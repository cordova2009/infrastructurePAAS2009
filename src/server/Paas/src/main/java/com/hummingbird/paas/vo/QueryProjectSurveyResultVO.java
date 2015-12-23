package com.hummingbird.paas.vo;

/**
 * @author panda
 * 2015年12月23日 上午11:15:52
 * 查询项目信息概况
 */
public class QueryProjectSurveyResultVO {
	
    //发布信息数
    private int publishedCount;
    
    //参与人数
    private int publishedManCount;
    
    
	public int getPublishedCount() {
		return publishedCount;
	}


	public void setPublishedCount(int publishedCount) {
		this.publishedCount = publishedCount;
	}


	public int getPublishedManCount() {
		return publishedManCount;
	}


	public void setPublishedManCount(int publishedManCount) {
		this.publishedManCount = publishedManCount;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryProjectSurveyResultVO [publishedCount=" + publishedCount + 
				", publishedManCount=" + publishedManCount + "]";
	}
	
	



}
