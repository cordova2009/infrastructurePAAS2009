package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.common.face.Pagingnation;
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
	/**
	 * 取最新的记录
	 */
	private Integer size;
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
	/**
	 * 取最新的记录 
	 */
	public Integer getSize() {
		return size;
	}
	/**
	 * 取最新的记录 
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
	
	/**
	 * 分页组件
	 * @return
	 */
	public Pagingnation toPagingnation(){
		if(size!=null&&size>0){
			pageSize = size;
		}
		if(pageIndex<=0){
			pageIndex=1;
		}
		if(pageSize<=0){
			pageSize=10;
		}
		if(pageSize>500){
			pageSize=500;
		}
		return  new Pagingnation(pageIndex, pageSize);
	}

}
