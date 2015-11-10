package com.hummingbird.paas.vo;

import java.util.List;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

public class BankInfoReturnVO extends AppBaseVO implements Decidable{
	/*"bankInfo":[{
        "bankId":"BANK_ID", 
        "bank":"招商银行深圳支行",
        "accountId":"1234567812345678",
        "accountName":"深圳麦圈互动技术有限公司"
    },
    {
        "bankId":"BANK_ID", 
        "bank":"招商银行深圳支行",
        "accountId":"1234567812345678",
        "accountName":"深圳麦圈互动技术有限公司"
    }]*/
	private List<BankInfoReturnDetailVO> bankInfo;

	public List<BankInfoReturnDetailVO> getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(List<BankInfoReturnDetailVO> bankInfo) {
		this.bankInfo = bankInfo;
	}
	@Override
	public String toString() {
		return "BankInfoReturnVO [bankInfo=" + bankInfo + ", app="
				+ app + "]";
	}
	
}
