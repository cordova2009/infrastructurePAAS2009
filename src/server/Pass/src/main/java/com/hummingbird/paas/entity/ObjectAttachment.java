package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的附件表
 */
public class ObjectAttachment {
    /**
     * id
     */
    private Integer id;

    /**
     * 标的id
     */
    private String object_id;

    /**
     * 附件名称
     */
    private String attachment_name;

    /**
     * 附件url
     */
    private String attachment_url;

    /**
     * 新增时间
     */
    private Date insert_time;

    /**
     * 新增人
     */
    private String insert_by;

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
     * @return 附件名称
     */
    public String getAttachment_name() {
        return attachment_name;
    }

    /**
     * @param attachmentName 
	 *            附件名称
     */
    public void setAttachment_name(String attachment_name) {
        this.attachment_name = attachment_name == null ? null : attachment_name.trim();
    }

    /**
     * @return 附件url
     */
    public String getAttachment_url() {
        return attachment_url;
    }

    /**
     * @param attachmentUrl 
	 *            附件url
     */
    public void setAttachment_url(String attachment_url) {
        this.attachment_url = attachment_url == null ? null : attachment_url.trim();
    }

    /**
     * @return 新增时间
     */
    public Date getInsert_time() {
        return insert_time;
    }

    /**
     * @param insertTime 
	 *            新增时间
     */
    public void setInsert_time(Date insert_time) {
        this.insert_time = insert_time;
    }

    /**
     * @return 新增人
     */
    public String getInsert_by() {
        return insert_by;
    }

    /**
     * @param insertBy 
	 *            新增人
     */
    public void setInsert_by(String insert_by) {
        this.insert_by = insert_by == null ? null : insert_by.trim();
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
        ObjectAttachment other = (ObjectAttachment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObject_id() == null ? other.getObject_id() == null : this.getObject_id().equals(other.getObject_id()))
            && (this.getAttachment_name() == null ? other.getAttachment_name() == null : this.getAttachment_name().equals(other.getAttachment_name()))
            && (this.getAttachment_url() == null ? other.getAttachment_url() == null : this.getAttachment_url().equals(other.getAttachment_url()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getInsert_by() == null ? other.getInsert_by() == null : this.getInsert_by().equals(other.getInsert_by()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObject_id() == null) ? 0 : getObject_id().hashCode());
        result = prime * result + ((getAttachment_name() == null) ? 0 : getAttachment_name().hashCode());
        result = prime * result + ((getAttachment_url() == null) ? 0 : getAttachment_url().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getInsert_by() == null) ? 0 : getInsert_by().hashCode());
        return result;
    }
}