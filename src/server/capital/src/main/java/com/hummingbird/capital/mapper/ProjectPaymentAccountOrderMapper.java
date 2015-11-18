package com.hummingbird.capital.mapper;

import com.hummingbird.capital.entity.ProjectPaymentAccountOrder;

public interface ProjectPaymentAccountOrderMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectPaymentAccountOrder record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectPaymentAccountOrder record);

    /**
     * 根据主键查询记录
     */
    ProjectPaymentAccountOrder selectByPrimaryKey(String orderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectPaymentAccountOrder record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectPaymentAccountOrder record);
}