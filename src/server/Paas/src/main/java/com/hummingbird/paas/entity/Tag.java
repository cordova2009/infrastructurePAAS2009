package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标签表
 */
public class Tag {
    /**
     * id
     */
    private Integer id;

    /**
     * 标签分类
     */
    private Integer type_id;

    /**
     * 标签值
     */
    private String tag_name;

    /**
     * 状态，OK#正常，FLS停止
     */
    private String status;

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
     * @return 标签分类
     */
    public Integer getType_id() {
        return type_id;
    }

    /**
     * @param typeId 
	 *            标签分类
     */
    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    /**
     * @return 标签值
     */
    public String getTag_name() {
        return tag_name;
    }

    /**
     * @param tagName 
	 *            标签值
     */
    public void setTag_name(String tag_name) {
        this.tag_name = tag_name == null ? null : tag_name.trim();
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
        Tag other = (Tag) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getType_id() == null ? other.getType_id() == null : this.getType_id().equals(other.getType_id()))
            && (this.getTag_name() == null ? other.getTag_name() == null : this.getTag_name().equals(other.getTag_name()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreate_by() == null ? other.getCreate_by() == null : this.getCreate_by().equals(other.getCreate_by()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getType_id() == null) ? 0 : getType_id().hashCode());
        result = prime * result + ((getTag_name() == null) ? 0 : getTag_name().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreate_by() == null) ? 0 : getCreate_by().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        return result;
    }
}