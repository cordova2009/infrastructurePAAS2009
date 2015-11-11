package com.hummingbird.paas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.ValidateResult;
import com.hummingbird.paas.entity.ProjectAccount;
import com.hummingbird.paas.entity.ProjectAccountOrder;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.entity.UserBankcard;
import com.hummingbird.paas.entity.UserPassword;
import com.hummingbird.paas.mapper.ProjectAccountMapper;
import com.hummingbird.paas.mapper.ProjectAccountOrderMapper;
import com.hummingbird.paas.mapper.UserBankcardMapper;
import com.hummingbird.paas.mapper.UserPasswordMapper;
import com.hummingbird.paas.services.CapitalManageService;

@Service
public class CapitalManageServiceImpl implements CapitalManageService{
	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());
	
	@Autowired
	private ProjectAccountMapper ProActDao;
	@Autowired
	ProjectAccountOrderMapper proActOrdDo;
	@Autowired
	UserPasswordMapper passwordDao;
	
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
