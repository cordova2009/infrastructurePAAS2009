package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ProjectPaymentAccount;

public interface ProjectPaymentAccountMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String account_id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectPaymentAccount record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectPaymentAccount record);

    /**
     * 根据主键查询记录
     */
    ProjectPaymentAccount selectByPrimaryKey(String account_id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectPaymentAccount record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectPaymentAccount record);
}