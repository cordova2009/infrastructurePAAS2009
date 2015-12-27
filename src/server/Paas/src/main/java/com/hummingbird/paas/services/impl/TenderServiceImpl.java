package com.hummingbird.paas.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.keyvalue.DefaultKeyValue;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.RequestException;
import com.hummingbird.common.exception.SignatureException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.MapMaker;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.util.http.HttpRequester;
import com.hummingbird.commonbiz.util.NoGenerationUtil;
import com.hummingbird.commonbiz.util.TransOrderBuilder;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.BidCertification;
import com.hummingbird.paas.entity.BidInviteBidder;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.CertificationType;
import com.hummingbird.paas.entity.Industry;
import com.hummingbird.paas.entity.MakeMatchBondRecord;
import com.hummingbird.paas.entity.MemberBiddee;
import com.hummingbird.paas.entity.MemberBidder;
import com.hummingbird.paas.entity.ObjectAttachment;
import com.hummingbird.paas.entity.ObjectBaseinfo;
import com.hummingbird.paas.entity.ObjectCertificationRequirement;
import com.hummingbird.paas.entity.ObjectProjectInfo;
import com.hummingbird.paas.entity.Project;
import com.hummingbird.paas.entity.ProjectEvaluationBiddee;
import com.hummingbird.paas.entity.ProjectEvaluationBidder;
import com.hummingbird.paas.entity.ProjectInfo;
import com.hummingbird.paas.entity.ProjectInfos;
import com.hummingbird.paas.entity.ProjectPaymentDefine;
import com.hummingbird.paas.entity.ProjectPaymentDefineDetail;
import com.hummingbird.paas.entity.Qanda;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.event.InvBidEvent;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.mapper.BidCertificationMapper;
import com.hummingbird.paas.mapper.BidEvaluationMapper;
import com.hummingbird.paas.mapper.BidInviteBidderMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.BidderRecommendMapper;
import com.hummingbird.paas.mapper.CertificationTypeMapper;
import com.hummingbird.paas.mapper.IndustryMapper;
import com.hummingbird.paas.mapper.MakeMatchBondRecordMapper;
import com.hummingbird.paas.mapper.MemberBiddeeMapper;
import com.hummingbird.paas.mapper.MemberBidderMapper;
import com.hummingbird.paas.mapper.ObjectAttachmentMapper;
import com.hummingbird.paas.mapper.ObjectBaseinfoMapper;
import com.hummingbird.paas.mapper.ObjectBondSettingMapper;
import com.hummingbird.paas.mapper.ObjectCertificationRequirementMapper;
import com.hummingbird.paas.mapper.ObjectProjectInfoMapper;
import com.hummingbird.paas.mapper.ProjectEvaluationBiddeeMapper;
import com.hummingbird.paas.mapper.ProjectEvaluationBidderMapper;
import com.hummingbird.paas.mapper.ProjectInfoMapper;
import com.hummingbird.paas.mapper.ProjectPaymentDefineDetailMapper;
import com.hummingbird.paas.mapper.ProjectPaymentDefineMapper;
import com.hummingbird.paas.mapper.ProjectPaymentPayMapper;
import com.hummingbird.paas.mapper.QandaMapper;
import com.hummingbird.paas.mapper.UserInformationMapper;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.util.CallInterfaceUtil;
import com.hummingbird.paas.vo.AbstractBidFileTypeInfo;
import com.hummingbird.paas.vo.CapitalOrderReturnVO;
import com.hummingbird.paas.vo.CompanyBaseInfo;
import com.hummingbird.paas.vo.CompanyBidInfo;
import com.hummingbird.paas.vo.CompanyCerticateInfo;
import com.hummingbird.paas.vo.CompanyEvaluationDetailInfo;
import com.hummingbird.paas.vo.CompanyEvaluationInfo;
import com.hummingbird.paas.vo.CompanyInfo;
import com.hummingbird.paas.vo.CompanySurvey;
import com.hummingbird.paas.vo.EvaluateBidderBodyVO;
import com.hummingbird.paas.vo.GetIndustryDetailBodyVO;
import com.hummingbird.paas.vo.GetIndustryListBodyVOResult;
import com.hummingbird.paas.vo.InviteTenderVO;
import com.hummingbird.paas.vo.JsonResult;
import com.hummingbird.paas.vo.JsonResultMsg;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyTenderObjectListVO;
import com.hummingbird.paas.vo.QueryAnswerMethodInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidEvaluationTypeInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidFileTypeInfoResult;
import com.hummingbird.paas.vo.QueryBidIndexListResult;
import com.hummingbird.paas.vo.QueryBidIndexSurveyResult;
import com.hummingbird.paas.vo.QueryBidderListHomepageResultVO;
import com.hummingbird.paas.vo.QueryBidderListResultVO;
import com.hummingbird.paas.vo.QueryCertificateListBodyVO;
import com.hummingbird.paas.vo.QueryCertificateListResultBodyVO;
import com.hummingbird.paas.vo.QueryCertificateListResultVO;
import com.hummingbird.paas.vo.QueryCompanyInfoBodyVO;
import com.hummingbird.paas.vo.QueryDateRequirementInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryIndexBidListResultVO;
import com.hummingbird.paas.vo.QueryIndexObjectListResult;
import com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectBondInfoResult;
import com.hummingbird.paas.vo.QueryObjectCertificationInfoResult;
import com.hummingbird.paas.vo.QueryObjectConstructionInfoResult;
import com.hummingbird.paas.vo.QueryObjectMethodInfoResult;
import com.hummingbird.paas.vo.QueryObjectProjectInfoResult;
import com.hummingbird.paas.vo.QueryProjectSurveyResultVO;
import com.hummingbird.paas.vo.SaveAnswerMethodInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidEvaluationTypeInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidEvalutionResultVO;
import com.hummingbird.paas.vo.SaveBidFileTypeInfo;
import com.hummingbird.paas.vo.SaveDateRequirementInfoBodyVO;
import com.hummingbird.paas.vo.SaveObjectBaseInfo;
import com.hummingbird.paas.vo.SaveObjectBondInfo;
import com.hummingbird.paas.vo.SaveObjectCertificationInfo;
import com.hummingbird.paas.vo.SaveObjectConstructionInfo;
import com.hummingbird.paas.vo.SaveObjectMethodInfo;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVO;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVOResult;
import com.hummingbird.paas.vo.SaveProjectRequirementInfoBodyVO;
import com.hummingbird.paas.vo.SelectBidWinMakeMatchBondRewardReturnBodyVO;
import com.hummingbird.paas.vo.SelectBidWinMakeMatchBondRewardReturnVO;
import com.hummingbird.paas.vo.TagInfo;
import com.hummingbird.paas.vo.TenderCertificationReturnVO;
import com.hummingbird.paas.vo.TenderMyBuildingObjectVO;
import com.hummingbird.paas.vo.TenderMyEndedObjectVO;
import com.hummingbird.paas.vo.TenderMyObjectBidReturnVO;
import com.hummingbird.paas.vo.TenderMyObjectBidReturnWithCertificationVO;
import com.hummingbird.paas.vo.TenderObjectBodyVO;
import com.hummingbird.paas.vo.TenderObjectListReturnVO;
import com.hummingbird.paas.vo.TenderPaymentDetailInfo;
import com.hummingbird.paas.vo.TenderPaymentInfo;
import com.hummingbird.paas.vo.TenderSurveyReturnVO;

/**
 * @author
 * @date 2015-11-08
 * @version 1.0 service接口实现
 */
@Service
public class TenderServiceImpl implements TenderService {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	IndustryMapper indDao;
	@Autowired
	BidObjectMapper dao;
	@Autowired
	TokenService tokenSrv;
	@Autowired
	ObjectProjectInfoMapper bpdao;
	@Autowired
	BidRecordMapper bidRecordDao;
	@Autowired
	ObjectCertificationRequirementMapper ocrDao;
	@Autowired
	ObjectBondSettingMapper obsDao;
	@Autowired
	ObjectAttachmentMapper oaDao;
	@Autowired
	BidInviteBidderMapper bibDao;
	@Autowired
	QandaMapper qaDao;
	@Autowired
	ObjectBaseinfoMapper obiDao;
	@Autowired
	CertificationTypeMapper ctDao;
	@Autowired
	BidderMapper berDao;
	@Autowired
	BidderRecommendMapper bidderRecDao;
	@Autowired
	ProjectInfoMapper projectInfoDao;
	@Autowired
	ProjectEvaluationBiddeeMapper evaluationBiddeeDao;
	@Autowired
	ProjectEvaluationBidderMapper evaluationBidderDao;
	@Autowired
	BiddeeMapper beDao;  //ProjectPaymentPayMapper
	@Autowired
	ProjectPaymentPayMapper pppDao;
	@Autowired
	BidCertificationMapper bcDao;
	@Autowired
	UserMapper userDao;
	@Autowired
	protected ProjectPaymentDefineMapper projectPaymentDefineDao;
	@Autowired
	protected ProjectPaymentDefineDetailMapper projectPaymentDefineDetailDao;
	@Autowired
	protected BidEvaluationMapper bidevaDao;
	@Autowired
	protected MakeMatchBondRecordMapper mmbondDao;
	@Autowired
	protected UserInformationMapper userInformationMapper;
	@Autowired
	protected MemberBiddeeMapper biddeeMembeeDao;
	@Autowired
	protected MemberBidderMapper biddeeMemberDao;
	

