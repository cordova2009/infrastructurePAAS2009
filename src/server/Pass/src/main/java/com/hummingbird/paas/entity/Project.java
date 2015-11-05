package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的工程表
 */
public class Project {
    /**
     * 招标编号(平台)
     */
    private String object_id;

    /**
     * 发包方id
     */
    private Integer biddee_id;

    /**
     * 招标项目编号
     */
    private String object_no;

    /**
     * 招标项目名称
     */
    private String object_name;

    /**
     * 标的金额
     */
    private Integer object_amount;

    /**
     * 标的公开类型,PUB公开招标,INV邀请招标
     */
    private String object_publish_type;

    /**
     * 标的状态,CRT 创建，PUB发布（可投标），REV评标开标，ADA废标，FLS流标，SEL定标，END结束
     */
    private String object_status;

    /**
     * 中标金额
     */
    private String win_bid_amount;

    /**
     * 中标的承包商id
     */
    private Integer win_bidder_id;

    /**
     * 板块分类,来自行业版块表
     */
    private String industry_id;

    /**
     * 板块分类,来自行业版块表
     */
    private String sector_id;

    /**
     * 省份分类,使用区域表id
     */
    private Integer province;

    /**
     * 地区分类，使用区域表id
     */
    private Integer district;

    /**
     * 招标方经办人
     */
    private String biddee_company_principal;

    /**
     * 招标方办公电话
     */
    private String biddee_company_telephone;

    /**
     * 开标时间
     */
    private Date bid_open_date;

    /**
     * 标准工期,单位是日历天
     */
    private Integer project_expect_period;

    /**
     * 资格审查方式,SYS 投标人资质等级系统自动匹配审查,
     */
    private String certification_checkup_type;

    /**
     * 评标方法,QLT 定性，CRE 信用商户评价，OVE综合评估
     */
    private String bid_evaluation_type;

    /**
     * 技术评标地点
     */
    private String bid_evaluation_site;

    /**
     * 中标人确定方式,ORV 直接票决定标，MRV 逐轮票决定标，VDM 票决筹钱定标
     */
    private String bid_winner_determine_way;

    /**
     * 票决方式, SMP 简单铎书法，CPN 对比胜出法
     */
    private String vote_win_way;

    /**
     * 投标担保金额,单位为分
     */
    private Integer bid_bond_amount;

    /**
     * 商务标必须,YES是，NO#否
     */
    private String need_business_standard;

    /**
     * 技术标必须,YES是，NO#否
     */
    private String need_technical_standard;

    /**
     * 资格审查文件必须,YES是，NO#否
     */
    private String need_certification_checkup_file;

    /**
     * 需要投标人项目经理,YES是，NO#否
     */
    private String need_pm_certification;

    /**
     * 需要投标人建造师,YES是，NO#否
     */
    private String need_constructor_certification;

    /**
     * 需要安全生产许可证,YES是，NO#否
     */
    private String need_safety_permit;

    /**
     * 需要项目经理安全生产考核合格证
     */
    private String need_pm_safety_certification;

    /**
     * @return 招标编号(平台)
     */
    public String getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            招标编号(平台)
     */
    public void setObject_id(String object_id) {
        this.object_id = object_id == null ? null : object_id.trim();
    }

    /**
     * @return 发包方id
     */
    public Integer getBiddee_id() {
        return biddee_id;
    }

    /**
     * @param biddeeId 
	 *            发包方id
     */
    public void setBiddee_id(Integer biddee_id) {
        this.biddee_id = biddee_id;
    }

    /**
     * @return 招标项目编号
     */
    public String getObject_no() {
        return object_no;
    }

    /**
     * @param objectNo 
	 *            招标项目编号
     */
    public void setObject_no(String object_no) {
        this.object_no = object_no == null ? null : object_no.trim();
    }

    /**
     * @return 招标项目名称
     */
    public String getObject_name() {
        return object_name;
    }

    /**
     * @param objectName 
	 *            招标项目名称
     */
    public void setObject_name(String object_name) {
        this.object_name = object_name == null ? null : object_name.trim();
    }

