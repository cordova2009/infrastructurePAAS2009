package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.ProjectAccountOrder;

public interface ProjectAccountOrderMapper {
	 /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectAccountOrder record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectAccountOrder record);

    /**
     * 根据主键查询记录
     */
    ProjectAccountOrder selectByPrimaryKey(String orderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectAccountOrder record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectAccountOrder record);
    
    /**
	 * 获取总记录数
	 * @param unionId
	 * @return
	 */
	int selectTotalCountByaccountId(String accountId);

    /**
     * 根据资金账号Id查询账户流水
     * @param accountId
     * @return
     */
    List<ProjectAccountOrder> queryRecordsByAccountId(@Param("accountId")String accountId,@Param("page")Pagingnation page);

    /**
	 * 查询用户资金账户总收入
	 * @param accountId
	 * @return
	 */
	public Integer getAccountIncome(String accountId);
	
	/**
	 * 查询用户资金账户总支出
	 * @param accountId
	 * @return
	 */
	public Integer getAccountOutlay(String accountId);
	/**
	 * 查询解冻订单
	 * @param orignalOrderId
	 * @return
	 */
	ProjectAccountOrder queryUnfreezeRecord(String orignalOrderId);
}