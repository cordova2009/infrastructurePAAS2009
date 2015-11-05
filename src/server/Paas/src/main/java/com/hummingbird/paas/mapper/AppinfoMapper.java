package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.Appinfo;

public interface AppinfoMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String appId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Appinfo record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Appinfo record);

    /**
     * 根据主键查询记录
     */
    Appinfo selectByPrimaryKey(String appId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Appinfo record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Appinfo record);
}