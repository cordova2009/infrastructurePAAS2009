package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.RechargeApply;

public interface RechargeApplyMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(RechargeApply record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(RechargeApply record);

    /**
     * 根据主键查询记录
     */
    RechargeApply selectByPrimaryKey(String orderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(RechargeApply record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(RechargeApply record);
    
    List<RechargeApply> queryApplyByUserId(Integer userId);
}