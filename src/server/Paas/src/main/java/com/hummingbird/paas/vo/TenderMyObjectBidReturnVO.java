package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hummingbird.common.util.convertor.JacksonDateSerializer;
import com.hummingbird.common.util.convertor.JacksonDateTimeSerializer;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年11月11日22:12:08
 * */
public class TenderMyObjectBidReturnVO {
//    "list":[{
//        "bidId":"4535264477",
//        "bidderCompanyName":"蜂鸟娱乐",
//        "bidderId":"4536789",
//        "bidTime":"2015-06-25 11:35:23",
//        "bidAmount":5000000,
//        "projectExpectStartDate":"2015-06-12",
//        "projectExpectPeriod":300
//        "fileUrl":"URL",
//        "certificationList":[{
//            "certificationId":1,
//            "certificationName":"一级建造师"
//        }]
//    }]
	private Integer bidId;
	private String  bidderCompanyName;
	private Integer bidderId;
	private Date bidTime;
	
	private Integer bidAmount;
	private Date  projectExpectStartDate;
	private Integer projectExpectPeriod;
	private String fileUrl;
	List<TenderCertificationReturnVO> certificationList;
	/**
	 * @return the bidId
	 */
	public Integer getBidId() {
		return bidId;
	}
	/**
	 * @return the bidderCompanyName
	 */
	public String getBidderCompanyName() {
		return bidderCompanyName;
	}
	/**
	 * @return the bidderId
	 */
	public Integer getBidderId() {
		return bidderId;
	}
	/**
	 * @return the bidTime
	 */
	@JsonSerialize(using = JacksonDateTimeSerializer.class)
	public Date getBidTime() {
		return bidTime;
	}
	/**
	 * @return the bidAmount
	 */
	public Integer getBidAmount() {
		return bidAmount;
	}
	/**
	 * @return the projectExpectStartDate
	 */
	@JsonSerialize(using = JacksonDateSerializer.class)
	public Date getProjectExpectStartDate() {
		return projectExpectStartDate;
	}
	/**
	 * @return the projectExpectPeriod
	 */
	public Integer getProjectExpectPeriod() {
		return projectExpectPeriod;
	}
	/**
	 * @return the fileUrl
	 */
	public String getFileUrl() {
		return fileUrl;
	}
	/**
	 * @return the certificationList
	 */
	public List<TenderCertificationReturnVO> getCertificationList() {
		return certificationList;
	}
	/**
	 * @param bidId the bidId to set
	 */
	public void setBidId(Integer bidId) {
		this.bidId = bidId;
	}
	/**
	 * @param bidderCompanyName the bidderCompanyName to set
	 */
	public void setBidderCompanyName(String bidderCompanyName) {
		this.bidderCompanyName = bidderCompanyName;
	}
	/**
	 * @param bidderId the bidderId to set
	 */
	public void setBidderId(Integer bidderId) {
		this.bidderId = bidderId;
	}
	/**
	 * @param bidTime the bidTime to set
	 */
	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}
	/**
	 * @param bidAmount the bidAmount to set
	 */
	public void setBidAmount(Integer bidAmount) {
		this.bidAmount = bidAmount;
	}
	/**
	 * @param projectExpectStartDate the projectExpectStartDate to set
	 */
	public void setProjectExpectStartDate(Date projectExpectStartDate) {
		this.projectExpectStartDate = projectExpectStartDate;
	}
	/**
	 * @param projectExpectPeriod the projectExpectPeriod to set
	 */
	public void setProjectExpectPeriod(Integer projectExpectPeriod) {
		this.projectExpectPeriod = projectExpectPeriod;
	}
	/**
	 * @param fileUrl the fileUrl to set
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	/**
	 * @param certificationList the certificationList to set
	 */
	public void setCertificationList(List<TenderCertificationReturnVO> certificationList) {
		this.certificationList = certificationList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderMyObjectBidReturnVO [bidId=" + bidId + ", bidderCompanyName=" + bidderCompanyName + ", bidderId="
				+ bidderId + ", bidTime=" + bidTime + ", bidAmount=" + bidAmount + ", projectExpectStartDate="
				+ projectExpectStartDate + ", projectExpectPeriod=" + projectExpectPeriod + ", fileUrl=" + fileUrl
				+ ", certificationList=" + certificationList + "]";
	}
	


}
