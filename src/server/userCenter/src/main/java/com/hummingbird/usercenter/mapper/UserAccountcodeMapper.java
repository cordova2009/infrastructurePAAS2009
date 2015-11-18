package com.hummingbird.usercenter.mapper;

import com.hummingbird.usercenter.entity.UserAccountcode;

public interface UserAccountcodeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Long idtUserAccountcode);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(UserAccountcode record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(UserAccountcode record);

    /**
     * 根据主键查询记录
     */
    UserAccountcode selectByPrimaryKey(Long idtUserAccountcode);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(UserAccountcode record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(UserAccountcode record);
}