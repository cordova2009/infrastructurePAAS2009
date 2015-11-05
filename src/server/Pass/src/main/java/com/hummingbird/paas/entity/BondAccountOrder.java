package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 保证金帐户订单记录表
 */
public class BondAccountOrder {
    /**
     * 订单id
     */
    private Integer order_id;

    /**
     * 帐户id
     */
    private Integer account_id;

    /**
     * 插入时间
     */
    private Date insert_time;

    /**
     * 类别，ZBZ平台方收保证金（承包商），FBZ平台方收保证金（发包方）
     */
    private String type;

    /**
     * 金额，单位分
     */
    private Integer sum;

    /**
     * 标的id
     */
    private Integer object_id;

    /**
     * 结存，即发生该交易后，该账户的结存
     */
    private Integer balance;

    /**
     * app订单号
     */
    private String app_order_id;

    /**
     * 外部订单号
     */
    private String external_order_id;

    /**
     * 对方账户类型,PA# 企业工程帐户
     */
    private String peer_account_type;

    /**
     * 对方帐户id
     */
    private String peer_account_id;

    /**
     * 对方的账户发行单位，比如建设银行，如果是营销账户平台管理的账户，填写为“营销账户平台”
     */
    private String peer_account_unit;

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
    private String original_order_id;

    /**
     * 关联表名
     */
    private String original_table;

    /**
     * 流向，IN#-转入，OUT-转出
     */
    private String flow_direction;

    /**
     * 应用id
     */
    private String app_id;

    /**
     * 应用名称
     */
    private String app_name;

    /**
     * 接口方法
     */
    private String method;

    /**
     * app保留字段
     */
    private String app_alias;

    /**
     * app保留字段2
     */
    private String app_alias2;

    /**
     * 外部订单时间
     */
    private Date external_order_time;

    /**
     * @return 订单id
     */
    public Integer getOrder_id() {
        return order_id;
    }

    /**
     * @param orderId 
	 *            订单id
     */
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    /**
     * @return 帐户id
     */
    public Integer getAccount_id() {
        return account_id;
    }

    /**
     * @param accountId 
	 *            帐户id
     */
    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    /**
     * @return 插入时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            插入时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return 类别，ZBZ平台方收保证金（承包商），FBZ平台方收保证金（发包方）
     */
    public String getType() {
        return type;
    }

