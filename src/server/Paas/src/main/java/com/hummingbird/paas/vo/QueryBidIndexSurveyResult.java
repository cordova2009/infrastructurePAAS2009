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
  protected String bidNum;
  protected String amount;
/**
 * @return the bidNum
 */
public String getBidNum() {
	return bidNum;
}
/**
 * @return the amount
 */
public String getAmount() {
	return amount;
}
/**
 * @param bidNum the bidNum to set
 */
public void setBidNum(String bidNum) {
	this.bidNum = bidNum;
}
/**
 * @param amount the amount to set
 */
public void setAmount(String amount) {
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