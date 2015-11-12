package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.MembeBiddeeUpgrade;

public interface MembeBiddeeUpgradeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(MembeBiddeeUpgrade record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(MembeBiddeeUpgrade record);

    /**
     * 根据主键查询记录
     */
    MembeBiddeeUpgrade selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(MembeBiddeeUpgrade record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(MembeBiddeeUpgrade record);
}