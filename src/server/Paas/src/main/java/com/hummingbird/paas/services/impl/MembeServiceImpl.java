package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.paas.entity.HyglBiddee;
import com.hummingbird.paas.entity.HyglBidder;
import com.hummingbird.paas.entity.Order;
import com.hummingbird.paas.entity.OrderProduct;
import com.hummingbird.paas.entity.QyzzBiddee;
import com.hummingbird.paas.entity.QyzzBidder;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.mapper.HyglBiddeeMapper;
import com.hummingbird.paas.mapper.HyglBidderMapper;
import com.hummingbird.paas.mapper.MemberProductPrivilegeMapper;
import com.hummingbird.paas.mapper.OrderMapper;
import com.hummingbird.paas.mapper.OrderProductMapper;
import com.hummingbird.paas.mapper.QyzzBiddeeMapper;
import com.hummingbird.paas.mapper.QyzzBidderMapper;
import com.hummingbird.paas.mapper.UserTokenMapper;
import com.hummingbird.paas.services.MemberService;
import com.hummingbird.paas.util.AccountGenerationUtil;
import com.hummingbird.paas.vo.BuyTenderMemberBodyVO;
import com.hummingbird.paas.vo.QueryMemberInfoResultVO;
import com.hummingbird.paas.vo.QueryMemberProductResultBodyVO;
import com.hummingbird.paas.vo.QueryMemberProductResultVO;

@Service
public class MembeServiceImpl implements MemberService {

	org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(this.getClass());
	@Autowired
	private UserTokenMapper utokenDao;
	@Autowired
	HyglBidderMapper hbmDao;
	@Autowired
	HyglBiddeeMapper tmDao;
	@Autowired
	QyzzBidderMapper qberDao;
	@Autowired
	QyzzBiddeeMapper qbeeDao;
	@Autowired
	MemberProductPrivilegeMapper prDao;
	@Autowired
	OrderProductMapper opmDao;
	@Autowired
	UserTokenMapper utDao;
	@Autowired
	OrderMapper omDao;

