package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的工程表
 */
public class BidObject {
    /**
     * 招标编号(平台),ZB00时间戳随机数
     */
    private String objectId;

    /**
     * 发包方id
     */
    private Integer biddeeId;

    /**
     * 招标项目编号
     */
    private String objectNo;

    /**
     * 招标项目名称
     */
    private String objectName;

    /**
     * 标的金额
     */
    private Integer objectAmount;

    /**
     * 标的公开类型,PUB公开招标,INV邀请招标
     */
    private String objectPublishType;

    /**
     * 标的状态,CRT 创建，PUB发布（可投标），REV评标开标，ADA废标，FLS流标，SEL定标，END结束
     */
    private String objectStatus;

    /**
     * 中标金额
     */
    private String winBidAmount;

    /**
     * 中标的承包商id
     */
    private Integer winBidderId;

    /**
     * 板块分类,来自行业版块表
     */
    private String industryId;

    /**
     * 板块分类,来自行业版块表
     */
    private String sectorId;

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
    private String biddeeCompanyPrincipal;

    /**
     * 招标方办公电话
     */
    private String biddeeCompanyTelephone;

    /**
     * 开标时间
     */
    private Date bidOpenDate;

    /**
     * 标准工期,单位是日历天
     */
    private Integer projectExpectPeriod;

    /**
     * 承包方式
     */
    private String contractType;

    /**
     * 采用币种,CNY人民币,USD美元
     */
    private String currency;

    /**
     * 投标担保金额,单位为分
     */
    private Integer bidBondAmount;

    /**
     * 商务标必须,YES是，NO#否
     */
    private String needBusinessStandard;

    /**
     * 技术标必须,YES是，NO#否
     */
    private String needTechnicalStandard;

    /**
     * 资格审查文件必须,YES是，NO#否
     */
    private String needCertificationCheckupFile;

    /**
     * 需要投标人项目经理,YES是，NO#否
     */
    private String needPmCertification;

    /**
     * 需要投标人建造师,YES是，NO#否
     */
    private String needConstructorCertification;

    /**
     * 需要安全生产许可证,YES是，NO#否
     */
    private String needSafetyPermit;

    /**
     * 需要项目经理安全生产考核合格证
     */
    private String needPmSafetyCertification;

    /**
     * 工程标的估价
     */
    private Integer evaluationAmount;

    /**
     * 招标项目范围
     */
    private String objectScope;

    /**
     * @return 招标编号(平台),ZB00时间戳随机数
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * @param objectId 
	 *            招标编号(平台),ZB00时间戳随机数
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId == null ? null : objectId.trim();
    }

    /**
     * @return 发包方id
     */
    public Integer getBiddeeId() {
        return biddeeId;
    }

    /**
     * @param biddeeId 
	 *            发包方id
     */
    public void setBiddeeId(Integer biddeeId) {
        this.biddeeId = biddeeId;
    }

    /**
     * @return 招标项目编号
     */
    public String getObjectNo() {
        return objectNo;
    }

    /**
     * @param objectNo 
	 *            招标项目编号
     */
    public void setObjectNo(String objectNo) {
        this.objectNo = objectNo == null ? null : objectNo.trim();
    }

    /**
     * @return 招标项目名称
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * @param objectName 
	 *            招标项目名称
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName == null ? null : objectName.trim();
    }

    /**
     * @return 标的金额
     */
    public Integer getObjectAmount() {
        return objectAmount;
    }

    /**
     * @param objectAmount 
	 *            标的金额
     */
    public void setObjectAmount(Integer objectAmount) {
        this.objectAmount = objectAmount;
    }

    /**
     * @return 标的公开类型,PUB公开招标,INV邀请招标
     */
    public String getObjectPublishType() {
        return objectPublishType;
    }

    /**
     * @param objectPublishType 
	 *            标的公开类型,PUB公开招标,INV邀请招标
     */
    public void setObjectPublishType(String objectPublishType) {
        this.objectPublishType = objectPublishType == null ? null : objectPublishType.trim();
    }

