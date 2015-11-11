package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.hummingbird.paas.entity.OrderProduct;
import com.hummingbird.paas.entity.ProjectAccount;
import com.hummingbird.paas.entity.ProjectAccountOrder;
import com.hummingbird.paas.entity.QyzzBiddee;
import com.hummingbird.paas.entity.QyzzBidder;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.mapper.HyglBiddeeMapper;
import com.hummingbird.paas.mapper.HyglBidderMapper;
import com.hummingbird.paas.mapper.MemberProductPrivilegeMapper;
import com.hummingbird.paas.mapper.OrderProductMapper;
import com.hummingbird.paas.mapper.ProjectAccountMapper;
import com.hummingbird.paas.mapper.ProjectAccountOrderMapper;
import com.hummingbird.paas.mapper.QyzzBiddeeMapper;
import com.hummingbird.paas.mapper.QyzzBidderMapper;
import com.hummingbird.paas.mapper.UserTokenMapper;
import com.hummingbird.paas.services.MemberService;
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
	ProjectAccountMapper paDao;
	@Autowired
	ProjectAccountOrderMapper paoDao;
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
		Integer bidderId = qm.getId();
		Integer tendererId = qe.getId();
		HyglBidder bidder = null;
		HyglBiddee hyglBiddee = null;
		if (bidderId != null) {
			bidder = hbmDao.selectByPrimaryKey(bidderId);
		}
		if (tendererId != null) {
			hyglBiddee = tmDao.selectByPrimaryKey(tendererId);
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
		} else {
			qrv.setIsMember(false);
			qmis.add(qrv);
		}
		return qmis;
	}

	/* 查询可购买会员 */
	public QueryMemberProductResultVO querysAvailableProducts(String token) {
		if (StringUtils.isBlank(token)) {
			log.error("查询会员可购买信息出错传入token为空");
			return null;
		}
		QueryMemberProductResultVO proResult = null;
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
		Integer bidderId = qm.getId();
		Integer tendererId = qe.getId();
		HyglBidder bidder = null;
		HyglBiddee hyglBiddee = null;
		if (bidderId != null) {
			bidder = hbmDao.selectByBidderId(bidderId);
		}
		if (tendererId != null) {
			hyglBiddee = tmDao.selectByBiddeeId(tendererId);
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
		if (hyglBiddee != null) {
			Date now = new Date();
			if (hyglBiddee.getEndTime() != null) {
				if (hyglBiddee.getEndTime().getTime() > now.getTime()) {
					proResult.setTeeMember("OK#");
					Integer productId = bidder.getProductId();
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
				proResult.setTeeMemberExpireTime(du.format(bidder.getEndTime(), "yyyy-MM-dd"));
			} else {
				if (log.isDebugEnabled()) {
					log.debug("截止日期信息不全无法判断会员是否可购买");
				}
				proResult.setTeeMember("FLS");
			}

		}
		proResult.setResults(qproducts);
		return proResult;
	}

	@Override
	public boolean buyPrivilegeMember(BuyTenderMemberBodyVO bt) {
		if(bt==null||StringUtils.isBlank(bt.getToken())||StringUtils.isBlank(bt.getPayMethod())||StringUtils.isBlank(bt.getMemberType())||bt.getPayAmount()==null||bt.getMemberDuration()==null){
		    log.error("购买招标方会员出错");
			return false;
		}
		//现金支付
		Token t = 	utDao.selectByPrimaryKey(bt.getToken());
		Integer userId = t.getUserId();
		if(userId==null||userId<=0){
			log.error("用户id为空");
			return false;
		}
		if(bt.getPayMethod().equals("CAS")){
		  ProjectAccount pacc =  paDao.queryAccountInfo(userId);
		  if(pacc==null){
			  log.error("查询到工程项目账号记录为空");
			  return false;
		  }
		  Integer balance  = pacc.getRemainingSum();
		  if(balance!=null&&balance>bt.getPayAmount()){
			
		      QyzzBiddee qe = qbeeDao.selectByUserId(userId);
		      if(qe==null){
		    	  log.error("QyzzBiddee未找到招标方记录");
		    	  return false;
		      }
		      Integer biddeeId = qe.getId();
		      HyglBiddee hbee = tmDao.selectByBiddeeId(biddeeId);
		      if(hbee!=null){
		          Calendar calendar = Calendar.getInstance();
		          Date date = hbee.getEndTime();
		          if(date==null||date.getTime()<new Date().getTime()){
		        	  if(log.isDebugEnabled()){
		        		  log.debug("招标方截止会员日期不全");
		        	  }
		        	  //默认为现在
		        	  date = new Date();
		          }
		          calendar.setTime(date);
		          calendar.add(Calendar.YEAR,bt.getMemberDuration());
		          date = calendar.getTime();
		          hbee.setEndTime(date);
		          ProjectAccountOrder pao = new ProjectAccountOrder();
		          pao.setAccountId(pacc.getAccountId());
		          
		          Integer newRemain = bt.getPayAmount()-balance;
			      pacc.setRemainingSum(newRemain);
			      return true;
		      }
		  }
		  
		}
		return true;
	}
}
