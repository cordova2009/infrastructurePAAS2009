package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ObjectBondRecord;

public interface ObjectBondRecordMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ObjectBondRecord record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ObjectBondRecord record);

    /**
     * 根据主键查询记录
     */
    ObjectBondRecord selectByPrimaryKey(String orderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ObjectBondRecord record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ObjectBondRecord record);
}