/**
 * 
 * SelectBidWinMakeMatchBondRewardReturnVO.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.vo;

import java.util.List;

/**
 * @author john huang
 * 2015年12月11日 下午1:40:56
 * 本类主要做为 定标时资金帐户 撮合保证金处理后返回的结果
 */
public class SelectBidWinMakeMatchBondRewardReturnVO  {

	/**
	 * 错误号
	 */
	protected int errcode=0;
	
	/**
	 * 信息
	 */
	protected String errmsg;
	
	/**
	 * 中标的撮合保证金转移到平台返回结果
	 */
	SelectBidWinMakeMatchBondRewardReturnBodyVO result;
	/**
	 * 错误号 
	 */
	public int getErrcode() {
		return errcode;
	}

	/**
	 * 错误号 
	 */
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	/**
	 * 信息 
	 */
	public String getErrmsg() {
		return errmsg;
	}

	/**
	 * 信息 
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	/**
	 * 中标的撮合保证金转移到平台返回结果 
	 */
	public SelectBidWinMakeMatchBondRewardReturnBodyVO getResult() {
		return result;
	}

	/**
	 * 中标的撮合保证金转移到平台返回结果 
	 */
	public void setResult(SelectBidWinMakeMatchBondRewardReturnBodyVO result) {
		this.result = result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SelectBidWinMakeMatchBondRewardReturnVO [errcode=" + errcode + ", errmsg=" + errmsg + ", result="
				+ result + "]";
	}


	
	
	
	
}
