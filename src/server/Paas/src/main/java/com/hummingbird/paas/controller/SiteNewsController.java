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
import com.hummingbird.common.face.AbstractAppLog;
import com.hummingbird.common.util.JsonUtil;
import com.hummingbird.common.util.RequestUtil;
import com.hummingbird.common.vo.ResultModel;
import com.hummingbird.paas.entity.AppLog;
import com.hummingbird.paas.mapper.AppLogMapper;
import com.hummingbird.paas.services.SiteNewsService;
import com.hummingbird.paas.vo.GetNoticeListResultVO;
import com.hummingbird.paas.vo.GetNoticeListVO;
import com.hummingbird.paas.vo.GetSiteNewsListResultVO;
import com.hummingbird.paas.vo.GetSiteNewsListVO;
@Controller
@RequestMapping("/siteNews")
public class SiteNewsController extends BaseController{ 
   @Autowired
   SiteNewsService siteSer;
	@Autowired
	AppLogMapper applogDao;
	
   @RequestMapping(value = "/getSiteNewsList", method = RequestMethod.POST)
 	public @ResponseBody ResultModel queryMemberInfo(HttpServletRequest request) {
 		if(log.isDebugEnabled()){
 			log.debug("查询最新站点消息公告中");
 		}
 		GetSiteNewsListVO transorder;
		ResultModel rm = new ResultModel();
		String messagebase = "查询最新站点消息公告中";
		rm.setBaseErrorCode(280100);
		rm.setErrmsg(messagebase+"成功");
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, GetSiteNewsListVO.class);
		} catch (Exception e) {
			log.error(String.format("参数转化出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "订单参数"));
			return rm;
		}
		Integer size = transorder.getBody().getSize();
		if(size!=null){
			List<GetSiteNewsListResultVO> uns = siteSer.getSiteNewsList(size);
            rm.put("list", uns);		
		}else{
			if(log.isDebugEnabled()){
				log.debug("查询会员信息出错传入页数出错");
				rm.setErrmsg("查询会员信息出错传入页数出错");
				rm.setErrcode(280100);
			}
		}
		if(log.isDebugEnabled()){
			log.debug("查询会员信息参数成功");
		}
		return rm;
   
   }
   @RequestMapping(value = "/getnoticeList", method = RequestMethod.POST)
	public @ResponseBody ResultModel getnoticeList(HttpServletRequest request) {
		if(log.isDebugEnabled()){
			log.debug("查询更多网站公告");
		}
		GetNoticeListVO transorder;
		ResultModel rm = new ResultModel();
		String messagebase = "查询更多站点消息公告中";
		rm.setBaseErrorCode(280100);
		rm.setErrmsg(messagebase+"成功");
		try {
			String jsonstr = RequestUtil.getRequestPostData(request);
			request.setAttribute("rawjson", jsonstr);
			transorder = RequestUtil.convertJson2Obj(jsonstr, GetNoticeListVO.class);
		} catch (Exception e) {
			log.error(String.format("参数转化出错"),e);
			rm.mergeException(ValidateException.ERROR_PARAM_FORMAT_ERROR.cloneAndAppend(null, "公告参数"));
			return rm;
		}
		Integer pageIndex = transorder.getBody().getPageIndex();
		Integer pageSize = transorder.getBody().getPageSize();
		if(pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){
			rm.setErrcode(280111);
			rm.setErrmsg("获取分页列表参数错误");
			return rm;
		}
		GetNoticeListResultVO gv = siteSer.getNoticeList(pageIndex,pageSize);
		if(gv!=null){
		rm.put("total",gv.getTotal());
			if(gv.getList()!=null){
				rm.put("list", gv.getList());
//				return rm;
			}else{
				rm.setErrcode(208012);
				rm.setErrmsg("查询列表为空");
			}
		}else{
			rm.setErrcode(208013);
			rm.setErrmsg("查询列表为空");
		}
		rm.put("pageIndex",pageIndex);
		rm.put("pageSize", pageSize);
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
