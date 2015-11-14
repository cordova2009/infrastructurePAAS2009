package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * saveObjectMethodInfo 在body VO
 */
public class InviteTenderVO 
implements PainttextAble {
    
	/**
     * 投标人
     */
    private Integer bidderId;

    
    /**
     * 投标人名称 
     */
    private String bidderName;

		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(String.valueOf(bidderId),bidderName
					 				);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}


	/**
	 * 投标人 
	 */
	public Integer getBidderId() {
		return bidderId;
	}


	/**
	 * 投标人 
	 */
	public void setBidderId(Integer bidderId) {
		this.bidderId = bidderId;
	}


	/**
	 * 投标人名称 
	 */
	public String getBidderName() {
		return bidderName;
	}


	/**
	 * 投标人名称 
	 */
	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

    

}