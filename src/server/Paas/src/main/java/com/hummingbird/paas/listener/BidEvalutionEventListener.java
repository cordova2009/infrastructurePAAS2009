/**
 * 
 * BidEvalutionEventListener.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.listener;

import com.hummingbird.common.event.AbstractBusinessEventListener;
import com.hummingbird.common.event.BusinessEvent;
import com.hummingbird.paas.event.BidSelectedEvent;

/**
 * @author john huang
 * 2015年12月11日 下午6:45:45
 * 本类主要做为
 */
public class BidEvalutionEventListener extends AbstractBusinessEventListener {

	/* (non-Javadoc)
	 * @see com.hummingbird.common.event.BusinessEventListener#handleEvent(com.hummingbird.common.event.BusinessEvent)
	 */
	@Override
	public void handleEvent(BusinessEvent event) {
		if (event instanceof BidSelectedEvent) {
			BidSelectedEvent bse = (BidSelectedEvent) event;
			System.out.println("中标事件处理");
			
		}
		
	}

}
