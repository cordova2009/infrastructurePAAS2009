package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.BidderCompanyCertification;
import com.hummingbird.paas.vo.BidderEqInfo;

public interface BidderCompanyCertificationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidderCompanyCertification record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidderCompanyCertification record);

    /**
     * 根据主键查询记录
     */
    BidderCompanyCertification selectByPrimaryKey(Integer id);
    
    /**
     * 根据bidder_id查询记录 
     */
    List<BidderEqInfo> selectEqInfoByBidderId(Integer bidder_id);
    
    /**
     * 根据token查询记录 
     */
    List<BidderEqInfo> selectEqInfoByToken(String token);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidderCompanyCertification record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidderCompanyCertification record);
}