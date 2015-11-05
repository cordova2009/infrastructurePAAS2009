package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BiddeeCompanyCertification;

public interface BiddeeCompanyCertificationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BiddeeCompanyCertification record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BiddeeCompanyCertification record);

    /**
     * 根据主键查询记录
     */
    BiddeeCompanyCertification selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BiddeeCompanyCertification record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BiddeeCompanyCertification record);
}