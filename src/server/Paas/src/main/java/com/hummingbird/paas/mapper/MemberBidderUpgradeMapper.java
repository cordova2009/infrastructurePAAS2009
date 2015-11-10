package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.MemberBidderUpgrade;

public interface MemberBidderUpgradeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(MemberBidderUpgrade record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(MemberBidderUpgrade record);

    /**
     * 根据主键查询记录
     */
    MemberBidderUpgrade selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(MemberBidderUpgrade record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(MemberBidderUpgrade record);
}