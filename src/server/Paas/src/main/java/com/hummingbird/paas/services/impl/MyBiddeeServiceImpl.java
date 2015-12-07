package com.hummingbird.paas.services.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.BiddeeBankCardCerticate;
import com.hummingbird.paas.entity.BiddeeCerticate;
import com.hummingbird.paas.entity.BiddeeCertificateAduit;
import com.hummingbird.paas.entity.BiddeeCertification;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.mapper.BidObjectMapper;
import com.hummingbird.paas.mapper.BiddeeBankAduitMapper;
import com.hummingbird.paas.mapper.BiddeeBankCardCerticateMapper;
import com.hummingbird.paas.mapper.BiddeeBidCreditScoreMapper;
import com.hummingbird.paas.mapper.BiddeeCerticateMapper;
import com.hummingbird.paas.mapper.BiddeeCertificateAduitMapper;
import com.hummingbird.paas.mapper.BiddeeCertificationCertificationMapper;
import com.hummingbird.paas.mapper.BiddeeCertificationMapper;
import com.hummingbird.paas.mapper.BiddeeCreditMapper;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.ScoreLevelMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.services.MyBiddeeService;
import com.hummingbird.paas.util.CamelUtil;
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
	protected BiddeeCreditMapper biddeeCreditDao;
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
		// TODO Auto-generated method stub
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
			
			legalPerson.setName(util.getShowString(aa.getLegalPerson()));
			legalPerson.setIdCard(util.getShowString(aa.getLegalPersonIdcard()));
			legalPerson.setIdCardfrontUrl(aa.getLegalPersonIdcardFrontUrl());
			legalPerson.setIdCardBackUrl(aa.getLegalPersonIdcardBackUrl());
			legalPerson.setAuthorityBookUrl(aa.getLegalPersonAuthorityBook());
			
		}
		
		
		return legalPerson;
	}

	@Override
	public BiddeeRegisteredInfo getRegisteredInfo_apply(Token token) throws BusinessException {
		// TODO Auto-generated method stub
		BiddeeCerticate aa = biddeeCerticateDao.selectByUserId(token.getUserId());
		BiddeeRegisteredInfo registeredInfo = new BiddeeRegisteredInfo();
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
		if(aa != null){
			
			registeredInfo.setBusinessLicenseNum(aa.getBusinessLicense());
			registeredInfo.setBusinessLicenseUrl(aa.getBusinessLicenseUrl());
			registeredInfo.setTaxRegistrationNum(aa.getTaxRegistrationCertificate());
			registeredInfo.setTaxRegistrationUrl(aa.getTaxRegistrationCertificateUrl());
			registeredInfo.setOrganizationCodeNum(aa.getOrgCodeCertificate());
			registeredInfo.setOrganizationCodeUrl(aa.getOrgCodeCertificateUrl());
			registeredInfo.setBusinessScope(aa.getBusinessScope());
			registeredInfo.setRegTime(aa.getRegTime());
			registeredInfo.setBusinessLicenseExpireTime(DateUtil.formatShortDateorNull(aa.getBusinessLicenseExpireTime()));
			registeredInfo.setAddress(aa.getAddress());
			registeredInfo.setBusinessLicenseType(aa.getBusinessLicenseType());
			registeredInfo.setNewBusinessLicenseNum(aa.getNewBusinessLicense());
			registeredInfo.setNewBusinessLicenseUrl(aa.getUnifiedSocialCreditCodeUrl());
		}
		
		
		return registeredInfo;
	}

	@Override
	public BiddeeBankInfo getBankInfo_apply(Token token) throws BusinessException {
		// TODO Auto-generated method stub

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
		}
		return bankInfo;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveBaseInfo_apply(String appId, BiddeeBaseInfo baseInfo, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
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
					
				}
				i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
			}
			
		}
		
		return i;
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveLegalPersonInfo_apply(String appId, BiddeeLegalPerson legalPerson, Token token) throws BusinessException {
		// TODO Auto-generated method stub
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
				Date businessLicenseExpireTime = null;
				
				if(StringUtils.isNotBlank(registeredInfo.getBusinessLicenseExpireTime())){
					try {
						businessLicenseExpireTime = DateUtils.parseDate(registeredInfo.getBusinessLicenseExpireTime(),"yyyy-MM-dd HH:mm:ss","yyyy-MM-dd");
					} catch (ParseException e) {
						log.error(String.format("企业营业期限%s日期格式不正确",registeredInfo.getBusinessLicenseExpireTime()),e);
						throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e, "企业营业期限日期格式不正确");
					}
				}
				
				biddee.setBusinessLicenseType(businessLicenseType);
				if("NEW".equalsIgnoreCase(businessLicenseType)){
					
					biddee.setUnifiedSocialCreditCode(newBusinessLicenseNum);
					biddee.setUnifiedSocialCreditCodeUrl(newBusinessLicenseUrl);
					biddee.setNewBusinessLicense(newBusinessLicenseNum);
					ValidateUtil.assertNull(newBusinessLicenseNum, "社会统一信用代码");
					ValidateUtil.assertNull(newBusinessLicenseUrl, "三合一执照url");
					/*biddee.setBusinessLicense(newBusinessLicenseNum);
					biddee.setBusinessLicenseUrl(newBusinessLicenseUrl);*/
				}else if("OLD".equalsIgnoreCase(businessLicenseType)){
					biddee.setBusinessLicense(businessLicenseNum);
					biddee.setBusinessLicenseUrl(businessLicenseUrl);
					biddee.setTaxRegistrationCertificate(taxRegistrationNum);
					biddee.setTaxRegistrationCertificateUrl(taxRegistrationUrl);
					biddee.setOrgCodeCertificate(organizationCodeNum);
					biddee.setOrgCodeCertificateUrl(organizationCodeUrl);
					ValidateUtil.assertNull(businessLicenseNum, "营业执照");
					ValidateUtil.assertNull(businessLicenseUrl, "营业执照url");
					ValidateUtil.assertNull(taxRegistrationNum, "税务证书编号");
					ValidateUtil.assertNull(taxRegistrationUrl, "税务证书url");
					ValidateUtil.assertNull(organizationCodeNum, "组织机构代码");
					ValidateUtil.assertNull(organizationCodeUrl, "组织机构url");
				}else{
						throw new BusinessException("营业执照类型不对");
					
				}
	
				biddee.setBusinessScope(businessScope);
				biddee.setAddress(address);
				
				biddee.setRegTime(regTime);
				biddee.setBusinessLicenseExpireTime(businessLicenseExpireTime);
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
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int saveBankInfo(String appId, BiddeeBankInfo bankInfo, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
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
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public int applay(String appId, Token token) throws BusinessException {
		// TODO Auto-generated method stub
		
		int i= 0;
		if(token.getUserId() != null){
			BiddeeCerticate biddee=biddeeCerticateDao.selectByUserId(token.getUserId());
			ValidateUtil.assertNull(biddee, "未找到招标人数据！请先填写完信息再提交!");
	
			biddee.setStatus("OK#");//修改状态为已认证
			i = biddeeCerticateDao.updateByPrimaryKeySelective(biddee);
		
			}
			return i;
	
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public  Boolean checkApplication(String appId, BiddeeAuditBodyInfo body, Integer biddeeId) throws BusinessException {
		// TODO Auto-generated method stub
		boolean flag = true;
		BiddeeBaseInfoCheck baseInfoCheck = body.getBaseInfoCheck();
		BiddeeLegalPersonCheck legalPersonCheck = body.getLegalPersonCheck();
		BiddeeRegisteredInfoCheck registeredInfoCheck = body.getRegisteredInfoCheck();
		BiddeeBankInfoCheck bankInfoCheck  = body.getBankInfoCheck();
		
		boolean baseInfoCheckflag = checkIsOk(baseInfoCheck);
		boolean legalPersonCheckfalg = checkIsOk(legalPersonCheck);
		boolean registeredInfoCheckflag = checkIsOk(registeredInfoCheck);
		boolean bankInfoCheckfalg = checkIsOk(bankInfoCheck);
//		所有信息都OK#的表示认证审核通过，只要有一项FLS的表示认证审核不通过，需要申请人修订后重新提交。
		if(baseInfoCheckflag == false || legalPersonCheckfalg == false || registeredInfoCheckflag == false || bankInfoCheckfalg == false){
			flag = false;
		}
//		baseInfoCheck.getCompany_name().getResult()
		BiddeeCerticate bc = biddeeCerticateDao.selectByPrimaryKey(biddeeId);
		BiddeeCertificateAduit  bca = biddeeCertificateAduitDao.selectByPrimaryKey(biddeeId);

		ValidateUtil.assertNull(bc, "未找到招标人资质申请数据！");
		if(bca == null){
			bca = new BiddeeCertificateAduit();
		}
			//审核通过 
			if(flag){
//				1.插入招标人正式表
				Biddee biddee = biddeeDao.selectByUserId(bc.getUserId());
				if(biddee==null){
					biddeeDao.insertSelectByBiddeeIdSuccess(biddeeId);
				}else{
					biddeeDao.updateByBiddeeIdSuccess(biddeeId);
				}
				
//				2.插入资质证书正式表
				List<BiddeeCertification> bcfs  = bcDao.selectByBiddeeId(biddeeId);
				if(bcfs == null || bcfs.size()==0){
					bcDao.insertSelectiveByCertificationIdSuccess(biddeeId);
				}else{
					bcDao.updateByCertificationIdSuccess(biddeeId);
				}
				
//				3.插入开户行正式表 信息
				List<UserBankcard> ubcs = userBankcardDao.selectBiddeeBankInfoByUserId(bc.getUserId());
				if(ubcs != null || ubcs.size()==0){
					userBankcardDao.insertBiddeeBankInfo(bc.getUserId());
				}else{
					userBankcardDao.updateBiddeeBankInfo(bc.getUserId());
				}
				bca.setAuditStatus("OK#");
				
			}else{//审核不通过
				bca.setAuditStatus("FLS");
				
			}
//			4.插入审核信息
			
			bca = this.getBiddeeCertificateAduitInfo(body.getBaseInfoCheck(), bca);
			bca = getBiddeeCertificateAduitInfo(body.getLegalPersonCheck(), bca);
			bca = getBiddeeCertificateAduitInfo(body.getRegisteredInfoCheck(), bca);
			bca.setBiddeeCerticateId(biddeeId);
			bca.setAuditor(bc.getUserId());
			bca.setAuditTime(new Date());
			if(bca==null){
				
				bca.setInsertTime(new Date());//首次插入时间
				biddeeCertificateAduitDao.insert(bca);
			}else{
				
				biddeeCertificateAduitDao.updateByPrimaryKey(bca);
			}

			
		
		
//		bc = getBiddeeCertificateAduitInfo(obj, bc)
//		BiddeeCertificateAduit bc = this.getBiddeeCertificateAduitInfo(obj, bc);
		
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
	public  <T> BiddeeCertificateAduit getBiddeeCertificateAduitInfo(T obj,BiddeeCertificateAduit bc) throws BusinessException {
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
//		BiddeeBaseInfoCheck baseInfoCheck = body.getBaseInfoCheck();
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
