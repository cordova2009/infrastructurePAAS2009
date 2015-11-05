package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 标的投标方评价打分表,由投标方向招标方打分
 */
public class ProjectEvaluationBidder {
    /**
     * id
     */
    private Integer id;

    /**
     * 标的id
     */
    private Integer project_id;

    /**
     * 招标方id
     */
    private Integer biddee_id;

    /**
     * 投标方id
     */
    private Integer bidder_id;

    /**
     * 评价内容
     */
    private String evaluation_content;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 星星数,1-5
     */
    private Integer star_count;

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
    public Integer getProject_id() {
        return project_id;
    }

    /**
     * @param projectId 
	 *            标的id
     */
    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    /**
     * @return 招标方id
     */
    public Integer getBiddee_id() {
        return biddee_id;
    }

    /**
     * @param biddeeId 
	 *            招标方id
     */
    public void setBiddee_id(Integer biddee_id) {
        this.biddee_id = biddee_id;
    }

    /**
     * @return 投标方id
     */
    public Integer getBidder_id() {
        return bidder_id;
    }

    /**
     * @param bidderId 
	 *            投标方id
     */
    public void setBidder_id(Integer bidder_id) {
        this.bidder_id = bidder_id;
    }

    /**
     * @return 评价内容
     */
    public String getEvaluation_content() {
        return evaluation_content;
    }

    /**
     * @param evaluationContent 
	 *            评价内容
     */
    public void setEvaluation_content(String evaluation_content) {
        this.evaluation_content = evaluation_content == null ? null : evaluation_content.trim();
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
    public Integer getStar_count() {
        return star_count;
    }

    /**
     * @param starCount 
	 *            星星数,1-5
     */
    public void setStar_count(Integer star_count) {
        this.star_count = star_count;
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
        ProjectEvaluationBidder other = (ProjectEvaluationBidder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProject_id() == null ? other.getProject_id() == null : this.getProject_id().equals(other.getProject_id()))
            && (this.getBiddee_id() == null ? other.getBiddee_id() == null : this.getBiddee_id().equals(other.getBiddee_id()))
            && (this.getBidder_id() == null ? other.getBidder_id() == null : this.getBidder_id().equals(other.getBidder_id()))
            && (this.getEvaluation_content() == null ? other.getEvaluation_content() == null : this.getEvaluation_content().equals(other.getEvaluation_content()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getStar_count() == null ? other.getStar_count() == null : this.getStar_count().equals(other.getStar_count()))
            && (this.getInsert_time() == null ? other.getInsert_time() == null : this.getInsert_time().equals(other.getInsert_time()))
            && (this.getInsert_by() == null ? other.getInsert_by() == null : this.getInsert_by().equals(other.getInsert_by()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProject_id() == null) ? 0 : getProject_id().hashCode());
        result = prime * result + ((getBiddee_id() == null) ? 0 : getBiddee_id().hashCode());
        result = prime * result + ((getBidder_id() == null) ? 0 : getBidder_id().hashCode());
        result = prime * result + ((getEvaluation_content() == null) ? 0 : getEvaluation_content().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getStar_count() == null) ? 0 : getStar_count().hashCode());
        result = prime * result + ((getInsert_time() == null) ? 0 : getInsert_time().hashCode());
        result = prime * result + ((getInsert_by() == null) ? 0 : getInsert_by().hashCode());
        return result;
    }
}