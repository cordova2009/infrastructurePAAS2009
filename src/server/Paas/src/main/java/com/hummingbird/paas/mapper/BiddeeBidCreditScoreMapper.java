package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BiddeeBidCreditScore;

public interface BiddeeBidCreditScoreMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BiddeeBidCreditScore record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BiddeeBidCreditScore record);

    /**
     * 根据主键查询记录
     */
    BiddeeBidCreditScore selectByPrimaryKey(Integer id);
    
    /**
     * 根据招标人id计算招标次数
     */
    int countNumByBid(Integer tenderer_id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BiddeeBidCreditScore record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BiddeeBidCreditScore record);
    /**
     * 根据招标人id计算积分总和
     */
    int sumScoreByBiddeeId(Integer tenderer_id);
}