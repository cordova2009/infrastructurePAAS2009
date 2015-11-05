package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.UserSmscode;

public interface UserSmscodeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer idt_user_smscode);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(UserSmscode record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(UserSmscode record);

    /**
     * 根据主键查询记录
     */
    UserSmscode selectByPrimaryKey(Integer idt_user_smscode);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(UserSmscode record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(UserSmscode record);
}