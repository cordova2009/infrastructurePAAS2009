package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年10月29日15:00:01
 * */
public class SmsUpdateVO extends AppBaseVO implements Decidable{
	private SmsUpdateBodyVO body;


	public SmsUpdateBodyVO getBody() {
		return body;
	}


	public void setBody(SmsUpdateBodyVO body) {
		this.body = body;
	}
	

    
	@Override
	public String toString() {
		return " SmsUpdateVO [body=" + body + ", app=" + app +"]";
	}


}
