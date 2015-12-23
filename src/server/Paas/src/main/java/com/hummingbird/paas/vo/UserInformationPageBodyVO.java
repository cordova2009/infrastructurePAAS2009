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
public class UserInformationPageBodyVO extends BaseUserInformationPageBodyVO{
	
	private String   token;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInformationPageBodyVO [token=" + token + ", status=" + status + ", keywords=" + keywords
				+ ", pageSize=" + pageSize + ", pageIndex=" + pageIndex + "]";
	}
	
	
	
}
