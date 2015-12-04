package com.hummingbird.paas.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.commonbiz.util.NoGenerationUtil;
import com.hummingbird.paas.entity.Announcement;
import com.hummingbird.paas.entity.BidInviteBidder;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.ObjectProjectInfo;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.CertificationType;
import com.hummingbird.paas.entity.Industry;
import com.hummingbird.paas.entity.ObjectAttachment;
import com.hummingbird.paas.entity.ObjectBaseinfo;
import com.hummingbird.paas.entity.ObjectBondSetting;
import com.hummingbird.paas.entity.ObjectCertificationRequirement;
import com.hummingbird.paas.entity.ProjectEvaluationBiddee;
import com.hummingbird.paas.entity.ProjectInfo;
import com.hummingbird.paas.entity.Qanda;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.BidInviteBidderMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.ObjectProjectInfoMapper;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.CertificationTypeMapper;
import com.hummingbird.paas.mapper.IndustryMapper;
import com.hummingbird.paas.mapper.ObjectAttachmentMapper;
import com.hummingbird.paas.mapper.ObjectBaseinfoMapper;
import com.hummingbird.paas.mapper.ObjectBondSettingMapper;
import com.hummingbird.paas.mapper.ObjectCertificationRequirementMapper;
import com.hummingbird.paas.mapper.ProjectEvaluationBiddeeMapper;
import com.hummingbird.paas.mapper.ProjectInfoMapper;
import com.hummingbird.paas.mapper.QandaMapper;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.EvaluateBidderBodyVO;
import com.hummingbird.paas.vo.InviteTenderVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.MyTenderObjectListVO;
import com.hummingbird.paas.vo.QueryAnswerMethodInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidEvaluationTypeInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidFileTypeInfoResult;
import com.hummingbird.paas.vo.QueryBidIndexListResult;
import com.hummingbird.paas.vo.QueryBidIndexSurveyResult;
import com.hummingbird.paas.vo.QueryBidderListResultVO;
import com.hummingbird.paas.vo.QueryCertificateListResultBodyVO;
import com.hummingbird.paas.vo.QueryCertificateListResultVO;
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
import com.hummingbird.paas.vo.SaveAnswerMethodInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidEvaluationTypeInfoBodyVO;
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
import com.hummingbird.paas.vo.TenderMyBuildingObjectVO;
import com.hummingbird.paas.vo.TenderMyEndedObjectVO;
import com.hummingbird.paas.vo.TenderMyObjectBidReturnVO;
import com.hummingbird.paas.vo.TenderObjectListReturnVO;

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
	CertificationTypeMapper tmDao;
	@Autowired
	BidObjectMapper dao;
	@Autowired
	TokenService tokenSrv;
	@Autowired
	ObjectProjectInfoMapper bpdao;
	@Autowired
	ObjectBaseinfoMapper obidao;
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
	ProjectInfoMapper projectInfoDao;
	@Autowired
	ProjectEvaluationBiddeeMapper evaluationBiddeeDao;
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
	public MyObjectTenderSurveyBodyVOResult queryMyObjectTenderSurvey(String appId, MyObjectTenderSurveyBodyVO body,
			Biddee biddee) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("我的招标评标概况接口开始");
		}
		throw new BusinessException("未完成 ");
		// Project project = dao.selectByPrimaryKey(body.getObjectId());
		// ValidateUtil.assertNull(project, "标的");
		// ObjectProjectInfo pi = bpdao.selectByPrimaryKey(body.getObjectId());
		// MyObjectTenderSurveyBodyVOResult result =
		// bidRecordDao.selectTenderSurveyByObjectId(body.getObjectId());
		// result.setObjectName(project.getObjectName());

		// if(log.isDebugEnabled()){
		// log.debug("我的招标评标概况接口完成");
		// }
		// return result;
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
		BidObject bo  = null;
		if(StringUtils.isBlank(body.getObjectId())){
			//查询有没有未完成的
			List<BidObject> selectUnfinishObject = dao.selectUnfinishObject(biddeeId, null);
			if(selectUnfinishObject!=null&&!selectUnfinishObject.isEmpty())
			{
				bo = selectUnfinishObject.get(0);
			}
		}
		else{
			
			bo = dao.selectByPrimaryKey(body.getObjectId());
			if(bo!=null){
				//检查编号是否存在
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
//			bo.setIndustryId(body.getIndustryId());
			bo.setObjectNo(body.getBiddingNo());
			bo.setObjectScope(body.getObjectScope());
			bo.setBiddeeCompanyPrincipal(body.getBiddeeCompanyPrincipal());
			bo.setBiddeeCompanyTelephone(body.getBiddeeCompanyTelephone());
			bo.setCurrency(body.getCurrency());
			bo.setContractType(body.getContractType());
			bo.setEvaluationAmount(body.getEvaluationAmount());
			bo.setObjectAmount(0l);
			bo.setProjectExpectPeriod(0);
			bo.setBidBondAmount(0l);
			bo.setObjectStatus(CommonStatusConst.STATUS_CREATE);
			bo.setEvaluationAmountVisiable(StringUtils.defaultIfEmpty(body.getEvaluationAmountVisiable(),"ENB"));
			bo.setInsertTime(new Date());

			dao.insert(bo);
		} else {
			bo.setBiddeeId(biddeeId);
			bo.setObjectName(body.getObjectName());
			bo.setObjectName(body.getObjectName());
//			bo.setIndustryId(body.getIndustryId());
			bo.setObjectNo(body.getBiddingNo());
			bo.setObjectScope(body.getObjectScope());
			bo.setBiddeeCompanyPrincipal(body.getBiddeeCompanyPrincipal());
			bo.setBiddeeCompanyTelephone(body.getBiddeeCompanyTelephone());
			bo.setCurrency(body.getCurrency());
			bo.setContractType(body.getContractType());
			bo.setEvaluationAmount(body.getEvaluationAmount());
			bo.setObjectAmount(0l);
			bo.setProjectExpectPeriod(0);
			bo.setBidBondAmount(0l);
			bo.setEvaluationAmountVisiable(StringUtils.defaultIfEmpty(body.getEvaluationAmountVisiable(),"ENB"));
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
				if(StringUtils.isNotBlank(body.getLandUseCertificateEndDate())){
					bpi.setLandUseCertificateEnddate(DateUtil.parse(body.getLandUseCertificateEndDate()).getTime());
				}
				bpi.setLandUseCertificateUrl(body.getLandUseCertificateUrl());
				bpi.setConstructionLandUsePermitNo(body.getConstructionLandUsePermitNo());
				if(StringUtils.isNotBlank(body.getConstructionLandUsePermitEndDate())){
					
					bpi.setConstructionLandUsePermitEnddate(
							DateUtil.parse(body.getConstructionLandUsePermitEndDate()).getTime());
				}
				bpi.setConstructionLandUsePermitUrl(body.getConstructionLandUsePermitUrl());
				bpi.setBuildingPermitNo(body.getBuildingPermitNo());
				if(StringUtils.isNotBlank(body.getBuildingPermitEndDate())){
					
					bpi.setBuildingPermitEnddate(DateUtil.parse(body.getBuildingPermitEndDate()).getTime());
				}
				bpi.setBuildingPermitUrl(body.getBuildingPermitUrl());
				bpi.setLetterOfAcceptanceUrl(body.getLetterOfAcceptanceUrl());
				bpi.setBuildingConstructionPermitNo(body.getBuildingConstructPermitNo());
				if(StringUtils.isNotBlank(body.getBuildingConstructPermitEndDate())){
					bpi.setBuildingConstructionPermitEnddate(
							DateUtil.parse(body.getBuildingConstructPermitEndDate()).getTime());
				}
				bpi.setBuildingConstructionPermitUrl(body.getBuildingConstructPermitUrl());
				bpi.setObjectId(body.getObjectId());
				bpdao.insert(bpi);
			} else {

				bpi.setConstructionProveType(body.getConstructionProveType());
				bpi.setLandUseCertificateNo(body.getLandUseCertificateNo());
				if(StringUtils.isNotBlank(body.getLandUseCertificateEndDate())){
					bpi.setLandUseCertificateEnddate(DateUtil.parse(body.getLandUseCertificateEndDate()).getTime());
				}
				bpi.setLandUseCertificateUrl(body.getLandUseCertificateUrl());
				bpi.setConstructionLandUsePermitNo(body.getConstructionLandUsePermitNo());
				if(StringUtils.isNotBlank(body.getConstructionLandUsePermitEndDate())){
					bpi.setConstructionLandUsePermitEnddate(
							DateUtil.parse(body.getConstructionLandUsePermitEndDate()).getTime());
				}
				bpi.setConstructionLandUsePermitUrl(body.getConstructionLandUsePermitUrl());
				bpi.setBuildingPermitNo(body.getBuildingPermitNo());
				if(StringUtils.isNotBlank(body.getBuildingPermitEndDate())){
					bpi.setBuildingPermitEnddate(DateUtil.parse(body.getBuildingPermitEndDate()).getTime());
				}
				bpi.setBuildingPermitUrl(body.getBuildingPermitUrl());
				bpi.setLetterOfAcceptanceUrl(body.getLetterOfAcceptanceUrl());
				bpi.setBuildingConstructionPermitNo(body.getBuildingConstructPermitNo());
				if(StringUtils.isNotBlank(body.getBuildingConstructPermitEndDate())){
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
				objectCertificationRequirement.setCertificationName(ObjectUtils.toString(map.get("certificateName")));
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
		Integer objectBidderBond = obsDao.getObjectBidderBond(body.getObjectId());
		QueryObjectBondInfoResult result = new QueryObjectBondInfoResult();
		if (objectBidderBond != null) {
			result.setBidBondAmount(ObjectUtils.toString(objectBidderBond ));
		}
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
		ObjectBondSetting ob = obsDao.selectByObjectId(bo.getObjectId());
		if (ob == null) {
			ob = new ObjectBondSetting();
			ob.setObjectId(bo.getObjectId());
			ob.setBiddeeBond(0l);
			ob.setBidderBidBond(body.getBidBondAmount());
			obsDao.insert(ob);
		} else {
			ob.setBidderBidBond(body.getBidBondAmount());
			obsDao.updateByPrimaryKey(ob);
		}

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
		//从附件表中查询,如果有多个,则尝试拿名称有标记 TF#,如果没有,则尝试拿 第一个
		List<ObjectAttachment> attachments = oaDao.selectTenderFileByObjectId(bo.getObjectId());
		if(attachments!=null&&!attachments.isEmpty()){
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
		if(bo==null){
			throw ValidateException.ERROR_PARAM_NULL.clone(null, "招标项目不存在");
		}
		ValidateUtil.assertNotEqual(bo.getObjectStatus(), "CRT", "项目非编制中,不能进行操作");
		ValidateUtil.assertEmpty(body.getTenderFile(), "招标文件");
		
		bo.setNeedBusinessStandard(StringUtils.defaultIfEmpty(body.getNeedBusinessStandard(), "NO#"));
		bo.setNeedCertificationCheckupFile(StringUtils.defaultIfEmpty(body.getNeedCertificationCheckupFile(), "NO#"));
		bo.setNeedTechnicalStandard(StringUtils.defaultIfEmpty(body.getNeedTechnicalStandard(), "NO#"));
		dao.updateByPrimaryKey(bo);
		//删除原来的文件
		List<ObjectAttachment> selctByObjectId = oaDao.selectTenderFileByObjectId(bo.getObjectId());
		for (Iterator iterator = selctByObjectId.iterator(); iterator.hasNext();) {
			ObjectAttachment objectAttachment = (ObjectAttachment) iterator.next();
			oaDao.deleteByPrimaryKey(objectAttachment.getId());
		}
		//重新添加
		ObjectAttachment objectAttachment = new ObjectAttachment();
		objectAttachment.setObjectId(bo.getObjectId());
		objectAttachment.setInsertTime(new Date());
		objectAttachment.setAttachmentUrl(body.getTenderFile());
//		objectAttachment.getInsertBy();
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
		if (log.isDebugEnabled()) {
			log.debug("saveObjectMethodInfo完成");
		}
	}

	@Override
	public List<TenderMyObjectBidReturnVO> selectByObjectIdInValid(Integer userId, String objectId, Pagingnation page) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<TenderMyObjectBidReturnVO> selectByObjectIdInValid(Integer userId, String objectId, Pagingnation page) {
//		// TODO Auto-generated method stub
//		org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
//		
//		if(page!=null&&page.isCountsize()){
//			int totalcount = notificationDao.selectTotalCountByTokenAndStatus(token, status);
//			page.setTotalCount(totalcount);
//			page.calculatePageCount();
//		}
//		List<InstationNotification> nos = notificationDao.selectByUserInValid(token, status, page); 
//		
//		return nos;
//	}

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
		ValidateUtil.assertNull(bo, "招标项目不存在");
		Qanda qanda = qaDao.selectByObjectId(body.getObjectId());
		QueryAnswerMethodInfoBodyVOResult result = new QueryAnswerMethodInfoBodyVOResult();
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
		if (log.isDebugEnabled()) {
			log.debug("发布标的接口完成");
		}
	}

	@Override
	public List<MyTenderObjectListVO> getTenderObjectList(Integer user_id, Pagingnation page) throws BusinessException {
		// TODO Auto-generated method stub

		org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
		
		if(page!=null&&page.isCountsize()){
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
		// TODO Auto-generated method stub
		org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
		
		if(page!=null&&page.isCountsize()){
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
		// TODO Auto-generated method stub
		org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
		
		if(page!=null&&page.isCountsize()){
			int totalcount = dao.selectTotalTenderEndedObject(user_id);
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<TenderMyEndedObjectVO> ans = dao.selectTenderEndedObject(user_id, page); 
		
		return ans;
	}

	@Override
	public List<TenderObjectListReturnVO> getTenderObjectList(String[] keywords, Pagingnation page)
			throws BusinessException {
		// TODO Auto-generated method stub
		org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
		
		if(page!=null&&page.isCountsize()){
			int totalcount = dao.selectTotalTenderObjectList(keywords);
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<TenderObjectListReturnVO> ans = dao.selectTenderObjectList(keywords, page); 
		
		return ans;
	}

	@Override
//	public List<QueryIndexObjectListResult> getIndexObjectList(Pagingnation page) throws BusinessException {
	public List<QueryIndexObjectListResult> getIndexObjectList() throws BusinessException {
		// TODO Auto-generated method stub
		org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
		com.hummingbird.common.face.Pagingnation page = new Pagingnation();
		page.setCurrPage(1);
		page.setPageSize(10);
		if(page!=null&&page.isCountsize()){
			int totalcount = dao.selectTotalIndexObjectList();
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<QueryIndexObjectListResult> ans = dao.selectIndexObjectList(page); 
		
		return ans;
	}

	@Override
	public QueryBidIndexSurveyResult getBidIndexSurvey() throws BusinessException {
			QueryBidIndexSurveyResult bis = dao.selectBidIndexSurvey();
			return bis;
	}

	@Override
	public List<QueryBidIndexListResult> getBidIndexList(Pagingnation page,String projectName,Integer publishTime) throws BusinessException {
		if(page!=null&&page.isCountsize()){
			int totalcount = dao.selectTotalBidIndexList(projectName,publishTime);
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		List<QueryBidIndexListResult> ans = dao.selectBidIndexList(projectName,publishTime,page); 
		
		return ans;
	}
	
	public List<QueryBidderListResultVO> queryBidderList() throws BusinessException {
		List<Bidder> bers = berDao.selectAll();
		List<QueryBidderListResultVO> qlr = new ArrayList<QueryBidderListResultVO>();
		QueryBidderListResultVO qr = null;
		for (Bidder ber : bers) {
			qr = new QueryBidderListResultVO();
			qr.setBidderId(ber.getId());
			qr.setBidderName(ber.getCompanyName());
			qlr.add(qr);
		}
		return qlr;
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
	public List<QueryCertificateListResultVO> queryCertificateList(){
		if (log.isDebugEnabled()) {
			log.debug("查询资质证书类型列表接口开始");
		}
		List<Industry> inds = indDao.selectAll();
		if(inds == null){
			if(log.isDebugEnabled()){
			    log.debug("得到industry为空"+inds);
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
			List<CertificationType> cs = tmDao.selectAllTypes(ind.getId());
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
		// TODO Auto-generated method stub
		List<Bidder> bers = berDao.getIndexBidListPages(pageIndex,pageSize);
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
	public void evaluateBidder(EvaluateBidderBodyVO body,User user)
			throws MaAccountException {
		ProjectInfo project=projectInfoDao.selectByObjectId(body.getObjectId())==null?null:projectInfoDao.selectByObjectId(body.getObjectId()).get(0);
		if(project==null){
			if(log.isDebugEnabled()){
				log.debug(String.format("根据项目编号【%s】查询项目信息失败", body.getObjectId()));
			}throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,String.format("根据项目编号【%s】查询项目信息失败", body.getObjectId()));
		}
		ProjectEvaluationBiddee evaluationBiddee=new ProjectEvaluationBiddee();
		evaluationBiddee.setBiddeeId(project.getBiddeeId());
		evaluationBiddee.setBidderId(project.getBidderId());
		evaluationBiddee.setEvaluationContent(body.getEvaluateContent());
		evaluationBiddee.setInsertBy(user.getId().toString());
		evaluationBiddee.setInsertTime(new Date());
		evaluationBiddee.setProjectId(project.getProjectId());
		evaluationBiddee.setScore(body.getEvaluateScore());
		evaluationBiddee.setStarCount(evaluationBiddee.getStarCount());
		//标签部分缺少
		evaluationBiddeeDao.insert(evaluationBiddee);
		
		
	}
}