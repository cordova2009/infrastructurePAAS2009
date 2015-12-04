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
    private String objectId;

    /**
     * 附件名称
     */
    private String attachmentName;

    /**
     * 附件url
     */
    private String attachmentUrl;

    /**
     * 新增时间
     */
    private Date insertTime;

    /**
     * 新增人
     */
    private String insertBy;

    /**
     * 附件类型,TF# 招标文件
     */
    private String attachmentType;

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
     * @return 附件名称
     */
    public String getAttachmentName() {
        return attachmentName;
    }

    /**
     * @param attachmentName 
	 *            附件名称
     */
    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    /**
     * @return 附件url
     */
    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    /**
     * @param attachmentUrl 
	 *            附件url
     */
    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl == null ? null : attachmentUrl.trim();
    }

    /**
     * @return 新增时间
     */
    public Date getInsertTime() {
        return insertTime;
    }

    /**
     * @param insertTime 
	 *            新增时间
     */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    /**
     * @return 新增人
     */
    public String getInsertBy() {
        return insertBy;
    }

    /**
     * @param insertBy 
	 *            新增人
     */
    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy == null ? null : insertBy.trim();
    }

    /**
     * @return 附件类型,TF# 招标文件
     */
    public String getAttachmentType() {
        return attachmentType;
    }

    /**
     * @param attachmentType 
	 *            附件类型,TF# 招标文件
     */
    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType == null ? null : attachmentType.trim();
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
            && (this.getObjectId() == null ? other.getObjectId() == null : this.getObjectId().equals(other.getObjectId()))
            && (this.getAttachmentName() == null ? other.getAttachmentName() == null : this.getAttachmentName().equals(other.getAttachmentName()))
            && (this.getAttachmentUrl() == null ? other.getAttachmentUrl() == null : this.getAttachmentUrl().equals(other.getAttachmentUrl()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getInsertBy() == null ? other.getInsertBy() == null : this.getInsertBy().equals(other.getInsertBy()))
            && (this.getAttachmentType() == null ? other.getAttachmentType() == null : this.getAttachmentType().equals(other.getAttachmentType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectId() == null) ? 0 : getObjectId().hashCode());
        result = prime * result + ((getAttachmentName() == null) ? 0 : getAttachmentName().hashCode());
        result = prime * result + ((getAttachmentUrl() == null) ? 0 : getAttachmentUrl().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getInsertBy() == null) ? 0 : getInsertBy().hashCode());
        result = prime * result + ((getAttachmentType() == null) ? 0 : getAttachmentType().hashCode());
        return result;
    }
}