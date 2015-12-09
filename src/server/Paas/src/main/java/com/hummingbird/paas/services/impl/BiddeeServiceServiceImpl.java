package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.BiddeeCredit;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.CertificationRequirement;
import com.hummingbird.paas.entity.ObjectBaseinfo;
import com.hummingbird.paas.entity.ObjectProject;
import com.hummingbird.paas.entity.ProjectInfos;
import com.hummingbird.paas.entity.Qanda;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.mapper.BiddeeCreditMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.CertificationRequirementMapper;
import com.hummingbird.paas.mapper.ObjectBaseinfoMapper;
import com.hummingbird.paas.mapper.ObjectMapper;
import com.hummingbird.paas.mapper.ObjectProjectMapper;
import com.hummingbird.paas.mapper.ProjectInfosMapper;
import com.hummingbird.paas.mapper.QandaMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.services.BiddeeServiceService;
import com.hummingbird.paas.vo.DetailVO;
import com.hummingbird.paas.vo.MyBuildingObjectProject;
import com.hummingbird.paas.vo.MyEndedObjectProject;
import com.hummingbird.paas.vo.MyLoseObjectProject;
import com.hummingbird.paas.vo.QueryMyBidObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyBuildingObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyEndedObjectListResultVO;
import com.hummingbird.paas.vo.QueryMyLoseObjectListResultVO;
import com.hummingbird.paas.vo.QueryObjectDetailAnswerQuestion;
import com.hummingbird.paas.vo.QueryObjectDetailBaseVO;
import com.hummingbird.paas.vo.QueryObjectDetailBidEvaluationTypeInfo;
import com.hummingbird.paas.vo.QueryObjectDetailBidFilTypeInfo;
import com.hummingbird.paas.vo.QueryObjectDetailBidderBidderCertification;
import com.hummingbird.paas.vo.QueryObjectDetailBidderCertificationInfo;
import com.hummingbird.paas.vo.QueryObjectDetailBodyVO;
import com.hummingbird.paas.vo.QueryObjectDetailBondInfo;
import com.hummingbird.paas.vo.QueryObjectDetailConstructionInfo;
import com.hummingbird.paas.vo.QueryObjectDetailDateRequirementInfo;
import com.hummingbird.paas.vo.QueryObjectDetailInviteTender;
import com.hummingbird.paas.vo.QueryObjectDetailObjectMethondInfo;
import com.hummingbird.paas.vo.QueryObjectDetailProjectInfo;
import com.hummingbird.paas.vo.QueryObjectDetailProjectRequirementInfo;
import com.hummingbird.paas.vo.QueryObjectDetailResultVO;
import com.hummingbird.paas.vo.QueryObjectListResultVO;
import com.hummingbird.paas.vo.SurveyVO;

