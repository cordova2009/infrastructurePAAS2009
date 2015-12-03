package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.UserReport;

public interface UserReportMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(UserReport record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(UserReport record);

    /**
     * 根据主键查询记录
     */
    UserReport selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(UserReport record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(UserReport record);
}