package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.CertificationRequirement;

public interface CertificationRequirementMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(CertificationRequirement record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(CertificationRequirement record);

    /**
     * 根据主键查询记录selectCertisByObjectId
     */
    CertificationRequirement selectByPrimaryKey(Integer id);
    
    /**
     * 根据主键更新属性不为空的记录
     */ 
    List<CertificationRequirement> selectCertisByObjectId(String objectId);
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(CertificationRequirement record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(CertificationRequirement record);
}