package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ObjectCertificationRequirement;

public interface ObjectCertificationRequirementMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ObjectCertificationRequirement record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ObjectCertificationRequirement record);

    /**
     * 根据主键查询记录
     */
    ObjectCertificationRequirement selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ObjectCertificationRequirement record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ObjectCertificationRequirement record);
}