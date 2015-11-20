package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.BiddeeCertification;
import com.hummingbird.paas.entity.BidderCertification;
import com.hummingbird.paas.vo.BidderEqInfo;

public interface BidderCertificationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidderCertification record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidderCertification record);
    
    /**
     * 审核通过   保存审核表的数据到正式表  
     */
    int insertSelectiveByCertificationIdSuccess(Integer bidderId);
    /**
     * 审核通过   更新审核表的数据到正式表  
     */
    int updateByCertificationIdSuccess(Integer bidderId);

    /**
     * 根据主键查询记录
     */
    BidderCertification selectByPrimaryKey(Integer id);
   
    /**
     * 根据bidderId查询记录
     */
    List<BidderCertification> selectByBidderId(Integer bidderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidderCertification record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidderCertification record);
}