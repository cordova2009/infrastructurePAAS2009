package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ProjectEvaluationBidder;

public interface ProjectEvaluationBidderMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectEvaluationBidder record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectEvaluationBidder record);

    /**
     * 根据主键查询记录
     */
    ProjectEvaluationBidder selectByPrimaryKey(Integer id);
    
    /**
     * 查询评价次数
     */
    int countEvaluationNumByBidderId(Integer bidder_id);
    
    /**
     * 查询评价积分
     */
    double countEvaluationScoreByBidderId(Integer bidder_id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectEvaluationBidder record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectEvaluationBidder record);
}