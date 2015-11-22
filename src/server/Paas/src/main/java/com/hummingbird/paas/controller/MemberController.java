package com.hummingbird.paas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.services.MemberService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.BuyTenderMemberVO;
import com.hummingbird.paas.vo.MemberQueryMemberInfoVO;
import com.hummingbird.paas.vo.QueryMemberInfoResultVO;
import com.hummingbird.paas.vo.QueryMemberProductResultVO;
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController{


    @Autowired
    private MemberService mservice;
	@Autowired
	private TokenService tokenSrv;
    @RequestMapping(value = "/queryMemberInfo", method = RequestMethod.POST)
	public @ResponseBody ResultModel queryMemberInfo(HttpServletRequest request) {
		if(log.isDebugEnabled()){
			log.debug("查询会员方法中");
		}
		MemberQueryMemberInfoVO transorder;
		ResultModel rm = new ResultModel();
		String messagebase = "查询会员";
		rm.setBaseErrorCode(280100);
		rm.setErrmsg(messagebase+"成功");
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, MemberQueryMemberInfoVO.class);
		} catch (Exception e) {
			log.error(String.format("参数转化出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		Token token = null;
		token = tokenSrv.getToken(transorder.getBody().getToken(),transorder.getApp().getAppId());
		if(token==null){
			log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
			rm.setErrcode(280101);
			rm.setErrmsg("token[%s]验证失败,或已过期,请重新登录");
			return rm;
		}
		List<QueryMemberInfoResultVO> qminfos = new ArrayList<QueryMemberInfoResultVO>(0);
		try {
			qminfos =mservice.querysMemberInfo(token.getToken());
		} catch (BusinessException e1) {
			rm.setErrcode(280105);
			rm.setErrmsg("鏌ヨ浼氬憳淇℃伅澶辫触");
			return rm;
		}
		try {
			if(qminfos.size()>0){
			String infos = JsonUtil.convert2Json(qminfos);
			rm.put("info",infos);
			}else{
				rm.put("info","获取信息为空");
			}
		} catch (DataInvalidException e) {
			log.error(String.format("会员信息参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "会员信息转化字符串失败"));
			return rm;
		}
		if(log.isDebugEnabled()){
			log.debug("查询会员信息参数成功");
		}
		return rm;
    }	
    //查询可购买的会员
    @RequestMapping(value = "/queryMemberProduct", method = RequestMethod.POST)
  	public @ResponseBody ResultModel queryMemberProduct(HttpServletRequest request) {
		if(log.isDebugEnabled()){
			log.debug("查询可购买会员方法中");
		}
		MemberQueryMemberInfoVO transorder;
		ResultModel rm = new ResultModel();
		String messagebase = "查询可购买会员";
		rm.setBaseErrorCode(280100);
		rm.setErrmsg(messagebase+"成功");
		Token token = null;
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, MemberQueryMemberInfoVO.class);
		} catch (Exception e) {
			log.error(String.format("参数转化出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		token = tokenSrv.getToken(transorder.getBody().getToken(),transorder.getApp().getAppId());
		if(token==null){
			log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
			rm.setErrcode(280101);
			rm.setErrmsg("token[%s]验证失败,或已过期,请重新登录");
			return rm;
		}
		QueryMemberProductResultVO res = mservice.querysAvailableProducts(token.getToken());
        rm.put("results", res.getResults());
        rm.put("teeMember",res.getTeeMember());
        rm.put("teeMemberExpireTime", res.getTeeMemberExpireTime());
		rm.put("terMember",res.getTerMember());
		rm.put("terMemberExpireTime",res.getTerMemberExpireTime());
        if(log.isDebugEnabled()){
			log.debug("查询可购买会员成功");
		}
		return rm;
    }	
    //购买招标方会员
    @RequestMapping(value = "/buyPrivilegeMember", method = RequestMethod.POST)
  	public @ResponseBody ResultModel buyPrivilegeMember(HttpServletRequest request) {
		if(log.isDebugEnabled()){
			log.debug("购买招标方会员");
		}
		BuyTenderMemberVO  transorder;
		ResultModel rm = new ResultModel();
		String messagebase = "购买招标方会员";
		rm.setBaseErrorCode(280100);
		rm.setErrmsg(messagebase+"成功");
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BuyTenderMemberVO.class);
		} catch (Exception e) {
			log.error(String.format("参数转化出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		Token token = null;
		token = tokenSrv.getToken(transorder.getBody().getToken(),transorder.getApp().getAppId());
		if(token==null){
			log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
			rm.setErrcode(280101);
			rm.setErrmsg("token[%s]验证失败,或已过期,请重新登录");
			return rm;
		}
	    String  orderId = mservice.buyPrivilegeMember(transorder.getBody(),transorder.getApp().getAppId());
        if(StringUtils.isBlank(orderId)){
        	rm.setErrcode(280124);
        	rm.setErrmsg("获取订单参数为空，错误");
            return rm;
        }
        rm.put("orderId",orderId);
	    if(log.isDebugEnabled()){
			log.debug("购买招标方会员");
		}
		return rm;
    }	
    //购买招标方会员
    @RequestMapping(value = "/buyTenderMember", method = RequestMethod.POST)
  	public @ResponseBody ResultModel buyTenderMember(HttpServletRequest request) {
		if(log.isDebugEnabled()){
			log.debug("购买投标方会员");
		}
		BuyTenderMemberVO  transorder;
		ResultModel rm = new ResultModel();
		String messagebase = "购买投标方会员";
		rm.setBaseErrorCode(280100);
		rm.setErrmsg(messagebase+"成功");
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BuyTenderMemberVO.class);
		} catch (Exception e) {
			log.error(String.format("参数转化出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		Token token = null;
		token = tokenSrv.getToken(transorder.getBody().getToken(),transorder.getApp().getAppId());
		if(token==null){
			log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
			rm.setErrcode(280101);
			rm.setErrmsg("token[%s]验证失败,或已过期,请重新登录");
			return rm;
		}
	    String  orderId = mservice.buyPrivilegeMember(transorder.getBody(),transorder.getApp().getAppId());
        if(StringUtils.isBlank(orderId)){
        	rm.setErrcode(280124);
        	rm.setErrmsg("获取订单参数为空，错误");
            return rm;
        }
        rm.put("orderId",orderId);
	    if(log.isDebugEnabled()){
			log.debug("购买投标方会员");
		}
		return rm;
    }	
}