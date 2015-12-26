/**
 * 
 * DuplicateMessageEventListener.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.payment.event;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.hummingbird.common.event.AbstractBusinessEventListener;
import com.hummingbird.common.event.BusinessEvent;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.http.HttpRequester;

/**
 * @author john huang
 * 2015年12月26日 下午12:40:13
 * 本类主要做为 复制消息处理器,主要用于分发
 */
public class DuplicateMessageEventListener extends AbstractBusinessEventListener {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	/* (non-Javadoc)
	 * @see com.hummingbird.common.event.BusinessEventListener#handleEvent(com.hummingbird.common.event.BusinessEvent)
	 */
	@Override
	public void handleEvent(BusinessEvent arg0) {
		if (arg0 instanceof DuplicateMessageEvent) {
			DuplicateMessageEvent event = (DuplicateMessageEvent) arg0;
			
			PropertiesUtil pu = new PropertiesUtil();
			String duplicate_message_addresses = pu.getProperty("duplicate.message.addresses");
			String[] dmadds = StringUtils.split(duplicate_message_addresses,",");
			for (int i = 0; i < dmadds.length; i++) {
				String targetAddress = dmadds[i];
				sendMessage(targetAddress,event);
			}
			
		}
		
	}

	/**
	 * 发送消息
	 * @param targetAddress
	 * @param event 
	 */
	private void sendMessage(String targetAddress, DuplicateMessageEvent event) {
		String qs = event.getQueryString();
		if(StringUtils.isNotBlank(qs)){
			if(!targetAddress.endsWith("?")){
				targetAddress=targetAddress+"?";
			}
			targetAddress=targetAddress+qs;
			
		}
		
		if (log.isDebugEnabled()) {
			log.debug(("支付宝复制消息通知:"+targetAddress));
		}
		//目前以post的模式
		String sendPost = new HttpRequester().sendPost(targetAddress, new HashMap());
		if (log.isDebugEnabled()) {
			log.debug(("支付宝复制消息通知结果"+sendPost));
		}
	}

}
