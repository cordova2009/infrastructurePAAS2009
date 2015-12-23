/**
 * 
 * SaveBidEvalutionResultVO.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.vo;

import java.util.ArrayList;
import java.util.List;

import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.entity.Bidder;

/**
 * @author john huang
 * 2015年12月11日 下午6:26:56
 * 本类主要做为 定标后的结果输出
 */
public class SaveBidEvalutionResultVO {

	/**
	 * 中标投标人
	 */
	Integer windidder;
	
	/**
	 * 不中标投标人
	 */
	List<Integer> loseBidders = new ArrayList<Integer>();
	
	/**
	 * 标的
	 */
	BidObject object;

	/**
	 * 中标投标人 
	 */
	public Integer getWindidder() {
		return windidder;
	}

	/**
	 * 中标投标人 
	 */
	public void setWindidder(Integer windidder) {
		this.windidder = windidder;
	}

	/**
	 * 不中标投标人 
	 */
	public List<Integer> getLoseBidders() {
		return loseBidders;
	}

	/**
	 * 不中标投标人 
	 */
	public void setLoseBidders(List<Integer> loseBidders) {
		this.loseBidders = loseBidders;
	}
	
	/**
	 * 添加失败的投标人
	 * @param bidder
	 */
	public void addLoseBidder(Integer bidder){
		loseBidders.add(bidder);
	}

	/**
	 * 标的 
	 */
	public BidObject getObject() {
		return object;
	}

	/**
	 * 标的 
	 */
	public void setObject(BidObject object) {
		this.object = object;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SaveBidEvalutionResultVO [windidder=" + windidder + ", loseBidders=" + loseBidders + ", object="
				+ object + "]";
	}
	
}
