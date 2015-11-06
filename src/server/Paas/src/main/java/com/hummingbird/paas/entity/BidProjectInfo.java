package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的工程信息表
 */
public class BidProjectInfo {
    /**
     * 标的id
     */
    private String objectId;

    /**
     * 工程标的估价
     */
    private Integer evaluationAmount;

    /**
     * 工程预计开始时间
     */
    private String projectExpectStartDate;

    /**
     * 工程预计结束时间
     */
    private String projectExpectEndDate;

    /**
     * 招标方经办人
     */
    private String biddeeCompanyPrincipal;

    /**
     * 招标方办公电话
     */
    private String biddeeCompanyTelephone;

    /**
     * 工程名称
     */
    private String projectName;

    /**
     * 工程编号
     */
    private String projectNo;

    /**
     * 工程项目概况
     */
    private String projectSituation;

    /**
     * 工程计划总投资
     */
    private String projectExpectInvestment;

    /**
     * 建设单位
     */
    private String employer;

    /**
     * 建设单位经办人
     */
    private String employerPrincipal;

    /**
     * 建设单位办公电话
     */
    private String employerTelephone;

    /**
     * 项目负责人要求
     */
    private String projectManagerRequirement;

    /**
     * 其它要求
     */
    private String otherRequirement;

    /**
     * 工程地点所在镇区，使用区域表id
     */
    private String projectSiteTown;

    /**
     * 工程地点所在城市，使用区域表id
     */
    private String projectSiteCity;

    /**
     * 工程地点所在省份，使用区域表id
     */
    private String projectSiteProvince;

    /**
     * 工程地点
     */
    private String projectSite;

    /**
     * 工程规模及特征
     */
    private String projectScale;

    /**
     * 承包方式
     */
    private String contractType;

    /**
     * 采用币种,CNY人民币,USD美元
     */
    private String currency;

    /**
     * 标准工期,单位是日历天
     */
    private Integer projectExpectPeriod;

    /**
     * 中标通知书附件
     */
    private String letterOfAcceptanceUrl;

    /**
     * 工程施工证明类型,转包,建设单位
     */
    private String constructionProveType;

    /**
     * 工程最晚工期,计划施工总工期不超过xxx日历天
     */
    private Integer projectPeriodDeadline;

    /**
     * 国有土地使用证有效期
     */
    private Date landUseCertificateEnddate;

    /**
     * 建设用地规划许可证有效期
     */
    private Date constructionLandUsePermitEnddate;

    /**
     * 建设工程规划许可证有效期
     */
    private Date buildingPermitEnddate;

    /**
     * 国有土地使用证编号
     */
    private String landUseCertificateNo;

    /**
     * 建设用地规划许可证编号
     */
    private String constructionLandUsePermitNo;

    /**
     * 建设工程规划许可证编号
     */
    private String buildingPermitNo;

    /**
     * 建设工程施工许可证编号
     */
    private String buildingConstructionPermitNo;

    /**
     * 建设工程施工许可证附件
     */
    private String buildingConstructionPermitUrl;

    /**
     * 建设工程施工许可证有效期
     */
    private Date buildingConstructionPermitEnddate;

    /**
     * 国有土地使用证附件
     */
    private String landUseCertificateUrl;

    /**
     * 建设用地规划许可证附件
     */
    private String constructionLandUsePermitUrl;

    /**
     * 建设工程规划许可证附件
     */
    private String buildingPermitUrl;

    /**
     * @return 标的id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * @return 工程标的估价
     */
    public Integer getEvaluationAmount() {
        return evaluationAmount;
    }

    /**
     * @param evaluationAmount 
	 *            工程标的估价
     */
    public void setEvaluationAmount(Integer evaluationAmount) {
        this.evaluationAmount = evaluationAmount;
    }

    /**
     * @return 工程预计开始时间
     */
    public String getProjectExpectStartDate() {
        return projectExpectStartDate;
    }

