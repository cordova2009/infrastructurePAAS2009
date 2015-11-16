package com.hummingbird.capital.mapper;

import com.hummingbird.capital.entity.BondAccountOrder;

public interface BondAccountOrderMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BondAccountOrder record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BondAccountOrder record);

    /**
     * 根据主键查询记录
     */
    BondAccountOrder selectByPrimaryKey(String orderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BondAccountOrder record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BondAccountOrder record);
}