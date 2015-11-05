package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的工程信息表
 */
public class BidProjectInfo {
    /**
     * 标的id
     */
    private String object_id;

    /**
     * 工程标的估价
     */
    private Integer evaluation_amount;

    /**
     * 工程预计开始时间
     */
    private String project_expect_start_date;

    /**
     * 工程预计结束时间
     */
    private String project_expect_end_date;

    /**
     * 招标方经办人
     */
    private String biddee_company_principal;

    /**
     * 招标方办公电话
     */
    private String biddee_company_telephone;

    /**
     * 工程名称
     */
    private String project_name;

    /**
     * 工程编号
     */
    private String project_no;

    /**
     * 工程项目概况
     */
    private String project_situation;

    /**
     * 工程计划总投资
     */
    private String project_expect_investment;

    /**
     * 建设单位
     */
    private String employer;

    /**
     * 建设单位经办人
     */
    private String employer_principal;

    /**
     * 建设单位办公电话
     */
    private String employer_telephone;

    /**
     * 项目负责人要求
     */
    private String project_manager_requirement;

    /**
     * 其它要求
     */
    private String other_requirement;

    /**
     * 工程地点所在镇区，使用区域表id
     */
    private String project_site_town;

    /**
     * 工程地点所在城市，使用区域表id
     */
    private String project_site_city;

    /**
     * 工程地点所在省份，使用区域表id
     */
    private String project_site_province;

    /**
     * 工程地点
     */
    private String project_site;

    /**
     * 工程规模及特征
     */
    private String project_scale;

    /**
     * 承包方式
     */
    private String contract_type;

    /**
     * 采用币种,CNY人民币,USD美元
     */
    private String currency;

    /**
     * 标准工期,单位是日历天
     */
    private Integer project_expect_period;

    /**
     * 中标通知书附件
     */
    private String letter_of_acceptance_url;

    /**
     * 工程施工证明类型,转包,建设单位
     */
    private String construction_prove_type;

    /**
     * 工程最晚工期,计划施工总工期不超过xxx日历天
     */
    private Integer project_period_deadline;

    /**
     * 国有土地使用证有效期
     */
    private Date land_use_certificate_enddate;

    /**
     * 建设用地规划许可证有效期
     */
    private Date construction_land_use_permit_enddate;

    /**
     * 建设工程规划许可证有效期
     */
    private Date building_permit_enddate;

    /**
     * 国有土地使用证编号
     */
    private String land_use_certificate_No;

    /**
     * 建设用地规划许可证编号
     */
    private String construction_land_use_permit_No;

    /**
     * 建设工程规划许可证编号
     */
    private String building_permit_No;

    /**
     * 建设工程施工许可证编号
     */
    private String building_construction_permit_No;

    /**
     * 建设工程施工许可证附件
     */
    private String building_construction_permit_url;

    /**
     * 建设工程施工许可证有效期
     */
    private Date building_construction_permit_enddate;

    /**
     * 国有土地使用证附件
     */
    private String land_use_certificate_url;

    /**
     * 建设用地规划许可证附件
     */
    private String construction_land_use_permit_url;

    /**
     * 建设工程规划许可证附件
     */
    private String building_permit_url;

