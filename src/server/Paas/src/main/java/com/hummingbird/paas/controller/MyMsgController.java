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
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.exception.TokenException;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.UserNotices;
import com.hummingbird.paas.exception.PaasException;
import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.services.MymsgService;
import com.hummingbird.paas.services.TokenService;
import com.hummingbird.paas.vo.GetMsgBodyVO;
import com.hummingbird.paas.vo.GetMsgListResultBodyVO;
import com.hummingbird.paas.vo.GetMsgListResultVO;
import com.hummingbird.paas.vo.GetMsgListVO;
import com.hummingbird.paas.vo.MemberQueryMemberInfoVO;
import com.hummingbird.paas.vo.QueryObjectBodyVO;
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
				GetMsgListResultVO gv = msgSer.getMsgList(token.getUserId(), pageIndex, pageSize);
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
				tokenSrv.postponeToken(token);
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
	 
	    @RequestMapping(value = "/getUnreadMsgNum", method = RequestMethod.POST)
		public @ResponseBody ResultModel getUnreadMsgNum(HttpServletRequest request) {
			if(log.isDebugEnabled()){
				log.debug("取我的未读消息个数接口");
			}
			MemberQueryMemberInfoVO transorder;
			RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求
			ResultModel rm = new ResultModel();
			String messagebase = "取我的消息未读个数接口";
			rm.setBaseErrorCode(280200);
			rm.setErrmsg(messagebase+"成功");
//			String token = null;
			try {
				String jsonstr = RequestUtil.getRequestPostData(request);
				request.setAttribute("rawjson", jsonstr);
				transorder = RequestUtil.convertJson2Obj(jsonstr, MemberQueryMemberInfoVO.class);
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
		    Integer count  = msgSer.getUnreadMsgNum(token.getUserId());
		    if(count==null){
		    	log.error("获取数据为空");
		    	rm.setErrcode(rm.getBaseerrcode()+PaasException.ERR_USER_NOTICE_INFO_EXCEPTION);
		    	rm.setErrmsg("获取总数为空");
		    	return rm;
		    }
		    rm.put("unreadMsgNum", count);
		    tokenSrv.postponeToken(token);
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
		
	    @RequestMapping(value = "/getMsgDetail", method = RequestMethod.POST)
	    @AccessRequered(methodName = "获取我的消息详情", isJson = true, codebase = 280300, className = "com.hummingbird.commonbiz.vo.BaseTransVO", genericClassName = "com.hummingbird.paas.vo.GetMsgBodyVO", appLog = true)
	    public @ResponseBody ResultModel getMsgDetail(HttpServletRequest request) {
	    	ResultModel rm = super.getResultModel();
			BaseTransVO<GetMsgBodyVO> transorder = (BaseTransVO<GetMsgBodyVO>) super.getParameterObject();
			String messagebase = "获取我的消息详情";
	    	RequestEvent qe = null; // 业务请求事件,当实现一些关键的业务时,需要生成该请求
	    	try {
	    		// 业务数据必填等校验
	    		Token token = tokenSrv.getToken(transorder.getBody().getToken(), transorder.getApp().getAppId());
	    		if (token == null) {
	    			log.error(String.format("token[%s]验证失败,或已过期,请重新登录", transorder.getBody().getToken()));
	    			throw new TokenException("token验证失败,或已过期,请重新登录");
	    		}
	    		UserNotices un  = msgSer.getMsgDetail(transorder.getBody().getMsgId());
	    		GetMsgListResultBodyVO gb = new GetMsgListResultBodyVO();
				 gb.setIsRead(un.getStatus());
				 gb.setCreateTime(DateUtil.formatCommonDateorNull(un.getInsertTime()));
			     gb.setMsgContent(un.getNoticeText());
			     gb.setMsgId(un.getId());
			     gb.setMsgTitle(un.getNoticeTitle());
			     gb.setMsgType(un.getNoticeType());
			     if(un.getSender()==0){
			    	 gb.setMsgSender("系统");
			     }
			     //TODO 未知sender要怎么弄
	    		rm.put("result", gb);
	    		tokenSrv.postponeToken(token);
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
