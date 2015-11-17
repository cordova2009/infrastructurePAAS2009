package com.hummingbird.paas.controller;
/**
 * @author YJY 
 * @since 2015年10月28日
 * */
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.weaver.AnnotationNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hummingbird.common.controller.BaseController;
import com.hummingbird.common.event.EventListenerContainer;
import com.hummingbird.common.event.RequestEvent;
import com.hummingbird.common.exception.DataInvalidException;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.ext.AccessRequered;
import com.hummingbird.common.util.CollectionTools;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.commonbiz.vo.BaseTransVO;
import com.hummingbird.paas.entity.Announcement;
import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.entity.InstationNotification;
import com.hummingbird.paas.mapper.AnnouncementMapper;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.mapper.InstationNotificationMapper;
import com.hummingbird.paas.services.InstationNotificationService;
import com.hummingbird.paas.vo.AnnouncementDetailBodyVO;
import com.hummingbird.paas.vo.AnnouncementListBodyVO;
import com.hummingbird.paas.vo.AnnouncementUpdateVO;
import com.hummingbird.paas.vo.SmsDetailBodyVO;
import com.hummingbird.paas.vo.SmsListBodyVO;
import com.hummingbird.paas.vo.SmsUpdateVO;
@Controller
@RequestMapping(value="/message"
		 ,method=RequestMethod.POST)
public class InstationNotificationController extends BaseController  {
	@Autowired
	protected InstationNotificationService notificationService;
	@Autowired
	protected InstationNotificationMapper notificationDao;

	@Autowired(required = true)
	protected AppLogMapper applogDao;
	
	@RequestMapping(value="/getSmsList",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询通知列表历史")
	public @ResponseBody ResultModel QueryMessageList(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341200;//待定
		String messagebase = "查询通知列表";
		BaseTransVO<SmsListBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, SmsListBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "参数异常"));
			return rm;
		}
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/message/getSmsList");
		
		List<InstationNotification> list=new ArrayList<InstationNotification>();
		try {
			com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
			String token = transorder.getBody().getToken();
			String status = transorder.getBody().getStatus();
			list = notificationService.selectByUserInValid(token,status,page);
			List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<InstationNotification, Map>() {

				@Override
				public Map convert(InstationNotification ori) {
					
					try {
						Map row= BeanUtils.describe(ori);
						row.put("insertTime", DateUtil.formatCommonDateorNull(ori.getInsertTime()));
						row.put("updateTime", DateUtil.formatCommonDateorNull(ori.getUpdateTime()));
						row.remove("class");
						return row;
						
					} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
						log.error(String.format("转换为map对象出错"),e);
						return null;
					}
				}
			});
			mergeListOutput(rm, page, nos);
			
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
	}  
	
	@RequestMapping(value="/getUnreadSmsList",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询未读通知列表")
	public @ResponseBody ResultModel QueryUnreadMessageList(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341200;//待定
		String messagebase = "查询未读通知列表";
		BaseTransVO<SmsListBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, SmsListBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "参数异常"));
			return rm;
		}
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/message/getSmsList");
		
		List<InstationNotification> list=new ArrayList<InstationNotification>();
		try {
			com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
			String token = transorder.getBody().getToken();
			String status = "N";//已读
			list = notificationService.selectByUserInValid(token, status, page);
			List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<InstationNotification, Map>() {

				@Override
				public Map convert(InstationNotification ori) {
					
					try {
						Map row= BeanUtils.describe(ori);
						row.put("insertTime", DateUtil.formatCommonDateorNull(ori.getInsertTime()));
						row.put("updateTime", DateUtil.formatCommonDateorNull(ori.getUpdateTime()));
						row.remove("class");
						return row;
						
					} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
						log.error(String.format("转换为map对象出错"),e);
						return null;
					}
				}
			});
			mergeListOutput(rm, page, nos);
			
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
	}  
	
	/**
	 * 查询通知详细
	 * @return
	 */
	@RequestMapping(value="/getsmsinfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查看通知详情")
	// 框架的日志处理
	public @ResponseBody ResultModel getMessageDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查看通知详情";
