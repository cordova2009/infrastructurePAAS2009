package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ProjectInfo;

public interface ProjectInfoMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String projectId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectInfo record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectInfo record);

    /**
     * 根据主键查询记录
     */
    ProjectInfo selectByPrimaryKey(String projectId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectInfo record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectInfo record);
}