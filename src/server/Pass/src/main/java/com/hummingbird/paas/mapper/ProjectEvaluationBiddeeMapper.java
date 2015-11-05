package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ProjectEvaluationBiddee;

public interface ProjectEvaluationBiddeeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectEvaluationBiddee record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectEvaluationBiddee record);

    /**
     * 根据主键查询记录
     */
    ProjectEvaluationBiddee selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectEvaluationBiddee record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectEvaluationBiddee record);
}