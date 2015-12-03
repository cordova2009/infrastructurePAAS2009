package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 查看我的发布信息详情接口 
 * @author YJY  
 * @since 2015年11月10日16:21:54
 * @see 用于规范json
 * */

//"body":{
//    "token":"12345",
//    "objectAmount":"3000万",
//    "informationId":1,
//    "district":"广州市",
//    "objectName":"项目名称",
//    "employer":"甲方xxxxxx",
//    "phase":"招标阶段",
//    "projectPeriod":"半年",
//    "projectSituation":"本项目主要是xxxx",
//    "address":"xx路666号"
//}
public class UserInformationDetailReturnVO extends UserInformationCommonVO{
	
	private String   status;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInformationDetailReturnVO [status=" + status + "]";
	}

	
	



}
