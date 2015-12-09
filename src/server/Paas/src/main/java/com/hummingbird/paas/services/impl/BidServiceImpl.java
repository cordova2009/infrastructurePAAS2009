package com.hummingbird.paas.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.util.http.HttpRequester;
import com.hummingbird.commonbiz.util.NoGenerationUtil;
import com.hummingbird.commonbiz.util.TransOrderBuilder;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.BidAttachment;
import com.hummingbird.paas.entity.BidCertification;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.BiddeeCredit;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.BidderCertification;
import com.hummingbird.paas.entity.CertificationRequirement;
import com.hummingbird.paas.entity.CertificationType;
import com.hummingbird.paas.entity.MakeMatchBondRecord;
import com.hummingbird.paas.entity.ObjectBaseinfo;
import com.hummingbird.paas.entity.ObjectProject;
import com.hummingbird.paas.entity.ProjectEvaluationBidder;
import com.hummingbird.paas.entity.ProjectInfo;
import com.hummingbird.paas.entity.ProjectInfos;
import com.hummingbird.paas.entity.Qanda;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.mapper.BidAttachmentMapper;
import com.hummingbird.paas.mapper.BidCertificationMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.mapper.BiddeeCreditMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.BidderCertificationMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.CertificationRequirementMapper;
import com.hummingbird.paas.mapper.CertificationTypeMapper;
import com.hummingbird.paas.mapper.FeeRateMapper;
import com.hummingbird.paas.mapper.InviteBidderMapper;
import com.hummingbird.paas.mapper.MakeMatchBondRecordMapper;
import com.hummingbird.paas.mapper.ObjectBaseinfoMapper;
import com.hummingbird.paas.mapper.ObjectBondRecordMapper;
import com.hummingbird.paas.mapper.ObjectMapper;
import com.hummingbird.paas.mapper.ObjectProjectMapper;
import com.hummingbird.paas.mapper.ProjectEvaluationBiddeeMapper;
import com.hummingbird.paas.mapper.ProjectEvaluationBidderMapper;
import com.hummingbird.paas.mapper.ProjectInfoMapper;
import com.hummingbird.paas.mapper.ProjectInfosMapper;
import com.hummingbird.paas.mapper.QandaMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.services.BidService;
import com.hummingbird.paas.util.AccountGenerationUtil;
import com.hummingbird.paas.util.CallInterfaceUtil;
import com.hummingbird.paas.util.MoneyUtil;
import com.hummingbird.paas.vo.CertificationMatchVO;
import com.hummingbird.paas.vo.DetailVO;
import com.hummingbird.paas.vo.EvaluateBiddeeBodyVO;
import com.hummingbird.paas.vo.FreezeBondBodyVO;
import com.hummingbird.paas.vo.FreezeBondReturnVO;
import com.hummingbird.paas.vo.FreezeVO;
import com.hummingbird.paas.vo.QueryBidBodyVO;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult_1;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult_2;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult_3;
import com.hummingbird.paas.vo.QueryBidderBondBodyVOResult;
import com.hummingbird.paas.vo.QueryBidderCompanyInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBusinessStandardInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryMakeMatchBidderBondBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectCertificationInfoResult;
import com.hummingbird.paas.vo.QueryObjectDetailAnswerQuestion;
import com.hummingbird.paas.vo.QueryObjectDetailBaseVO;
import com.hummingbird.paas.vo.QueryObjectDetailBidEvaluationTypeInfo;
import com.hummingbird.paas.vo.QueryObjectDetailBidFilTypeInfo;
import com.hummingbird.paas.vo.QueryObjectDetailBidderBidderCertification;
import com.hummingbird.paas.vo.QueryObjectDetailBidderCertificationInfo;
import com.hummingbird.paas.vo.QueryObjectDetailBondInfo;
import com.hummingbird.paas.vo.QueryObjectDetailConstructionInfo;
import com.hummingbird.paas.vo.QueryObjectDetailDateRequirementInfo;
import com.hummingbird.paas.vo.QueryObjectDetailInviteTender;
import com.hummingbird.paas.vo.QueryObjectDetailObjectMethondInfo;
import com.hummingbird.paas.vo.QueryObjectDetailProjectInfo;
import com.hummingbird.paas.vo.QueryObjectDetailProjectRequirementInfo;
import com.hummingbird.paas.vo.QueryObjectDetailResultVO;
import com.hummingbird.paas.vo.QueryObjectListResultVO;
import com.hummingbird.paas.vo.QueryProjectAccountReturnVO;
import com.hummingbird.paas.vo.QueryProjectAccountVO;
import com.hummingbird.paas.vo.QueryTechnicalStandardInfoBodyVOResult;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO_1;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO_2;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO_3;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO_4;
import com.hummingbird.paas.vo.SaveBidderBondBodyVO;
import com.hummingbird.paas.vo.SaveBusinessStandardInfoBodyVO;
import com.hummingbird.paas.vo.SaveMakeMatchBidderBondBodyVO;
import com.hummingbird.paas.vo.SaveTechnicalStandardInfoBodyVO;
import com.hummingbird.paas.vo.SubmitBidBodyVO;
import com.hummingbird.paas.vo.SurveyVO;
import com.hummingbird.paas.vo.UnfreezeBondVO;

/**
 * @author
 * @date 2015-11-13
 * @version 1.0 service接口实现
 */
