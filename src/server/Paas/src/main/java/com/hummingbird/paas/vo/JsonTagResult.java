package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

/**
 * 用于标签 
 * @author YJY  
 * @since 2015年11月30日19:42:09
 * @see 用于规范json
 * */

//{"errcode":10000,"errmsg":"接收的数据为空"}
public class JsonTagResult {
	
	private String  errcode;
	private String  errmsg;
	/**
	 * @return the errcode
	 */
	public String getErrcode() {
		return errcode;
	}
	/**
	 * @return the errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}
	/**
	 * @param errcode the errcode to set
	 */
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	/**
	 * @param errmsg the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonTagResult [errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}
	
}
