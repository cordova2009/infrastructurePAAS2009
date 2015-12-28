package com.hummingbird.paas.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.RequestException;
import com.hummingbird.common.exception.SignatureException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.util.http.HttpRequester;
import com.hummingbird.commonbiz.util.TransOrderBuilder;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.ProjectInfo;
import com.hummingbird.paas.entity.ProjectPaymentPay;
import com.hummingbird.paas.entity.ProjectPaymentReceive;
import com.hummingbird.paas.event.BidSelectedEvent;
import com.hummingbird.paas.event.ConfirmPayEvent;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.ProjectInfoMapper;
import com.hummingbird.paas.mapper.ProjectPaymentPayMapper;
import com.hummingbird.paas.mapper.ProjectPaymentReceiveMapper;
import com.hummingbird.paas.services.ProjectPaymentService;
import com.hummingbird.paas.vo.ProjectPaymentConfirmBodyVO;
import com.hummingbird.paas.vo.QueryProjectAccountReturnVO;
import com.hummingbird.paas.vo.QueryProjectAccountVO;

/**
 * @author 
 * @date 2015-12-13
 * @version 1.0
 *  service接口实现
 */
@Service
public class ProjectPaymentServiceImpl  implements ProjectPaymentService{

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	
	@Autowired
	ProjectPaymentPayMapper paydao;
	@Autowired
	ProjectPaymentReceiveMapper receivedao;
	@Autowired
	ProjectInfoMapper projectdao;
	@Autowired
	BidObjectMapper objDao;
	@Autowired
	BiddeeMapper biddeedao;
	@Autowired
	BidderMapper bidderdao;

	/**
	 * 确认工程付款
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	 @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public void confirmPayment(String appId,ProjectPaymentConfirmBodyVO body) throws BusinessException{
		if(log.isDebugEnabled()){
			log.debug("确认工程付款开始");
		}
		
		ValidateUtil.assertNullnoappend(body.getOrderId(), "工程付款订单号不存在");
		ProjectPaymentPay pp = paydao.selectByOrderId(body.getOrderId());
		ValidateUtil.assertNullnoappend(pp, "工程付款记录不存在");
		ValidateUtil.assertNotEqual(pp.getStatus(), "CRT", "工程付款已处理,无法再处理");
		
		String confirmStatus = body.getConfirmStatus();
		if(StringUtils.equals(CommonStatusConst.STATUS_OK, confirmStatus)){
			//成功
			pp.setStatus(CommonStatusConst.STATUS_OK);
			pp.setPayTime(new Date());
			paydao.updateByPrimaryKey(pp);
			//转帐到投标人
			transPayment2Bidder(pp);
			//如果是最后一期,且付款成功,则项目结束
			if(pp.getLeftPeriod()==0){
				String projectId = pp.getProjectId();
				ProjectInfo projectInfo = projectdao.selectByPrimaryKey(projectId);
				projectInfo.setEndTime(new Date());
				projectInfo.setStatus("END");
				projectdao.updateByPrimaryKey(projectInfo);
				BidObject bidObject = objDao.selectByPrimaryKey(projectInfo.getObjectId());
				bidObject.setUpdateTime(new Date());
				bidObject.setObjectStatus("END");
				objDao.updateByPrimaryKey(bidObject);
				
			}
		}
		else{
			//失败
			pp.setStatus(CommonStatusConst.STATUS_FAIL);
			pp.setPayTime(new Date());
			paydao.updateByPrimaryKey(pp);
		}
		
		//资金帐户收款
//		receivenPayment2platform(pp);
		//add 付款通知   2015年12月20日
		ProjectInfo projectInfo = projectdao.selectByPrimaryKey(pp.getProjectId());
		Integer biddeeId = projectInfo.getBiddeeId();
		Integer bidderId = projectInfo.getBidderId();
		Biddee biddee = biddeedao.selectByPrimaryKey(biddeeId);
		Bidder bidder = bidderdao.selectByPrimaryKey(bidderId);
		if(biddee != null && bidder != null){
			ConfirmPayEvent pay = new ConfirmPayEvent(pp.getProjectId(),biddee.getUserId(),bidder.getUserId());
			EventListenerContainer.getInstance().fireEvent(pay);
		}
		
		if(log.isDebugEnabled()){
			log.debug("确认工程付款完成");
		}
	}

	/**
	 * @param pp
	 * @throws MaAccountException 
	 * @throws SignatureException 
	 * @throws DataInvalidException 
	 * @throws RequestException 
	 */
	private void receivenPayment2bidder(ProjectPaymentReceive pp) throws MaAccountException, DataInvalidException, SignatureException, RequestException {
		PropertiesUtil pu=new PropertiesUtil();
		Map capbody = new HashMap();
		capbody.put("amount", pp.getAmount());
		capbody.put("appOrderId", pp.getOrderId());
		
		ProjectInfo projectInfo = projectdao.selectByPrimaryKey(pp.getProjectId());
		Integer bidderId = projectInfo.getBidderId();
		Bidder bidder = bidderdao.selectByPrimaryKey(bidderId);
		
		capbody.put("userId", bidder.getUserId());
		
		BaseTransVO<Map> buildBaseTrans = TransOrderBuilder.buildBaseTrans("paas", pu.getProperty("appkey"), capbody, false, false);
		String requestJson = JsonUtil.convert2Json(buildBaseTrans);
		String paygatewayUrl = String.format("%s/capitalManage/userProjectPaymentAccountIncome",pu.getProperty("capital.url"));
		log.debug(String.format("开始调用资金账户用户工程款收入接口，地址是：%s", paygatewayUrl));
		String result2 = new HttpRequester().postRequest(paygatewayUrl,
				requestJson);
		if(result2==null){
			throw ValidateException.ERROR_REQUEST_INVALID;
		}
		QueryProjectAccountVO proAccount=JsonUtil.convertJson2Obj(result2, QueryProjectAccountVO.class);
		
		QueryProjectAccountReturnVO returnBody=proAccount.getAccount();
		boolean mapsuccess = "0".equals(ObjectUtils.toString(proAccount.getErrcode()));
		if(!mapsuccess){
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户收入失败"));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,proAccount.getErrmsg());
			
		}
		
	}

