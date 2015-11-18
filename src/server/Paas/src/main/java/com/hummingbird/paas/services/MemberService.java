package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.common.exception.BusinessException;
import com.hummingbird.paas.vo.BuyTenderMemberBodyVO;
import com.hummingbird.paas.vo.QueryMemberInfoResultVO;
import com.hummingbird.paas.vo.QueryMemberProductResultVO;

public interface MemberService {
	  //鏌ヨ浼氬憳淇℃伅
      public List<QueryMemberInfoResultVO> querysMemberInfo(String token)throws BusinessException;
      //璐拱鎷涙爣浜轰俊鎭�
      public QueryMemberProductResultVO querysAvailableProducts(String token);
       //璐拱鎷涙爣鏂逛細鍛樻帴鍙�
      public String  buyPrivilegeMember(BuyTenderMemberBodyVO bt,String appId);
      /**
       * 閺�顖欑帛鐎规繄缍夐崗鎶斤拷姘辩叀閹恒儱褰�
       * */
//  	  public ResultModel orderNotify(OrderNotifyVO onvo);
      
      
}
