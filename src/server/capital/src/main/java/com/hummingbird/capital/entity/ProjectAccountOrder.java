package com.hummingbird.capital.entity;

import java.util.Date;

/**
 * 记录企业工程帐户的订单历史
 */
public class ProjectAccountOrder {
    /**
     * 订单id
     */
    private String orderId;

    /**
     * 帐户id
     */
    private String accountId;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 类别，SBZ收 "退还保证金"(解冻)，JBZ交纳保证金(冻结)，GFK工程付款（招标方至平台），GSK工程收款（平台至投标方），CHZ冲正,TX#提现,CZ#充值,FRZ 冻结,UFZ 解冻,SXF 交手续费,TSX 退手续费
     */
    private String type;

    /**
     * 金额，单位分
     */
    private Integer sum;

    /**
     * 标的id
     */
    private String objectId;

    /**
     * 结存，即发生该交易后，该账户的结存
     */
    private Integer balance;

    /**
     * app订单号
     */
    private String appOrderId;

    /**
     * 外部订单号
     */
    private String externalOrderId;

    /**
     * 对方账户类型,PA# 企业工程帐户
     */
    private String peerAccountType;

    /**
     * 对方帐户id
     */
    private String peerAccountId;

    /**
     * 对方的账户发行单位，比如建设银行，如果是营销账户平台管理的账户，填写为“营销账户平台”
     */
    private String peerAccountUnit;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态，OK#成功，FLS失败
     */
    private String status;

    /**
     * 关联订单号
     */
    private String originalOrderId;

    /**
     * 关联表名
     */
    private String originalTable;

    /**
     * 流向，IN#-转入，OUT-转出
     */
    private String flowDirection;

    /**
     * 应用id
     */
    private String appId;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 接口方法
     */
    private String method;

    /**
     * app保留字段
     */
    private String appAlias;

    /**
     * app保留字段2
     */
    private String appAlias2;

    /**
     * 外部订单时间
     */
    private Date externalOrderTime;

    /**
     * 冻结余额
     */
    private Integer frozenSumSnapshot;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * @return 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId 
	 *            订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * @return 帐户id
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId 
	 *            帐户id
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * @return 插入时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            插入时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 类别，SBZ收 "退还保证金"(解冻)，JBZ交纳保证金(冻结)，GFK工程付款（招标方至平台），GSK工程收款（平台至投标方），CHZ冲正,TX#提现,CZ#充值,FRZ 冻结,UFZ 解冻,SXF 交手续费,TSX 退手续费
     */
    public String getType() {
        return type;
    }

    /**
     * @param type 
	 *            类别，SBZ收 "退还保证金"(解冻)，JBZ交纳保证金(冻结)，GFK工程付款（招标方至平台），GSK工程收款（平台至投标方），CHZ冲正,TX#提现,CZ#充值,FRZ 冻结,UFZ 解冻,SXF 交手续费,TSX 退手续费
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return 金额，单位分
     */
    public Integer getSum() {
        return sum;
    }

    /**
     * @param sum 
	 *            金额，单位分
     */
    public void setSum(Integer sum) {
        this.sum = sum;
    }

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
     * @return 结存，即发生该交易后，该账户的结存
     */
    public Integer getBalance() {
        return balance;
    }

    /**
     * @param balance 
	 *            结存，即发生该交易后，该账户的结存
     */
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    /**
     * @return app订单号
     */
    public String getAppOrderId() {
        return appOrderId;
    }

    /**
     * @param appOrderId 
	 *            app订单号
     */
    public void setAppOrderId(String appOrderId) {
        this.appOrderId = appOrderId == null ? null : appOrderId.trim();
    }

    /**
     * @return 外部订单号
     */
    public String getExternalOrderId() {
        return externalOrderId;
    }

    /**
     * @param externalOrderId 
	 *            外部订单号
     */
    public void setExternalOrderId(String externalOrderId) {
        this.externalOrderId = externalOrderId == null ? null : externalOrderId.trim();
    }

    /**
     * @return 对方账户类型,PA# 企业工程帐户
     */
    public String getPeerAccountType() {
        return peerAccountType;
    }

    /**
     * @param peerAccountType 
	 *            对方账户类型,PA# 企业工程帐户
     */
    public void setPeerAccountType(String peerAccountType) {
        this.peerAccountType = peerAccountType == null ? null : peerAccountType.trim();
    }

    /**
     * @return 对方帐户id
     */
    public String getPeerAccountId() {
        return peerAccountId;
    }

    /**
     * @param peerAccountId 
	 *            对方帐户id
     */
    public void setPeerAccountId(String peerAccountId) {
        this.peerAccountId = peerAccountId == null ? null : peerAccountId.trim();
    }

    /**
     * @return 对方的账户发行单位，比如建设银行，如果是营销账户平台管理的账户，填写为“营销账户平台”
     */
    public String getPeerAccountUnit() {
        return peerAccountUnit;
    }

    /**
     * @param peerAccountUnit 
	 *            对方的账户发行单位，比如建设银行，如果是营销账户平台管理的账户，填写为“营销账户平台”
     */
    public void setPeerAccountUnit(String peerAccountUnit) {
        this.peerAccountUnit = peerAccountUnit == null ? null : peerAccountUnit.trim();
    }

    /**
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark 
	 *            备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return 状态，OK#成功，FLS失败
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态，OK#成功，FLS失败
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 关联订单号
     */
    public String getOriginalOrderId() {
        return originalOrderId;
    }

