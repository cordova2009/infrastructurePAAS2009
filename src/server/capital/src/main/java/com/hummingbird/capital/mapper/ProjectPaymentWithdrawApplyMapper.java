package com.hummingbird.capital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.capital.entity.ProjectPaymentWithdrawApply;
import com.hummingbird.common.face.Pagingnation;

public interface ProjectPaymentWithdrawApplyMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectPaymentWithdrawApply record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectPaymentWithdrawApply record);

    /**
     * 根据主键查询记录
     */
    ProjectPaymentWithdrawApply selectByPrimaryKey(String orderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectPaymentWithdrawApply record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectPaymentWithdrawApply record);

	/**
	 * 查询用户的提现记录数
	 * @param userId
	 * @return
	 */
	int selectCount(Integer userId);
	/**
	 * 根据主键查询记录
	 */
	List<ProjectPaymentWithdrawApply> selectWithdrawRecords(@Param("userId") Integer userId,@Param("page") Pagingnation page);
}