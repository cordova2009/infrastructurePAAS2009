package com.hummingbird.paas.entity;

import java.util.Date;

/**
 * 工程信息表,工程由标的中标后转化而来,本类带有中标金额
 */
public class ProjectInfoWithObjectAmount extends ProjectInfo {
    /**
     * 项目金额
     */
    private Long objectAmount;
    
    /**
     * 项目名称
     */
    private String objectName;

	/**
	 * 项目金额 
	 */
	public Long getObjectAmount() {
		return objectAmount;
	}

	/**
	 * 项目金额 
	 */
	public void setObjectAmount(Long objectAmount) {
		this.objectAmount = objectAmount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectInfoWithObjectAmount [objectAmount=" + objectAmount + ", projectId=" + projectId + ", objectId="
				+ objectId + ", bidderId=" + bidderId + ", status=" + status + ", biddeeId=" + biddeeId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", projectName=" + projectName + "]";
	}

	/**
	 * 项目名称 
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * 项目名称 
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
    
    

    
}