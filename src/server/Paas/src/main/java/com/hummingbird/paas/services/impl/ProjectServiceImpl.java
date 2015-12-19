package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.commonbiz.util.NoGenerationUtil;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.ProjectInfo;
import com.hummingbird.paas.entity.ProjectPaymentDefine;
import com.hummingbird.paas.entity.ProjectPaymentDefineDetail;
import com.hummingbird.paas.entity.ProjectPaymentDefineDetailAndPay;
import com.hummingbird.paas.entity.ProjectPaymentPay;
import com.hummingbird.paas.entity.ProjectPaymentReceive;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.ProjectInfoMapper;
import com.hummingbird.paas.mapper.ProjectPaymentDefineDetailMapper;
import com.hummingbird.paas.mapper.ProjectPaymentDefineMapper;
import com.hummingbird.paas.mapper.ProjectPaymentPayMapper;
import com.hummingbird.paas.mapper.ProjectPaymentReceiveMapper;
import com.hummingbird.paas.mapper.ProjectPaymentRecordMapper;
import com.hummingbird.paas.services.ProjectService;
import com.hummingbird.paas.util.FundNameUtil;
import com.hummingbird.paas.vo.MyIncomeOverallReturnVO;
import com.hummingbird.paas.vo.MyObjectPaymentBodyVO;
import com.hummingbird.paas.vo.MyPaymentOverallReturnVO;
import com.hummingbird.paas.vo.PaidAmountDetailReturnVO;
import com.hummingbird.paas.vo.QueryMyIncomeListReturnVO;
import com.hummingbird.paas.vo.QueryMyPaymentListReturnVO;
import com.hummingbird.paas.vo.WillPayAmountDetailReturnVO;
@Service
public class ProjectServiceImpl implements ProjectService{
	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());
	
	@Autowired
	ProjectInfoMapper projectDao;
	@Autowired
	ProjectPaymentRecordMapper proRecordDao;
	@Autowired
	BidObjectMapper objectDao;
	@Autowired
	ProjectPaymentDefineMapper payDefDao;
	@Autowired
	ProjectPaymentDefineDetailMapper payDefineDao;
	@Autowired
	ProjectPaymentPayMapper payRecordDao;
	@Autowired
	ProjectPaymentReceiveMapper receiveRecordDao;
	
	/**
	 * 查询我的招标项目付款列表
	 * @see com.hummingbird.paas.services.ProjectService#queryMyPaymentList(java.lang.Integer, com.hummingbird.common.face.Pagingnation)
	 */
	@Override
	public List<QueryMyPaymentListReturnVO> queryMyPaymentList(Integer biddeeId,Pagingnation pagingnation) throws MaAccountException{
		if(pagingnation!=null&&pagingnation.isCountsize())
		{
			int count=projectDao.queryBeeProjectCount(biddeeId);
			pagingnation.setTotalCount(count);
			pagingnation.calculatePageCount();
		}
		List<ProjectInfo> projects=projectDao.queryBeeProject(biddeeId,pagingnation);
		List<QueryMyPaymentListReturnVO> list=new ArrayList<QueryMyPaymentListReturnVO>();
		for(ProjectInfo project:projects){
			
			List<ProjectPaymentDefineDetailAndPay> selectPayDefineByObjectId = payDefineDao.selectPayDefineByObjectId(project.getObjectId());
			Long projectamount = 0L;
			Long hadpayamount = 0l;
			boolean hadsetnextperiod = false;
			ProjectPaymentDefineDetailAndPay shouldpay=null;
			for (Iterator iterator = selectPayDefineByObjectId.iterator(); iterator.hasNext();) {
				ProjectPaymentDefineDetailAndPay defineandpay = (ProjectPaymentDefineDetailAndPay) iterator
						.next();
				projectamount+=defineandpay.getPaySum();
				if(shouldpay==null){
					shouldpay = defineandpay;
				}
				if(StringUtils.equals(defineandpay.getStatus(), CommonStatusConst.STATUS_OK)){
					hadpayamount += defineandpay.getPaySum();
					if(!hadsetnextperiod){//找到应该支付的期数
						hadsetnextperiod=true;
					}
				}
				else if(StringUtils.equals(defineandpay.getStatus(), "CFM")){
					//待平台确认
					shouldpay = defineandpay;
					hadsetnextperiod=true;
				}
				if(!hadsetnextperiod){//下一期应付的钱
					shouldpay = defineandpay;
				}
				
			}
			
			QueryMyPaymentListReturnVO query=new QueryMyPaymentListReturnVO();
			query.setObjectId(project.getObjectId());
			query.setObjectName(project.getProjectName());
			query.setPaidAmount(String.valueOf(hadpayamount));
//			Long willPayAmount=0l;
//			if(lastPayInfo!=null){
//				willPayAmount=lastPayInfo.getLeftAmount();
//			}else if(payDefine!=null){
//				
//				willPayAmount=objcet.getWinBidAmount();//-payDefine.getPaySum();
//			}
			query.setWillPayAmount(ObjectUtils.toString(projectamount));
			query.setWinBidAmount(ObjectUtils.toString(projectamount-hadpayamount));
			query.setNextPeriodPayAmount(ObjectUtils.toString(shouldpay.getPaySum()));
			query.setNextPeriodPayTime(DateUtil.formatCommonDateorNull(shouldpay.getPayStartTime()));
			query.setStatus(StringUtils.defaultIfEmpty(shouldpay.getStatus(),"NON"));
			list.add(query);
		}
		return list;
	}

	@Override
	public MyPaymentOverallReturnVO getMyPaymentOverall(Integer biddeeId)
			throws MaAccountException {
		MyPaymentOverallReturnVO overall=new MyPaymentOverallReturnVO();
		List<ProjectInfo> projects=projectDao.queryBeeProject(biddeeId,null);
		
		Long allAmount=0l;
		Long allPaidAmount=0l;
		Long allWillPayAmount=0l;
		Long allNextPeriodPayAmount=0l;
		for(ProjectInfo project:projects){
			BidObject objcet=objectDao.selectByPrimaryKey(project.getObjectId());
			if(objcet==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("根据标的记录号[%s]查询不到标的",project.getObjectId()));
				}
				throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据标的记录号[%s]查询不到标的",project.getObjectId()));
			
			}
			ProjectPaymentPay lastPayInfo=payRecordDao.getLastRecord(project.getObjectId());
			
			ProjectPaymentDefineDetail payDefine=payDefineDao.selectByObjectId(project.getObjectId(),(lastPayInfo==null?0:lastPayInfo.getCurrentPeriod())+1);
			if(payDefine==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("根据标的记录号[%s]查询不到标的付款设置信息",project.getObjectId()));
				}
				throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据标的记录号[%s]查询不到标的付款设置信息",project.getObjectId()));
			
			}
			
			Long paidAmount= proRecordDao.getPaidAmountByObjectId(project.getObjectId());
			allPaidAmount+=paidAmount;
			allAmount+=objcet.getWinBidAmount();
			allWillPayAmount+=lastPayInfo==null?payDefine.getPaySum():lastPayInfo.getLeftAmount();
			Long nextPeriodPayAmount=0l;
			if(payDefine!=null){
				
				nextPeriodPayAmount=payDefine.getPaySum();
			}
			allNextPeriodPayAmount+=nextPeriodPayAmount;
		}
		overall.setObjectNum(projects.size());
		overall.setAllAmount(ObjectUtils.toString(allAmount));
		overall.setNextPeriodPayAmount(ObjectUtils.toString(allNextPeriodPayAmount));
		overall.setPaidAmount(ObjectUtils.toString(allPaidAmount));
		overall.setWillPayAmount(ObjectUtils.toString(allWillPayAmount));
		return overall;
	}

	@Override
	public List<WillPayAmountDetailReturnVO> queryWillPayAmountDetail(
			String objectId) throws MaAccountException {
		List<WillPayAmountDetailReturnVO> list=new ArrayList<WillPayAmountDetailReturnVO>();
		ProjectPaymentPay lastPayInfo=payRecordDao.getLastRecord(objectId);
		List<ProjectPaymentDefineDetail> defines=payDefineDao.selectPayByObjectId(objectId, lastPayInfo==null?0:lastPayInfo.getCurrentPeriod());
		for(ProjectPaymentDefineDetail define:defines){
			WillPayAmountDetailReturnVO query=new WillPayAmountDetailReturnVO();
			query.setAmount(ObjectUtils.toString(define.getPaySum()));
			query.setEndDate(DateUtil.formatShortDateorNull(define.getPayEndTime()));
			query.setFundName("第"+FundNameUtil.outCh(define.getPeriod())+"期");
			query.setStartDate(DateUtil.formatShortDateorNull(define.getPayStartTime()));
			list.add(query);
		}
		return list;
	}

	@Override
	public List<PaidAmountDetailReturnVO> queryPaidAmountDetail(String objectId)
			throws MaAccountException {
		List<PaidAmountDetailReturnVO> list=new ArrayList<PaidAmountDetailReturnVO>();
		List<ProjectPaymentPay> payList=payRecordDao.queryPaidRecord(objectId);
		for(ProjectPaymentPay record: payList){
			PaidAmountDetailReturnVO query=new PaidAmountDetailReturnVO();
			query.setAmount(ObjectUtils.toString(record.getAmount()));
			query.setBankName(record.getBank());
			query.setFundName("第"+FundNameUtil.outCh(record.getCurrentPeriod())+"期");
			query.setTransferDate(DateUtil.formatCommonDateorNull(record.getTransferDate()));
			query.setVoucherNo(record.getVoucher());
			query.setPayStatus(record.getStatus());
			list.add(query);
		}
		return list;
	}

	@Override
	public List<QueryMyIncomeListReturnVO> queryMyIncomeList(Integer bidderId, Pagingnation pagingnation)
			throws MaAccountException {
		
		if(pagingnation!=null&&pagingnation.isCountsize()){
			int count = projectDao.selectBerProjectCount(bidderId);
			pagingnation.setTotalCount(count);
			pagingnation.calculatePageCount();
		}
		
		List<ProjectInfo> projects=projectDao.queryBerProject(bidderId,pagingnation);
		List<QueryMyIncomeListReturnVO> list=new ArrayList<QueryMyIncomeListReturnVO>();
		for(ProjectInfo project:projects){
			BidObject objcet=objectDao.selectByPrimaryKey(project.getObjectId());
			if(objcet==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("根据标的记录号[%s]查询不到标的",project.getObjectId()));
				}
				throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据标的记录号[%s]查询不到标的",project.getObjectId()));
			
			}
			ProjectPaymentReceive lastPayInfo=receiveRecordDao.getLastRecord(project.getObjectId());
			ProjectPaymentDefineDetail payDefine=payDefineDao.selectByObjectId(project.getObjectId(),(lastPayInfo==null?0:lastPayInfo.getCurrentPeriod())+1);
			
			Long paidAmount= proRecordDao.getReceivedAmountByObjectId(project.getObjectId());
			Long willReceiveAmount=0l;
			if(lastPayInfo!=null){
				willReceiveAmount=lastPayInfo.getLeftAmount();
			}else if(payDefine!=null){
				willReceiveAmount=objcet.getWinBidAmount()-payDefine.getPaySum();
			}else{
				willReceiveAmount=0l;
			}
			QueryMyIncomeListReturnVO query=new QueryMyIncomeListReturnVO();
			query.setObjectId(project.getObjectId());
			query.setObjectName(objcet.getObjectName());
			query.setReceivedAmount(paidAmount.toString());
			query.setWillReceiveAmount(ObjectUtils.toString(willReceiveAmount));
			query.setWinBidAmount(ObjectUtils.toString(objcet.getWinBidAmount()));
			if(payDefine==null){
				query.setNextPeriodReceiveAmount("0");
				query.setNextPeriodReceiveTime(null);
			}else{
				query.setNextPeriodReceiveAmount(ObjectUtils.toString(payDefine.getPaySum()));
				query.setNextPeriodReceiveTime(DateUtil.formatShortDateorNull(payDefine.getPayStartTime()));
			}
			list.add(query);
		}
		return list;
	}

	@Override
	public MyIncomeOverallReturnVO getMyIncomeOverall(Integer bidderId)
			throws MaAccountException {
		MyIncomeOverallReturnVO overall=new MyIncomeOverallReturnVO();
		List<ProjectInfo> projects=projectDao.queryBerProject(bidderId,null);
		
		Long allAmount=0l;
		Long allPaidAmount=0l;
		Long allWillPayAmount=0l;
		Long allNextPeriodPayAmount=0l;
		for(ProjectInfo project:projects){
			BidObject objcet=objectDao.selectByPrimaryKey(project.getObjectId());
			if(objcet==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("根据标的记录号[%s]查询不到标的",project.getObjectId()));
				}
				throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据标的记录号[%s]查询不到标的",project.getObjectId()));
			
			}
			ProjectPaymentReceive lastReceivedInfo=receiveRecordDao.getLastRecord(project.getObjectId());
			ProjectPaymentDefineDetail payDefine=payDefineDao.selectByObjectId(project.getObjectId(),(lastReceivedInfo==null?0:lastReceivedInfo.getCurrentPeriod())+1);
			
			Long paidAmount= proRecordDao.getPaidAmountByObjectId(project.getObjectId());
			allPaidAmount+=paidAmount;
			allAmount+=objcet.getWinBidAmount();
			allWillPayAmount+=lastReceivedInfo==null?objcet.getObjectAmount():lastReceivedInfo.getLeftAmount();
			Long nextPeriodPayAmount=0l;
			if(payDefine!=null){
				
				nextPeriodPayAmount=payDefine.getPaySum();
			}
			allNextPeriodPayAmount+=nextPeriodPayAmount;
		}
		overall.setObjectNum(projects.size());
		overall.setAllAmount(ObjectUtils.toString(allAmount));
		overall.setNextPeriodReceiveAmount(ObjectUtils.toString(allNextPeriodPayAmount));
		overall.setReceivedAmount(ObjectUtils.toString(allPaidAmount));
		overall.setWillReceiveAmount(ObjectUtils.toString(allWillPayAmount));
		return overall;
	}

	@Override
	public List<WillPayAmountDetailReturnVO> queryWillReceiveAmountDetail(
			String objectId) throws MaAccountException {
		List<WillPayAmountDetailReturnVO> list=new ArrayList<WillPayAmountDetailReturnVO>();
		ProjectPaymentReceive lastReceiveInfo=receiveRecordDao.getLastRecord(objectId);
		List<ProjectPaymentDefineDetail> defines=payDefineDao.selectPayByObjectId(objectId, lastReceiveInfo==null?0:lastReceiveInfo.getCurrentPeriod());
		for(ProjectPaymentDefineDetail define:defines){
			WillPayAmountDetailReturnVO query=new WillPayAmountDetailReturnVO();
			query.setAmount(ObjectUtils.toString(define.getPaySum()));
			query.setEndDate(DateUtil.formatShortDateorNull(define.getPayEndTime()));
			query.setFundName("第"+FundNameUtil.outCh(define.getPeriod())+"期");
			query.setStartDate(DateUtil.formatShortDateorNull(define.getPayStartTime()));
			list.add(query);
		}
		return list;
	}

	@Override
	public List<PaidAmountDetailReturnVO> queryReceivedAmountDetail(
			String objectId) throws MaAccountException {
		List<PaidAmountDetailReturnVO> list=new ArrayList<PaidAmountDetailReturnVO>();
		List<ProjectPaymentReceive> receivedList=receiveRecordDao.queryReceivedRecord(objectId);
		for(ProjectPaymentReceive record: receivedList){
			ProjectPaymentPay payInfo=payRecordDao.getRecordByPeriod(objectId,record.getCurrentPeriod());
			if(payInfo==null){
				if (log.isDebugEnabled()) {
					log.debug(String.format("查询第【%d】期项目【%s】付款记录信息失败",record.getCurrentPeriod(),objectId));
				}
				throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("查询第【%d】期项目【%s】付款记录信息失败",record.getCurrentPeriod(),objectId));
			
			}
			PaidAmountDetailReturnVO query=new PaidAmountDetailReturnVO();
			query.setAmount(ObjectUtils.toString(record.getAmount()));
			query.setBankName(payInfo.getBank());
			query.setFundName("第"+FundNameUtil.outCh(record.getCurrentPeriod())+"期");
			query.setTransferDate(DateUtil.formatCommonDateorNull(payInfo.getTransferDate()));
			query.setVoucherNo(payInfo.getVoucher());
			list.add(query);
		}
		return list;
	}

	/**
	 * 招标人付款
	 * @see com.hummingbird.paas.services.ProjectService#paymentProject(com.hummingbird.paas.vo.MyObjectPaymentBodyVO)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public void paymentProject(MyObjectPaymentBodyVO body)
			throws MaAccountException {
		//查询付款到哪一期了
		String objectId=body.getObjectId();
		BidObject object=objectDao.selectByPrimaryKey(objectId);
		if(object==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据标的记录号[%s]查询不到标的",objectId));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据标的记录号[%s]查询不到标的",objectId));
		
		}
		List<ProjectInfo> selectByObjectId = projectDao.selectByObjectId(objectId);
		if(selectByObjectId==null||selectByObjectId.isEmpty()){
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据标的Id[%s]查询不到工程",objectId));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据标的Id[%s]查询不到工程",objectId));
			
		}
		ProjectInfo projectInfo=selectByObjectId.get(0);
		if(projectInfo==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据标的Id[%s]查询不到工程",objectId));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据标的Id[%s]查询不到工程",objectId));
		
		}
		ProjectPaymentPay lastPayInfo=payRecordDao.getLastRecord(objectId);
		ProjectPaymentDefine define=payDefDao.selectByObjectId(objectId);
		int currentperiod =  lastPayInfo==null?1:(StringUtils.equals(lastPayInfo.getStatus(),CommonStatusConst.STATUS_FAIL)?lastPayInfo.getCurrentPeriod():(lastPayInfo.getCurrentPeriod()+1));
		ProjectPaymentDefineDetail defines=payDefineDao.selectNextPayByObjectId(objectId,currentperiod);
		if(define==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("项目【%s】查询付款定义失败",objectId));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("项目【%s】查询付款定义失败",objectId));
		
		}
		if(defines==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("项目【%s】付款已结束",objectId));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("项目【%s】付款已结束",objectId));
		
		}
		
		//插入付款记录
		ProjectPaymentPay record=new ProjectPaymentPay();
		record.setAmount(body.getAmount());
		record.setBank(body.getBankName());
		record.setCurrentPeriod(defines.getPeriod());
		Long leftAmount=0l;
		if(lastPayInfo==null){
			leftAmount=object.getWinBidAmount()==null?0:(object.getWinBidAmount()-body.getAmount());
		}else{
			//如果付款失败,则按原来的期数再次发起付款
			if(StringUtils.equals(lastPayInfo.getStatus(),CommonStatusConst.STATUS_FAIL)){
				leftAmount = lastPayInfo.getLeftAmount();
			}
			else{
				
				leftAmount=lastPayInfo.getLeftAmount()-body.getAmount();
			}
		}
		record.setLeftAmount(leftAmount);
		int leftPeriod=define.getPayPeriod()-currentperiod;
//		if(lastPayInfo==null){
//			leftPeriod=define.getPayPeriod()-1;
//		}else{
//			leftPeriod=lastPayInfo.getLeftPeriod()-1;
//		}
		record.setLeftPeriod(leftPeriod);
		record.setPayTime(new Date());
		record.setProjectId(projectInfo.getProjectId());
		record.setShouldPayTime(defines.getPayEndTime());
		record.setStatus("CRT");
		record.setTotalAmount(object.getWinBidAmount()==null?0:object.getWinBidAmount());
		record.setTotalPeriod(define.getPayPeriod());
		record.setTransferDate(body.getTransferTime());
		record.setVoucher(body.getVoucherNo());
		record.setVoucherPic(body.getVoucherFileUrl());
		record.setOrderId(NoGenerationUtil.genNO("PP",6));
		payRecordDao.insert(record);
	}
}
