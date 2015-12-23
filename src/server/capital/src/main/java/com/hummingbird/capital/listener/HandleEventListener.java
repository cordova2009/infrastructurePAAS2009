/**
 * 
 * BidEvalutionEventListener.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.capital.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.hummingbird.capital.entity.Bidder;
import com.hummingbird.capital.event.BidSelectedEvent;
import com.hummingbird.capital.event.ConfirmPayEvent;
import com.hummingbird.capital.event.projectPaymentWithdrawalsApplyEvent;
import com.hummingbird.capital.mapper.BidderMapper;
import com.hummingbird.capital.services.UserMsgService;
import com.hummingbird.capital.vo.UserMsgBodyVO;
import com.hummingbird.common.event.AbstractBusinessEventListener;
import com.hummingbird.common.event.BusinessEvent;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.util.SpringBeanUtil;

/**
 * @author john huang
 * 2015年12月11日 下午6:45:45
 * 本类主要做为  系统自动监听处理通知=信息类  
 */
public class HandleEventListener extends AbstractBusinessEventListener {

	@Autowired
	UserMsgService  umService;
	@Autowired
	BidderMapper  bidderDao;
	
	/* (non-Javadoc)
	 * @see com.hummingbird.common.event.BusinessEventListener#handleEvent(com.hummingbird.common.event.BusinessEvent)
	 */ 
	@Override
	public void handleEvent(BusinessEvent event) {
		try {
//			add by YJY 2015-12-19 添加中标  邀标   付款  提现 充值  以及付款超时提醒
			UserMsgService  umService = (UserMsgService)SpringBeanUtil.getInstance().getBean(UserMsgService.class);
			BidderMapper  bidderDao = (BidderMapper)SpringBeanUtil.getInstance().getBean(BidderMapper.class);
			
				if (event instanceof BidSelectedEvent) {
					BidSelectedEvent bse = (BidSelectedEvent) event;
					System.out.println("中标事件处理");
					UserMsgBodyVO info = new UserMsgBodyVO();
					info.setMsgContent("恭喜您在招标【"+bse.getObjectId()+"】项目中中标了");
					info.setMsgTitle("中标通知");
					info.setMsgType("PRI");
					Bidder bidder = bidderDao.selectByPrimaryKey(bse.getBidderId());
					if(bidder != null){
						info.setUserId(bidder.getUserId());
						umService.addMsg(info);
					}
					
					
				}else if (event instanceof projectPaymentWithdrawalsApplyEvent) {
					projectPaymentWithdrawalsApplyEvent inv = (projectPaymentWithdrawalsApplyEvent) event;
					System.out.println("工程提现事件处理");
					if(inv!= null){
						if("STA".equalsIgnoreCase(inv.getStatus())){
							UserMsgBodyVO info = new UserMsgBodyVO();
							info.setMsgContent("您有一笔【"+inv.getAmount()+"】元的提现申请");
							info.setMsgTitle("工程提现通知");
							info.setMsgType("PRI");
							if(inv.getBidderId() != null){
								info.setUserId(inv.getBidderId());
								umService.addMsg(info);
							}
						}else if("OK#".equalsIgnoreCase(inv.getStatus())){
							UserMsgBodyVO info = new UserMsgBodyVO();
							info.setMsgContent("您有一笔【"+inv.getAmount()+"】元的提现成功");
							info.setMsgTitle("工程提现通知");
							info.setMsgType("PRI");
							if(inv.getBidderId() != null){
								info.setUserId(inv.getBidderId());
								umService.addMsg(info);
							}
						}else if("FLS".equalsIgnoreCase(inv.getStatus())){
							UserMsgBodyVO info = new UserMsgBodyVO();
							info.setMsgContent("您有一笔【"+inv.getAmount()+"】元的提现失败");
							info.setMsgTitle("工程提现通知");
							info.setMsgType("PRI");
							if(inv.getBidderId() != null){
								info.setUserId(inv.getBidderId());
								umService.addMsg(info);
							}
						}
						
					}
					
					
				}else if (event instanceof ConfirmPayEvent) {
					ConfirmPayEvent cp = (ConfirmPayEvent) event;
					System.out.println("付款事件处理");
					if(cp!= null && cp.getBiddeeId()!= null){
						UserMsgBodyVO info = new UserMsgBodyVO();
						info.setMsgContent("您的招标【"+cp.getProjectId()+"】项目已经确认付款");
						info.setMsgTitle("付款通知");
						info.setMsgType("PRI");
						info.setUserId(cp.getBiddeeId());
						umService.addMsg(info);
						
					}
					if(cp!= null && cp.getBidderId() != null){
						UserMsgBodyVO info1 = new UserMsgBodyVO();
						info1.setMsgContent("您的投标【"+cp.getProjectId()+"】项目付款人已付款");
						info1.setMsgTitle("付款通知");
						info1.setMsgType("PRI");
						info1.setUserId(cp.getBidderId());
						umService.addMsg(info1);
						
					}
					
					
				}
				
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
