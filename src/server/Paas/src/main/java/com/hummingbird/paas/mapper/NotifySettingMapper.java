package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.NotifySetting;

public interface NotifySettingMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(NotifySetting record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(NotifySetting record);

    /**
     * 根据主键查询记录
     */
    NotifySetting selectByPrimaryKey(String id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(NotifySetting record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(NotifySetting record);
}