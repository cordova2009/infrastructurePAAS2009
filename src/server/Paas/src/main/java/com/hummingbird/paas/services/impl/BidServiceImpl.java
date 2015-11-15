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
import com.hummingbird.paas.entity.BidCertification;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.mapper.BidCertificationMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidRecordMapper;
import com.hummingbird.paas.services.BidService;
import com.hummingbird.paas.util.MoneyUtil;
import com.hummingbird.paas.vo.QueryBidBodyVO;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult_1;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult_2;
import com.hummingbird.paas.vo.QueryBidRequirementInfoBodyVOResult_3;
import com.hummingbird.paas.vo.QueryBidderBondBodyVOResult;
import com.hummingbird.paas.vo.QueryBusinessStandardInfoBodyVOResult;
import com.hummingbird.paas.vo.QueryTechnicalStandardInfoBodyVOResult;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO_1;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO_2;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO_3;
import com.hummingbird.paas.vo.SaveBidRequirementInfoBodyVO_4;
import com.hummingbird.paas.vo.SaveBidderBondBodyVO;
import com.hummingbird.paas.vo.SaveBusinessStandardInfoBodyVO;
import com.hummingbird.paas.vo.SaveTechnicalStandardInfoBodyVO;

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
	 * @throws BusinessException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public void saveBidRequirementInfo(String appId, SaveBidRequirementInfoBodyVO body, Integer bidderId)
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
		BidObject object = null;
		BidRecord bid = validateBid(body.getBidId(), body.getObjectId(), bidderId, object);
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
	public void saveBidderBond(String appId, SaveBidderBondBodyVO body,Integer bidderId) throws BusinessException {
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

}