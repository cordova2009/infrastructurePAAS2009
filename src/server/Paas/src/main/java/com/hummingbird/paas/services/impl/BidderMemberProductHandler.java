/**
 * 
 * Bi大鹏.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.services.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.ValidateUtil;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.MemberBidder;
import com.hummingbird.paas.entity.MemberBidderUpgrade;
import com.hummingbird.paas.entity.MemberProductAttr;
import com.hummingbird.paas.entity.Order;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.mapper.BidderMapper;
import com.hummingbird.paas.mapper.MemberBidderMapper;
import com.hummingbird.paas.mapper.MemberBidderUpgradeMapper;
import com.hummingbird.paas.mapper.MemberProductAttrMapper;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.services.ProductHandler;

/**
 * @author john huang
 * 2015年12月2日 下午5:38:46
 * 本类主要做为 投标人会员产品 的处理器
 */
@Service("bidderMemberProductHandler")
public class BidderMemberProductHandler implements ProductHandler {

	@Autowired
	UserMapper userDao;
	@Autowired
	MemberBidderMapper biddermemDao;
	@Autowired
	BidderMapper bidderDao;
	@Autowired
	MemberProductAttrMapper memproattrDao;
	@Autowired
	MemberBidderUpgradeMapper memproupgradeDao;
	
	/* (non-Javadoc)
	 * @see com.hummingbird.paas.services.ProductHandler#handle(com.hummingbird.paas.entity.Order)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, value = "txManager")
	public Object handle(Order order) throws BusinessException {
		
		String productId = order.getProductId();
		MemberProductAttr attr = memproattrDao.selectByPrimaryKey(productId);
		ValidateUtil.assertNull(attr, "会员属性不存在");
		//查询招标人
		Integer userId = order.getUserId();
		User user = userDao.selectByPrimaryKey(userId);
		ValidateUtil.assertNull(user, "用户不存在");
		Bidder bidder = bidderDao.selectByUserId(userId);
		ValidateUtil.assertNull(bidder, "用户未通过招标人资质认证");
		//查询招标人会员
		MemberBidder biddermem = biddermemDao.selectByBidderId(bidder.getId());
		if(biddermem==null){
			//初次购买,添加 会员
			biddermem = new MemberBidder();
			biddermem.setMemberLevel(attr.getLevel());
			biddermem.setBidderId(bidder.getId());
			biddermem.setStartTime(new Date());
			biddermem.setEndTime(DateUtil.dateAdd(new Date(), Calendar.DATE, attr.getProductExpireLength()));
			biddermemDao.insert(biddermem);
		}
		else{
			//判断是否过期了
			//注意由于只有一级,这里不管升级降级的情况
			if(biddermem.isOvertime()){
				biddermem.setMemberLevel(attr.getLevel());
				biddermem.setStartTime(new Date());
				biddermem.setEndTime(DateUtil.dateAdd(new Date(), Calendar.DATE, attr.getProductExpireLength()));
				biddermemDao.updateByPrimaryKey(biddermem);
			}
			else{
				//往后推一年
				biddermem.setEndTime(DateUtil.dateAdd(biddermem.getEndTime(), Calendar.DATE, attr.getProductExpireLength()));
				biddermemDao.updateByPrimaryKey(biddermem);
			}
		}
		//记录历史
		MemberBidderUpgrade upgrade =new MemberBidderUpgrade();
		upgrade.setAmount(order.getAmount().intValue());
		upgrade.setBidderId(bidder.getId());
		upgrade.setInsertTime(new Date());
		upgrade.setMemberLevel(attr.getLevel());
		upgrade.setProductId(productId);
		memproupgradeDao.insert(upgrade);
		
		return biddermem;
	}

}
