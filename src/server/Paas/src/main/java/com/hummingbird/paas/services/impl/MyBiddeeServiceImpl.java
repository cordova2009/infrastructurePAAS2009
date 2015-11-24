package com.hummingbird.paas.services.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.paas.entity.Announcement;
import com.hummingbird.paas.entity.BiddeeCerticate;
import com.hummingbird.paas.entity.InstationNotification;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.mapper.AnnouncementMapper;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BiddeeBankAduitMapper;
import com.hummingbird.paas.mapper.BiddeeBidCreditScoreMapper;
import com.hummingbird.paas.mapper.BiddeeCerticateMapper;
import com.hummingbird.paas.mapper.BiddeeCertificateAduitMapper;
import com.hummingbird.paas.mapper.BiddeeCreditMapper;
import com.hummingbird.paas.mapper.InstationNotificationMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.services.AnnouncementService;
import com.hummingbird.paas.services.InstationNotificationService;
import com.hummingbird.paas.services.MyBiddeeService;
import com.hummingbird.paas.vo.BiddeeBankInfo;
import com.hummingbird.paas.vo.BiddeeBaseInfo;
import com.hummingbird.paas.vo.BiddeeLegalPerson;
import com.hummingbird.paas.vo.BiddeeRegisteredInfo;
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
public class MyBiddeeServiceImpl implements MyBiddeeService {
	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	protected BiddeeCerticateMapper biddeeCerticateDao;
	@Autowired
	protected BiddeeCertificateAduitMapper biddeeCertificateAduitDao;
	@Autowired
	protected UserBankcardMapper userBankcardDao;
	@Autowired
	protected BiddeeCreditMapper biddeeCreditDao;
	@Autowired
	protected BiddeeBidCreditScoreMapper biddeeBidCreditScoreDao;
	@Autowired
	protected BiddeeBankAduitMapper biddeeBankAduitDao;
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
	public BiddeeBaseInfo getBaseInfo_apply(Token token) throws BusinessException {
		// TODO Auto-generated method stub
		BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(token.getUserId());
		
		BiddeeBaseInfo baseInfo = new BiddeeBaseInfo();
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
	public BiddeeLegalPerson getLegalPersonInfo_apply(Token token) throws BusinessException {
		// TODO Auto-generated method stub
		BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(token.getUserId());
		
//		"legalPerson":{
//	        "name":"张三",
//	        "idCard":"420923199205049230121",
//	        "idCardfrontUrl":"法人身份证正面地址",
//	        "idCardBackUrl":"法人身份证反面地址",
//	        "authorityBookUrl":""
//	    }
		BiddeeLegalPerson legalPerson = new BiddeeLegalPerson();
		legalPerson.setName(Md5Util.Encrypt(aa.getLegalPerson()));
		legalPerson.setIdCard(Md5Util.Encrypt(aa.getLegalPersonIdcard()));
		legalPerson.setIdCardfrontUrl(aa.getLegalPersonIdcardFrontUrl());
		legalPerson.setIdCardBackUrl(aa.getLegalPersonIdcardBackUrl());
		legalPerson.setAuthorityBookUrl(aa.getLegalPersonAuthorityBook());
		
		return legalPerson;
	}

	@Override
	public BiddeeRegisteredInfo getRegisteredInfo_apply(Token token) throws BusinessException {
		// TODO Auto-generated method stub
		BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(token.getUserId());
		
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
		BiddeeRegisteredInfo registeredInfo = new BiddeeRegisteredInfo();
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
	public BiddeeBankInfo getBankInfo_apply(Token token) throws BusinessException {
		// TODO Auto-generated method stub

		List<UserBankcard> aa = userBankcardDao.selectBiddeeBankInfoByToken(token.getToken());
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
		}
		return bankInfo;
	}

	@Override
	public int saveBaseInfo_apply(String appId, BiddeeBaseInfo baseInfo, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		if(token.getUserId() != null){
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token.getUserId());
			if(biddee==null){
				biddee=new BiddeeCerticate();
				if(baseInfo!= null){
					String company_name = baseInfo.getCompanyName();
					String short_name = baseInfo.getShortName();
					String description = baseInfo.getDescription();
					String registered_capital = baseInfo.getRegisteredCapital();
					String telephone = baseInfo.getTelephone();
					String email = baseInfo.getEmail();
					biddee.setCompanyName(company_name);
					biddee.setShortName(short_name);
					biddee.setDescription(description);
					biddee.setRegisteredCapital(registered_capital);
					biddee.setContactMobileNum(telephone);
					biddee.setEmail(email);
					
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
					biddee.setCompanyName(company_name);
					biddee.setShortName(short_name);
					biddee.setDescription(description);
					biddee.setRegisteredCapital(registered_capital);
					biddee.setContactMobileNum(telephone);
					biddee.setEmail(email);
					
				}
				i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
			}
			
		}
		
		return i;
		
	}

