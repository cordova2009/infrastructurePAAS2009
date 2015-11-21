package com.hummingbird.paas.vo;

public class WithdrawalsApplyBodyVO {
	 /*"body":{
            "token":"USER_TOKEN",
            "amount":100000,
            "bankId":"BANK_ID",
            "tradePassword":"TRADE_PASSWORD"
        }*/
	private String token;
	private Integer amount;
	private Integer bankId;
	private String tradePassword;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getTradePassword() {
		return tradePassword;
	}
	public void setTradePassword(String tradePassword) {
		this.tradePassword = tradePassword;
	}
	
}
