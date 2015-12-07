package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.ObjectUtils;

/**
 * 查询工程类别列表项 结果输出 VO
 */
public class GetIndustryListBodyVOResult {
	/**
	 * 工程类别id
	 */
	protected String industryId;
	/**
	 * 工程类别图标
	 */
	protected String industryIcon;
	/**
	 * 工程类别名称
	 */
	protected String industryName;

	/**
	 * 工程类别id
	 * 
	 * @return
	 */
	public String getIndustryId() {
		return industryId;
	}

	/**
	 * 工程类别id
	 * 
	 * @param
	 */
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	/**
	 * @return 工程类别图标
	 */
	public String getIndustryIcon() {
		return industryIcon;
	}

	/**
	 * @param 工程类别图标
	 */
	public void setIndustryIcon(String industryIcon) {
		this.industryIcon = industryIcon;
	}

	/**
	 * @return 工程类别名称
	 */
	public String getIndustryName() {
		return industryName;
	}

	/**
	 * @param 工程类别名称
	 */
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

}