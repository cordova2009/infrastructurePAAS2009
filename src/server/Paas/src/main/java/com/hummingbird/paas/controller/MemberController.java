package com.hummingbird.paas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
/*import com.hummingbird.paas.services.MemberService;
import com.hummingbird.paas.vo.MemberQueryMemberInfoVO;
import com.hummingbird.paas.vo.QueryMemberInfoResultVO;
import com.hummingbird.paas.vo.QueryMemberProductResultVO;*/
@Controller
@RequestMapping("/member")
public class MemberController extends BaseController{

/*
    @Autowired
    private MemberService mservice;
	
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
		String token = null;
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, MemberQueryMemberInfoVO.class);
		    token = transorder.getBody().getToken();
		} catch (Exception e) {
			log.error(String.format("参数转化出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		List<QueryMemberInfoResultVO> qminfos = mservice.querysMemberInfo(token);
		try {
			if(qminfos!=null){
			String infos = JsonUtil.convert2Json(qminfos);
			rm.put("info",infos);
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
    @RequestMapping(value = "/buyPrivilegeMember", method = RequestMethod.POST)
  	public @ResponseBody ResultModel buyPrivilegeMember(HttpServletRequest request) {
		if(log.isDebugEnabled()){
			log.debug("查询会员方法中");
		}
		MemberQueryMemberInfoVO transorder;
		ResultModel rm = new ResultModel();
		String messagebase = "查询会员";
		rm.setBaseErrorCode(280100);
		rm.setErrmsg(messagebase+"成功");
		String token = null;
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, MemberQueryMemberInfoVO.class);
		    token = transorder.getBody().getToken();
		} catch (Exception e) {
			log.error(String.format("参数转化出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		QueryMemberProductResultVO res = mservice.querysAvailableProducts(token);
        rm.put("results", res.getResults());
        rm.put("teeMember",res.getTeeMember());
        rm.put("teeMemberExpireTime", res.getTeeMemberExpireTime());
		rm.put("terMember",res.getTerMember());
		rm.put("terMemberExpireTime",res.getTerMemberExpireTime());
        if(log.isDebugEnabled()){
			log.debug("查询可购买会员成功");
		}
		return rm;
    }	*/
  

}