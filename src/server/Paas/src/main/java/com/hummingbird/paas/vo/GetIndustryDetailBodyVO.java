package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 查询工程类别详情 在body VO
 */
public class GetIndustryDetailBodyVO
implements PainttextAble {

    	/**
	     * 工程类别id
	     */
	    protected String industryId;
	
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
				   
							ObjectUtils.toString(industryId) 
							);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}


	/**
	 * 工程类别id 
	 */
	public String getIndustryId() {
		return industryId;
	}


	/**
	 * 工程类别id 
	 */
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

    

}