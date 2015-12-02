package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.HyglBidder;

public interface HyglBidderMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(HyglBidder record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(HyglBidder record);

    /**
     * 根据主键查询记录
     */
    HyglBidder selectByPrimaryKey(Integer id);
    /**
     * 根据bidderId查询记录
     */
     
    HyglBidder selectByBidderId(Integer bidderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(HyglBidder record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(HyglBidder record);
    
    /***
    *
    * @param memberLevel
    * @return
    */
	String getMemberContent(String memberLevel);
}