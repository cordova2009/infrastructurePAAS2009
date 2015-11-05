package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.CertificateAuditHistory;

public interface CertificateAuditHistoryMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(CertificateAuditHistory record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(CertificateAuditHistory record);

    /**
     * 根据主键查询记录
     */
    CertificateAuditHistory selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(CertificateAuditHistory record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(CertificateAuditHistory record);
}