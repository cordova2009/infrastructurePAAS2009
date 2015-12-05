package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 证书信息  
 * @author YJY  
 * @since 2015年12月4日15:28:30
 * @see 用于规范json
 * */

//"bidInfo":{
//    "tenderNum":5,
//    "bidNum":4,
//    "flowNum":5,
//    "winNum":6
//    "onTimeNum":5
//    "outTimeNum":2
//}
public class CompanyBidInfo {
	
	private Integer  tenderNum;
	private Integer  bidNum;
	private Integer  flowNum;
	private Integer  winNum;
	private Integer  onTimeNum;
	private Integer  outTimeNum;
	
	/**
	 * @return the tenderNum
	 */
	public Integer getTenderNum() {
		return tenderNum;
	}
	/**
	 * @return the bidNum
	 */
	public Integer getBidNum() {
		return bidNum;
	}
	/**
	 * @return the flowNum
	 */
	public Integer getFlowNum() {
		return flowNum;
	}
	/**
	 * @return the winNum
	 */
	public Integer getWinNum() {
		return winNum;
	}
	/**
	 * @return the onTimeNum
	 */
	public Integer getOnTimeNum() {
		return onTimeNum;
	}
	/**
	 * @return the outTimeNum
	 */
	public Integer getOutTimeNum() {
		return outTimeNum;
	}
	/**
	 * @param tenderNum the tenderNum to set
	 */
	public void setTenderNum(Integer tenderNum) {
		this.tenderNum = tenderNum;
	}
	/**
	 * @param bidNum the bidNum to set
	 */
	public void setBidNum(Integer bidNum) {
		this.bidNum = bidNum;
	}
	/**
	 * @param flowNum the flowNum to set
	 */
	public void setFlowNum(Integer flowNum) {
		this.flowNum = flowNum;
	}
	/**
	 * @param winNum the winNum to set
	 */
	public void setWinNum(Integer winNum) {
		this.winNum = winNum;
	}
	/**
	 * @param onTimeNum the onTimeNum to set
	 */
	public void setOnTimeNum(Integer onTimeNum) {
		this.onTimeNum = onTimeNum;
	}
	/**
	 * @param outTimeNum the outTimeNum to set
	 */
	public void setOutTimeNum(Integer outTimeNum) {
		this.outTimeNum = outTimeNum;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompanyBidInfo [tenderNum=" + tenderNum + ", bidNum=" + bidNum + ", flowNum=" + flowNum + ", winNum="
				+ winNum + ", onTimeNum=" + onTimeNum + ", outTimeNum=" + outTimeNum + "]";
	}
	

	

}
