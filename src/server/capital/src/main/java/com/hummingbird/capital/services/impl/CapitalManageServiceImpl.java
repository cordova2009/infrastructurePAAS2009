package com.hummingbird.capital.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.capital.entity.ProjectAccount;
import com.hummingbird.capital.entity.ProjectAccountOrder;
import com.hummingbird.capital.entity.User;
import com.hummingbird.capital.entity.UserBankcard;
import com.hummingbird.capital.entity.UserPassword;
import com.hummingbird.capital.mapper.ProjectAccountMapper;
import com.hummingbird.capital.mapper.ProjectAccountOrderMapper;
import com.hummingbird.capital.mapper.UserBankcardMapper;
import com.hummingbird.capital.mapper.UserPasswordMapper;
import com.hummingbird.capital.services.CapitalManageService;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.ValidateResult;

@Service
public class CapitalManageServiceImpl implements CapitalManageService{
	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());
	@Autowired
	private UserBankcardMapper bankcardDao;
	@Autowired
	private ProjectAccountMapper ProActDao;
	@Autowired
	ProjectAccountOrderMapper proActOrdDo;
	@Autowired
	UserPasswordMapper passwordDao;
	@Override
	public List<UserBankcard> queryBankListByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return bankcardDao.queryBankListByUserId(userId);
	}
	@Override
	public ProjectAccount queryAccountInfo(Integer userId) {
		
		return ProActDao.queryAccountInfo(userId);
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
			User user) throws DataInvalidException {
		UserPassword userPassword=passwordDao.selectByPrimaryKey(user.getId());
		ValidateUtil.assertNull(user, "用户");
		if (log.isDebugEnabled()) {
			log.debug(String.format("验证用户%s与传入的支付码%s是否一致",user.getMobileNum(),tradePassword));
		}
		ValidateUtil.assertNotEqual(userPassword.getTradePassword(), tradePassword,"支付密码不正确", ValidateException.ERROR_MATCH_VALIDATECODE.getErrcode());
		ValidateResult vr = new ValidateResult();
		vr.setValidateMsg("支付验证码验证成功");
		return vr;
	}
}