    /**
     * @param type 
	 *            类别，ZBZ平台方收保证金（承包商），FBZ平台方收保证金（发包方）
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
    public Integer getObject_id() {
        return object_id;
    }

    /**
     * @param objectId 
	 *            标的id
     */
    public void setObject_id(Integer object_id) {
        this.object_id = object_id;
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
    public String getApp_order_id() {
        return app_order_id;
    }

    /**
     * @param appOrderId 
	 *            app订单号
     */
    public void setApp_order_id(String app_order_id) {
        this.app_order_id = app_order_id == null ? null : app_order_id.trim();
    }

    /**
     * @return 外部订单号
     */
    public String getExternal_order_id() {
        return external_order_id;
    }

    /**
     * @param externalOrderId 
	 *            外部订单号
     */
    public void setExternal_order_id(String external_order_id) {
        this.external_order_id = external_order_id == null ? null : external_order_id.trim();
    }

    /**
     * @return 对方账户类型,PA# 企业工程帐户
     */
    public String getPeer_account_type() {
        return peer_account_type;
    }

    /**
     * @param peerAccountType 
	 *            对方账户类型,PA# 企业工程帐户
     */
    public void setPeer_account_type(String peer_account_type) {
        this.peer_account_type = peer_account_type == null ? null : peer_account_type.trim();
    }

    /**
     * @return 对方帐户id
     */
    public String getPeer_account_id() {
        return peer_account_id;
    }

    /**
     * @param peerAccountId 
	 *            对方帐户id
     */
    public void setPeer_account_id(String peer_account_id) {
        this.peer_account_id = peer_account_id == null ? null : peer_account_id.trim();
    }

    /**
     * @return 对方的账户发行单位，比如建设银行，如果是营销账户平台管理的账户，填写为“营销账户平台”
     */
    public String getPeer_account_unit() {
        return peer_account_unit;
    }

    /**
     * @param peerAccountUnit 
	 *            对方的账户发行单位，比如建设银行，如果是营销账户平台管理的账户，填写为“营销账户平台”
     */
    public void setPeer_account_unit(String peer_account_unit) {
        this.peer_account_unit = peer_account_unit == null ? null : peer_account_unit.trim();
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
    public String getOriginal_order_id() {
        return original_order_id;
    }

    /**
     * @param originalOrderId 
	 *            关联订单号
     */
    public void setOriginal_order_id(String original_order_id) {
        this.original_order_id = original_order_id == null ? null : original_order_id.trim();
    }

    /**
     * @return 关联表名
     */
    public String getOriginal_table() {
        return original_table;
    }

    /**
     * @param originalTable 
	 *            关联表名
     */
    public void setOriginal_table(String original_table) {
        this.original_table = original_table == null ? null : original_table.trim();
    }

    /**
     * @return 流向，IN#-转入，OUT-转出
     */
    public String getFlow_direction() {
        return flow_direction;
    }

    /**
     * @param flowDirection 
	 *            流向，IN#-转入，OUT-转出
     */
    public void setFlow_direction(String flow_direction) {
        this.flow_direction = flow_direction == null ? null : flow_direction.trim();
    }

    /**
     * @return 应用id
     */
    public String getApp_id() {
        return app_id;
    }

    /**
     * @param appId 
	 *            应用id
     */
    public void setApp_id(String app_id) {
        this.app_id = app_id == null ? null : app_id.trim();
    }

    /**
     * @return 应用名称
     */
    public String getApp_name() {
        return app_name;
    }

    /**
     * @param appName 
	 *            应用名称
     */
    public void setApp_name(String app_name) {
        this.app_name = app_name == null ? null : app_name.trim();
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
    public String getApp_alias() {
        return app_alias;
    }

    /**
     * @param appAlias 
	 *            app保留字段
     */
    public void setApp_alias(String app_alias) {
        this.app_alias = app_alias == null ? null : app_alias.trim();
    }

    /**
     * @return app保留字段2
     */
    public String getApp_alias2() {
        return app_alias2;
    }

    /**
     * @param appAlias2 
	 *            app保留字段2
     */
    public void setApp_alias2(String app_alias2) {
        this.app_alias2 = app_alias2 == null ? null : app_alias2.trim();
    }

    /**
     * @return 外部订单时间
     */
    public Date getExternal_order_time() {
        return external_order_time;
    }

    /**
     * @param externalOrderTime 
	 *            外部订单时间
     */
    public void setExternal_order_time(Date external_order_time) {
        this.external_order_time = external_order_time;
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
        BondAccountOrder other = (BondAccountOrder) that;
        return (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getAccount_id() == null ? other.getAccount_id() == null : this.getAccount_id().equals(other.getAccount_id()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSum() == null ? other.getSum() == null : this.getSum().equals(other.getSum()))
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getApp_order_id() == null ? other.getApp_order_id() == null : this.getApp_order_id().equals(other.getApp_order_id()))
            && (this.getExternal_order_id() == null ? other.getExternal_order_id() == null : this.getExternal_order_id().equals(other.getExternal_order_id()))
            && (this.getPeer_account_type() == null ? other.getPeer_account_type() == null : this.getPeer_account_type().equals(other.getPeer_account_type()))
            && (this.getPeer_account_id() == null ? other.getPeer_account_id() == null : this.getPeer_account_id().equals(other.getPeer_account_id()))
            && (this.getPeer_account_unit() == null ? other.getPeer_account_unit() == null : this.getPeer_account_unit().equals(other.getPeer_account_unit()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOriginal_order_id() == null ? other.getOriginal_order_id() == null : this.getOriginal_order_id().equals(other.getOriginal_order_id()))
            && (this.getOriginal_table() == null ? other.getOriginal_table() == null : this.getOriginal_table().equals(other.getOriginal_table()))
            && (this.getFlow_direction() == null ? other.getFlow_direction() == null : this.getFlow_direction().equals(other.getFlow_direction()))
            && (this.getApp_id() == null ? other.getApp_id() == null : this.getApp_id().equals(other.getApp_id()))
            && (this.getApp_name() == null ? other.getApp_name() == null : this.getApp_name().equals(other.getApp_name()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getApp_alias() == null ? other.getApp_alias() == null : this.getApp_alias().equals(other.getApp_alias()))
            && (this.getApp_alias2() == null ? other.getApp_alias2() == null : this.getApp_alias2().equals(other.getApp_alias2()))
            && (this.getExternal_order_time() == null ? other.getExternal_order_time() == null : this.getExternal_order_time().equals(other.getExternal_order_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getAccount_id() == null) ? 0 : getAccount_id().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSum() == null) ? 0 : getSum().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getApp_order_id() == null) ? 0 : getApp_order_id().hashCode());
        result = prime * result + ((getExternal_order_id() == null) ? 0 : getExternal_order_id().hashCode());
        result = prime * result + ((getPeer_account_type() == null) ? 0 : getPeer_account_type().hashCode());
        result = prime * result + ((getPeer_account_id() == null) ? 0 : getPeer_account_id().hashCode());
        result = prime * result + ((getPeer_account_unit() == null) ? 0 : getPeer_account_unit().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOriginal_order_id() == null) ? 0 : getOriginal_order_id().hashCode());
        result = prime * result + ((getOriginal_table() == null) ? 0 : getOriginal_table().hashCode());
        result = prime * result + ((getFlow_direction() == null) ? 0 : getFlow_direction().hashCode());
        result = prime * result + ((getApp_id() == null) ? 0 : getApp_id().hashCode());
        result = prime * result + ((getApp_name() == null) ? 0 : getApp_name().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getApp_alias() == null) ? 0 : getApp_alias().hashCode());
        result = prime * result + ((getApp_alias2() == null) ? 0 : getApp_alias2().hashCode());
        result = prime * result + ((getExternal_order_time() == null) ? 0 : getExternal_order_time().hashCode());
        return result;
    }
}