    /**
     * @param projectExpectStartDate 
	 *            工程预计开始时间
     */
    public void setProjectExpectStartDate(String projectExpectStartDate) {
        this.projectExpectStartDate = projectExpectStartDate == null ? null : projectExpectStartDate.trim();
    }

    /**
     * @return 工程预计结束时间
     */
    public String getProjectExpectEndDate() {
        return projectExpectEndDate;
    }

    /**
     * @param projectExpectEndDate 
	 *            工程预计结束时间
     */
    public void setProjectExpectEndDate(String projectExpectEndDate) {
        this.projectExpectEndDate = projectExpectEndDate == null ? null : projectExpectEndDate.trim();
    }

    /**
     * @return 招标方经办人
     */
    public String getBiddeeCompanyPrincipal() {
        return biddeeCompanyPrincipal;
    }

    /**
     * @param biddeeCompanyPrincipal 
	 *            招标方经办人
     */
    public void setBiddeeCompanyPrincipal(String biddeeCompanyPrincipal) {
        this.biddeeCompanyPrincipal = biddeeCompanyPrincipal == null ? null : biddeeCompanyPrincipal.trim();
    }

    /**
     * @return 招标方办公电话
     */
    public String getBiddeeCompanyTelephone() {
        return biddeeCompanyTelephone;
    }

    /**
     * @param biddeeCompanyTelephone 
	 *            招标方办公电话
     */
    public void setBiddeeCompanyTelephone(String biddeeCompanyTelephone) {
        this.biddeeCompanyTelephone = biddeeCompanyTelephone == null ? null : biddeeCompanyTelephone.trim();
    }

    /**
     * @return 工程名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName 
	 *            工程名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * @return 工程编号
     */
    public String getProjectNo() {
        return projectNo;
    }

    /**
     * @param projectNo 
	 *            工程编号
     */
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    /**
     * @return 工程项目概况
     */
    public String getProjectSituation() {
        return projectSituation;
    }

    /**
     * @param projectSituation 
	 *            工程项目概况
     */
    public void setProjectSituation(String projectSituation) {
        this.projectSituation = projectSituation == null ? null : projectSituation.trim();
    }

    /**
     * @return 工程计划总投资
     */
    public String getProjectExpectInvestment() {
        return projectExpectInvestment;
    }

    /**
     * @param projectExpectInvestment 
	 *            工程计划总投资
     */
    public void setProjectExpectInvestment(String projectExpectInvestment) {
        this.projectExpectInvestment = projectExpectInvestment == null ? null : projectExpectInvestment.trim();
    }

    /**
     * @return 建设单位
     */
    public String getEmployer() {
        return employer;
    }

    /**
     * @param employer 
	 *            建设单位
     */
    public void setEmployer(String employer) {
        this.employer = employer == null ? null : employer.trim();
    }

    /**
     * @return 建设单位经办人
     */
    public String getEmployerPrincipal() {
        return employerPrincipal;
    }

    /**
     * @param employerPrincipal 
	 *            建设单位经办人
     */
    public void setEmployerPrincipal(String employerPrincipal) {
        this.employerPrincipal = employerPrincipal == null ? null : employerPrincipal.trim();
    }

    /**
     * @return 建设单位办公电话
     */
    public String getEmployerTelephone() {
        return employerTelephone;
    }

    /**
     * @param employerTelephone 
	 *            建设单位办公电话
     */
    public void setEmployerTelephone(String employerTelephone) {
        this.employerTelephone = employerTelephone == null ? null : employerTelephone.trim();
    }

    /**
     * @return 项目负责人要求
     */
    public String getProjectManagerRequirement() {
        return projectManagerRequirement;
    }

    /**
     * @param projectManagerRequirement 
	 *            项目负责人要求
     */
    public void setProjectManagerRequirement(String projectManagerRequirement) {
        this.projectManagerRequirement = projectManagerRequirement == null ? null : projectManagerRequirement.trim();
    }

    /**
     * @return 其它要求
     */
    public String getOtherRequirement() {
        return otherRequirement;
    }

