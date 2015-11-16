package com.hummingbird.paas.entity;

/**
 * 信用等级判定表，记录由分数转成等级的规则
 */
public class ScoreLevel {
    private Integer id;

    /**
     * 等级名称
     */
    private String levelName;

    /**
     * 最小分数,分数要大于等于此值
     */
    private Integer minScore;

    /**
     * 最大分数，分数要小于此值
     */
    private Integer maxScore;

    /**
     * 图标
     */
    private String icon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 等级名称
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * @param levelName 
	 *            等级名称
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    /**
     * @return 最小分数,分数要大于等于此值
     */
    public Integer getMinScore() {
        return minScore;
    }

    /**
     * @param minScore 
	 *            最小分数,分数要大于等于此值
     */
    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    /**
     * @return 最大分数，分数要小于此值
     */
    public Integer getMaxScore() {
        return maxScore;
    }

    /**
     * @param maxScore 
	 *            最大分数，分数要小于此值
     */
    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    /**
     * @return 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon 
	 *            图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}