    /**
     * @return 标的id
     */
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id == null ? null : object_id.trim();
    }

    /**
     * @return 工程标的估价
     */
    public Integer getEvaluation_amount() {
        return evaluation_amount;
    }

    /**
     * @param evaluationAmount 
	 *            工程标的估价
     */
    public void setEvaluation_amount(Integer evaluation_amount) {
        this.evaluation_amount = evaluation_amount;
    }

    /**
     * @return 工程预计开始时间
     */
    public String getProject_expect_start_date() {
        return project_expect_start_date;
    }

    /**
     * @param projectExpectStartDate 
	 *            工程预计开始时间
     */
    public void setProject_expect_start_date(String project_expect_start_date) {
        this.project_expect_start_date = project_expect_start_date == null ? null : project_expect_start_date.trim();
    }

    /**
     * @return 工程预计结束时间
     */
    public String getProject_expect_end_date() {
        return project_expect_end_date;
    }

    /**
     * @param projectExpectEndDate 
	 *            工程预计结束时间
     */
    public void setProject_expect_end_date(String project_expect_end_date) {
        this.project_expect_end_date = project_expect_end_date == null ? null : project_expect_end_date.trim();
    }

    /**
     * @return 招标方经办人
     */
    public String getBiddee_company_principal() {
        return biddee_company_principal;
    }

    /**
     * @param biddeeCompanyPrincipal 
	 *            招标方经办人
     */
    public void setBiddee_company_principal(String biddee_company_principal) {
        this.biddee_company_principal = biddee_company_principal == null ? null : biddee_company_principal.trim();
    }

    /**
     * @return 招标方办公电话
     */
    public String getBiddee_company_telephone() {
        return biddee_company_telephone;
    }

    /**
     * @param biddeeCompanyTelephone 
	 *            招标方办公电话
     */
    public void setBiddee_company_telephone(String biddee_company_telephone) {
        this.biddee_company_telephone = biddee_company_telephone == null ? null : biddee_company_telephone.trim();
    }

    /**
     * @return 工程名称
     */
    public String getProject_name() {
        return project_name;
    }

    /**
     * @param projectName 
	 *            工程名称
     */
    public void setProject_name(String project_name) {
        this.project_name = project_name == null ? null : project_name.trim();
    }

    /**
     * @return 工程编号
     */
    public String getProject_no() {
        return project_no;
    }

    /**
     * @param projectNo 
	 *            工程编号
     */
    public void setProject_no(String project_no) {
        this.project_no = project_no == null ? null : project_no.trim();
    }

    /**
     * @return 工程项目概况
     */
    public String getProject_situation() {
        return project_situation;
    }

    /**
     * @param projectSituation 
	 *            工程项目概况
     */
    public void setProject_situation(String project_situation) {
        this.project_situation = project_situation == null ? null : project_situation.trim();
    }

    /**
     * @return 工程计划总投资
     */
    public String getProject_expect_investment() {
        return project_expect_investment;
    }

    /**
     * @param projectExpectInvestment 
	 *            工程计划总投资
     */
    public void setProject_expect_investment(String project_expect_investment) {
        this.project_expect_investment = project_expect_investment == null ? null : project_expect_investment.trim();
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
    public String getEmployer_principal() {
        return employer_principal;
    }

    /**
     * @param employerPrincipal 
	 *            建设单位经办人
     */
    public void setEmployer_principal(String employer_principal) {
        this.employer_principal = employer_principal == null ? null : employer_principal.trim();
    }

    /**
     * @return 建设单位办公电话
     */
    public String getEmployer_telephone() {
        return employer_telephone;
    }

    /**
     * @param employerTelephone 
	 *            建设单位办公电话
     */
    public void setEmployer_telephone(String employer_telephone) {
        this.employer_telephone = employer_telephone == null ? null : employer_telephone.trim();
    }

    /**
     * @return 项目负责人要求
     */
    public String getProject_manager_requirement() {
        return project_manager_requirement;
    }

    /**
     * @param projectManagerRequirement 
	 *            项目负责人要求
     */
    public void setProject_manager_requirement(String project_manager_requirement) {
        this.project_manager_requirement = project_manager_requirement == null ? null : project_manager_requirement.trim();
    }

    /**
     * @return 其它要求
     */
    public String getOther_requirement() {
        return other_requirement;
    }

    /**
     * @param otherRequirement 
	 *            其它要求
     */
    public void setOther_requirement(String other_requirement) {
        this.other_requirement = other_requirement == null ? null : other_requirement.trim();
    }

    /**
     * @return 工程地点所在镇区，使用区域表id
     */
    public String getProject_site_town() {
        return project_site_town;
    }

    /**
     * @param projectSiteTown 
	 *            工程地点所在镇区，使用区域表id
     */
    public void setProject_site_town(String project_site_town) {
        this.project_site_town = project_site_town == null ? null : project_site_town.trim();
    }

    /**
     * @return 工程地点所在城市，使用区域表id
     */
    public String getProject_site_city() {
        return project_site_city;
    }

    /**
     * @param projectSiteCity 
	 *            工程地点所在城市，使用区域表id
     */
    public void setProject_site_city(String project_site_city) {
        this.project_site_city = project_site_city == null ? null : project_site_city.trim();
    }

    /**
     * @return 工程地点所在省份，使用区域表id
     */
    public String getProject_site_province() {
        return project_site_province;
    }

    /**
     * @param projectSiteProvince 
	 *            工程地点所在省份，使用区域表id
     */
    public void setProject_site_province(String project_site_province) {
        this.project_site_province = project_site_province == null ? null : project_site_province.trim();
    }

    /**
     * @return 工程地点
     */
    public String getProject_site() {
        return project_site;
    }

    /**
     * @param projectSite 
	 *            工程地点
     */
    public void setProject_site(String project_site) {
        this.project_site = project_site == null ? null : project_site.trim();
    }

    /**
     * @return 工程规模及特征
     */
    public String getProject_scale() {
        return project_scale;
    }

    /**
     * @param projectScale 
	 *            工程规模及特征
     */
    public void setProject_scale(String project_scale) {
        this.project_scale = project_scale == null ? null : project_scale.trim();
    }

    /**
     * @return 承包方式
     */
    public String getContract_type() {
        return contract_type;
    }

    /**
     * @param contractType 
	 *            承包方式
     */
    public void setContract_type(String contract_type) {
        this.contract_type = contract_type == null ? null : contract_type.trim();
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
    public Integer getProject_expect_period() {
        return project_expect_period;
    }

    /**
     * @param projectExpectPeriod 
	 *            标准工期,单位是日历天
     */
    public void setProject_expect_period(Integer project_expect_period) {
        this.project_expect_period = project_expect_period;
    }

    /**
     * @return 中标通知书附件
     */
    public String getLetter_of_acceptance_url() {
        return letter_of_acceptance_url;
    }

    /**
     * @param letterOfAcceptanceUrl 
	 *            中标通知书附件
     */
    public void setLetter_of_acceptance_url(String letter_of_acceptance_url) {
        this.letter_of_acceptance_url = letter_of_acceptance_url == null ? null : letter_of_acceptance_url.trim();
    }

    /**
     * @return 工程施工证明类型,转包,建设单位
     */
    public String getConstruction_prove_type() {
        return construction_prove_type;
    }

    /**
     * @param constructionProveType 
	 *            工程施工证明类型,转包,建设单位
     */
    public void setConstruction_prove_type(String construction_prove_type) {
        this.construction_prove_type = construction_prove_type == null ? null : construction_prove_type.trim();
    }

    /**
     * @return 工程最晚工期,计划施工总工期不超过xxx日历天
     */
    public Integer getProject_period_deadline() {
        return project_period_deadline;
    }

    /**
     * @param projectPeriodDeadline 
	 *            工程最晚工期,计划施工总工期不超过xxx日历天
     */
    public void setProject_period_deadline(Integer project_period_deadline) {
        this.project_period_deadline = project_period_deadline;
    }

    /**
     * @return 国有土地使用证有效期
     */
    public Date getLand_use_certificate_enddate() {
        return land_use_certificate_enddate;
    }

    /**
     * @param landUseCertificateEnddate 
	 *            国有土地使用证有效期
     */
    public void setLand_use_certificate_enddate(Date land_use_certificate_enddate) {
        this.land_use_certificate_enddate = land_use_certificate_enddate;
    }

    /**
     * @return 建设用地规划许可证有效期
     */
    public Date getConstruction_land_use_permit_enddate() {
        return construction_land_use_permit_enddate;
    }

    /**
     * @param constructionLandUsePermitEnddate 
	 *            建设用地规划许可证有效期
     */
    public void setConstruction_land_use_permit_enddate(Date construction_land_use_permit_enddate) {
        this.construction_land_use_permit_enddate = construction_land_use_permit_enddate;
    }

    /**
     * @return 建设工程规划许可证有效期
     */
    public Date getBuilding_permit_enddate() {
        return building_permit_enddate;
    }

    /**
     * @param buildingPermitEnddate 
	 *            建设工程规划许可证有效期
     */
    public void setBuilding_permit_enddate(Date building_permit_enddate) {
        this.building_permit_enddate = building_permit_enddate;
    }

    /**
     * @return 国有土地使用证编号
     */
    public String getLand_use_certificate_No() {
        return land_use_certificate_No;
    }

    /**
     * @param landUseCertificateNo 
	 *            国有土地使用证编号
     */
    public void setLand_use_certificate_No(String land_use_certificate_No) {
        this.land_use_certificate_No = land_use_certificate_No == null ? null : land_use_certificate_No.trim();
    }

    /**
     * @return 建设用地规划许可证编号
     */
    public String getConstruction_land_use_permit_No() {
        return construction_land_use_permit_No;
    }

    /**
     * @param constructionLandUsePermitNo 
	 *            建设用地规划许可证编号
     */
    public void setConstruction_land_use_permit_No(String construction_land_use_permit_No) {
        this.construction_land_use_permit_No = construction_land_use_permit_No == null ? null : construction_land_use_permit_No.trim();
    }

    /**
     * @return 建设工程规划许可证编号
     */
    public String getBuilding_permit_No() {
        return building_permit_No;
    }

    /**
     * @param buildingPermitNo 
	 *            建设工程规划许可证编号
     */
    public void setBuilding_permit_No(String building_permit_No) {
        this.building_permit_No = building_permit_No == null ? null : building_permit_No.trim();
    }

    /**
     * @return 建设工程施工许可证编号
     */
    public String getBuilding_construction_permit_No() {
        return building_construction_permit_No;
    }

    /**
     * @param buildingConstructionPermitNo 
	 *            建设工程施工许可证编号
     */
    public void setBuilding_construction_permit_No(String building_construction_permit_No) {
        this.building_construction_permit_No = building_construction_permit_No == null ? null : building_construction_permit_No.trim();
    }

    /**
     * @return 建设工程施工许可证附件
     */
    public String getBuilding_construction_permit_url() {
        return building_construction_permit_url;
    }

    /**
     * @param buildingConstructionPermitUrl 
	 *            建设工程施工许可证附件
     */
    public void setBuilding_construction_permit_url(String building_construction_permit_url) {
        this.building_construction_permit_url = building_construction_permit_url == null ? null : building_construction_permit_url.trim();
    }

    /**
     * @return 建设工程施工许可证有效期
     */
    public Date getBuilding_construction_permit_enddate() {
        return building_construction_permit_enddate;
    }

    /**
     * @param buildingConstructionPermitEnddate 
	 *            建设工程施工许可证有效期
     */
    public void setBuilding_construction_permit_enddate(Date building_construction_permit_enddate) {
        this.building_construction_permit_enddate = building_construction_permit_enddate;
    }

    /**
     * @return 国有土地使用证附件
     */
    public String getLand_use_certificate_url() {
        return land_use_certificate_url;
    }

    /**
     * @param landUseCertificateUrl 
	 *            国有土地使用证附件
     */
    public void setLand_use_certificate_url(String land_use_certificate_url) {
        this.land_use_certificate_url = land_use_certificate_url == null ? null : land_use_certificate_url.trim();
    }

    /**
     * @return 建设用地规划许可证附件
     */
    public String getConstruction_land_use_permit_url() {
        return construction_land_use_permit_url;
    }

    /**
     * @param constructionLandUsePermitUrl 
	 *            建设用地规划许可证附件
     */
    public void setConstruction_land_use_permit_url(String construction_land_use_permit_url) {
        this.construction_land_use_permit_url = construction_land_use_permit_url == null ? null : construction_land_use_permit_url.trim();
    }

    /**
     * @return 建设工程规划许可证附件
     */
    public String getBuilding_permit_url() {
        return building_permit_url;
    }

    /**
     * @param buildingPermitUrl 
	 *            建设工程规划许可证附件
     */
    public void setBuilding_permit_url(String building_permit_url) {
        this.building_permit_url = building_permit_url == null ? null : building_permit_url.trim();
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
        return (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getEvaluation_amount() == null ? other.getEvaluation_amount() == null : this.getEvaluation_amount().equals(other.getEvaluation_amount()))
            && (this.getProject_expect_start_date() == null ? other.getProject_expect_start_date() == null : this.getProject_expect_start_date().equals(other.getProject_expect_start_date()))
            && (this.getProject_expect_end_date() == null ? other.getProject_expect_end_date() == null : this.getProject_expect_end_date().equals(other.getProject_expect_end_date()))
            && (this.getBiddee_company_principal() == null ? other.getBiddee_company_principal() == null : this.getBiddee_company_principal().equals(other.getBiddee_company_principal()))
            && (this.getBiddee_company_telephone() == null ? other.getBiddee_company_telephone() == null : this.getBiddee_company_telephone().equals(other.getBiddee_company_telephone()))
            && (this.getProject_name() == null ? other.getProject_name() == null : this.getProject_name().equals(other.getProject_name()))
            && (this.getProject_no() == null ? other.getProject_no() == null : this.getProject_no().equals(other.getProject_no()))
            && (this.getProject_situation() == null ? other.getProject_situation() == null : this.getProject_situation().equals(other.getProject_situation()))
            && (this.getProject_expect_investment() == null ? other.getProject_expect_investment() == null : this.getProject_expect_investment().equals(other.getProject_expect_investment()))
            && (this.getEmployer() == null ? other.getEmployer() == null : this.getEmployer().equals(other.getEmployer()))
            && (this.getEmployer_principal() == null ? other.getEmployer_principal() == null : this.getEmployer_principal().equals(other.getEmployer_principal()))
            && (this.getEmployer_telephone() == null ? other.getEmployer_telephone() == null : this.getEmployer_telephone().equals(other.getEmployer_telephone()))
            && (this.getProject_manager_requirement() == null ? other.getProject_manager_requirement() == null : this.getProject_manager_requirement().equals(other.getProject_manager_requirement()))
            && (this.getOther_requirement() == null ? other.getOther_requirement() == null : this.getOther_requirement().equals(other.getOther_requirement()))
            && (this.getProject_site_town() == null ? other.getProject_site_town() == null : this.getProject_site_town().equals(other.getProject_site_town()))
            && (this.getProject_site_city() == null ? other.getProject_site_city() == null : this.getProject_site_city().equals(other.getProject_site_city()))
            && (this.getProject_site_province() == null ? other.getProject_site_province() == null : this.getProject_site_province().equals(other.getProject_site_province()))
            && (this.getProject_site() == null ? other.getProject_site() == null : this.getProject_site().equals(other.getProject_site()))
            && (this.getProject_scale() == null ? other.getProject_scale() == null : this.getProject_scale().equals(other.getProject_scale()))
            && (this.getContract_type() == null ? other.getContract_type() == null : this.getContract_type().equals(other.getContract_type()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getProject_expect_period() == null ? other.getProject_expect_period() == null : this.getProject_expect_period().equals(other.getProject_expect_period()))
            && (this.getLetter_of_acceptance_url() == null ? other.getLetter_of_acceptance_url() == null : this.getLetter_of_acceptance_url().equals(other.getLetter_of_acceptance_url()))
            && (this.getConstruction_prove_type() == null ? other.getConstruction_prove_type() == null : this.getConstruction_prove_type().equals(other.getConstruction_prove_type()))
            && (this.getProject_period_deadline() == null ? other.getProject_period_deadline() == null : this.getProject_period_deadline().equals(other.getProject_period_deadline()))
            && (this.getLand_use_certificate_enddate() == null ? other.getLand_use_certificate_enddate() == null : this.getLand_use_certificate_enddate().equals(other.getLand_use_certificate_enddate()))
            && (this.getConstruction_land_use_permit_enddate() == null ? other.getConstruction_land_use_permit_enddate() == null : this.getConstruction_land_use_permit_enddate().equals(other.getConstruction_land_use_permit_enddate()))
            && (this.getBuilding_permit_enddate() == null ? other.getBuilding_permit_enddate() == null : this.getBuilding_permit_enddate().equals(other.getBuilding_permit_enddate()))
            && (this.getLand_use_certificate_No() == null ? other.getLand_use_certificate_No() == null : this.getLand_use_certificate_No().equals(other.getLand_use_certificate_No()))
            && (this.getConstruction_land_use_permit_No() == null ? other.getConstruction_land_use_permit_No() == null : this.getConstruction_land_use_permit_No().equals(other.getConstruction_land_use_permit_No()))
            && (this.getBuilding_permit_No() == null ? other.getBuilding_permit_No() == null : this.getBuilding_permit_No().equals(other.getBuilding_permit_No()))
            && (this.getBuilding_construction_permit_No() == null ? other.getBuilding_construction_permit_No() == null : this.getBuilding_construction_permit_No().equals(other.getBuilding_construction_permit_No()))
            && (this.getBuilding_construction_permit_url() == null ? other.getBuilding_construction_permit_url() == null : this.getBuilding_construction_permit_url().equals(other.getBuilding_construction_permit_url()))
            && (this.getBuilding_construction_permit_enddate() == null ? other.getBuilding_construction_permit_enddate() == null : this.getBuilding_construction_permit_enddate().equals(other.getBuilding_construction_permit_enddate()))
            && (this.getLand_use_certificate_url() == null ? other.getLand_use_certificate_url() == null : this.getLand_use_certificate_url().equals(other.getLand_use_certificate_url()))
            && (this.getConstruction_land_use_permit_url() == null ? other.getConstruction_land_use_permit_url() == null : this.getConstruction_land_use_permit_url().equals(other.getConstruction_land_use_permit_url()))
            && (this.getBuilding_permit_url() == null ? other.getBuilding_permit_url() == null : this.getBuilding_permit_url().equals(other.getBuilding_permit_url()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getEvaluation_amount() == null) ? 0 : getEvaluation_amount().hashCode());
        result = prime * result + ((getProject_expect_start_date() == null) ? 0 : getProject_expect_start_date().hashCode());
        result = prime * result + ((getProject_expect_end_date() == null) ? 0 : getProject_expect_end_date().hashCode());
        result = prime * result + ((getBiddee_company_principal() == null) ? 0 : getBiddee_company_principal().hashCode());
        result = prime * result + ((getBiddee_company_telephone() == null) ? 0 : getBiddee_company_telephone().hashCode());
        result = prime * result + ((getProject_name() == null) ? 0 : getProject_name().hashCode());
        result = prime * result + ((getProject_no() == null) ? 0 : getProject_no().hashCode());
        result = prime * result + ((getProject_situation() == null) ? 0 : getProject_situation().hashCode());
        result = prime * result + ((getProject_expect_investment() == null) ? 0 : getProject_expect_investment().hashCode());
        result = prime * result + ((getEmployer() == null) ? 0 : getEmployer().hashCode());
        result = prime * result + ((getEmployer_principal() == null) ? 0 : getEmployer_principal().hashCode());
        result = prime * result + ((getEmployer_telephone() == null) ? 0 : getEmployer_telephone().hashCode());
        result = prime * result + ((getProject_manager_requirement() == null) ? 0 : getProject_manager_requirement().hashCode());
        result = prime * result + ((getOther_requirement() == null) ? 0 : getOther_requirement().hashCode());
        result = prime * result + ((getProject_site_town() == null) ? 0 : getProject_site_town().hashCode());
        result = prime * result + ((getProject_site_city() == null) ? 0 : getProject_site_city().hashCode());
        result = prime * result + ((getProject_site_province() == null) ? 0 : getProject_site_province().hashCode());
        result = prime * result + ((getProject_site() == null) ? 0 : getProject_site().hashCode());
        result = prime * result + ((getProject_scale() == null) ? 0 : getProject_scale().hashCode());
        result = prime * result + ((getContract_type() == null) ? 0 : getContract_type().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getProject_expect_period() == null) ? 0 : getProject_expect_period().hashCode());
        result = prime * result + ((getLetter_of_acceptance_url() == null) ? 0 : getLetter_of_acceptance_url().hashCode());
        result = prime * result + ((getConstruction_prove_type() == null) ? 0 : getConstruction_prove_type().hashCode());
        result = prime * result + ((getProject_period_deadline() == null) ? 0 : getProject_period_deadline().hashCode());
        result = prime * result + ((getLand_use_certificate_enddate() == null) ? 0 : getLand_use_certificate_enddate().hashCode());
        result = prime * result + ((getConstruction_land_use_permit_enddate() == null) ? 0 : getConstruction_land_use_permit_enddate().hashCode());
        result = prime * result + ((getBuilding_permit_enddate() == null) ? 0 : getBuilding_permit_enddate().hashCode());
        result = prime * result + ((getLand_use_certificate_No() == null) ? 0 : getLand_use_certificate_No().hashCode());
        result = prime * result + ((getConstruction_land_use_permit_No() == null) ? 0 : getConstruction_land_use_permit_No().hashCode());
        result = prime * result + ((getBuilding_permit_No() == null) ? 0 : getBuilding_permit_No().hashCode());
        result = prime * result + ((getBuilding_construction_permit_No() == null) ? 0 : getBuilding_construction_permit_No().hashCode());
        result = prime * result + ((getBuilding_construction_permit_url() == null) ? 0 : getBuilding_construction_permit_url().hashCode());
        result = prime * result + ((getBuilding_construction_permit_enddate() == null) ? 0 : getBuilding_construction_permit_enddate().hashCode());
        result = prime * result + ((getLand_use_certificate_url() == null) ? 0 : getLand_use_certificate_url().hashCode());
        result = prime * result + ((getConstruction_land_use_permit_url() == null) ? 0 : getConstruction_land_use_permit_url().hashCode());
        result = prime * result + ((getBuilding_permit_url() == null) ? 0 : getBuilding_permit_url().hashCode());
        return result;
    }
}