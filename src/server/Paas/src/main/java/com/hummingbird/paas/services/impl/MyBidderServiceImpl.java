package com.hummingbird.paas.services.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.paas.entity.BiddeeCerticate;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.BidderBankCardCerticate;
import com.hummingbird.paas.entity.BidderCerticate;
import com.hummingbird.paas.entity.BidderCertificateAduit;
import com.hummingbird.paas.entity.BidderCertification;
import com.hummingbird.paas.entity.BidderCerticate;
import com.hummingbird.paas.entity.BidderCertificationCertification;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidderBankAduitMapper;
import com.hummingbird.paas.mapper.BidderBankCardCerticateMapper;
import com.hummingbird.paas.mapper.BidderBidCreditScoreMapper;
import com.hummingbird.paas.mapper.BidderCerticateMapper;
import com.hummingbird.paas.mapper.BidderCertificateAduitMapper;
import com.hummingbird.paas.mapper.BidderCertificationCertificationMapper;
import com.hummingbird.paas.mapper.BidderCertificationMapper;
import com.hummingbird.paas.mapper.BidderCreditMapper;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.BidderCerticateMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.services.MyBidderService;
import com.hummingbird.paas.util.CamelUtil;
import com.hummingbird.paas.util.StringUtil;
import com.hummingbird.paas.vo.AuditInfo;
import com.hummingbird.paas.vo.BiddeeAuditBodyInfo;
import com.hummingbird.paas.vo.BidderAuditBodyInfo;
import com.hummingbird.paas.vo.BidderBankInfoCheck;
import com.hummingbird.paas.vo.BidderBaseInfoCheck;
import com.hummingbird.paas.vo.BidderLegalPersonCheck;
import com.hummingbird.paas.vo.BidderRegisteredInfoCheck;
import com.hummingbird.paas.vo.BidderBankInfo;
import com.hummingbird.paas.vo.BidderBaseInfo;
import com.hummingbird.paas.vo.BidderEqInfo;
import com.hummingbird.paas.vo.BidderLegalPerson;
import com.hummingbird.paas.vo.BidderRegisteredInfo;
@Service
public class MyBidderServiceImpl implements MyBidderService {
	

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	protected BidderCerticateMapper bidderCerticateDao;
	@Autowired
	protected BidderCertificateAduitMapper bidderCertificateAduitDao;
	@Autowired
	protected BidderBankCardCerticateMapper bbccDao;
	@Autowired
	protected UserBankcardMapper userBankcardDao;
	@Autowired
	protected BidderCreditMapper bidderCreditDao;
	@Autowired
	protected BidderBidCreditScoreMapper bidderBidCreditScoreDao;
	@Autowired
	protected BidderBankAduitMapper bidderBankAduitDao;
	@Autowired
	protected BidderCertificationCertificationMapper bidderCertificationCertificationDao;
	@Autowired
	protected BidObjectMapper bidObjectDao;
	@Autowired
	protected ScoreLevelMapper scoreLevelDao;
	@Autowired
	protected BidderMapper bidderDao;
	@Autowired
	protected BidderCertificationMapper bcDao;