    /**
     * @param originalOrderId 
	 *            关联订单号
     */
    public void setOriginalOrderId(String originalOrderId) {
        this.originalOrderId = originalOrderId == null ? null : originalOrderId.trim();
    }

    /**
     * @return 关联表名
     */
    public String getOriginalTable() {
        return originalTable;
    }

    /**
     * @param originalTable 
	 *            关联表名
     */
    public void setOriginalTable(String originalTable) {
        this.originalTable = originalTable == null ? null : originalTable.trim();
    }

    /**
     * @return 流向，IN#-转入，OUT-转出
     */
    public String getFlowDirection() {
        return flowDirection;
    }

    /**
     * @param flowDirection 
	 *            流向，IN#-转入，OUT-转出
     */
    public void setFlowDirection(String flowDirection) {
        this.flowDirection = flowDirection == null ? null : flowDirection.trim();
    }

    /**
     * @return 应用id
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId 
	 *            应用id
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * @return 应用名称
     */
    public String getAppName() {
        return appName;
    }

    /**
     * @param appName 
	 *            应用名称
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * @return 接口方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method 
	 *            接口方法
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * @return app保留字段
     */
    public String getAppAlias() {
        return appAlias;
    }

    /**
     * @param appAlias 
	 *            app保留字段
     */
    public void setAppAlias(String appAlias) {
        this.appAlias = appAlias == null ? null : appAlias.trim();
    }

    /**
     * @return app保留字段2
     */
    public String getAppAlias2() {
        return appAlias2;
    }

    /**
     * @param appAlias2 
	 *            app保留字段2
     */
    public void setAppAlias2(String appAlias2) {
        this.appAlias2 = appAlias2 == null ? null : appAlias2.trim();
    }

    /**
     * @return 外部订单时间
     */
    public Date getExternalOrderTime() {
        return externalOrderTime;
    }

    /**
     * @param externalOrderTime 
	 *            外部订单时间
     */
    public void setExternalOrderTime(Date externalOrderTime) {
        this.externalOrderTime = externalOrderTime;
    }

    /**
     * @return 冻结余额
     */
    public Integer getFrozenSumSnapshot() {
        return frozenSumSnapshot;
    }

    /**
     * @param frozenSumSnapshot 
	 *            冻结余额
     */
    public void setFrozenSumSnapshot(Integer frozenSumSnapshot) {
        this.frozenSumSnapshot = frozenSumSnapshot;
    }

    /**
     * @return 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName 
	 *            产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
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
        ProjectAccountOrder other = (ProjectAccountOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSum() == null ? other.getSum() == null : this.getSum().equals(other.getSum()))
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getAppOrderId() == null ? other.getAppOrderId() == null : this.getAppOrderId().equals(other.getAppOrderId()))
            && (this.getExternalOrderId() == null ? other.getExternalOrderId() == null : this.getExternalOrderId().equals(other.getExternalOrderId()))
            && (this.getPeerAccountType() == null ? other.getPeerAccountType() == null : this.getPeerAccountType().equals(other.getPeerAccountType()))
            && (this.getPeerAccountId() == null ? other.getPeerAccountId() == null : this.getPeerAccountId().equals(other.getPeerAccountId()))
            && (this.getPeerAccountUnit() == null ? other.getPeerAccountUnit() == null : this.getPeerAccountUnit().equals(other.getPeerAccountUnit()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOriginalOrderId() == null ? other.getOriginalOrderId() == null : this.getOriginalOrderId().equals(other.getOriginalOrderId()))
            && (this.getOriginalTable() == null ? other.getOriginalTable() == null : this.getOriginalTable().equals(other.getOriginalTable()))
            && (this.getFlowDirection() == null ? other.getFlowDirection() == null : this.getFlowDirection().equals(other.getFlowDirection()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getAppAlias() == null ? other.getAppAlias() == null : this.getAppAlias().equals(other.getAppAlias()))
            && (this.getAppAlias2() == null ? other.getAppAlias2() == null : this.getAppAlias2().equals(other.getAppAlias2()))
            && (this.getExternalOrderTime() == null ? other.getExternalOrderTime() == null : this.getExternalOrderTime().equals(other.getExternalOrderTime()))
            && (this.getFrozenSumSnapshot() == null ? other.getFrozenSumSnapshot() == null : this.getFrozenSumSnapshot().equals(other.getFrozenSumSnapshot()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSum() == null) ? 0 : getSum().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getAppOrderId() == null) ? 0 : getAppOrderId().hashCode());
        result = prime * result + ((getExternalOrderId() == null) ? 0 : getExternalOrderId().hashCode());
        result = prime * result + ((getPeerAccountType() == null) ? 0 : getPeerAccountType().hashCode());
        result = prime * result + ((getPeerAccountId() == null) ? 0 : getPeerAccountId().hashCode());
        result = prime * result + ((getPeerAccountUnit() == null) ? 0 : getPeerAccountUnit().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOriginalOrderId() == null) ? 0 : getOriginalOrderId().hashCode());
        result = prime * result + ((getOriginalTable() == null) ? 0 : getOriginalTable().hashCode());
        result = prime * result + ((getFlowDirection() == null) ? 0 : getFlowDirection().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getAppAlias() == null) ? 0 : getAppAlias().hashCode());
        result = prime * result + ((getAppAlias2() == null) ? 0 : getAppAlias2().hashCode());
        result = prime * result + ((getExternalOrderTime() == null) ? 0 : getExternalOrderTime().hashCode());
        result = prime * result + ((getFrozenSumSnapshot() == null) ? 0 : getFrozenSumSnapshot().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        return result;
    }
}