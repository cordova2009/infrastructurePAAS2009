package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.BidderCertificationCertification;
import com.hummingbird.paas.vo.BidderEqInfo;
import com.hummingbird.paas.vo.CertificationInfo;
import com.hummingbird.paas.vo.BidderEqInfoWithAudit;

public interface BidderCertificationCertificationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 根据资质删除记录
     */
    int deleteByBidderId(@Param("bidderId")Integer bidderId, @Param("updIds")List<Integer> updIds);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidderCertificationCertification record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidderCertificationCertification record);

    /**
     * 根据主键查询记录
     */
    BidderCertificationCertification selectByPrimaryKey(Integer id);

    /**
     * 根据bidder_id查询记录 
     */
    List<BidderEqInfo> selectEqInfoByBidderId(Integer bidder_id);
    
    /**
     * 根据userId查询记录 
     */
    List<BidderEqInfoWithAudit> selectEqInfoByUserId(Integer userId);
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidderCertificationCertification record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidderCertificationCertification record);
    /**
     * 根据bidderId查询记录 
     */
    List<CertificationInfo> selectCertificationInfo(Integer bidderId);
}