	/**
	 * @param pp
	 * @throws DataInvalidException 
	 * @throws RequestException 
	 * @throws MaAccountException 
	 * @throws SignatureException 
	 */
	 @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	private void transPayment2Bidder(ProjectPaymentPay pp) throws DataInvalidException, SignatureException, MaAccountException, RequestException {
		String orderId = pp.getOrderId();
		ValidateUtil.assertNullnoappend(orderId, "工程收款订单号不存在");
		ProjectPaymentReceive ppr = receivedao.selectByOrderId(orderId);
		if(ppr!=null){
			ValidateUtil.assertNotEqual(ppr.getStatus(), "CRT", "工程收款已处理,无法再处理");
			ppr.setStatus(CommonStatusConst.STATUS_OK);
			ppr.setReceiveTime(new Date());
			receivedao.updateByPrimaryKey(ppr);
		}
		else{
			ppr = new ProjectPaymentReceive();
			ppr.setOrderId(orderId);
			ppr.setAmount(pp.getAmount());
			ppr.setCurrentPeriod(pp.getCurrentPeriod());
			ppr.setLeftAmount(pp.getLeftAmount());
			ppr.setLeftPeriod(pp.getLeftPeriod());
			ppr.setProjectId(pp.getProjectId());
			ppr.setReceiveTime(new Date());
			ppr.setShouldReceiveTime(pp.getShouldPayTime());
			ppr.setTotalAmount(pp.getTotalAmount());
			ppr.setTotalPeriod(pp.getTotalPeriod());
			ppr.setStatus(CommonStatusConst.STATUS_OK);
			receivedao.insert(ppr);
		}
		//招标人资金帐户收款
		receivenPayment2bidder(ppr);
		//平台方资金帐户付款
	}
		
		
		
}