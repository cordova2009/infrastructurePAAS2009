package com.hummingbird.paas.vo;

public class QueryMemberInfoResultVO {
    private Boolean isMember;
    private String memberStartTime;
    private String memberEndTime;
    private String memberType;
    private String memberContent;
	public Boolean getIsMember() {
		return isMember;
	}
	public void setIsMember(Boolean isMember) {
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
	@Override
	public String toString() {
		return "QueryMemberInfoResultVO [isMember=" + isMember + ", memberStartTime=" + memberStartTime
				+ ", memberEndTime=" + memberEndTime + ", memberType=" + memberType + ", memberContent=" + memberContent
				+ "]";
	}
}
