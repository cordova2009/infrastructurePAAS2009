package com.hummingbird.paas.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hummingbird.common.constant.CommonStatusConst;
import com.hummingbird.common.exception.ValidateException;
import com.hummingbird.common.util.DateUtil;
import com.hummingbird.paas.entity.Token;
import com.hummingbird.paas.entity.UserNotices;
import com.hummingbird.paas.exception.PaasException;
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
    
    
	/**
	 * 获取消息明细
	 * @param msgId
	 * @return
	 * @throws PaasException 
	 */
	public UserNotices getMsgDetail(Integer msgId) throws PaasException{
		UserNotices un = umDao.selectByPrimaryKey(msgId);
		if(un==null){
			throw new PaasException(PaasException.ERR_USER_NOTICE_INFO_EXCEPTION,"用户消息不存在");
		}
		if(StringUtils.equals("FLS",un.getStatus())){
			if (log.isDebugEnabled()) {
				log.debug(String.format("消息%s状态是fls,不能查询"));
			}
			throw new PaasException(PaasException.ERR_USER_NOTICE_INFO_EXCEPTION,"用户消息不存在");
		}
		if(StringUtils.equals("NO#",un.getStatus())){
			un.setStatus("YES");
			umDao.updateByPrimaryKey(un);
		}
		return un;
	}
    
    
	public GetMsgListResultVO getMsgList(Integer userId, Integer pageIndex, Integer pageSize) {
		
		if(pageIndex==null||pageSize==null||pageIndex<=0||pageSize<=0){
			return null;
		}
        if(userId==null||userId<=0){
        	log.error("用户ID为空或错误");
        	return null;
        }
		List<GetMsgListResultBodyVO> gmbs = new ArrayList<GetMsgListResultBodyVO>();
		GetMsgListResultBodyVO  gb = null;
		DateUtil du = new DateUtil();
		int start = (pageIndex-1)*pageSize;//从1开始,第一页是第0条
		List<UserNotices> uns = umDao.getMsgList(userId, start,pageSize);
		for(UserNotices un:uns){
			 gb = new GetMsgListResultBodyVO();
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
	public Integer getUnreadMsgNum(Integer userId) {

        if(userId==null||userId<=0){
        	log.error("用户ID为空或错误");
        	return null;
        }
        Integer count = umDao.getUnreadMesgCount(userId);
        return count;
	}

}