	/**
	 * 我的招标评标概况接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public TenderSurveyReturnVO queryMyObjectTenderSurvey(String appId, MyObjectTenderSurveyBodyVO body,
			Biddee biddee) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("我的招标评标概况接口开始");
		}
		
		TenderSurveyReturnVO selectTenderSurvey2selectByObjectId = bidRecordDao.selectTenderSurvey2selectByObjectId(body.getObjectId());
		
		return selectTenderSurvey2selectByObjectId;
	}

	/**
	 * 查询未完成招标项目基础信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryObjectBaseInfoBodyVOResult queryObjectBaseInfo(String appId, QueryObjectBodyVO body, Biddee biddee)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目基础信息接口开始");
		}
		BidObject object = null;
		List<BidObject> objs = dao.selectUnfinishObject(biddee.getId(), body.getObjectId());
		if (objs != null && !objs.isEmpty()) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("查询招标方[%s]下有%s个未完成任务", biddee.getId(), objs.size()));
			}
			object = objs.get(0);

		} else {
			if (log.isDebugEnabled()) {
				log.debug(String.format("招标方[%s]没有待完成的招标信息", biddee.getId()));
			}
			return null;
		}
		QueryObjectBaseInfoBodyVOResult result = new QueryObjectBaseInfoBodyVOResult();
		result.setObjectId(object.getObjectId());
		result.setObjectName(object.getObjectName());
		result.setBiddingNo(object.getObjectNo());
		result.setObjectScope(object.getObjectScope());
		result.setBiddeeCompanyPrincipal(object.getBiddeeCompanyPrincipal());
		result.setBiddeeCompanyTelephone(object.getBiddeeCompanyTelephone());
		result.setCurrency(object.getCurrency());
		result.setContractType(object.getContractType());
		result.setEvaluationAmount(ObjectUtils.toString(object.getEvaluationAmount()));
		result.setEvaluationAmountVisiable(object.getEvaluationAmountVisiable());

		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目基础信息接口完成");
		}
		return result;
	}

	/**
	 * 保存招标项目基础信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return 招标编号
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public String saveObjectBaseInfo(String appId, SaveObjectBaseInfo body, Integer biddeeId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目基础信息接口开始");
		}
		BidObject bo = null;
		if (StringUtils.isBlank(body.getObjectId())) {
			// 查询有没有未完成的
			List<BidObject> selectUnfinishObject = dao.selectUnfinishObject(biddeeId, null);
			if (selectUnfinishObject != null && !selectUnfinishObject.isEmpty()) {
				bo = selectUnfinishObject.get(0);
			}
		} else {

			bo = dao.selectByPrimaryKey(body.getObjectId());
			if (bo != null) {
				// 检查编号是否存在
				ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
			}
		}

		if (bo == null) {
			bo = new BidObject();

			if (StringUtils.isNotBlank(body.getObjectId())) {
				bo.setObjectId(body.getObjectId());
			} else {

				bo.setObjectId(NoGenerationUtil.genNO("ZB00", 6));
			}
			bo.setBiddeeId(biddeeId);
			bo.setObjectName(body.getObjectName());
			bo.setObjectName(body.getObjectName());
			// bo.setIndustryId(body.getIndustryId());
			bo.setObjectNo(body.getBiddingNo());
			bo.setObjectScope(body.getObjectScope());
			bo.setBiddeeCompanyPrincipal(body.getBiddeeCompanyPrincipal());
			bo.setBiddeeCompanyTelephone(body.getBiddeeCompanyTelephone());
			bo.setCurrency(body.getCurrency());
			bo.setContractType(body.getContractType());
			bo.setEvaluationAmount(body.getEvaluationAmount());
			if(bo.getObjectAmount()==null)
				bo.setObjectAmount(0l);
			if(bo.getBidBondAmount()==null)
				bo.setBidBondAmount(0l);
			bo.setObjectStatus(CommonStatusConst.STATUS_CREATE);
			bo.setEvaluationAmountVisiable(StringUtils.defaultIfEmpty(body.getEvaluationAmountVisiable(), "ENB"));
			bo.setInsertTime(new Date());

			dao.insert(bo);
		} else {
			bo.setBiddeeId(biddeeId);
			bo.setObjectName(body.getObjectName());
			bo.setObjectName(body.getObjectName());
			// bo.setIndustryId(body.getIndustryId());
			bo.setObjectNo(body.getBiddingNo());
			bo.setObjectScope(body.getObjectScope());
			bo.setBiddeeCompanyPrincipal(body.getBiddeeCompanyPrincipal());
			bo.setBiddeeCompanyTelephone(body.getBiddeeCompanyTelephone());
			bo.setCurrency(body.getCurrency());
			bo.setContractType(body.getContractType());
			bo.setEvaluationAmount(body.getEvaluationAmount());
			if(bo.getObjectAmount()==null)
				bo.setObjectAmount(0l);
			if(bo.getBidBondAmount()==null)
				bo.setBidBondAmount(0l);
			bo.setEvaluationAmountVisiable(StringUtils.defaultIfEmpty(body.getEvaluationAmountVisiable(), "ENB"));
			dao.updateByPrimaryKey(bo);
		}
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目基础信息接口完成");
		}
		return bo.getObjectId();
	}

	/**
	 * 查询未完成招标项目工程信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryObjectProjectInfoResult queryObjectProjectInfo(String appId, QueryObjectBodyVO body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目工程信息接口开始");
		}
		// 请自行调整
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ObjectProjectInfo bidproject = null;
		List<ObjectProjectInfo> projects = bpdao.selectProjects(biddeeId, body.getObjectId(),
				CommonStatusConst.STATUS_CREATE);
		if (projects != null && !projects.isEmpty()) {
			bidproject = projects.get(0);
		}
		QueryObjectProjectInfoResult result = null;
		if (bidproject != null) {
			result = new QueryObjectProjectInfoResult();
			result.setEmployer(bidproject.getEmployer());
			result.setProjectName(bidproject.getProjectName());
			result.setProjectSite(bidproject.getProjectSite());
			result.setProjectScale(bidproject.getProjectScale());
			result.setProjectExpectInvestment(bidproject.getProjectExpectInvestment());
			result.setEmployer(bidproject.getEmployer());
			result.setEmployerPrincipal(bidproject.getEmployerPrincipal());
			result.setEmployerTelephone(bidproject.getEmployerTelephone());
			result.setIndustryId(bo.getIndustryId());
		}
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目工程信息接口完成");
		}
		return result;
	}

	/**
	 * 保存招标项目工程信息接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveObjectProjectInfo(String appId, int userId, SaveObjectProjectInfoBodyVO body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程信息接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		ObjectProjectInfo bp = bpdao.selectByPrimaryKey(body.getObjectId());
		if (bp == null) {
			bp = new ObjectProjectInfo();

			bp.setObjectId(bo.getObjectId());
			bp.setProjectName(body.getProjectName());
			bp.setProjectSite(body.getProjectSite());
			bp.setProjectScale(body.getProjectScale());
			bp.setProjectExpectInvestment(body.getProjectExpectInvestment());
			bp.setEmployer(body.getEmployer());
			bp.setEmployerPrincipal(body.getEmployerPrincipal());
			bp.setEmployerTelephone(body.getEmployerTelephone());
			bpdao.insert(bp);
		} else {

			bp.setProjectName(body.getProjectName());
			bp.setProjectSite(body.getProjectSite());
			bp.setProjectScale(body.getProjectScale());
			bp.setProjectExpectInvestment(body.getProjectExpectInvestment());
			bp.setEmployer(body.getEmployer());
			bp.setEmployerPrincipal(body.getEmployerPrincipal());
			bp.setEmployerTelephone(body.getEmployerTelephone());

			bpdao.updateByPrimaryKey(bp);
		}
		bo.setIndustryId(body.getIndustryId());
		dao.updateByPrimaryKey(bo);

		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程信息接口完成");
		}
	}

	/**
	 * 查询未完成招标项目工程要求接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @return
	 * @throws BusinessException
	 */
	public SaveObjectProjectInfoBodyVOResult queryProjectRequirementInfo(String appId, QueryObjectBodyVO body,
			Integer biddeeId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目工程要求接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		// 请自行调整
		ObjectProjectInfo bidproject = null;
		List<ObjectProjectInfo> projects = bpdao.selectProjects(biddeeId, body.getObjectId(),
				CommonStatusConst.STATUS_CREATE);
		if (projects != null && !projects.isEmpty()) {
			bidproject = projects.get(0);
		}
		ObjectProjectInfo bpi = bidproject;
		SaveObjectProjectInfoBodyVOResult result = null;
		if (bpi != null) {
			result = new SaveObjectProjectInfoBodyVOResult();
			result.setProjectExpectPeriod(bpi.getProjectExpectPeriod());
			result.setProjectExpectStartDate(bpi.getProjectExpectStartDate());
		}

		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目工程要求接口完成");
		}
		return result;
	}

	/**
	 * 保存招标项目工程施工证明接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveProjectRequirementInfo(String appId, SaveProjectRequirementInfoBodyVO body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程施工证明接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		// 请自行调整
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		ObjectProjectInfo bpi = bpdao.selectByPrimaryKey(body.getObjectId());
		if (bpi == null) {
			bpi = new ObjectProjectInfo();
			bpi.setProjectExpectPeriod(body.getProjectExpectPeriod());
			bpi.setProjectExpectStartDate(body.getProjectExpectStartDate());
			bpi.setObjectId(body.getObjectId());
			bpdao.insert(bpi);
		} else {

			bpi.setProjectExpectPeriod(body.getProjectExpectPeriod());
			bpi.setProjectExpectStartDate(body.getProjectExpectStartDate());
			bpdao.updateByPrimaryKey(bpi);
		}
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程施工证明接口完成");
		}

	}

	/**
	 * 查询未完成招标项目工程施工证明接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @return
	 * @throws BusinessException
	 */
	public QueryObjectConstructionInfoResult queryObjectConstructionInfo(String appId, QueryObjectBodyVO body,
			Integer biddeeId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目工程施工证明接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		ObjectProjectInfo bpi = null;
		List<ObjectProjectInfo> projects = bpdao.selectProjects(biddeeId, body.getObjectId(),
				CommonStatusConst.STATUS_CREATE);
		if (projects != null && !projects.isEmpty()) {
			bpi = projects.get(0);
		}
		QueryObjectConstructionInfoResult result = null;
		if (bpi != null) {
			result = new QueryObjectConstructionInfoResult();
			result.setConstructionProveType(bpi.getConstructionProveType());
			result.setLandUseCertificateNo(bpi.getLandUseCertificateNo());
			result.setLandUseCertificateEndDate(bpi.getLandUseCertificateEnddate() == null ? ""
					: DateUtil.format(bpi.getLandUseCertificateEnddate(), "yyyy-MM-dd"));
			result.setLandUseCertificateUrl(bpi.getLandUseCertificateUrl());
			result.setConstructionLandUsePermitNo(bpi.getConstructionLandUsePermitNo());
			result.setConstructionLandUsePermitEndDate(bpi.getConstructionLandUsePermitEnddate() == null ? ""
					: DateUtil.format(bpi.getConstructionLandUsePermitEnddate(), "yyyy-MM-dd"));
			result.setConstructionLandUsePermitUrl(bpi.getConstructionLandUsePermitUrl());
			result.setBuildingPermitNo(bpi.getBuildingPermitNo());
			result.setBuildingPermitEndDate(bpi.getBuildingPermitEnddate() == null ? ""
					: DateUtil.format(bpi.getBuildingPermitEnddate(), "yyyy-MM-dd"));
			result.setBuildingPermitUrl(bpi.getBuildingPermitUrl());
			result.setLetterOfAcceptanceUrl(bpi.getLetterOfAcceptanceUrl());
			result.setBuildingConstructPermitNo(bpi.getBuildingConstructionPermitNo());
			result.setBuildingConstructPermitEndDate(bpi.getBuildingConstructionPermitEnddate() == null ? ""
					: DateUtil.format(bpi.getBuildingConstructionPermitEnddate(), "yyyy-MM-dd"));
			result.setBuildingConstructPermitUrl(bpi.getBuildingConstructionPermitUrl());

		}
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目工程施工证明接口完成");
		}
		return result;
	}

	/**
	 * 保存招标项目工程施工证明接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveObjectConstructionInfo(String appId, SaveObjectConstructionInfo body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程施工证明接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		// 请自行调整
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		ObjectProjectInfo bpi = bpdao.selectByPrimaryKey(body.getObjectId());
		try {
			if (bpi == null) {
				bpi = new ObjectProjectInfo();
				bpi.setConstructionProveType(body.getConstructionProveType());
				bpi.setLandUseCertificateNo(body.getLandUseCertificateNo());
				if (StringUtils.isNotBlank(body.getLandUseCertificateEndDate())) {
					bpi.setLandUseCertificateEnddate(DateUtil.parse(body.getLandUseCertificateEndDate()).getTime());
				}
				bpi.setLandUseCertificateUrl(body.getLandUseCertificateUrl());
				bpi.setConstructionLandUsePermitNo(body.getConstructionLandUsePermitNo());
				if (StringUtils.isNotBlank(body.getConstructionLandUsePermitEndDate())) {

					bpi.setConstructionLandUsePermitEnddate(
							DateUtil.parse(body.getConstructionLandUsePermitEndDate()).getTime());
				}
				bpi.setConstructionLandUsePermitUrl(body.getConstructionLandUsePermitUrl());
				bpi.setBuildingPermitNo(body.getBuildingPermitNo());
				if (StringUtils.isNotBlank(body.getBuildingPermitEndDate())) {

					bpi.setBuildingPermitEnddate(DateUtil.parse(body.getBuildingPermitEndDate()).getTime());
				}
				bpi.setBuildingPermitUrl(body.getBuildingPermitUrl());
				bpi.setLetterOfAcceptanceUrl(body.getLetterOfAcceptanceUrl());
				bpi.setBuildingConstructionPermitNo(body.getBuildingConstructPermitNo());
				if (StringUtils.isNotBlank(body.getBuildingConstructPermitEndDate())) {
					bpi.setBuildingConstructionPermitEnddate(
							DateUtil.parse(body.getBuildingConstructPermitEndDate()).getTime());
				}
				bpi.setBuildingConstructionPermitUrl(body.getBuildingConstructPermitUrl());
				bpi.setObjectId(body.getObjectId());
				bpdao.insert(bpi);
			} else {

				bpi.setConstructionProveType(body.getConstructionProveType());
				bpi.setLandUseCertificateNo(body.getLandUseCertificateNo());
				if (StringUtils.isNotBlank(body.getLandUseCertificateEndDate())) {
					bpi.setLandUseCertificateEnddate(DateUtil.parse(body.getLandUseCertificateEndDate()).getTime());
				}
				bpi.setLandUseCertificateUrl(body.getLandUseCertificateUrl());
				bpi.setConstructionLandUsePermitNo(body.getConstructionLandUsePermitNo());
				if (StringUtils.isNotBlank(body.getConstructionLandUsePermitEndDate())) {
					bpi.setConstructionLandUsePermitEnddate(
							DateUtil.parse(body.getConstructionLandUsePermitEndDate()).getTime());
				}
				bpi.setConstructionLandUsePermitUrl(body.getConstructionLandUsePermitUrl());
				bpi.setBuildingPermitNo(body.getBuildingPermitNo());
				if (StringUtils.isNotBlank(body.getBuildingPermitEndDate())) {
					bpi.setBuildingPermitEnddate(DateUtil.parse(body.getBuildingPermitEndDate()).getTime());
				}
				bpi.setBuildingPermitUrl(body.getBuildingPermitUrl());
				bpi.setLetterOfAcceptanceUrl(body.getLetterOfAcceptanceUrl());
				bpi.setBuildingConstructionPermitNo(body.getBuildingConstructPermitNo());
				if (StringUtils.isNotBlank(body.getBuildingConstructPermitEndDate())) {
					bpi.setBuildingConstructionPermitEnddate(
							DateUtil.parse(body.getBuildingConstructPermitEndDate()).getTime());
				}
				bpi.setBuildingConstructionPermitUrl(body.getBuildingConstructPermitUrl());
				bpdao.updateByPrimaryKey(bpi);
			}
		} catch (ParseException e) {
			log.error(String.format("日期格式处理错误"), e);
			throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e, String.format("日期格式处理错误"));
		}

		// 请自行调整
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程施工证明接口完成");
		}
	}

	/**
	 * 查询未完成招标项目资质要求接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @return
	 * @throws BusinessException
	 */
	public QueryObjectCertificationInfoResult queryObjectCertificationInfo(String appId, QueryObjectBodyVO body,
			Integer biddeeId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目资质要求接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		QueryObjectCertificationInfoResult result = new QueryObjectCertificationInfoResult();
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		result.setNeedConstructorCertification(bo.getNeedConstructorCertification());
		result.setNeedPmCertification(bo.getNeedPmCertification());
		result.setNeedPmSafetyCertification(bo.getNeedPmSafetyCertification());
		result.setNeedSafetyPermit(bo.getNeedSafetyPermit());
		List<Map> certs = new ArrayList();
		List<ObjectCertificationRequirement> certificationInfos = ocrDao.selectCertificationInfos(body.getObjectId(),
				biddeeId, CommonStatusConst.STATUS_CREATE);
		for (Iterator iterator = certificationInfos.iterator(); iterator.hasNext();) {
			ObjectCertificationRequirement objectCertificationRequirement = (ObjectCertificationRequirement) iterator
					.next();
			Map<String, Object> certmap = new HashMap<>();
			certmap.put("certificateId", objectCertificationRequirement.getCertificationId());
			certmap.put("industryId", objectCertificationRequirement.getIndustryId());
			certmap.put("certificateName", objectCertificationRequirement.getCertificationName());
			certs.add(certmap);
		}
		result.setBidderCertification(certs);

		// 请自行调整
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目资质要求接口完成");
		}
		return result;
	}

	/**
	 * 保存招标项目资质要求接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveObjectCertificationInfo(String appId, SaveObjectCertificationInfo body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目资质要求接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		// 请自行调整
		BidObject bo = null;
		List<BidObject> objs = dao.selectUnfinishObject(biddeeId, body.getObjectId());
		if (objs != null && !objs.isEmpty()) {
			bo = objs.get(0);
		}
		ValidateUtil.assertNull(bo, "招标项目不存在");
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		bo.setNeedConstructorCertification(body.getNeedConstructorCertification());
		bo.setNeedPmCertification(body.getNeedPmCertification());
		bo.setNeedPmSafetyCertification(body.getNeedPmSafetyCertification());
		bo.setNeedSafetyPermit(body.getNeedSafetyPermit());

		dao.updateByPrimaryKey(bo);
		// 删除原有数据 ,并重新插入数据
		int deleteByObjectId = ocrDao.deleteByObjectId(body.getObjectId());

		List<Map> bidderCertification = body.getBidderCertification();

		if (bidderCertification != null) {
			for (Iterator iterator = bidderCertification.iterator(); iterator.hasNext();) {
				Map map = (Map) iterator.next();
				ObjectCertificationRequirement objectCertificationRequirement = new ObjectCertificationRequirement();
				objectCertificationRequirement
						.setCertificationId(NumberUtils.toInt(ObjectUtils.toString(map.get("certificateId"))));
				String certificateName = ObjectUtils.toString(map.get("certificateName"));
				if(StringUtils.isBlank(certificateName)){
					//根据id查询资质证书
					CertificationType certificationType = ctDao.selectByPrimaryKey(objectCertificationRequirement.getCertificationId());
					certificateName = certificationType.getCertificationName();
				}
				objectCertificationRequirement.setCertificationName(certificateName);
				objectCertificationRequirement.setIndustryId(ObjectUtils.toString(map.get("industryId")));
				objectCertificationRequirement.setObjectId(bo.getObjectId());
				ocrDao.insert(objectCertificationRequirement);
			}
		}

		// 请自行调整
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目资质要求接口完成");
		}
	}

	/**
	 * 查询未完成招标项目保证金接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryObjectBondInfoResult queryObjectBondInfo(String appId, QueryObjectBodyVO body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目保证金接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		// Integer objectBidderBond =
		// obsDao.getObjectBidderBond(body.getObjectId());

		QueryObjectBondInfoResult result = new QueryObjectBondInfoResult();
		// if (objectBidderBond != null) {
		result.setBidBondAmount(ObjectUtils.toString(bo.getBidBondAmount()));
		// }
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目保证金接口完成");
		}
		return result;
	}

	/**
	 * 保存招标项目保证金接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveObjectBondInfo(String appId, SaveObjectBondInfo body, Integer biddeeId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目保证金接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		bo.setBidBondAmount(body.getBidBondAmount());
		dao.updateByPrimaryKey(bo);
		// ObjectBondSetting ob = obsDao.selectByObjectId(bo.getObjectId());
		// if (ob == null) {
		// ob = new ObjectBondSetting();
		// ob.setObjectId(bo.getObjectId());
		// ob.setBiddeeBond(0l);
		// ob.setBidderBidBond(body.getBidBondAmount());
		// obsDao.insert(ob);
		// } else {
		// ob.setBidderBidBond(body.getBidBondAmount());
		// obsDao.updateByPrimaryKey(ob);
		// }

		if (log.isDebugEnabled()) {
			log.debug("保存招标项目保证金接口完成");
		}
	}

	/**
	 * 查询未完成招标项目投标文件接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryBidFileTypeInfoResult queryBidFileTypeInfo(String appId, QueryObjectBodyVO body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目投标文件接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		QueryBidFileTypeInfoResult result = new QueryBidFileTypeInfoResult();
		result.setNeedBusinessStandard(bo.getNeedBusinessStandard());
		result.setNeedCertificationCheckupFile(bo.getNeedCertificationCheckupFile());
		result.setNeedTechnicalStandard(bo.getNeedTechnicalStandard());
		// 从附件表中查询,如果有多个,则尝试拿名称有标记 TF#,如果没有,则尝试拿 第一个
		List<ObjectAttachment> attachments = oaDao.selectTenderFileByObjectId(bo.getObjectId());
		if (attachments != null && !attachments.isEmpty()) {
			result.setTenderFile(attachments.get(0).getAttachmentUrl());
		}
		// 请自行调整
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目投标文件接口完成");
		}
		return result;

	}

	/**
	 * 保存招标项目投标文件接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveBidFileTypeInfo(String appId, SaveBidFileTypeInfo body, Integer biddeeId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目投标文件接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		if (bo == null) {
			throw ValidateException.ERROR_PARAM_NULL.clone(null, "招标项目不存在");
		}
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		ValidateUtil.assertEmpty(body.getTenderFile(), "招标文件");

		bo.setNeedBusinessStandard(StringUtils.defaultIfEmpty(body.getNeedBusinessStandard(), "NO#"));
		bo.setNeedCertificationCheckupFile(StringUtils.defaultIfEmpty(body.getNeedCertificationCheckupFile(), "NO#"));
		bo.setNeedTechnicalStandard(StringUtils.defaultIfEmpty(body.getNeedTechnicalStandard(), "NO#"));
		dao.updateByPrimaryKey(bo);
		// 删除原来的文件
		List<ObjectAttachment> selctByObjectId = oaDao.selectTenderFileByObjectId(bo.getObjectId());
		for (Iterator iterator = selctByObjectId.iterator(); iterator.hasNext();) {
			ObjectAttachment objectAttachment = (ObjectAttachment) iterator.next();
			oaDao.deleteByPrimaryKey(objectAttachment.getId());
		}
		// 重新添加
		ObjectAttachment objectAttachment = new ObjectAttachment();
		objectAttachment.setObjectId(bo.getObjectId());
		objectAttachment.setInsertTime(new Date());
		objectAttachment.setAttachmentUrl(body.getTenderFile());
		// objectAttachment.getInsertBy();
		objectAttachment.setAttachmentType("TF#");
		oaDao.insert(objectAttachment);
		// 请自行调整
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目投标文件接口完成");
		}
	}

	/**
	 * 查询未完成招标方式接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public QueryObjectMethodInfoResult queryObjectMethodInfo(String appId, QueryObjectBodyVO body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标方式接口开始");
		}
		QueryObjectMethodInfoResult result = null;
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = null;
		List<BidObject> objs = dao.selectUnfinishObject(biddeeId, body.getObjectId());
		if (objs != null && !objs.isEmpty()) {
			bo = objs.get(0);
		}
		ValidateUtil.assertNull(bo, "招标项目不存在");
		result = new QueryObjectMethodInfoResult();
		result.setObjectMethod(bo.getObjectPublishType());
		if ("INV".equals(bo.getObjectPublishType())) {
			// 查询邀请投标
			List<BidInviteBidder> invBidders = bibDao.selectByObjectId(body.getObjectId());
			List list = new ArrayList<>();
			for (Iterator iterator = invBidders.iterator(); iterator.hasNext();) {
				BidInviteBidder bidInviteBidder = (BidInviteBidder) iterator.next();
				Map row = new HashMap<>();
				row.put("bidderId", bidInviteBidder.getBidderId());
				row.put("bidderName", bidInviteBidder.getBidderName());
				list.add(row);
			}
			result.setInviteTender(list);
		}
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标方式接口完成");
		}
		return result;
	}

	/**
	 * saveObjectMethodInfo
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveObjectMethodInfo(String appId, SaveObjectMethodInfo body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("saveObjectMethodInfo开始");
		}
		QueryObjectMethodInfoResult result = null;
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		switch (body.getObjectMethod()) {
		case "PUB":
			bo.setObjectPublishType(body.getObjectMethod());
			bibDao.deleteByObjectId(body.getObjectId());
			break;
		case "INV":
			bo.setObjectPublishType(body.getObjectMethod());
			bibDao.deleteByObjectId(body.getObjectId());
			List<InviteTenderVO> inviteTender = body.getInviteTender();
			if (inviteTender == null || inviteTender.isEmpty()) {
				log.error(String.format("招标[%s]中招标方式设置为邀标,但没有设置投标人", body.getObjectId()));
			}
			for (Iterator iterator = inviteTender.iterator(); iterator.hasNext();) {
				InviteTenderVO inviteTenderVO = (InviteTenderVO) iterator.next();
				BidInviteBidder bidInviteBidder = new BidInviteBidder();
				bidInviteBidder.setObjectId(body.getObjectId());
				bidInviteBidder.setBidderId(inviteTenderVO.getBidderId());

				bibDao.insert(bidInviteBidder);
			}
		}
		dao.updateByPrimaryKey(bo);
		if (log.isDebugEnabled()) {
			log.debug("saveObjectMethodInfo完成");
		}
	}

	@Override
	public List<TenderMyObjectBidReturnWithCertificationVO> selectByObjectIdInValid(Integer userId, String objectId, Pagingnation page) {
		 List<TenderMyObjectBidReturnWithCertificationVO> tmob =new ArrayList<TenderMyObjectBidReturnWithCertificationVO>();
		 
				 Biddee biddee = beDao.selectByUserId(userId);
				 if(biddee != null){
					 if(page!=null&&page.isCountsize()){
						 int totalcount = bidRecordDao.selectTotalByObjectIdInValid(biddee.getId(), objectId);
								 page.setTotalCount(totalcount);
								 page.calculatePageCount();
					 }
					 List<TenderMyObjectBidReturnVO> nos =
							 bidRecordDao.selectByObjectIdInValid(biddee.getId(), objectId, page);
					if(nos!= null && nos.size()>0){
						List<TenderCertificationReturnVO> certificationList = new ArrayList<TenderCertificationReturnVO>();
						for(TenderMyObjectBidReturnVO tm : nos){
							TenderMyObjectBidReturnWithCertificationVO tmb = new TenderMyObjectBidReturnWithCertificationVO();
							tmb.setBidAmount(tm.getBidAmount());
							tmb.setBidderCompanyName(tm.getBidderCompanyName());
							tmb.setBidderId(tm.getBidderId());
							
							tmb.setBidId(tm.getBidId());
							tmb.setBidTime(tm.getBidTime());
							tmb.setFileUrl(tm.getFileUrl());
							tmb.setProjectExpectEndDate(tm.getProjectExpectEndDate());
							tmb.setProjectExpectPeriod(tm.getProjectExpectPeriod());
							tmb.setProjectExpectStartDate(tm.getProjectExpectStartDate());
							List<BidCertification>  ds = bcDao.selectByBidId(tm.getBidId());
							if(ds != null && ds.size()>0){
								for(BidCertification dd : ds){
									TenderCertificationReturnVO mm = new TenderCertificationReturnVO();
									mm.setCertificationId((dd.getBidderCertificationId()));
									String certificationName = dd.getCertificationName();
									mm.setCertificationName(certificationName);
									
									certificationList.add(mm);
								}
							}
							tmb.setCertificationList(certificationList);
							tmob.add(tmb);
						}
						
					}
				 }else{
					 if(page!=null&&page.isCountsize()){
								 page.setTotalCount(0);
								 page.calculatePageCount();
					 }
				 }
				 
				 return tmob;
	}

	// @Override
	// public List<TenderMyObjectBidReturnVO> selectByObjectIdInValid(Integer
	// userId, String objectId, Pagingnation page) {
	// org.apache.commons.logging.Log log =
	// org.apache.commons.logging.LogFactory.getLog(this.getClass());
	//
	// if(page!=null&&page.isCountsize()){
	// int totalcount = notificationDao.selectTotalCountByTokenAndStatus(token,
	// status);
	// page.setTotalCount(totalcount);
	// page.calculatePageCount();
	// }
	// List<InstationNotification> nos =
	// notificationDao.selectByUserInValid(token, status, page);
	//
	// return nos;
	// }

	/**
	 * 查询未完成招标答疑方式接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public QueryAnswerMethodInfoBodyVOResult queryAnswerMethodInfo(String appId, QueryObjectBodyVO body,
			Integer biddeeId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标答疑方式接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = null;
		List<BidObject> objs = dao.selectUnfinishObject(biddeeId, body.getObjectId());
		if (objs != null && !objs.isEmpty()) {
			bo = objs.get(0);
		}
		ValidateUtil.assertNullnoappend(bo, "招标项目不存在");
		Qanda qanda = qaDao.selectByObjectId(body.getObjectId());
		QueryAnswerMethodInfoBodyVOResult result=null;
		if(qanda!=null){
			 
			result = new QueryAnswerMethodInfoBodyVOResult();
			if ("YES".equals(qanda.getIsEmailAnswer())) {
				result.setEmail(qanda.getEmail());
			}
			if ("YES".equals(qanda.getIsMeetngAnswer())) {
				result.setAddress(qanda.getAddress());
				result.setAddressAnswerDate(qanda.getAnswerDate());
				result.setAddressAnswerTime(qanda.getAnswerTime());
			}
			if ("YES".equals(qanda.getIsQqAnswer())) {
				result.setQQ(qanda.getQqNo());
				result.setQQtoken(qanda.getQqPassword());
			}
			if ("YES".equals(qanda.getIsTelAnswer())) {
				result.setTelephone(qanda.getTelephone());
			}
			result.setStartTime(DateUtil.format(qanda.getAnswerStartDate(), "yyyy-MM-dd"));
			result.setEndTime(DateUtil.format(qanda.getAnswerEndDate(), "yyyy-MM-dd"));
		}

		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标答疑方式接口完成");
		}
		return result;
	}

	/**
	 * 保存招标答疑方式接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveAnswerMethodInfo(String appId, SaveAnswerMethodInfoBodyVO body) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标答疑方式接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		Qanda qanda = qaDao.selectByObjectId(body.getObjectId());
		boolean isadd = false;
		if (qanda == null) {
			isadd = true;
			qanda = new Qanda();
			qanda.setObjectId(body.getObjectId());
		}
		try {
			qanda.setAnswerStartDate(DateUtil.parse2date(body.getStartTime()));
			qanda.setAnswerEndDate(DateUtil.parse2date(body.getEndTime()));
		} catch (ParseException e) {
			log.error(String.format("日期转换出错"), e);
			throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e, "答疑时间日期格式不正确");
		}
		qanda.setQqNo(body.getQQ());
		qanda.setQqPassword(body.getQQtoken());
		qanda.setTelephone(body.getTelephone());
		qanda.setAddress(body.getAddress());
		qanda.setEmail(body.getEmail());
		qanda.setIsEmailAnswer("YES");
		qanda.setIsMeetngAnswer("YES");
		qanda.setIsQqAnswer("YES");
		qanda.setIsTelAnswer("YES");
		if (isadd) {
			qaDao.insert(qanda);
		} else {
			qaDao.updateByPrimaryKey(qanda);
		}

		if (log.isDebugEnabled()) {
			log.debug("保存招标答疑方式接口完成");
		}
	}

	/**
	 * 查询未完成招标时间要求接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public QueryDateRequirementInfoBodyVOResult queryDateRequirementInfo(String appId, QueryObjectBodyVO body,
			Integer biddeeId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标时间要求接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		ObjectBaseinfo baseinfo = obiDao.selectByPrimaryKey(body.getObjectId());
		QueryDateRequirementInfoBodyVOResult result = new QueryDateRequirementInfoBodyVOResult();
		if (baseinfo != null) {
			result.setAnnouncementBeginTime(baseinfo.getAnnouncementBeginTime() == null ? ""
					: DateUtil.format(baseinfo.getAnnouncementBeginTime(), "yyyy-MM-dd"));
			result.setAnnouncementEndTime(baseinfo.getAnnouncementEndTime() == null ? ""
					: DateUtil.format(baseinfo.getAnnouncementEndTime(), "yyyy-MM-dd"));
			result.setBiddingEndTime(baseinfo.getBiddingEndTime() == null ? ""
					: DateUtil.format(baseinfo.getBiddingEndTime(), "yyyy-MM-dd"));
			result.setBidOpenDate(
					bo.getBidOpenDate() == null ? "" : DateUtil.format(bo.getBidOpenDate(), "yyyy-MM-dd"));
		}
		// 请自行调整
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标时间要求接口完成");
		}
		return result;
	}

	/**
	 * 保存招标时间要求
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveDateRequirementInfo(String appId, SaveDateRequirementInfoBodyVO body) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标时间要求开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		ObjectBaseinfo baseinfo = obiDao.selectByPrimaryKey(body.getObjectId());
		boolean isadd = false;
		if (baseinfo == null) {
			isadd = true;
			baseinfo = new ObjectBaseinfo();
			baseinfo.setObjectId(body.getObjectId());
		}
		try {
			baseinfo.setAnnouncementBeginTime(getDateFromStringOrNull(body.getAnnouncementBeginTime()));
			baseinfo.setAnnouncementEndTime(getDateFromStringOrNull(body.getAnnouncementEndTime()));
			baseinfo.setBiddingEndTime(getDateFromStringOrNull(body.getBiddingEndTime()));
			bo.setBidOpenDate(getDateFromStringOrNull(body.getBidOpenDate()));
		} catch (ParseException e) {
			log.error(String.format("日期格式不正确"), e);
			throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e, "日期格式不正确");
		}
		if (isadd) {
			obiDao.insert(baseinfo);
		} else {
			obiDao.updateByPrimaryKey(baseinfo);
		}
		dao.updateByPrimaryKey(bo);

		if (log.isDebugEnabled()) {
			log.debug("保存招标时间要求完成");
		}
	}

	/**
	 * 把字符串转为日期,如果内容为空,则返回null
	 * 
	 * @param datestr
	 * @return
	 * @throws ParseException
	 */
	private Date getDateFromStringOrNull(String datestr) throws ParseException {
		if (StringUtils.isNotBlank(datestr)) {
			return DateUtil.parse(datestr).getTime();
		} else {
			return (null);
		}
	}

	/**
	 * 查询未完成招标评标方式接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public QueryBidEvaluationTypeInfoBodyVOResult queryBidEvaluationTypeInfo(String appId, QueryObjectBodyVO body,
			Integer biddeeId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标评标方式接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		ObjectBaseinfo baseinfo = obiDao.selectByPrimaryKey(body.getObjectId());
		QueryBidEvaluationTypeInfoBodyVOResult result = new QueryBidEvaluationTypeInfoBodyVOResult();
		if (baseinfo != null) {
			result.setBidEvaluationSite(baseinfo.getBidEvaluationSite());
			result.setBidEvaluationType(baseinfo.getBidEvaluationType());
			result.setBidWinnerDetermineWay(baseinfo.getBidWinnerDetermineWay());
			result.setVoteWinWay(baseinfo.getVoteWinWay());
		}

		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标评标方式接口完成");
		}
		return result;
	}

	/**
	 * 保存招标评标方式接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveBidEvaluationTypeInfo(String appId, SaveBidEvaluationTypeInfoBodyVO body) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标评标方式接口开始");
		}
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		ObjectBaseinfo baseinfo = obiDao.selectByPrimaryKey(body.getObjectId());
		boolean isadd = false;
		if (baseinfo == null) {
			isadd = true;
			baseinfo = new ObjectBaseinfo();
			baseinfo.setObjectId(body.getObjectId());
		}
		baseinfo.setBidEvaluationSite((body.getBidEvaluationSite()));
		baseinfo.setBidEvaluationType((body.getBidEvaluationType()));
		baseinfo.setBidWinnerDetermineWay((body.getBidWinnerDetermineWay()));
		baseinfo.setVoteWinWay((body.getVoteWinWay()));
		if (isadd) {
			obiDao.insert(baseinfo);
		} else {
			obiDao.updateByPrimaryKey(baseinfo);
		}
		dao.updateByPrimaryKey(bo);
		if (log.isDebugEnabled()) {
			log.debug("保存招标评标方式接口完成");
		}
	}

	/**
	 * 发布标的接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void submitObject(String appId, QueryObjectBodyVO body, Integer biddeeId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("发布标的接口开始");
		}
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");

		ValidateUtil.assertNotEqual(bo.getBiddeeId(), biddeeId, "项目非您的招标项目,不能进行操作");
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		bo.setObjectStatus("PUB");
		bo.setPublishTime(new Date());
		dao.updateByPrimaryKey(bo);
		String objectId = bo.getObjectId();
		//被邀标人
		List<Integer> bidderIds = new ArrayList<Integer>();
		if("INV".equalsIgnoreCase(bo.getObjectPublishType())){
			List<Bidder> bidders = berDao.selectInviteBidders(objectId);
			if(bidders!= null && bidders.size() >0){
				for(Bidder bidder : bidders){
					bidderIds.add(bidder.getUserId());
				}
				InvBidEvent bide = new InvBidEvent(objectId, bidderIds);
				EventListenerContainer.getInstance().fireEvent(bide);
			}
			
		}
		if (log.isDebugEnabled()) {
			log.debug("发布标的接口完成");
		}
	}

	@Override
	public List<MyTenderObjectListVO> getTenderObjectList(Integer user_id, Pagingnation page) throws BusinessException {

		if (page != null && page.isCountsize()) {
			int totalcount = dao.selectTotalCountTenderObject(user_id);
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<MyTenderObjectListVO> ans = dao.selectTenderObject(user_id, page);

		return ans;

	}

	@Override
	public List<TenderMyBuildingObjectVO> getTenderBuildingObjectList(Integer user_id, Pagingnation page)
			throws BusinessException {

		if (page != null && page.isCountsize()) {
			int totalcount = dao.selectTotalTenderBuildingObject(user_id);
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<TenderMyBuildingObjectVO> ans = dao.selectTenderBuildingObject(user_id, page);

		return ans;
	}

	@Override
	public List<TenderMyEndedObjectVO> getTenderEndedObjectList(Integer user_id, Pagingnation page)
			throws BusinessException {

		if (page != null && page.isCountsize()) {
			int totalcount = dao.selectTotalTenderEndedObject(user_id);
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<TenderMyEndedObjectVO> ans = dao.selectTenderEndedObject(user_id, page);

		return ans;
	}

	@Override
	public List<TenderObjectListReturnVO> getTenderObjectList(String[] keywords, Pagingnation page,TenderObjectBodyVO body)
			throws BusinessException {
		List<String> kwlist=new ArrayList<>();
		if(keywords!=null&&keywords.length>0){
			for (int i = 0; i < keywords.length; i++) {
				String akw = keywords[i];
				if(StringUtils.isNotBlank(akw)){
					kwlist.add(akw);
				}
			}
		}
		String[] kw=null;
		if(!kwlist.isEmpty()){
			kw = kwlist.toArray(new String[]{});
		}
		if (page != null && page.isCountsize()) {
			int totalcount = dao.selectTotalTenderObjectList(kw,body.getStatus(),body.getPublishTime());
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<TenderObjectListReturnVO> ans = dao.selectTenderObjectList(kw, page,body.getStatus(),body.getPublishTime());

		return ans;
	}

	@Override
	// public List<QueryIndexObjectListResult> getIndexObjectList(Pagingnation
	// page) throws BusinessException {
	public List<QueryIndexObjectListResult> getIndexObjectList() throws BusinessException {
		com.hummingbird.common.face.Pagingnation page = new Pagingnation();
		page.setCurrPage(1);
		page.setPageSize(10);
		if (page != null && page.isCountsize()) {
			int totalcount = dao.selectTotalIndexObjectList();
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<QueryIndexObjectListResult> ans = dao.selectIndexObjectList(page);

		return ans;
	}
	@Override
	 public List<QueryIndexObjectListResult> getIndexObjectList(Pagingnation
	 page) throws BusinessException {
		if (page != null && page.isCountsize()) {
			int totalcount = dao.selectTotalTjIndexObjectList();
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<QueryIndexObjectListResult> ans = dao.selectTjIndexObjectList(page);

		return ans;
	}

	@Override
	public QueryBidIndexSurveyResult getBidIndexSurvey() throws BusinessException {
		QueryBidIndexSurveyResult bis = dao.selectBidIndexSurvey();
		return bis;
	}

	@Override
	public List<QueryBidIndexListResult> getBidIndexList(Pagingnation page, String projectName, Integer publishTime)
			throws BusinessException {
		if (page != null && page.isCountsize()) {
			int totalcount = dao.selectTotalBidIndexList(projectName, publishTime);
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<QueryBidIndexListResult> ans = dao.selectBidIndexList(projectName, publishTime, page);

		return ans;
	}

	/**
	 * 查询投标人分页
	 * @see com.hummingbird.paas.services.TenderService#queryBidderList()
	 */
	public List<QueryBidderListResultVO> queryBidderList(QueryCertificateListBodyVO queryCertificateListBodyVO, Pagingnation pagingnation) throws BusinessException {
		if(pagingnation!=null&&pagingnation.isCountsize()){
			int count = berDao.selectBidderCount(queryCertificateListBodyVO);
			pagingnation.setTotalCount(count);
			pagingnation.calculatePageCount();
		}
		List<Bidder> bers = berDao.selectBidder(queryCertificateListBodyVO,pagingnation);
		List<QueryBidderListResultVO> qlr = new ArrayList<QueryBidderListResultVO>();
		QueryBidderListResultVO qr = null;
		for (Bidder ber : bers) {
			qr = new QueryBidderListResultVO();
			qr.setBidderId(ber.getId());
			qr.setBidderName(ber.getCompanyName());
			//查询用户信息
			User user = userDao.selectByPrimaryKey(ber.getUserId());
			if(user!=null)
				qr.setUserName(user.getNickName());
			qlr.add(qr);
		}
		return qlr;
	}
	
	/**
	 * 首页查询投标人列表
	 * @param body
	 * @param pagingnation
	 * @return
	 */
	public List<QueryBidderListHomepageResultVO> queryBidderList4homepage(QueryCertificateListBodyVO body,
			Pagingnation pagingnation){
		List<String> keywords = body.getKeywords();
		//如果列表中的无内容,或者为"",会变成sql错误,这里进行处理
		if(keywords==null||keywords.isEmpty()){
			keywords=null;
		}
		else{
			boolean allblank = true;
			for (Iterator iterator = keywords.iterator(); iterator.hasNext();) {
				String kw = (String) iterator.next();
				allblank&=StringUtils.isBlank(kw);
			}
			if(allblank){
				keywords=null;
			}
		}
		String bidderName = body.getBidderName();
		if(pagingnation!=null&&pagingnation.isCountsize()){
			int count = berDao.selectBidderCount4homepage(keywords,bidderName);
			pagingnation.setTotalCount(count);
			pagingnation.calculatePageCount();
		}
		
		List<QueryBidderListHomepageResultVO> bers = berDao.selectBidder4homepage(keywords,bidderName,pagingnation);
		return bers;
	}

	/**
	 * 查询资质证书类型列表接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public List<QueryCertificateListResultVO> queryCertificateList() {
		if (log.isDebugEnabled()) {
			log.debug("查询资质证书类型列表接口开始");
		}
		List<Industry> inds = indDao.selectAll();
		if (inds == null) {
			if (log.isDebugEnabled()) {
				log.debug("得到industry为空" + inds);
			}
			return null;
		}
		QueryCertificateListResultBodyVO cert = null;
		List<QueryCertificateListResultVO> qc = new ArrayList<QueryCertificateListResultVO>();
		QueryCertificateListResultVO cvo = null;
		List<QueryCertificateListResultBodyVO> qcrs = null;
		for (Industry ind : inds) {
			cvo = new QueryCertificateListResultVO();
			cvo.setIndustryId(ind.getId());
			cvo.setIndustryName(ind.getIndustryName());
			List<CertificationType> cs = ctDao.selectAllTypes(ind.getId());
			qcrs = new ArrayList<QueryCertificateListResultBodyVO>();
			for (CertificationType ct : cs) {
				cert = new QueryCertificateListResultBodyVO();
				cert.setCertificateId(ct.getId());
				cert.setCertificateName(ct.getCertificationName());
				qcrs.add(cert);
			}
			cvo.setCertificateList(qcrs);
			qc.add(cvo);
		}
		if (log.isDebugEnabled()) {
			log.debug("查询资质证书类型列表接口成功");
		}
		return qc;
	}

	/**
	 * 查询首页投标人推荐列表接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List<QueryIndexBidListResultVO> queryIndexBidList(Integer pageIndex, Integer pageSize)
			throws BusinessException {
		List<Bidder> bers = berDao.getIndexBidListPages((pageIndex-1)*pageSize, pageSize);
		List<QueryIndexBidListResultVO> qlr = new ArrayList<QueryIndexBidListResultVO>();
		QueryIndexBidListResultVO qr = null;
		for (Bidder ber : bers) {
			qr = new QueryIndexBidListResultVO();
			qr.setBiderId(ber.getId());
			qr.setShortName(ber.getShortName());
			qr.setCompanyLogo(ber.getLogo());
			qlr.add(qr);
		}
		return qlr;
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public int evaluateBidder(EvaluateBidderBodyVO body,Token token)
			throws MaAccountException {
		int i = 0;
		ProjectInfo project=projectInfoDao.selectByObjectId(body.getObjectId())==null?null:projectInfoDao.selectByObjectId(body.getObjectId()).get(0);
		if(project==null){
			if(log.isDebugEnabled()){
				log.debug(String.format("根据项目编号【%s】查询项目信息失败", body.getObjectId()));
			}
			throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,
					String.format("根据项目编号【%s】查询项目信息失败", body.getObjectId()));
		}
		ProjectEvaluationBiddee evaluationBiddee = new ProjectEvaluationBiddee();
		evaluationBiddee.setBiddeeId(project.getBiddeeId());
		evaluationBiddee.setBidderId(project.getBidderId());
		evaluationBiddee.setEvaluationContent(body.getEvaluateContent());
		evaluationBiddee.setInsertBy(token.getUserId().toString());
		evaluationBiddee.setInsertTime(new Date());
		evaluationBiddee.setProjectId(project.getProjectId());
		evaluationBiddee.setScore(body.getEvaluateScore()==null?0:(body.getEvaluateScore()*2));
		evaluationBiddee.setStarCount(body.getEvaluateScore()==null?0:body.getEvaluateScore());
		// 标签部分缺少 add by YJY 2015年12月1日15:35:35 插入标签
		if (body.getTags() != null) {
			for (String tag : body.getTags()) {
//				CallInterfaceUtil.addTag(tag, "0", "evaluation_manager", "t_ztgl_object_project_info",
//						body.getObjectId());
				CallInterfaceUtil.addTag(tag, "0", "bidder_manager", "t_qyzz_bidder",
						evaluationBiddee.getBidderId());
			}
		}
		
		
		i = evaluationBiddeeDao.insert(evaluationBiddee);
		
		return i;
	}

	@Override
	public CompanyInfo queryTenderCompanyInfo(String appId, QueryCompanyInfoBodyVO mm) throws BusinessException {
		CompanyInfo cc = new CompanyInfo();
		// 1.概况
		CompanyBaseInfo cb = new CompanyBaseInfo();
		CompanySurvey cs = beDao.selectCompanySurveyById(mm.getCompanyId());
		if(cs ==null){
			cs = new CompanySurvey();
		}
		cc.setSurvey(cs);
		// 2.基本信息
		Biddee biddee = beDao.selectByPrimaryKey(mm.getCompanyId());
		ValidateUtil.assertNull(biddee, "公司信息不存在！");
		cb.setAddress(biddee.getAddress());
		cb.setBusinessScope(biddee.getBusinessScope());
		cb.setCompanyName(biddee.getCompanyName());
		cb.setContactMobileNum(biddee.getContactMobileNum());
		cb.setContactName(biddee.getContactName());
		cb.setDescription(biddee.getDescription());
		cb.setEmail(biddee.getEmail());
		cb.setRegisteredCapital(biddee.getRegisteredCapital());
		cb.setRegTime(biddee.getRegTime());
		cc.setBaseInfo(cb);
		// 3.证书信息
//		List<CompanyCerticateInfo> ccis = beDao.selectCompanyCerticateInfoById(mm.getCompanyId());
//		cc.setCerticate(ccis);
		// 4.招投标信息
		CompanyBidInfo cbi = new CompanyBidInfo();
		cbi.setTenderNum(dao.selectTenderNumbyBiddeeId(mm.getCompanyId()));
		cbi.setBidNum(dao.selectBidNumbyBiddeeId(mm.getCompanyId()));
		cbi.setFlowNum(dao.selectFlowNumbyBiddeeId(mm.getCompanyId()));
		cbi.setWinNum(dao.selectWinNumbyBiddeeId(mm.getCompanyId()));
		cbi.setOnTimeNum(pppDao.getBiddeeOnTimeNum(mm.getCompanyId()));
		cbi.setOutTimeNum(pppDao.getBiddeeOutTimeNum(mm.getCompanyId()));
		cc.setBidInfo(cbi);
		// 5.评价信息
		CompanyEvaluationInfo cei = new CompanyEvaluationInfo();
		cei.setCompanyEvaluateNum(evaluationBiddeeDao.countEvaluationNumByBiddeeId(mm.getCompanyId()));
		cei.setCompanyEvaluateScore(evaluationBiddeeDao.countEvaluationScoreByBiddeeId(mm.getCompanyId()));
		List<CompanyEvaluationDetailInfo> cedis = evaluationBiddeeDao.selectEvaluationDetailByBiddeeId(mm.getCompanyId());
		cei.setList(cedis);
//		cei.set
		//查询是否招标方会员
		MemberBiddee mb = biddeeMembeeDao.selectByBiddeeId(biddee.getId());
		cs.setIsMember("FLS");
		if(mb!=null){
			//判断时间有没有超出范围
			if(mb.getEndTime().getTime()>System.currentTimeMillis()){
				cs.setIsMember("OK#");
			}
		}
		
		//标签
//		CallInterfaceUtil.addTag(tag, "0", "biddee_evaluation_manager", "t_ztgl_object", project.getObjectId());
		String  tagJson = CallInterfaceUtil.searchTag("biddee_evaluation_manager", "t_ztgl_object");
		
		
		List<TagInfo> tagList = new ArrayList<TagInfo>();
		// ---------------------------------------------------------------------
		Gson ss = new Gson();
		try {
			JsonResult str = ss.fromJson(tagJson, JsonResult.class);

			if (str != null && "0".equals(str.getErrcode())) {
				for (JsonResultMsg msg : str.getErrmsg()) {
					TagInfo aa = new TagInfo();
					aa.setTagName(msg.getTagName());
					aa.setTagNum(msg.getTabUseNum());
					tagList.add(aa);
				}

			}
		} catch (JsonSyntaxException e) {
			log.error(e.getMessage());
		}

		cei.setTag(tagList);
		cc.setEvaluationInfo(cei);
		return cc;
	}

	@Override
	public CompanyInfo queryBidderCompanyInfo(String appId, QueryCompanyInfoBodyVO mm) throws BusinessException {
		CompanyInfo cc = new CompanyInfo();
//		1.概况
		CompanyBaseInfo cb = new CompanyBaseInfo();
		CompanySurvey cs = berDao.selectCompanySurveyById(mm.getCompanyId());
		if(cs ==null){
			cs = new CompanySurvey();
		}
		cc.setSurvey(cs);
//		2.基本信息
		Bidder bidder = berDao.selectByPrimaryKey(mm.getCompanyId());
		ValidateUtil.assertNull(bidder,"公司信息不存在！");
		cb.setAddress(bidder.getAddress());
		cb.setBusinessScope(bidder.getBusinessScope());
		cb.setCompanyName(bidder.getCompanyName());
		cb.setContactMobileNum(bidder.getContactMobileNum());
		cb.setContactName(bidder.getContactName());
		cb.setDescription(bidder.getDescription());
		cb.setEmail(bidder.getEmail());
		cb.setRegisteredCapital(bidder.getRegisteredCapital());
		cb.setRegTime(bidder.getRegTime());
		cc.setBaseInfo(cb);
//		3.证书信息
		List<CompanyCerticateInfo> ccis = beDao.selectCompanyCerticateInfoById(mm.getCompanyId());
		cc.setCerticate(ccis);
//		4.招投标信息
		CompanyBidInfo  cbi  = new CompanyBidInfo();
		cbi.setTenderNum(dao.selectTenderNumbyBidderId(mm.getCompanyId()));
		cbi.setBidNum(dao.selectBidNumbyBidderId(mm.getCompanyId()));
		cbi.setFlowNum(dao.selectFlowNumbyBidderId(mm.getCompanyId()));
		cbi.setWinNum(dao.selectWinNumbyBidderId(mm.getCompanyId()));
		cbi.setOnTimeNum(pppDao.getBidderOnTimeNum(mm.getCompanyId()));
		cbi.setOutTimeNum(pppDao.getBidderOutTimeNum(mm.getCompanyId()));
		cc.setBidInfo(cbi);
//		5.评价信息
		CompanyEvaluationInfo  cei  = new CompanyEvaluationInfo();
		cei.setCompanyEvaluateNum(evaluationBidderDao.countEvaluationNumByBidderId(mm.getCompanyId()));
		cei.setCompanyEvaluateScore(evaluationBidderDao.countEvaluationScoreByBidderId(mm.getCompanyId()));
		List<CompanyEvaluationDetailInfo> cedis = evaluationBidderDao.selectEvaluationDetailByBidderId(mm.getCompanyId());
		cei.setList(cedis);
		
		//查询是否招标方会员
		MemberBidder mb = biddeeMemberDao.selectByBidderId(bidder.getId());
		cs.setIsMember("FLS");
		if(mb!=null){
			//判断时间有没有超出范围
			if(mb.getEndTime().getTime()>System.currentTimeMillis()){
				cs.setIsMember("OK#");
			}
		}
		
		//标签
//		String  tagJson = CallInterfaceUtil.searchTag("biddee_evaluation_manager", "t_ztgl_object");
		String  tagJson = CallInterfaceUtil.searchTag("bidder_evaluation_manager", "t_ztgl_object");
		
		
		List<TagInfo> tagList = new ArrayList<TagInfo>();
//		---------------------------------------------------------------------
		Gson ss = new Gson();
		try{
			JsonResult str = ss.fromJson(tagJson, JsonResult.class);

			if(str!= null&&"0".equals(str.getErrcode())){
				for(JsonResultMsg msg : str.getErrmsg()){
					TagInfo aa =new TagInfo();
					aa.setTagName(msg.getTagName());
					aa.setTagNum(msg.getTabUseNum());
					tagList.add(aa);
				}
				
			}
		}catch(JsonSyntaxException e){
			//转换失败  可能是没数据  期间   所得标签都是为空     
			log.error(e.getMessage());
		}
		
		cei.setTag(tagList);
		cc.setEvaluationInfo(cei);
		return cc;
	}

	/**
	 * 招标方给投标方评价
	 * 
	 * @param appId
	 * @param body
	 * @param biddee
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void evaluateBidder(String appId, EvaluateBidderBodyVO body, Biddee biddee) throws BusinessException {

		int i = 0;
		String objectId = body.getObjectId();
		BidObject bidObject = dao.selectByPrimaryKey(objectId);
		if (bidObject == null) {
			log.error("标的不存在:" + objectId);
			throw ValidateException.ERROR_PARAM_NULL.clone(null, "标的不存在:");
		}
		if (StringUtils.equals(bidObject.getObjectStatus(), "END")) {
			log.error("标的未结束:" + objectId);
			throw new PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION, "标的未结束");
		}
		List<ProjectInfo> projects = projectInfoDao.selectByObjectId(objectId);
		if (org.apache.commons.collections.CollectionUtils.isEmpty(projects)) {
			log.error("标的工程不存在:" + objectId);
			throw new PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION, "标的工程不存在");
		}
		ProjectInfo project = projects.get(0);
		// if(project==null){
		// if(log.isDebugEnabled()){
		// log.debug(String.format("根据项目编号【%s】查询项目信息失败", body.getObjectId()));
		// }
		// throw new
		// PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION,String.format("根据项目编号【%s】查询项目信息失败",
		// body.getObjectId()));
		// }
		ProjectEvaluationBidder evaluationBidder = new ProjectEvaluationBidder();
		evaluationBidder.setStarCount(0);
		evaluationBidder.setBiddeeId(project.getBiddeeId());
		evaluationBidder.setBidderId(project.getBidderId());
		evaluationBidder.setEvaluationContent(body.getEvaluateContent());
		evaluationBidder.setInsertBy(biddee.getUserId().toString());
		evaluationBidder.setInsertTime(new Date());
		evaluationBidder.setProjectId(project.getProjectId());
		evaluationBidder.setScore(body.getEvaluateScore()==null?0:body.getEvaluateScore()*2);
		evaluationBidder.setStarCount(body.getEvaluateScore()==null?0:body.getEvaluateScore());
		evaluationBidderDao.insert(evaluationBidder);
		// 标签部分缺少 add by YJY 2015年12月1日15:35:35 插入标签
		// 调用接口时,如果数据库失败,这个标签也会保存进去
		if (body.getTags() != null) {
			for (String tag : body.getTags()) {
//				CallInterfaceUtil.addTag(tag, "0", "biddee_manager", "t_qyzz_biddee", evaluationBidder.getBiddeeId());
				CallInterfaceUtil.addTag(tag, "0", "bidder_evaluation_manager", "t_ztgl_object", body.getObjectId());
//				CallInterfaceUtil.addTag(tag, "0", "bidder_evaluation_manager", "t_ztgl_object_project_info",
//						body.getObjectId());
			}
		}

	}

	/**
	 * 查询工程类别列表
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public List<GetIndustryListBodyVOResult> getIndustryList(String appId, Map body) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询工程类别列表开始");
		}
		List<GetIndustryListBodyVOResult> result = new ArrayList<>();
		List<Industry> selectAll = indDao.selectAll();
		for (Iterator iterator = selectAll.iterator(); iterator.hasNext();) {
			Industry industry = (Industry) iterator.next();
			GetIndustryListBodyVOResult item = new GetIndustryListBodyVOResult();
			result.add(item);
			item.setIndustryIcon(industry.getIndustryIcon());
			item.setIndustryId(industry.getId());
			item.setIndustryName(industry.getIndustryName());
		}

		if (log.isDebugEnabled()) {
			log.debug("查询工程类别列表完成");
		}
		return result;
	}

	/**
	 * 查询工程类别详情
	 * 
	 * @param appId
	 * @param body
	 * @return
	 * @throws BusinessException
	 */
	public GetIndustryListBodyVOResult getIndustryDetail(String appId, GetIndustryDetailBodyVO body)
			throws BusinessException {
		Industry industry = indDao.selectByPrimaryKey(body.getIndustryId());
		if (industry == null) {
			log.error(String.format("工程类型%s不存在", body.getIndustryId()));
			throw ValidateException.ERROR_PARAM_NULL.clone(null, "工程类型不存在");
		}
		GetIndustryListBodyVOResult item = new GetIndustryListBodyVOResult();
		item.setIndustryIcon(industry.getIndustryIcon());
		item.setIndustryId(industry.getId());
		item.setIndustryName(industry.getIndustryName());
		return item;

	}
	
	/**
	 * 定标
	 * @param objectId
	 * @param biddee
	 * @param bidder_id
	 * @param tenderPaymentInfo 分期付款设定
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void selectBid2win(String objectId, Biddee biddee, Integer winbidId, TenderPaymentInfo tenderPaymentInfo,String token)throws BusinessException{
		if (log.isDebugEnabled()) {
			log.debug("定标开始");
		}
		ValidateUtil.assertNullnoappend(objectId, "招标编号不存在");
		ValidateUtil.assertNullnoappend(winbidId, "投标记录不存在");
		BidObject bo = dao.selectByPrimaryKey(objectId);
		ValidateUtil.assertNullnoappend(bo, "招标项目不存在");
		ValidateUtil.assertNotEqual(bo.getBiddeeId(), biddee.getId(), "此项目并不是您的标的,不能进行操作");
//		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "REV", "项目还没有开标,不能进行操作");
		
		BidRecord bid = bidRecordDao.selectByPrimaryKey(winbidId);
		ValidateUtil.assertNullnoappend(bid, "招标记录不存在");
		ValidateUtil.assertNotEqual(bid.getObjectId(),objectId, "招标与投标不匹配");
		ObjectProjectInfo objproj = bpdao.selectByPrimaryKey(objectId);
		Integer winBidderId = bid.getBidderId();
		ProjectPaymentDefine ppd = new ProjectPaymentDefine();
		ProjectPaymentDefineDetail ppf = new ProjectPaymentDefineDetail();
		TenderPaymentInfo tp = tenderPaymentInfo;
		List<TenderPaymentDetailInfo> tpds= tp.getPayList();
		//1.保存到招标表
		bo.setObjectStatus("SEL");//修改状态为定标
		bo.setWinBidderId(winBidderId);
		bo.setWinBidAmount(bid.getBidAmount());
		dao.updateByPrimaryKey(bo);
		//更新投标表
		//更新其它投标为失败
		bidRecordDao.update2fail(objectId, winbidId);
		bid.setBidStatus("WIN");
		bidRecordDao.updateByPrimaryKey(bid);
		
		//2.保存到工程付款表
		ppd.setObjectId(objectId);
		ppd.setPayPeriod(tp.getPayPeriod());
		ppd.setPayType(tp.getPayType());
		int pid = projectPaymentDefineDao.insert(ppd); 
		for(TenderPaymentDetailInfo mm : tpds){
			ppf.setPaySum(mm.getPaySum());
			ppf.setPeriod(mm.getPeriod());
			ppf.setPayEndTime(mm.getPayDate());
			if(mm.getPayDate()!=null){
				
				ppf.setPayStartTime(DateUtils.addDays(mm.getPayDate(), -30));
			}
			ppf.setProjectPaymentDefineId(ppd.getId());
			projectPaymentDefineDetailDao.insert(ppf);
		}
		//更新投标评标表	
		//XXX 先暂时不处理,好像不需要使用
//		BidEvaluation be = new BidEvaluation();
//		bidevaDao.insertBidEvaluation(objectId, winbidderId);
		
		PropertiesUtil pu = new PropertiesUtil();
		String url=pu.getProperty("capital.url");
		String appkey = pu.getProperty("appkey");
		String appId = pu.getProperty("appId");
		ValidateUtil.assertNullnoappend(url, "资金服务访问地址为空");
		//解冻保证金
		//收取中标者的保证金,这2个放到最后处理
		List<MakeMatchBondRecord> mmbonds = mmbondDao.selectByObjectId(objectId);
		String wincaporder = null;
		List<Map<String,String>> losecaporders = new ArrayList<>();
		String appOrderId = NoGenerationUtil.genNO("MM00", 6);
		MakeMatchBondRecord winMakeMatchBondRecord = null;
		List<MakeMatchBondRecord> loseMakeMatchBondRecords = new ArrayList<>();
		for (Iterator iterator = mmbonds.iterator(); iterator.hasNext();) {
			MakeMatchBondRecord makeMatchBondRecord = (MakeMatchBondRecord) iterator.next();
			if(bid.getId()==makeMatchBondRecord.getBidId()){
				wincaporder = makeMatchBondRecord.getCapitalOrderId();
				winMakeMatchBondRecord =  new MakeMatchBondRecord();
				winMakeMatchBondRecord.setBidId(makeMatchBondRecord.getBidId());
				winMakeMatchBondRecord.setObjectId(makeMatchBondRecord.getObjectId());
				winMakeMatchBondRecord.setOrderId(appOrderId);
				winMakeMatchBondRecord.setBondAmount(makeMatchBondRecord.getBondAmount());
				winMakeMatchBondRecord.setStatus("PAY");
				winMakeMatchBondRecord.setInsertTime(new Date());
				winMakeMatchBondRecord.setCreator(String.valueOf(biddee.getUserId()));
				
			}
			else{
				MakeMatchBondRecord loseMakeMatchBondRecord =  new MakeMatchBondRecord();
				loseMakeMatchBondRecord.setBidId(makeMatchBondRecord.getBidId());
				loseMakeMatchBondRecord.setOrderId(NoGenerationUtil.genNO("MM00", 6));
				loseMakeMatchBondRecord.setObjectId(makeMatchBondRecord.getObjectId());
				loseMakeMatchBondRecord.setBondAmount(makeMatchBondRecord.getBondAmount());
				loseMakeMatchBondRecord.setStatus("REV");
				loseMakeMatchBondRecord.setInsertTime(new Date());
				loseMakeMatchBondRecord.setCreator(String.valueOf(biddee.getUserId()));
				loseMakeMatchBondRecords.add(loseMakeMatchBondRecord);
				Map<String,String> lose = new HashMap<>();
				lose.put("appOrderId", loseMakeMatchBondRecord.getOrderId());
				lose.put("orderId", makeMatchBondRecord.getCapitalOrderId());
				losecaporders.add(lose);
			}
			
		}
		//生成工程信息
		ProjectInfo project = new ProjectInfo();
		project.setObjectId(objectId);
		project.setBiddeeId(bo.getBiddeeId());
		project.setBidderId(winBidderId);
		project.setProjectId(objectId);//使用标的id
		project.setStatus("OK#");
		project.setProjectName(objproj.getProjectName());
		try {
			project.setStartTime(getDateFromStringOrNull(bid.getConstructionStartDate()));
			project.setEndTime(getDateFromStringOrNull(bid.getConstructionEndDate()));
		} catch (ParseException e) {
//			log.error(String.format("施工开始时间 或 结束时间 有误 "),e);
			throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e, "施工开始时间 或 结束时间 有误 ");
		}
		projectInfoDao.insert(project);
		//收取中标者的保证金,解冻保证金
		Map param = MapMaker.buildFromKeyValue(new DefaultKeyValue("token",token),new DefaultKeyValue("orderId",wincaporder),new DefaultKeyValue("lose",losecaporders),new DefaultKeyValue("appOrderId",appOrderId));
		SelectBidWinMakeMatchBondRewardReturnBodyVO makeMatchBondRewardReturnVO = callTransBond2platform(param,url,appId,appkey);
		String winorderId = makeMatchBondRewardReturnVO.getOrderId();
		winMakeMatchBondRecord.setCapitalOrderId(winorderId);
		mmbondDao.insert(winMakeMatchBondRecord);
		List<CapitalOrderReturnVO> unfreezOrders = makeMatchBondRewardReturnVO.getLose();
		for (Iterator iterator = unfreezOrders.iterator(); iterator.hasNext();) {
			CapitalOrderReturnVO capitalOrderReturnVO = (CapitalOrderReturnVO) iterator.next();
			String unfreezeorderId = capitalOrderReturnVO.getOrderId();
			String apporderid = capitalOrderReturnVO.getAppOrderId();
			for (Iterator iterator2 = loseMakeMatchBondRecords.iterator(); iterator2.hasNext();) {
				MakeMatchBondRecord makeMatchBondRecord = (MakeMatchBondRecord) iterator2.next();
				if(makeMatchBondRecord.getOrderId().equals(apporderid)){
					makeMatchBondRecord.setCapitalOrderId(unfreezeorderId);
					mmbondDao.insert(makeMatchBondRecord);
					break;
				}
			}
		}
		
		

		if (log.isDebugEnabled()) {
			log.debug("定标完成");
		}
		
		
		
	}

	/**
	 * 调用资金帐户把钱移到平台帐户 中
	 * @param orderId
	 * @param appkey 
	 * @param appId 
	 * @param url 
	 * @return 
	 * @throws PaasException 
	 * @throws SignatureException 
	 * @throws DataInvalidException 
	 * @throws RequestException 
	 */
	private SelectBidWinMakeMatchBondRewardReturnBodyVO callTransBond2platform(Map param, String url, String appId, String appkey) throws PaasException, DataInvalidException, SignatureException, RequestException {
		if (log.isDebugEnabled()) {
			log.debug(String.format("请求资金服务,中标投标人撮合保证转移到平台,非中标投标人撮合保证金解冻"));
		}
		BaseTransVO<Map> buildBaseTrans = TransOrderBuilder.buildBaseTrans(appId,appkey,param, false, false);
		String poststr = JsonUtil.convert2Json(buildBaseTrans);
		String result = new HttpRequester().postRequest(url+"/capitalManage/payMatchHandingCharge", poststr);
		SelectBidWinMakeMatchBondRewardReturnVO mmcapReturn = JsonUtil.convertJson2Obj(result, SelectBidWinMakeMatchBondRewardReturnVO.class);
		
		if(mmcapReturn.getErrcode()!=0){
			if (log.isDebugEnabled()) {
				log.debug(String.format("请求资金服务,中标投标人撮合保证转移到平台,非中标投标人撮合保证金解冻,出错,信息为%s",mmcapReturn));
			}
			throw new PaasException(PaasException.ERR_TENDER_INFO_EXCEPTION,"定标撮合保证金处理出错");
		}
		else{
			return mmcapReturn.getResult();
		}
		
	}

	
	@Override
	public QueryProjectSurveyResultVO queryUserInformationIndexSurvey()
			throws BusinessException {
		
		// 查询所有用户成功发布信息的总数 和 成功发布信息的用户总数
		QueryProjectSurveyResultVO projectSurvey = userInformationMapper.queryUserInformationIndexSurvey();
		
		return projectSurvey;
	}

}