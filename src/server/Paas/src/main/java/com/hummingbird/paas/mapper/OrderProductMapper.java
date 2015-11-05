package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.OrderProduct;

public interface OrderProductMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(OrderProduct record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(OrderProduct record);

    /**
     * 根据主键查询记录
     */
    OrderProduct selectByPrimaryKey(String id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(OrderProduct record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(OrderProduct record);
}