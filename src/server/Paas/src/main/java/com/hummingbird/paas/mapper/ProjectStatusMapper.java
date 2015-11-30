package com.hummingbird.paas.mapper;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.ProjectStatus;

public interface ProjectStatusMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String projectId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectStatus record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectStatus record);

    /**
     * 根据主键查询记录
     */
    ProjectStatus selectByPrimaryKey(String projectId);
    
    /**
     * 根据objectId和userid查询记录
     */
    ProjectStatus selectByObjectIdAndUserId(@Param("objectId")String objectId,@Param("userId")Integer userId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectStatus record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectStatus record);
}