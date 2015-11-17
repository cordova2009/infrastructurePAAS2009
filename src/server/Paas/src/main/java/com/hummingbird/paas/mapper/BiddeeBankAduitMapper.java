package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BiddeeBankAduit;

public interface BiddeeBankAduitMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BiddeeBankAduit record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BiddeeBankAduit record);

    /**
     * 根据主键查询记录
     */
    BiddeeBankAduit selectByPrimaryKey(Integer id);
    
    /**
     * 根据招标方资质认证id查询记录
     */
    BiddeeBankAduit selectByBcId(Integer bcid);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BiddeeBankAduit record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BiddeeBankAduit record);
}