    /**
     * @param otherRequirement 
	 *            其它要求
     */
    public void setOtherRequirement(String otherRequirement) {
        this.otherRequirement = otherRequirement == null ? null : otherRequirement.trim();
    }

    /**
     * @return 工程地点所在镇区，使用区域表id
     */
    public String getProjectSiteTown() {
        return projectSiteTown;
    }

    /**
     * @param projectSiteTown 
	 *            工程地点所在镇区，使用区域表id
     */
    public void setProjectSiteTown(String projectSiteTown) {
        this.projectSiteTown = projectSiteTown == null ? null : projectSiteTown.trim();
    }

    /**
     * @return 工程地点所在城市，使用区域表id
     */
    public String getProjectSiteCity() {
        return projectSiteCity;
    }

    /**
     * @param projectSiteCity 
	 *            工程地点所在城市，使用区域表id
     */
    public void setProjectSiteCity(String projectSiteCity) {
        this.projectSiteCity = projectSiteCity == null ? null : projectSiteCity.trim();
    }

    /**
     * @return 工程地点所在省份，使用区域表id
     */
    public String getProjectSiteProvince() {
        return projectSiteProvince;
    }

    /**
     * @param projectSiteProvince 
	 *            工程地点所在省份，使用区域表id
     */
    public void setProjectSiteProvince(String projectSiteProvince) {
        this.projectSiteProvince = projectSiteProvince == null ? null : projectSiteProvince.trim();
    }

    /**
     * @return 工程地点
     */
    public String getProjectSite() {
        return projectSite;
    }

    /**
     * @param projectSite 
	 *            工程地点
     */
    public void setProjectSite(String projectSite) {
        this.projectSite = projectSite == null ? null : projectSite.trim();
    }

    /**
     * @return 工程规模及特征
     */
    public String getProjectScale() {
        return projectScale;
    }

    /**
     * @param projectScale 
	 *            工程规模及特征
     */
    public void setProjectScale(String projectScale) {
        this.projectScale = projectScale == null ? null : projectScale.trim();
    }

    /**
     * @return 承包方式
     */
    public String getContractType() {
        return contractType;
    }

    /**
     * @param contractType 
	 *            承包方式
     */
    public void setContractType(String contractType) {
        this.contractType = contractType == null ? null : contractType.trim();
    }

    /**
     * @return 采用币种,CNY人民币,USD美元
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency 
	 *            采用币种,CNY人民币,USD美元
     */
    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    /**
     * @return 标准工期,单位是日历天
     */
    public Integer getProjectExpectPeriod() {
        return projectExpectPeriod;
    }

    /**
     * @param projectExpectPeriod 
	 *            标准工期,单位是日历天
     */
    public void setProjectExpectPeriod(Integer projectExpectPeriod) {
        this.projectExpectPeriod = projectExpectPeriod;
    }

    /**
     * @return 中标通知书附件
     */
    public String getLetterOfAcceptanceUrl() {
        return letterOfAcceptanceUrl;
    }

    /**
     * @param letterOfAcceptanceUrl 
	 *            中标通知书附件
     */
    public void setLetterOfAcceptanceUrl(String letterOfAcceptanceUrl) {
        this.letterOfAcceptanceUrl = letterOfAcceptanceUrl == null ? null : letterOfAcceptanceUrl.trim();
    }

    /**
     * @return 工程施工证明类型,转包,建设单位
     */
    public String getConstructionProveType() {
        return constructionProveType;
    }

    /**
     * @param constructionProveType 
	 *            工程施工证明类型,转包,建设单位
     */
    public void setConstructionProveType(String constructionProveType) {
        this.constructionProveType = constructionProveType == null ? null : constructionProveType.trim();
    }

    /**
     * @return 工程最晚工期,计划施工总工期不超过xxx日历天
     */
    public Integer getProjectPeriodDeadline() {
        return projectPeriodDeadline;
    }

