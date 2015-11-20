package com.hummingbird.paas.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.commonbiz.util.NoGenerationUtil;
import com.hummingbird.paas.constant.OrderConst;
import com.hummingbird.paas.entity.BidCertification;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.BiddeeCredit;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.CertificationRequirement;
import com.hummingbird.paas.entity.MakeMatchBondRecord;
import com.hummingbird.paas.entity.ObjectBaseinfo;
import com.hummingbird.paas.entity.ObjectProject;
import com.hummingbird.paas.entity.ProjectInfos;
import com.hummingbird.paas.entity.Qanda;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.BidCertificationMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.mapper.BiddeeCreditMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.CertificationRequirementMapper;
import com.hummingbird.paas.mapper.FeeRateMapper;
import com.hummingbird.paas.mapper.MakeMatchBondRecordMapper;
import com.hummingbird.paas.mapper.ObjectBaseinfoMapper;
import com.hummingbird.paas.mapper.ObjectBondRecordMapper;
import com.hummingbird.paas.mapper.ObjectMapper;
import com.hummingbird.paas.mapper.ObjectProjectMapper;
import com.hummingbird.paas.mapper.ProjectInfosMapper;
import com.hummingbird.paas.mapper.QandaMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.services.BidService;
import com.hummingbird.paas.util.AccountGenerationUtil;
import com.hummingbird.paas.util.MoneyUtil;
import com.hummingbird.paas.vo.DetailVO;
import com.hummingbird.paas.vo.FreezeBondReturnVO;
import com.hummingbird.paas.vo.QueryBidBodyVO;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult_1;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult_2;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult_3;
import com.hummingbird.paas.vo.QueryBidderBondBodyVOResult;
import com.hummingbird.paas.vo.QueryBusinessStandardInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryMakeMatchBidderBondBodyVOResult;
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
	@Autowired
	ObjectBondRecordMapper obrDao;
	@Autowired
	MakeMatchBondRecordMapper mmbrDao;
	@Autowired
	FeeRateMapper frDao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public Boolean queryTender(Token token) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("接口查询用户是否具有投标的资质进入");
		}
		Integer userId = token.getUserId();
		if (userId == null) {
			return false;
		}
		Bidder bidder = berDao.selectByUserId(userId);
		if (bidder == null) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户[%s]没有进行投标人资格认证",userId));
			}
			return false;
		}
		if (!CommonStatusConst.STATUS_OK.equals(bidder.getStatus())) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户[%s]投标人信息状态不对",userId));
			}
			return false;
		}
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public List<QueryObjectListResultVO> queryObjectList(Integer pageIndex, Integer pageSize) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询招标的项目列表");
		}
		List<QueryObjectListResultVO> qors = new ArrayList<QueryObjectListResultVO>();
		QueryObjectListResultVO qol = null;
		if (pageIndex == null || pageIndex <= 0 || pageSize == null || pageSize <= 0) {
			return null;
		}

		List<ObjectProject> pjs = obDao.getPages((pageIndex - 1) * pageSize, pageSize);
		for (ObjectProject pj : pjs) {
			qol = new QueryObjectListResultVO();
			if (pj.getEvaluationAmount() != null)
				qol.setEvaluationAmount(pj.getEvaluationAmount().toString());
			ProjectInfos proj = pIDao.selectByPrimaryKey(pj.getObjectId());
			if (proj != null && proj.getProjectExpectStartDate() != null)
				qol.setObjectPredictStartTime(proj.getProjectExpectStartDate());
			qol.setObjectId(pj.getObjectId());
			qol.setObjetName(pj.getObjectName());
			qol.setProjectExpectPeriod(pj.getProjectExpectPeriod());
			if (pj.getBiddeeId() != null) {
				Integer biddeeId = pj.getBiddeeId();
				Biddee dee = beeDao.selectByPrimaryKey(biddeeId);
				if (dee == null) {
					continue;
				}
				qol.setCompanyShortName(dee.getCompanyName());
				BiddeeCredit bc = bcDao.selectByPrimaryKey(biddeeId);
				if (bc == null) {
					continue;
				}
				if (bc != null) {
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
			if (log.isDebugEnabled()) {
				log.debug("查询招标的项目列表完成:" + qol);
			}
			qors.add(qol);

		}
		return qors;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public QueryObjectDetailResultVO queryObjectDetail(QueryObjectDetailBodyVO body) throws BusinessException {
		if (log.isDebugEnabled()) {
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
			if (ob.getProjectExpectPeriod() != null)
				sv.setProjectExpectPeriod(ob.getProjectExpectPeriod().toString());
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
		/*
		 * qodbevti.setBidEvalutionSite(ob.getBidEvaluationSite());
		 * qodbevti.setBidEvalutionType(ob.getBidEvaluationType());
		 * qodbevti.setBidWinnerDatemineWay(ob.getBidWinnerDetermineWay());
		 * qodbevti.setVoteWinWay(ob.getVoteWinWay());
		 */
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
		ProjectInfos pi = new ProjectInfos();
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
			qoddri.setAnnouncementBeginTime(qoddri.getAnnouncementBeginTime());
			qoddri.setAnnouncementEndTime(qoddri.getAnnouncementEndTime());
			qoddri.setBiddingEndTime(qoddri.getBiddingEndTime());
			qoddri.setBidOpenDate(qoddri.getBidOpenDate());
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
		ProjectInfos pin = new ProjectInfos();
		pin = pIDao.selectByPrimaryKey(objectId);
		if (pin != null) {
			qodop.setEmployer(pin.getEmployer());
			qodop.setEmployerPrincipal(pin.getEmployerPrincipal());
			qodop.setProjectExpectInvestment(pin.getProjectExpectInvestment());
			qodop.setProjectName(pin.getProjectName());
			qodop.setProjectScale(pin.getProjectScale());
			qodop.setProjectSite(pin.getProjectSite());
		}
		dv.setProjectInfo(qodop);
		QueryObjectDetailProjectRequirementInfo qodpr = new QueryObjectDetailProjectRequirementInfo();
		if (pin != null) {
			qodpr.setProjectExpectPeriod(pin.getProjectExpectPeriod());
			qodpr.setProjectExpectStartDate(pin.getProjectExpectStartDate());
		}
		dv.setProjectRequirementInfo(qodpr);
		qodr.setDetail(dv);
		if (log.isDebugEnabled()) {
			log.debug("查询招标项目详情完成:" + qodr);
		}
		return qodr;
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
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), bidderId);

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
		result2.setConstructorCertificationEndDate(getStringFromDateOrNull(bid.getConstructorCertificationEndtime()));
		result2.setConstructorCertificationUrl(bid.getConstructorCertificationUrl());

		QueryBidRequirementInfoBodyVOResult_3 result3 = new QueryBidRequirementInfoBodyVOResult_3();
		result3.setBankGuaranteeAmount(
				bid.getBankGuaranteeAmount() == null ? "0" : (String.valueOf(bid.getBankGuaranteeAmount() / 100)));
		result3.setBankGuaranteeNo(bid.getBankGuaranteeNo());
		result3.setBankGuaranteeUrl(bid.getBankGuaranteeUrl());
		// 查询投标资质
		List<BidCertification> bclist = bcdao.selectByBidId((body.getBidId()));
		List<Integer> bcilist = new ArrayList<>();
		for (Iterator iterator = bclist.iterator(); iterator.hasNext();) {
			BidCertification bidCertification = (BidCertification) iterator.next();
			bcilist.add(bidCertification.getBidId());
		}
		QueryBidRequirementInfoBodyVOResult result = new QueryBidRequirementInfoBodyVOResult();
		result.setBankGuarantee(result3);
		result.setBidPeopleRequirement(result2);
		result.setBidSafetyInfo(result1);
		result.setCertificationList(bcilist);

		if (log.isDebugEnabled()) {
			log.debug("查询未完成的投标资格审查信息接口完成");
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
		BidRecord bid = dao.selectByPrimaryKey((body.getBidId()));
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
			bid.setBidAmount(0);
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
		bcdao.deleteByBidId((body.getBidId()));
		List<SaveBidRequirementInfoBodyVO_4> certificationList = body.getCertificationList();
		for (Iterator iterator = certificationList.iterator(); iterator.hasNext();) {
			SaveBidRequirementInfoBodyVO_4 bidCertificationReq = (SaveBidRequirementInfoBodyVO_4) iterator.next();
			BidCertification bc = new BidCertification();
			bc.setBidId((body.getBidId()));
			bc.setObjReqId(bidCertificationReq.getObjReqId());
			bc.setBidderCertificationId(bidCertificationReq.getBidderCertificationId());
			bcdao.insert(bc);
		}
		if (isadd) {
			dao.insert(bid);
		} else {
			dao.updateByPrimaryKey(bid);
		}

		// 请自行调整
		if (log.isDebugEnabled()) {
			log.debug("保存投标资格审查信息接口完成");
		}
		return bid;
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
		result.setBidAmount(MoneyUtil.getMoneyStringDecimal4yuan(bid.getBidAmount()));
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
		bid.setBidAmount(NumberUtils.toInt(body.getBidAmount()));
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
		Integer bidBondAmount = object.getBidBondAmount();
		result.setBankGuaranteeAmount(MoneyUtil.getMoneyStringDecimal4yuan(bid.getBankGuaranteeAmount()));
		result.setBankGuaranteeNo(bid.getBankGuaranteeNo());
		result.setBankGuaranteeUrl(bid.getBankGuaranteeUrl());
		result.setBidBondAmount(MoneyUtil.getMoneyStringDecimal4yuan(bidBondAmount));
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
			Integer bondmoney = frDao.selectMoney(object.getEvaluationAmount(), "BZJ");
			if (bondmoney == null) {
				log.error(String.format("无法找到合适的撮合保证金,费率表没有对应的设置,金额为%s分", object.getEvaluationAmount()));
				throw ValidateException.ERROR_PARAM_NULL.clone(null, "无法找到合适的撮合保证金");
			}
			result.setMakeMatchBidderBondAmount(MoneyUtil.getMoneyStringDecimal4yuan(bondmoney));
			// 检查投标人的可用余额,远程访问用户资金帐户
			// TODO 改为访问用户资金帐户
			Integer remainingsum = 30000000;
			if (remainingsum >= bondmoney) {
				result.setSatisfy("ENH");
			} else {
				result.setSatisfy("NEN");
			}
		} else {
			result.setMakeMatchBidderBondAmount(MoneyUtil.getMoneyStringDecimal4yuan(mmbond.getBondAmount()));
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
			// 调用用户资金接口,记录用户资金
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
	public FreezeBondReturnVO unfreezeMakeMatchBidderBond(UnfreezeBondVO body, Bidder bidder,
			String method) throws BusinessException {
		// TODO Auto-generated method stub
		
		//根据orderId查询原来的订单信息
		MakeMatchBondRecord oldActOrd=mmbrDao.selectByPrimaryKey(body.getOrderId());
		if(oldActOrd==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("根据订单号【%s】查询不到原来的订单信息",body.getOrderId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据订单号【%s】查询不到原来的订单信息",body.getOrderId()));
			
		}
		BidObject object = null;
		BidRecord bid = validateBid(oldActOrd.getBidId(), oldActOrd.getObjectId(), bidder.getId(), object);
		
		List<MakeMatchBondRecord> returnActOrds=mmbrDao.selectReturnByBidId(oldActOrd.getBidId());
		if(returnActOrds.size()>0){
			if (log.isDebugEnabled()) {
				log.debug(String.format("投标订单号【%s】已经退还过撮合保证金，无法再次退还",oldActOrd.getBidId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("投标订单号【%s】已经退还过撮合保证金，无法再次退还",oldActOrd.getBidId()));		
		}
		
		//创建保证金订单
		Integer objectBond=oldActOrd.getBondAmount();
		//创建解冻撮合担保金订单
		MakeMatchBondRecord bondRecord=new MakeMatchBondRecord();
		String bondorderId=AccountGenerationUtil.genNO("BZ00");
		bondRecord.setOrderId(bondorderId);
		bondRecord.setUpdateTime(new Date());
		bondRecord.setBidId(oldActOrd.getBidId());
		bondRecord.setCreator(String.valueOf(bidder.getUserId()));
		bondRecord.setInsertTime(new Date());
		bondRecord.setObjectId(oldActOrd.getObjectId());
		bondRecord.setBondAmount(objectBond);
		bondRecord.setStatus("REV");
		mmbrDao.insert(bondRecord);
		// 调用用户资金接口,记录用户资金
		//组装返回信息
		FreezeBondReturnVO bond=new FreezeBondReturnVO();
		/*bond.setAccountId(account.getAccountId());
		bond.setAmount(objectBond.toString());
		bond.setBalance(balance.toString());
		bond.setFlowDirection("IN#");
		bond.setFlowDirection(OrderConst.FLOW_DIRECTION_IN);
		bond.setOrderId(accountOrderId);
		bond.setRemark("退还保证金");
				
		bond.setType("REV");*/
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
	public void submitBid(String appId, QueryBidBodyVO body, Bidder bidder) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("提交投标接口开始");
		}
		BidObject object = null;
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), bidder.getId(), object);
		bid.setStatus(CommonStatusConst.STATUS_OK);
		
		dao.updateByPrimaryKey(bid);

		if (log.isDebugEnabled()) {
			log.debug("提交投标接口完成");
		}
	}

	

}