    /**
     * @return 标的金额
     */
    public Integer getObject_amount() {
        return object_amount;
    }

    /**
     * @param objectAmount 
	 *            标的金额
     */
    public void setObject_amount(Integer object_amount) {
        this.object_amount = object_amount;
    }

    /**
     * @return 标的公开类型,PUB公开招标,INV邀请招标
     */
    public String getObject_publish_type() {
        return object_publish_type;
    }

    /**
     * @param objectPublishType 
	 *            标的公开类型,PUB公开招标,INV邀请招标
     */
    public void setObject_publish_type(String object_publish_type) {
        this.object_publish_type = object_publish_type == null ? null : object_publish_type.trim();
    }

    /**
     * @return 标的状态,CRT 创建，PUB发布（可投标），REV评标开标，ADA废标，FLS流标，SEL定标，END结束
     */
    public String getObject_status() {
        return object_status;
    }

    /**
     * @param objectStatus 
	 *            标的状态,CRT 创建，PUB发布（可投标），REV评标开标，ADA废标，FLS流标，SEL定标，END结束
     */
    public void setObject_status(String object_status) {
        this.object_status = object_status == null ? null : object_status.trim();
    }

    /**
     * @return 中标金额
     */
    public String getWin_bid_amount() {
        return win_bid_amount;
    }

    /**
     * @param winBidAmount 
	 *            中标金额
     */
    public void setWin_bid_amount(String win_bid_amount) {
        this.win_bid_amount = win_bid_amount == null ? null : win_bid_amount.trim();
    }

    /**
     * @return 中标的承包商id
     */
    public Integer getWin_bidder_id() {
        return win_bidder_id;
    }

    /**
     * @param winBidderId 
	 *            中标的承包商id
     */
    public void setWin_bidder_id(Integer win_bidder_id) {
        this.win_bidder_id = win_bidder_id;
    }

    /**
     * @return 板块分类,来自行业版块表
     */
    public String getIndustry_id() {
        return industry_id;
    }

    /**
     * @param industryId 
	 *            板块分类,来自行业版块表
     */
    public void setIndustry_id(String industry_id) {
        this.industry_id = industry_id == null ? null : industry_id.trim();
    }

    /**
     * @return 板块分类,来自行业版块表
     */
    public String getSector_id() {
        return sector_id;
    }

    /**
     * @param sectorId 
	 *            板块分类,来自行业版块表
     */
    public void setSector_id(String sector_id) {
        this.sector_id = sector_id == null ? null : sector_id.trim();
    }

    /**
     * @return 省份分类,使用区域表id
     */
    public Integer getProvince() {
        return province;
    }

    /**
     * @param province 
	 *            省份分类,使用区域表id
     */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /**
     * @return 地区分类，使用区域表id
     */
    public Integer getDistrict() {
        return district;
    }

