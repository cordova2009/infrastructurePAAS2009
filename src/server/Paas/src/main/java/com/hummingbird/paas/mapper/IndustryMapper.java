package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.Industry;

public interface IndustryMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Industry record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Industry record);

    /**
     * 根据主键查询记录
     */
    Industry selectByPrimaryKey(String id);
    /**
     * 根据主键查询记录
     */
    List<Industry> selectAll();
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Industry record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Industry record);
}