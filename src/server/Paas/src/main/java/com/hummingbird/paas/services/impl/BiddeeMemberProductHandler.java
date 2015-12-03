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
import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.MemberBiddee;
import com.hummingbird.paas.entity.MemberBiddeeUpgrade;
import com.hummingbird.paas.entity.MemberProductAttr;
import com.hummingbird.paas.entity.Order;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.mapper.BiddeeMapper;
import com.hummingbird.paas.mapper.MemberBiddeeMapper;
import com.hummingbird.paas.mapper.MemberBiddeeUpgradeMapper;
import com.hummingbird.paas.mapper.MemberProductAttrMapper;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.services.ProductHandler;

/**
 * @author john huang
 * 2015年12月2日 下午5:38:46
 * 本类主要做为 招标人会员产品 的处理器
 */
@Service("biddeeMemberProductHandler")
public class BiddeeMemberProductHandler implements ProductHandler {

	@Autowired
	UserMapper userDao;
	@Autowired
	MemberBiddeeMapper biddeememDao;
	@Autowired
	BiddeeMapper biddeeDao;
	@Autowired
	MemberProductAttrMapper memproattrDao;
	@Autowired
	MemberBiddeeUpgradeMapper memproupgradeDao;
	
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
		Biddee biddee = biddeeDao.selectByUserId(userId);
		ValidateUtil.assertNull(biddee, "用户未通过招标人资质认证");
		//查询招标人会员
		MemberBiddee biddeemem = biddeememDao.selectByBiddeeId(biddee.getId());
		if(biddeemem==null){
			//初次购买,添加 会员
			biddeemem = new MemberBiddee();
			biddeemem.setMemberLevel(attr.getLevel());
			biddeemem.setBiddeeId(biddee.getId());
			biddeemem.setStartTime(new Date());
			biddeemem.setEndTime(DateUtil.dateAdd(new Date(), Calendar.DATE, attr.getProductExpireLength()));
			biddeememDao.insert(biddeemem);
		}
		else{
			//判断是否过期了
			//注意由于只有一级,这里不管升级降级的情况
			if(biddeemem.isOvertime()){
				biddeemem.setMemberLevel(attr.getLevel());
				biddeemem.setStartTime(new Date());
				biddeemem.setEndTime(DateUtil.dateAdd(new Date(), Calendar.DATE, attr.getProductExpireLength()));
				biddeememDao.updateByPrimaryKey(biddeemem);
			}
			else{
				//往后推一年
				biddeemem.setEndTime(DateUtil.dateAdd(biddeemem.getEndTime(), Calendar.DATE, attr.getProductExpireLength()));
				biddeememDao.updateByPrimaryKey(biddeemem);
			}
		}
		//记录历史
		MemberBiddeeUpgrade upgrade =new MemberBiddeeUpgrade();
		upgrade.setAmount(order.getAmount().intValue());
		upgrade.setBiddeeId(biddee.getId());
		upgrade.setInsertTime(new Date());
		upgrade.setMemberLevel(attr.getLevel());
		upgrade.setProductId(productId);
		memproupgradeDao.insert(upgrade);
		
		return biddeemem;
	}

}