	public List<QueryMemberInfoResultVO> querysMemberInfo(String token) {

		if (StringUtils.isBlank(token)) {
			log.error("查询会员信息出错传入token为空");
			return null;
		}
		DateUtil du = new DateUtil();
		Token utoken = utokenDao.selectByPrimaryKey(token);
		List<QueryMemberInfoResultVO> qmis = new ArrayList<QueryMemberInfoResultVO>();
		QueryMemberInfoResultVO qrv = null;
		if (utoken == null) {
			if (log.isDebugEnabled()) {
				log.debug("找不到对应UserToken对象");
			}
			
			return null;
		}
		Integer id = utoken.getUserId();
		if (id == null || id <= 0) {
			log.error("获取会员id出错");
			return null;
		}
		QyzzBidder qm = qberDao.selectByUserId(id);
		QyzzBiddee qe = qbeeDao.selectByUserId(id);
		//
		
		if (qm != null) {

			Integer bidderId = qm.getId();
			HyglBidder bidder = null;
			if (bidderId != null) {
				bidder = hbmDao.selectByPrimaryKey(bidderId);
			}
			if (bidder != null) {
				qrv = new QueryMemberInfoResultVO();
				Date now = new Date();
				if (bidder.getEndTime() != null) {
					if (bidder.getEndTime().getTime() > now.getTime()) {
						qrv.setIsMember(true);
						qrv.setMemberEndTime(du.format(bidder.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
					} else {
						qrv.setMemberEndTime(du.format(bidder.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
						qrv.setIsMember(false);
					}

				} else {
					if (log.isDebugEnabled()) {
						log.debug("截止日期信息不全无法判断是否是会员");
					}
					qrv.setIsMember(false);
				}
				if (bidder.getStartTime() != null)
					qrv.setMemberStartTime(du.format(bidder.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
				qrv.setMemberType(bidder.getMemberLevel());
				Integer productId = bidder.getProductId();
				if (productId != null) {
					List<String> privileges = prDao.getPriviliges(productId);
					try {
						String priviliege = JsonUtil.convert2Json(privileges);

						qrv.setMemberContent(priviliege);
					} catch (DataInvalidException e) {
						log.error("权限信息数组转换为字符串失败" + privileges);
					}
				}
				qmis.add(qrv);
			}

		}
		if (qe != null) {

			Integer tendererId = qe.getId();

			HyglBiddee hyglBiddee = null;
			if (tendererId != null) {
				hyglBiddee = tmDao.selectByPrimaryKey(tendererId);
			}
			if (hyglBiddee != null) {
				qrv = new QueryMemberInfoResultVO();
				Date now = new Date();
				if (hyglBiddee.getEndTime() != null) {
					if (hyglBiddee.getEndTime().getTime() > now.getTime()) {
						qrv.setIsMember(true);
						qrv.setMemberEndTime(du.format(hyglBiddee.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
					} else {
						qrv.setMemberEndTime(du.format(hyglBiddee.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
						qrv.setIsMember(false);
					}
					if (hyglBiddee.getStartTime() != null)
						qrv.setMemberStartTime(du.format(hyglBiddee.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
					qrv.setMemberType(hyglBiddee.getMemberLevel());
					Integer productId = hyglBiddee.getProductId();
					if (productId != null) {
						List<String> privileges = prDao.getPriviliges(productId);
						try {
							String priviliege = JsonUtil.convert2Json(privileges);

							qrv.setMemberContent(priviliege);
						} catch (DataInvalidException e) {
							log.error("权限信息数组转换为字符串失败" + privileges);
						}
					}
					qmis.add(qrv);

				}
			}
		} else {
			if (qrv != null) {
				qrv.setIsMember(false);
				qmis.add(qrv);
			}
		}
		return qmis;
	}

	/* 查询可购买会员 */
	public QueryMemberProductResultVO querysAvailableProducts(String token) {
		QueryMemberProductResultVO proResult = new QueryMemberProductResultVO();
		if (StringUtils.isBlank(token)) {
			log.error("查询会员可购买信息出错传入token为空");
			return null;
		}
		List<QueryMemberProductResultBodyVO> qproducts = new ArrayList<QueryMemberProductResultBodyVO>();
		QueryMemberProductResultBodyVO resultOne = null;
		DateUtil du = new DateUtil();
		Token utoken = utokenDao.selectByPrimaryKey(token);
		if (utoken == null) {
			if (log.isDebugEnabled()) {
				log.debug("找不到对应UserToken对象");
			}
			return null;
		}
		Integer id = utoken.getUserId();
		if (id == null || id <= 0) {
			log.error("获取会员id出错");
			return null;
		}
		QyzzBidder qm = qberDao.selectByUserId(id);
		QyzzBiddee qe = qbeeDao.selectByUserId(id);
		//
		if(qm==null){
			proResult.setTerMember("FLS");
		}
		if (qm != null) {
			Integer bidderId = qm.getId();
			HyglBidder bidder = null;
			if (bidderId != null) {
				bidder = hbmDao.selectByBidderId(bidderId);
			}else{
				proResult.setTerMember("FLS");
			}
            if(bidder==null){
            	proResult.setTerMember("FLS");
            }
			if (bidder != null) {
				Date now = new Date();
				if (bidder.getEndTime() != null) {
					if (bidder.getEndTime().getTime() > now.getTime()) {
						proResult.setTerMember("OK#");
						Integer productId = bidder.getProductId();
						if (productId != null) {
							OrderProduct or = opmDao.selectByPrimaryKey(productId.toString());
							if (or != null) {
								resultOne = new QueryMemberProductResultBodyVO();
								if (StringUtils.isNotBlank(or.getPrice()))
									resultOne.setProductPrice(or.getPrice());
								if (StringUtils.isNotBlank(or.getProductDescription()))
									resultOne.setProductDesc(or.getProductDescription());
								if (StringUtils.isNotBlank(or.getProductName()))
									resultOne.setProductName(or.getProductName());
								resultOne.setProductId(productId.toString());
								resultOne.setMemberType("TER");
								qproducts.add(resultOne);
							}
						}
					} else {
						proResult.setTerMember("FLS");
					}
					proResult.setTerMemberExpireTime(du.format(bidder.getEndTime(), "yyyy-MM-dd"));
				} else {
					if (log.isDebugEnabled()) {
						log.debug("截止日期信息不全无法判断是否是会员");
					}
					proResult.setTerMember("FLS");
				}

			}
		}
		if(qe==null){
			proResult.setTeeMember("FLS");
		}
		if (qe != null) {
			Integer tendererId = qe.getId();
			HyglBiddee hyglBiddee = null;
			if (tendererId != null) {
				hyglBiddee = tmDao.selectByBiddeeId(tendererId);
			}else{
				proResult.setTeeMember("FLS");
			}
			if(hyglBiddee==null){
				proResult.setTeeMember("FLS");
			}
			if (hyglBiddee != null) {
				Date now = new Date();
				if(hyglBiddee.getEndTime()==null){
					proResult.setTeeMember("FlS");
				}
				if (hyglBiddee.getEndTime() != null) {
					if (hyglBiddee.getEndTime().getTime() > now.getTime()) {
						proResult.setTeeMember("OK#");
						Integer productId = hyglBiddee.getProductId();
						if (productId != null) {
							OrderProduct or = opmDao.selectByPrimaryKey(productId.toString());
							if (or != null) {
								QueryMemberProductResultBodyVO resultOne2 = new QueryMemberProductResultBodyVO();
								if (StringUtils.isNotBlank(or.getPrice()))
									resultOne2.setProductPrice(or.getPrice());
								if (StringUtils.isNotBlank(or.getProductDescription()))
									resultOne2.setProductDesc(or.getProductDescription());
								if (StringUtils.isNotBlank(or.getProductName()))
									resultOne2.setProductName(or.getProductName());
								resultOne2.setProductId(productId.toString());
								resultOne2.setMemberType("TEE");
								qproducts.add(resultOne2);
							}
						}
					} else {
						proResult.setTeeMember("FLS");
					}
					proResult.setTeeMemberExpireTime(du.format(hyglBiddee.getEndTime(), "yyyy-MM-dd"));
				} else {
					if (log.isDebugEnabled()) {
						log.debug("截止日期信息不全无法判断会员是否可购买");
					}
					proResult.setTeeMember("FLS");
				}

			}

		}
		proResult.setResults(qproducts);
		return proResult;
	}

	// 购买招标方会员接口
	@Override
	public String buyPrivilegeMember(BuyTenderMemberBodyVO bt, String appId) {
		if (bt == null || StringUtils.isBlank(bt.getToken()) || StringUtils.isBlank(bt.getPayMethod())
				|| StringUtils.isBlank(bt.getProductId()) || bt.getPayAmount() == null
				|| bt.getMemberDuration() == null) {
			log.error("购买招标方会员出错");
			return null;
		}
		OrderProduct op = opmDao.selectByPrimaryKey(bt.getProductId());
		if (op == null) {
			log.error("该产品不存在");
			return null;
		}
		Token t = utDao.selectByPrimaryKey(bt.getToken());
		Integer userId = t.getUserId();
		if (userId == null || userId <= 0) {
			log.error("用户id为空");
			return null;
		}
		Order ord = new Order();
		ord.setAmount(bt.getPayAmount());
		ord.setInsertTime(new Date());
		ord.setPayStatus("CRT");
		ord.setPayType(bt.getPayMethod());
		ord.setProductCount(bt.getMemberDuration());
		ord.setDiscount(100);
		Integer price = bt.getPayAmount()/bt.getMemberDuration();
		ord.setProductPrice(price);
		ord.setCreateBy(userId.toString());
		ord.setRealAmount(bt.getPayAmount());
		String orderId = AccountGenerationUtil.genNO("RM", 8);
		ord.setOrderId(orderId);
		ord.setAppId(appId);
		ord.setProductDesc(op.getProductDescription());
		ord.setProductId(bt.getProductId());
		omDao.insert(ord);
		return orderId;
	}
}
