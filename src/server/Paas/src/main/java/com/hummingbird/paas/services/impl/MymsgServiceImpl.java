package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.util.DateUtil;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.UserNotices;
import com.hummingbird.paas.mapper.UserNoticesMapper;
import com.hummingbird.paas.mapper.UserTokenMapper;
import com.hummingbird.paas.services.MymsgService;
import com.hummingbird.paas.vo.GetMsgListResultBodyVO;
import com.hummingbird.paas.vo.GetMsgListResultVO;
@Service
public class MymsgServiceImpl implements MymsgService{
    @Autowired
    UserNoticesMapper umDao;
    @Autowired
    UserTokenMapper utDao;
    org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(this.getClass());
	public GetMsgListResultVO getMsgList(String token, Integer pageIndex, Integer pageSize) {
		
		if(StringUtils.isBlank(token)||pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){
			return null;
		}
		Token tk = utDao.selectByTokenStr(token);
        if(tk==null){
           log.error("获取我自己的站点信息错误");
           return null;
        }
        Integer userId = tk.getUserId();
        if(userId==null||userId<=0){
        	log.error("用户ID为空或错误");
        	return null;
        }
		List<GetMsgListResultBodyVO> gmbs = new ArrayList<GetMsgListResultBodyVO>();
		GetMsgListResultBodyVO  gb = null;
		DateUtil du = new DateUtil();
		List<UserNotices> uns = umDao.getMsgList(userId, pageIndex,pageSize);
		for(UserNotices un:uns){
			 gb = new GetMsgListResultBodyVO();
			 if(un.getStatus().equalsIgnoreCase("Y")){
				 gb.setIsRead("YES");
			 }else{
				 gb.setIsRead("NO");
			 }
		     if(un.getInsertTime()!=null){
		    	 gb.setCreateTime(du.format(un.getInsertTime(),""));
		     }
		     gb.setMsgContent(un.getNoticeText());
		     gb.setMsgId(un.getId());
		     gb.setMsgTitl(un.getNoticeTitle());
		     gb.setMsgType(un.getNoticeType());
		     gmbs.add(gb);
		}
		GetMsgListResultVO gmv = new GetMsgListResultVO();
	    gmv.setData(gmbs);
	    Integer msgTotal  =  umDao.getMsgTotalCount(userId);
	    
	    if(msgTotal!=null){
	    	gmv.setTotal(msgTotal);
	    }
		return gmv;
	}
	@Override
	public Integer getUnreadMsgNum(String token) {
		Token tk = utDao.selectByTokenStr(token);
        if(tk==null){
           log.error("获取我自己的站点信息错误");
           return null;
        }
        Integer userId = tk.getUserId();
        if(userId==null||userId<=0){
        	log.error("用户ID为空或错误");
        	return null;
        }
        Integer count = umDao.getUnreadMesgCount(userId);
        return count;
	}

}
