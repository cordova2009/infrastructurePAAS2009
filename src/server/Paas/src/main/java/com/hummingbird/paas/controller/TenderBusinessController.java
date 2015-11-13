package com.hummingbird.paas.controller;
/**
 * @author YJY 
 * @since 2015年11月11日22:02:25
 * 招标服务接口
 * */

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.jce.provider.JCEMac.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.util.CollectionTools;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.BaseTransVO;

import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.BiddeeBankAduit;
import com.hummingbird.paas.entity.BiddeeCerticate;
import com.hummingbird.paas.entity.BiddeeCertificateAduit;
import com.hummingbird.paas.entity.BiddeeCredit;
import com.hummingbird.paas.entity.InstationNotification;
import com.hummingbird.paas.entity.ProjectPaymentDefine;
import com.hummingbird.paas.entity.ProjectPaymentDefineDetail;
import com.hummingbird.paas.entity.ScoreLevel;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.mapper.BiddeeBankAduitMapper;
import com.hummingbird.paas.mapper.BiddeeBidCreditScoreMapper;
import com.hummingbird.paas.mapper.BiddeeCerticateMapper;
import com.hummingbird.paas.mapper.BiddeeCertificateAduitMapper;
import com.hummingbird.paas.mapper.BiddeeCreditMapper;
import com.hummingbird.paas.mapper.ProjectPaymentDefineDetailMapper;
import com.hummingbird.paas.mapper.ProjectPaymentDefineMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.services.MyBiddeeService;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.BiddeeAuthInfo;
import com.hummingbird.paas.vo.BiddeeBankInfo;
import com.hummingbird.paas.vo.BiddeeBaseInfo;
import com.hummingbird.paas.vo.BiddeeCerticateSaveInfoVO;
import com.hummingbird.paas.vo.BiddeeLegalPerson;
import com.hummingbird.paas.vo.BiddeeRegisteredInfo;
import com.hummingbird.paas.vo.BidderBaseInfo;
import com.hummingbird.paas.vo.MyBiddeeAuthInfoApplyVO;
import com.hummingbird.paas.vo.MyBiddeeAuthInfoBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.SmsListBodyVO;
import com.hummingbird.paas.vo.TenderBidEvaluationBodyVO;
import com.hummingbird.paas.vo.TenderMyObjectBidReturnVO;
import com.hummingbird.paas.vo.TenderPaymentDetailInfo;
import com.hummingbird.paas.vo.TenderPaymentInfo;
import com.hummingbird.paas.vo.TenderSurveyBodyVO;
import com.hummingbird.paas.vo.TenderSurveyReturnVO;
@Controller
@RequestMapping(value="/tender"
		 ,method=RequestMethod.POST)
public class TenderBusinessController extends BaseController  {
	@Autowired
	protected MyBiddeeService myBiddeeService;

	@Autowired
	protected BidObjectMapper bidObjectDao;
	@Autowired
	protected BidRecordMapper bidRecordDao;
	@Autowired
	protected ProjectPaymentDefineMapper projectPaymentDefineDao;
	@Autowired
	protected ProjectPaymentDefineDetailMapper projectPaymentDefineDetailDao;
	@Autowired
	TokenService tokenSrv;
	@Autowired
	TenderService  tenderService;

	@Autowired(required = true)
	protected AppLogMapper applogDao;
	
	
	/**
	 * 我的招标评标概况接口
	 * @author YJY
	 * @since 2015年11月12日16:07:24
	 * @return
	 */
	@RequestMapping(value="/queryMyObjectTenderSurvey",method=RequestMethod.POST)
	@AccessRequered(methodName = "我的招标评标概况")
	// 框架的日志处理
	public @ResponseBody ResultModel queryMyObjectTenderSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "我的招标评标概况";
		int basecode = 0;
		BaseTransVO<TenderSurveyBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,TenderSurveyBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryMyObjectTenderSurvey");
		
