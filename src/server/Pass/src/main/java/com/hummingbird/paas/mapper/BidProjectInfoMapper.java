package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BidProjectInfo;

public interface BidProjectInfoMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String object_id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidProjectInfo record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidProjectInfo record);

    /**
     * 根据主键查询记录
     */
    BidProjectInfo selectByPrimaryKey(String object_id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidProjectInfo record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidProjectInfo record);
}