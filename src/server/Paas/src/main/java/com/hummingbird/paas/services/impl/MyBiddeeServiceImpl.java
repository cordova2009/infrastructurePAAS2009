package com.hummingbird.paas.services.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.BiddeeBankAduit;
import com.hummingbird.paas.entity.BiddeeBankCardCerticate;
import com.hummingbird.paas.entity.BiddeeCerticate;
import com.hummingbird.paas.entity.BiddeeCertificateAduit;
import com.hummingbird.paas.entity.BiddeeCertification;
import com.hummingbird.paas.entity.BiddeeCertificationAudit;
import com.hummingbird.paas.entity.BiddeeCredit;
import com.hummingbird.paas.entity.BidderBankAduit;
import com.hummingbird.paas.entity.BidderCertificateAduit;
import com.hummingbird.paas.entity.BidderCertificationAudit;
import com.hummingbird.paas.entity.ScoreDefine;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.exception.MaAccountException;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BiddeeBankAduitMapper;
import com.hummingbird.paas.mapper.BiddeeBankCardCerticateMapper;
import com.hummingbird.paas.mapper.BiddeeBidCreditScoreMapper;
import com.hummingbird.paas.mapper.BiddeeCerticateMapper;
import com.hummingbird.paas.mapper.BiddeeCertificateAduitMapper;
import com.hummingbird.paas.mapper.BiddeeCertificationAuditMapper;
import com.hummingbird.paas.mapper.BiddeeCertificationCertificationMapper;
import com.hummingbird.paas.mapper.BiddeeCertificationCreditScoreMapper;
import com.hummingbird.paas.mapper.BiddeeCertificationMapper;
import com.hummingbird.paas.mapper.BiddeeCreditMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.BidderCertificationAuditMapper;
import com.hummingbird.paas.mapper.ScoreDefineMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.services.MyBiddeeService;
import com.hummingbird.paas.util.CamelUtil;
import com.hummingbird.paas.util.IntegerUtil;
import com.hummingbird.paas.util.StringUtil;
import com.hummingbird.paas.vo.AuditInfo;
import com.hummingbird.paas.vo.BiddeeAuditBodyInfo;
import com.hummingbird.paas.vo.BiddeeBankInfo;
import com.hummingbird.paas.vo.BiddeeBankInfoCheck;
import com.hummingbird.paas.vo.BiddeeBaseInfo;
import com.hummingbird.paas.vo.BiddeeBaseInfoCheck;
import com.hummingbird.paas.vo.BiddeeLegalPerson;
import com.hummingbird.paas.vo.BiddeeLegalPersonCheck;
import com.hummingbird.paas.vo.BiddeeRegisteredInfo;
import com.hummingbird.paas.vo.BiddeeRegisteredInfoCheck;
import com.hummingbird.paas.vo.CertificationCheck;
@Service
public class MyBiddeeServiceImpl implements MyBiddeeService {
	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	protected BiddeeCerticateMapper biddeeCerticateDao;
	@Autowired
	protected BiddeeCertificateAduitMapper biddeeCertificateAduitDao;
	@Autowired
	protected BiddeeCertificationMapper bcDao;
	@Autowired
	protected BiddeeCertificationCertificationMapper bccDao;
	@Autowired
	protected BiddeeBankCardCerticateMapper bbccDao;
	@Autowired
	protected UserBankcardMapper userBankcardDao;
	@Autowired
	protected BiddeeBidCreditScoreMapper biddeeBidCreditScoreDao;
	@Autowired
	protected BiddeeBankAduitMapper biddeeBankAduitDao;
	@Autowired
	protected BidObjectMapper bidObjectDao;
	@Autowired
	protected ScoreLevelMapper scoreLevelDao;
	@Autowired
	protected BiddeeMapper biddeeDao;
	@Autowired
	protected BiddeeCreditMapper biddeeCreditDao;
	@Autowired
	protected BiddeeCertificationCreditScoreMapper bccsDao;
	@Autowired
	protected BiddeeBidCreditScoreMapper bbcsDao;
	@Autowired
	protected BiddeeCertificationAuditMapper bcaDao;
	@Autowired
	protected ScoreDefineMapper sdDao;
	
