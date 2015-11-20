package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.BiddeeBankCardCerticate;
import com.hummingbird.paas.entity.UserBankcard;

public interface BiddeeBankCardCerticateMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BiddeeBankCardCerticate record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BiddeeBankCardCerticate record);

    /**
     * 根据主键查询记录
     */
    BiddeeBankCardCerticate selectByPrimaryKey(Integer id);
    /**
     * 根据token查询招标人开户行记录
     */
    List<BiddeeBankCardCerticate> selectBiddeeBankInfoByToken(String token);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BiddeeBankCardCerticate record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BiddeeBankCardCerticate record);
}