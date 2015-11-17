package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.PagingnationVO;

/**
 * 消息列表
 * @author YJY
 * @since 2015年10月29日15:00:01
 * */
public class AnnouncementListBodyVO extends PagingnationVO{
	
	public AnnouncementListBodyVO() {
		
	}
	private Integer creator;
    private String status;
    private Date startTime;
    private Date endTime;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

    
	/*@Override
	public String toString() {
		return " ActivityJoinBodyVO [activityId=" + activityId + ", unionId=" + unionId +"]";
	}*/
}
