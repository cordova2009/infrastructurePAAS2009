package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

/**
 * 消息详细
 * @author YJY  
 * @since 2015年10月29日15:00:01
 * */
public class AnnouncementUpdateVO extends AppBaseVO implements Decidable{
	private AnnouncementUpdateBodyVO body;

	public AnnouncementUpdateBodyVO getBody() {
		return body;
	}

	public void setBody(AnnouncementUpdateBodyVO body) {
		this.body = body;
	}

	

    
	@Override
	public String toString() {
		return " AnnouncementUpdateVO [body=" + body + ", app=" + app +"]";
	}
}
