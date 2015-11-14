package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.commonbiz.util.NoGenerationUtil;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.BidProjectInfo;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.BiddeeCredit;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.CertificationType;
import com.hummingbird.paas.entity.Industry;
import com.hummingbird.paas.entity.Objects;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidProjectInfoMapper;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.mapper.BiddeeCreditMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.CertificationTypeMapper;
import com.hummingbird.paas.mapper.IndustryCertificationMapper;
import com.hummingbird.paas.mapper.IndustryMapper;
import com.hummingbird.paas.mapper.ObjectBaseinfoMapper;
import com.hummingbird.paas.mapper.ObjectMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.QueryBidderListResultVO;
import com.hummingbird.paas.vo.QueryCertificateListResultBodyVO;
import com.hummingbird.paas.vo.QueryCertificateListResultVO;
import com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectConstructionInfoResult;
import com.hummingbird.paas.vo.QueryObjectListResultVO;
import com.hummingbird.paas.vo.QueryObjectProjectInfoResult;
import com.hummingbird.paas.vo.SaveObjectBaseInfo;
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
	IndustryMapper indDao;
	@Autowired
	IndustryCertificationMapper icmDao;
	@Autowired
	CertificationTypeMapper tmDao;
	@Autowired
	BiddeeMapper beeDao;
    @Autowired
    ObjectMapper obDao;
    @Autowired
    BiddeeCreditMapper bcDao;
    @Autowired
    ScoreLevelMapper slDao;
    @Autowired
    BidderMapper berDao;
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
	public MyObjectTenderSurveyBodyVOResult queryMyObjectTenderSurvey(String appId, MyObjectTenderSurveyBodyVO body)
			throws BusinessException {
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
	public QueryObjectBaseInfoBodyVOResult queryObjectBaseInfo(String appId, QueryObjectBodyVO body)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目基础信息接口开始");
		}
		BidObject object = dao.selectByPrimaryKey(body.getObjectId());
		if (object == null) {
			if (log.isDebugEnabled()) {
				log.debug(String.format("平台招标编号%s没有招标信息", body.getObjectId()));
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
	public String saveObjectBaseInfo(String appId, SaveObjectBaseInfo body, Integer userId) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目基础信息接口开始");
		}
		// 从token 查找 用户id

		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		if (bo == null) {
			bo = new BidObject();

			if (StringUtils.isNotBlank(body.getObjectId())) {
				bo.setObjectId(body.getObjectId());
			} else {
				bo.setObjectId(NoGenerationUtil.genNO("ZB00", 6));
			}
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
			dao.insert(bo);
		} else {
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
	public QueryObjectProjectInfoResult queryObjectProjectInfo(String appId, QueryObjectBodyVO body)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目工程信息接口开始");
		}
		// 请自行调整
		BidProjectInfo bidproject = bpdao.selectByPrimaryKey(body.getObjectId());
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
	public void saveObjectProjectInfo(String appId, int userId, SaveObjectProjectInfoBodyVO body)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程信息接口开始");
		}
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

			bpdao.insert(bp);
			bpdao.updateByPrimaryKey(bp);
		}

		bp.setObjectId(bo.getObjectId());
		bp.setProjectName(body.getProjectName());
		bp.setProjectSite(body.getProjectSite());
		bp.setProjectScale(body.getProjectScale());
		bp.setProjectExpectInvestment(body.getProjectExpectInvestment());
		bp.setEmployer(body.getEmployer());
		bp.setEmployerPrincipal(body.getEmployerPrincipal());
		bp.setEmployerTelephone(body.getEmployerTelephone());

		bpdao.insert(bp);

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
	public SaveObjectProjectInfoBodyVOResult queryProjectRequirementInfo(String appId, QueryObjectBodyVO body)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目工程要求接口开始");
		}
		// 请自行调整
		BidProjectInfo bpi = bpdao.selectByPrimaryKey(body.getObjectId());
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
	public void saveProjectRequirementInfo(String appId, SaveProjectRequirementInfoBodyVO body)
			throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程施工证明接口开始");
		}
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
	 * 查询未完成招标项目工程施工证明接口
	 * 
	 * @param appId
	 *            应用id
	 * @param body
	 *            参数
	 * @return
	 * @throws BusinessException
	 */
	public void queryObjectConstructionInfo(String appId, QueryObjectBodyVO body) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目工程施工证明接口开始");
		}
		BidProjectInfo bpi = bpdao.selectByPrimaryKey(body.getObjectId());
		QueryObjectConstructionInfoResult result = null;
		if (bpi != null) {
			result = new QueryObjectConstructionInfoResult();
			result.setConstructionProveType(bpi.getConstructionProveType());
			result.setLandUseCertificateNo(bpi.getLandUseCertificateNo());
			// result.setLandUseCertificateEndDate
			// (bpi.getLandUseCertificateEndDate ());
			// result.setLandUseCertificateUrl (bpi.getLandUseCertificateUrl
			// ());
			// result.setConstructionLandUsePermitNo
			// (bpi.getConstructionLandUsePermitNo ());
			// result.setConstructionLandUsePermitEndDate(bpi.getConstructionLandUsePermitEndDate());
			// result.setConstructionLandUsePermitUrl
			// (bpi.getConstructionLandUsePermitUrl ());
			// result.setBuildingPermitNo (bpi.getBuildingPermitNo ());
			// result.setBuildingPermitEndDate (bpi.getBuildingPermitEndDate
			// ());
			// result.setBuildingPermitUrl (bpi.getBuildingPermitUrl ());
			// result.setLetterOfAcceptanceUrl (bpi.getLetterOfAcceptanceUrl
			// ());
			// result.setBuildingConstructPermitNo
			// (bpi.getBuildingConstructPermitNo ());
			// result.setBuildingConstructPermitEndDate
			// (bpi.getBuildingConstructPermitEndDate ());
			// result.setBuildingConstructPermitUrl
			// (bpi.getBuildingConstructPermitUrl ());

		}
		if (log.isDebugEnabled()) {
			log.debug("查询未完成招标项目工程施工证明接口完成");
		}
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
	
}