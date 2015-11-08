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
    private String tagName;

    /**
     * 引用表id
     */
    private String refValueId;

    /**
     * 引用表标识,可以为表名
     */
    private String refId;

    /**
     * 类型，标签类型
     */
    private String type;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 标签id
     */
    private Integer tagId;

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
    public String getTagName() {
        return tagName;
    }

    /**
     * @param tagName 
	 *            标签名
     */
    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    /**
     * @return 引用表id
     */
    public String getRefValueId() {
        return refValueId;
    }

    /**
     * @param refValueId 
	 *            引用表id
     */
    public void setRefValueId(String refValueId) {
        this.refValueId = refValueId == null ? null : refValueId.trim();
    }

    /**
     * @return 引用表标识,可以为表名
     */
    public String getRefId() {
        return refId;
    }

    /**
     * @param refId 
	 *            引用表标识,可以为表名
     */
    public void setRefId(String refId) {
        this.refId = refId == null ? null : refId.trim();
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
     * @return 标签id
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * @param tagId 
	 *            标签id
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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
            && (this.getTagName() == null ? other.getTagName() == null : this.getTagName().equals(other.getTagName()))
            && (this.getRefValueId() == null ? other.getRefValueId() == null : this.getRefValueId().equals(other.getRefValueId()))
            && (this.getRefId() == null ? other.getRefId() == null : this.getRefId().equals(other.getRefId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getTagId() == null ? other.getTagId() == null : this.getTagId().equals(other.getTagId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTagName() == null) ? 0 : getTagName().hashCode());
        result = prime * result + ((getRefValueId() == null) ? 0 : getRefValueId().hashCode());
        result = prime * result + ((getRefId() == null) ? 0 : getRefId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getTagId() == null) ? 0 : getTagId().hashCode());
        return result;
    }
}