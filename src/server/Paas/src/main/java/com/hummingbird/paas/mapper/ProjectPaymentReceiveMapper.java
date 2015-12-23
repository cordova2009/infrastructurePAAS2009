package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.ProjectPaymentReceive;

public interface ProjectPaymentReceiveMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectPaymentReceive record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectPaymentReceive record);

    /**
     * 根据主键查询记录
     */
    ProjectPaymentReceive selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectPaymentReceive record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectPaymentReceive record);
    /**
     * 根据标的获得最后一次收款的记录信息
     * @param objectId
     * @return
     */
    ProjectPaymentReceive getLastRecord(String objectId);
    
    /**
     * 查询标的收款列表
     * @param objectId
     * @return
     */
    List<ProjectPaymentReceive> queryReceivedRecord(String objectId);

	/**
	 * 根据订单查询收款记录
	 * @param orderId
	 * @return
	 */
	ProjectPaymentReceive selectByOrderId(String orderId);
	
	/**
     * 查询该标的已收款的金额
     * @param ObjectId
     * @return
     */
    Long getReceivedAmountByObjectId(String ObjectId);
}