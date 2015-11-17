package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BidderCredit;

public interface BidderCreditMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer bidderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidderCredit record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidderCredit record);

    /**
     * 根据主键查询记录
     */
    BidderCredit selectByPrimaryKey(Integer bidderId);
    
    /**
     * 根据token查询记录
     */
    BidderCredit selectByToken(String token);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidderCredit record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidderCredit record);
}