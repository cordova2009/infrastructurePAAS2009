package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标签分类
 */
public class TagType {
    /**
     * id
     */
    private Integer id;

    /**
     * 分类
     */
    private String type;

    /**
     * 上级标签分类
     */
    private Integer parent_id;

    /**
     * 自定义分类,0否，1是
     */
    private String customer_type;

    /**
     * 状态，OK#正常，FLS停止
     */
    private String status;

    /**
     * 分类名称
     */
    private String type_name;

    /**
     * 创建人
     */
    private String create_by;

    /**
     * 创建时间
     */
    private Date insert_time;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 
	 *            id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 分类
     */
    public String getType() {
        return type;
    }

    /**
     * @param type 
	 *            分类
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return 上级标签分类
     */
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * @param parentId 
	 *            上级标签分类
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * @return 自定义分类,0否，1是
     */
    public String getCustomer_type() {
        return customer_type;
    }

    /**
     * @param customerType 
	 *            自定义分类,0否，1是
     */
    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type == null ? null : customer_type.trim();
    }

    /**
     * @return 状态，OK#正常，FLS停止
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态，OK#正常，FLS停止
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return 分类名称
     */
    public String getType_name() {
        return type_name;
    }

    /**
     * @param typeName 
	 *            分类名称
     */
    public void setType_name(String type_name) {
        this.type_name = type_name == null ? null : type_name.trim();
    }

    /**
     * @return 创建人
     */
    public String getCreate_by() {
        return create_by;
    }

    /**
     * @param createBy 
	 *            创建人
     */
    public void setCreate_by(String create_by) {
        this.create_by = create_by == null ? null : create_by.trim();
    }

    /**
     * @return 创建时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            创建时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
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
        TagType other = (TagType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getParent_id() == null ? other.getParent_id() == null : this.getParent_id().equals(other.getParent_id()))
            && (this.getCustomer_type() == null ? other.getCustomer_type() == null : this.getCustomer_type().equals(other.getCustomer_type()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getType_name() == null ? other.getType_name() == null : this.getType_name().equals(other.getType_name()))
            && (this.getCreate_by() == null ? other.getCreate_by() == null : this.getCreate_by().equals(other.getCreate_by()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getParent_id() == null) ? 0 : getParent_id().hashCode());
        result = prime * result + ((getCustomer_type() == null) ? 0 : getCustomer_type().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getType_name() == null) ? 0 : getType_name().hashCode());
        result = prime * result + ((getCreate_by() == null) ? 0 : getCreate_by().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        return result;
    }
}