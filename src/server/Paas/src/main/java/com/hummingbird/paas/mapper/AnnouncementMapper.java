package com.hummingbird.paas.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.Announcement;

public interface AnnouncementMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Announcement record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Announcement record);

    /**
     * 根据主键查询记录
     */
    Announcement selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Announcement record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKeyWithBLOBs(Announcement record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Announcement record);
    
    /**
     * 查询有效期公告条数
     */
    int selectTotalCountAnnouncement(@Param("creator") Integer creator,@Param("status") String status,@Param("startTime") Date startTime,@Param("endTime") Date endTime);
    
    /**
     * 查询有效期公告记录
     */
    List<Announcement> selectAnnouncement(@Param("creator") Integer creator,@Param("status") String status,@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("page") Pagingnation page);
}