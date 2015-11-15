package com.hummingbird.paas.vo;

public class GetSiteNewsListResultVO  {
    private Integer id;
    private String title;
    private String createTime;
    private String contentUrl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	@Override
	public String toString() {
		return "GetSiteNewsListResultVO [id=" + id + ", title=" + title + ", createTime=" + createTime + ", contentUrl="
				+ contentUrl + "]";
	}
}
