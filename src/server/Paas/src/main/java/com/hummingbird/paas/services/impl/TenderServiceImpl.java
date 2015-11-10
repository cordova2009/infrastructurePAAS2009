package com.hummingbird.paas.services.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.commonbiz.util.NoGenerationUtil;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.BidProjectInfo;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidProjectInfoMapper;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.mapper.ObjectBaseinfoMapper;
import com.hummingbird.paas.services.TenderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVO;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBaseInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
import com.hummingbird.paas.vo.QueryObjectProjectInfoResult;
import com.hummingbird.paas.vo.SaveObjectBaseInfo;
import com.hummingbird.paas.vo.SaveObjectProjectInfoBodyVO;

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
		BidObject bo = new BidObject();
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
	public void saveObjectProjectInfo(String appId,int userId, SaveObjectProjectInfoBodyVO body) throws BusinessException {
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程信息接口开始");
		}
		BidProjectInfo bp = new BidProjectInfo();
		BidObject bo = dao.selectByPrimaryKey(body.getObjectId());
		ValidateUtil.assertNull(bo, "招标项目不存在");
		bp.setObjectId(bo.getObjectId());
		bp.setProjectName            (body.getProjectName            ());
		bp.setProjectSite            (body.getProjectSite            ());
		bp.setProjectScale           (body.getProjectScale           ());
		bp.setProjectExpectInvestment(body.getProjectExpectInvestment());
		bp.setEmployer               (body.getEmployer               ());
		bp.setEmployerPrincipal      (body.getEmployerPrincipal      ());
		bp.setEmployerTelephone      (body.getEmployerTelephone      ());
		
		bpdao.insert(bp);
		
		if (log.isDebugEnabled()) {
			log.debug("保存招标项目工程信息接口完成");
		}
	}

	/**
 * 查询未完成招标项目工程要求接口
 * @param appId 应用id
 * @param body 参数
 * @return 
 * @throws BusinessException 
 */
public void queryProjectRequirementInfo(String appId,QueryObjectBodyVO body) throws BusinessException{
	if(log.isDebugEnabled()){
			log.debug("查询未完成招标项目工程要求接口开始");
		}
	// 请自行调整
	if(log.isDebugEnabled()){
			log.debug("查询未完成招标项目工程要求接口完成");
	}
}
	
}