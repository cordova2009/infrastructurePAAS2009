package com.hummingbird.paas.vo;

public class WillPayAmountDetailReturnVO {
	/*"list":[{
        "fundName":"第六期",
        "amount":"40,000.00",
        "startDate":"2015-12-12",
        "endDate":"2015-12-22",
    }]*/
	private String fundName;
	private String amount;
	private String startDate;
	private String endDate;
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
