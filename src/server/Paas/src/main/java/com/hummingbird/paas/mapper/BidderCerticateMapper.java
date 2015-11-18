package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BidderCerticate;

public interface BidderCerticateMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidderCerticate record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidderCerticate record);

    /**
     * 根据主键查询记录
     */
    BidderCerticate selectByPrimaryKey(Integer id);
    
    /**
     * 根据userId查询记录
     */
    BidderCerticate selectByUserId(Integer userId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidderCerticate record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidderCerticate record);
}