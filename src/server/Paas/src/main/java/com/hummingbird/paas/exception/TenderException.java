/**
 * 
 * MaAccountException.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.exception;

import com.hummingbird.common.exception.BusinessException;

/**
 * @author huangjiej_2
 * 2014年12月27日 下午10:07:38
 * 本类主要做为招标管理的异常
 */
public class TenderException extends BusinessException {

	/**
	 * 招标信息异常
	 */
	static public int ERR_TENDER_INFO_EXCEPTION=1;
	
	
	
	public TenderException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TenderException(int errcode, String message, Throwable cause) {
		super(errcode, message, cause);
		// TODO Auto-generated constructor stub
	}

	public TenderException(int errcode, String message) {
		super(errcode, message);
		// TODO Auto-generated constructor stub
	}

	public TenderException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TenderException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TenderException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
