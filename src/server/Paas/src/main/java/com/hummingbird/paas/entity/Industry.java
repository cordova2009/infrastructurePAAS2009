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
    private String industry_name;

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
    public String getIndustry_name() {
        return industry_name;
    }

    /**
     * @param industryName 
	 *            行业名称
     */
    public void setIndustry_name(String industry_name) {
        this.industry_name = industry_name == null ? null : industry_name.trim();
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
            && (this.getIndustry_name() == null ? other.getIndustry_name() == null : this.getIndustry_name().equals(other.getIndustry_name()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIndustry_name() == null) ? 0 : getIndustry_name().hashCode());
        return result;
    }
}