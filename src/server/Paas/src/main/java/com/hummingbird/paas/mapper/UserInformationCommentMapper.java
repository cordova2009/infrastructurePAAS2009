package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.UserInformationComment;
import com.hummingbird.paas.vo.UserInformationComments;

public interface UserInformationCommentMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(UserInformationComment record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(UserInformationComment record);

    /**
     * 根据主键查询记录
     */
    UserInformationComment selectByPrimaryKey(Integer id);
    /**
     * 根据information_id和userid查询记录
     */
    UserInformationComment selectByInformationIdAndUserId(@Param("informationId")Integer informationId,@Param("userId")Integer userId);
    /**
     * 根据information_id查询记录
     */
    List<UserInformationComments> selectByInformationId(Integer information_id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(UserInformationComment record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(UserInformationComment record);
}