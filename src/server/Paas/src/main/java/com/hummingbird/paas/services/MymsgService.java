package com.hummingbird.paas.services;

import com.hummingbird.paas.vo.GetMsgListResultVO;

public interface MymsgService {
      public GetMsgListResultVO getMsgList(String token,Integer pageIndex,Integer pageSize);

      public Integer  getUnreadMsgNum(String token);
}