    /**
     * @return 标的状态,CRT 创建，PUB发布（可投标），REV评标开标，ADA废标，FLS流标，SEL定标，END结束
     */
    public String getObjectStatus() {
        return objectStatus;
    }

    /**
     * @param objectStatus 
	 *            标的状态,CRT 创建，PUB发布（可投标），REV评标开标，ADA废标，FLS流标，SEL定标，END结束
     */
    public void setObjectStatus(String objectStatus) {
        this.objectStatus = objectStatus == null ? null : objectStatus.trim();
    }

    /**
     * @return 中标金额
     */
    public String getWinBidAmount() {
        return winBidAmount;
    }

    /**
     * @param winBidAmount 
	 *            中标金额
     */
    public void setWinBidAmount(String winBidAmount) {
        this.winBidAmount = winBidAmount == null ? null : winBidAmount.trim();
    }

    /**
     * @return 中标的承包商id
     */
    public Integer getWinBidderId() {
        return winBidderId;
    }

    /**
     * @param winBidderId 
	 *            中标的承包商id
     */
    public void setWinBidderId(Integer winBidderId) {
        this.winBidderId = winBidderId;
    }

    /**
     * @return 板块分类,来自行业版块表
     */
    public String getIndustryId() {
        return industryId;
    }

    /**
     * @param industryId 
	 *            板块分类,来自行业版块表
     */
    public void setIndustryId(String industryId) {
        this.industryId = industryId == null ? null : industryId.trim();
    }

    /**
     * @return 板块分类,来自行业版块表
     */
    public String getSectorId() {
        return sectorId;
    }

