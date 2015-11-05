package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.TagRelation;

public interface TagRelationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(TagRelation record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(TagRelation record);

    /**
     * 根据主键查询记录
     */
    TagRelation selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(TagRelation record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(TagRelation record);
}