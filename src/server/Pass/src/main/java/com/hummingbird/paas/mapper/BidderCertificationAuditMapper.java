package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BidderCertificationAudit;

public interface BidderCertificationAuditMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidderCertificationAudit record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidderCertificationAudit record);

    /**
     * 根据主键查询记录
     */
    BidderCertificationAudit selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidderCertificationAudit record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidderCertificationAudit record);
}