package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.MemberBiddee;
import com.hummingbird.paas.entity.MemberBidder;

public interface MemberBidderMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(MemberBidder record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(MemberBidder record);

    /**
     * 根据主键查询记录
     */
    MemberBidder selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(MemberBidder record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(MemberBidder record);
    
    /**
	 * 根据投标人id查询会员
	 * @param id
	 * @return
	 */
	MemberBidder selectByBidderId(Integer biddeeId);
}