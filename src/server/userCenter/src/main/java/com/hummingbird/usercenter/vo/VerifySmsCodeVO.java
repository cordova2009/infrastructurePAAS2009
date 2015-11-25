package com.hummingbird.usercenter.vo;

public class VerifySmsCodeVO {
	private String mobileNum;
	private String smsCode;
	
	@Override
	public String toString() {
		return "VerifySmsCodeVO [mobileNum=" + mobileNum + ", smsCode="
				+ smsCode + "]";
	}
	
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getSmsCode() {
		return smsCode;
	}
	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
}
