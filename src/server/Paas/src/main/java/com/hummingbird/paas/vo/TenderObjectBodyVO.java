package com.hummingbird.paas.vo;

import java.util.Arrays;
import java.util.Date;

import com.hummingbird.commonbiz.vo.PagingnationVO;

/**
 * 查询招标项目接口
 * @author YJY  
 * @since 2015年11月14日19:21:15
 * */
public class TenderObjectBodyVO extends PagingnationVO {
//	 "keywords":[{"keyword":"投标"},{"keyword":"深圳"}]
//		        "pageIndex":0,
//		        "pageSize":10
	private String[] keyword;

	/**
	 * @return the keyword
	 */
	public String[] getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String[] keyword) {
		this.keyword = keyword;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderObjectBodyVO [keyword=" + Arrays.toString(keyword) + "]";
	}
	


}
