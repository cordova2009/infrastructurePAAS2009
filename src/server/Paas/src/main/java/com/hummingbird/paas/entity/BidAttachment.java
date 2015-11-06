package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 投标附件表
 */
public class BidAttachment {
    /**
     * id
     */
    private Integer id;

    /**
     * 投标id
     */
    private Integer bidId;

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
     * @return 投标id
     */
    public Integer getBidId() {
        return bidId;
    }

    /**
     * @param bidId 
	 *            投标id
     */
    public void setBidId(Integer bidId) {
        this.bidId = bidId;
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
        BidAttachment other = (BidAttachment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBidId() == null ? other.getBidId() == null : this.getBidId().equals(other.getBidId()))
            && (this.getAttachmentName() == null ? other.getAttachmentName() == null : this.getAttachmentName().equals(other.getAttachmentName()))
            && (this.getAttachmentUrl() == null ? other.getAttachmentUrl() == null : this.getAttachmentUrl().equals(other.getAttachmentUrl()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getInsertBy() == null ? other.getInsertBy() == null : this.getInsertBy().equals(other.getInsertBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBidId() == null) ? 0 : getBidId().hashCode());
        result = prime * result + ((getAttachmentName() == null) ? 0 : getAttachmentName().hashCode());
        result = prime * result + ((getAttachmentUrl() == null) ? 0 : getAttachmentUrl().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getInsertBy() == null) ? 0 : getInsertBy().hashCode());
        return result;
    }
}