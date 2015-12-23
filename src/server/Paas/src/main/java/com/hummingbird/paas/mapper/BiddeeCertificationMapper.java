package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.BiddeeCertification;

public interface BiddeeCertificationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BiddeeCertification record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BiddeeCertification record);
    
    /**
     * 审核通过   保存审核表的数据到正式表  
     */
    int insertSelectiveByCertificationIdSuccess(Integer biddeeId);
    /**
     * 审核通过   更新审核表的数据到正式表  
     */
    int updateByCertificationIdSuccess(Integer biddeeId);

    /**
     * 根据主键查询记录
     */
    BiddeeCertification selectByPrimaryKey(Integer id);
    /**
     * 根据biddeeId查询记录
     */
    List<BiddeeCertification> selectByBiddeeId(Integer biddeeId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BiddeeCertification record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BiddeeCertification record);

    /**
	 * 删除所有正式的证书
	 * @param bidderId
	 */
	int removeAllByBiddeeId(Integer biddeeId);

	/**
	 * 把申请的证书复制到正式表中
	 * @param certificationApplyId
	 */
	int insertByApplyId(Integer certificationApplyId);
}