package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.Project;
import com.hummingbird.paas.entity.ProjectInfo;
import com.hummingbird.paas.entity.ProjectPaymentDefine;
import com.hummingbird.paas.entity.ProjectPaymentDefineDetail;
import com.hummingbird.paas.entity.ProjectPaymentPay;
import com.hummingbird.paas.entity.ProjectPaymentReceive;
import com.hummingbird.paas.entity.ProjectPaymentRecord;
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
	ProjectPaymentDefineDetailMapper payDefineDao;
	@Autowired
	ProjectPaymentPayMapper payRecordDao;
	@Autowired
	ProjectPaymentReceiveMapper receiveRecordDao;
	
	@Override
	public List<QueryMyPaymentListReturnVO> queryMyPaymentList(Integer biddeeId) throws MaAccountException{
		// TODO Auto-generated method stub
		List<ProjectInfo> projects=projectDao.queryBeeProject(biddeeId);
		List<QueryMyPaymentListReturnVO> list=new ArrayList<QueryMyPaymentListReturnVO>();
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
			Integer paidAmount= proRecordDao.getPaidAmountByObjectId(project.getObjectId());
			
			QueryMyPaymentListReturnVO query=new QueryMyPaymentListReturnVO();
			query.setObjectId(project.getObjectId());
			query.setObjectName(objcet.getObjectName());
			query.setPaidAmount(paidAmount.toString());
			Integer willPayAmount=0;
			if(lastPayInfo!=null){
				willPayAmount=lastPayInfo.getLeftAmount()/100;
			}else if(payDefine!=null){
				//应该是objcet.getWinBidAmount()-payDefine.getPaySum()，但是数据库不对
				willPayAmount=payDefine.getPaySum()/100;
			}else{
				willPayAmount=0;
			}
			query.setWillPayAmount(willPayAmount.toString());
			query.setWinBidAmount(objcet.getWinBidAmount());
			if(payDefine==null){
				query.setNextPeriodPayAmount("0");
				query.setNextPeriodPayTime(null);
			}else{
				query.setNextPeriodPayAmount(payDefine.getPaySum().toString());
				query.setNextPeriodPayTime(payDefine.getPayStartTime().toString());
			}
			
			list.add(query);
		}
		return list;
	}

	@Override
	public MyPaymentOverallReturnVO getMyPaymentOverall(Integer biddeeId)
			throws MaAccountException {
		MyPaymentOverallReturnVO overall=new MyPaymentOverallReturnVO();
		List<ProjectInfo> projects=projectDao.queryBeeProject(biddeeId);
		
		Integer allAmount=0;
		Integer allPaidAmount=0;
		Integer allWillPayAmount=0;
		Integer allNextPeriodPayAmount=0;
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
			
			Integer paidAmount= proRecordDao.getPaidAmountByObjectId(project.getObjectId());
			allPaidAmount+=paidAmount;
			allAmount+=objcet.getObjectAmount();
			allWillPayAmount+=lastPayInfo==null?payDefine.getPaySum():lastPayInfo.getLeftAmount();
			Integer nextPeriodPayAmount=0;
			if(payDefine!=null){
				
				nextPeriodPayAmount=payDefine.getPaySum();
			}
			allNextPeriodPayAmount+=nextPeriodPayAmount;
		}
		overall.setObjectNum(projects.size());
		overall.setAllAmount(allAmount.toString());
		overall.setNextPeriodPayAmount(allNextPeriodPayAmount.toString());
		overall.setPaidAmount(allPaidAmount.toString());
		overall.setWillPayAmount(allWillPayAmount.toString());
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
			query.setAmount(define.getPaySum().toString());
			query.setEndDate(define.getPayEndTime().toString());
			query.setFundName("第"+FundNameUtil.outCh(define.getPeriod())+"期");
			query.setStartDate(define.getPayStartTime().toString());
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
			query.setAmount(record.getAmount().toString());
			query.setBankName(record.getBank());
			query.setFundName("第"+FundNameUtil.outCh(record.getCurrentPeriod())+"期");
			query.setTransferDate(record.getTransferDate().toString());
			query.setVoucherNo(record.getVoucher());
			list.add(query);
		}
		return list;
	}

	@Override
	public List<QueryMyIncomeListReturnVO> queryMyIncomeList(Integer bidderId)
			throws MaAccountException {
		List<ProjectInfo> projects=projectDao.queryBerProject(bidderId);
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
			
			Integer paidAmount= proRecordDao.getReceivedAmountByObjectId(project.getObjectId());
			Integer willReceiveAmount=0;
			if(lastPayInfo!=null){
				willReceiveAmount=lastPayInfo.getLeftAmount()/100;
			}else if(payDefine!=null){
				//应该是objcet.getWinBidAmount()-payDefine.getPaySum()，但是数据库不对
				willReceiveAmount=payDefine.getPaySum()/100;
			}else{
				willReceiveAmount=0;
			}
			QueryMyIncomeListReturnVO query=new QueryMyIncomeListReturnVO();
			query.setObjectId(project.getObjectId());
			query.setObjectName(objcet.getObjectName());
			query.setReceivedAmount(paidAmount.toString());
			query.setWillReceiveAmount(willReceiveAmount.toString());
			query.setWinBidAmount(objcet.getWinBidAmount());
			if(payDefine==null){
				query.setNextPeriodReceiveAmount("0");
				query.setNextPeriodReceiveTime(null);
			}else{
				query.setNextPeriodReceiveAmount(payDefine.getPaySum().toString());
				query.setNextPeriodReceiveTime(payDefine.getPayStartTime().toString());
			}
			list.add(query);
		}
		return list;
	}

	@Override
	public MyIncomeOverallReturnVO getMyIncomeOverall(Integer bidderId)
			throws MaAccountException {
		MyIncomeOverallReturnVO overall=new MyIncomeOverallReturnVO();
		List<ProjectInfo> projects=projectDao.queryBerProject(bidderId);
		
		Integer allAmount=0;
		Integer allPaidAmount=0;
		Integer allWillPayAmount=0;
		Integer allNextPeriodPayAmount=0;
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
			
			Integer paidAmount= proRecordDao.getPaidAmountByObjectId(project.getObjectId());
			allPaidAmount+=paidAmount;
			allAmount+=objcet.getObjectAmount();//??标的金额是否为项目金额,这里应该是winAmount，但是数据库字段有问题
			allWillPayAmount+=lastReceivedInfo==null?objcet.getObjectAmount():lastReceivedInfo.getLeftAmount();
			Integer nextPeriodPayAmount=0;
			if(payDefine!=null){
				
				nextPeriodPayAmount=payDefine.getPaySum();
			}
			allNextPeriodPayAmount+=nextPeriodPayAmount;
		}
		overall.setObjectNum(projects.size());
		overall.setAllAmount(allAmount.toString());
		overall.setNextPeriodReceiveAmount(allNextPeriodPayAmount.toString());
		overall.setReceivedAmount(allPaidAmount.toString());
		overall.setWillReceiveAmount(allWillPayAmount.toString());
		return overall;
	}

	@Override
	public List<WillPayAmountDetailReturnVO> queryWillReceiveAmountDetail(
			String objectId) throws MaAccountException {
		List<WillPayAmountDetailReturnVO> list=new ArrayList<WillPayAmountDetailReturnVO>();
		ProjectPaymentReceive lastReceiveInfo=receiveRecordDao.getLastRecord(objectId);
		List<ProjectPaymentDefineDetail> defines=payDefineDao.selectPayByObjectId(objectId, lastReceiveInfo.getCurrentPeriod());
		for(ProjectPaymentDefineDetail define:defines){
			WillPayAmountDetailReturnVO query=new WillPayAmountDetailReturnVO();
			query.setAmount(define.getPaySum().toString());
			query.setEndDate(define.getPayEndTime().toString());
			query.setFundName("第"+FundNameUtil.outCh(define.getPeriod())+"期");
			query.setStartDate(define.getPayStartTime().toString());
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
			query.setAmount(record.getAmount().toString());
			query.setBankName(payInfo.getBank());
			query.setFundName("第"+FundNameUtil.outCh(record.getCurrentPeriod())+"期");
			query.setTransferDate(payInfo.getTransferDate().toString());
			query.setVoucherNo(payInfo.getVoucher());
			list.add(query);
		}
		return list;
	}

}
