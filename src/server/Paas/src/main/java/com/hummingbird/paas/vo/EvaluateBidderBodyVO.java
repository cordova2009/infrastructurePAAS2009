package com.hummingbird.paas.vo;

import java.util.Arrays;
import java.util.List;

public class EvaluateBidderBodyVO {
	/*"body":
    {
        "token":"4543gjh7h99",
        "objectId":"BH2015090887",
        "evaluateScore":7,
        "tags":["速度够快","质量很高"],
        "evaluateContent":"合作愉快，期待下次继续！"
    }*/
	private String token;
	private String objectId;
	private String evaluateContent;
	private Integer evaluateScore;
	private String[] tags;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @return the objectId
	 */
	public String getObjectId() {
		return objectId;
	}
	/**
	 * @return the evaluateContent
	 */
	public String getEvaluateContent() {
		return evaluateContent;
	}
	/**
	 * @return the evaluateScore
	 */
	public Integer getEvaluateScore() {
		return evaluateScore;
	}
	/**
	 * @return the tags
	 */
	public String[] getTags() {
		return tags;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @param objectId the objectId to set
	 */
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	/**
	 * @param evaluateContent the evaluateContent to set
	 */
	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}
	/**
	 * @param evaluateScore the evaluateScore to set
	 */
	public void setEvaluateScore(Integer evaluateScore) {
		this.evaluateScore = evaluateScore;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EvaluateBidderBodyVO [token=" + token + ", objectId=" + objectId + ", evaluateContent="
				+ evaluateContent + ", evaluateScore=" + evaluateScore + ", tags=" + Arrays.toString(tags) + "]";
	}
	
	
}
