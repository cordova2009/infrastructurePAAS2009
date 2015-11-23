package com.hummingbird.usercenter.mapper;

import com.hummingbird.usercenter.entity.UserAuth;

public interface UserAuthMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(UserAuth record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(UserAuth record);

    /**
     * 根据主键查询记录
     */
    UserAuth selectByPrimaryKey(Integer userId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(UserAuth record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(UserAuth record);
}