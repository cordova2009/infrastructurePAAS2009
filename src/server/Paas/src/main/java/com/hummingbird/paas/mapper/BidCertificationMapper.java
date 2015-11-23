package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.BidCertification;

public interface BidCertificationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidCertification record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidCertification record);

    /**
     * 根据主键查询记录
     */
    BidCertification selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidCertification record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidCertification record);

	/**
	 * 根据投标id查询已提交的资质证书
	 * @param parseInt
	 */
	List<BidCertification> selectByBidId(Integer bidId);

	/**
	 * 删除标的下的所有证书
	 * @param bidId
	 */
	int deleteByBidId(Integer bidId);
}