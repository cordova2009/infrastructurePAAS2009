/**
 * 
 * BaseUserInformationPageBodyVO.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.vo;

import java.util.List;

import com.hummingbird.commonbiz.vo.PagingnationVO;

/**
 * @author john huang
 * 2015年12月23日 下午7:47:53
 * 本类主要做为
 */
public class BaseUserInformationPageBodyVO extends PagingnationVO {

	/**
	 * 状态
	 */
	protected String status;
	/**
	 * 关键字
	 */
	protected List<String> keywords;

	/**
	 * 构造函数
	 */
	public BaseUserInformationPageBodyVO() {
		super();
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseUserInformationPageBodyVO [status=" + status + ", keywords=" + keywords + ", pageSize=" + pageSize
				+ ", pageIndex=" + pageIndex + "]";
	}


	/**
	 * 关键字 
	 */
	public List<String> getKeywords() {
		return keywords;
	}


	/**
	 * 关键字 
	 */
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}




}