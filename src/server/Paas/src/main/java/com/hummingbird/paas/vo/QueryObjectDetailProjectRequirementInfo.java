package com.hummingbird.paas.vo;

public class QueryObjectDetailProjectRequirementInfo {
    private String projectExpectStartDate;
    private Integer projectExpectPeriod;
	public String getProjectExpectStartDate() {
		return projectExpectStartDate;
	}
	public void setProjectExpectStartDate(String projectExpectStartDate) {
		this.projectExpectStartDate = projectExpectStartDate;
	}
	public Integer getProjectExpectPeriod() {
		return projectExpectPeriod;
	}
	public void setProjectExpectPeriod(Integer projectExpectPeriod) {
		this.projectExpectPeriod = projectExpectPeriod;
	}
	@Override
	public String toString() {
		return "QueryObjectDetailProjectRequirementInfo [projectExpectStartDate=" + projectExpectStartDate
				+ ", projectExpectPeriod=" + projectExpectPeriod + "]";
	}
}
