package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 用于标签 
 * @author YJY  
 * @since 2015年11月30日19:42:09
 * @see 用于规范json
 * */

//{"errcode":0,"errmsg":[{"tagName":"市场活动","tabUseNum":1,"tagId":1,"businessId":"1"}]}
public class JsonResultMsg {
	
	private String  tagName;
	private Integer  tabUseNum;
	private Integer  tagId;
	private String  businessId;
	/**
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}
	/**
	 * @return the tabUseNum
	 */
	public Integer getTabUseNum() {
		return tabUseNum;
	}
	/**
	 * @return the tagId
	 */
	public Integer getTagId() {
		return tagId;
	}
	/**
	 * @return the businessId
	 */
	public String getBusinessId() {
		return businessId;
	}
	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	/**
	 * @param tabUseNum the tabUseNum to set
	 */
	public void setTabUseNum(Integer tabUseNum) {
		this.tabUseNum = tabUseNum;
	}
	/**
	 * @param tagId the tagId to set
	 */
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	/**
	 * @param businessId the businessId to set
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonResultMsg [tagName=" + tagName + ", tabUseNum=" + tabUseNum + ", tagId=" + tagId + ", businessId="
				+ businessId + "]";
	}
	

	
}
