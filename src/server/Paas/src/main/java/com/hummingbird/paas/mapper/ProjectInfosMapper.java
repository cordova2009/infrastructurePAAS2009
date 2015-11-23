package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ProjectInfos;

public interface ProjectInfosMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String objectId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectInfos record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectInfos record);

    /**
     * 根据主键查询记录
     */
    ProjectInfos selectByPrimaryKey(String objectId);
    

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectInfos record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectInfos record);
}