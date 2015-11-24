package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.BiddeeBankCardCerticate;
import com.hummingbird.paas.entity.BidderBankCardCerticate;

public interface BidderBankCardCerticateMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidderBankCardCerticate record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidderBankCardCerticate record);

    /**
     * 根据主键查询记录
     */
    BidderBankCardCerticate selectByPrimaryKey(Integer id);
    
    /**
     * 根据token查询招标人开户行记录
     */
    List<BidderBankCardCerticate> selectBidderBankInfoByToken(String token);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidderBankCardCerticate record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidderBankCardCerticate record);
}