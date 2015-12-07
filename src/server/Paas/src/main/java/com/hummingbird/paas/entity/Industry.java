package com.hummingbird.paas.entity;

/**
 * 行业版块表
 */
public class Industry {
    /**
     * 行业id
     */
    private String id;

    /**
     * 行业名称
     */
    private String industryName;

    /**
     * 行业图标
     */
    private String industryIcon;

    /**
     * @return 行业id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id 
	 *            行业id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return 行业名称
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * @param industryName 
	 *            行业名称
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName == null ? null : industryName.trim();
    }

    /**
     * @return 行业图标
     */
    public String getIndustryIcon() {
        return industryIcon;
    }

    /**
     * @param industryIcon 
	 *            行业图标
     */
    public void setIndustryIcon(String industryIcon) {
        this.industryIcon = industryIcon == null ? null : industryIcon.trim();
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
        Industry other = (Industry) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIndustryName() == null ? other.getIndustryName() == null : this.getIndustryName().equals(other.getIndustryName()))
            && (this.getIndustryIcon() == null ? other.getIndustryIcon() == null : this.getIndustryIcon().equals(other.getIndustryIcon()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIndustryName() == null) ? 0 : getIndustryName().hashCode());
        result = prime * result + ((getIndustryIcon() == null) ? 0 : getIndustryIcon().hashCode());
        return result;
    }
}