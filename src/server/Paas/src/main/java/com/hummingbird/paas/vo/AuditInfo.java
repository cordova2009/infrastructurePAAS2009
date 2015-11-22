package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 审核信息 包括状态和msg原因 
 * @author YJY  
 * @since 2015年11月7日11:06:3
 * @see 用于规范json
 * */

//"baseInfoCheck":{
//    "biddeeId":999,
//    "companyName":{"result":"FLS","msg":"公司名称与工商注册名称不一致"},
//    "shortName":{"result":"OK#","msg":""},
//    "description":{"result":"OK#","msg":""},
//    "registeredCapital":{"result":"OK#","msg":""},
//    "telephone":{"result":"OK#","msg":""},
//    "email":{"result":"OK#","msg":""},
//    "logoUrl":{"result":"OK#","msg":""}
//}
public class AuditInfo {
	
	private String  result;
	private String  msg;
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuditInfo [result=" + result + ", msg=" + msg + "]";
	}


	
}
