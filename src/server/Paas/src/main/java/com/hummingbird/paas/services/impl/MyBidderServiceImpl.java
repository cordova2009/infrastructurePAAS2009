package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.paas.entity.BidderCerticate;
import com.hummingbird.paas.entity.BidderCertificationCertification;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BidderBankAduitMapper;
import com.hummingbird.paas.mapper.BidderBidCreditScoreMapper;
import com.hummingbird.paas.mapper.BidderCerticateMapper;
import com.hummingbird.paas.mapper.BidderCertificateAduitMapper;
import com.hummingbird.paas.mapper.BidderCertificationCertificationMapper;
import com.hummingbird.paas.mapper.BidderCreditMapper;
import com.hummingbird.paas.mapper.BidderCerticateMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.services.MyBidderService;
import com.hummingbird.paas.vo.BidderBankInfo;
import com.hummingbird.paas.vo.BidderBaseInfo;
import com.hummingbird.paas.vo.BidderEqInfo;
import com.hummingbird.paas.vo.BidderLegalPerson;
import com.hummingbird.paas.vo.BidderRegisteredInfo;
@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
public class MyBidderServiceImpl implements MyBidderService {
	

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	protected BidderCerticateMapper bidderCerticateDao;
	@Autowired
	protected BidderCertificateAduitMapper bidderCertificateAduitDao;
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
		baseInfo.setLogoUrl(aa.getLogo());
		baseInfo.setCompanyName(aa.getCompanyName());
		baseInfo.setShortName(aa.getShortName());
		baseInfo.setDescription(aa.getDescription());
		baseInfo.setRegisteredCapital(aa.getRegisteredCapital());
		baseInfo.setTelephone(aa.getContactMobileNum());
		baseInfo.setEmail(aa.getEmail());
		
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
		legalPerson.setName(Md5Util.Encrypt(aa.getLegalPerson()));
		legalPerson.setIdCard(Md5Util.Encrypt(aa.getLegalPersonIdcard()));
		legalPerson.setIdCardfrontUrl(aa.getLegalPersonIdcardFrontUrl());
		legalPerson.setIdCardBackUrl(aa.getLegalPersonIdcardBackUrl());
		legalPerson.setAuthorityBookUrl(aa.getLegalPersonAuthorityBook());
		
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
		
