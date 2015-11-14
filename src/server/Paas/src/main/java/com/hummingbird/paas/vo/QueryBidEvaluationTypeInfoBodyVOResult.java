package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;


/**
 * 查询未完成招标评标方式接口 结果输出 VO
 */
public class QueryBidEvaluationTypeInfoBodyVOResult
{
    
	    	/**
	     * 
	     */
	    protected String bidEvaluationType;
	    	/**
	     * 技术标评标地点
	     */
	    protected String bidEvaluationSite;
	    	/**
	     * 中标人的确定方法.ORV,直接票决定标.MRV 逐轮票决定标,VDM 票决筹钱定标
	     */
	    protected String bidWinnerDetermineWay;
	    	/**
	     * 票决方式,SMP,简单铎书法。CPN,对比胜出法
	     */
	    protected String voteWinWay;
	
	    	/**
	     * @return 
	     */
	    public String getBidEvaluationType() {
	        return bidEvaluationType;
	    }
	
	    /**
	     * @param 
	     */
	    public void setBidEvaluationType(String bidEvaluationType) {
	        this.bidEvaluationType = bidEvaluationType;
	    }
	    	/**
	     * @return 技术标评标地点
	     */
	    public String getBidEvaluationSite() {
	        return bidEvaluationSite;
	    }
	
	    /**
	     * @param 技术标评标地点
	     */
	    public void setBidEvaluationSite(String bidEvaluationSite) {
	        this.bidEvaluationSite = bidEvaluationSite;
	    }
	    	/**
	     * @return 中标人的确定方法.ORV,直接票决定标.MRV 逐轮票决定标,VDM 票决筹钱定标
	     */
	    public String getBidWinnerDetermineWay() {
	        return bidWinnerDetermineWay;
	    }
	
	    /**
	     * @param 中标人的确定方法.ORV,直接票决定标.MRV 逐轮票决定标,VDM 票决筹钱定标
	     */
	    public void setBidWinnerDetermineWay(String bidWinnerDetermineWay) {
	        this.bidWinnerDetermineWay = bidWinnerDetermineWay;
	    }
	    	/**
	     * @return 票决方式,SMP,简单铎书法。CPN,对比胜出法
	     */
	    public String getVoteWinWay() {
	        return voteWinWay;
	    }
	
	    /**
	     * @param 票决方式,SMP,简单铎书法。CPN,对比胜出法
	     */
	    public void setVoteWinWay(String voteWinWay) {
	        this.voteWinWay = voteWinWay;
	    }
		

	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}