@Service
public class BiddeeServiceServiceImpl implements BiddeeServiceService {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());

	@Autowired
	BiddeeMapper beeDao;
	@Autowired
	ObjectMapper ojDao;
	@Autowired
	ObjectBaseinfoMapper obiDao;
	@Autowired
	QandaMapper qmDao;
	@Autowired
	ProjectInfosMapper pIDao;
	@Autowired
	BidderMapper berDao;
	@Autowired
	BidRecordMapper brDao;
	@Autowired
	CertificationRequirementMapper crDao;
	@Autowired
	ObjectProjectMapper obDao;
	@Autowired
	BiddeeCreditMapper bcDao;
	@Autowired
	ScoreLevelMapper slDao;
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public Boolean queryTender(Token token) throws BusinessException {
		if(log.isDebugEnabled()){
			log.debug("接口查询用户是否具有投标的资质进入");
		}
		Integer userId = token.getUserId();
		if (userId == null) {
			return false;
		}
		Biddee bee = beeDao.selectByUserId(userId);
		if(log.isDebugEnabled()){
			log.debug("本接口用于查询用户是否具有投标的资质完成："+bee);
		}
		if (bee == null) {
			return false;
		}
		if (bee.getStatus().equals("OK#")) {
			return true;
		} else {
			return false;
		}
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public List<QueryObjectListResultVO> queryObjectList(Integer pageIndex, Integer pageSize) throws BusinessException {
		if(log.isDebugEnabled()){
			log.debug("查询招标的项目列表");
		}
		List<QueryObjectListResultVO> qors = new ArrayList<QueryObjectListResultVO>();
		QueryObjectListResultVO qol = null;
		if (pageIndex == null || pageIndex <= 0 || pageSize == null || pageSize <= 0) {
			return null;
		}

		List<ObjectProject> pjs = obDao.getPages((pageIndex-1) * pageSize, pageSize);
		for (ObjectProject pj : pjs) {
			qol = new QueryObjectListResultVO();
			if (pj.getEvaluationAmount() != null)
				qol.setEvaluationAmount(pj.getEvaluationAmount().toString());
			ProjectInfos  proj = pIDao.selectByPrimaryKey(pj.getObjectId());
			if(proj!=null&&proj.getProjectExpectStartDate()!=null)
			qol.setObjectPredictStartTime(proj.getProjectExpectStartDate());
			qol.setObjectId(pj.getObjectId());
			qol.setObjectName(pj.getObjectName());
			qol.setProjectExpectPeriod(proj.getProjectExpectPeriod());
			if (pj.getBiddeeId() != null) {
				Integer biddeeId = pj.getBiddeeId();
				Biddee dee = beeDao.selectByPrimaryKey(biddeeId);
				if (dee == null) {
					continue;
				}
				qol.setCompanyShortName(dee.getCompanyName());
				BiddeeCredit bc = bcDao.selectByPrimaryKey(biddeeId);
				if(bc==null){
					continue;
				}
				if(bc!=null){
					Integer score = bc.getBaseinfoCreditScore();
					if (score == null) {
						continue;
					}
					String leve = slDao.getLevelName(score);
					if (StringUtils.isBlank(leve)) {
						continue;
					}
					qol.setCreditRating(leve);
				}
			}
			if(log.isDebugEnabled()){
				log.debug("查询招标的项目列表完成:"+qol);
			}
			qors.add(qol);

		}
		return qors;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public QueryObjectDetailResultVO queryObjectDetail(QueryObjectDetailBodyVO body) throws BusinessException {
		if(log.isDebugEnabled()){
			log.debug("进入查询招标项目详情:");
		}
		String objectId = body.getObjectId();
		ObjectProject ob = obDao.selectByPrimaryKey(objectId);
		if (StringUtils.isBlank(objectId) || ob == null) {
			return null;
		}
		QueryObjectDetailResultVO qodr = new QueryObjectDetailResultVO();
		qodr.setObjectId(objectId);
		qodr.setStatus(ob.getObjectStatus());
		ObjectBaseinfo obi = new ObjectBaseinfo();
		obi = obiDao.selectByPrimaryKey(objectId);
		SurveyVO sv = new SurveyVO();
		if (obi != null) {
			if (obi.getAnnouncementEndTime() != null)
				sv.setAnnouncementEndTime(DateUtil.formatCommonDate(obi.getAnnouncementEndTime()));
			Integer count = brDao.selectCountByObjectId(objectId);
			if (count != null)
				sv.setBidderNum(count);
			if (obi.getBiddingEndTime() != null)
				sv.setBiddingEndTime(DateUtil.formatCommonDate(obi.getBiddingEndTime()));
			if (ob.getEvaluationAmount() != null)
				sv.setEvalutionAmount(ob.getEvaluationAmount().toString());
			sv.setObjectId(obi.getObjectId());
			//sv.setProjectSite(ob);
			sv.setStatus(ob.getObjectStatus());
		}
		qodr.setSurvey(sv);
		DetailVO dv = new DetailVO();
		QueryObjectDetailAnswerQuestion qodaq = new QueryObjectDetailAnswerQuestion();
		Qanda qd = qmDao.selectByObjectId(objectId);
		if (qd != null) {
			qodaq.setAddress(qd.getAddress());
			qodaq.setAnswerTime(qd.getAnswerTime());
			qodaq.setEmail(qd.getEmail());
			if(qd.getAnswerEndDate()!=null)
		    qodaq.setEndTime(DateUtil.formatCommonDate(qd.getAnswerEndDate()));
			qodaq.setQQ(qd.getQqNo());
			qodaq.setQQToken(qd.getQqPassword());
			if(qd.getAnswerEndDate()!=null)
			qodaq.setStartTime(DateUtil.formatCommonDate(qd.getAnswerStartDate()));
			qodaq.setTelephone(qd.getTelephone());
		}
		dv.setAnswerQuestion(qodaq);
		QueryObjectDetailBaseVO qodb = new QueryObjectDetailBaseVO();
		qodb.setBiddeeCompanyPrincipal(ob.getBiddeeCompanyPrincipal());
		qodb.setBiddeeCompanyTelephone(ob.getBiddeeCompanyTelephone());
		qodb.setBiddingNo(ob.getObjectNo());
		qodb.setContractType(ob.getContractType());
		qodb.setCurrency(ob.getCurrency());
		if (ob.getEvaluationAmount() != null)
			qodb.setEvaluationAmount(ob.getEvaluationAmount().toString());
		qodb.setIndustryId(ob.getIndustryId());
		qodb.setObjectName(ob.getObjectName());
		qodb.setObjectScope(ob.getObjectScope());
		dv.setBaseInfo(qodb);
		QueryObjectDetailBidderCertificationInfo qodbci = new QueryObjectDetailBidderCertificationInfo();
		List<QueryObjectDetailBidderBidderCertification> qodbcs = new ArrayList<QueryObjectDetailBidderBidderCertification>();
		QueryObjectDetailBidderBidderCertification qodbbc = null;
		List<CertificationRequirement> cts = crDao.selectCertisByObjectId(objectId);
		for (CertificationRequirement ct : cts) {
			qodbbc = new QueryObjectDetailBidderBidderCertification();
			qodbbc.setCertificateId(ct.getCertificationId());
			qodbbc.setCertificateName(ct.getCertificationName());
			qodbcs.add(qodbbc);
		}
		qodbci.setBidderCertification(qodbcs);
		qodbci.setNeedConstructorCertification(ob.getNeedConstructorCertification());
		qodbci.setNeedPmCertification(ob.getNeedPmCertification());
		qodbci.setNeedPmSafetyCertification(ob.getNeedPmSafetyCertification());
		qodbci.setNeedSafetyPermit(ob.getNeedSafetyPermit());
		dv.setBidderCertificationInfo(qodbci);
		QueryObjectDetailBidEvaluationTypeInfo qodbevti = new QueryObjectDetailBidEvaluationTypeInfo();
		qodbevti.setBidEvalutionSite(obi.getBidEvaluationSite());
		qodbevti.setBidEvalutionType(obi.getBidEvaluationType());
		qodbevti.setBidWinnerDatemineWay(obi.getBidWinnerDetermineWay());
		qodbevti.setVoteWinWay(obi.getVoteWinWay());
		dv.setBidEvaluationTypeInfo(qodbevti);
		QueryObjectDetailBidFilTypeInfo qodbft = new QueryObjectDetailBidFilTypeInfo();
		qodbft.setNeedBusinessStandard(ob.getNeedBusinessStandard());
		qodbft.setNeedCertificationCheckupFile(ob.getNeedCertificationCheckupFile());
		qodbft.setNeedTechnicalStandard(ob.getNeedTechnicalStandard());
		dv.setBidFileTypeInfo(qodbft);
		QueryObjectDetailBondInfo qodbis = new QueryObjectDetailBondInfo();
		if (ob.getBidBondAmount() != null)
			qodbis.setBidBondAmount(ob.getBidBondAmount().toString());
		dv.setBondInfo(qodbis);
		QueryObjectDetailConstructionInfo qodci = new QueryObjectDetailConstructionInfo();
		ProjectInfos pi = pIDao.selectByPrimaryKey(objectId);
		if (pi != null) {
			if (pi.getBuildingConstructionPermitEnddate() != null)
				qodci.setBuildingConstructPermitEndDate(
						DateUtil.formatCommonDate(pi.getBuildingConstructionPermitEnddate()));
			qodci.setBuildingConstructPermitNo(pi.getConstructionLandUsePermitNo());
			qodci.setBuildingConstructPermitUrl(pi.getBuildingConstructionPermitUrl());
			if (pi.getBuildingPermitEnddate() != null)
				qodci.setBuildingPermitEndDate(DateUtil.formatCommonDate(pi.getBuildingPermitEnddate()));
			qodci.setBuildingPermitNo(pi.getBuildingPermitNo());
			qodci.setBuildingPermitPicUrl(pi.getBuildingPermitUrl());
			if (pi.getConstructionLandUsePermitEnddate() != null)
				qodci.setConstructionLandUsePermitEndDate(
						DateUtil.formatCommonDate(pi.getConstructionLandUsePermitEnddate()));
			qodci.setConstructionLandUsePermitNo(pi.getConstructionLandUsePermitNo());
			qodci.setConstructionLandUsePermitUrl(pi.getBuildingConstructionPermitUrl());
			qodci.setConstructionProveType(pi.getConstructionProveType());
			if (pi.getLandUseCertificateEnddate() != null)
				qodci.setLandUseCertificateEndDate(DateUtil.formatCommonDate(pi.getLandUseCertificateEnddate()));
			qodci.setLandUseCertificateNo(pi.getLandUseCertificateNo());
			qodci.setLandUseCertificateUrl(pi.getLandUseCertificateUrl());
			qodci.setLetterOfAcceptanceUrl(pi.getLetterOfAcceptanceUrl());
		}
		dv.setConstructionInfo(qodci);
		QueryObjectDetailDateRequirementInfo qoddri = new QueryObjectDetailDateRequirementInfo();
		if (obi != null) {
			qoddri.setAnnouncementBeginTime(DateUtil.formatCommonDateorNull(obi.getAnnouncementBeginTime()));
			qoddri.setAnnouncementEndTime(DateUtil.formatCommonDateorNull(obi.getAnnouncementEndTime()));
			qoddri.setBiddingEndTime(DateUtil.formatCommonDateorNull(obi.getBiddingEndTime()));
			qoddri.setBidOpenDate(DateUtil.formatCommonDateorNull(ob.getBidOpenDate()));
		}
		dv.setDateRequirementInfo(qoddri);
		QueryObjectDetailObjectMethondInfo qodom = new QueryObjectDetailObjectMethondInfo();
		List<Bidder> bms = berDao.selectInviteBidders(objectId);
		List<QueryObjectDetailInviteTender> tens = new ArrayList<QueryObjectDetailInviteTender>();
		QueryObjectDetailInviteTender qodi = null;
		for (Bidder ber : bms) {
			qodi = new QueryObjectDetailInviteTender();
			qodi.setBidderId(ber.getId());
			qodi.setBidderName(ber.getCompanyName());
			tens.add(qodi);
		}
		qodom.setObjectMethodInfo(ob.getObjectPublishType());
		qodom.setInviteTender(tens);
		dv.setObjectMethodInfo(qodom);
		QueryObjectDetailProjectInfo qodop = new QueryObjectDetailProjectInfo();
		if (pi != null) {
			qodop.setEmployer(pi.getEmployer());
			qodop.setEmployerPrincipal(pi.getEmployerPrincipal());
			qodop.setProjectExpectInvestment(pi.getProjectExpectInvestment());
			qodop.setProjectName(pi.getProjectName());
			qodop.setEmployerTelephone(pi.getEmployerTelephone());
			qodop.setProjectScale(pi.getProjectScale());
			qodop.setProjectSite(pi.getProjectSite());
		}
		dv.setProjectInfo(qodop);
		QueryObjectDetailProjectRequirementInfo qodpr = new QueryObjectDetailProjectRequirementInfo();
		if (pi != null) {
			qodpr.setProjectExpectPeriod(pi.getProjectExpectPeriod());
			qodpr.setProjectExpectStartDate(pi.getProjectExpectStartDate());
		}
		dv.setProjectRequirementInfo(qodpr);
		qodr.setDetail(dv);
		if(log.isDebugEnabled()){
			log.debug("查询招标项目详情完成:"+qodr);
		}
		return qodr;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public List<QueryMyBidObjectListResultVO> queryMyBidObjectList(Integer user_id, Integer pageIndex, Integer pageSize)
			throws BusinessException {
		// TODO Auto-generated method stub
		if(log.isDebugEnabled()){
			log.debug("查询我的投标中项目列表");
		}
		List<QueryMyBidObjectListResultVO> qors = new ArrayList<QueryMyBidObjectListResultVO>();
		QueryObjectListResultVO qmb = null;
		if (pageIndex == null || pageIndex <= 0 || pageSize == null || pageSize <= 0) {
			return null;
		}

		List<ObjectProject> pjs = obDao.getMyObjectProjectPages(user_id,(pageIndex-1) * pageSize, pageSize);
		QueryMyBidObjectListResultVO qol = null;
		for (ObjectProject pj : pjs) {
			if(pj != null){
			 qol = new QueryMyBidObjectListResultVO();
			qol.setIndustryId(pj.getIndustryId());
			qol.setBidAmount(String.valueOf(pj.getWinBidAmount()));
			qol.setBidOpenDate(pj.getBidOpenDate());
			qol.setObjectId(pj.getObjectId());
			qol.setObjetName(pj.getObjectName());
			if(log.isDebugEnabled()){
				log.debug("查询招标的项目列表完成:"+qol);
			}
			qors.add(qol);
			}
		}
			
		return qors;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public List<QueryMyBuildingObjectListResultVO> queryMyBuildingObjectList(Integer user_id, Integer pageIndex,
			Integer pageSize) throws BusinessException {
		// TODO Auto-generated method stub
		if(log.isDebugEnabled()){
			log.debug("查询我的实施中项目列表接口");
		}
		List<QueryMyBuildingObjectListResultVO> qors = new ArrayList<QueryMyBuildingObjectListResultVO>();
		QueryObjectListResultVO qmb = null;
		if (pageIndex == null || pageIndex <= 0 || pageSize == null || pageSize <= 0) {
			return null;
		}

		List<MyBuildingObjectProject> pjs = obDao.getMyBuildingObjectProjectPages(user_id,(pageIndex-1) * pageSize, pageSize);
		
		QueryMyBuildingObjectListResultVO qol = null;
		for (MyBuildingObjectProject pj : pjs) {
			if(pj != null){
				qol = new QueryMyBuildingObjectListResultVO();
				ProjectInfos  proj = pIDao.selectByPrimaryKey(pj.getObjectId());
				qol.setObjectId(pj.getObjectId());
//				qol.set
				qol.setObjetName(pj.getObjectName());
				if(proj!=null){
					qol.setProjectExpectPeriod(proj.getProjectExpectPeriod());
				}else {
					qol.setProjectExpectPeriod(0);
				}
//				qol.setProjectExpectStartDate(pj.getpro);
				qol.setReceivedAmount(pj.getReceivedAmount());
				qol.setWillReceiveAmount(String.valueOf(pj.getWinBidAmount()));
				if(log.isDebugEnabled()){
					log.debug("查询招标的项目列表完成:"+qol);
				}
				qors.add(qol);
			}
			 
			}
			
			
		return qors;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public List<QueryMyEndedObjectListResultVO> queryMyEndedObjectList(Integer user_id, Integer pageIndex,
			Integer pageSize) throws BusinessException {
		// TODO Auto-generated method stub
		if(log.isDebugEnabled()){
			log.debug("询我的已结束项目列表接口");
		}
		List<QueryMyEndedObjectListResultVO> qors = new ArrayList<QueryMyEndedObjectListResultVO>();
		QueryObjectListResultVO qmb = null;
		if (pageIndex == null || pageIndex <= 0 || pageSize == null || pageSize <= 0) {
			return null;
		}

		List<MyEndedObjectProject> pjs = obDao.getMyEndedObjectProjectPages(user_id,(pageIndex-1) * pageSize, pageSize);
		QueryMyEndedObjectListResultVO qol = null;
		for (MyEndedObjectProject pj : pjs) {
			if(pj != null){
			 qol = new QueryMyEndedObjectListResultVO();
			qol.setIndustryId(pj.getIndustryId());
			qol.setBidAmount(String.valueOf(pj.getWinBidAmount()));
			qol.setObjectId(pj.getObjectId());
			qol.setObjetName(pj.getObjectName());
			qol.setBiddee(pj.getBiddee());
			if(log.isDebugEnabled()){
				log.debug("查询招标的项目列表完成:"+qol);
			}
			qors.add(qol);;
			}
		}
			
			
		return qors;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public List<QueryMyLoseObjectListResultVO> queryMyLoseObjectList(Integer user_id, Integer pageIndex,
			Integer pageSize) throws BusinessException {
		// TODO Auto-generated method stub
		if(log.isDebugEnabled()){
			log.debug("询我的未中标项目列表接口");
		}
		List<QueryMyLoseObjectListResultVO> qors = new ArrayList<QueryMyLoseObjectListResultVO>();
		QueryObjectListResultVO qmb = null;
		if (pageIndex == null || pageIndex <= 0 || pageSize == null || pageSize <= 0) {
			return null;
		}

		List<MyLoseObjectProject> pjs = obDao.getMyLoseObjectProjectPages(user_id,(pageIndex-1) * pageSize, pageSize);
		QueryMyLoseObjectListResultVO qol = null;
		for (MyLoseObjectProject pj : pjs) {
			if(pj != null){
			 qol = new QueryMyLoseObjectListResultVO();
			qol.setIndustryId(pj.getIndustryId());
			qol.setWinBidAmount(String.valueOf(pj.getWinBidAmount()));
			qol.setObjectId(pj.getObjectId());
			qol.setObjetName(pj.getObjectName());
			qol.setBiddee(pj.getBiddee());
			if(log.isDebugEnabled()){
				log.debug("查询招标的项目列表完成:"+qol);
			}
			qors.add(qol);
			}
		}
			
		return qors;
	}
}
