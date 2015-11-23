package com.hummingbird.paas.vo;

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
	private List<String> tags;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getEvaluateContent() {
		return evaluateContent;
	}
	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}
	public Integer getEvaluateScore() {
		return evaluateScore;
	}
	public void setEvaluateScore(Integer evaluateScore) {
		this.evaluateScore = evaluateScore;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
}
