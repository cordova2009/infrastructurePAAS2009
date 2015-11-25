/**
 * 
 */
package com.hummingbird.usercenter.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.Md5Util;
import com.hummingbird.usercenter.exception.MaAccountException;
import com.hummingbird.usercenter.face.Account;

/**
 * @author liudou
 * 验证账户是否被篡改
 */
public abstract class AccountValidateUtil {
	static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(AccountValidateUtil.class);
	
	
 	public static void validateAccount(Account account) throws MaAccountException{
		String balanceValidateString = account.getBalanceValidateString();
		String md5value = Md5Util.Encrypt(balanceValidateString);
		if(log.isTraceEnabled()){
			log.trace(String.format("帐户%s,防串改明文为%s，签名为%s", account,balanceValidateString,md5value));
		}
		if(!StringUtils.equals(md5value, account.getSignature())){
			if (log.isDebugEnabled()) {
				log.debug(String.format(account.getAccountName()+account.getAccountId()+"账户信息被篡改"));
			}
			throw new MaAccountException(MaAccountException.ERR_ACCOUNT_EXCEPTION,"账户信息可能遭篡改，请联系管理员");
		}
		
	}
 	//不抛异常
 	public static int validateAccountSignature(Account account) throws MaAccountException{
		int i=1;
 		String balanceValidateString = account.getBalanceValidateString();
		String md5value = Md5Util.Encrypt(balanceValidateString);
		if(!StringUtils.equals(md5value, account.getSignature())){
			i=0;
			if (log.isDebugEnabled()) {
				log.debug(String.format(account.getAccountName()+account.getAccountId()+"账户信息被篡改"));
			}
		}
		return i;
	}
	public static void updateAccountSignature(Account account){
		
		String balanceValidateString = account.getBalanceValidateString();
		String md5value = Md5Util.Encrypt(balanceValidateString);
		if(log.isTraceEnabled()){
			log.trace(String.format("帐户%s,防串改明文为%s，签名为%s", account,balanceValidateString,md5value));
		}
		account.setSignature(md5value);	
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(DateUtil.toDayStart(new Date()));
		
	}

}
