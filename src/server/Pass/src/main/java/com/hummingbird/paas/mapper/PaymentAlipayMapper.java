package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.PaymentAlipay;

public interface PaymentAlipayMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(PaymentAlipay record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(PaymentAlipay record);

    /**
     * 根据主键查询记录
     */
    PaymentAlipay selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(PaymentAlipay record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(PaymentAlipay record);
}