		return registeredInfo;
	}

	@Override
	public BidderBankInfo getBankInfo_apply(Token token) throws BusinessException {
		// TODO Auto-generated method stub

		List<UserBankcard> aa = userBankcardDao.selectBidderBankInfoByToken(token.getToken());
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
	public int saveBaseInfo_apply(String appId, BidderBaseInfo baseInfo, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		if(token.getUserId() != null){
			BidderCerticate bidder=bidderCerticateDao.selectByUserId(token.getUserId());
			if(bidder==null){
				bidder=new BidderCerticate();
				if(baseInfo!= null){
					String company_name = baseInfo.getCompanyName();
					String short_name = baseInfo.getShortName();
					String description = baseInfo.getDescription();
					String registered_capital = baseInfo.getRegisteredCapital();
					String telephone = baseInfo.getTelephone();
					String email = baseInfo.getEmail();
					bidder.setCompanyName(company_name);
					bidder.setShortName(short_name);
					bidder.setDescription(description);
					bidder.setRegisteredCapital(registered_capital);
					bidder.setContactMobileNum(telephone);
					bidder.setEmail(email);
					
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
					bidder.setCompanyName(company_name);
					bidder.setShortName(short_name);
					bidder.setDescription(description);
					bidder.setRegisteredCapital(registered_capital);
					bidder.setContactMobileNum(telephone);
					bidder.setEmail(email);
					
				}
				i = bidderCerticateDao.updateByPrimaryKeySelective(bidder);
			}
			
		}
		
		return i;
		
	}

	@Override
	public int saveLegalPersonInfo_apply(String appId, BidderLegalPerson legalPerson, Token token) throws BusinessException {
		// TODO Auto-generated method stub
        int i = 0;
		if(token.getUserId()!=null){
			BidderCerticate bidder=bidderCerticateDao.selectByUserId(token.getUserId());
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
	public int saveRegisteredInfo(String appId, BidderRegisteredInfo registeredInfo, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		if(token.getUserId() != null){
			BidderCerticate bidder=bidderCerticateDao.selectByUserId(token.getUserId());
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
				Date businessLicenseExpireTime = registeredInfo.getBusinessLicenseExpireTime();
				
				
				
				
				bidder.setBusinessLicenseType(businessLicenseType);
				
				if("NEW3".equalsIgnoreCase(businessLicenseType)){
					
					bidder.setUnifiedSocialCreditCode(newBusinessLicenseNum);
					bidder.setUnifiedSocialCreditCodeUrl(newBusinessLicenseUrl);
					bidder.setNewBusinessLicense(newBusinessLicenseNum);
					/*bidder.setBusinessLicense(newBusinessLicenseNum);
					bidder.setBusinessLicenseUrl(newBusinessLicenseUrl);*/
				}else if("OLD3".equalsIgnoreCase(businessLicenseType)){
					bidder.setBusinessLicense(businessLicenseNum);
					bidder.setBusinessLicenseUrl(businessLicenseUrl);
					bidder.setTaxRegistrationCertificate(taxRegistrationNum);
					bidder.setTaxRegistrationCertificateUrl(taxRegistrationUrl);
					bidder.setOrgCodeCertificate(organizationCodeNum);
					bidder.setOrgCodeCertificateUrl(organizationCodeUrl);
				}
	
				bidder.setBusinessScope(businessScope);
				bidder.setAddress(address);
				
				bidder.setRegTime(DateUtil.parseDateToTimestamp(regTime, "yyyy-MM-dd HH:mm:ss"));
				bidder.setBusinessLicenseExpireTime(DateUtil.parseDateToTimestamp(businessLicenseExpireTime, "yyyy-MM-dd HH:mm:ss"));
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
	public int saveBankInfo(String appId, BidderBankInfo bankInfo, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		if(token.getUserId() != null){
			List<UserBankcard> banks=userBankcardDao.selectBidderBankInfoByToken(token.getToken());
			UserBankcard b =new UserBankcard();
			
			if(banks!= null && banks.size()>0){
				 b = banks.get(0);
				 if(bankInfo !=null){
						
					 b.setBankName(bankInfo.getBank());
					 b.setAccountNo(bankInfo.getAccountId());
					 b.setAccountName(bankInfo.getAccountName());
				 }
				
				i = userBankcardDao.updateByPrimaryKeySelective(b);

			}else{
				 if(bankInfo !=null){
						
					 b.setBankName(bankInfo.getBank());
					 b.setAccountNo(bankInfo.getAccountId());
					 b.setAccountName(bankInfo.getAccountName());
				 }
				i = userBankcardDao.insertSelective(b);
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
			if(bidder==null){
				if(log.isDebugEnabled()){
					log.debug("未找到相应记录 ,请先填写基本信息!");
				}
				}else{
					bidder.setStatus("OK#");//修改状态为已认证
					i = bidderCerticateDao.updateByPrimaryKeySelective(bidder);
				}
			
				
				i = bidderCerticateDao.insertSelective(bidder);
			}
			return i;
	
	}

	@Override
	public List<BidderEqInfo> getEnterpriseQualification(Token token) throws BusinessException {
		// TODO Auto-generated method stub
		List<BidderEqInfo> aa = bidderCertificationCertificationDao.selectEqInfoByUserId(token.getUserId());

		if(aa==null){
			aa = new ArrayList<BidderEqInfo>();
		}
		
		return aa;
	}

	@Override
	public int saveEnterpriseQualification(String appId, List<BidderEqInfo> eqInfos, Token token)
			throws BusinessException {
		// TODO Auto-generated method stub
			int i =0;
			BidderCerticate bidder = bidderCerticateDao.selectByUserId(token.getUserId());
			if(eqInfos!= null && eqInfos.size()>0){
				
				BidderCertificationCertification b =new BidderCertificationCertification();
				
				for(BidderEqInfo be :  eqInfos){
					if(be.getEqId() != null){
						BidderCertificationCertification bcc=bidderCertificationCertificationDao.selectByPrimaryKey(be.getEqId());
						bcc.setExpireTime(be.getExpiryDate());
//						bcc.setBidderId(be.getEqId());
						bcc.setCertificationContent(be.getEqDesc());
						bcc.setCertificationName(be.getEqName());
						bcc.setIndustryId(be.getProjectType());//工程 类别
						i = bidderCertificationCertificationDao.updateByPrimaryKeySelective(bcc);
//						i = bidderCertificationCertificationDao.updateByPrimaryKeySelective(b);
						
					}else{
						b.setExpireTime(be.getExpiryDate());
						b.setBidderId(bidder.getId());
						b.setCertificationContent(be.getEqDesc());
						b.setCertificationName(be.getEqName());
						b.setIndustryId(be.getProjectType());//工程 类别
						b.setCertificationId(be.getEqId());
						i = bidderCertificationCertificationDao.insert(b);
						
					}
					
				}
				
			}
			return i;
			
			
	}
		  
	
		  
	}


