/**
 * 
 * PaasIniter.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.capital.util;

import java.util.Map;

import com.hummingbird.capital.listener.HandleEventListener;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.ext.AppIniter;

/**
 * @author YJY
 * 2015年12月20日11:21:05
 * 本类主要做为
 */
public class CapitalIniter implements AppIniter{

	/* (non-Javadoc)
	 * @see com.hummingbird.common.ext.AppIniter#init(java.util.Map)
	 */
	@Override
	public void init(Map param) {
		EventListenerContainer.getInstance().addMyListener(new HandleEventListener());
		
	}

}
