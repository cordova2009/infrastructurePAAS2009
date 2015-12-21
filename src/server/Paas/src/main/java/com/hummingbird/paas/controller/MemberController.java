package com.hummingbird.paas.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.codehaus.jackson.map.SerializationConfig;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.PropertiesUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.util.http.HttpRequester;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.BiddeeUpgrade;
import com.hummingbird.paas.entity.BidderUpgrade;
import com.hummingbird.paas.entity.HyglBiddee;
import com.hummingbird.paas.entity.HyglBidder;
import com.hummingbird.paas.entity.MemberProductAttr;
import com.hummingbird.paas.entity.Order;
import com.hummingbird.paas.entity.OrderProduct;
import com.hummingbird.paas.entity.PaymentAlipay;
import com.hummingbird.paas.entity.QyzzBiddee;
import com.hummingbird.paas.entity.QyzzBidder;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.User;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.mapper.BiddeeUpgradeMapper;
import com.hummingbird.paas.mapper.BidderUpgradeMapper;
import com.hummingbird.paas.mapper.HyglBiddeeMapper;
import com.hummingbird.paas.mapper.HyglBidderMapper;
import com.hummingbird.paas.mapper.MemberProductAttrMapper;
import com.hummingbird.paas.mapper.OrderMapper;
import com.hummingbird.paas.mapper.OrderProductMapper;
import com.hummingbird.paas.mapper.PaymentAlipayMapper;
import com.hummingbird.paas.mapper.QyzzBiddeeMapper;
import com.hummingbird.paas.mapper.QyzzBidderMapper;
import com.hummingbird.paas.mapper.UserMapper;
import com.hummingbird.paas.services.OrderService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.services.VIPService;
import com.hummingbird.paas.util.AccountGenerationUtil;
import com.hummingbird.paas.vo.AlipayGatewayVO;
import com.hummingbird.paas.vo.BuyBiddeeVIPListVO;
import com.hummingbird.paas.vo.BuyVIPListVOResult;
import com.hummingbird.paas.vo.PayResult;
import com.hummingbird.paas.vo.QueryAlipayGatewayVO;
import com.hummingbird.paas.vo.QueryVIPBodyVO;
import com.hummingbird.paas.vo.QueryVIPInfoVOResult;


