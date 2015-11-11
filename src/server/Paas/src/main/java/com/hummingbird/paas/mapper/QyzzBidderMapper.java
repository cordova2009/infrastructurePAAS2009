package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.entity.QyzzBidder;

public interface QyzzBidderMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(QyzzBidder record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(QyzzBidder record);

    /**
     * 根据主键查询记录
     */
    QyzzBidder selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(QyzzBidder record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(QyzzBidder record);
    /**
     *根据用户Id找记录
     * **/
    QyzzBidder selectByUserId(Integer uid);
}