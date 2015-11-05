package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标签值关联表,记录标签与表之间的关联
 */
public class TagRelation {
    /**
     * id
     */
    private Integer id;

    /**
     * 标签名
     */
    private String tag_name;

    /**
     * 引用表id
     */
    private String ref_value_id;

    /**
     * 引用表标识,可以为表名
     */
    private String ref_id;

    /**
     * 类型，标签类型
     */
    private String type;

    /**
     * 插入时间
     */
    private Date insert_time;

    /**
     * 标签id
     */
    private Integer tag_id;

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
     * @return 标签名
     */
    public String getTag_name() {
        return tag_name;
    }

    /**
     * @param tagName 
	 *            标签名
     */
    public void setTag_name(String tag_name) {
        this.tag_name = tag_name == null ? null : tag_name.trim();
    }

    /**
     * @return 引用表id
     */
    public String getRef_value_id() {
        return ref_value_id;
    }

    /**
     * @param refValueId 
	 *            引用表id
     */
    public void setRef_value_id(String ref_value_id) {
        this.ref_value_id = ref_value_id == null ? null : ref_value_id.trim();
    }

    /**
     * @return 引用表标识,可以为表名
     */
    public String getRef_id() {
        return ref_id;
    }

    /**
     * @param refId 
	 *            引用表标识,可以为表名
     */
    public void setRef_id(String ref_id) {
        this.ref_id = ref_id == null ? null : ref_id.trim();
    }

    /**
     * @return 类型，标签类型
     */
    public String getType() {
        return type;
    }

    /**
     * @param type 
	 *            类型，标签类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
     * @return 标签id
     */
    public Integer getTag_id() {
        return tag_id;
    }

    /**
     * @param tagId 
	 *            标签id
     */
    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
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
        TagRelation other = (TagRelation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTag_name() == null ? other.getTag_name() == null : this.getTag_name().equals(other.getTag_name()))
            && (this.getRef_value_id() == null ? other.getRef_value_id() == null : this.getRef_value_id().equals(other.getRef_value_id()))
            && (this.getRef_id() == null ? other.getRef_id() == null : this.getRef_id().equals(other.getRef_id()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getTag_id() == null ? other.getTag_id() == null : this.getTag_id().equals(other.getTag_id()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTag_name() == null) ? 0 : getTag_name().hashCode());
        result = prime * result + ((getRef_value_id() == null) ? 0 : getRef_value_id().hashCode());
        result = prime * result + ((getRef_id() == null) ? 0 : getRef_id().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getTag_id() == null) ? 0 : getTag_id().hashCode());
        return result;
    }
}