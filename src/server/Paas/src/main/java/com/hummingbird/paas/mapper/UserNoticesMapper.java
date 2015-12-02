package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.UserNotices;

public interface UserNoticesMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(UserNotices record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(UserNotices record);

    /**
     * 根据主键查询记录
     */
    UserNotices selectByPrimaryKey(Integer id);
//    /**
//     * 查询最新的记录
//     * */
//    List<UserNotices> queryNoticesNewest(@Param("limit") int limit);
//    /**
//     * 分页查询
//     * */
//    List<UserNotices> getnoticeList(@Param("begin") int begin ,@Param("limit") int limit);
    /**
     * 查询我的记录
     * */
    List<UserNotices> getMsgList(@Param("userId") Integer userId ,@Param("begin") int begin ,@Param("limit") int limit);
    /*
     * 获取总的某人的信息
     * */
    int getMsgTotalCount(Integer userId);
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(UserNotices record);
    /*获取未读的数据
     * 
     * */
    int getUnreadMesgCount(Integer userId);
    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(UserNotices record);
     /**
      * *查询记录总数
      * */
	Integer getTotalCount();
    
}