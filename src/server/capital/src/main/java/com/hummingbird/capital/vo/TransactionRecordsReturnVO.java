package com.hummingbird.capital.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class TransactionRecordsReturnVO{
	/*"list":[{
        "time":"2015-09-19 08:21:12",
        "type":"TEE",
        "income":"10000.00",
        "outlay":"0.00",
        "balance":"2000.00",
        "remark":"xxxx"
    }]*/
	private String time;
	private String type;
	private String income;
	private String outlay;
	private String balance;
	private String remark;
	
	@Override
	public String toString() {
		return "TransactionRecordsReturnVO [time=" + time + ", type=" + type +
				",income=" + income +",outlay="+outlay+ 
				",balance="+balance+",remark+"+remark+"]";
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