	@Override
	public Boolean getAuthInfo(Token token) throws BusinessException {
		
		return null;
	}

	@Override
	public BiddeeBaseInfo getBaseInfo_apply(Token token) throws BusinessException {
		
		BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(token.getUserId());
		BiddeeBaseInfo baseInfo = new BiddeeBaseInfo();
		
		if(aa!=null){
			baseInfo.setLogoUrl(aa.getLogo());
			baseInfo.setCompanyName(aa.getCompanyName());
			baseInfo.setShortName(aa.getShortName());
			baseInfo.setDescription(aa.getDescription());
			baseInfo.setRegisteredCapital(aa.getRegisteredCapital());
			baseInfo.setTelephone(aa.getContactMobileNum());
			baseInfo.setEmail(aa.getEmail());
		}
		
		
		
		return baseInfo;
		
	}

	@Override
	public BiddeeLegalPerson getLegalPersonInfo_apply(Token token) throws BusinessException {
		
		BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(token.getUserId());
		BiddeeLegalPerson legalPerson = new BiddeeLegalPerson();
//		"legalPerson":{
//	        "name":"张三",
//	        "idCard":"420923199205049230121",
//	        "idCardfrontUrl":"法人身份证正面地址",
//	        "idCardBackUrl":"法人身份证反面地址",
//	        "authorityBookUrl":""
//	    }
		StringUtil util = new StringUtil();
		if(aa!=null){
			String lpname = aa.getLegalPerson()!=null?aa.getLegalPerson():"";
			String IdCard = aa.getLegalPersonIdcard()!=null?aa.getLegalPersonIdcard():"";
			
			legalPerson.setName(aa.getLegalPerson());
			legalPerson.setIdCard(aa.getLegalPersonIdcard());
			legalPerson.setIdCardfrontUrl(aa.getLegalPersonIdcardFrontUrl());
			legalPerson.setIdCardBackUrl(aa.getLegalPersonIdcardBackUrl());
			legalPerson.setAuthorityBookUrl(aa.getLegalPersonAuthorityBook());
			
		}
		
		
		return legalPerson;
	}

	@Override
	public BiddeeRegisteredInfo getRegisteredInfo_apply(Token token) throws BusinessException {
		
		BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(token.getUserId());
		BiddeeRegisteredInfo registeredInfo = new BiddeeRegisteredInfo();

		if(aa != null){
			
			registeredInfo.setBusinessLicenseNum(aa.getBusinessLicense());
			registeredInfo.setBusinessLicenseUrl(aa.getBusinessLicenseUrl());
			registeredInfo.setTaxRegistrationNum(aa.getTaxRegistrationCertificate());
			registeredInfo.setTaxRegistrationUrl(aa.getTaxRegistrationCertificateUrl());
			registeredInfo.setOrganizationCodeNum(aa.getOrgCodeCertificate());
			registeredInfo.setOrganizationCodeUrl(aa.getOrgCodeCertificateUrl());
			registeredInfo.setBusinessScope(aa.getBusinessScope());
			registeredInfo.setRegTime(aa.getRegTime());
			registeredInfo.setBusinessLicenseExpireTime(aa.getBusinessLicenseExpireTime());
			registeredInfo.setAddress(aa.getAddress());
			registeredInfo.setBusinessLicenseType(aa.getBusinessLicenseType());
			registeredInfo.setNewBusinessLicenseNum(aa.getNewBusinessLicense());
			registeredInfo.setNewBusinessLicenseUrl(aa.getUnifiedSocialCreditCodeUrl());
		}
		
		
		return registeredInfo;
	}

