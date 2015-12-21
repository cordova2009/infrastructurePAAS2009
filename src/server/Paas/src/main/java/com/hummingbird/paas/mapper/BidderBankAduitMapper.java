package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BiddeeBankAduit;
import com.hummingbird.paas.entity.BidderBankAduit;

public interface BidderBankAduitMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidderBankAduit record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidderBankAduit record);

    /**
     * 根据主键查询记录
     */
    BidderBankAduit selectByPrimaryKey(Integer id);
    
    /**
     * 根据招标方资质认证id查询记录
     */
    BidderBankAduit selectByBcId(Integer bcid);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidderBankAduit record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidderBankAduit record);

	/**
	 * 删除审核表中的银行卡信息
	 * @param bidderId
	 */
	void removeAduitRecord(Integer bidderCertificationId);
}