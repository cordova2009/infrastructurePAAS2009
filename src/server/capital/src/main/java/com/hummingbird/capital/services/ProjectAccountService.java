/**
 * 
 * CashAccountService.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.capital.services;

import com.hummingbird.capital.entity.ProjectAccount;
import com.hummingbird.capital.exception.MaAccountException;

/**
 * @author huangjiej_2
 * 2014年12月29日 下午10:55:31
 * 本类主要做为
 */
public interface ProjectAccountService extends AccountService {
	public void open(ProjectAccount cashAccount) throws MaAccountException;
}
