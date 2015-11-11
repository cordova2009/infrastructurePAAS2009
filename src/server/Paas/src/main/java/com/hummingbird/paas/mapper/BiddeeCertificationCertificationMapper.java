package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BiddeeCertificationCertification;

public interface BiddeeCertificationCertificationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BiddeeCertificationCertification record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BiddeeCertificationCertification record);

    /**
     * 根据主键查询记录
     */
    BiddeeCertificationCertification selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BiddeeCertificationCertification record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BiddeeCertificationCertification record);
}