package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.UserToken;

public interface UserTokenMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String token);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(UserToken record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(UserToken record);

    /**
     * 根据主键查询记录
     */
    UserToken selectByPrimaryKey(String token);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(UserToken record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(UserToken record);
}