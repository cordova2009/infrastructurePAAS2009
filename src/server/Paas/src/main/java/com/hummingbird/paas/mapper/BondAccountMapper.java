package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BondAccount;

public interface BondAccountMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String accountId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BondAccount record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BondAccount record);

    /**
     * 根据主键查询记录
     */
    BondAccount selectByPrimaryKey(String accountId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BondAccount record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BondAccount record);
}