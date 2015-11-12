package com.hummingbird.paas.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.commonbiz.util.NoGenerationUtil;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.BidProjectInfo;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.ObjectAttachment;
import com.hummingbird.paas.entity.ObjectBondSetting;
import com.hummingbird.paas.entity.ObjectCertificationRequirement;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidProjectInfoMapper;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.mapper.ObjectAttachmentMapper;
import com.hummingbird.paas.mapper.ObjectBaseinfoMapper;
import com.hummingbird.paas.mapper.ObjectBondSettingMapper;
import com.hummingbird.paas.mapper.ObjectCertificationRequirementMapper;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.QueryBidFileTypeInfoResult;
import com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectBondInfoResult;
import com.hummingbird.paas.vo.QueryObjectCertificationInfoResult;
import com.hummingbird.paas.vo.QueryObjectConstructionInfoResult;
import com.hummingbird.paas.vo.QueryObjectProjectInfoResult;
import com.hummingbird.paas.vo.SaveBidFileTypeInfo;
import com.hummingbird.paas.vo.SaveObjectBaseInfo;
import com.hummingbird.paas.vo.SaveObjectBondInfo;
import com.hummingbird.paas.vo.SaveObjectCertificationInfo;
import com.hummingbird.paas.vo.SaveObjectConstructionInfo;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVO;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVOResult;
import com.hummingbird.paas.vo.SaveProjectRequirementInfoBodyVO;

/**
 * @author
 * @date 2015-11-08
 * @version 1.0 service接口实现
 */
