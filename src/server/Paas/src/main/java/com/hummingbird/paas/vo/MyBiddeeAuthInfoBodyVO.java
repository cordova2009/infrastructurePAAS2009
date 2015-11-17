package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 消息详细
 * @author Yu.JY
 * @since 2015年11月6日15:45:10
 * */
public class MyBiddeeAuthInfoBodyVO {
	private String token;

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
	
	@Override
	public String toString() {
		return " MyBiddeeAuthInfoBodyVO [token=" + token + "]";
	}
}