/**
 * <p>Title: MemberController</p>
 * <p>Description:会员controller</p>
 * <p>Company: 麦圈互动</p>
 * @author 黄细华
 * @date 2015-11-26下午4:03:35
 * @version 1.0
 */
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController{
	
	//会员业务模型
    @Autowired
    VIPService vipService;
    
    //令牌服务service
	@Autowired
	TokenService tokenService;
	
	//招标人DAO 招标人表
	@Autowired
	QyzzBiddeeMapper qyzzBiddeeMapper;
	
	//投标人DAO 投标人表
	@Autowired
	QyzzBidderMapper qyzzBidderMapper;
	
	//招标方会员DAO 招标方会员表
	@Autowired
	HyglBiddeeMapper hyglBiddeeMapper;
	
	//投标方会员DAO 投标方会员表
	@Autowired
	HyglBidderMapper hyglBidderMapper;
	
	//订单表DAO  订单表
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	OrderService ordersrv;
	
	//注册用户DAO 注册用户表 
	@Autowired
	UserMapper userMapper;
	
	//订单产品DAO 订单产品表
	@Autowired
	OrderProductMapper orderProductMapper;
	
	//支付宝支付记录DAO 支付宝支付记录表
	@Autowired
	PaymentAlipayMapper PaymentAlipayMapper;
	//会员产品属性表 t_ddgl_member_product_attr
	@Autowired
	MemberProductAttrMapper MemberProductAttrMapper;
	//招标人会员购买记录表 t_hygl_biddee_upgrade
	@Autowired
	BiddeeUpgradeMapper biddeeUpgradeMapper;
	
	@Autowired
	BidderUpgradeMapper bidderUpgradeMapper;
	//查询会员信息接口
    @RequestMapping(value = "/queryMemberInfo", method = RequestMethod.POST)
    @AccessRequered(methodName = "查询会员信息接口", isJson = true, codebase = 280100, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryVIPBodyVO", appLog = true)
	public @ResponseBody ResultModel queryMemberInfo(HttpServletRequest request,HttpServletResponse response) {
    	//结果集汇总类
		ResultModel rm = super.getResultModel();
		if(rm != null){
			//接受查询参数
			BaseTransVO<QueryVIPBodyVO> transorder = (BaseTransVO<QueryVIPBodyVO>) super.getParameterObject();
			if(transorder != null){
				String messagebase = "查询会员信息";
				try {
					//主体数据 此接口核心部分
					List<QueryVIPInfoVOResult> result=new ArrayList<QueryVIPInfoVOResult>();
					//*****************************验证开始************************************************
					
					
					// --------------------用户令牌验证------------------------------------
					String bodyToken=transorder.getBody().getToken();//用户令牌----->业务入口
					String appId=transorder.getApp().getAppId();//应用ID
					Token token = tokenService.getToken(bodyToken,appId);
					if (token == null) {
						log.error(String.format("token[%s]验证失败,或已过期,请重新登录",bodyToken));
						throw new TokenException("token验证失败,或已过期,请重新登录");
					}
					// --------------------用户令牌验证------------------------------------

					//*****************************验证结束************************************************
					// 业务数据逻辑校验
					if (log.isDebugEnabled()) {
						log.debug("检验通过，获取请求");
					}
					
					//*****************************接口业务核心部分开始************************************************
					Integer userId=token.getUserId(); 
					if(userId != null){
						//设置消息成功
						rm.setErrmsg(messagebase+"成功");
						//会员身份属性,NCP:未资质认证,NON:非会员,OK#:会员,EPE:会员过期
						String[] isMember =new String[]{"NCP","NON","OK#","EPE"};
						//会员类型，TER招标人会员，BIR投标人会员
						String[] memberType=new String[]{"TER","BIR"};
						/**
						 * 投标人查询 ---默认条件是status状态,OK#正常,DIS禁用;certificate_status认证状态,CRT待认证,OK#已认证,FLS认证失败
						 * status=OK#;certificate_status:OK#
						 */
						QyzzBidder bidder = qyzzBidderMapper.selectByUserId(userId);
						
						//根据状态和认证状态判断是否有资质认证
						if( bidder == null){
							//如果没有通过资质认证isMember设置为NCP:未资质认证
							QueryVIPInfoVOResult vipInfoVOResult=new QueryVIPInfoVOResult();
							vipInfoVOResult.setIsMember(isMember[0]);
							vipInfoVOResult.setMemberType(memberType[1]);
							result.add(vipInfoVOResult);
						}else{
							Integer bidderId=bidder.getId();
							if(bidderId != null ){
								//查询投标人会员表t_hygl_bidder
								//通过资质认证查是否为投标人会员
								HyglBidder hyglBidder=hyglBidderMapper.selectByBidderId(bidderId);
								if(hyglBidder == null){
									//不是会员isMember设置为NON:非会员
									QueryVIPInfoVOResult vipInfoVOResult=new QueryVIPInfoVOResult();
									vipInfoVOResult.setIsMember(isMember[1]);
									vipInfoVOResult.setMemberType(memberType[1]);
									result.add(vipInfoVOResult);//往JSON info添加数据
								}else{
									QueryVIPInfoVOResult vipInfoVOResult=new QueryVIPInfoVOResult();
									DateUtil du = new DateUtil();//时期处理工具类
									//getTime获取的整数值大小,整数值大的时间就大，整数值小的时间就小
									Date memberEndTime=hyglBidder.getEndTime();
									long currentTime=new Date().getTime();//获取当前时间与会员结束时间进行比较如果会员结束时间大于当前时间说明会员在有效期内，即是会员。
									if( memberEndTime.getTime()>currentTime){
										//在有效期内是会员 isMember:OK# 会员
										vipInfoVOResult.setIsMember(isMember[2]);	
									}else{
										//不在有效期内不是会员 isMember:EPE 会员过期
										vipInfoVOResult.setIsMember(isMember[3]);
									}
									vipInfoVOResult.setMemberType(memberType[1]);
									vipInfoVOResult.setMemberStartTime(du.format(hyglBidder.getStartTime(),"yyyy-MM-dd"));
									vipInfoVOResult.setMemberEndTime(du.format(memberEndTime,"yyyy-MM-dd"));									
									//会员特权
									String memberContent=hyglBidderMapper.getMemberContent(hyglBidder.getMemberLevel());
									if(memberContent != null){
										vipInfoVOResult.setMemberContent(memberContent);	
									}
									
									result.add(vipInfoVOResult);
								}
							}

						}	
						//招标人查询
						QyzzBiddee biddee = qyzzBiddeeMapper.selectByUserId(userId);
						//根据状态和认证状态判断是否有资质认证
						if( biddee == null){
							//如果没有通过资质认证isMember设置为NCP:未资质认证
							QueryVIPInfoVOResult vipInfoVOResult=new QueryVIPInfoVOResult();
							vipInfoVOResult.setIsMember(isMember[0]);
							vipInfoVOResult.setMemberType(memberType[0]);
							result.add(vipInfoVOResult);
						}else{
							//通过资质认证查是否为会员
							HyglBiddee hyglBiddee=hyglBiddeeMapper.selectByBiddeeId(biddee.getId());
							if(hyglBiddee == null){
								//不是会员isMember设置为NON:非会员
								QueryVIPInfoVOResult vipInfoVOResult=new QueryVIPInfoVOResult();
								vipInfoVOResult.setIsMember(isMember[0]);
								vipInfoVOResult.setMemberType(memberType[0]);
								result.add(vipInfoVOResult);
							}else{
								
								QueryVIPInfoVOResult vipInfoVOResult=new QueryVIPInfoVOResult();
								DateUtil du = new DateUtil();
								long currentTime=new Date().getTime();//获取当前时间与会员结束时间进行比较如果会员结束时间大于当前时间说明会员在有效期内
								Date memberEndTime=hyglBiddee.getEndTime();
								if(memberEndTime != null){
									if( memberEndTime.getTime()>currentTime){
										//在有效期内是会员 isMember:OK# 会员
										vipInfoVOResult.setIsMember(isMember[2]);	
									}else{
										//不在有效期内不是会员 isMember:EPE 会员过期
										vipInfoVOResult.setIsMember(isMember[3]);
									}
									vipInfoVOResult.setMemberType(memberType[0]);
									vipInfoVOResult.setMemberStartTime(du.format(hyglBiddee.getStartTime(),"yyyy-MM-dd"));
									vipInfoVOResult.setMemberEndTime(du.format(memberEndTime,"yyyy-MM-dd"));
									
								}
								//会员特权
								String memberContent=hyglBiddeeMapper.getMemberContent(hyglBiddee.getMemberLevel());
								if( memberContent != null){
									vipInfoVOResult.setMemberContent(memberContent);
								}
								result.add(vipInfoVOResult);
							}
						}
					}
					//---------------------招投标人验证-----------------------------------------------
					//---------------------招投标人验证-----------------------------------------------
					rm.put("info",result);
					// ************************业务核心**********************************
					tokenService.postponeToken(token);
					//*****************************验证结束************************************************
				} catch (Exception e) {
					rm.setErrcode(210101);
					rm.setErrmsg(messagebase+"失败");
					log.error(String.format(messagebase + "失败"), e);
					rm.mergeException(e);
				}
			}
			
		}
		return rm;
    }	
    //查询可购买的会员
    @RequestMapping(value = "/queryMemberProduct", method = RequestMethod.POST)
    @AccessRequered(methodName = "查询可购买会员列表接口", isJson = true, codebase = 840000, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.QueryVIPBodyVO", appLog = true)
  	public @ResponseBody ResultModel queryMemberProduct(HttpServletRequest request,HttpServletResponse response) {
    	//结果集汇总
		ResultModel rm = super.getResultModel();
		//接受查询参数
		BaseTransVO<QueryVIPBodyVO> transorder = (BaseTransVO<QueryVIPBodyVO>) super.getParameterObject();
		String messagebase = "查询可购买会员列表";
		
		if(transorder != null){
			try {		
				//*****************************验证开始************************************************
				// --------------------用户令牌验证------------------------------------
				String bodyToken=transorder.getBody().getToken();//用户令牌----->业务入口
				String appId=transorder.getApp().getAppId();//应用ID
				Token token = tokenService.getToken(bodyToken,appId);
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				// --------------------用户令牌验证------------------------------------
				//*****************************验证开始************************************************
				
				
				// 业务数据逻辑校验
				if (log.isDebugEnabled()) {
					log.debug("检验通过，获取请求");
				}
				//*****************************接口业务核心部分开始************************************************
				//主体数据 此接口核心部分
				List<BuyVIPListVOResult> results=new ArrayList<BuyVIPListVOResult>();
				
				Integer userId=token.getUserId(); 
				
				if(userId != null){
					//会员身份属性,NCP:未资质认证,NON:非会员,OK#:会员,EPE:会员过期
					String[] isMember =new String[]{"NCP","NON","OK#","EPE"};
					//会员类型，TER招标人会员，BIR投标人会员
					String[] memberType=new String[]{"TER","BIR"};
					/**
					 * 投标人查询 ---默认条件是status状态,OK#正常,DIS禁用;certificate_status认证状态,CRT待认证,OK#已认证,FLS认证失败
					 * status=OK#;certificate_status:OK#
					 */
					//**********************招标人*************************************************************
					//招标人查询
					QyzzBiddee biddee = qyzzBiddeeMapper.selectByUserId(userId);
					
						
						boolean biddeeFalg=true;
						if( biddee == null){
							rm.put("terMember",isMember[0]);	//是否招标方会员,NCP 未资质认证,NON 非会员,OK# 会员,EPE 会员过期
							rm.put("terMemberExpireTime","");//招标方会员到期时间
							biddeeFalg=false;
						}else{
							
							Integer bidderId=biddee.getId();
							if( bidderId != null){
								//通过资质认证查是否为会员
								HyglBiddee hyglBiddee=hyglBiddeeMapper.selectByBiddeeId(bidderId);
								if( hyglBiddee == null){
									rm.put("terMember", isMember[1]);	//是否招标方会员,NCP 未资质认证,NON 非会员,OK# 会员,EPE 会员过期
									rm.put("terMemberExpireTime","");//招标方会员到期时间
								}else{
									Date date=new Date();
									DateUtil du = new DateUtil();
									Date endTime=hyglBiddee.getEndTime();
									
									if(endTime.getTime()>date.getTime()){
										biddeeFalg=false;
										rm.put("terMember",isMember[2]);	//是否招标方会员,NCP 未资质认证,NON 非会员,OK# 会员,EPE 会员过期
									}else{
										rm.put("terMember",isMember[3]);	//是否招标方会员,NCP 未资质认证,NON 非会员,OK# 会员,EPE 会员过期
									}
									rm.put("terMemberExpireTime",du.format(endTime,"yyyy-MM-dd"));//招标方会员到期时间
								}
							}
						}
						//注: 当terMember和birMember是NCP 未资质认证,不能购买会员,OK# 也不能购买会员
						if(biddeeFalg){
							
							List<BuyVIPListVOResult> ter=vipService.getBuyVIPListVOResult(memberType[0]); 
							if( ter != null && ter.size()>0){
								results.addAll(ter);
							}
						}
					
					//**********************招标人*************************************************************
					//投标人查询
					QyzzBidder bidder = qyzzBidderMapper.selectByUserId(userId);
					
					
						boolean bidderFalg=true;
						//**********************投标人*******************************
						if( bidder == null){
							rm.put("birMember",isMember[0]);//是否投标方会员,NCP 未资质认证,NON 非会员,OK# 会员,EPE 会员过期
							rm.put("birMemberExpireTime","");//投标方会员到期时间
							bidderFalg=false;
						}else{
							//通过资质认证查是否为会员
							HyglBidder hyglBidder=hyglBidderMapper.selectByBidderId(bidder.getId());
							if( hyglBidder == null){
								rm.put("birMember", isMember[1]);//是否投标方会员,NCP 未资质认证,NON 非会员,OK# 会员,EPE 会员过期
								rm.put("birMemberExpireTime","");//投标方会员到期时间
							}else{
								Date date=new Date();
								DateUtil du = new DateUtil();
								Date endTime=hyglBidder.getEndTime();
								if(endTime.getTime()>date.getTime()){
									rm.put("birMember", isMember[2]);	//是否投标方会员,NCP 未资质认证,NON 非会员,OK# 会员,EPE 会员过期
									bidderFalg=false;
								}else{
									rm.put("birMember", isMember[3]);	//是否投标方会员,NCP 未资质认证,NON 非会员,OK# 会员,EPE 会员过期
								}
								rm.put("birMemberExpireTime",du.format(endTime,"yyyy-MM-dd"));//投标方会员到期时间
							}
						
							//注: 当birMember是NCP 未资质认证,不能购买会员,OK# 也不能购买会员
						if( bidderFalg == true){
							List<BuyVIPListVOResult> bir=vipService.getBuyVIPListVOResult(memberType[1]); 
							if( bir != null && bir.size()>0){
								results.addAll(bir);
							}
						}
					}
					//**********************投标人*******************************
					if(results != null && results.size()>0){
					rm.put("results", results);	
					}
					// ************************业务核心**********************************
					tokenService.postponeToken(token);
				}
				tokenService.postponeToken(token);
			} catch (Exception e)  {
				rm.setErrcode(840001);
				rm.setErrmsg(messagebase+"失败");
				log.error(String.format(messagebase + "失败"), e);
				rm.mergeException(e);
			}
		}

		
		return rm;
    }	
    //购买招标方会员
    @RequestMapping(value = "/buyBiddeeMember", method = RequestMethod.POST)
    @AccessRequered(methodName = "购买招标方会员接口", isJson = true, codebase = 850000, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.BuyBiddeeVIPListVO", appLog = true)
  	public @ResponseBody ResultModel buyBiddeeMember(HttpServletRequest request) {
    	//结果集汇总
		ResultModel rm = super.getResultModel();
		//接受查询参数
		BaseTransVO<BuyBiddeeVIPListVO> transorder = (BaseTransVO<BuyBiddeeVIPListVO>) super.getParameterObject();
		String messagebase = "购买招标方会员";
		try {
			/*
			 * 1. 查询用户的身份,如果用户不是通过招标人资质,不能购买.如果用户已有招标人会员(在有效期内),则也不能购买

			2. 检查用户的订单表有没有购买招标人会员的订单,订单状态为CRT(待支付),调用支付宝网关,查询订单状态

			    如果有记录,记录状态可为 OK#已支付,FLS支付失败,NON没有处理,OTH其它状态(如订单取消)

			    2.1 如果为已支付,则把订单状态改为已支付,且为用户添加会员身份(如果原来没有会员,则添加会员,如果原来有会员,则调整会员的开始时间和结束时间),在会员升级表添加一条历史记录,并且返回{"errcode":210106,"errmsg":"您已是会员"},其中errcode中的 21010 要根据功能编号来改.

			    2.2 如果为支付失败,则把订单状态改为支付失败,且生成一条新的订单,返回订单号.

			    2.3 如果支付状态为没有处理,则直接返回这个订单号.

			    2.4 如果状态是其它,则把订单状态改为支付失败,且生成一条新的订单,返回订单号.

			3. 如果第2步查询订单时,查询不到订单,则新建一条订单,返回订单号
			*/
			//*****************************验证开始************************************************
			    // --------------------用户令牌验证------------------------------------
			if(transorder != null){
				String bodyToken=transorder.getBody().getToken();//用户令牌----->业务入口
				String appId=transorder.getApp().getAppId();//应用ID
				Token token = tokenService.getToken(bodyToken,appId);
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录",bodyToken));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				// --------------------用户令牌验证------------------------------------
				
				Integer userId=token.getUserId();
				if( userId != null){
					
					rm.setErrcode(280200);
					rm.setErrmsg(messagebase+"成功");
					//---------------------招标人验证-----------------------------------------------
					//招标人表t_qyzz_biddee 
					QyzzBiddee biddee = qyzzBiddeeMapper.selectByUserId(userId);
					if (biddee == null) {
						log.error(String.format("用户%s查找不到招标方信息,可能未进行资格认证", userId));
						throw new PaasException(PaasException.ERR_BIDDER_INFO_EXCEPTION, "您没有招标方资质认证,请先进行认证");
					}
					//---------------------招标人验证-----------------------------------------------
					//---------------------招标人验证-----------------------------------------------
					//---------------------会员验证-----------------------------------------------
					//通过资质认证查是否为会员
					Integer biddeeId=biddee.getId();
					if(biddeeId != null){
						// 查询招标人会员信息  t_hygl_biddee 招标人会员表
						HyglBiddee hyglBiddee=hyglBiddeeMapper.selectByBiddeeId(biddeeId);
						Date date=new Date();
						if(hyglBiddee != null){
							Date endTime=hyglBiddee.getEndTime();
							if(endTime.getTime()>date.getTime()){
								rm.setErrcode(280201);
								rm.setErrmsg("您已是会员");
							}
						}
						else{
							//***检查用户的订单表有没有购买招标人会员的订单,订单状态为CRT(待支付),调用支付宝网关,查询订单状态*****
							Order order = new Order();
							order.setAppId(appId);
							order.setUserId(userId);
							String productId=transorder.getBody().getProductId();
							order.setProductId(productId);
							//查询订单  t_ddgl_order 订单表
							order=orderMapper.getOrder(order);
							// 如果第2步查询订单时,查询不到订单,则新建一条订单,返回订单号
							if(order == null){
								//如果没有订单则创建订单
								Order createOrder = ordersrv.createOrder(transorder.getApp().getAppId(),productId,userId,100);
								rm.setErrmsg("购买会员成功");
								rm.put("orderId", createOrder.getOrderId());
							}else{
								//支付宝网关支付查询接口
								//订单id,对应支付宝的outTradeId
								PayResult pr = ordersrv.queryPayResult(order.getOrderId(),order.getPayType());
								if(pr==null){
									//访问 失败
									log.error(String.format("调用支付宝网关支付查询接口,返回结果为空,订单id为%s",order.getOrderId()));
									throw ValidateException.ERROR_SYSTEM_INTERNAL.clone(null, "无法知道您上一笔订单的支付情况,不能处理");
								}
								else{
									if(CommonStatusConst.STATUS_OK.equals(pr.getPayStatus())){
										//支付成功
										ordersrv.paySuccess(order);
									}
									else if("NON".equals(pr.getPayStatus())){
										// 未支付,使用原来的订单id
										rm.setErrmsg("购买会员成功");
										rm.put("orderId", order.getOrderId());
										
									}
									else if("CRT".equals(pr.getPayStatus()))
									{
										//待支付,关闭原来的支付
										
									}
									else{
										//支付失败等
										order.setPayStatus("FLS");
										order.setUpdateTime(new Date());
										orderMapper.updateByPrimaryKey(order);
									}
								}
							}
						}
//						}else{
//							//***检查用户的订单表有没有购买招标人会员的订单,订单状态为CRT(待支付),调用支付宝网关,查询订单状态*****
//							Order order = new Order();
//							order.setAppId(appId);
//							order.setUserId(userId);
//							String productId=transorder.getBody().getProductId();
//							order.setProductId(productId);
//							//查询订单  t_ddgl_order 订单表
//							order=orderMapper.getOrder(order);
//							// 如果第2步查询订单时,查询不到订单,则新建一条订单,返回订单号
//							if(order == null){
//								//如果没有订单则创建订单
//								Order ord = new Order();
//								String orderId = AccountGenerationUtil.genNO("RM",8);//订单号
//								ord.setInsertTime(date);//创建时间
//								ord.setProductId( productId);//产品ID
//								OrderProduct orderProduct=orderProductMapper.selectByPrimaryKey(productId);
//								Long amount=null;
//								if( orderProduct != null){
//									amount=orderProduct.getPrice()*1;
//									ord.setProductCount(1);//产品数量
//									ord.setProductPrice(orderProduct.getPrice());//产品单价
//									ord.setAmount(amount);//总价
//									ord.setProductDesc(orderProduct.getProductDescription());//产品描述
//								}
//								ord.setUpdateTime(date);//更新时间
//								User user =userMapper.selectByPrimaryKey(userId);
//								if(user != null){
//									ord.setCreateBy(user.getUserName());//创建人
//									ord.setUserId(userId);//用户id
//								}
//								ord.setPayType("CAS");//支付类型
//								ord.setPayStatus("CRT");//支付状态
//								ord.setAppId(appId);//应用id
//								ord.setDiscount(100);//产品折扣
//								ord.setRealAmount(amount);//折后价格
//								ord.setOrderId(orderId);
//								int number=orderMapper.insert(ord);
//								if(number>0){
//									rm.setErrmsg("购买会员成功");
//									rm.put("orderId", orderId);
//								}
//							}else{
//								//支付宝网关支付查询接口
//								//订单id,对应支付宝的outTradeId
//								PropertiesUtil pu = new PropertiesUtil();
//								ObjectMapper mapper = new ObjectMapper();
//								mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,Boolean.TRUE);
//								AlipayGatewayVO alipayGatewayVO=new AlipayGatewayVO();
//								String orderId=order.getOrderId();
//								alipayGatewayVO.setOrderId(orderId);
//								BaseTransVO<AlipayGatewayVO> transVO = new BaseTransVO<AlipayGatewayVO>();
//								transVO.setBody(alipayGatewayVO);
//								String requestJson = mapper.writeValueAsString(transVO);
//								//调用支付宝网关,查询订单状态
//								String paygatewayUrl = String.format("%s/order/query",pu.getProperty("map.url"));
//								String result = new HttpRequester().postRequest(paygatewayUrl,requestJson);
//								if(result !=null ){
//									QueryAlipayGatewayVO queryAlipayGatewayVO=RequestUtil.convertJson2Obj(result, QueryAlipayGatewayVO.class);
//									if(queryAlipayGatewayVO != null){
//										String falg=queryAlipayGatewayVO.getResult().getStatus();
///*										如果为已支付,则把订单状态改为已支付,且为用户添加会员身份(如果原来没有会员,则添加会员,如果原来有会员,
//										则调整会员的开始时间和结束时间),在会员升级表添加一条历史记录,并且返回{"errcode":210106,"errmsg":"您已是会员"},
//										其中errcode中的 21010 要根据功能编号来改.
//										*/
//										if(falg.equals("OK#")){
//											
//											//****************订单更新状态操作***********************
//											order.setPayStatus("OK#");
//											order.setUpdateTime(new Date());
//											int updateCount=orderMapper.updateByPrimaryKey(order);
//											//****************订单更新状态操作***********************
//											if(updateCount>0){
//												rm.setErrmsg("您已是会员");
//												//******************支付宝支付记录表****start**************************
//												PaymentAlipay paymentAlipay=new PaymentAlipay();
//												paymentAlipay.setOrderId(orderId);//订单号
//												String tradeId=queryAlipayGatewayVO.getResult().getAlipayOrderId();//支付宝订单号
//												paymentAlipay.setTradeId(tradeId);////支付宝订单号
//												paymentAlipay.setPayStatus(order.getPayStatus());//支付状态
//												paymentAlipay.setProductDesc(order.getProductDesc());//产品描述
//												paymentAlipay.setAppId(appId);//应用ID
//												paymentAlipay.setInsertTime(date);//新增时间
//												//执行支付宝支付记录表t_ddgl_payment_alipay
//												PaymentAlipayMapper.insert(paymentAlipay);
//												//******************支付宝支付记录表*****end************************* 
//												
//												MemberProductAttr memberProductAttr=MemberProductAttrMapper.selectByPrimaryKey(productId);
//												
//												//******************招标人会员表	*****start************************* 
//												hyglBiddee=hyglBiddeeMapper.selectByBiddeeId(biddeeId);
//												Calendar rightNow = Calendar.getInstance();
//												Date startTime=rightNow.getTime();
//												rightNow.add(Calendar.YEAR, 1);
//												Date hyglendTime=rightNow.getTime();
//												boolean hyglBiddeeFalg=false;
//												if(hyglBiddee != null){
//
//													hyglBiddee.setStartTime(startTime);//会员开始时间
//													hyglBiddee.setEndTime(hyglendTime);//会员结束时间
//													int count=hyglBiddeeMapper.updateByPrimaryKey(hyglBiddee);
//													if(count>0){
//														hyglBiddeeFalg=true;
//													}
//												}else{
//													hyglBiddee=new HyglBiddee();
//													hyglBiddee.setBiddeeId(biddeeId);//招标人id
//													hyglBiddee.setStartTime(startTime);//会员开始时间
//													hyglBiddee.setEndTime(hyglendTime);//会员结束时间
//													
//													if(memberProductAttr != null){
//														hyglBiddee.setMemberLevel(memberProductAttr.getLevel());//会员级别
//													}
//													int count=hyglBiddeeMapper.insert(hyglBiddee);
//													if(count>0){
//														hyglBiddeeFalg=true;
//													}
//													//会员级别
//												}
//												//******************招标人会员表	*****end************************* 
//												
//												//***********************招标人会员购买记录表************************
//												if(hyglBiddeeFalg){
//													BiddeeUpgrade biddeeUpgrade=new BiddeeUpgrade();
//													biddeeUpgrade.setBiddeeId(biddeeId);//招标人id
//													biddeeUpgrade.setMemberLevel(memberProductAttr.getLevel());//会员级别
//													biddeeUpgrade.setInsertTime(startTime);//更新时间
//													biddeeUpgrade.setAmount(order.getProductPrice().intValue());//升级价格
//													biddeeUpgrade.setProductId(productId);
//													biddeeUpgradeMapper.insert(biddeeUpgrade);
//												}
//												//***********************招标人会员购买记录表************************
//											}	
//										}else if(falg.equals("FLS")){
//											order.setPayStatus("FLS");
//											int updateCount=orderMapper.updateByPrimaryKey(order);
//											if(updateCount>0){
//												rm.setErrmsg("购买会员失败");
//												//如果没有订单则创建订单
//												Order ord = new Order();
//												String orderNumber  = AccountGenerationUtil.genNO("RM",8);//订单号
//												ord.setInsertTime(date);//创建时间
//												ord.setProductId( productId);//产品ID
//												OrderProduct orderProduct=orderProductMapper.selectByPrimaryKey(productId);
//												Long amount=null;
//												if( orderProduct != null){
//													amount=orderProduct.getPrice()*1;
//													ord.setProductCount(1);//产品数量
//													ord.setProductPrice(orderProduct.getPrice());//产品单价
//													ord.setAmount(amount);//总价
//													ord.setProductDesc(orderProduct.getProductDescription());//产品描述
//												}
//												ord.setUpdateTime(date);//更新时间
//												User user =userMapper.selectByPrimaryKey(userId);
//												if(user != null){
//													ord.setCreateBy(user.getUserName());//创建人
//													ord.setUserId(userId);//用户id
//												}
//												ord.setPayType("CAS");//支付类型
//												ord.setPayStatus("CRT");//支付状态
//												ord.setAppId(appId);//应用id
//												ord.setDiscount(100);//产品折扣
//												ord.setRealAmount(amount);//折后价格
//												ord.setOrderId(orderNumber);//订单号
//												int number=orderMapper.insert(ord);
//												if(number>0){
//													rm.setErrmsg("购买会员成功");
//													rm.put("orderId", orderNumber);
//												}
//											}
//
//										}else if(falg.equals("NON")){
//											rm.put("orderId", order.getOrderId());
//										}else if(falg.equals("OTH")){
//											//如果没有订单则创建订单
//											Order ord = new Order();
//											String orderNumber  = AccountGenerationUtil.genNO("RM",8);//订单号
//											ord.setInsertTime(date);//创建时间
//											ord.setProductId( productId);//产品ID
//											OrderProduct orderProduct=orderProductMapper.selectByPrimaryKey(productId);
//											Long amount=null;
//											if( orderProduct != null){
//												amount=orderProduct.getPrice()*1;
//												ord.setProductCount(1);//产品数量
//												ord.setProductPrice(orderProduct.getPrice());//产品单价
//												ord.setAmount(amount);//总价
//												ord.setProductDesc(orderProduct.getProductDescription());//产品描述
//											}
//											ord.setUpdateTime(date);//更新时间
//											User user =userMapper.selectByPrimaryKey(userId);
//											if(user != null){
//												ord.setCreateBy(user.getUserName());//创建人
//												ord.setUserId(userId);//用户id
//											}
//											ord.setPayType("CAS");//支付类型
//											ord.setPayStatus("CRT");//支付状态
//											ord.setAppId(appId);//应用id
//											ord.setDiscount(100);//产品折扣
//											ord.setRealAmount(amount);//折后价格
//											ord.setOrderId(orderNumber);//订单号
//											int number=orderMapper.insert(ord);
//											if(number>0){
//												rm.setErrmsg("购买会员成功");
//												rm.put("orderId", orderNumber);
//											}
//										}
//										
//									}
//								}
//							}
//						}
					}
					}
					tokenService.postponeToken(token);
					}
			
			//---------------------会员验证-----------------------------------------------
			//*****************************验证开始************************************************
			
		}catch (Exception e) {
			
			rm.setErrcode(850001);
			rm.setErrmsg(messagebase+"失败");
			log.error(String.format(messagebase + "失败"), e);
			rm.mergeException(e);
		}
		return rm;
    }	
    //购买招标方会员
    @RequestMapping(value = "/buyBidderMember", method = RequestMethod.POST)
    @AccessRequered(methodName = "购买投标方会员接口", isJson = true, codebase = 280200, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.BuyBiddeeVIPListVO", appLog = true)
  	public @ResponseBody ResultModel buyBidderMember(HttpServletRequest request, HttpServletResponse response) {
    	//结果集汇总
		ResultModel rm = super.getResultModel();
		//接受查询参数
		BaseTransVO<BuyBiddeeVIPListVO> transorder = (BaseTransVO<BuyBiddeeVIPListVO>) super.getParameterObject();
		String messagebase = "购买投标方会员";
		try {
			/*
			 * 1. 查询用户的身份,如果用户不是通过招标人资质,不能购买.如果用户已有招标人会员(在有效期内),则也不能购买

			2. 检查用户的订单表有没有购买招标人会员的订单,订单状态为CRT(待支付),调用支付宝网关,查询订单状态

			    如果有记录,记录状态可为 OK#已支付,FLS支付失败,NON没有处理,OTH其它状态(如订单取消)

			    2.1 如果为已支付,则把订单状态改为已支付,且为用户添加会员身份(如果原来没有会员,则添加会员,如果原来有会员,则调整会员的开始时间和结束时间),在会员升级表添加一条历史记录,并且返回{"errcode":210106,"errmsg":"您已是会员"},其中errcode中的 21010 要根据功能编号来改.

			    2.2 如果为支付失败,则把订单状态改为支付失败,且生成一条新的订单,返回订单号.

			    2.3 如果支付状态为没有处理,则直接返回这个订单号.

			    2.4 如果状态是其它,则把订单状态改为支付失败,且生成一条新的订单,返回订单号.

			3. 如果第2步查询订单时,查询不到订单,则新建一条订单,返回订单号
			*/
			//*****************************验证开始************************************************
			    // --------------------用户令牌验证------------------------------------
			if(transorder != null){
				String bodyToken=transorder.getBody().getToken();//用户令牌----->业务入口
				String appId=transorder.getApp().getAppId();//应用ID
				Token token = tokenService.getToken(bodyToken,appId);
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录",bodyToken));
					throw new TokenException("token验证失败,或已过期,请重新登录");
				}
				// --------------------用户令牌验证------------------------------------
				
				Integer userId=token.getUserId();
				if( userId != null){
					
					//---------------------招标人验证-----------------------------------------------
					//招标人表t_qyzz_biddee 
					QyzzBidder bidder = qyzzBidderMapper.selectByUserId(userId);
					if (bidder == null) {
						log.error(String.format("用户%s查找不到投标方信息,可能未进行资格认证", userId));
						throw new PaasException(PaasException.ERR_BIDDER_INFO_EXCEPTION, "您没有投标方资质认证,请先进行认证");
					}
					//---------------------招标人验证-----------------------------------------------
					//---------------------招标人验证-----------------------------------------------
					//---------------------会员验证-----------------------------------------------
					//通过资质认证查是否为会员
					Integer bidderId=bidder.getId();
					if(bidderId != null){
						// 查询招标人会员信息  t_hygl_biddee 招标人会员表
						HyglBidder hyglBidder=hyglBidderMapper.selectByBidderId(bidderId);
						Date date=new Date();
						if(hyglBidder != null ){
							Date endTime=hyglBidder.getEndTime();
							if(endTime.getTime()>date.getTime()){
								
								rm.setErrcode(280201);
								rm.setErrmsg("您已是会员");
							}
						}else{
							//***检查用户的订单表有没有购买招标人会员的订单,订单状态为CRT(待支付),调用支付宝网关,查询订单状态*****
							Order order = new Order();
							order.setAppId(appId);
							order.setUserId(userId);
							String productId=transorder.getBody().getProductId();
							order.setProductId(productId);
							//查询订单  t_ddgl_order 订单表
							order=orderMapper.getOrder(order);
							// 如果第2步查询订单时,查询不到订单,则新建一条订单,返回订单号
							if(order == null){
								//如果没有订单则创建订单
								Order createOrder = ordersrv.createOrder(transorder.getApp().getAppId(),productId,userId,100);
								rm.setErrmsg("购买会员成功");
								rm.put("orderId", createOrder.getOrderId());
							}else{
								//支付宝网关支付查询接口
								//订单id,对应支付宝的outTradeId
								PayResult pr = ordersrv.queryPayResult(order.getOrderId(),order.getPayType());
								if(pr==null){
									//访问 失败
									log.error(String.format("调用支付宝网关支付查询接口,返回结果为空,订单id为%s",order.getOrderId()));
									throw ValidateException.ERROR_SYSTEM_INTERNAL.clone(null, "无法知道您上一笔订单的支付情况,不能处理");
								}
								else{
									if(CommonStatusConst.STATUS_OK.equals(pr.getPayStatus())){
										//支付成功
										ordersrv.paySuccess(order);
									}
									else if("NON".equals(pr.getPayStatus())){
										// 未支付,使用原来的订单id
										rm.setErrmsg("购买会员成功");
										rm.put("orderId", order.getOrderId());
										
									}
									else if("CRT".equals(pr.getPayStatus()))
									{
										//待支付,关闭原来的支付
										
									}
									else{
										//支付失败等
										order.setPayStatus("FLS");
										order.setUpdateTime(new Date());
										orderMapper.updateByPrimaryKey(order);
									}
								}
//								PropertiesUtil pu = new PropertiesUtil();
//								ObjectMapper mapper = new ObjectMapper();
//								mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,Boolean.TRUE);
//								AlipayGatewayVO alipayGatewayVO=new AlipayGatewayVO();
//								String orderId=order.getOrderId();
//								alipayGatewayVO.setOrderId(orderId);
//								BaseTransVO<AlipayGatewayVO> transVO = new BaseTransVO<AlipayGatewayVO>();
//								transVO.setBody(alipayGatewayVO);
//								String requestJson = mapper.writeValueAsString(transVO);
//								//调用支付宝网关,查询订单状态
//								String paygatewayUrl = String.format("%s/order/query",pu.getProperty("map.url"));
//								String result = new HttpRequester().postRequest(paygatewayUrl,requestJson);
//								if(result !=null ){
//									QueryAlipayGatewayVO queryAlipayGatewayVO=RequestUtil.convertJson2Obj(result, QueryAlipayGatewayVO.class);
//									if(queryAlipayGatewayVO != null){
//										String falg=queryAlipayGatewayVO.getResult().getStatus();
///*										如果为已支付,则把订单状态改为已支付,且为用户添加会员身份(如果原来没有会员,则添加会员,如果原来有会员,
//										则调整会员的开始时间和结束时间),在会员升级表添加一条历史记录,并且返回{"errcode":210106,"errmsg":"您已是会员"},
//										其中errcode中的 21010 要根据功能编号来改.
//										*/
//										if(falg.equals("OK#")){
//											
//											//****************订单更新状态操作***********************
//											order.setPayStatus("OK#");
//											order.setUpdateTime(new Date());
//											int updateCount=orderMapper.updateByPrimaryKey(order);
//											//****************订单更新状态操作***********************
//											if(updateCount>0){
//												rm.setErrmsg("您已是会员");
//												//******************支付宝支付记录表****start**************************
//												PaymentAlipay paymentAlipay=new PaymentAlipay();
//												paymentAlipay.setOrderId(orderId);//订单号
//												String tradeId=queryAlipayGatewayVO.getResult().getAlipayOrderId();//支付宝订单号
//												paymentAlipay.setTradeId(tradeId);////支付宝订单号
//												paymentAlipay.setPayStatus(order.getPayStatus());//支付状态
//												paymentAlipay.setProductDesc(order.getProductDesc());//产品描述
//												paymentAlipay.setAppId(appId);//应用ID
//												paymentAlipay.setInsertTime(date);//新增时间
//												//执行支付宝支付记录表t_ddgl_payment_alipay
//												PaymentAlipayMapper.insert(paymentAlipay);
//												//******************支付宝支付记录表*****end************************* 
//												
//												MemberProductAttr memberProductAttr=MemberProductAttrMapper.selectByPrimaryKey(productId);
//												
//												//******************招标人会员表	*****start************************* 
//												hyglBidder=hyglBidderMapper.selectByBidderId(bidderId);
//												Calendar rightNow = Calendar.getInstance();
//												Date startTime=rightNow.getTime();
//												rightNow.add(Calendar.YEAR, 1);
//												Date hyglendTime=rightNow.getTime();
//												boolean hyglBidderFalg=false;
//												if(hyglBidder != null){
//
//													hyglBidder.setStartTime(startTime);//会员开始时间
//													hyglBidder.setEndTime(hyglendTime);//会员结束时间
//													int count=hyglBidderMapper.updateByPrimaryKey(hyglBidder);
//													if(count>0){
//														hyglBidderFalg=true;
//													}
//												}else{
//													hyglBidder=new HyglBidder();
//													hyglBidder.setBidderId(bidderId);//招标人id
//													hyglBidder.setStartTime(startTime);//会员开始时间
//													hyglBidder.setEndTime(hyglendTime);//会员结束时间
//													
//													if(memberProductAttr != null){
//														hyglBidder.setMemberLevel(memberProductAttr.getLevel());//会员级别
//													}
//													int count=hyglBidderMapper.insert(hyglBidder);
//													if(count>0){
//														hyglBidderFalg=true;
//													}
//													//会员级别
//												}
//												//******************招标人会员表	*****end************************* 
//												
//												//***********************招标人会员购买记录表************************
//												if(hyglBidderFalg){
//													BidderUpgrade bidderUpgrade=new BidderUpgrade();
//													bidderUpgrade.setBidderId(bidderId);//招标人id
//													bidderUpgrade.setMemberLevel(memberProductAttr.getLevel());//会员级别
//													bidderUpgrade.setInsertTime(startTime);//更新时间
//													bidderUpgrade.setAmount(order.getProductPrice().intValue());//升级价格
//													bidderUpgrade.setProductId(productId);
//													bidderUpgradeMapper.insert(bidderUpgrade);
//												}
//												//***********************招标人会员购买记录表************************
//											}	
//										}else if(falg.equals("FLS")){
//											order.setPayStatus("FLS");
//											int updateCount=orderMapper.updateByPrimaryKey(order);
//											if(updateCount>0){
//												rm.setErrmsg("购买会员失败");
//												//如果没有订单则创建订单
//												Order ord = new Order();
//												String orderNumber  = AccountGenerationUtil.genNO("RM",8);//订单号
//												ord.setInsertTime(date);//创建时间
//												ord.setProductId( productId);//产品ID
//												OrderProduct orderProduct=orderProductMapper.selectByPrimaryKey(productId);
//												Long amount=null;
//												if( orderProduct != null){
//													amount=orderProduct.getPrice()*1;
//													ord.setProductCount(1);//产品数量
//													ord.setProductPrice(orderProduct.getPrice());//产品单价
//													ord.setAmount(amount);//总价
//													ord.setProductDesc(orderProduct.getProductDescription());//产品描述
//												}
//												ord.setUpdateTime(date);//更新时间
//												User user =userMapper.selectByPrimaryKey(userId);
//												if(user != null){
//													ord.setCreateBy(user.getUserName());//创建人
//													ord.setUserId(userId);//用户id
//												}
//												ord.setPayType("CAS");//支付类型
//												ord.setPayStatus("CRT");//支付状态
//												ord.setAppId(appId);//应用id
//												ord.setDiscount(100);//产品折扣
//												ord.setRealAmount(amount);//折后价格
//												ord.setOrderId(orderNumber);//订单号
//												int number=orderMapper.insert(ord);
//												if(number>0){
//													rm.setErrmsg("购买会员成功");
//													rm.put("orderId", orderNumber);
//												}
//											}
//
//										}else if(falg.equals("NON")){
//											rm.put("orderId", order.getOrderId());
//										}else if(falg.equals("OTH")){
//											//如果没有订单则创建订单
//											Order ord = new Order();
//											String orderNumber  = AccountGenerationUtil.genNO("RM",8);//订单号
//											ord.setInsertTime(date);//创建时间
//											ord.setProductId( productId);//产品ID
//											OrderProduct orderProduct=orderProductMapper.selectByPrimaryKey(productId);
//											Long amount=null;
//											if( orderProduct != null){
//												amount=orderProduct.getPrice()*1;
//												ord.setProductCount(1);//产品数量
//												ord.setProductPrice(orderProduct.getPrice());//产品单价
//												ord.setAmount(amount);//总价
//												ord.setProductDesc(orderProduct.getProductDescription());//产品描述
//											}
//											ord.setUpdateTime(date);//更新时间
//											User user =userMapper.selectByPrimaryKey(userId);
//											if(user != null){
//												ord.setCreateBy(user.getUserName());//创建人
//												ord.setUserId(userId);//用户id
//											}
//											ord.setPayType("CAS");//支付类型
//											ord.setPayStatus("CRT");//支付状态
//											ord.setAppId(appId);//应用id
//											ord.setDiscount(100);//产品折扣
//											ord.setRealAmount(amount);//折后价格
//											ord.setOrderId(orderNumber);//订单号
//											int number=orderMapper.insert(ord);
//											if(number>0){
//												rm.setErrmsg("购买会员成功");
//												rm.put("orderId", orderNumber);
//											}
//										}
//										
//									}
//								}
							}
						}
					}
					}
					tokenService.postponeToken(token);
					}
			
			//---------------------会员验证-----------------------------------------------
			//*****************************验证开始************************************************
			
		}catch (Exception e) {
			
			rm.setErrcode(850001);
			rm.setErrmsg(messagebase+"失败");
			log.error(String.format(messagebase + "失败"), e);
			rm.mergeException(e);
		}
		return rm;
    }
}