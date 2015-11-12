package com.hummingbird.paas.vo;

import com.hummingbird.paas.entity.ProjectAccount;

public class CapitalSurveyReturnVO {
	/*"myCapitalInfo":{
	    "balance":"100000.00",
	    "freezeAmount":"90000.00",
	    "income":"50000.00",
	    "outlay":"60000.00"
	}*/
	private String balance;
	private String freezeAmount;
	private String income;
	private String outlay;
	
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getFreezeAmount() {
		return freezeAmount;
	}
	public void setFreezeAmount(String freezeAmount) {
		this.freezeAmount = freezeAmount;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getOutlay() {
		return outlay;
	}
	public void setOutlay(String outlay) {
		this.outlay = outlay;
	}
	
}
