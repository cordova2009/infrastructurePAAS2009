package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

/**
 * 招标人认证审核接口 
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
public class BiddeeAuditInfoVO extends AppBaseVO implements Decidable {
	
	private BiddeeAuditBodyInfo  body;

	/**
	 * @return the body
	 */
	public BiddeeAuditBodyInfo getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(BiddeeAuditBodyInfo body) {
		this.body = body;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeAuditInfoVO [body=" + body + "]";
	}
	
}
