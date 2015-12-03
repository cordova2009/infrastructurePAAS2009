package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

/**
 * 查看我的发布信息详情接口 
 * @author YJY  
 * @since 2015年11月10日16:21:54
 * @see 用于规范json
 * */

//"result":{
//    "status":"OK#",
//    "objectAmount":"3000万",
//    "informationId":1,
//    "district":"广州市",
//    "objectName":"项目名称",
//    "employer":"甲方xxxxxx",
//    "phase":"招标阶段",
//    "projectPeriod":"半年",
//    "projectSituation":"本项目主要是xxxx",
//    "address":"xx路666号",
//    "userName":"用户名",
//    "comments":[
//        {"replier":12,"replierName":"王大力","replyContent:"好","replyTime":"2015-01-01 01:01:01"},
//        {"replier":13,"replierName":"王大力a","replyContent:"好","replyTime":"2015-01-01 01:01:01"},
//    ]
//
//
//}
public class UserInformationDetailWithCommentsReturnVO extends UserInformationCommonVO{
	
	private String   status;
	private String   userName;
	private List<UserInformationComments>   comments;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @return the comments
	 */
	public List<UserInformationComments> getComments() {
		return comments;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<UserInformationComments> comments) {
		this.comments = comments;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInformationDetailWithCommentsReturnVO [status=" + status + ", userName=" + userName + ", comments="
				+ comments + "]";
	}

	
	



}
