package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.util.DateUtil;
import com.hummingbird.paas.entity.UserNotices;
import com.hummingbird.paas.mapper.UserNoticesMapper;
import com.hummingbird.paas.services.SiteNewsService;
import com.hummingbird.paas.vo.GetNoticeListResultVO;
import com.hummingbird.paas.vo.GetSiteNewsListResultVO;
@Service
public class SiteNewsServiceImpl implements SiteNewsService{
    @Autowired
    UserNoticesMapper unmDao;
	@Override
	public List<GetSiteNewsListResultVO> getSiteNewsList(Integer size) {
		List<GetSiteNewsListResultVO> gsl= new ArrayList<GetSiteNewsListResultVO>();;
		GetSiteNewsListResultVO gsr =null;
		List<UserNotices> notices = unmDao.queryNoticesNewest(size);
		DateUtil du = new DateUtil();
		for(UserNotices un : notices){
			gsr = new GetSiteNewsListResultVO();
			if(un.getInsertTime()!=null){
				String time = du.format(un.getInsertTime(),"yyyy-MM-dd HH:mm:ss");
				if(StringUtils.isNotBlank(time))
				  gsr.setCreateTime(time);
			}
			gsr.setId(un.getId());
            gsr.setTitle(un.getNoticeTitle());
			gsl.add(gsr);
		}
		return gsl;
	}
	@Override
	public GetNoticeListResultVO getNoticeList(Integer pageIndex,Integer pageSize) {
		if(pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){
			return null;
		}
		List<UserNotices> notices=unmDao.getnoticeList((pageIndex-1)*pageSize, pageSize);
		DateUtil du = new DateUtil();
		GetSiteNewsListResultVO gsr =null;
		GetNoticeListResultVO gnr = new GetNoticeListResultVO();
		List<GetSiteNewsListResultVO> gsl= new ArrayList<GetSiteNewsListResultVO>();;
		for(UserNotices un : notices){
			gsr = new GetSiteNewsListResultVO();
			if(un.getInsertTime()!=null){
				String time = du.format(un.getInsertTime(),"yyyy-MM-dd HH:mm:ss");
				if(StringUtils.isNotBlank(time))
				  gsr.setCreateTime(time);
			}
			gsr.setId(un.getId());
            gsr.setTitle(un.getNoticeTitle());
            gsl.add(gsr);
		}
		gnr.setList(gsl);
		Integer total = unmDao.getTotalCount();
		if(total!=null){
			gnr.setTotal(total);
		}
		return gnr;
	}
    
}
