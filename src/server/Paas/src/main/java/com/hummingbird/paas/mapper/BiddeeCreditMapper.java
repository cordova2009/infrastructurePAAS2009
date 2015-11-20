package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BiddeeCredit;

public interface BiddeeCreditMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer tendererId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BiddeeCredit record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BiddeeCredit record);

    /**
     * 根据主键查询记录
     */
    BiddeeCredit selectByPrimaryKey(Integer tendererId);
    
    /**
     * 根据userId查询记录
     */
    BiddeeCredit selectByUserId(Integer userId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BiddeeCredit record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BiddeeCredit record);
}