    /**
     * @param district 
	 *            地区分类，使用区域表id
     */
    public void setDistrict(Integer district) {
        this.district = district;
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
     * @return 开标时间
     */
    public Date getBid_open_date() {
        return bid_open_date;
    }

    /**
     * @param bidOpenDate 
	 *            开标时间
     */
    public void setBid_open_date(Date bid_open_date) {
        this.bid_open_date = bid_open_date;
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
     * @return 资格审查方式,SYS 投标人资质等级系统自动匹配审查,
     */
    public String getCertification_checkup_type() {
        return certification_checkup_type;
    }

    /**
     * @param certificationCheckupType 
	 *            资格审查方式,SYS 投标人资质等级系统自动匹配审查,
     */
    public void setCertification_checkup_type(String certification_checkup_type) {
        this.certification_checkup_type = certification_checkup_type == null ? null : certification_checkup_type.trim();
    }

    /**
     * @return 评标方法,QLT 定性，CRE 信用商户评价，OVE综合评估
     */
    public String getBid_evaluation_type() {
        return bid_evaluation_type;
    }

    /**
     * @param bidEvaluationType 
	 *            评标方法,QLT 定性，CRE 信用商户评价，OVE综合评估
     */
    public void setBid_evaluation_type(String bid_evaluation_type) {
        this.bid_evaluation_type = bid_evaluation_type == null ? null : bid_evaluation_type.trim();
    }

    /**
     * @return 技术评标地点
     */
    public String getBid_evaluation_site() {
        return bid_evaluation_site;
    }

    /**
     * @param bidEvaluationSite 
	 *            技术评标地点
     */
    public void setBid_evaluation_site(String bid_evaluation_site) {
        this.bid_evaluation_site = bid_evaluation_site == null ? null : bid_evaluation_site.trim();
    }

    /**
     * @return 中标人确定方式,ORV 直接票决定标，MRV 逐轮票决定标，VDM 票决筹钱定标
     */
    public String getBid_winner_determine_way() {
        return bid_winner_determine_way;
    }

    /**
     * @param bidWinnerDetermineWay 
	 *            中标人确定方式,ORV 直接票决定标，MRV 逐轮票决定标，VDM 票决筹钱定标
     */
    public void setBid_winner_determine_way(String bid_winner_determine_way) {
        this.bid_winner_determine_way = bid_winner_determine_way == null ? null : bid_winner_determine_way.trim();
    }

    /**
     * @return 票决方式, SMP 简单铎书法，CPN 对比胜出法
     */
    public String getVote_win_way() {
        return vote_win_way;
    }

    /**
     * @param voteWinWay 
	 *            票决方式, SMP 简单铎书法，CPN 对比胜出法
     */
    public void setVote_win_way(String vote_win_way) {
        this.vote_win_way = vote_win_way == null ? null : vote_win_way.trim();
    }

    /**
     * @return 投标担保金额,单位为分
     */
    public Integer getBid_bond_amount() {
        return bid_bond_amount;
    }

    /**
     * @param bidBondAmount 
	 *            投标担保金额,单位为分
     */
    public void setBid_bond_amount(Integer bid_bond_amount) {
        this.bid_bond_amount = bid_bond_amount;
    }

    /**
     * @return 商务标必须,YES是，NO#否
     */
    public String getNeed_business_standard() {
        return need_business_standard;
    }

    /**
     * @param needBusinessStandard 
	 *            商务标必须,YES是，NO#否
     */
    public void setNeed_business_standard(String need_business_standard) {
        this.need_business_standard = need_business_standard == null ? null : need_business_standard.trim();
    }

    /**
     * @return 技术标必须,YES是，NO#否
     */
    public String getNeed_technical_standard() {
        return need_technical_standard;
    }

    /**
     * @param needTechnicalStandard 
	 *            技术标必须,YES是，NO#否
     */
    public void setNeed_technical_standard(String need_technical_standard) {
        this.need_technical_standard = need_technical_standard == null ? null : need_technical_standard.trim();
    }

    /**
     * @return 资格审查文件必须,YES是，NO#否
     */
    public String getNeed_certification_checkup_file() {
        return need_certification_checkup_file;
    }

    /**
     * @param needCertificationCheckupFile 
	 *            资格审查文件必须,YES是，NO#否
     */
    public void setNeed_certification_checkup_file(String need_certification_checkup_file) {
        this.need_certification_checkup_file = need_certification_checkup_file == null ? null : need_certification_checkup_file.trim();
    }

    /**
     * @return 需要投标人项目经理,YES是，NO#否
     */
    public String getNeed_pm_certification() {
        return need_pm_certification;
    }

    /**
     * @param needPmCertification 
	 *            需要投标人项目经理,YES是，NO#否
     */
    public void setNeed_pm_certification(String need_pm_certification) {
        this.need_pm_certification = need_pm_certification == null ? null : need_pm_certification.trim();
    }

    /**
     * @return 需要投标人建造师,YES是，NO#否
     */
    public String getNeed_constructor_certification() {
        return need_constructor_certification;
    }

    /**
     * @param needConstructorCertification 
	 *            需要投标人建造师,YES是，NO#否
     */
    public void setNeed_constructor_certification(String need_constructor_certification) {
        this.need_constructor_certification = need_constructor_certification == null ? null : need_constructor_certification.trim();
    }

    /**
     * @return 需要安全生产许可证,YES是，NO#否
     */
    public String getNeed_safety_permit() {
        return need_safety_permit;
    }

    /**
     * @param needSafetyPermit 
	 *            需要安全生产许可证,YES是，NO#否
     */
    public void setNeed_safety_permit(String need_safety_permit) {
        this.need_safety_permit = need_safety_permit == null ? null : need_safety_permit.trim();
    }

    /**
     * @return 需要项目经理安全生产考核合格证
     */
    public String getNeed_pm_safety_certification() {
        return need_pm_safety_certification;
    }

    /**
     * @param needPmSafetyCertification 
	 *            需要项目经理安全生产考核合格证
     */
    public void setNeed_pm_safety_certification(String need_pm_safety_certification) {
        this.need_pm_safety_certification = need_pm_safety_certification == null ? null : need_pm_safety_certification.trim();
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
        Project other = (Project) that;
        return (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getBiddee_id() == null ? other.getBiddee_id() == null : this.getBiddee_id().equals(other.getBiddee_id()))
            && (this.getObject_no() == null ? other.getObject_no() == null : this.getObject_no().equals(other.getObject_no()))
            && (this.getObject_name() == null ? other.getObject_name() == null : this.getObject_name().equals(other.getObject_name()))
            && (this.getObject_amount() == null ? other.getObject_amount() == null : this.getObject_amount().equals(other.getObject_amount()))
            && (this.getObject_publish_type() == null ? other.getObject_publish_type() == null : this.getObject_publish_type().equals(other.getObject_publish_type()))
            && (this.getObject_status() == null ? other.getObject_status() == null : this.getObject_status().equals(other.getObject_status()))
            && (this.getWin_bid_amount() == null ? other.getWin_bid_amount() == null : this.getWin_bid_amount().equals(other.getWin_bid_amount()))
            && (this.getWin_bidder_id() == null ? other.getWin_bidder_id() == null : this.getWin_bidder_id().equals(other.getWin_bidder_id()))
            && (this.getIndustry_id() == null ? other.getIndustry_id() == null : this.getIndustry_id().equals(other.getIndustry_id()))
            && (this.getSector_id() == null ? other.getSector_id() == null : this.getSector_id().equals(other.getSector_id()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getBiddee_company_principal() == null ? other.getBiddee_company_principal() == null : this.getBiddee_company_principal().equals(other.getBiddee_company_principal()))
            && (this.getBiddee_company_telephone() == null ? other.getBiddee_company_telephone() == null : this.getBiddee_company_telephone().equals(other.getBiddee_company_telephone()))
            && (this.getBid_open_date() == null ? other.getBid_open_date() == null : this.getBid_open_date().equals(other.getBid_open_date()))
            && (this.getProject_expect_period() == null ? other.getProject_expect_period() == null : this.getProject_expect_period().equals(other.getProject_expect_period()))
            && (this.getCertification_checkup_type() == null ? other.getCertification_checkup_type() == null : this.getCertification_checkup_type().equals(other.getCertification_checkup_type()))
            && (this.getBid_evaluation_type() == null ? other.getBid_evaluation_type() == null : this.getBid_evaluation_type().equals(other.getBid_evaluation_type()))
            && (this.getBid_evaluation_site() == null ? other.getBid_evaluation_site() == null : this.getBid_evaluation_site().equals(other.getBid_evaluation_site()))
            && (this.getBid_winner_determine_way() == null ? other.getBid_winner_determine_way() == null : this.getBid_winner_determine_way().equals(other.getBid_winner_determine_way()))
            && (this.getVote_win_way() == null ? other.getVote_win_way() == null : this.getVote_win_way().equals(other.getVote_win_way()))
            && (this.getBid_bond_amount() == null ? other.getBid_bond_amount() == null : this.getBid_bond_amount().equals(other.getBid_bond_amount()))
            && (this.getNeed_business_standard() == null ? other.getNeed_business_standard() == null : this.getNeed_business_standard().equals(other.getNeed_business_standard()))
            && (this.getNeed_technical_standard() == null ? other.getNeed_technical_standard() == null : this.getNeed_technical_standard().equals(other.getNeed_technical_standard()))
            && (this.getNeed_certification_checkup_file() == null ? other.getNeed_certification_checkup_file() == null : this.getNeed_certification_checkup_file().equals(other.getNeed_certification_checkup_file()))
            && (this.getNeed_pm_certification() == null ? other.getNeed_pm_certification() == null : this.getNeed_pm_certification().equals(other.getNeed_pm_certification()))
            && (this.getNeed_constructor_certification() == null ? other.getNeed_constructor_certification() == null : this.getNeed_constructor_certification().equals(other.getNeed_constructor_certification()))
            && (this.getNeed_safety_permit() == null ? other.getNeed_safety_permit() == null : this.getNeed_safety_permit().equals(other.getNeed_safety_permit()))
            && (this.getNeed_pm_safety_certification() == null ? other.getNeed_pm_safety_certification() == null : this.getNeed_pm_safety_certification().equals(other.getNeed_pm_safety_certification()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getBiddee_id() == null) ? 0 : getBiddee_id().hashCode());
        result = prime * result + ((getObject_no() == null) ? 0 : getObject_no().hashCode());
        result = prime * result + ((getObject_name() == null) ? 0 : getObject_name().hashCode());
        result = prime * result + ((getObject_amount() == null) ? 0 : getObject_amount().hashCode());
        result = prime * result + ((getObject_publish_type() == null) ? 0 : getObject_publish_type().hashCode());
        result = prime * result + ((getObject_status() == null) ? 0 : getObject_status().hashCode());
        result = prime * result + ((getWin_bid_amount() == null) ? 0 : getWin_bid_amount().hashCode());
        result = prime * result + ((getWin_bidder_id() == null) ? 0 : getWin_bidder_id().hashCode());
        result = prime * result + ((getIndustry_id() == null) ? 0 : getIndustry_id().hashCode());
        result = prime * result + ((getSector_id() == null) ? 0 : getSector_id().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getBiddee_company_principal() == null) ? 0 : getBiddee_company_principal().hashCode());
        result = prime * result + ((getBiddee_company_telephone() == null) ? 0 : getBiddee_company_telephone().hashCode());
        result = prime * result + ((getBid_open_date() == null) ? 0 : getBid_open_date().hashCode());
        result = prime * result + ((getProject_expect_period() == null) ? 0 : getProject_expect_period().hashCode());
        result = prime * result + ((getCertification_checkup_type() == null) ? 0 : getCertification_checkup_type().hashCode());
        result = prime * result + ((getBid_evaluation_type() == null) ? 0 : getBid_evaluation_type().hashCode());
        result = prime * result + ((getBid_evaluation_site() == null) ? 0 : getBid_evaluation_site().hashCode());
        result = prime * result + ((getBid_winner_determine_way() == null) ? 0 : getBid_winner_determine_way().hashCode());
        result = prime * result + ((getVote_win_way() == null) ? 0 : getVote_win_way().hashCode());
        result = prime * result + ((getBid_bond_amount() == null) ? 0 : getBid_bond_amount().hashCode());
        result = prime * result + ((getNeed_business_standard() == null) ? 0 : getNeed_business_standard().hashCode());
        result = prime * result + ((getNeed_technical_standard() == null) ? 0 : getNeed_technical_standard().hashCode());
        result = prime * result + ((getNeed_certification_checkup_file() == null) ? 0 : getNeed_certification_checkup_file().hashCode());
        result = prime * result + ((getNeed_pm_certification() == null) ? 0 : getNeed_pm_certification().hashCode());
        result = prime * result + ((getNeed_constructor_certification() == null) ? 0 : getNeed_constructor_certification().hashCode());
        result = prime * result + ((getNeed_safety_permit() == null) ? 0 : getNeed_safety_permit().hashCode());
        result = prime * result + ((getNeed_pm_safety_certification() == null) ? 0 : getNeed_pm_safety_certification().hashCode());
        return result;
    }
}