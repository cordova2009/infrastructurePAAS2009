package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.Project;

public interface ProjectMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String object_id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Project record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Project record);

    /**
     * 根据主键查询记录
     */
    Project selectByPrimaryKey(String object_id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Project record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Project record);
}