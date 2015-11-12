package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BidderCertificationCreditScore;

public interface BidderCertificationCreditScoreMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer bidderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidderCertificationCreditScore record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidderCertificationCreditScore record);

    /**
     * 根据主键查询记录
     */
    BidderCertificationCreditScore selectByPrimaryKey(Integer bidderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidderCertificationCreditScore record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidderCertificationCreditScore record);
}