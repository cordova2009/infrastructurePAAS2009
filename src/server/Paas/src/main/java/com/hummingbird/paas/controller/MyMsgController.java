package com.hummingbird.paas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.services.MymsgService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.GetMsgListResultVO;
import com.hummingbird.paas.vo.GetMsgListVO;
import com.hummingbird.paas.vo.MemberQueryMemberInfoVO;
@Controller
@RequestMapping("/myMsg")
public class MyMsgController extends BaseController {
	 @Autowired
	 MymsgService msgSer;
	 @Autowired
	 TokenService tokenSrv;
	@Autowired
	AppLogMapper applogDao;
		
	 @RequestMapping(value = "/getMsgList", method = RequestMethod.POST)
		public @ResponseBody ResultModel queryMemberInfo(HttpServletRequest request) {
			if(log.isDebugEnabled()){
				log.debug("查询我的消息列表中");
			}
			GetMsgListVO transorder;
			RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求
			ResultModel rm = new ResultModel();
			String messagebase = "查询我的消息列表";
			rm.setBaseErrorCode(280100);
			rm.setErrmsg(messagebase+"成功");
//			String token = null;
			try {
				String jsonstr = RequestUtil.getRequestPostData(request);
				request.setAttribute("rawjson", jsonstr);
				transorder = RequestUtil.convertJson2Obj(jsonstr, GetMsgListVO.class);
//			    token = transorder.getBody().getToken();
			} catch (Exception e) {
				log.error(String.format("参数转化出错"),e);
				rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "参数"));
				return rm;
			}
			try {
				// 业务数据必填等校验
				Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
				if (token == null) {
					log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
					
						throw new TokenException("token验证失败,或已过期,请重新登录");
					
				}
				Integer pageSize = transorder.getBody().getPageSize();
				Integer pageIndex = transorder.getBody().getPageIndex();
				GetMsgListResultVO gv = msgSer.getMsgList(token.getToken(), pageIndex, pageSize);
				if(gv!=null){
				     rm.put("data",gv.getData());
				     rm.put("total",gv.getTotal());
				}else{
					rm.setErrcode(280110);
					rm.setErrmsg("查询得到结果为空");
				}
				if(log.isDebugEnabled()){
					log.debug("查询我的消息列表");
				}
				rm.put("pageIndex", pageIndex);
				rm.put("pageSize", pageSize);
			} catch (Exception e1) {
				log.error(String.format(messagebase + "失败"), e1);
				rm.mergeException(e1);
				if (qe != null)
					qe.setSuccessed(false);
			} finally {
				if (qe != null)
					EventListenerContainer.getInstance().fireEvent(qe);
			}
			return rm;
	    }	
	    @RequestMapping(value = "/getUnreadMsgNum"/*, method = RequestMethod.POST*/)
		public @ResponseBody ResultModel getUnreadMsgNum(HttpServletRequest request) {
			if(log.isDebugEnabled()){
				log.debug("取我的未读消息个数接口");
			}
			MemberQueryMemberInfoVO transorder;
			RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求
			ResultModel rm = new ResultModel();
			String messagebase = "取我的消息未读个数接口";
			rm.setBaseErrorCode(280100);
			rm.setErrmsg(messagebase+"成功");
//			String token = null;
			try {
				String jsonstr = RequestUtil.getRequestPostData(request);
				request.setAttribute("rawjson", jsonstr);
				transorder = RequestUtil.convertJson2Obj(jsonstr, MemberQueryMemberInfoVO.class);
//			    token = transorder.getBody().getToken();
			} catch (Exception e) {
				log.error(String.format("参数转化出错"),e);
				rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "参数"));
				return rm;
			}
			try {
			// 业务数据必填等校验
			Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
			if (token == null) {
				log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
				
				
						throw new TokenException("token验证失败,或已过期,请重新登录");
				
			}
		    Integer count  = msgSer.getUnreadMsgNum(token.getToken());
		    System.out.println(count);
		    if(count==null){
		    	log.error("获取数据为空");
		    	rm.setErrcode(290112);
		    	rm.setErrmsg("获取总数为空");
		    	return rm;
		    }
		    rm.put("unreadMsgNum", count);
		    if(log.isDebugEnabled()){
				log.debug("取我的未读消息个数接口完成");
			}
		
			} catch (Exception e1) {
				log.error(String.format(messagebase + "失败"), e1);
				rm.mergeException(e1);
				if (qe != null)
					qe.setSuccessed(false);
			} finally {
				if (qe != null)
					EventListenerContainer.getInstance().fireEvent(qe);
			}
			return rm;
	    }	
		
		/**
		 * 写日志,需要由子类实现
		 * @param applog
		 */
		protected void writeAppLog(AbstractAppLog applog) {
			if(applog!=null){
				applogDao.insert(new AppLog(applog));
			}
		}
}
