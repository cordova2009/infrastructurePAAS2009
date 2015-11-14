package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.CertificationType;

public interface CertificationTypeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(CertificationType record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(CertificationType record);

    /**
     * 根据主键查询记录selectAllTypes
     */
    CertificationType selectByPrimaryKey(Integer id);
     
    /**
     * 根据industryId 找寻相应的证书
     */
    List<CertificationType> selectAllTypes(String industryId);
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(CertificationType record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(CertificationType record);
}