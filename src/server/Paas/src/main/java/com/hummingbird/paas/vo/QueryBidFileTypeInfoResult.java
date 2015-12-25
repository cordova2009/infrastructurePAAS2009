package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标项目投标文件接口 结果输出 VO
 */
public class QueryBidFileTypeInfoResult extends AbstractBidFileTypeInfo
{
    
	    /**
	     * 招标文件
	     */
	    protected String tenderFile;
	
	public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

	/**
	 * 招标文件 
	 */
	public String getTenderFile() {
		return tenderFile;
	}

	/**
	 * 招标文件 
	 */
	public void setTenderFile(String tenderFile) {
		this.tenderFile = tenderFile;
	}

    

}