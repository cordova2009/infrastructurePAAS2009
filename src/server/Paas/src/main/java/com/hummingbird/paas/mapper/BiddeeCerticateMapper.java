package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BiddeeCerticate;

public interface BiddeeCerticateMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BiddeeCerticate record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BiddeeCerticate record);

    /**
     * 根据主键查询记录
     */
    BiddeeCerticate selectByPrimaryKey(Integer id);
    /**
     * 根据user_id查询信息
     */
    BiddeeCerticate selectByUserId(Integer user_id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BiddeeCerticate record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BiddeeCerticate record);
}