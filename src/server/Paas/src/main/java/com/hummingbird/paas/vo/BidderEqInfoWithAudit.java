package com.hummingbird.paas.vo;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hummingbird.common.util.convertor.JacksonDateSerializer;
import com.hummingbird.common.util.convertor.JacksonDateTimeSerializer;
import com.hummingbird.paas.util.JacksonDateDeserializer;

/**
 * 投标人资质信息
 * 
 * @author YJY
 * @since 2015年11月10日16:22:07
 * @see 用于规范json
 */

// "baseInfo":{
// "companyName":"深圳蜂鸟娱乐技术有限公司",
// "shortName":"蜂鸟娱乐",
// "description":"公司简介",
// "registeredCapital":"",
// "telephone":"",
// "email":"",
// "logoUrl":"LOGO_IMAGE_URL"
// }
public class BidderEqInfoWithAudit extends BidderEqInfo {

	
	/**
	 * 审核结果,为空表示未审核,FLS审核不通过,OK#审核通过
	 */
	private String audit;
	/**
	 * 审核不通过的说明
	 */
	private String auditMsg;

	

	/**
	 * 审核结果为空表示未审核FLS审核不通过OK#审核通过 
	 */
	public String getAudit() {
		return audit;
	}

	/**
	 * 审核结果为空表示未审核FLS审核不通过OK#审核通过 
	 */
	public void setAudit(String audit) {
		this.audit = audit;
	}

	/**
	 * 审核不通过的说明 
	 */
	public String getAuditMsg() {
		return auditMsg;
	}

	/**
	 * 审核不通过的说明 
	 */
	public void setAuditMsg(String auditMsg) {
		this.auditMsg = auditMsg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidderEqInfoWithAudit [audit=" + audit + ", auditMsg=" + auditMsg + ", projectType=" + projectType
				+ ", projectTypeName=" + projectTypeName + ", eqName=" + eqName + ", eqRating=" + eqRating + ", eqId="
				+ eqId + ", certificationContent=" + certificationContent + ", applicableRegion=" + applicableRegion
				+ ", certificationNo=" + certificationNo + ", certificationId=" + certificationId + ", expiryDate="
				+ expiryDate + "]";
	}

	

	
}