@Service
public class TenderServiceImpl implements TenderService {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());

	@Autowired
	BidObjectMapper dao;
	@Autowired
	TokenService tokenSrv;
	@Autowired
	BidProjectInfoMapper bpdao;
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
		// BidProjectInfo pi = bpdao.selectByPrimaryKey(body.getObjectId());
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
		result.setObjectName(object.getObjectName());
		result.setBiddingNo(object.getObjectId());
		result.setObjectScope(object.getObjectScope());
		result.setBiddeeCompanyPrincipal(object.getBiddeeCompanyPrincipal());
		result.setBiddeeCompanyTelephone(object.getObjectName());
		result.setCurrency(object.getObjectName());
		result.setContractType(object.getObjectName());
		result.setEvaluationAmount(object.getObjectName());

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
	public String saveObjectBaseInfo(String appId, SaveObjectBaseInfo body, Integer biddeeId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目基础信息接口开始");
		}

		BidObject bo = null;
		List<BidObject> objs = dao.selectUnfinishObject(biddeeId, body.getObjectId());
		if (objs != null && !objs.isEmpty()) {
			bo = objs.get(0);
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
			bo.setIndustryId(body.getIndustryId());
			bo.setObjectNo(body.getBiddingNo());
			bo.setObjectScope(body.getObjectScope());
			bo.setBiddeeCompanyPrincipal(body.getBiddeeCompanyPrincipal());
			bo.setBiddeeCompanyTelephone(body.getBiddeeCompanyTelephone());
			bo.setCurrency(body.getCurrency());
			bo.setContractType(body.getContractType());
			bo.setEvaluationAmount(body.getEvaluationAmount());
			bo.setObjectAmount(0);
			bo.setProjectExpectPeriod(0);
			bo.setBidBondAmount(0);
			bo.setObjectStatus(CommonStatusConst.STATUS_CREATE);

			dao.insert(bo);
		} else {
			bo.setBiddeeId(biddeeId);
			bo.setObjectName(body.getObjectName());
			bo.setObjectName(body.getObjectName());
			bo.setIndustryId(body.getIndustryId());
			bo.setObjectNo(body.getBiddingNo());
			bo.setObjectScope(body.getObjectScope());
			bo.setBiddeeCompanyPrincipal(body.getBiddeeCompanyPrincipal());
			bo.setBiddeeCompanyTelephone(body.getBiddeeCompanyTelephone());
			bo.setCurrency(body.getCurrency());
			bo.setContractType(body.getContractType());
			bo.setEvaluationAmount(body.getEvaluationAmount());
			bo.setObjectAmount(0);
			bo.setProjectExpectPeriod(0);
			bo.setBidBondAmount(0);
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
		BidProjectInfo bidproject = null;
		List<BidProjectInfo> projects = bpdao.selectProjects(biddeeId, body.getObjectId(),
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
	public void saveObjectProjectInfo(String appId, int userId, SaveObjectProjectInfoBodyVO body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程信息接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		BidProjectInfo bp = bpdao.selectByPrimaryKey(body.getObjectId());
		if (bp == null) {
			bp = new BidProjectInfo();

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
		BidProjectInfo bidproject = null;
		List<BidProjectInfo> projects = bpdao.selectProjects(biddeeId, body.getObjectId(),
				CommonStatusConst.STATUS_CREATE);
		if (projects != null && !projects.isEmpty()) {
			bidproject = projects.get(0);
		}
		BidProjectInfo bpi = bidproject;
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
	public void saveProjectRequirementInfo(String appId, SaveProjectRequirementInfoBodyVO body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程施工证明接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		// 请自行调整
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		BidProjectInfo bpi = bpdao.selectByPrimaryKey(body.getObjectId());
		if (bpi == null) {
			bpi = new BidProjectInfo();
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
		BidProjectInfo bpi = null;
		List<BidProjectInfo> projects = bpdao.selectProjects(biddeeId, body.getObjectId(),
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
	public void saveObjectConstructionInfo(String appId, SaveObjectConstructionInfo body, Integer biddeeId)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程施工证明接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		// 请自行调整
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		BidProjectInfo bpi = bpdao.selectByPrimaryKey(body.getObjectId());
		try {
			if (bpi == null) {
				bpi = new BidProjectInfo();
				bpi.setConstructionProveType(body.getConstructionProveType());
				bpi.setLandUseCertificateNo(body.getLandUseCertificateNo());
				bpi.setLandUseCertificateEnddate(DateUtil.parse(body.getLandUseCertificateEndDate()).getTime());
				bpi.setLandUseCertificateUrl(body.getLandUseCertificateUrl());
				bpi.setConstructionLandUsePermitNo(body.getConstructionLandUsePermitNo());
				bpi.setConstructionLandUsePermitEnddate(
						DateUtil.parse(body.getConstructionLandUsePermitEndDate()).getTime());
				bpi.setConstructionLandUsePermitUrl(body.getConstructionLandUsePermitUrl());
				bpi.setBuildingPermitNo(body.getBuildingPermitNo());
				bpi.setBuildingPermitEnddate(DateUtil.parse(body.getBuildingPermitEndDate()).getTime());
				bpi.setBuildingPermitUrl(body.getBuildingPermitUrl());
				bpi.setLetterOfAcceptanceUrl(body.getLetterOfAcceptanceUrl());
				bpi.setBuildingConstructionPermitNo(body.getBuildingConstructPermitNo());
				bpi.setBuildingConstructionPermitEnddate(
						DateUtil.parse(body.getBuildingConstructPermitEndDate()).getTime());
				bpi.setBuildingConstructionPermitUrl(body.getBuildingConstructPermitUrl());
				bpi.setObjectId(body.getObjectId());
				bpdao.insert(bpi);
			} else {

				bpi.setConstructionProveType(body.getConstructionProveType());
				bpi.setLandUseCertificateNo(body.getLandUseCertificateNo());
				bpi.setLandUseCertificateEnddate(DateUtil.parse(body.getLandUseCertificateEndDate()).getTime());
				bpi.setLandUseCertificateUrl(body.getLandUseCertificateUrl());
				bpi.setConstructionLandUsePermitNo(body.getConstructionLandUsePermitNo());
				bpi.setConstructionLandUsePermitEnddate(
						DateUtil.parse(body.getConstructionLandUsePermitEndDate()).getTime());
				bpi.setConstructionLandUsePermitUrl(body.getConstructionLandUsePermitUrl());
				bpi.setBuildingPermitNo(body.getBuildingPermitNo());
				bpi.setBuildingPermitEnddate(DateUtil.parse(body.getBuildingPermitEndDate()).getTime());
				bpi.setBuildingPermitUrl(body.getBuildingPermitUrl());
				bpi.setLetterOfAcceptanceUrl(body.getLetterOfAcceptanceUrl());
				bpi.setBuildingConstructionPermitNo(body.getBuildingConstructPermitNo());
				bpi.setBuildingConstructionPermitEnddate(
						DateUtil.parse(body.getBuildingConstructPermitEndDate()).getTime());
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
	public QueryObjectCertificationInfoResult queryObjectCertificationInfo(String appId, QueryObjectBodyVO body, Integer biddeeId)
			throws BusinessException {
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
			Map<String,Object> certmap = new HashMap<>();
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
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	public void saveObjectCertificationInfo(String appId,SaveObjectCertificationInfo body,Integer biddeeId) throws BusinessException{
		if(log.isDebugEnabled()){
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
		bo.setNeedConstructorCertification(body.getNeedConstructorCertification());
		bo.setNeedPmCertification(body.getNeedPmCertification());
		bo.setNeedPmSafetyCertification(body.getNeedPmSafetyCertification());
		bo.setNeedSafetyPermit(body.getNeedSafetyPermit());
		
		dao.updateByPrimaryKey(bo);
		//删除原有数据 ,并重新插入数据 
		int deleteByObjectId = ocrDao.deleteByObjectId(body.getObjectId());
		
		List<Map> bidderCertification = body.getBidderCertification();
		
		if(bidderCertification!=null){
			for (Iterator iterator = bidderCertification.iterator(); iterator.hasNext();) {
				Map map = (Map) iterator.next();
				ObjectCertificationRequirement objectCertificationRequirement = new ObjectCertificationRequirement();
				objectCertificationRequirement.setCertificationId(NumberUtils.toInt(ObjectUtils.toString(map.get("certificateId" ))));
				objectCertificationRequirement.setCertificationName(ObjectUtils.toString(map.get("certificateName" )));
				objectCertificationRequirement.setIndustryId(ObjectUtils.toString(map.get("industryId")));
				objectCertificationRequirement.setObjectId(bo.getObjectId());
				ocrDao.insert(objectCertificationRequirement);
			}
		}
		
		// 请自行调整
		if(log.isDebugEnabled()){
				log.debug("保存招标项目资质要求接口完成");
		}
	}
	
	
	/**
	 * 查询未完成招标项目保证金接口
	 * @param appId 应用id
	 * @param body 参数
	 * @return 
	 * @throws BusinessException 
	 */
	public QueryObjectBondInfoResult queryObjectBondInfo(String appId,QueryObjectBodyVO body,Integer biddeeId) throws BusinessException{
		if(log.isDebugEnabled()){
				log.debug("查询未完成招标项目保证金接口开始");
		}
		ValidateUtil.assertNull(body.getObjectId(), "招标编号");
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		Integer objectBidderBond = obsDao.getObjectBidderBond(body.getObjectId());
		QueryObjectBondInfoResult result = new QueryObjectBondInfoResult();
		if(objectBidderBond!=null)
		{
			result.setBidBondAmount(objectBidderBond/100+"元");
		}
		if(log.isDebugEnabled()){
				log.debug("查询未完成招标项目保证金接口完成");
		}
		return result;
	}
	
	/**
 * 保存招标项目保证金接口
 * @param appId 应用id
 * @param body 参数
 * @return 
 * @throws BusinessException 
 */
public void saveObjectBondInfo(String appId,SaveObjectBondInfo body,Integer biddeeId) throws BusinessException{
	if(log.isDebugEnabled()){
			log.debug("保存招标项目保证金接口开始");
	}
	ValidateUtil.assertNull(body.getObjectId(), "招标编号");
	BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
	ValidateUtil.assertNull(bo, "招标项目不存在");
	ObjectBondSetting ob = obsDao.selectByObjectId(bo.getObjectId()); 
	if(ob==null)
	{
		ob = new ObjectBondSetting();
		ob.setObjectId(bo.getObjectId());
		ob.setBidderBidBond(body.getBidBondAmount());
		obsDao.insert(ob);
	}
	else{
		ob.setBidderBidBond(body.getBidBondAmount());
		obsDao.updateByPrimaryKey(ob);
	}
	
	if(log.isDebugEnabled()){
			log.debug("保存招标项目保证金接口完成");
	}
}

/**
* 查询未完成招标项目投标文件接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public QueryBidFileTypeInfoResult queryBidFileTypeInfo(String appId,QueryObjectBodyVO body,Integer biddeeId) throws BusinessException
{
	if(log.isDebugEnabled()){
		log.debug("查询未完成招标项目投标文件接口开始");
	}
	ValidateUtil.assertNull(body.getObjectId(), "招标编号");
	BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
	ValidateUtil.assertNull(bo, "招标项目不存在");
	QueryBidFileTypeInfoResult result = new QueryBidFileTypeInfoResult();
	result.setNeedBusinessStandard(bo.getNeedBusinessStandard());
	result.setNeedCertificationCheckupFile(bo.getNeedCertificationCheckupFile());
	result.setNeedTechnicalStandard(bo.getNeedTechnicalStandard());
	// 请自行调整
	if(log.isDebugEnabled()){
		log.debug("查询未完成招标项目投标文件接口完成");
	}
	return result;
	
}


/**
* 保存招标项目投标文件接口
* @param appId 应用id
* @param body 参数
* @return 
* @throws BusinessException 
*/
public void saveBidFileTypeInfo(String appId,SaveBidFileTypeInfo body,Integer biddeeId) throws BusinessException{
	if(log.isDebugEnabled()){
		log.debug("保存招标项目投标文件接口开始");
	}
	ValidateUtil.assertNull(body.getObjectId(), "招标编号");
	BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
	ValidateUtil.assertNull(bo, "招标项目不存在");
	bo.setNeedBusinessStandard(StringUtils.defaultIfEmpty(body.getNeedBusinessStandard(),"NO#"));
	bo.setNeedCertificationCheckupFile(StringUtils.defaultIfEmpty(body.getNeedCertificationCheckupFile(),"NO#"));
	bo.setNeedTechnicalStandard(StringUtils.defaultIfEmpty(body.getNeedTechnicalStandard(),"NO#"));
	dao.updateByPrimaryKey(bo);
	// 请自行调整
	if(log.isDebugEnabled()){
			log.debug("保存招标项目投标文件接口完成");
	}
}




}