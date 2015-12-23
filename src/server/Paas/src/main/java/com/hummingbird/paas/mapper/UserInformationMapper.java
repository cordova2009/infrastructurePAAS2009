package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.UserInformation;
import com.hummingbird.paas.vo.UserInformationPageReturnVO;

public interface UserInformationMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(UserInformation record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(UserInformation record);

    /**
     * 根据主键查询记录
     */
    UserInformation selectByPrimaryKey(Integer id);
    /**
     * 根据userId status查询记录
     */
    List<UserInformationPageReturnVO> selectByUserIdAndStatus(@Param("userId") int userId ,@Param("status") String status,@Param("begin") int begin ,@Param("limit") int limit);

    /**
     * 根据userId status查询记录数
     */
    int selectTotalByUserIdAndStatus(@Param("userId") int userId ,@Param("status") String status);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(UserInformation record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(UserInformation record);
    
    /**
     * 查询所有用户成功发布的信息总数
     */
    int selectPublishedInfoCount();
    
    /**
     * 查询成功发布信息的用户总数
     */
    int selectPublishedManCount();

	/**
	 * 查询用户信息列表
	 * @param integer
	 * @param status
	 * @param keywords
	 * @param page
	 * @return
	 */
	List<UserInformationPageReturnVO> selectUserInfoPage(@Param("userId") Integer userId,@Param("status") String status,@Param("keywords") List<String> keywords,@Param("page")
			Pagingnation page);
	/**
	 * 查询用户信息列表记录数
	 * @param integer
	 * @param status
	 * @param keywords
	 * @param page
	 * @return
	 */
	int selectUserInfoCount(@Param("userId") Integer userId,@Param("status") String status,@Param("keywords") List<String> keywords);
    
    
}