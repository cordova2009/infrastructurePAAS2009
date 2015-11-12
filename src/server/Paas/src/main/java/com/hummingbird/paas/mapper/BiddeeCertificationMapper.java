package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BiddeeCertification;

public interface BiddeeCertificationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BiddeeCertification record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BiddeeCertification record);

    /**
     * 根据主键查询记录
     */
    BiddeeCertification selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BiddeeCertification record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BiddeeCertification record);
}