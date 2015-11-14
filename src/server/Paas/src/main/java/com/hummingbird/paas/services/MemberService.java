package com.hummingbird.paas.services;

import java.util.List;

import com.hummingbird.paas.vo.BuyTenderMemberBodyVO;
import com.hummingbird.paas.vo.QueryMemberInfoResultVO;
import com.hummingbird.paas.vo.QueryMemberProductResultVO;

public interface MemberService {
	  //查询会员信息
      public List<QueryMemberInfoResultVO> querysMemberInfo(String token);
      //购买招标人信息
      public QueryMemberProductResultVO querysAvailableProducts(String token);
       //购买招标方会员接口
      public String  buyPrivilegeMember(BuyTenderMemberBodyVO bt,String appId);
}
