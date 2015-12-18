package com.hummingbird.capital.services.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.capital.entity.ProjectAccount;
import com.hummingbird.capital.entity.ProjectAccount;
import com.hummingbird.capital.entity.ProjectAccountOrder;
import com.hummingbird.capital.entity.ProjectPaymentAccount;
import com.hummingbird.capital.entity.ProjectPaymentAccountOrder;
import com.hummingbird.capital.entity.User;
import com.hummingbird.capital.entity.UserBankcard;
import com.hummingbird.capital.entity.UserPassword;
import com.hummingbird.capital.exception.MaAccountException;
import com.hummingbird.capital.face.Account;
import com.hummingbird.capital.mapper.ProjectAccountMapper;
import com.hummingbird.capital.mapper.ProjectAccountOrderMapper;
import com.hummingbird.capital.mapper.ProjectPaymentAccountMapper;
import com.hummingbird.capital.mapper.ProjectPaymentAccountOrderMapper;
import com.hummingbird.capital.mapper.UserBankcardMapper;
import com.hummingbird.capital.mapper.UserPasswordMapper;
import com.hummingbird.capital.services.CapitalManageService;
import com.hummingbird.capital.util.AccountValidateUtil;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.DESUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.ValidateResult;
import com.hummingbird.commonbiz.util.NoGenerationUtil;