//		int basecode = 220002;
		BaseTransVO<SmsDetailBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,SmsDetailBodyVO.class);
		} catch (Exception e) {
			log.error(String.format("获取%s参数出错",messagebase),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, messagebase+"参数"));
			return rm;
		}
//		// 预设的一些信息
		
//		rm.setBaseErrorCode(basecode);
		rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;
		
		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/message/getsmsinfo");
		
		try {
			Integer smsId = transorder.getBody().getSmsId();
			Map row= new HashMap();
		if(StringUtils.isNotBlank(ObjectUtils.toString(smsId))){
			InstationNotification n = notificationDao.selectByPrimaryKey(transorder.getBody().getSmsId());
		    row= BeanUtils.describe(n);
			row.put("insertTime", DateUtil.formatCommonDateorNull(n.getInsertTime()));
			row.put("updateTime", DateUtil.formatCommonDateorNull(n.getUpdateTime()));
			row.remove("class");
		}
//			InstationNotification n = notificationDao.selectByPrimaryKey(transorder.getBody().getSmsId());
//		    Map row= BeanUtils.describe(n);
//			row.put("insertTime", DateUtil.formatCommonDateorNull(n.getInsertTime()));
//			row.put("updateTime", DateUtil.formatCommonDateorNull(n.getUpdateTime()));
//			row.remove("class");
			rm.put("result", row);
		}catch (Exception e1) {
			log.error(String.format(messagebase + "失败"), e1);
			rm.mergeException(e1);
			if(qe!=null)
				qe.setSuccessed(false);
		} finally {
			try {
				rnr.setRespone(StringUtils.substring(JsonUtil.convert2Json(rm),0,2000));
				applogDao.insert(rnr);
			} catch (DataInvalidException e) {
				log.error(String.format("日志处理出错"),e);
			}
			
			if(qe!=null)
				EventListenerContainer.getInstance().fireEvent(qe);
		}
		return rm;
		
	}
	
	@RequestMapping(value="/updateSms",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel UpdateUserNotice(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "修改通知信息";
		SmsUpdateVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, SmsUpdateVO.class);
		} catch (Exception e) {
			log.error(String.format("获取参数出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "参数异常"));
			return rm;
		}
		//rm.setErrmsg(messagebase + "成功");
		RequestEvent qe=null ;		
		AppLog rnr = new AppLog();
		rnr.setAppid(transorder.getApp().getAppId());
		rnr.setRequest(ObjectUtils.toString(request.getAttribute("rawjson")));
		rnr.setInserttime(new Date());
		rnr.setMethod("/message/updateSms");
		
		try {
		Integer smsId =  transorder.getBody().getSmsId();
		String  token = transorder.getBody().getToken();
		Integer expiryDate = transorder.getBody().getExpiryDate();
		String  noticeText = transorder.getBody().getNoticeText();
		String  noticeTitle = transorder.getBody().getNoticeTitle();
		String  noticeType= transorder.getBody().getNoticeType();
		int i= 0;
		if(StringUtils.isNotBlank(ObjectUtils.toString(smsId))){
			InstationNotification n =  new InstationNotification();
			n.setId(smsId);
			n.setStatus("Y");//Y已读
			n.setUpdateTime(DateUtil.getCurrentTimestamp());
			n.setNoticeText(noticeText);
			n.setNoticeTitle(noticeTitle);
			n.setNoticeType(noticeType);
			n.setExpiryDate(expiryDate);
			i = notificationDao.updateByPrimaryKeySelective(n);
		}
	
		
		if(i<= 0){
			rm.setErrmsg("数据未修改！");
		}else{
			rm.setErrmsg(messagebase + "成功");
		}
//		activityService.JoinActivity(activityId,unionId,parentName,mobileNum,babyName,babySex,babyBirthday,city,district);
		} catch (Exception e1) {
			log.error(String.format(messagebase+"失败"),e1);
			rm.mergeException(e1);
			rm.setErrmsg("该用户暂时没有通知信息");
		}
		return rm;
	}  
	
}
