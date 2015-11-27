package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 标签信息 
 * @author YJY  
 * @since 2015年11月27日15:23:49
 * @see 用于规范json
 * */

//{
//    "tagName":"质量好啊","tagNum":3
//}
public class TagInfo {
	
	private String  tagName;
	private Integer  tagNum;
	/**
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}
	/**
	 * @return the tagNum
	 */
	public Integer getTagNum() {
		return tagNum;
	}
	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	/**
	 * @param tagNum the tagNum to set
	 */
	public void setTagNum(Integer tagNum) {
		this.tagNum = tagNum;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TagInfo [tagName=" + tagName + ", tagNum=" + tagNum + "]";
	}
	
	
}
