package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 查询公司信息接口 在body VO
 */
public class QueryCompanyInfoBodyVO 
implements PainttextAble {
    
//	 "body":{
//    "companyId":23,
//    "type":"BEE"
//}
	    /**
	     * 用户令牌
	     */
	protected Integer companyId;
	protected String type;
	
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
					ObjectUtils.toString(companyId) , 					ObjectUtils.toString(type) 				);
		return pt;
	}

	/**
	 * @return the companyId
	 */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryCompanyInfoBodyVO [companyId=" + companyId + ", type=" + type + "]";
	}
	


    

}