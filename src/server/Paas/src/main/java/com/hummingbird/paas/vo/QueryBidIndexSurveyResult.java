package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询首页中标结果概况接口  结果输出 VO
 */
public class QueryBidIndexSurveyResult
{
    
//	"info":{
//    "bidNum":35,
//    "amount":"45647689.00"
//}
  protected Integer bidNum;
  protected Long amount;
  
	/**
	 * @return the bidNum
	 */
	public Integer getBidNum() {
		return bidNum;
	}
	/**
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}
	/**
	 * @param bidNum the bidNum to set
	 */
	public void setBidNum(Integer bidNum) {
		this.bidNum = bidNum;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryBidIndexSurveyResult [bidNum=" + bidNum + ", amount=" + amount + "]";
	}
	  

}