	@Override
	public BiddeeRegisteredInfo getRegisteredInfo(Token token) throws BusinessException {
		
		BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(token.getUserId());
		BiddeeRegisteredInfo registeredInfo = new BiddeeRegisteredInfo();

		if(aa != null){
			
			registeredInfo.setBusinessLicenseNum(aa.getBusinessLicense());
			registeredInfo.setBusinessLicenseUrl(aa.getBusinessLicenseUrl());
			registeredInfo.setTaxRegistrationNum(aa.getTaxRegistrationCertificate());
			registeredInfo.setTaxRegistrationUrl(aa.getTaxRegistrationCertificateUrl());
			registeredInfo.setOrganizationCodeNum(aa.getOrgCodeCertificate());
			registeredInfo.setOrganizationCodeUrl(aa.getOrgCodeCertificateUrl());
			registeredInfo.setBusinessScope(aa.getBusinessScope());
			registeredInfo.setRegTime(aa.getRegTime());
			if("0".equals(aa.getBusinessLicenseExpireTime())){
				registeredInfo.setBusinessLicenseExpireTime("长期");
			}else{
				registeredInfo.setBusinessLicenseExpireTime(aa.getBusinessLicenseExpireTime());
				
			}
			
			registeredInfo.setAddress(aa.getAddress());
			registeredInfo.setBusinessLicenseType(aa.getBusinessLicenseType());
			registeredInfo.setNewBusinessLicenseNum(aa.getNewBusinessLicense());
			registeredInfo.setNewBusinessLicenseUrl(aa.getUnifiedSocialCreditCodeUrl());
		}
		
		
		return registeredInfo;
	}
	@Override
	public BiddeeBankInfo getBankInfo_apply(Token token) throws BusinessException {
		

		List<BiddeeBankCardCerticate> aa = bbccDao.selectBiddeeBankInfoByToken(token.getToken());
//		Map bankInfo= new HashMap();
//		"bankInfo":{ 
//	        "bank":"招商银行深圳支行",
//	        "accountId":"1234567812345678",
//	        "accountName":"深圳麦圈互动技术有限公司"
//	    }
//		if(aa!=null&&aa.size()>0){
//			bankInfo.put("bank", aa.get(0).getBankName());
//			bankInfo.put("accountId", aa.get(0).getAccountNo());
//			bankInfo.put("accountName", aa.get(0).getAccountName());
//		}
		BiddeeBankInfo bankInfo = new BiddeeBankInfo();
		if(aa!=null&&aa.size()>0){
			bankInfo.setBank(aa.get(0).getBankName());
			bankInfo.setAccountId(aa.get(0).getAccountNo());
			bankInfo.setAccountName(aa.get(0).getAccountName());
			bankInfo.setTaxNo(aa.get(0).getTaxNo());
			bankInfo.setTelephone(aa.get(0).getTelephone());
			bankInfo.setAddress(aa.get(0).getAddress());
		}
		return bankInfo;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveBaseInfo_apply(String appId, BiddeeBaseInfo baseInfo, Token token) throws BusinessException {
		
		
		int i= 0;
		if(token.getUserId() != null){
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token.getUserId());
//			ValidateUtil.assertNull(biddee, "未找到招标人数据！请先填写完信息再提交!");
			if(biddee==null){
				biddee=new BiddeeCerticate();
				if(baseInfo!= null){
					String company_name = baseInfo.getCompanyName();
					String short_name = baseInfo.getShortName();
					String description = baseInfo.getDescription();
					String registered_capital = baseInfo.getRegisteredCapital();
					String telephone = baseInfo.getTelephone();
					String email = baseInfo.getEmail();
					String logo  = baseInfo.getLogoUrl();
					biddee.setUserId(token.getUserId());
					biddee.setCompanyName(company_name);
					biddee.setShortName(short_name);
					biddee.setDescription(description);
					biddee.setRegisteredCapital(registered_capital);
					biddee.setContactMobileNum(telephone);
					biddee.setEmail(email);
					biddee.setLogo(logo);
					biddee.setApplyTime(new Date());
					biddee.setStatus("CRT");
					
				}
			
				
				i = biddeeCerticateDao.insertSelective(biddee);
			}else{
				if(baseInfo!= null){
					String company_name = baseInfo.getCompanyName();
					String short_name = baseInfo.getShortName();
					String description = baseInfo.getDescription();
					String registered_capital = baseInfo.getRegisteredCapital();
					String telephone = baseInfo.getTelephone();
					String email = baseInfo.getEmail();
					String logo  = baseInfo.getLogoUrl();
					biddee.setCompanyName(company_name);
					biddee.setShortName(short_name);
					biddee.setDescription(description);
					biddee.setRegisteredCapital(registered_capital);
					biddee.setContactMobileNum(telephone);
					biddee.setEmail(email);
					biddee.setLogo(logo);
					biddee.setStatus("CRT");
					
				}
				i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
			}
			
		}
		
		return i;
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveLegalPersonInfo_apply(String appId, BiddeeLegalPerson legalPerson, Token token) throws BusinessException {
		
        int i = 0;
		if(token.getUserId()!=null){
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token.getUserId());
//			ValidateUtil.assertNull(biddee, "未找到招标人数据！请先填写完信息再提交!");
			if(biddee==null){
				biddee=new BiddeeCerticate();
				if(legalPerson!= null){
					String name = legalPerson.getName();
					String idCard = legalPerson.getIdCard();
					String idCardfrontUrl = legalPerson.getIdCardfrontUrl();
					
					String idCardBackUrl = legalPerson.getIdCardBackUrl();
					String authorityBookUrl = legalPerson.getAuthorityBookUrl();
					
					biddee.setUserId(token.getUserId());
					biddee.setLegalPerson(name);
					biddee.setLegalPersonIdcard(idCard);
					biddee.setLegalPersonIdcardFrontUrl(idCardfrontUrl);
					biddee.setLegalPersonIdcardBackUrl(idCardBackUrl);
					
					biddee.setLegalPersonAuthorityBook(authorityBookUrl);
				}
			
				
				i = biddeeCerticateDao.insertSelective(biddee);
			}else{
				if(legalPerson!= null){
					String name = legalPerson.getName();
					String idCard =legalPerson.getIdCard();
					String idCardfrontUrl = legalPerson.getIdCardfrontUrl();
					
					String idCardBackUrl = legalPerson.getIdCardBackUrl();
					String authorityBookUrl = legalPerson.getAuthorityBookUrl();
					
					
					biddee.setLegalPerson(name);
					biddee.setLegalPersonIdcard(idCard);
					biddee.setLegalPersonIdcardFrontUrl(idCardfrontUrl);
					biddee.setLegalPersonIdcardBackUrl(idCardBackUrl);
					
					biddee.setLegalPersonAuthorityBook(authorityBookUrl);
				}
			
				i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
			}
			
		}
		
		return i;
		
		
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveRegisteredInfo(String appId, BiddeeRegisteredInfo registeredInfo, Token token) throws BusinessException {
		int i= 0;
		if(token.getUserId() != null){
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token.getUserId());
//			ValidateUtil.assertNull(biddee, "未找到招标人数据！请先填写完信息再提交!");
			if(biddee == null){
				biddee = new BiddeeCerticate();
				biddee.setUserId(token.getUserId());
			}
			if(registeredInfo!= null){
				
				String businessLicenseNum = registeredInfo.getBusinessLicenseNum();
				String businessLicenseUrl = registeredInfo.getBusinessLicenseUrl();
				String businessLicenseType = registeredInfo.getBusinessLicenseType();
				String taxRegistrationNum = registeredInfo.getTaxRegistrationNum();
				String taxRegistrationUrl = registeredInfo.getTaxRegistrationUrl();
				String organizationCodeNum = registeredInfo.getOrganizationCodeNum();
				String organizationCodeUrl = registeredInfo.getOrganizationCodeUrl();
				
				
				String newBusinessLicenseNum = registeredInfo.getNewBusinessLicenseNum();
				String newBusinessLicenseUrl = registeredInfo.getNewBusinessLicenseUrl();
				String businessScope = registeredInfo.getBusinessScope();
				String address = registeredInfo.getAddress();
				Date regTime = registeredInfo.getRegTime();
				
				biddee.setBusinessLicenseType(businessLicenseType);
				if("NEW".equalsIgnoreCase(businessLicenseType)){
					
					biddee.setUnifiedSocialCreditCode(newBusinessLicenseNum);
					biddee.setUnifiedSocialCreditCodeUrl(newBusinessLicenseUrl);
					biddee.setNewBusinessLicense(newBusinessLicenseNum);
					ValidateUtil.assertEmpty(newBusinessLicenseNum, "社会统一信用代码");
					ValidateUtil.assertEmpty(newBusinessLicenseUrl, "三合一执照url");
					/*biddee.setBusinessLicense(newBusinessLicenseNum);
					biddee.setBusinessLicenseUrl(newBusinessLicenseUrl);*/
				}else if("OLD".equalsIgnoreCase(businessLicenseType)){
					biddee.setBusinessLicense(businessLicenseNum);
					biddee.setBusinessLicenseUrl(businessLicenseUrl);
					biddee.setTaxRegistrationCertificate(taxRegistrationNum);
					biddee.setTaxRegistrationCertificateUrl(taxRegistrationUrl);
					biddee.setOrgCodeCertificate(organizationCodeNum);
					biddee.setOrgCodeCertificateUrl(organizationCodeUrl);
					ValidateUtil.assertEmpty(businessLicenseNum, "营业执照");
					ValidateUtil.assertEmpty(businessLicenseUrl, "营业执照url");
					ValidateUtil.assertEmpty(taxRegistrationNum, "税务证书编号");
					ValidateUtil.assertEmpty(taxRegistrationUrl, "税务证书url");
					ValidateUtil.assertEmpty(organizationCodeNum, "组织机构代码");
					ValidateUtil.assertEmpty(organizationCodeUrl, "组织机构url");
				}else{
						throw new BusinessException("营业执照类型不对");
					
				}
	
				biddee.setBusinessScope(businessScope);
				biddee.setAddress(address);
				
				biddee.setRegTime(regTime);
				biddee.setBusinessLicenseExpireTime(registeredInfo.getBusinessLicenseExpireTime());
			}	
			if(biddee.getId()==null){
				//biddee=new BiddeeCerticate();
				i = biddeeCerticateDao.insertSelective(biddee);
			}else{
			
				i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
			}
			
		}
		return i;
		
		}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveBankInfo(String appId, BiddeeBankInfo bankInfo, Token token) throws BusinessException {
		
		
		int i= 0;
		if(token.getUserId() != null){
			List<BiddeeBankCardCerticate> banks = bbccDao.selectBiddeeBankInfoByToken(token.getToken());
			BiddeeBankCardCerticate b =new BiddeeBankCardCerticate();
			
			if(banks!= null && banks.size()>0){
				 b = banks.get(0);
				 if(bankInfo !=null){
					
					 b.setBankName(bankInfo.getBank());
					 b.setAccountNo(bankInfo.getAccountId());
					 b.setAccountName(bankInfo.getAccountName());
					 b.setTaxNo(bankInfo.getTaxNo());
					 b.setTelephone(bankInfo.getTelephone());
					 b.setAddress(bankInfo.getAddress());
					 
				 }
				
				i = bbccDao.updateByPrimaryKeySelective(b);

			}else{
				 if(bankInfo !=null){
					 b.setUserId(token.getUserId());
					 b.setBankName(bankInfo.getBank());
					 b.setAccountNo(bankInfo.getAccountId());
					 b.setAccountName(bankInfo.getAccountName());
					 b.setTaxNo(bankInfo.getTaxNo());
					 b.setTelephone(bankInfo.getTelephone());
					 b.setAddress(bankInfo.getAddress());
				 }
				i = bbccDao.insertSelective(b);
			}
		}
		return i;
		
		}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int applay(String appId, Token token) throws BusinessException {
		
		
		int i= 0;
		if(token.getUserId() != null){
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token.getUserId());
			ValidateUtil.assertNull(biddee, "未找到招标人数据！请先填写完信息再提交!");
	
			biddee.setStatus("APY");//修改状态为已申请中   
			i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
		
			}
			return i;
	
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public  String checkApplication(String appId, BiddeeAuditBodyInfo body, Integer biddeeId) throws BusinessException {
		boolean flag = true;
		String mscode = "4210";//审核完成 且通过审核
		try{
			BiddeeCerticate bc = biddeeCerticateDao.selectByPrimaryKey(biddeeId);
			BiddeeCertificateAduit  bca = biddeeCertificateAduitDao.selectByBcid(biddeeId);
			ValidateUtil.assertNull(bc, "未找到招标人资质申请数据！");
			
			BiddeeBaseInfoCheck baseInfoCheck = body.getBaseInfoCheck();
			BiddeeLegalPersonCheck legalPersonCheck = body.getLegalPersonCheck();
			BiddeeRegisteredInfoCheck registeredInfoCheck = body.getRegisteredInfoCheck();
			BiddeeBankInfoCheck bankInfoCheck  = body.getBankInfoCheck();
			List<CertificationCheck> certificationsCheck = body.getCertificationsCheck();
			
			boolean baseInfoCheckflag = checkIsOk(baseInfoCheck,null);
			boolean legalPersonCheckfalg = checkIsOk(legalPersonCheck,null);
			boolean registeredInfoCheckflag = checkIsOk(registeredInfoCheck,bc.getBusinessLicenseType());
			boolean bankInfoCheckfalg = checkIsOk(bankInfoCheck,null);
//			所有信息都OK#的表示认证审核通过，只要有一项FLS的表示认证审核不通过，需要申请人修订后重新提交。
			if(baseInfoCheckflag == false || legalPersonCheckfalg == false || registeredInfoCheckflag == false || bankInfoCheckfalg == false){
				flag = false;
				mscode = "4211";   //审核完成 且 审核不通过
			}
//			baseInfoCheck.getCompany_name().getResult()
			
			

			if(bca == null){
				bca = new BiddeeCertificateAduit();
			}
				//审核通过 
				if(flag){
//					1.插入招标人正式表
					Biddee biddee = biddeeDao.selectByUserId(bc.getUserId());
					if(biddee==null){
						biddeeDao.insertSelectByBiddeeIdSuccess(biddeeId);
					}else{
						biddeeDao.updateByBiddeeIdSuccess(biddeeId);
					}
					
//					2.插入资质证书正式表
//					List<BiddeeCertification> bcfs  = bcDao.selectByBiddeeId(biddeeId);
//					if(bcfs == null || bcfs.size()==0){
//						bcDao.insertSelectiveByCertificationIdSuccess(biddeeId);
//					}else{
//						bcDao.updateByCertificationIdSuccess(biddeeId);
//					}
					
//					3.插入开户行正式表 信息
					List<UserBankcard> ubcs = userBankcardDao.selectBiddeeBankInfoByUserId(bc.getUserId());
					if(ubcs == null || ubcs.size()==0){
						userBankcardDao.insertBiddeeBankInfo(bc.getUserId());
					}else{
						userBankcardDao.updateBiddeeBankInfo(bc.getUserId());
					}
					bca.setAuditStatus("OK#");
					bc.setStatus("OK#");
					
					//添加 证书资质信息,只有通过的资质证书放过去
					//删除所有证书
					//招标人无资质证书
//					bcDao.removeAllByBiddeeId(biddeeId);
//					if(CollectionUtils.isNotEmpty(certificationsCheck)){
//						for (Iterator iterator = certificationsCheck.iterator(); iterator.hasNext();) {
//							CertificationCheck certificationCheck = (CertificationCheck) iterator.next();
//							Integer certificationApplyId = certificationCheck.getCertificationApplyId();
//							if(StringUtils.equals(CommonStatusConst.STATUS_OK,certificationCheck.getCertificationApply().getResult())){
//								bcDao.insertByApplyId(certificationApplyId);
//							}
//							BiddeeCertificationAudit ca = new BiddeeCertificationAudit();
//							ca.setAuditor(bc.getUserId());
//							ca.setAuditStatus(certificationCheck.getCertificationApply().getResult());
//							ca.setAuditTime(new Date());
//							
//							ca.setCertificationCerticateId(certificationApplyId);
//							bcaDao.insert(ca);
//						}
//					}
					
//					5.插入积分信息
					BiddeeCredit bcr  = biddeeCreditDao.selectByPrimaryKey(biddeeId);
					ScoreDefine sd = sdDao.selectByPrimaryKey(1);//信用积分配置表信息
					if(bcr == null){
						bcr = new BiddeeCredit();
					}
					ValidateUtil.assertNull(sd, "积分配置信息");
					IntegerUtil iu = new IntegerUtil();
//					这里积分规则未定出     暂时全部存入 0 
					bcr.setBankInfo(iu.getRegulaInt(sd.getBankInfo()));
					bcr.setBaseinfoCreditScore(iu.getRegulaInt(sd.getBaseinfoCreditScore()));
					bcr.setCompanyRegisteredInfo(iu.getRegulaInt(sd.getCompanyRegisteredInfo()));
					bcr.setCreditScore(iu.getSum(sd.getBankInfo(),sd.getBaseinfoCreditScore(),sd.getCompanyRegisteredInfo(),sd.getLegalPersonInfo()));
					bcr.setLegalPersonInfo(iu.getRegulaInt(sd.getLegalPersonInfo()));
					
					if(bcr.getTendererId() != null){
						biddeeCreditDao.updateByPrimaryKeySelective(bcr);
					}else{
						bcr.setTendererId(biddeeId);
						biddeeCreditDao.insert(bcr);
					}
					
				}else{//审核不通过
					bca.setAuditStatus("FLS");
					bc.setStatus("FLS");
					
				}
//				4.插入审核信息
				
				bca = this.getBiddeeCertificateAduitInfo(body.getBaseInfoCheck(), bca);
				bca = getBiddeeCertificateAduitInfo(body.getLegalPersonCheck(), bca);
				bca = getBiddeeCertificateAduitInfo(body.getRegisteredInfoCheck(), bca);
				bca.setBiddeeCerticateId(biddeeId);
				bca.setAuditor(bc.getUserId());
				bca.setAuditTime(new Date());
		
				if(bca.getId()==null){
					bca.setInsertTime(new Date());//首次插入时间
					biddeeCertificateAduitDao.insert(bca);
				}else{
					biddeeCertificateAduitDao.updateByPrimaryKey(bca);
				}

				//插入银行审核信息
				BiddeeBankAduit bba = new BiddeeBankAduit();
				bba.setAuditTime(new Date());
				bba.setBiddeeCerticateId(biddeeId);
				bba.setBankcardCertificateResult(bankInfoCheck.getAccount_no   ().getResult());
				bba.setBankCertificateResult(bankInfoCheck.getBank_name()        .getResult());
				bba.setAcccountNameCertificateResult(bankInfoCheck.getAccount_name().getResult());
				bba.setTaxNoCertificateResult(bankInfoCheck.getTax_no       ().getResult());
				bba.setAddressCertificateResult(bankInfoCheck.getAddress     ().getResult());
				bba.setTelephoneCertificateResult(bankInfoCheck.getTelephone   ().getResult());
				bba.setBankcardCertificateMsg(bankInfoCheck.getAccount_no   ().getMsg());
				bba.setBankCertificateMsg(bankInfoCheck.getBank_name()        .getMsg());
				bba.setAcccountNameCertificateMsg(bankInfoCheck.getAccount_name().getMsg());
				bba.setTaxNoCertificateMsg(bankInfoCheck.getTax_no       ().getMsg());
				bba.setAddressCertificateMsg(bankInfoCheck.getAddress     ().getMsg());
				bba.setTelephoneCertificateMsg(bankInfoCheck.getTelephone   ().getMsg());
				biddeeBankAduitDao.removeAduitRecord(biddeeId);
				biddeeBankAduitDao.insert(bba);

				
				
//				6.修改临时表数据状态
				biddeeCerticateDao.updateByPrimaryKeySelective(bc);
		}catch(ValidateException ve){
				int errcode=ValidateException.ERRCODE_NULLVALUE;
				
				//throw new DataInvalidException(errcode, msg );
				throw new DataInvalidException(10103, ve.getMessage());
			
		}catch(Exception e){
				throw new MaAccountException(MaAccountException.ERR_ORDER_EXCEPTION,
						String.format("招标人【%s】审核失败", biddeeId));
			
		}
		

			
		
		
//		bc = getBiddeeCertificateAduitInfo(obj, bc)
//		BiddeeCertificateAduit bc = this.getBiddeeCertificateAduitInfo(obj, bc);
		
		return mscode;
	}
	
