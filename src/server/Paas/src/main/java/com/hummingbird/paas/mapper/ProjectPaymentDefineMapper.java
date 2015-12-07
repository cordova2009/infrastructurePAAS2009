package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ProjectPaymentDefine;

public interface ProjectPaymentDefineMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectPaymentDefine record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectPaymentDefine record);

    /**
     * 根据主键查询记录
     */
    ProjectPaymentDefine selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectPaymentDefine record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectPaymentDefine record);
    
    /**
     * 根据objectId查询记录
     */
    ProjectPaymentDefine selectByObjectId(String objectId);
}