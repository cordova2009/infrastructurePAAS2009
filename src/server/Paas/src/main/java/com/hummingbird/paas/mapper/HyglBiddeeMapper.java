package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.HyglBiddee;

public interface HyglBiddeeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(HyglBiddee record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(HyglBiddee record);

    /**
     * 根据主键查询记录
     */
    HyglBiddee selectByPrimaryKey(Integer id);
    /*
     * 根据biddee—_id查询记录
     * */
    HyglBiddee selectByBiddeeId(Integer biddeeId);
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(HyglBiddee record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(HyglBiddee record);
}