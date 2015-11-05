package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.TagType;

public interface TagTypeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(TagType record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(TagType record);

    /**
     * 根据主键查询记录
     */
    TagType selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(TagType record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(TagType record);
}