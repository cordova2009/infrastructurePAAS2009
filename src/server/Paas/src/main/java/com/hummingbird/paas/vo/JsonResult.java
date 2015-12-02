package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

/**
 * 用于标签 
 * @author YJY  
 * @since 2015年11月30日19:42:09
 * @see 用于规范json
 * */

//{"errcode":0,"errmsg":[{"tagName":"市场活动","tabUseNum":1,"tagId":1,"businessId":"1"}]}
public class JsonResult {
	
	private String  errcode;
	private List<JsonResultMsg>  errmsg;
	/**
	 * @return the errcode
	 */
	public String getErrcode() {
		return errcode;
	}
	/**
	 * @return the errmsg
	 */
	public List<JsonResultMsg> getErrmsg() {
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
	public void setErrmsg(List<JsonResultMsg> errmsg) {
		this.errmsg = errmsg;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonResult [errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}
	

	
}
