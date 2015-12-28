package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.TagGroup;

public interface TagGroupMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer tagGroupId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(TagGroup record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(TagGroup record);

    /**
     * 根据主键查询记录
     */
    TagGroup selectByPrimaryKey(Integer tagGroupId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(TagGroup record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKeyWithBLOBs(TagGroup record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(TagGroup record);
    /**
     * 根据标签名查询记录
     */
    TagGroup selectByTagGroupName(String tagGroupName);
}