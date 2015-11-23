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
	private String[] keywords;

	/**
	 * @return the keywords
	 */
	public String[] getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderObjectBodyVO [keywords=" + Arrays.toString(keywords) + "]";
	}

	


}
