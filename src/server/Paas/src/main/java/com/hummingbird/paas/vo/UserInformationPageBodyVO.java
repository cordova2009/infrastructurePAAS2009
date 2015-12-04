package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 查询发布信息列表接口 
 * @author YJY  
 * @since 2015年11月10日16:21:54
 * @see 用于规范json
 * */

//"token":"12345",
//"pageIndex":1,
//"pageSize":10,
//"status":"CRT"
public class UserInformationPageBodyVO{
	
	private String   token;
	private Integer   pageIndex;
	private Integer   pageSize;
	private String   status;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}
	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
		return "UserInformationPageBodyVO [token=" + token + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", status=" + status + "]";
	}
	
	
	
}
