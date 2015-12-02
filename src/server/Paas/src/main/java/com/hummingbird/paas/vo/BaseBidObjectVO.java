package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.PagingnationVO;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年11月11日22:12:08
 * */
public class BaseBidObjectVO extends PagingnationVO {
	
	/**
	 * 项目名称
	 */
	private String projectName;
	
	/**
	 * 发布时间,几天之前
	 */
	private Integer publishTime;
	
	
	public  BaseBidObjectVO(){
		
	}


	/**
	 * 项目名称 
	 */
	public String getProjectName() {
		return projectName;
	}


	/**
	 * 项目名称 
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	/**
	 * 发布时间几天之前 
	 */
	public Integer getPublishTime() {
		return publishTime;
	}


	/**
	 * 发布时间几天之前 
	 */
	public void setPublishTime(Integer publishTime) {
		this.publishTime = publishTime;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseBidObjectVO [projectName=" + projectName + ", publishTime=" + publishTime + "]";
	}
}
