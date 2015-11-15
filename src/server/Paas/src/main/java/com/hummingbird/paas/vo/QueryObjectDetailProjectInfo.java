package com.hummingbird.paas.vo;

public class QueryObjectDetailProjectInfo {
       private String projectName;
       private String projectSite;
       private String projectScale;
       private String projectExpectInvestment;
       private String employer;
       private String employerPrincipal;
	private String employerTelephone;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectSite() {
		return projectSite;
	}

	public void setProjectSite(String projectSite) {
		this.projectSite = projectSite;
	}

	public String getProjectScale() {
		return projectScale;
	}

	public void setProjectScale(String projectScale) {
		this.projectScale = projectScale;
	}

	public String getProjectExpectInvestment() {
		return projectExpectInvestment;
	}

	public void setProjectExpectInvestment(String projectExpectInvestment) {
		this.projectExpectInvestment = projectExpectInvestment;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getEmployerPrincipal() {
		return employerPrincipal;
	}

	public void setEmployerPrincipal(String employerPrincipal) {
		this.employerPrincipal = employerPrincipal;
	}

	public String getEmployerTelephone() {
		return employerTelephone;
	}

	public void setEmployerTelephone(String employerTelephone) {
		this.employerTelephone = employerTelephone;
	}

	@Override
	public String toString() {
		return "QueryObjectDetailProjectInfo [projectName=" + projectName + ", projectSite=" + projectSite
				+ ", projectScale=" + projectScale + ", projectExpectInvestment=" + projectExpectInvestment
				+ ", employer=" + employer + ", employerPrincipal=" + employerPrincipal + ", employerTelephone="
				+ employerTelephone + "]";
	}
}
