package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.MemberBiddeeUpgrade;

public interface MemberBiddeeUpgradeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(MemberBiddeeUpgrade record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(MemberBiddeeUpgrade record);

    /**
     * 根据主键查询记录
     */
    MemberBiddeeUpgrade selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(MemberBiddeeUpgrade record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(MemberBiddeeUpgrade record);
}