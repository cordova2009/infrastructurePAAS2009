package com.hummingbird.paas.vo;

import java.util.Date;
import org.apache.commons.lang.ObjectUtils;

import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.common.vo.PainttextAble;

/**
 * 保存招标评标方式接口 在body VO
 */
public class SaveBidEvaluationTypeInfoBodyVO 
implements PainttextAble {
    
	    	/**
	     * 
	     */
	    protected String token;
	    	/**
	     * 招标项目内部编号
	     */
	    protected String objectId;
	    	/**
	     * 评标方法及标准,QLT,定性.CRE,信用商户评价.OVE,综合评估
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
	    public String getToken() {
	        return token;
	    }
	
	    /**
	     * @param 
	     */
	    public void setToken(String token) {
	        this.token = token;
	    }
	    	/**
	     * @return 招标项目内部编号
	     */
	    public String getObjectId() {
	        return objectId;
	    }
	
	    /**
	     * @param 招标项目内部编号
	     */
	    public void setObjectId(String objectId) {
	        this.objectId = objectId;
	    }
	    	/**
	     * @return 评标方法及标准,QLT,定性.CRE,信用商户评价.OVE,综合评估
	     */
	    public String getBidEvaluationType() {
	        return bidEvaluationType;
	    }
	
	    /**
	     * @param 评标方法及标准,QLT,定性.CRE,信用商户评价.OVE,综合评估
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
		
	/**
	 * 生成文本组装内容
	 * @return
	 */
	public String getPaintText(){
		String pt = ValidateUtil.sortbyValues(
					ObjectUtils.toString(token) , 					ObjectUtils.toString(objectId) , 					ObjectUtils.toString(bidEvaluationType) , 					ObjectUtils.toString(bidEvaluationSite) , 					ObjectUtils.toString(bidWinnerDetermineWay) , 					ObjectUtils.toString(voteWinWay) 				);
		return pt;
	}
	

    public String toString() {
		return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this);
	}

    

}