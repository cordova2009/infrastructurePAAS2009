package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BiddeeCertificationCreditScore;

public interface BiddeeCertificationCreditScoreMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer tendererId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BiddeeCertificationCreditScore record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BiddeeCertificationCreditScore record);

    /**
     * 根据主键查询记录
     */
    BiddeeCertificationCreditScore selectByPrimaryKey(Integer tendererId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BiddeeCertificationCreditScore record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BiddeeCertificationCreditScore record);
}