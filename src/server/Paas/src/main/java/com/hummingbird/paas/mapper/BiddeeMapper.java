package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.Biddee;

public interface BiddeeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Biddee record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Biddee record);
    /**
     * 保存认证申请通过的资质表数据 
     */
    int insertSelectByBiddeeIdSuccess(Integer biddeeId);
    /**
     * 更新认证申请通过的资质表数据 
     */
    int updateByBiddeeIdSuccess(Integer biddeeId);

    /**
     * 根据主键查询记录
     */
    Biddee selectByPrimaryKey(Integer id);
    /**

     * 根据userId查询记录
     */
    Biddee selectByUserId(Integer userId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Biddee record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Biddee record);
    
    
}