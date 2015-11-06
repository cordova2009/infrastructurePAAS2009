package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.MemberProductAttr;

public interface MemberProductAttrMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String productId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(MemberProductAttr record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(MemberProductAttr record);

    /**
     * 根据主键查询记录
     */
    MemberProductAttr selectByPrimaryKey(String productId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(MemberProductAttr record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(MemberProductAttr record);
}