package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询首页中标项目列表接口 结果输出 VO
 */
public class QueryBidIndexListResult
{
    
//	"industryId":3,
//    "objectId":"32456",
//    "objectName":"7665",
//    "winBidAmount":"30000000",
//    "biddee":"麦圈互动"
  protected String objectId;
  protected String objectName;
  protected String industryId;
  protected String biddee;
  protected String winBidAmount;
/**
 * @return the objectId
 */
public String getObjectId() {
	return objectId;
}
/**
 * @return the objectName
 */
public String getObjectName() {
	return objectName;
}
/**
 * @return the industryId
 */
public String getIndustryId() {
	return industryId;
}
/**
 * @return the biddee
 */
public String getBiddee() {
	return biddee;
}
/**
 * @return the winBidAmount
 */
public String getWinBidAmount() {
	return winBidAmount;
}
/**
 * @param objectId the objectId to set
 */
public void setObjectId(String objectId) {
	this.objectId = objectId;
}
/**
 * @param objectName the objectName to set
 */
public void setObjectName(String objectName) {
	this.objectName = objectName;
}
/**
 * @param industryId the industryId to set
 */
public void setIndustryId(String industryId) {
	this.industryId = industryId;
}
/**
 * @param biddee the biddee to set
 */
public void setBiddee(String biddee) {
	this.biddee = biddee;
}
/**
 * @param winBidAmount the winBidAmount to set
 */
public void setWinBidAmount(String winBidAmount) {
	this.winBidAmount = winBidAmount;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "QueryBidIndexListResult [objectId=" + objectId + ", objectName=" + objectName + ", industryId=" + industryId
			+ ", biddee=" + biddee + ", winBidAmount=" + winBidAmount + "]";
}

    

}