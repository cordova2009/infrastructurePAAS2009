package com.hummingbird.usercenter.mapper;

import com.hummingbird.usercenter.entity.Bank;

public interface BankMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String bankId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Bank record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Bank record);

    /**
     * 根据主键查询记录
     */
    Bank selectByPrimaryKey(String bankId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Bank record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Bank record);
}