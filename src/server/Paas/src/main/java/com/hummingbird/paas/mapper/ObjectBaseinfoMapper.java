package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ObjectBaseinfo;

public interface ObjectBaseinfoMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String objectId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ObjectBaseinfo record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ObjectBaseinfo record);

    /**
     * 根据主键查询记录
     */
    ObjectBaseinfo selectByPrimaryKey(String objectId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ObjectBaseinfo record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ObjectBaseinfo record);
}