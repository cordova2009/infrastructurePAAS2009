package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BidderBidCreditScore;

public interface BidderBidCreditScoreMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidderBidCreditScore record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidderBidCreditScore record);

    /**
     * 根据主键查询记录
     */
    BidderBidCreditScore selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidderBidCreditScore record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidderBidCreditScore record);
    /**
     * 根据投标人id计算积分总和
     */
    int sumScoreByBidderId(Integer bidder_id);
}