package com.hummingbird.paas.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.Announcement;
import com.hummingbird.paas.entity.InstationNotification;

public interface InstationNotificationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(InstationNotification record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(InstationNotification record);

    /**
     * 根据主键查询记录
     */
    InstationNotification selectByPrimaryKey(Integer id);
    
    int selectTotalCountByTokenAndStatus(String token,String status);
    
    /**
     * 查询有效期公告记录
     */
    List<InstationNotification> selectByUserInValid(@Param("token") String token,@Param("status") String status,@Param("page") Pagingnation page);
   

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(InstationNotification record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(InstationNotification record);
}