@Service
public class BidServiceImpl implements BidService {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());

	@Autowired
	BidRecordMapper dao;
	@Autowired
	BidCertificationMapper bcdao;
	@Autowired
	BidObjectMapper objectdao;
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
	ProjectInfoMapper projectInfoDao;
	@Autowired
	BidderMapper berDao;
	@Autowired
	BidderCertificationMapper bcertDao;// 投标证书
	@Autowired
	BidRecordMapper brDao;
	@Autowired
	CertificationTypeMapper certDao;
	@Autowired
	CertificationRequirementMapper crDao;
	@Autowired
	ObjectProjectMapper obDao;
	@Autowired
	BiddeeCreditMapper bcDao;
	@Autowired
	ScoreLevelMapper slDao;
	@Autowired
	ObjectBondRecordMapper obrDao;
	@Autowired
	MakeMatchBondRecordMapper mmbrDao;
	@Autowired
	FeeRateMapper frDao;
	@Autowired
	InviteBidderMapper ibDao;
	@Autowired
	ProjectEvaluationBidderMapper evaluationBidderDao;
	@Autowired
	BidAttachmentMapper baDao;

	// @Transactional(propagation = Propagation.REQUIRED, rollbackFor =
	// Exception.class, value = "txManager")
	/**
	 * 查询投标人资质证书接口
	 * 
	 * @param bidderId
	 * @return
	 * @throws BusinessException
	 */
	public Map queryBidderCertificationInfo(QueryBidBodyVO body, Integer bidderId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询投标人资质证书接口进入");
		}
		// 查询招标的证书要求
		// 查询投标人的证书
		List<CertificationRequirement> certs = crDao.selectCertisByObjectId(body.getObjectId());
		List<BidderCertification> biddercerts = bcertDao.selectByBidderId(bidderId);
		List misslist = new ArrayList<>();
		List bidderList = new ArrayList<>();
		List requirementList = new ArrayList<>();
		Map certificationInfo = new HashMap<>();
		certificationInfo.put("missingList", misslist);
		certificationInfo.put("bidderList", bidderList);
		certificationInfo.put("requirementList", requirementList);
		Map bidderCertMap = new HashMap<>();
		for (Iterator iterator = biddercerts.iterator(); iterator.hasNext();) {
			BidderCertification bidderCertification = (BidderCertification) iterator.next();
			CertificationType cert = certDao.selectByPrimaryKey(bidderCertification.getCertificationId());
			if (cert != null) {
				bidderCertification.setCertificationType(cert);
				addCert2list(bidderList, cert);
			}
		}
		List<CertificationMatchVO> nofitcerts = new ArrayList<>();
		StringBuilder reason = new StringBuilder();
		for (Iterator iterator = certs.iterator(); iterator.hasNext();) {
			CertificationRequirement cr = (CertificationRequirement) iterator.next();
			Integer certificationId = cr.getCertificationId();
			CertificationType cert = certDao.selectByPrimaryKey(certificationId);
			if (cert != null) {
				addCert2list(requirementList, cert);
				// 查询投标人有没有对应的资质
				CertificationMatchVO matchresult = getSuitableCert(cert, biddercerts);
				if (!matchresult.isMatch()) {
					addCert2list(misslist, cert);
				}
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("查询投标人资质证书接口完成");
		}
		return certificationInfo;
	}

	/**
	 * 添加证书信息到list中
	 * 
	 * @param list
	 * @param cert
	 */
	private void addCert2list(List list, CertificationType cert) {
		Map certmap = new HashMap<>();
		certmap.put("certificateId", cert.getId());
		certmap.put("certificationName", cert.getCertificationName());
		list.add(certmap);
	}

	// @Transactional(propagation = Propagation.REQUIRED, rollbackFor =
	// Exception.class, value = "txManager")
	public List<QueryObjectListResultVO> queryObjectList(Pagingnation pagingnation, Integer userId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询招标的项目列表");
		}
		List<QueryObjectListResultVO> qors = new ArrayList<QueryObjectListResultVO>();
		QueryObjectListResultVO qol = new QueryObjectListResultVO();
		// if (pageIndex == null || pageIndex <= 0 || pageSize == null ||
		// pageSize <= 0) {
		// return null;
		// }
		// Pagingnation pagingnation = body.toPagingnation();
		Map param = new HashMap<>();
		param.put("userId", userId);
		int count = obDao.queryObjectCount(param);
		pagingnation.setTotalCount(count);
		pagingnation.calculatePageCount();

		List<ObjectProject> pjs = obDao.queryObjectByPage(pagingnation, param);
		for (ObjectProject pj : pjs) {
			qol = new QueryObjectListResultVO();
			if (pj.getEvaluationAmount() != null)
				qol.setEvaluationAmount(ObjectUtils.toString(pj.getEvaluationAmount()));
			ProjectInfos proj = pIDao.selectByPrimaryKey(pj.getObjectId());
			if (proj != null && proj.getProjectExpectStartDate() != null)
				qol.setObjectPredictStartTime(proj.getProjectExpectStartDate());
			qol.setObjectId(pj.getObjectId());
			qol.setObjectName(pj.getObjectName());
			if (proj != null && proj.getProjectExpectPeriod() != null) qol.setProjectExpectPeriod(proj.getProjectExpectPeriod());
			if (pj.getBiddeeId() != null) {
				Integer biddeeId = pj.getBiddeeId();
				Biddee dee = beeDao.selectByPrimaryKey(biddeeId);
				if (dee != null) {
					qol.setCompanyShortName(dee.getCompanyName());
				}
				BiddeeCredit bc = bcDao.selectByPrimaryKey(biddeeId);
				// 生成信用评价,需要调整
				if (bc != null) {
					Integer score = bc.getBaseinfoCreditScore();
					if (score != null) {
						String leve = StringUtils.defaultIfEmpty(slDao.getLevelName(score), "A");//modify by   2015年12月9日21:08:34
						if (StringUtils.isNotBlank(leve)) {
							qol.setCreditRating(leve);
						}
					}
				}
			}
			if (log.isDebugEnabled()) {
				log.debug("查询招标的项目列表完成:" + qol);
			}
			qors.add(qol);

		}
		return qors;
	}

	/**
	 * 查询标的详情接口
	 * 
	 * @see com.hummingbird.paas.services.BidService#queryObjectDetail(com.hummingbird.paas.vo.QueryObjectDetailBodyVO)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public QueryObjectDetailResultVO queryObjectDetail(String appId, QueryBidBodyVO body, Integer bidderId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("进入查询招标项目详情:");
		}
		String objectId = body.getObjectId();
		ObjectProject ob = obDao.selectByPrimaryKey(objectId);
		if (StringUtils.isBlank(objectId) || ob == null) {
			log.error(String.format("标的不存在"));
			throw new PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION, "标的不存在");
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
//			if (ob.getProjectExpectPeriod() != null)
//				sv.setProjectExpectPeriod(ob.getProjectExpectPeriod().toString());
			// sv.setProjectSite(ob);
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
			if (qd.getAnswerEndDate() != null)
				qodaq.setEndTime(DateUtil.formatCommonDate(qd.getAnswerEndDate()));
			qodaq.setQQ(qd.getQqNo());
			qodaq.setQQToken(qd.getQqPassword());
			if (qd.getAnswerEndDate() != null)
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
		ProjectInfos pi =pIDao.selectByPrimaryKey(objectId);
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
			qodop.setEmployerTelephone(pi.getEmployerTelephone());
			qodop.setProjectExpectInvestment(pi.getProjectExpectInvestment());
			qodop.setProjectName(pi.getProjectName());
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
		if (log.isDebugEnabled()) {
			log.debug("查询招标项目详情完成:" + qodr);
		}
		return qodr;
	}

	/**
	 * 查询投标要求基础信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public QueryObjectCertificationInfoResult queryObjectRequirementInfo(String appId, QueryBidBodyVO body)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询投标要求基础信息接口");
		}
		BidObject bidObject = objectdao.selectByPrimaryKey(body.getObjectId());
		if (bidObject == null) {
			log.error(String.format("标的[%s]不存在", body.getObjectId()));
			throw ValidateException.ERROR_PARAM_NOTEXIST.clone(null, "标的不存在");
		}
		QueryObjectCertificationInfoResult result = new QueryObjectCertificationInfoResult();
		result.setNeedConstructorCertification(bidObject.getNeedConstructorCertification());
		result.setNeedPmCertification(bidObject.getNeedPmCertification());
		result.setNeedPmSafetyCertification(bidObject.getNeedPmSafetyCertification());
		result.setNeedSafetyPermit(bidObject.getNeedSafetyPermit());

		if (log.isDebugEnabled()) {
			log.debug("查询投标要求基础信息接口");
		}
		return result;
	}

	/**
	 * @param body
	 * @return
	 * @throws DataInvalidException
	 */
	public BidRecord validateBid(Integer bidId, String ObjectId, Integer bidderId) throws DataInvalidException {

		return validateBid(bidId, ObjectId, bidderId, null);
	}

	/**
	 * @param body
	 * @return
	 * @throws DataInvalidException
	 */
	public BidRecord validateBid(Integer bidId, String ObjectId, Integer bidderId, BidObject bidObject)
			throws DataInvalidException {
		BidRecord bid = dao.selectByPrimaryKey((bidId));
		if (bid == null) {
			log.error(String.format("投标记录[%s]不存在", bidId));
			throw ValidateException.ERROR_PARAM_NULL.clone(null, "投标记录不存在");
		}
		if (log.isDebugEnabled()) {
			log.debug(String.format("检查投标记录的属性是否匹配,%s", bid));
		}
		ValidateUtil.assertNotEqual(bid.getObjectId(), ObjectId, "当前投标并非指定标的");
		bidObject = objectdao.selectByPrimaryKey(bid.getObjectId());
		if (bidObject == null) {
			log.error(String.format("标的[%s]不存在", ObjectId));
			throw ValidateException.ERROR_PARAM_NOTEXIST.clone(null, "标的不存在");
		}
		if (!bidObject.getObjectStatus().equals("PUB")) {
			log.error(String.format("标的[%s]非发布中", ObjectId));
			throw ValidateException.ERROR_PARAM_NOTEXIST.clone(null, "标的状态不正确,目前并非发布中");
		}
		if (bidderId != null) {
			ValidateUtil.assertNotEqual(bid.getBidderId(), bidderId, "当前投标并非您的标");
		}
		ValidateUtil.assertNotEqual(bid.getStatus(), CommonStatusConst.STATUS_CREATE, "当前投标状态不正确");
		bid.setBo(bidObject);
		return bid;
	}

	/**
	 * 把字符串转为日期,如果内容为空,则返回null
	 * 
	 * @param datestr
	 * @return
	 * @throws ParseException
	 */
	private Date getDateFromStringOrNull(String datestr) throws ValidateException {
		if (StringUtils.isNotBlank(datestr)) {
			try {
				Date time = DateUtil.parse(datestr).getTime();
				return time;
			} catch (ParseException e1) {
				log.error(String.format("字符串%s转为日期出错", datestr), e1);
				throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e1, "日期格式不正确");
			}
		} else {
			return (null);
		}
	}

	/**
	 * 把日期转为字符串,如果内容为空,则返回""
	 * 
	 * @param datestr
	 * @return
	 * @throws ParseException
	 */
	private String getStringFromDateOrNull(Date date) {
		if (date == null) {
			return "";
		} else {
			return DateUtil.format(date, "yyyy-MM-dd");
		}
	}

	/**
	 * 查询未完成投标的商务标信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public QueryBusinessStandardInfoBodyVOResult queryBusinessStandardInfo(String appId, QueryBidBodyVO body,
			Integer bidderId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成投标的商务标信息接口开始");
		}
		QueryBusinessStandardInfoBodyVOResult result = new QueryBusinessStandardInfoBodyVOResult();
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), null);
		result.setBidAmount(ObjectUtils.toString(bid.getBidAmount()));
		result.setProjectQuotationUrl(bid.getProjectQuotationUrl());
		result.setConstructionCommitmentUrl(bid.getConstructionCommitmentUrl());
		result.setConstructionEndDate((bid.getConstructionEndDate()));
		result.setConstructionStartDate((bid.getConstructionStartDate()));
		if (log.isDebugEnabled()) {
			log.debug("查询未完成投标的商务标信息接口完成");
		}
		return result;
	}

	/**
	 * 保存投标的商务标信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveBusinessStandardInfo(String appId, SaveBusinessStandardInfoBodyVO body, Integer bidderId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存投标的商务标信息接口开始");
		}
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), null);
		ValidateUtil.assertEmpty(body.getBidAmount(), "项目报价");
		ValidateUtil.assertEmpty(body.getProjectQuotationUrl(), "项目报价表");
		ValidateUtil.assertEmpty(body.getConstructionCommitmentUrl(), "施工承诺函附件");
		ValidateUtil.assertEmpty(body.getConstructionEndDate(), "施工开始时间");
		ValidateUtil.assertEmpty(body.getConstructionStartDate(), "施工结束时间");
		bid.setBidAmount(NumberUtils.toLong(body.getBidAmount()));
		bid.setProjectQuotationUrl(body.getProjectQuotationUrl());
		bid.setConstructionCommitmentUrl(body.getConstructionCommitmentUrl());
		bid.setConstructionEndDate(body.getConstructionEndDate());
		bid.setConstructionStartDate(body.getConstructionStartDate());
		dao.updateByPrimaryKey(bid);
		if (log.isDebugEnabled()) {
			log.debug("保存投标的商务标信息接口完成");
		}
	}

	/**
	 * 查询未完成投标的技术标信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public QueryTechnicalStandardInfoBodyVOResult queryTechnicalStandardInfo(String appId, QueryBidBodyVO body,
			Integer bidderId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成投标的技术标信息接口开始");
		}
		QueryTechnicalStandardInfoBodyVOResult result = new QueryTechnicalStandardInfoBodyVOResult();
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), bidderId);
		result.setTechnicalStandardUrl(bid.getTechnicalStandardUrl());
		if (log.isDebugEnabled()) {
			log.debug("查询未完成投标的技术标信息接口完成");
		}
		return result;
	}

	/**
	 * 保存投标的技术标信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveTechnicalStandardInfo(String appId, SaveTechnicalStandardInfoBodyVO body, Integer bidderId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存投标的技术标信息接口开始");
		}
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), bidderId);
		ValidateUtil.assertEmpty(body.getTechnicalStandardUrl(), "技术标附件");
		bid.setTechnicalStandardUrl(body.getTechnicalStandardUrl());
		dao.updateByPrimaryKey(bid);
		if (log.isDebugEnabled()) {
			log.debug("保存投标的技术标信息接口完成");
		}
	}

	/**
	 * 查询投标保证金信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public QueryBidderBondBodyVOResult queryBidderBond(String appId, QueryBidBodyVO body, Integer bidderId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询投标保证金信息接口开始");
		}
		QueryBidderBondBodyVOResult result = new QueryBidderBondBodyVOResult();
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), bidderId, null);
		BidObject object = bid.getBo();
		Long bidBondAmount = object.getBidBondAmount();
		result.setBankGuaranteeAmount(ObjectUtils.toString(bid.getBankGuaranteeAmount()));
		result.setBankGuaranteeNo(bid.getBankGuaranteeNo());
		result.setBankGuaranteeUrl(bid.getBankGuaranteeUrl());
		result.setBidBondAmount(ObjectUtils.toString(bidBondAmount));
		if (log.isDebugEnabled()) {
			log.debug("查询投标保证金信息接口完成");
		}
		return result;
	}

	/**
	 * 保存投标保证金接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveBidderBond(String appId, SaveBidderBondBodyVO body, Integer bidderId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存投标保证金接口开始");
		}
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), bidderId, null);
		ValidateUtil.assertEmpty(body.getBankGuaranteeNo(), "保函编号");
		ValidateUtil.assertEmpty(body.getBankGuaranteeUrl(), "保函附件附件");
		ValidateUtil.assertEmpty(String.valueOf(body.getBankGuaranteeAmount()), "保函金额");
		bid.setBankGuaranteeAmount(body.getBankGuaranteeAmount());
		bid.setBankGuaranteeNo(body.getBankGuaranteeNo());
		bid.setBankGuaranteeUrl(body.getBankGuaranteeUrl());
		dao.updateByPrimaryKey(bid);
		if (log.isDebugEnabled()) {
			log.debug("保存投标保证金接口完成");
		}
	}

	/**
	 * 查询撮合投标保证金接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryMakeMatchBidderBondBodyVOResult queryMakeMatchBidderBond(String appId, QueryBidBodyVO body,
			Integer bidderId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询撮合投标保证金接口开始");
		}
		QueryMakeMatchBidderBondBodyVOResult result = new QueryMakeMatchBidderBondBodyVOResult();
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), bidderId, null);
		BidObject object = bid.getBo();
		MakeMatchBondRecord mmbond = mmbrDao.selectByBidId(body.getBidId());
		if (mmbond == null) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("投标人还没有交纳撮合保证金"));
			}
			// 计算撮合保证金金额
			Long bondmoney = frDao.selectMoney(object.getEvaluationAmount(), "BZJ");
			if (bondmoney == null) {
				log.error(String.format("无法找到合适的撮合保证金,费率表没有对应的设置,金额为%s分", object.getEvaluationAmount()));
				throw ValidateException.ERROR_PARAM_NULL.clone(null, "无法找到合适的撮合保证金");
			}
			result.setMakeMatchBidderBondAmount(ObjectUtils.toString(bondmoney));
			// 检查投标人的可用余额,远程访问用户资金帐户
			Map capbody = new HashMap();
			capbody.put("token", body.getToken());
			PropertiesUtil pu=new PropertiesUtil();
			
			BaseTransVO<Map> buildBaseTrans = TransOrderBuilder.buildBaseTrans("paas", pu.getProperty("appkey"), capbody, false, false);
			String requestJson = JsonUtil.convert2Json(buildBaseTrans);
			String paygatewayUrl = String.format("%s/capitalManage/queryProjectAccount",pu.getProperty("capital.url"));
			log.debug(String.format("开始调用资金账户冻结撮合保证金接口，地址是：%s", paygatewayUrl));
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
					log.debug(String.format("查询用户资金账户失败"));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,proAccount.getErrmsg());
				
			}
			// TODO 改为访问用户资金帐户
			Long remainingsum = returnBody.getRemainingSum();
			if (remainingsum >= bondmoney) {
				result.setSatisfy("ENH");
			} else {
				result.setSatisfy("NEN");
			}
		} else {
			result.setMakeMatchBidderBondAmount(ObjectUtils.toString(mmbond.getBondAmount()));
			result.setSatisfy("PAY");
		}

		if (log.isDebugEnabled()) {
			log.debug("查询撮合投标保证金接口完成");
		}
		return result;
	}

	/**
	 * 提交撮合投标保证金信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveMakeMatchBidderBond(String appId, SaveMakeMatchBidderBondBodyVO body, Bidder bidder)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("提交撮合投标保证金信息接口开始");
		}
		BidObject object = null;
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), bidder.getId(), object);
		object = bid.getBo();
		// 计算撮合保证金金额
		Long bondmoney = frDao.selectMoney(object.getEvaluationAmount(), "BZJ");
		if (bondmoney == null) {
			log.error(String.format("无法找到合适的撮合保证金,费率表没有对应的设置,金额为%s分", object.getEvaluationAmount()));
			throw ValidateException.ERROR_PARAM_NULL.clone(null, "无法找到合适的撮合保证金");
		}
		//调用资金账户管理，查询用户余额是否足够
		Map capbody = new HashMap();
		capbody.put("token", body.getToken());
		PropertiesUtil pu=new PropertiesUtil();
		
		BaseTransVO<Map> buildBaseTrans = TransOrderBuilder.buildBaseTrans("paas", pu.getProperty("appkey"), capbody, false, false);
		String requestJson = JsonUtil.convert2Json(buildBaseTrans);
		String paygatewayUrl = String.format("%s/capitalManage/queryProjectAccount",pu.getProperty("capital.url"));
		String result = new HttpRequester().postRequest(paygatewayUrl,
				requestJson);
		if(result==null){
			throw ValidateException.ERROR_REQUEST_INVALID;
		}
		QueryProjectAccountVO proAccount=JsonUtil.convertJson2Obj(result, QueryProjectAccountVO.class);
		
		QueryProjectAccountReturnVO returnBody=proAccount.getAccount();
		boolean mapsuccess = "0".equals(ObjectUtils.toString(proAccount.getErrcode()));
		if(!mapsuccess){
			if (log.isDebugEnabled()) {
				log.debug(String.format("查询用户资金账户失败"));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,proAccount.getErrmsg());
			
		}
		//判断用户账户余额是否足够支付撮合保证金
		if(returnBody.getRemainingSum()<bondmoney){
			if (log.isDebugEnabled()) {
				log.debug(String.format("冻结撮合保证金失败，用户可用余额不足"));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,String.format("冻结撮合保证金失败，用户可用余额不足"));
			
		}
		//生成撮合保证金缴纳记录
		MakeMatchBondRecord mmbond = mmbrDao.selectByBidId(body.getBidId());
		if (mmbond == null) {
			mmbond = new MakeMatchBondRecord();
			mmbond.setBidId(body.getBidId());
			mmbond.setObjectId(body.getObjectId());
			mmbond.setOrderId(NoGenerationUtil.genNO("BZ00", 8));
			mmbond.setInsertTime(new Date());
			mmbond.setUpdateTime(new Date());
			mmbond.setCreator(String.valueOf(bidder.getUserId()));
			mmbond.setStatus("FOZ");
			mmbond.setBondAmount(body.getMakeMatchBidderBondAmount());

			mmbrDao.insert(mmbond);
			// 调用用户资金接口,冻结FreezeBondBodyVO
			FreezeBondBodyVO freebody = new FreezeBondBodyVO();
			freebody.setAmount(bondmoney);
			freebody.setObjectId(body.getObjectId());
			freebody.setOriginalOrderId(mmbond.getOrderId());
			freebody.setOriginalTable("t_ztgl_object_makematch_bond_record");
			freebody.setRemark("冻结"+MoneyUtil.getMoneyStringDecimal4yuan(bondmoney)+"元撮合工保证金");
			freebody.setToken(body.getToken());
			//freebody.setTradePassword(tradePassword);
			freebody.setIsVerityPassword(false);
			BaseTransVO<FreezeBondBodyVO> buildBaseTrans2 = TransOrderBuilder.buildBaseTrans("paas", pu.getProperty("appkey"), freebody, false, false);
			String requestJson2 = JsonUtil.convert2Json(buildBaseTrans2);
			String paygatewayUrl2 = String.format("%s/capitalManage/freezeBond",pu.getProperty("capital.url"));
			String result2 = new HttpRequester().postRequest(paygatewayUrl2,
					requestJson2);
			if(result2==null){
				throw ValidateException.ERROR_REQUEST_INVALID;
			}
			FreezeVO freeze=JsonUtil.convertJson2Obj(result2, FreezeVO.class);
			
			FreezeBondReturnVO order=freeze.getOrder();
			boolean mapsuccess2 = "0".equals(ObjectUtils.toString(freeze.getErrcode()));
			if(!mapsuccess2){
				if (log.isDebugEnabled()) {
					log.debug(String.format("冻结撮合保证金失败"));
				}
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,freeze.getErrmsg());
				
			}
		}
		// 不存在更新行为
		// else{
		// mmbond.setBondAmount(body.getMakeMatchBidderBondAmount());
		// mmbrDao.updateByPrimaryKey(mmbond);
		// }
		if (log.isDebugEnabled()) {
			log.debug("提交撮合投标保证金信息接口完成");
		}
	}

	@Override
	public FreezeBondReturnVO unfreezeMakeMatchBidderBond(UnfreezeBondVO body, Bidder bidder, String method)
			throws BusinessException {
		// 根据orderId查询原来的订单信息
		MakeMatchBondRecord oldActOrd = mmbrDao.selectByPrimaryKey(body.getOrderId());
		if (oldActOrd == null) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据订单号【%s】查询不到原来的订单信息", body.getOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,
					String.format("根据订单号【%s】查询不到原来的订单信息", body.getOrderId()));

		}
		BidObject object = null;
		BidRecord bid = validateBid(oldActOrd.getBidId(), oldActOrd.getObjectId(), bidder.getId(), object);

		List<MakeMatchBondRecord> returnActOrds = mmbrDao.selectReturnByBidId(oldActOrd.getBidId());
		if (returnActOrds.size() > 0) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("投标订单号【%s】已经退还过撮合保证金，无法再次退还", oldActOrd.getBidId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,
					String.format("投标订单号【%s】已经退还过撮合保证金，无法再次退还", oldActOrd.getBidId()));
		}

		// 创建保证金订单
		Long objectBond = oldActOrd.getBondAmount();
		// 创建解冻撮合担保金订单
		MakeMatchBondRecord bondRecord = new MakeMatchBondRecord();
		String bondorderId = AccountGenerationUtil.genNO("BZ00");
		bondRecord.setOrderId(bondorderId);
		bondRecord.setUpdateTime(new Date());
		bondRecord.setBidId(oldActOrd.getBidId());
		bondRecord.setCreator(String.valueOf(bidder.getUserId()));
		bondRecord.setInsertTime(new Date());
		bondRecord.setObjectId(oldActOrd.getObjectId());
		bondRecord.setBondAmount(objectBond);
		bondRecord.setStatus("REV");
		mmbrDao.insert(bondRecord);
		// 调用用户资金接口,解除冻结
		UnfreezeBondVO unfreebody = new UnfreezeBondVO();
		unfreebody.setObjectId(body.getObjectId());
		unfreebody.setOrderId(body.getOrderId());
		unfreebody.setRemark("解除冻结"+MoneyUtil.getMoneyStringDecimal4yuan(oldActOrd.getBondAmount())+"元撮合工保证金");
		unfreebody.setToken(body.getToken());
		PropertiesUtil pu=new PropertiesUtil();
		BaseTransVO<UnfreezeBondVO> buildBaseTrans2 = TransOrderBuilder.buildBaseTrans("paas", pu.getProperty("appkey"), unfreebody, false, false);
		String requestJson2 = JsonUtil.convert2Json(buildBaseTrans2);
		String paygatewayUrl2 = String.format("%s/capitalManage/unfreezeBond",pu.getProperty("capital.url"));
		
		String result2 = new HttpRequester().postRequest(paygatewayUrl2,
				requestJson2);
		if(result2==null){
			throw ValidateException.ERROR_REQUEST_INVALID;
		}
		FreezeVO freeze=JsonUtil.convertJson2Obj(result2, FreezeVO.class);
		
		FreezeBondReturnVO order=freeze.getOrder();
		boolean mapsuccess2 = "0".equals(ObjectUtils.toString(freeze.getErrcode()));
		if(!mapsuccess2){
			if (log.isDebugEnabled()) {
				log.debug(String.format("冻结撮合保证金失败"));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,freeze.getErrmsg());
			
		}
		// 组装返回信息
		FreezeBondReturnVO bond = new FreezeBondReturnVO();
		/*
		 * bond.setAccountId(account.getAccountId());
		 * bond.setAmount(objectBond.toString());
		 * bond.setBalance(balance.toString()); bond.setFlowDirection("IN#");
		 * bond.setFlowDirection(OrderConst.FLOW_DIRECTION_IN);
		 * bond.setOrderId(accountOrderId); bond.setRemark("退还保证金");
		 * bond.setType("REV");
		 */
		return bond;
	}

	/**
	 * 提交投标接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void submitBid(String appId, SubmitBidBodyVO body, Bidder bidder) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("提交投标接口开始");
		}
		BidObject object = null;
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), bidder.getId(), object);
		bid.setStatus(CommonStatusConst.STATUS_OK);
		//添加附件
		BidAttachment ba = new BidAttachment();
		List<BidAttachment> selectBidFile = baDao.selectBidFile(body.getBidId());
		if(CollectionUtils.isNotEmpty(selectBidFile))
		{
			for (Iterator iterator = selectBidFile.iterator(); iterator.hasNext();) {
				BidAttachment bidAttachment = (BidAttachment) iterator.next();
				baDao.deleteByPrimaryKey(bidAttachment.getId());
			}
		}
		ba.setAttachmentUrl(body.getBidFile());
		ba.setBidId(body.getBidId());
		ba.setInsertTime(new Date());
		ba.setAttachmentType("BF#");
		baDao.insert(ba);
		dao.updateByPrimaryKey(bid);

		if (log.isDebugEnabled()) {
			log.debug("提交投标接口完成");
		}
	}

	/**
	 * 保存投标资格审查信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @param bidderId
	 * @return
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public BidRecord saveBidRequirementInfo(String appId, SaveBidRequirementInfoBodyVO body, Integer bidderId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存投标资格审查信息接口开始");
		}
		BidRecord bid = null;
		if (null == body.getBidId()) {
			// 查询有没有未完成的
			List<BidRecord> selectUnfinishObject = dao.selectUnfinishedBid(bidderId, body.getObjectId());
			if (selectUnfinishObject != null && !selectUnfinishObject.isEmpty()) {
				bid = selectUnfinishObject.get(0);
			}
		} else {

			bid = dao.selectByPrimaryKey((body.getBidId()));
			if (bid != null) {
				// 检查编号是否存在
				ValidateUtil.assertNotEqual(bid.getBidStatus(), "CRT", "项目非编制中,不能进行操作");
			}
		}
		if (bid != null) {

			String objectId = body.getObjectId();
			if (log.isDebugEnabled()) {
				log.debug(String.format("检查投标记录的属性是否匹配,%s", bid));
			}
			ValidateUtil.assertNotEqual(bid.getObjectId(), objectId, "当前投标并非指定标的");
			BidObject bidObject = objectdao.selectByPrimaryKey(bid.getObjectId());
			if (bidObject == null) {
				log.error(String.format("标的[%s]不存在", objectId));
				throw ValidateException.ERROR_PARAM_NOTEXIST.clone(null, "标的不存在");
			}
			if (!bidObject.getObjectStatus().equals("PUB")) {
				log.error(String.format("标的[%s]非发布中", objectId));
				throw ValidateException.ERROR_PARAM_NOTEXIST.clone(null, "标的状态不正确,目前并非发布中");
			}
			if (bidderId != null) {
				ValidateUtil.assertNotEqual(bid.getBidderId(), bidderId, "当前投标并非您的标");
			}
			ValidateUtil.assertNotEqual(bid.getStatus(), CommonStatusConst.STATUS_CREATE, "当前投标状态不正确");
		}
		boolean isadd = false;
		if (bid == null) {
			bid = new BidRecord();
			bid.setObjectId(body.getObjectId());
			bid.setBidderId(bidderId);
			bid.setBidStatus(CommonStatusConst.STATUS_CREATE);
			bid.setStatus(CommonStatusConst.STATUS_CREATE);
			bid.setBidAmount(0l);
			bid.setInsertTime(new Date());
			isadd = true;
		}
		SaveBidRequirementInfoBodyVO_3 bankGuarantee = body.getBankGuarantee();
		SaveBidRequirementInfoBodyVO_2 bidPeopleRequirement = body.getBidPeopleRequirement();
		SaveBidRequirementInfoBodyVO_1 bidSafetyInfo = body.getBidSafetyInfo();
		bid.setSafetyPermitEndtime(getDateFromStringOrNull(bidSafetyInfo.getNeedSafetyPermitEndDate()));
		bid.setPmSafetyCertificationEndtime(
				getDateFromStringOrNull(bidSafetyInfo.getNeedPmSafetyCertificationEndDate()));
		bid.setPmCertificationEndtime(getDateFromStringOrNull(bidPeopleRequirement.getNeedPmCertificationEndDate()));
		bid.setConstructorCertificationEndtime(
				getDateFromStringOrNull(bidPeopleRequirement.getNeedConstructorCertificationEndDate()));
		bid.setSafetyPermitNo(bidSafetyInfo.getNeedSafetyPermitNo());
		bid.setSafetyPermitUrl(bidSafetyInfo.getNeedSafetyPermitUrl());
		bid.setPmSafetyCertificationNo(bidSafetyInfo.getNeedPmSafetyCertificationNo());
		bid.setPmSafetyCertificationUrl(bidSafetyInfo.getNeedPmSafetyCertificationUrl());

		bid.setPmCertificationNo(bidPeopleRequirement.getNeedPmCertificationNo());
		bid.setPmCertificationUrl(bidPeopleRequirement.getNeedPmCertificationUrl());
		bid.setConstructorCertificationNo(bidPeopleRequirement.getNeedConstructorCertificationNo());
		bid.setConstructorCertificationUrl(bidPeopleRequirement.getNeedConstructorCertificationUrl());

		bid.setBankGuaranteeAmount(bankGuarantee.getBankGuaranteeAmount());
		bid.setBankGuaranteeNo(bankGuarantee.getBankGuaranteeNo());
		bid.setBankGuaranteeUrl(bankGuarantee.getBankGuaranteeUrl());
		// 查询投标资质
		if (isadd) {
			dao.insert(bid);
		} else {
			dao.updateByPrimaryKey(bid);
			bcdao.deleteByBidId((body.getBidId()));
		}
		List<SaveBidRequirementInfoBodyVO_4> certificationList = body.getCertificationList();
		for (Iterator iterator = certificationList.iterator(); iterator.hasNext();) {
			SaveBidRequirementInfoBodyVO_4 bidCertificationReq = (SaveBidRequirementInfoBodyVO_4) iterator.next();
			BidCertification bc = new BidCertification();
			bc.setBidId(bid.getId());
			bc.setObjReqId(bidCertificationReq.getObjReqId());
			bc.setBidderCertificationId(bidCertificationReq.getBidderCertificationId());
			bcdao.insert(bc);
		}

		// 请自行调整
		if (log.isDebugEnabled()) {
			log.debug("保存投标资格审查信息接口完成");
		}
		return bid;
	}

	public void hadQualify2bid(QueryObjectBodyVO queryobject, Integer userId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("接口查询用户是否具有投标的资质进入");
		}

		if (userId == null) {
			log.error(String.format("用户ID为空"));
			throw ValidateException.ERROR_PARAM_NULL.clone(null, "用户不存在");
		}
		Bidder bidder = berDao.selectByUserId(userId);
		if (bidder == null) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户[%s]没有进行投标人资格认证", userId));
			}
			throw new PaasException(PaasException.ERR_BIDDER_INFO_EXCEPTION, "你还不是投标人,不能参与投标");
		}
		if (!CommonStatusConst.STATUS_OK.equals(bidder.getStatus())) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户[%s]投标人信息状态不对", userId));
			}
			throw new PaasException(PaasException.ERR_BIDDER_INFO_EXCEPTION, "你的状态非正常状态,不能参与投标");
		}

		String objectId = queryobject.getObjectId();
		if (StringUtils.isBlank(objectId)) {
			log.error(String.format("标的编号为空,没有办法判断"));
			throw new PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION, "标的编号为空,没有办法判断");
		}
		ObjectProject object = obDao.selectByPrimaryKey(objectId);
		if (object == null) {
			log.error(String.format("招标信息为空,没有办法判断"));
			throw new PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION, "招标信息为空,没有办法判断");
		}
		if (!StringUtils.equals(object.getObjectStatus(), "PUB")) {
			log.error(String.format("招标信息状态非发布中,不能投标"));
			throw new PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION, "招标信息状态非发布中,不能投标");
		}
		// 如果招标的邀请招标,检查是否在邀请招标名单内
		if (StringUtils.equals(object.getObjectPublishType(), "INV")) {
			int count = ibDao.hadInvited(object.getObjectId(), bidder.getId());
			if (count == 0) {
				log.error(String.format("招标信息是邀请招标但你未被邀请,不能投标"));
				throw new PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION, "招标信息是邀请招标但你未被邀请,不能投标");
			}
		}
		// 检查招标人资质信息

		List<CertificationRequirement> certs = crDao.selectCertisByObjectId(objectId);
		List<BidderCertification> biddercerts = bcertDao.selectByBidderId(bidder.getId());
		Map bidderCertMap = new HashMap<>();
		for (Iterator iterator = biddercerts.iterator(); iterator.hasNext();) {
			BidderCertification bidderCertification = (BidderCertification) iterator.next();
			CertificationType cert = certDao.selectByPrimaryKey(bidderCertification.getCertificationId());
			if (cert != null) {
				bidderCertification.setCertificationType(cert);
			}
		}
		List<CertificationMatchVO> nofitcerts = new ArrayList<>();
		StringBuilder reason = new StringBuilder();
		for (Iterator iterator = certs.iterator(); iterator.hasNext();) {
			CertificationRequirement cr = (CertificationRequirement) iterator.next();
			Integer certificationId = cr.getCertificationId();
			CertificationType cert = certDao.selectByPrimaryKey(certificationId);
			if (cert != null) {
				// 查询投标人有没有对应的资质
				CertificationMatchVO matchresult = getSuitableCert(cert, biddercerts);
				if (!matchresult.isMatch()) {
					// nofitcerts.add(matchresult);
					reason.append(cert.getCertificationName());
					reason.append(matchresult.getReason());
					if (iterator.hasNext()) {
						reason.append("，");

					}

				}
			}
		}
		if (reason.length() > 0) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("投标人资质证书不匹配:%s", reason.toString()));
			}
			throw new PaasException(PaasException.ERR_BID_CERTIFICATION_INFO_EXCEPTION,
					"资质要求不能满足:" + reason.toString());
		}
	}

	/**
	 * 匹配证书
	 * 
	 * @param cert
	 * @param biddercerts
	 * @return 投标方资质证书记录主键,如不匹配返回null
	 */
	private CertificationMatchVO getSuitableCert(CertificationType targetcert, List<BidderCertification> biddercerts) {
		if (log.isDebugEnabled()) {
			log.debug(String.format("尝试匹配证书%s", targetcert));
		}
		CertificationMatchVO matchvo = new CertificationMatchVO();
		matchvo.setCertificationTypeId(targetcert.getId());
		for (Iterator iterator = biddercerts.iterator(); iterator.hasNext();) {
			BidderCertification bidderCertification = (BidderCertification) iterator.next();
			CertificationType cert = bidderCertification.getCertificationType();
			if (cert != null) {
				if (targetcert.getId() == cert.getId()) {
					if (log.isDebugEnabled()) {
						log.debug(String.format("证书相同,匹配成功"));
					}
					matchvo.setReason("匹配成功");
					matchvo.setMatch(true);
					matchvo.setBidderCertificationId(bidderCertification.getId());
					return matchvo;
				} else
					if (StringUtils.equals(targetcert.getCertificationGroupname(), cert.getCertificationGroupname())) {

					if (targetcert.getCertificationLevel() >= cert.getCertificationLevel()) {
						// 证书等级匹配
						if (log.isDebugEnabled()) {
							log.debug(String.format("证书等级匹配成功,匹配成功"));
						}
						matchvo.setReason("匹配成功");
						matchvo.setMatch(true);
						matchvo.setBidderCertificationId(bidderCertification.getId());
					} else {
						// 证书等级不对
						if (log.isDebugEnabled()) {
							log.debug(String.format("证书等级匹配失败,匹配失败"));
						}
						matchvo.setReason("证书等级不匹配");
						matchvo.setMatch(false);
					}

					return matchvo;
				} else {
					// 证书不同,先跳过
				}

			}
			// else
			// {
			// if (log.isDebugEnabled()) {
			// log.debug(String.format("招标资质要求的证书,投标人没有"));
			// }
			// }
		}
		if (log.isDebugEnabled()) {
			log.debug(String.format("招标资质要求的证书,投标人没有"));
		}
		matchvo.setReason("缺乏相应资质");
		matchvo.setMatch(false);
		return matchvo;
	}

	/**
	 * 查询未完成的投标资格审查信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public QueryBidRequirementInfoBodyVOResult queryBidRequirementInfo(String appId, QueryBidBodyVO body,
			Integer bidderId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成的投标资格审查信息接口开始");
		}
		BidObject bidObject = objectdao.selectByPrimaryKey(body.getObjectId());
		if (bidObject == null) {
			log.error(String.format("标的[%s]不存在", body.getObjectId()));
			throw ValidateException.ERROR_PARAM_NOTEXIST.clone(null, "标的不存在");
		}
		if (!bidObject.getObjectStatus().equals("PUB")) {
			log.error(String.format("标的[%s]非发布中", body.getObjectId()));
			throw ValidateException.ERROR_PARAM_NOTEXIST.clone(null, "标的状态不正确,目前并非发布中");
		}
		// 查询投标信息
		List<BidRecord> bids = dao.selectUnfinishedBid(bidderId, body.getObjectId());

		BidRecord bid = null;
		if (bids != null && !bids.isEmpty()) {
			bid = bids.get(0);
		}
		QueryBidRequirementInfoBodyVOResult result = new QueryBidRequirementInfoBodyVOResult();
		if (bid == null) {
			result = null;
		} else {

			QueryBidRequirementInfoBodyVOResult_1 result1 = new QueryBidRequirementInfoBodyVOResult_1();
			result1.setSafetyPermitNo(bid.getSafetyPermitNo());
			result1.setSafetyPermitEndDate(getStringFromDateOrNull(bid.getSafetyPermitEndtime()));
			result1.setSafetyPermitUrl(bid.getSafetyPermitUrl());
			result1.setPmSafetyCertificationNo(bid.getPmSafetyCertificationNo());
			result1.setPmSafetyCertificationEndDate(getStringFromDateOrNull(bid.getPmSafetyCertificationEndtime()));
			result1.setPmSafetyCertificationUrl(bid.getPmSafetyCertificationUrl());

			QueryBidRequirementInfoBodyVOResult_2 result2 = new QueryBidRequirementInfoBodyVOResult_2();
			result2.setPmCertificationNo(bid.getPmCertificationNo());
			result2.setPmCertificationEndDate(getStringFromDateOrNull(bid.getPmCertificationEndtime()));
			result2.setPmCertificationUrl(bid.getPmCertificationUrl());
			result2.setConstructorCertificationNo(bid.getConstructorCertificationNo());
			result2.setConstructorCertificationEndDate(
					getStringFromDateOrNull(bid.getConstructorCertificationEndtime()));
			result2.setConstructorCertificationUrl(bid.getConstructorCertificationUrl());

			QueryBidRequirementInfoBodyVOResult_3 result3 = new QueryBidRequirementInfoBodyVOResult_3();
			result3.setBankGuaranteeAmount(
					bid.getBankGuaranteeAmount() == null ? "0" : (String.valueOf(bid.getBankGuaranteeAmount())));
			result3.setBankGuaranteeNo(bid.getBankGuaranteeNo());
			result3.setBankGuaranteeUrl(bid.getBankGuaranteeUrl());
			// 查询投标资质
			List<BidCertification> bclist = bcdao.selectByBidId((body.getBidId()));
			List<Integer> bcilist = new ArrayList<>();
			for (Iterator iterator = bclist.iterator(); iterator.hasNext();) {
				BidCertification bidCertification = (BidCertification) iterator.next();
				bcilist.add(bidCertification.getBidId());
			}

			result.setBidId(bid.getId());
			result.setBankGuarantee(result3);
			result.setBidPeopleRequirement(result2);
			result.setBidSafetyInfo(result1);
			result.setCertificationList(bcilist);
		}

		if (log.isDebugEnabled()) {
			log.debug("查询未完成的投标资格审查信息接口完成");
		}
		return result;
	}

	/**
	 * 查询投标人基础信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryBidderCompanyInfoBodyVOResult queryBidderCompanyInfo(String appId, QueryBidBodyVO body,
			Bidder bidder) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询投标人基础信息接口开始");
		}
		QueryBidderCompanyInfoBodyVOResult result = new QueryBidderCompanyInfoBodyVOResult();
		result.setBusinessLicenseNum(bidder.getBusinessLicense());
		result.setBusinessLicenseType(bidder.getBusinessLicenseType());
		result.setBusinessLicenseUrl(bidder.getBusinessLicenseUrl());
		result.setCompanyName(bidder.getCompanyName());
		result.setNewBusinessLicenseNum(bidder.getUnifiedSocialCreditCode());
		result.setNewBusinessLicenseUrl(bidder.getUnifiedSocialCreditCodeUrl());
		result.setOrganizationCodeNum(bidder.getOrgCodeCertificate());
		result.setOrganizationCodeUrl(bidder.getOrgCodeCertificateUrl());
		result.setTaxRegistrationNum(bidder.getTaxRegistrationCertificate());
		result.setTaxRegistrationUrl(bidder.getTaxRegistrationCertificateUrl());
		if (log.isDebugEnabled()) {
			log.debug("查询投标人基础信息接口完成");
		}
		return result;
	}
	
	/**
	 * 投标方给招标方评价接口
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public void evaluateBiddee(String appId,EvaluateBiddeeBodyVO body,Bidder bidder) throws BusinessException{
		if(log.isDebugEnabled()){
				log.debug("投标方给招标方评价接口开始");
		}
		String objectId = body.getObjectId();
		BidObject bidObject = objectdao.selectByPrimaryKey(objectId);
		if(bidObject==null){
			log.error( "标的不存在:"+objectId);
			throw ValidateException.ERROR_PARAM_NULL.clone(null, "标的不存在:");
		}
		if(StringUtils.equals(bidObject.getObjectStatus(),"END")){
			log.error( "标的未结束:"+objectId);
			throw new PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION, "标的未结束");
		}
		List<ProjectInfo> projects = projectInfoDao.selectByObjectId(objectId);
		if(org.apache.commons.collections.CollectionUtils.isEmpty(projects)){
			log.error( "标的工程不存在:"+objectId);
			throw new PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION, "标的工程不存在");
		}
		ProjectInfo project=projects.get(0);
//		if(project==null){
//			if(log.isDebugEnabled()){
//				log.debug(String.format("根据项目编号【%s】查询项目信息失败", body.getObjectId()));
//			}
//			throw new PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION,String.format("根据项目编号【%s】查询项目信息失败", body.getObjectId()));
//		}
		ProjectEvaluationBidder evaluationBidder=new ProjectEvaluationBidder();
		evaluationBidder.setStarCount(0);
		evaluationBidder.setBiddeeId(project.getBiddeeId());
		evaluationBidder.setBidderId(project.getBidderId());
		evaluationBidder.setEvaluationContent(body.getEvaluateContent());
		evaluationBidder.setInsertBy(bidder.getUserId().toString());
		evaluationBidder.setInsertTime(new Date());
		evaluationBidder.setProjectId(project.getProjectId());
		evaluationBidder.setScore(body.getEvaluateScore());
//		evaluationBidder.setStarCount(evaluationBidder.getStarCount());
		evaluationBidderDao.insert(evaluationBidder);
		//标签部分缺少  add by YJY 2015年12月1日15:35:35 插入标签
		//调用接口时,如果数据库失败,这个标签也会保存进去
		if(body.getTags()!=null){
			for(String tag : body.getTags()){
				CallInterfaceUtil.addTag(tag, "0", "evaluation_manager", "t_ztgl_object_project_info", body.getObjectId());
			}
		}
		if(log.isDebugEnabled()){
				log.debug("投标方给招标方评价接口完成");
		}
	}
	
	
	/**
	 * 查询未完成的投标信息(投标附件)
	 * @param appId
	 * @param body
	 * @param id
	 * @return
	 * @throws DataInvalidException 
	 */
	public SubmitBidBodyVO queryBidSubmit(String appId, QueryBidBodyVO body, Integer bidderId) throws DataInvalidException{
		if (log.isDebugEnabled()) {
			log.debug("查询未完成的投标信息(投标附件)开始");
		}
		BidObject object = null;
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), bidderId, object);
		//添加附件
		SubmitBidBodyVO result = new SubmitBidBodyVO();
		List<BidAttachment> selectBidFile = baDao.selectBidFile(body.getBidId());
		if(CollectionUtils.isNotEmpty(selectBidFile))
		{
			for (Iterator iterator = selectBidFile.iterator(); iterator.hasNext();) {
				BidAttachment bidAttachment = (BidAttachment) iterator.next();
				result.setBidFile(bidAttachment.getAttachmentUrl());
				break;
			}
		}
		result.setBidId(body.getBidId());
		result.setObjectId(body.getObjectId());

		if (log.isDebugEnabled()) {
			log.debug("查询未完成的投标信息(投标附件)完成");
		}
		return result;
	}

}