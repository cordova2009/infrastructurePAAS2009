package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.entity.QyzzBiddee;

public interface QyzzBiddeeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(QyzzBiddee record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(QyzzBiddee record);

    /**
     * 根据主键查询记录
     */
    QyzzBiddee selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(QyzzBiddee record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(QyzzBiddee record);
    /**
     * 根据用户名查询距离
     * */
    QyzzBiddee selectByUserId(Integer uid);
}