@Service
public class CapitalManageServiceImpl implements CapitalManageService{
	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());
	@Autowired
	private UserBankcardMapper bankcardDao;
	@Autowired
	private ProjectAccountMapper proActDao;
	@Autowired
	private ProjectPaymentAccountMapper proPaymentActDao;
	@Autowired
	private ProjectPaymentAccountOrderMapper proPaymentActOrderDao;
	@Autowired
	ProjectAccountOrderMapper proActOrdDo;
	@Autowired
	UserPasswordMapper passwordDao;
	@Autowired
	AccountIdServiceImpl accountIdSrv;
	@Override
	public List<UserBankcard> queryBankListByUserId(Integer userId) {
		return bankcardDao.queryBankListByUserId(userId);
	}
	@Override
	public ProjectAccount queryAccountInfo(Integer userId) {
		
		return proActDao.queryAccountInfo(userId);
	}
	@Override
	public List<ProjectAccountOrder> queryAccountRecordsByAccountId(
			String accountId,Pagingnation page) {
		if(page!=null&&page.isCountsize()){
			int totalcount = proActOrdDo.selectTotalCountByaccountId(accountId);
			page.setTotalCount(totalcount);
			page.calculatePageCount();
		}
		return proActOrdDo.queryRecordsByAccountId(accountId,page);
	}
	@Override
	public Integer getAccountIncome(String accountId) {
		// TODO Auto-generated method stub
		return proActOrdDo.getAccountIncome(accountId);
	}
	@Override
	public Integer getAccountOutlay(String accountId) {
		// TODO Auto-generated method stub
		return proActOrdDo.getAccountOutlay(accountId);
	}
	@Override
	public ValidateResult validatePaymentCode(String tradePassword,
			User user,String appkey) throws DataInvalidException {
		UserPassword userPassword=passwordDao.selectByPrimaryKey(user.getId());
		ValidateUtil.assertNull(user, "用户");
		if (log.isDebugEnabled()) {
			log.debug(String.format("验证用户%s与传入的支付码%s是否一致",user.getMobileNum(),tradePassword));
		}
		String decodeTradePassword =null;
		//尝试进行解密
		if(StringUtils.isNotBlank(tradePassword)){
			try {
				decodeTradePassword= DESUtil.decodeDESwithCBC(tradePassword, appkey);
				
			}catch (Exception e) {
				log.error(String.format("支付密码des解密出错"),e);
				throw ValidateException.ERROR_PARAM_FORMAT_ERROR.clone(e,"支付密码des解密出错");
			}
		}
		ValidateUtil.assertNotEqual(userPassword.getTradePassword(), decodeTradePassword,"支付密码不正确", ValidateException.ERROR_MATCH_VALIDATECODE.getErrcode());
		ValidateResult vr = new ValidateResult();
		vr.setValidateMsg("支付验证码验证成功");
		return vr;
	}
	
	@Override
	public Account createProjectPaymentAccount(Integer userId) throws MaAccountException {
		Account acc = proPaymentActDao.getAccountByUserId(userId);
		String accountId=null;
		if(acc==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("为用户%s创建工程款帐户",userId));
			}
			ProjectPaymentAccount ca = new ProjectPaymentAccount();
			ca.setUserId(userId);
			accountId = accountIdSrv.prepareGetAccountId("9800");
			ca.setAccountId(accountId);
			ca.setFrozenSum(0l);
			ca.setInsertTime(new Date());
			ca.setRemainingSum(0l);
			ca.setStatus("OK#");
			AccountValidateUtil.updateAccountSignature(ca);
			try {
				proPaymentActDao.insert(ca);
			} catch (Exception e) {
				if (log.isDebugEnabled()) {
					log.debug(String.format("创建工程款帐户出错"),e);
				}
				//还原帐户
//				accountIdSrv.returnAccountId(accountId);
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"帐户创建失败");
			}
			acc = (Account) ca;
		}else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户%s工程款帐户已创建",userId));
			}
		}
		
		return acc;
	}
	
	@Override
	public Account createAccount(Integer userId) throws MaAccountException {
		Account acc = proActDao.getAccountByUserId(userId);
		String accountId=null;
		if(acc==null){
			if (log.isDebugEnabled()) {
				log.debug(String.format("为用户%s创建现金帐户",userId));
			}
			ProjectAccount ca = new ProjectAccount();
			ca.setUserId(userId);
			accountId = accountIdSrv.prepareGetAccountId("9500");	
			ca.setAccountId(accountId);
			ca.setFrozenSum(0l);
			ca.setInsertTime(new Date());
			ca.setRemainingSum(0l);
			ca.setStatus("OK#");
			AccountValidateUtil.updateAccountSignature(ca);
			try {
				proActDao.insert(ca);
			} catch (Exception e) {
				if (log.isDebugEnabled()) {
					log.debug(String.format("创建资金帐户出错"),e);
				}
				//还原帐户
//				accountIdSrv.returnAccountId(accountId);
				throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"帐户创建失败");
			}
			acc = ca;
		}else{
			if (log.isDebugEnabled()) {
				log.debug(String.format("用户%s资金帐户已创建",userId));
			}
		}
		
		return acc;
	}
	

	/**
	 * 工程款收入
	 * @param platformuserId
	 * @param amount
	 * @param appOrderId
	 */
	public void incomeProjectPayment(Integer userId, Long amount, String appOrderId,String remark)
	{
		ProjectPaymentAccount pa = this.getProjectPaymentAccount(userId);
//		ProjectAccount pa = this.queryAccountInfo(userId);
		pa.setRemainingSum(pa.getRemainingSum()+amount);
		proPaymentActDao.updateByPrimaryKey(pa);
		ProjectPaymentAccountOrder order = new ProjectPaymentAccountOrder();
		order.setAccountId(pa.getAccountId());
		order.setSum(amount);
		order.setBalance(pa.getRemainingSum());
		order.setAppOrderId(appOrderId);
		order.setFlowDirection("IN#");
		order.setFrozenSumSnapshot(pa.getFrozenSum());
		order.setInsertTime(new Date());
		order.setMethod("/capitalManage/UserAccountIncome");
		order.setOrderId(NoGenerationUtil.genNO("PA",6));
		order.setRemark(remark);
		order.setStatus("OK#");
		order.setType("CZ#");
		proPaymentActOrderDao.insert(order);
		
	}
	/**
	 * 获取用户的工程款帐号
	 * @param userId
	 * @return
	 */
	private ProjectPaymentAccount getProjectPaymentAccount(Integer userId) {
		return (ProjectPaymentAccount) proPaymentActDao.getAccountByUserId(userId);
	}
	
}