	@Override
	public int saveLegalPersonInfo_apply(String appId, BiddeeLegalPerson legalPerson, Token token) throws BusinessException {
		// TODO Auto-generated method stub
        int i = 0;
		if(token.getUserId()!=null){
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token.getUserId());
			if(biddee==null){
				biddee=new BiddeeCerticate();
				if(legalPerson!= null){
					String name = legalPerson.getName();
					String idCard = legalPerson.getIdCard();
					String idCardfrontUrl = legalPerson.getIdCardfrontUrl();
					
					String idCardBackUrl = legalPerson.getIdCardBackUrl();
					String authorityBookUrl = legalPerson.getAuthorityBookUrl();
					
					
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
	public int saveRegisteredInfo(String appId, BiddeeRegisteredInfo registeredInfo, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		if(token.getUserId() != null){
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token.getUserId());
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
				
				
				
				
				biddee.setBusinessLicenseType(businessLicenseType);
				
				if("NEW3".equalsIgnoreCase(businessLicenseType)){
					
					biddee.setUnifiedSocialCreditCode(newBusinessLicenseNum);
					biddee.setUnifiedSocialCreditCodeUrl(newBusinessLicenseUrl);
					biddee.setNewBusinessLicense(newBusinessLicenseNum);
					/*biddee.setBusinessLicense(newBusinessLicenseNum);
					biddee.setBusinessLicenseUrl(newBusinessLicenseUrl);*/
				}else if("OLD3".equalsIgnoreCase(businessLicenseType)){
					biddee.setBusinessLicense(businessLicenseNum);
					biddee.setBusinessLicenseUrl(businessLicenseUrl);
					biddee.setTaxRegistrationCertificate(taxRegistrationNum);
					biddee.setTaxRegistrationCertificateUrl(taxRegistrationUrl);
					biddee.setOrgCodeCertificate(organizationCodeNum);
					biddee.setOrgCodeCertificateUrl(organizationCodeUrl);
				}
	
				biddee.setBusinessScope(businessScope);
				biddee.setAddress(address);
				
				biddee.setRegTime(DateUtil.parseDateToTimestamp(regTime, "yyyy-MM-dd HH:mm:ss"));
				biddee.setBusinessLicenseExpireTime(DateUtil.parseDateToTimestamp(businessLicenseExpireTime, "yyyy-MM-dd HH:mm:ss"));
			}	
			if(biddee==null && biddee.getId()==null){
				//biddee=new BiddeeCerticate();
				i = biddeeCerticateDao.insertSelective(biddee);
			}else{
			
				i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
			}
			
		}
		return i;
		
		}

	@Override
	public int saveBankInfo(String appId, BiddeeBankInfo bankInfo, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		if(token.getUserId() != null){
			List<UserBankcard> banks=userBankcardDao.selectBiddeeBankInfoByToken(token.getToken());
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
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token.getUserId());
			if(biddee==null){
				if(log.isDebugEnabled()){
					log.debug("未找到相应记录 ,请先填写基本信息!");
				}
				}else{
					biddee.setStatus("OK#");//修改状态为已认证
					i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
				}
			
				
				i = biddeeCerticateDao.insertSelective(biddee);
			}
			return i;
	
	}
		  
	}