    /**
     * @param projectPeriodDeadline 
	 *            工程最晚工期,计划施工总工期不超过xxx日历天
     */
    public void setProjectPeriodDeadline(Integer projectPeriodDeadline) {
        this.projectPeriodDeadline = projectPeriodDeadline;
    }

    /**
     * @return 国有土地使用证有效期
     */
    public Date getLandUseCertificateEnddate() {
        return landUseCertificateEnddate;
    }

    /**
     * @param landUseCertificateEnddate 
	 *            国有土地使用证有效期
     */
    public void setLandUseCertificateEnddate(Date landUseCertificateEnddate) {
        this.landUseCertificateEnddate = landUseCertificateEnddate;
    }

    /**
     * @return 建设用地规划许可证有效期
     */
    public Date getConstructionLandUsePermitEnddate() {
        return constructionLandUsePermitEnddate;
    }

    /**
     * @param constructionLandUsePermitEnddate 
	 *            建设用地规划许可证有效期
     */
    public void setConstructionLandUsePermitEnddate(Date constructionLandUsePermitEnddate) {
        this.constructionLandUsePermitEnddate = constructionLandUsePermitEnddate;
    }

    /**
     * @return 建设工程规划许可证有效期
     */
    public Date getBuildingPermitEnddate() {
        return buildingPermitEnddate;
    }

    /**
     * @param buildingPermitEnddate 
	 *            建设工程规划许可证有效期
     */
    public void setBuildingPermitEnddate(Date buildingPermitEnddate) {
        this.buildingPermitEnddate = buildingPermitEnddate;
    }

    /**
     * @return 国有土地使用证编号
     */
    public String getLandUseCertificateNo() {
        return landUseCertificateNo;
    }

    /**
     * @param landUseCertificateNo 
	 *            国有土地使用证编号
     */
    public void setLandUseCertificateNo(String landUseCertificateNo) {
        this.landUseCertificateNo = landUseCertificateNo == null ? null : landUseCertificateNo.trim();
    }

    /**
     * @return 建设用地规划许可证编号
     */
    public String getConstructionLandUsePermitNo() {
        return constructionLandUsePermitNo;
    }

    /**
     * @param constructionLandUsePermitNo 
	 *            建设用地规划许可证编号
     */
    public void setConstructionLandUsePermitNo(String constructionLandUsePermitNo) {
        this.constructionLandUsePermitNo = constructionLandUsePermitNo == null ? null : constructionLandUsePermitNo.trim();
    }

    /**
     * @return 建设工程规划许可证编号
     */
    public String getBuildingPermitNo() {
        return buildingPermitNo;
    }

    /**
     * @param buildingPermitNo 
	 *            建设工程规划许可证编号
     */
    public void setBuildingPermitNo(String buildingPermitNo) {
        this.buildingPermitNo = buildingPermitNo == null ? null : buildingPermitNo.trim();
    }

    /**
     * @return 建设工程施工许可证编号
     */
    public String getBuildingConstructionPermitNo() {
        return buildingConstructionPermitNo;
    }

    /**
     * @param buildingConstructionPermitNo 
	 *            建设工程施工许可证编号
     */
    public void setBuildingConstructionPermitNo(String buildingConstructionPermitNo) {
        this.buildingConstructionPermitNo = buildingConstructionPermitNo == null ? null : buildingConstructionPermitNo.trim();
    }

    /**
     * @return 建设工程施工许可证附件
     */
    public String getBuildingConstructionPermitUrl() {
        return buildingConstructionPermitUrl;
    }

    /**
     * @param buildingConstructionPermitUrl 
	 *            建设工程施工许可证附件
     */
    public void setBuildingConstructionPermitUrl(String buildingConstructionPermitUrl) {
        this.buildingConstructionPermitUrl = buildingConstructionPermitUrl == null ? null : buildingConstructionPermitUrl.trim();
    }

    /**
     * @return 建设工程施工许可证有效期
     */
    public Date getBuildingConstructionPermitEnddate() {
        return buildingConstructionPermitEnddate;
    }

