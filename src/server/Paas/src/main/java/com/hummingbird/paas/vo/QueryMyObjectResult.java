package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询首页中标项目列表接口 结果输出 VO
 */
public class QueryMyObjectResult
{
    
//	"list":[{
//        "objectName":"OBJECT_NAME",
//        "objectId":"OBJECT_ID"
//        "bideeName":"中标公司简称",
//        "biderName":"招标公司简称",
//        "winBidAmount":"30000000.00"
//    }]
  protected String objectId;
  protected String objectName;
  protected String bideeName;
  protected String biderName;
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
 * @return the bideeName
 */
public String getBideeName() {
	return bideeName;
}
/**
 * @return the biderName
 */
public String getBiderName() {
	return biderName;
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
 * @param bideeName the bideeName to set
 */
public void setBideeName(String bideeName) {
	this.bideeName = bideeName;
}
/**
 * @param biderName the biderName to set
 */
public void setBiderName(String biderName) {
	this.biderName = biderName;
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
	return "QueryBidIndexListResult [objectId=" + objectId + ", objectName=" + objectName + ", bideeName=" + bideeName
			+ ", biderName=" + biderName + ", winBidAmount=" + winBidAmount + "]";
}
  
    

}