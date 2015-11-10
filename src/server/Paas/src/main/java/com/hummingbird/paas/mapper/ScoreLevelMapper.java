package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.ScoreLevel;

public interface ScoreLevelMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ScoreLevel record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ScoreLevel record);

    /**
     * 根据主键查询记录
     */
    ScoreLevel selectByPrimaryKey(Integer id);
    
    /**
     * 根据信用分数查询等级记录
     */
    ScoreLevel countLevelByScore(Integer score);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ScoreLevel record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ScoreLevel record);
}