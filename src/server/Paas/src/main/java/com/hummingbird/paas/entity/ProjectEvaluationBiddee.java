package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的招标方评价打分表,由招标方向投标方打分
 */
public class ProjectEvaluationBiddee {
    /**
     * id
     */
    private Integer id;

    /**
     * 标的id
     */
    private String projectId;

    /**
     * 招标方id
     */
    private Integer biddeeId;

    /**
     * 投标方id
     */
    private Integer bidderId;

    /**
     * 评价内容
     */
    private String evaluationContent;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 星星数,1-5
     */
    private Integer starCount;

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

    public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	

    public String getProjectId() {
		return projectId;
	}

	/**
     * @return 招标方id
     */
    public Integer getBiddeeId() {
        return biddeeId;
    }

    /**
     * @param biddeeId 
	 *            招标方id
     */
    public void setBiddeeId(Integer biddeeId) {
        this.biddeeId = biddeeId;
    }

    /**
     * @return 投标方id
     */
    public Integer getBidderId() {
        return bidderId;
    }

    /**
     * @param bidderId 
	 *            投标方id
     */
    public void setBidderId(Integer bidderId) {
        this.bidderId = bidderId;
    }

    /**
     * @return 评价内容
     */
    public String getEvaluationContent() {
        return evaluationContent;
    }

    /**
     * @param evaluationContent 
	 *            评价内容
     */
    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent == null ? null : evaluationContent.trim();
    }

    /**
     * @return 评分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score 
	 *            评分
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return 星星数,1-5
     */
    public Integer getStarCount() {
        return starCount;
    }

    /**
     * @param starCount 
	 *            星星数,1-5
     */
    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
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
        ProjectEvaluationBiddee other = (ProjectEvaluationBiddee) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getBiddeeId() == null ? other.getBiddeeId() == null : this.getBiddeeId().equals(other.getBiddeeId()))
            && (this.getBidderId() == null ? other.getBidderId() == null : this.getBidderId().equals(other.getBidderId()))
            && (this.getEvaluationContent() == null ? other.getEvaluationContent() == null : this.getEvaluationContent().equals(other.getEvaluationContent()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getStarCount() == null ? other.getStarCount() == null : this.getStarCount().equals(other.getStarCount()))
            && (this.getInsertTime() == null ? other.getInsertTime() == null : this.getInsertTime().equals(other.getInsertTime()))
            && (this.getInsertBy() == null ? other.getInsertBy() == null : this.getInsertBy().equals(other.getInsertBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getBiddeeId() == null) ? 0 : getBiddeeId().hashCode());
        result = prime * result + ((getBidderId() == null) ? 0 : getBidderId().hashCode());
        result = prime * result + ((getEvaluationContent() == null) ? 0 : getEvaluationContent().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getStarCount() == null) ? 0 : getStarCount().hashCode());
        result = prime * result + ((getInsertTime() == null) ? 0 : getInsertTime().hashCode());
        result = prime * result + ((getInsertBy() == null) ? 0 : getInsertBy().hashCode());
        return result;
    }
}