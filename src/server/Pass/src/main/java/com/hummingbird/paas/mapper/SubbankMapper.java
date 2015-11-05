package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.Subbank;

public interface SubbankMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String subbank_id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Subbank record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Subbank record);

    /**
     * 根据主键查询记录
     */
    Subbank selectByPrimaryKey(String subbank_id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Subbank record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Subbank record);
}