		try {
				TenderSurveyReturnVO tsr = bidRecordDao.selectByObjectId(transorder.getBody().getObjectId());
			
			
				if(tsr!= null){
					rm.put("survey", tsr);
					
				}
			
			
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	
	/**
	 * 定标接口
	 * @author YJY
	 * @since 2015年11月12日12:07:10
	 * @return
	 */
	@RequestMapping(value="/bidEvaluation",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel bidEvaluation(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "定标";
		BaseTransVO<TenderBidEvaluationBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, TenderBidEvaluationBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "参数异常"));
			return rm;
		}
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/bidEvaluation");
		
		
		try {
		String token =  transorder.getBody().getToken();
		String objectId =  transorder.getBody().getObjectId();
		Integer bidder_id = transorder.getBody().getWinBidId();

		int i= 0;
		if(StringUtils.isNotBlank(token)){
			BidObject  bid =bidObjectDao.selectByPrimaryKey(objectId);
			
			BidRecord bidr = bidRecordDao.selectByObjectIdAndBidderId(objectId, bidder_id);
			ProjectPaymentDefine ppd = new ProjectPaymentDefine();
			ProjectPaymentDefineDetail ppf = new ProjectPaymentDefineDetail();
			TenderPaymentInfo tp = transorder.getBody().getPaymentInfo();
			List<TenderPaymentDetailInfo> tpds= tp.getPayList();
			if(bid==null){
				rm.setErrmsg("未找到相应记录!");
				return rm;
				}else{
					//1.保存到招标表
					bid.setObjectStatus("SEL");;//修改状态为定标
					bid.setWinBidderId(transorder.getBody().getWinBidId());
					bid.setWinBidAmount(ObjectUtils.toString(bidr.getBidAmount()));
					i = bidObjectDao.updateByPrimaryKeySelective(bid);
					//2.保存到工程付款表
					UUID uid = UUID.randomUUID();
					Integer pid = uid.hashCode();
					ppd.setId(pid);
					ppd.setObjectId(objectId);
					ppd.setPayPeriod(tp.getPayPeriod());
					ppd.setPayType(tp.getPayType());
					projectPaymentDefineDao.insert(ppd); 
					for(TenderPaymentDetailInfo mm : tpds){
						ppf.setPaySum(mm.getPaySum());
						ppf.setPayTime(mm.getPayDate());
						ppf.setPeriod(mm.getPeriod());
						ppf.setProjectPaymentDefineId(pid);
						projectPaymentDefineDetailDao.insert(ppf);
					}
					
					
				}
			}
	
		
		if(i<= 0){
			rm.setErrmsg("数据未修改！");
		}else{
			rm.setErrmsg(messagebase + "成功");
		}
//		activityService.JoinActivity(activityId,unionId,parentName,mobileNum,babyName,babySex,babyBirthday,city,district);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg(e1.getMessage());
		}
		return rm;
	}  
	
	/**
	 * 我的招标项目投标列表接口
	 * @author YJY
	 * @since 2015年11月12日16:44:56
	 * @return
	 */
	@RequestMapping(value="/queryMyObjectBidList",method=RequestMethod.POST)
	@AccessRequered(methodName = "我的招标项目投标列表")
	public @ResponseBody ResultModel queryMyObjectBidList(HttpServletRequest request,HttpServletResponse response) {
		int basecode = 2341200;//待定
		String messagebase = "查询我的招标项目投标列表";
		BaseTransVO<TenderSurveyBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, TenderSurveyBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "参数异常"));
			return rm;
		}
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/tender/queryMyObjectBidList");
		
		List<TenderMyObjectBidReturnVO> list=new ArrayList<TenderMyObjectBidReturnVO>();
		try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				throw new TokenException("token验证失败,或已过期,请重新登录");
			}
			com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
			
			list = tenderService.selectByObjectIdInValid(token.getUserId(),transorder.getBody().getObjectId(),page);
			List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<TenderMyObjectBidReturnVO, Map>() {

				@Override
				public Map convert(TenderMyObjectBidReturnVO ori) {
					
					try {
						Map row= BeanUtils.describe(ori);
						row.put("bidTime", DateUtil.formatCommonDateorNull(ori.getBidTime()));
						row.put("projectExpectStartDate", DateUtil.formatCommonDateorNull(ori.getProjectExpectStartDate()));
						
						row.remove("class");
						return row;
						
					} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
						log.error(String.format("转换为map对象出错"),e);
						return null;
					}
				}
			});
			mergeListOutput(rm, page, nos);
			
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
	}  
	
	
	
	
}