    /**
     * @param buildingConstructionPermitEnddate 
	 *            建设工程施工许可证有效期
     */
    public void setBuildingConstructionPermitEnddate(Date buildingConstructionPermitEnddate) {
        this.buildingConstructionPermitEnddate = buildingConstructionPermitEnddate;
    }

    /**
     * @return 国有土地使用证附件
     */
    public String getLandUseCertificateUrl() {
        return landUseCertificateUrl;
    }

    /**
     * @param landUseCertificateUrl 
	 *            国有土地使用证附件
     */
    public void setLandUseCertificateUrl(String landUseCertificateUrl) {
        this.landUseCertificateUrl = landUseCertificateUrl == null ? null : landUseCertificateUrl.trim();
    }

    /**
     * @return 建设用地规划许可证附件
     */
    public String getConstructionLandUsePermitUrl() {
        return constructionLandUsePermitUrl;
    }

    /**
     * @param constructionLandUsePermitUrl 
	 *            建设用地规划许可证附件
     */
    public void setConstructionLandUsePermitUrl(String constructionLandUsePermitUrl) {
        this.constructionLandUsePermitUrl = constructionLandUsePermitUrl == null ? null : constructionLandUsePermitUrl.trim();
    }

    /**
     * @return 建设工程规划许可证附件
     */
    public String getBuildingPermitUrl() {
        return buildingPermitUrl;
    }