	@Override
	public Boolean getAuthInfo(Token token) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BidderBaseInfo getBaseInfo_apply(Token token) throws BusinessException {
		// TODO Auto-generated method stub
		BidderCerticate aa = bidderCerticateDao.selectByUserId(token.getUserId());
		BidderBaseInfo baseInfo = new BidderBaseInfo();
		
		if(aa !=null){
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
	public BidderLegalPerson getLegalPersonInfo_apply(Token token) throws BusinessException {
		// TODO Auto-generated method stub
		BidderCerticate aa = bidderCerticateDao.selectByUserId(token.getUserId());
		
//		"legalPerson":{
//	        "name":"张三",
//	        "idCard":"420923199205049230121",
//	        "idCardfrontUrl":"法人身份证正面地址",
//	        "idCardBackUrl":"法人身份证反面地址",
//	        "authorityBookUrl":""
//	    }
		BidderLegalPerson legalPerson = new BidderLegalPerson();
		StringUtil util = new StringUtil();
		if(aa !=null){
			
			legalPerson.setName(util.getShowString(aa.getLegalPerson()));
			legalPerson.setIdCard(util.getShowString(aa.getLegalPersonIdcard()));
			legalPerson.setIdCardfrontUrl(aa.getLegalPersonIdcardFrontUrl());
			legalPerson.setIdCardBackUrl(aa.getLegalPersonIdcardBackUrl());
			legalPerson.setAuthorityBookUrl(aa.getLegalPersonAuthorityBook());
		}
		
		
		return legalPerson;
	}

	@Override
	public BidderRegisteredInfo getRegisteredInfo_apply(Token token) throws BusinessException {
		// TODO Auto-generated method stub
		BidderCerticate aa = bidderCerticateDao.selectByUserId(token.getUserId());
		
//		 "registeredInfo":{
//	         "businessLicenseNum":"BUSINESS_LICENSE_NUM",
//	         "":"BUSINESS_LICENSE_URL",
//	         "taxRegistrationNum":"TAX_REGISTRATION_NUM",
//	         "taxRegistrationUrl":"TAX_REGISTRATION_URL",
//	         "organizationCodeNum":"ORGANIZATION_CODE_NUM",
//	         "organizationCodeUrl":"ORGANIZATION_CODE_URL"
//	         "businessScope":"经营范围",
//	         "regTime":"2014-04-05",
//	         "businessLicenseExpireTime":"10年",
//	         "address":"",
//	         "businessLicenseType":"OLD",
//	         "newBusinessLicenseNum":"",
//	         "newBusinessLicenseUrl":"",
//	    }registeredInfo
		
//		Map registeredInfo= new HashMap();
//		registeredInfo.put("businessLicenseNum", aa.getBusinessLicense());
//		registeredInfo.put("businessLicenseUrl", aa.getBusinessLicenseUrl());
//		registeredInfo.put("taxRegistrationNum", aa.getTaxRegistrationCertificate());
//		registeredInfo.put("taxRegistrationUrl", aa.getTaxRegistrationCertificateUrl());
//		registeredInfo.put("organizationCodeNum", aa.getOrgCodeCertificate());
//		registeredInfo.put("organizationCodeUrl", aa.getOrgCodeCertificateUrl());
//		registeredInfo.put("businessScope", aa.getBusinessScope());
//		registeredInfo.put("regTime", aa.getRegTime());
//		registeredInfo.put("businessLicenseExpireTime", aa.getBusinessLicenseExpireTime());
//		
//		registeredInfo.put("address", aa.getAddress());
//		registeredInfo.put("businessLicenseType", aa.getBusinessLicenseType());
//		registeredInfo.put("newBusinessLicenseNum", aa.getNewBusinessLicense());
//		registeredInfo.put("newBusinessLicenseUrl", aa.getUnifiedSocialCreditCodeUrl());
		BidderRegisteredInfo registeredInfo = new BidderRegisteredInfo();
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
	public BidderBankInfo getBankInfo_apply(Token token) throws BusinessException {
		// TODO Auto-generated method stub

		List<BidderBankCardCerticate> aa = bbccDao.selectBidderBankInfoByToken(token.getToken());
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
		BidderBankInfo bankInfo = new BidderBankInfo();
		if(aa!=null&&aa.size()>0){
			bankInfo.setBank(aa.get(0).getBankName());
			bankInfo.setAccountId(aa.get(0).getAccountNo());
			bankInfo.setAccountName(aa.get(0).getAccountName());
		}
		return bankInfo;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveBaseInfo_apply(String appId, BidderBaseInfo baseInfo, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		if(token.getUserId() != null){
			BidderCerticate bidder=bidderCerticateDao.selectByUserId(token.getUserId());
//			ValidateUtil.assertNull(bidder, "未找到投标人数据！请先填写完信息再提交!");
			if(bidder==null){
				bidder=new BidderCerticate();
				if(baseInfo!= null){
					String company_name = baseInfo.getCompanyName();
					String short_name = baseInfo.getShortName();
					String description = baseInfo.getDescription();
					String registered_capital = baseInfo.getRegisteredCapital();
					String telephone = baseInfo.getTelephone();
					String email = baseInfo.getEmail();
					String logo = baseInfo.getLogoUrl();
					bidder.setUserId(token.getUserId());
					bidder.setCompanyName(company_name);
					bidder.setShortName(short_name);
					bidder.setDescription(description);
					bidder.setRegisteredCapital(registered_capital);
					bidder.setContactMobileNum(telephone);
					bidder.setEmail(email);
					bidder.setLogo(logo);
					bidder.setStatus("CRT");
				}
			
				
				i = bidderCerticateDao.insertSelective(bidder);
			}else{
				if(baseInfo!= null){
					String company_name = baseInfo.getCompanyName();
					String short_name = baseInfo.getShortName();
					String description = baseInfo.getDescription();
					String registered_capital = baseInfo.getRegisteredCapital();
					String telephone = baseInfo.getTelephone();
					String email = baseInfo.getEmail();
					String logo = baseInfo.getLogoUrl();
					bidder.setCompanyName(company_name);
					bidder.setShortName(short_name);
					bidder.setDescription(description);
					bidder.setRegisteredCapital(registered_capital);
					bidder.setContactMobileNum(telephone);
					bidder.setEmail(email);
					bidder.setLogo(logo);
					bidder.setStatus("CRT");
					
				}
				i = bidderCerticateDao.updateByPrimaryKeySelective(bidder);
			}
			
		}
		
		return i;
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveLegalPersonInfo_apply(String appId, BidderLegalPerson legalPerson, Token token) throws BusinessException {
		// TODO Auto-generated method stub
        int i = 0;
		if(token.getUserId()!=null){
			BidderCerticate bidder=bidderCerticateDao.selectByUserId(token.getUserId());
//			ValidateUtil.assertNull(bidder, "未找到投标人数据！请先填写完信息再提交!");
			if(bidder==null){
				bidder=new BidderCerticate();
				if(legalPerson!= null){
					String name = legalPerson.getName();
					String idCard = legalPerson.getIdCard();
					String idCardfrontUrl = legalPerson.getIdCardfrontUrl();
					
					String idCardBackUrl = legalPerson.getIdCardBackUrl();
					String authorityBookUrl = legalPerson.getAuthorityBookUrl();
					
					
					bidder.setLegalPerson(name);
					bidder.setLegalPersonIdcard(idCard);
					bidder.setLegalPersonIdcardFrontUrl(idCardfrontUrl);
					bidder.setLegalPersonIdcardBackUrl(idCardBackUrl);
					
					bidder.setLegalPersonAuthorityBook(authorityBookUrl);
				}
			
				
				i = bidderCerticateDao.insertSelective(bidder);
			}else{
				if(legalPerson!= null){
					String name = legalPerson.getName();
					String idCard =legalPerson.getIdCard();
					String idCardfrontUrl = legalPerson.getIdCardfrontUrl();
					
					String idCardBackUrl = legalPerson.getIdCardBackUrl();
					String authorityBookUrl = legalPerson.getAuthorityBookUrl();
					
					
					bidder.setLegalPerson(name);
					bidder.setLegalPersonIdcard(idCard);
					bidder.setLegalPersonIdcardFrontUrl(idCardfrontUrl);
					bidder.setLegalPersonIdcardBackUrl(idCardBackUrl);
					
					bidder.setLegalPersonAuthorityBook(authorityBookUrl);
				}
			
				i = bidderCerticateDao.updateByPrimaryKeySelective(bidder);
			}
			
		}
		
		return i;
		
		
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveRegisteredInfo(String appId, BidderRegisteredInfo registeredInfo, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		if(token.getUserId() != null){
			BidderCerticate bidder=bidderCerticateDao.selectByUserId(token.getUserId());
//			ValidateUtil.assertNull(bidder, "未找到投标人数据！请先填写完信息再提交!");
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
				String businessLicenseExpireTime = registeredInfo.getBusinessLicenseExpireTime();
				bidder.setBusinessLicenseType(businessLicenseType);
				if("NEW".equalsIgnoreCase(businessLicenseType)){
					bidder.setUnifiedSocialCreditCode(newBusinessLicenseNum);
					bidder.setUnifiedSocialCreditCodeUrl(newBusinessLicenseUrl);
					bidder.setNewBusinessLicense(newBusinessLicenseNum);
					ValidateUtil.assertNull(newBusinessLicenseNum, "社会统一信用代码");
					ValidateUtil.assertNull(newBusinessLicenseUrl, "三合一执照url");
					/*bidder.setBusinessLicense(newBusinessLicenseNum);
					bidder.setBusinessLicenseUrl(newBusinessLicenseUrl);*/
				}else if("OLD".equalsIgnoreCase(businessLicenseType)){
					bidder.setBusinessLicense(businessLicenseNum);
					bidder.setBusinessLicenseUrl(businessLicenseUrl);
					bidder.setTaxRegistrationCertificate(taxRegistrationNum);
					bidder.setTaxRegistrationCertificateUrl(taxRegistrationUrl);
					bidder.setOrgCodeCertificate(organizationCodeNum);
					bidder.setOrgCodeCertificateUrl(organizationCodeUrl);
					ValidateUtil.assertNull(businessLicenseNum, "营业执照");
					ValidateUtil.assertNull(businessLicenseUrl, "营业执照url");
					ValidateUtil.assertNull(taxRegistrationNum, "税务证书编号");
					ValidateUtil.assertNull(taxRegistrationUrl, "税务证书url");
					ValidateUtil.assertNull(organizationCodeNum, "组织机构代码");
					ValidateUtil.assertNull(organizationCodeUrl, "组织机构url");
				}else{
						throw new BusinessException("营业执照类型不对");
					
				}
				
				bidder.setBusinessScope(businessScope);
				bidder.setAddress(address);
				
				bidder.setRegTime(regTime);
				bidder.setBusinessLicenseExpireTime(businessLicenseExpireTime);
			}	
			if(bidder==null && bidder.getId()==null){
				//bidder=new BidderCerticate();
				i = bidderCerticateDao.insertSelective(bidder);
			}else{
			
				i = bidderCerticateDao.updateByPrimaryKeySelective(bidder);
			}
			
		}
		return i;
		
		}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveBankInfo(String appId, BidderBankInfo bankInfo, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		if(token.getUserId() != null){
			List<BidderBankCardCerticate> banks = bbccDao.selectBidderBankInfoByToken(token.getToken());
			BidderBankCardCerticate b =new BidderBankCardCerticate();
			
			if(banks!= null && banks.size()>0){
				 b = banks.get(0);
				 if(bankInfo !=null){
						
					 b.setBankName(bankInfo.getBank());
					 b.setAccountNo(bankInfo.getAccountId());
					 b.setAccountName(bankInfo.getAccountName());
				 }
				
				i = bbccDao.updateByPrimaryKeySelective(b);

			}else{
				 if(bankInfo !=null){
					 b.setUserId(token.getUserId());
					 b.setBankName(bankInfo.getBank());
					 b.setAccountNo(bankInfo.getAccountId());
					 b.setAccountName(bankInfo.getAccountName());
				 }
				i = bbccDao.insertSelective(b);
			}
		}
		return i;
		
		}

	@Override
	public int applay(String appId, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		if(token.getUserId() != null){
			BidderCerticate bidder=bidderCerticateDao.selectByUserId(token.getUserId());
			ValidateUtil.assertNull(bidder, "未找到投标人数据！请先填写完信息再提交!");
	
			bidder.setStatus("OK#");//修改状态为已认证
			i = bidderCerticateDao.updateByPrimaryKeySelective(bidder);
		
			}
			return i;
	
	}

	@Override
	public List<BidderEqInfo> getEnterpriseQualification(Token token) throws BusinessException {
		List<BidderEqInfo> aa = bidderCertificationCertificationDao.selectEqInfoByUserId(token.getUserId());

		if(aa==null){
			aa = new ArrayList<BidderEqInfo>();
		}
		
		return aa;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveEnterpriseQualification(String appId, List<BidderEqInfo> eqInfos, Token token)
			throws BusinessException {
			int i =0;
			BidderCerticate bidder = bidderCerticateDao.selectByUserId(token.getUserId());
//			ValidateUtil.assertNull(bidder, "未找到投标人数据！请先填写完信息再提交!");
			if(eqInfos!= null && eqInfos.size()>0){
//				1.筛选出修改的记录
				List<Integer> updIds = new ArrayList<Integer>();
				for(BidderEqInfo be :  eqInfos){
					BidderCertificationCertification bcc=bidderCertificationCertificationDao.selectByPrimaryKey(be.getEqId());
					
					if(bcc!= null){
						updIds.add(be.getEqId());
					}
					
				}
//				2.删除前端未传过来的记录
				int re = bidderCertificationCertificationDao.deleteByBidderId(bidder.getId(), updIds);
//				3.修改或者插入相应记录
				for(BidderEqInfo be :  eqInfos){
					BidderCertificationCertification b =new BidderCertificationCertification();
//					ValidateUtil.assertNull(be.getEqId(), "eqId不能为空！");
					BidderCertificationCertification bcc=bidderCertificationCertificationDao.selectByPrimaryKey(be.getEqId());
					
					if(bcc != null){
						b.setExpireTime(be.getExpiryDate());
//						bcc.setBidderId(be.getEqId());
						b.setBidderApplyId(bidder.getId());
						b.setCertificationContent(be.getCertificationContent());
						b.setCertificationName(be.getEqName());
						b.setIndustryId(be.getProjectType());//工程 类别
						b.setApplicableRegion(be.getApplicableRegion());
						b.setCertificationNo(be.getCertificationNo());
						b.setCertificationId(be.getCertificationId());
						b.setId(be.getEqId());
						bidderCertificationCertificationDao.deleteByPrimaryKey(be.getEqId());
						bidderCertificationCertificationDao.insertSelective(b);
						i++;
//						i = bidderCertificationCertificationDao.updateByPrimaryKeySelective(b);
						
					}else{
						b.setExpireTime(be.getExpiryDate());
						b.setBidderApplyId(bidder.getId());
						b.setApplicableRegion(be.getApplicableRegion());
//						b.setBidderId(bidder.getId());
						b.setCertificationNo(be.getCertificationNo());
						b.setCertificationContent(be.getCertificationContent());
						b.setCertificationName(be.getEqName());
						b.setIndustryId(be.getProjectType());//工程 类别
						b.setCertificationId(be.getCertificationId());
						bidderCertificationCertificationDao.insert(b);
						i++;
						
					}
					
				}
				
			}
			return i;
			
			
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public  Boolean checkApplication(String appId, BidderAuditBodyInfo body, Integer bidderId) throws BusinessException {
		boolean flag = true;
		BidderBaseInfoCheck baseInfoCheck = body.getBaseInfoCheck();
		BidderLegalPersonCheck legalPersonCheck = body.getLegalPersonCheck();
		BidderRegisteredInfoCheck registeredInfoCheck = body.getRegisteredInfoCheck();
		BidderBankInfoCheck bankInfoCheck  = body.getBankInfoCheck();
		
		boolean baseInfoCheckflag = checkIsOk(baseInfoCheck);
		boolean legalPersonCheckfalg = checkIsOk(legalPersonCheck);
		boolean registeredInfoCheckflag = checkIsOk(registeredInfoCheck);
		boolean bankInfoCheckfalg = checkIsOk(bankInfoCheck);
//		所有信息都OK#的表示认证审核通过，只要有一项FLS的表示认证审核不通过，需要申请人修订后重新提交。
		if(baseInfoCheckflag == false || legalPersonCheckfalg == false || registeredInfoCheckflag == false || bankInfoCheckfalg == false){
			flag = false;
		}
//		baseInfoCheck.getCompany_name().getResult()
		BidderCerticate bc = bidderCerticateDao.selectByPrimaryKey(bidderId);
		BidderCertificateAduit  bca = bidderCertificateAduitDao.selectByPrimaryKey(bidderId);

		ValidateUtil.assertNull(bc, "未找到投标人资质申请数据！");
		if(bca == null){
			bca = new BidderCertificateAduit();
		}
			//审核通过 
			if(flag){
//				1.插入投标人正式表
				Bidder bidder = bidderDao.selectByUserId(bc.getUserId());
				if(bidder==null){
					bidderDao.insertSelectByBidderIdSuccess(bidderId);
				}else{
					bidderDao.updateByBidderIdSuccess(bidderId);
				}
				
//				2.插入资质证书正式表
				List<BidderCertification> bcfs  = bcDao.selectByBidderId(bidderId);
				if(bcfs == null || bcfs.size()==0){
					bcDao.insertSelectiveByCertificationIdSuccess(bidderId);
				}else{
					bcDao.updateByCertificationIdSuccess(bidderId);
				}
				
//				3.插入开户行正式表 信息
				List<UserBankcard> ubcs = userBankcardDao.selectBidderBankInfoByUserId(bc.getUserId());
				if(ubcs != null || ubcs.size()==0){
					userBankcardDao.insertBidderBankInfo(bc.getUserId());
				}else{
					userBankcardDao.updateBidderBankInfo(bc.getUserId());
				}
				bca.setAuditStatus("OK#");
				
			}else{//审核不通过
				bca.setAuditStatus("FLS");
				
			}
//			4.插入审核信息
			
				bca = this.getBidderCertificateAduitInfo(body.getBaseInfoCheck(), bca);
				bca = getBidderCertificateAduitInfo(body.getLegalPersonCheck(), bca);
				bca = getBidderCertificateAduitInfo(body.getRegisteredInfoCheck(), bca);
				bca.setInsertTime(new Date());//首次插入时间
				bca.setBidderCerticateId(bidderId);
				bca.setAuditor(bc.getUserId());
				bca.setAuditTime(new Date());
			if(bca==null){
				bca.setInsertTime(new Date());//首次插入时间
				bidderCertificateAduitDao.insert(bca);
			}else{
				bidderCertificateAduitDao.updateByPrimaryKey(bca);
			}

			
		
		
//		bc = getBidderCertificateAduitInfo(obj, bc)
//		BidderCertificateAduit bc = this.getBidderCertificateAduitInfo(obj, bc);
		
		return flag;
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
	public  <T> BidderCertificateAduit getBidderCertificateAduitInfo(T obj,BidderCertificateAduit bc) throws BusinessException {
		// TODO Auto-generated method stub
		
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
	public  <T> Boolean checkIsOk(T obj) throws BusinessException {
		// TODO Auto-generated method stub
		boolean flag = true;
//		BidderBaseInfoCheck baseInfoCheck = body.getBaseInfoCheck();
		Class clazz = obj.getClass();
	    Field[] fields = obj.getClass().getDeclaredFields();//获得属性
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
							if(!"OK#".equalsIgnoreCase(mm.getResult())){
								return false;
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


