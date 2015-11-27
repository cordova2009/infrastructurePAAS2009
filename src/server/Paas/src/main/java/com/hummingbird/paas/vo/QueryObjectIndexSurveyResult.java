package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询首页招标项目概况接口  结果输出 VO
 */
public class QueryObjectIndexSurveyResult
{
    
//	"info":{
//    "objectNum":35,
//    "amount":"45647689.00"
//}
  protected Integer objectNum;
  protected Long amount;
  
	/**
	 * @return the objectNum
	 */
	public Integer getObjectNum() {
		return objectNum;
	}
	/**
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}
	/**
	 * @param objectNum the objectNum to set
	 */
	public void setObjectNum(Integer objectNum) {
		this.objectNum = objectNum;
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
		return "QueryObjectIndexSurveyResult [objectNum=" + objectNum + ", amount=" + amount + "]";
	}
	  

	

}