    /**
     * @param sectorId 
	 *            板块分类,来自行业版块表
     */
    public void setSectorId(String sectorId) {
        this.sectorId = sectorId == null ? null : sectorId.trim();
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
     * @return 开标时间
     */
    public Date getBidOpenDate() {
        return bidOpenDate;
    }

    /**
     * @param bidOpenDate 
	 *            开标时间
     */
    public void setBidOpenDate(Date bidOpenDate) {
        this.bidOpenDate = bidOpenDate;
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
     * @return 投标担保金额,单位为分
     */
    public Integer getBidBondAmount() {
        return bidBondAmount;
    }

    /**
     * @param bidBondAmount 
	 *            投标担保金额,单位为分
     */
    public void setBidBondAmount(Integer bidBondAmount) {
        this.bidBondAmount = bidBondAmount;
    }

    /**
     * @return 商务标必须,YES是，NO#否
     */
    public String getNeedBusinessStandard() {
        return needBusinessStandard;
    }

    /**
     * @param needBusinessStandard 
	 *            商务标必须,YES是，NO#否
     */
    public void setNeedBusinessStandard(String needBusinessStandard) {
        this.needBusinessStandard = needBusinessStandard == null ? null : needBusinessStandard.trim();
    }

    /**
     * @return 技术标必须,YES是，NO#否
     */
    public String getNeedTechnicalStandard() {
        return needTechnicalStandard;
    }

    /**
     * @param needTechnicalStandard 
	 *            技术标必须,YES是，NO#否
     */
    public void setNeedTechnicalStandard(String needTechnicalStandard) {
        this.needTechnicalStandard = needTechnicalStandard == null ? null : needTechnicalStandard.trim();
    }

    /**
     * @return 资格审查文件必须,YES是，NO#否
     */
    public String getNeedCertificationCheckupFile() {
        return needCertificationCheckupFile;
    }

    /**
     * @param needCertificationCheckupFile 
	 *            资格审查文件必须,YES是，NO#否
     */
    public void setNeedCertificationCheckupFile(String needCertificationCheckupFile) {
        this.needCertificationCheckupFile = needCertificationCheckupFile == null ? null : needCertificationCheckupFile.trim();
    }

    /**
     * @return 需要投标人项目经理,YES是，NO#否
     */
    public String getNeedPmCertification() {
        return needPmCertification;
    }

    /**
     * @param needPmCertification 
	 *            需要投标人项目经理,YES是，NO#否
     */
    public void setNeedPmCertification(String needPmCertification) {
        this.needPmCertification = needPmCertification == null ? null : needPmCertification.trim();
    }

    /**
     * @return 需要投标人建造师,YES是，NO#否
     */
    public String getNeedConstructorCertification() {
        return needConstructorCertification;
    }

    /**
     * @param needConstructorCertification 
	 *            需要投标人建造师,YES是，NO#否
     */
    public void setNeedConstructorCertification(String needConstructorCertification) {
        this.needConstructorCertification = needConstructorCertification == null ? null : needConstructorCertification.trim();
    }

    /**
     * @return 需要安全生产许可证,YES是，NO#否
     */
    public String getNeedSafetyPermit() {
        return needSafetyPermit;
    }

    /**
     * @param needSafetyPermit 
	 *            需要安全生产许可证,YES是，NO#否
     */
    public void setNeedSafetyPermit(String needSafetyPermit) {
        this.needSafetyPermit = needSafetyPermit == null ? null : needSafetyPermit.trim();
    }

    /**
     * @return 需要项目经理安全生产考核合格证
     */
    public String getNeedPmSafetyCertification() {
        return needPmSafetyCertification;
    }

    /**
     * @param needPmSafetyCertification 
	 *            需要项目经理安全生产考核合格证
     */
    public void setNeedPmSafetyCertification(String needPmSafetyCertification) {
        this.needPmSafetyCertification = needPmSafetyCertification == null ? null : needPmSafetyCertification.trim();
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
     * @return 招标项目范围
     */
    public String getObjectScope() {
        return objectScope;
    }

    /**
     * @param objectScope 
	 *            招标项目范围
     */
    public void setObjectScope(String objectScope) {
        this.objectScope = objectScope == null ? null : objectScope.trim();
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
        BidObject other = (BidObject) that;
        return (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getBiddeeId() == null ? other.getBiddeeId() == null : this.getBiddeeId().equals(other.getBiddeeId()))
            && (this.getObjectNo() == null ? other.getObjectNo() == null : this.getObjectNo().equals(other.getObjectNo()))
            && (this.getObjectName() == null ? other.getObjectName() == null : this.getObjectName().equals(other.getObjectName()))
            && (this.getObjectAmount() == null ? other.getObjectAmount() == null : this.getObjectAmount().equals(other.getObjectAmount()))
            && (this.getObjectPublishType() == null ? other.getObjectPublishType() == null : this.getObjectPublishType().equals(other.getObjectPublishType()))
            && (this.getObjectStatus() == null ? other.getObjectStatus() == null : this.getObjectStatus().equals(other.getObjectStatus()))
            && (this.getWinBidAmount() == null ? other.getWinBidAmount() == null : this.getWinBidAmount().equals(other.getWinBidAmount()))
            && (this.getWinBidderId() == null ? other.getWinBidderId() == null : this.getWinBidderId().equals(other.getWinBidderId()))
            && (this.getIndustryId() == null ? other.getIndustryId() == null : this.getIndustryId().equals(other.getIndustryId()))
            && (this.getSectorId() == null ? other.getSectorId() == null : this.getSectorId().equals(other.getSectorId()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getBiddeeCompanyPrincipal() == null ? other.getBiddeeCompanyPrincipal() == null : this.getBiddeeCompanyPrincipal().equals(other.getBiddeeCompanyPrincipal()))
            && (this.getBiddeeCompanyTelephone() == null ? other.getBiddeeCompanyTelephone() == null : this.getBiddeeCompanyTelephone().equals(other.getBiddeeCompanyTelephone()))
            && (this.getBidOpenDate() == null ? other.getBidOpenDate() == null : this.getBidOpenDate().equals(other.getBidOpenDate()))
            && (this.getProjectExpectPeriod() == null ? other.getProjectExpectPeriod() == null : this.getProjectExpectPeriod().equals(other.getProjectExpectPeriod()))
            && (this.getContractType() == null ? other.getContractType() == null : this.getContractType().equals(other.getContractType()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getBidBondAmount() == null ? other.getBidBondAmount() == null : this.getBidBondAmount().equals(other.getBidBondAmount()))
            && (this.getNeedBusinessStandard() == null ? other.getNeedBusinessStandard() == null : this.getNeedBusinessStandard().equals(other.getNeedBusinessStandard()))
            && (this.getNeedTechnicalStandard() == null ? other.getNeedTechnicalStandard() == null : this.getNeedTechnicalStandard().equals(other.getNeedTechnicalStandard()))
            && (this.getNeedCertificationCheckupFile() == null ? other.getNeedCertificationCheckupFile() == null : this.getNeedCertificationCheckupFile().equals(other.getNeedCertificationCheckupFile()))
            && (this.getNeedPmCertification() == null ? other.getNeedPmCertification() == null : this.getNeedPmCertification().equals(other.getNeedPmCertification()))
            && (this.getNeedConstructorCertification() == null ? other.getNeedConstructorCertification() == null : this.getNeedConstructorCertification().equals(other.getNeedConstructorCertification()))
            && (this.getNeedSafetyPermit() == null ? other.getNeedSafetyPermit() == null : this.getNeedSafetyPermit().equals(other.getNeedSafetyPermit()))
            && (this.getNeedPmSafetyCertification() == null ? other.getNeedPmSafetyCertification() == null : this.getNeedPmSafetyCertification().equals(other.getNeedPmSafetyCertification()))
            && (this.getEvaluationAmount() == null ? other.getEvaluationAmount() == null : this.getEvaluationAmount().equals(other.getEvaluationAmount()))
            && (this.getObjectScope() == null ? other.getObjectScope() == null : this.getObjectScope().equals(other.getObjectScope()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getBiddeeId() == null) ? 0 : getBiddeeId().hashCode());
        result = prime * result + ((getObjectNo() == null) ? 0 : getObjectNo().hashCode());
        result = prime * result + ((getObjectName() == null) ? 0 : getObjectName().hashCode());
        result = prime * result + ((getObjectAmount() == null) ? 0 : getObjectAmount().hashCode());
        result = prime * result + ((getObjectPublishType() == null) ? 0 : getObjectPublishType().hashCode());
        result = prime * result + ((getObjectStatus() == null) ? 0 : getObjectStatus().hashCode());
        result = prime * result + ((getWinBidAmount() == null) ? 0 : getWinBidAmount().hashCode());
        result = prime * result + ((getWinBidderId() == null) ? 0 : getWinBidderId().hashCode());
        result = prime * result + ((getIndustryId() == null) ? 0 : getIndustryId().hashCode());
        result = prime * result + ((getSectorId() == null) ? 0 : getSectorId().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getBiddeeCompanyPrincipal() == null) ? 0 : getBiddeeCompanyPrincipal().hashCode());
        result = prime * result + ((getBiddeeCompanyTelephone() == null) ? 0 : getBiddeeCompanyTelephone().hashCode());
        result = prime * result + ((getBidOpenDate() == null) ? 0 : getBidOpenDate().hashCode());
        result = prime * result + ((getProjectExpectPeriod() == null) ? 0 : getProjectExpectPeriod().hashCode());
        result = prime * result + ((getContractType() == null) ? 0 : getContractType().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getBidBondAmount() == null) ? 0 : getBidBondAmount().hashCode());
        result = prime * result + ((getNeedBusinessStandard() == null) ? 0 : getNeedBusinessStandard().hashCode());
        result = prime * result + ((getNeedTechnicalStandard() == null) ? 0 : getNeedTechnicalStandard().hashCode());
        result = prime * result + ((getNeedCertificationCheckupFile() == null) ? 0 : getNeedCertificationCheckupFile().hashCode());
        result = prime * result + ((getNeedPmCertification() == null) ? 0 : getNeedPmCertification().hashCode());
        result = prime * result + ((getNeedConstructorCertification() == null) ? 0 : getNeedConstructorCertification().hashCode());
        result = prime * result + ((getNeedSafetyPermit() == null) ? 0 : getNeedSafetyPermit().hashCode());
        result = prime * result + ((getNeedPmSafetyCertification() == null) ? 0 : getNeedPmSafetyCertification().hashCode());
        result = prime * result + ((getEvaluationAmount() == null) ? 0 : getEvaluationAmount().hashCode());
        result = prime * result + ((getObjectScope() == null) ? 0 : getObjectScope().hashCode());
        return result;
    }
}