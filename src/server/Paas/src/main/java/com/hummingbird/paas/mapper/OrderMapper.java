package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.Order;

public interface OrderMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Order record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Order record);

    /**
     * 根据主键查询记录
     */
    Order selectByPrimaryKey(String orderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Order record);
    /**
     * 根据产品ID、用户ID、应用ID
     * @param ord
     * @return
     */
	Order getOrder(Order ord);
}