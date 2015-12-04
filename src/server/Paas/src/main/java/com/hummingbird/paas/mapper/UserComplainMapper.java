package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.UserComplain;

public interface UserComplainMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(UserComplain record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(UserComplain record);

    /**
     * 根据主键查询记录
     */
    UserComplain selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(UserComplain record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(UserComplain record);
}