package com.hummingbird.paas.entity;

import java.util.Date;

public class TagGroup {
    /**
     * 标签组主键
     */
    private Integer tagGroupId;

    /**
     * 组名称
     */
    private String tagGroupName;

    /**
     * 添加时间
     */
    private Date tagGroupCreateTime;

    /**
     * 备注
     */
    private String tagGroupRemark;

    /**
     * @return 标签组主键
     */
    public Integer getTagGroupId() {
        return tagGroupId;
    }

    /**
     * @param tagGroupId 
	 *            标签组主键
     */
    public void setTagGroupId(Integer tagGroupId) {
        this.tagGroupId = tagGroupId;
    }

    /**
     * @return 组名称
     */
    public String getTagGroupName() {
        return tagGroupName;
    }

    /**
     * @param tagGroupName 
	 *            组名称
     */
    public void setTagGroupName(String tagGroupName) {
        this.tagGroupName = tagGroupName == null ? null : tagGroupName.trim();
    }

    /**
     * @return 添加时间
     */
    public Date getTagGroupCreateTime() {
        return tagGroupCreateTime;
    }

    /**
     * @param tagGroupCreateTime 
	 *            添加时间
     */
    public void setTagGroupCreateTime(Date tagGroupCreateTime) {
        this.tagGroupCreateTime = tagGroupCreateTime;
    }

    /**
     * @return 备注
     */
    public String getTagGroupRemark() {
        return tagGroupRemark;
    }

    /**
     * @param tagGroupRemark 
	 *            备注
     */
    public void setTagGroupRemark(String tagGroupRemark) {
        this.tagGroupRemark = tagGroupRemark == null ? null : tagGroupRemark.trim();
    }
}