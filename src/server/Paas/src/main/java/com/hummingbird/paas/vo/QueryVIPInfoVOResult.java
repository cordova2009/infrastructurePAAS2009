package com.hummingbird.paas.vo;


public class QueryVIPInfoVOResult {
	/**
	 * 是否为会员
	 */
	private String isMember="";
	/**
	 * 会员开始时间
	 */
	private String memberStartTime="";
	/**
	 * 会员结束时间
	 */
	private String memberEndTime="";
	/**
	 * 会员类型
	 */
	private String memberType="";
	/**
	 * 会员特权
	 */
	private String memberContent="";
	
	

	
	public String getIsMember() {
		return isMember;
	}
	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}
	public String getMemberStartTime() {
		return memberStartTime;
	}
	public void setMemberStartTime(String memberStartTime) {
		this.memberStartTime = memberStartTime;
	}
	public String getMemberEndTime() {
		return memberEndTime;
	}
	public void setMemberEndTime(String memberEndTime) {
		this.memberEndTime = memberEndTime;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getMemberContent() {
		return memberContent;
	}
	public void setMemberContent(String memberContent) {
		this.memberContent = memberContent;
	}
	
	

}
