package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ProjectAccountOrder;

public interface ProjectAccountOrderMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectAccountOrder record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectAccountOrder record);

    /**
     * 根据主键查询记录
     */
    ProjectAccountOrder selectByPrimaryKey(String orderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectAccountOrder record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectAccountOrder record);
}