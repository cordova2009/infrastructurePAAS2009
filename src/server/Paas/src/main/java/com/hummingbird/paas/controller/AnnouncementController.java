package com.hummingbird.paas.controller;
/**
 * @author YJY 
 * @since 2015年11月6日14:41:41
 * */
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
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
import com.hummingbird.paas.mapper.AnnouncementMapper;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.services.AnnouncementService;
import com.hummingbird.paas.vo.AnnouncementDetailBodyVO;
import com.hummingbird.paas.vo.AnnouncementListBodyVO;
import com.hummingbird.paas.vo.AnnouncementUpdateVO;
@Controller
@RequestMapping(value="/message"
		 ,method=RequestMethod.POST)
public class AnnouncementController extends BaseController  {
	@Autowired
	protected AnnouncementService announcementService;
	@Autowired
	protected AnnouncementMapper announcementDao;
	@Autowired(required = true)
	protected AppLogMapper applogDao;
	
	
	@RequestMapping(value="/getnoticeList",method=RequestMethod.POST)
	@AccessRequered(methodName = "查询公告列表")
	public @ResponseBody ResultModel QueryAnnouncementList(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341200;//待定
		String messagebase = "查询公告列表";
		BaseTransVO<AnnouncementListBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr,BaseTransVO.class, AnnouncementListBodyVO.class);
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
		rnr.setMethod("/message/getnoticeList");
		
		List<Announcement> list=new ArrayList<Announcement>();
		try {
			com.hummingbird.common.face.Pagingnation page = transorder.getBody().toPagingnation();
			Integer creator = transorder.getBody().getCreator();
			String status = transorder.getBody().getStatus();
			Date startTime = transorder.getBody().getStartTime();
			Date endTime = transorder.getBody().getEndTime();
			
			list = announcementService.selectAnnouncementInValid(creator, status, startTime, endTime, page);
			List<Map> nos = CollectionTools.convertCollection(list, Map.class, new CollectionTools.CollectionElementConvertor<Announcement, Map>() {

				@Override
				public Map convert(Announcement ori) {
					
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
	 * 查询公告详细
	 * @return
	 */
	@RequestMapping(value="/getnoticeinfo",method=RequestMethod.POST)
	@AccessRequered(methodName = "查看公告详情")
	// 框架的日志处理
	public @ResponseBody ResultModel getAnnouncementDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String messagebase = "查看公告详情";
//		int basecode = 220002;
		BaseTransVO<AnnouncementDetailBodyVO> transorder = null;
		ResultModel rm = new ResultModel();
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, BaseTransVO.class,AnnouncementDetailBodyVO.class);
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
		rnr.setMethod("/message/getnoticeinfo");
		
		try {
			Announcement aa = announcementDao.selectByPrimaryKey(transorder.getBody().getNoticeId());
			Map row= BeanUtils.describe(aa);
			row.put("insertTime", DateUtil.formatCommonDateorNull(aa.getInsertTime()));
			row.put("updateTime", DateUtil.formatCommonDateorNull(aa.getUpdateTime()));
			row.remove("class");
				
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
	
	
	@RequestMapping(value="/updateAnnounce",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class,value="txManager")
	public @ResponseBody ResultModel UpdateAnnounce(HttpServletRequest request,HttpServletResponse response) {
//		int basecode = 2341210;//待定
		String messagebase = "修改通知信息";
		AnnouncementUpdateVO transorder = null;
		ResultModel rm = new ResultModel();
//		rm.setBaseErrorCode(basecode);
		try {
			String jsonstr  = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, AnnouncementUpdateVO.class);
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
		rnr.setMethod("/message/updateAnnounce");
		
		try {
		Integer noticeId =  transorder.getBody().getNoticeId();
		String type = transorder.getBody().getType();
		String title =  transorder.getBody().getTitle();
		String status =  transorder.getBody().getStatus();
		Integer expiryDate =  transorder.getBody().getExpiryDate();
		String imgurl = transorder.getBody().getImgurl();
		String content = transorder.getBody().getContent();
		
		int i= 0;
		if(StringUtils.isNotBlank(ObjectUtils.toString(noticeId))){
			Announcement n =  new Announcement();
			n.setId(noticeId);
			//n.setStatus("Y");//Y已读
			n.setContent(content);
			n.setExpiryDate(expiryDate);
			n.setImgurl(imgurl);
			n.setStatus(status);
			n.setTitle(title);
			n.setType(type);
			n.setUpdateTime(new Date());
			
			
			i = announcementDao.updateByPrimaryKeySelective(n);
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
