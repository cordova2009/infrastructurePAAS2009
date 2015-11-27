/**
 * 
 * AlipayNotificationResponse.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.payment.vo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.hummingbird.commonbiz.face.NotificationResponse;
import com.hummingbird.commonbiz.face.NotificationResponsor;
import com.hummingbird.commonbiz.vo.HttpResponseWapper;

/**
 * @author john huang
 * 2015年4月1日 下午11:01:58
 * 本类主要做为
 */
public class AlipayNotificationResponse implements NotificationResponse{

	
	boolean successed;

	/**
	 * @return the successed
	 */
	public boolean isSuccessed() {
		return successed;
	}

	/**
	 * @param successed the successed to set
	 */
	public void setSuccessed(boolean successed) {
		this.successed = successed;
	}

	/* (non-Javadoc)
	 * @see com.hummingbird.commonbiz.face.NotificationResponse#doReply(com.hummingbird.commonbiz.face.NotificationResponsor)
	 */
	@Override
	public Object doReply(NotificationResponsor responsor) {
		if (responsor instanceof HttpResponseWapper) {
			HttpResponseWapper responsewapper = (HttpResponseWapper) responsor;
			HttpServletResponse response = responsewapper.getResponse();
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.write(successed?"success":"fail");
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
}
