package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.WithdrawApply;

public interface WithdrawApplyMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(WithdrawApply record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(WithdrawApply record);

    /**
     * 根据主键查询记录
     */
    WithdrawApply selectByPrimaryKey(String orderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(WithdrawApply record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(WithdrawApply record);
}