	/**
	 *	采用反射  循环遍历所有传过来的字段    插入表
	 * @author YJY
	 * @since  2015年11月18日15:18:55
	 * @param T
	 *           
	 * @return flag
	 * @throws BusinessException
	 */
	public  <T> BiddeeCertificateAduit getBiddeeCertificateAduitInfo(T obj,BiddeeCertificateAduit bc) throws BusinessException {
		
		
		Class clazz = obj.getClass();
	    Field[] fields = obj.getClass().getDeclaredFields();//获得属性
	    for (Field field : fields) {
	    PropertyDescriptor pd;
	    PropertyDescriptor rpd;
	    PropertyDescriptor mpd;
	    CamelUtil cu = new CamelUtil();
		   try {
	            	pd = new PropertyDescriptor(field.getName(),
	          			  clazz);
	            	Method getMethod = pd.getReadMethod();//获得get方法
					Object o = getMethod.invoke(obj);  //执行get方法返回一个Object
					if(o!= null && o.getClass()!=null){
						if("AuditInfo".equals(o.getClass().getSimpleName())){
							AuditInfo mm =(AuditInfo)o;
							//动态set方法  result 
							String name = cu.underlineToCamel2(field.getName());
							System.out.println("转换后的字段名"+name);
							rpd = new PropertyDescriptor(name,
									bc.getClass());
				            	Method setresultMethod = rpd.getWriteMethod();//获得set方法
								Object rm =  setresultMethod.invoke(bc,mm.getResult());  //执行set 
								
							//动态set方法  msg 
							mpd = new PropertyDescriptor(name+"Msg",
									bc.getClass());
				            Method setMsgMethod = mpd.getWriteMethod();//获得set方法
							Object om =  setMsgMethod.invoke(bc,mm.getMsg());  //执行set 
//							System.out.println(om.toString());
						}
						System.out.println(o.getClass().getName());
					}
					
					
				} catch (IntrospectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
	    return bc;
	}
	
	/**
	 *	采用反射  循环遍历所有字段  查询状态
	 * @author YJY
	 * @since  2015年11月18日15:18:55
	 * @param T
	 *           
	 * @return flag
	 * @throws BusinessException
	 */
	public  <T> Boolean checkIsOk(T obj,String type) throws BusinessException {
		
		boolean flag = true;
//		BiddeeBaseInfoCheck baseInfoCheck = body.getBaseInfoCheck();
		Class clazz = obj.getClass();
	    Field[] fields = obj.getClass().getDeclaredFields();//获得属性
	    List<String> strs = new ArrayList<String>();
	    if(type != null){
	    	if("OLD".equalsIgnoreCase(type)){
				String[] str = {"unified_social_credit_code_url","unified_social_credit_code"};
			    strs = Arrays.asList(str);
				
			}else if("NEW".equalsIgnoreCase(type)){
				String[] str = {"business_license","business_license_url","tax_registration_certificate","tax_registration_certificate_url","org_code_certificate","org_code_certificate_url"};
				strs = Arrays.asList(str);
//				str.toString().contains("1212");
			}else{
				ValidateUtil.assertNull(null, "没有该类型的营业执照请核对后在审核！");
			}
	    }
	    
	    for (Field field : fields) {
	    PropertyDescriptor pd;
		   try {
	            	pd = new PropertyDescriptor(field.getName(),
	          			  clazz);
	            	Method getMethod = pd.getReadMethod();//获得get方法
					Object o = getMethod.invoke(obj);  //执行get方法返回一个Object
					if(o!= null && o.getClass()!=null){
						if("AuditInfo".equals(o.getClass().getSimpleName())){
							AuditInfo mm =(AuditInfo)o;
							if(type ==null){//非公司注册的校验
								if(!"OK#".equalsIgnoreCase(mm.getResult())){
									return false;
								}
							}else{//公司注册的校验 
//								List<String> strs = new ArrayList<String>(); 
								
									if(strs.contains(field.getName())){
										continue;
									}
									if(!"OK#".equalsIgnoreCase(mm.getResult())){
										return false;
									}
								
							}
							
							System.out.println(o.getClass().getName());
						}
//						System.out.println(o.getClass().getName());
					}
					
					
				} catch (IntrospectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
//		baseInfoCheck.getCompany_name().getResult()
		return flag;
	}
	
}