    /**
     * @param buildingPermitUrl 
	 *            建设工程规划许可证附件
     */
    public void setBuildingPermitUrl(String buildingPermitUrl) {
        this.buildingPermitUrl = buildingPermitUrl == null ? null : buildingPermitUrl.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BidProjectInfo other = (BidProjectInfo) that;
        return (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getEvaluationAmount() == null ? other.getEvaluationAmount() == null : this.getEvaluationAmount().equals(other.getEvaluationAmount()))
            && (this.getProjectExpectStartDate() == null ? other.getProjectExpectStartDate() == null : this.getProjectExpectStartDate().equals(other.getProjectExpectStartDate()))
            && (this.getProjectExpectEndDate() == null ? other.getProjectExpectEndDate() == null : this.getProjectExpectEndDate().equals(other.getProjectExpectEndDate()))
            && (this.getBiddeeCompanyPrincipal() == null ? other.getBiddeeCompanyPrincipal() == null : this.getBiddeeCompanyPrincipal().equals(other.getBiddeeCompanyPrincipal()))
            && (this.getBiddeeCompanyTelephone() == null ? other.getBiddeeCompanyTelephone() == null : this.getBiddeeCompanyTelephone().equals(other.getBiddeeCompanyTelephone()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectNo() == null ? other.getProjectNo() == null : this.getProjectNo().equals(other.getProjectNo()))
            && (this.getProjectSituation() == null ? other.getProjectSituation() == null : this.getProjectSituation().equals(other.getProjectSituation()))
            && (this.getProjectExpectInvestment() == null ? other.getProjectExpectInvestment() == null : this.getProjectExpectInvestment().equals(other.getProjectExpectInvestment()))
            && (this.getEmployer() == null ? other.getEmployer() == null : this.getEmployer().equals(other.getEmployer()))
            && (this.getEmployerPrincipal() == null ? other.getEmployerPrincipal() == null : this.getEmployerPrincipal().equals(other.getEmployerPrincipal()))
            && (this.getEmployerTelephone() == null ? other.getEmployerTelephone() == null : this.getEmployerTelephone().equals(other.getEmployerTelephone()))
            && (this.getProjectManagerRequirement() == null ? other.getProjectManagerRequirement() == null : this.getProjectManagerRequirement().equals(other.getProjectManagerRequirement()))
            && (this.getOtherRequirement() == null ? other.getOtherRequirement() == null : this.getOtherRequirement().equals(other.getOtherRequirement()))
            && (this.getProjectSiteTown() == null ? other.getProjectSiteTown() == null : this.getProjectSiteTown().equals(other.getProjectSiteTown()))
            && (this.getProjectSiteCity() == null ? other.getProjectSiteCity() == null : this.getProjectSiteCity().equals(other.getProjectSiteCity()))
            && (this.getProjectSiteProvince() == null ? other.getProjectSiteProvince() == null : this.getProjectSiteProvince().equals(other.getProjectSiteProvince()))
            && (this.getProjectSite() == null ? other.getProjectSite() == null : this.getProjectSite().equals(other.getProjectSite()))
            && (this.getProjectScale() == null ? other.getProjectScale() == null : this.getProjectScale().equals(other.getProjectScale()))
            && (this.getContractType() == null ? other.getContractType() == null : this.getContractType().equals(other.getContractType()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getProjectExpectPeriod() == null ? other.getProjectExpectPeriod() == null : this.getProjectExpectPeriod().equals(other.getProjectExpectPeriod()))
            && (this.getLetterOfAcceptanceUrl() == null ? other.getLetterOfAcceptanceUrl() == null : this.getLetterOfAcceptanceUrl().equals(other.getLetterOfAcceptanceUrl()))
            && (this.getConstructionProveType() == null ? other.getConstructionProveType() == null : this.getConstructionProveType().equals(other.getConstructionProveType()))
            && (this.getProjectPeriodDeadline() == null ? other.getProjectPeriodDeadline() == null : this.getProjectPeriodDeadline().equals(other.getProjectPeriodDeadline()))
            && (this.getLandUseCertificateEnddate() == null ? other.getLandUseCertificateEnddate() == null : this.getLandUseCertificateEnddate().equals(other.getLandUseCertificateEnddate()))
            && (this.getConstructionLandUsePermitEnddate() == null ? other.getConstructionLandUsePermitEnddate() == null : this.getConstructionLandUsePermitEnddate().equals(other.getConstructionLandUsePermitEnddate()))
            && (this.getBuildingPermitEnddate() == null ? other.getBuildingPermitEnddate() == null : this.getBuildingPermitEnddate().equals(other.getBuildingPermitEnddate()))
            && (this.getLandUseCertificateNo() == null ? other.getLandUseCertificateNo() == null : this.getLandUseCertificateNo().equals(other.getLandUseCertificateNo()))
            && (this.getConstructionLandUsePermitNo() == null ? other.getConstructionLandUsePermitNo() == null : this.getConstructionLandUsePermitNo().equals(other.getConstructionLandUsePermitNo()))
            && (this.getBuildingPermitNo() == null ? other.getBuildingPermitNo() == null : this.getBuildingPermitNo().equals(other.getBuildingPermitNo()))
            && (this.getBuildingConstructionPermitNo() == null ? other.getBuildingConstructionPermitNo() == null : this.getBuildingConstructionPermitNo().equals(other.getBuildingConstructionPermitNo()))
            && (this.getBuildingConstructionPermitUrl() == null ? other.getBuildingConstructionPermitUrl() == null : this.getBuildingConstructionPermitUrl().equals(other.getBuildingConstructionPermitUrl()))
            && (this.getBuildingConstructionPermitEnddate() == null ? other.getBuildingConstructionPermitEnddate() == null : this.getBuildingConstructionPermitEnddate().equals(other.getBuildingConstructionPermitEnddate()))
            && (this.getLandUseCertificateUrl() == null ? other.getLandUseCertificateUrl() == null : this.getLandUseCertificateUrl().equals(other.getLandUseCertificateUrl()))
            && (this.getConstructionLandUsePermitUrl() == null ? other.getConstructionLandUsePermitUrl() == null : this.getConstructionLandUsePermitUrl().equals(other.getConstructionLandUsePermitUrl()))
            && (this.getBuildingPermitUrl() == null ? other.getBuildingPermitUrl() == null : this.getBuildingPermitUrl().equals(other.getBuildingPermitUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getEvaluationAmount() == null) ? 0 : getEvaluationAmount().hashCode());
        result = prime * result + ((getProjectExpectStartDate() == null) ? 0 : getProjectExpectStartDate().hashCode());
        result = prime * result + ((getProjectExpectEndDate() == null) ? 0 : getProjectExpectEndDate().hashCode());
        result = prime * result + ((getBiddeeCompanyPrincipal() == null) ? 0 : getBiddeeCompanyPrincipal().hashCode());
        result = prime * result + ((getBiddeeCompanyTelephone() == null) ? 0 : getBiddeeCompanyTelephone().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectNo() == null) ? 0 : getProjectNo().hashCode());
        result = prime * result + ((getProjectSituation() == null) ? 0 : getProjectSituation().hashCode());
        result = prime * result + ((getProjectExpectInvestment() == null) ? 0 : getProjectExpectInvestment().hashCode());
        result = prime * result + ((getEmployer() == null) ? 0 : getEmployer().hashCode());
        result = prime * result + ((getEmployerPrincipal() == null) ? 0 : getEmployerPrincipal().hashCode());
        result = prime * result + ((getEmployerTelephone() == null) ? 0 : getEmployerTelephone().hashCode());
        result = prime * result + ((getProjectManagerRequirement() == null) ? 0 : getProjectManagerRequirement().hashCode());
        result = prime * result + ((getOtherRequirement() == null) ? 0 : getOtherRequirement().hashCode());
        result = prime * result + ((getProjectSiteTown() == null) ? 0 : getProjectSiteTown().hashCode());
        result = prime * result + ((getProjectSiteCity() == null) ? 0 : getProjectSiteCity().hashCode());
        result = prime * result + ((getProjectSiteProvince() == null) ? 0 : getProjectSiteProvince().hashCode());
        result = prime * result + ((getProjectSite() == null) ? 0 : getProjectSite().hashCode());
        result = prime * result + ((getProjectScale() == null) ? 0 : getProjectScale().hashCode());
        result = prime * result + ((getContractType() == null) ? 0 : getContractType().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getProjectExpectPeriod() == null) ? 0 : getProjectExpectPeriod().hashCode());
        result = prime * result + ((getLetterOfAcceptanceUrl() == null) ? 0 : getLetterOfAcceptanceUrl().hashCode());
        result = prime * result + ((getConstructionProveType() == null) ? 0 : getConstructionProveType().hashCode());
        result = prime * result + ((getProjectPeriodDeadline() == null) ? 0 : getProjectPeriodDeadline().hashCode());
        result = prime * result + ((getLandUseCertificateEnddate() == null) ? 0 : getLandUseCertificateEnddate().hashCode());
        result = prime * result + ((getConstructionLandUsePermitEnddate() == null) ? 0 : getConstructionLandUsePermitEnddate().hashCode());
        result = prime * result + ((getBuildingPermitEnddate() == null) ? 0 : getBuildingPermitEnddate().hashCode());
        result = prime * result + ((getLandUseCertificateNo() == null) ? 0 : getLandUseCertificateNo().hashCode());
        result = prime * result + ((getConstructionLandUsePermitNo() == null) ? 0 : getConstructionLandUsePermitNo().hashCode());
        result = prime * result + ((getBuildingPermitNo() == null) ? 0 : getBuildingPermitNo().hashCode());
        result = prime * result + ((getBuildingConstructionPermitNo() == null) ? 0 : getBuildingConstructionPermitNo().hashCode());
        result = prime * result + ((getBuildingConstructionPermitUrl() == null) ? 0 : getBuildingConstructionPermitUrl().hashCode());
        result = prime * result + ((getBuildingConstructionPermitEnddate() == null) ? 0 : getBuildingConstructionPermitEnddate().hashCode());
        result = prime * result + ((getLandUseCertificateUrl() == null) ? 0 : getLandUseCertificateUrl().hashCode());
        result = prime * result + ((getConstructionLandUsePermitUrl() == null) ? 0 : getConstructionLandUsePermitUrl().hashCode());
        result = prime * result + ((getBuildingPermitUrl() == null) ? 0 : getBuildingPermitUrl().hashCode());
        return result;
    }
}