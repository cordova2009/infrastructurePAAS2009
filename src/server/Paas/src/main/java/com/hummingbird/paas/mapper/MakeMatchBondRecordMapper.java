package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.MakeMatchBondRecord;

public interface MakeMatchBondRecordMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(MakeMatchBondRecord record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(MakeMatchBondRecord record);

    /**
     * 根据主键查询记录
     */
    MakeMatchBondRecord selectByPrimaryKey(String orderId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(MakeMatchBondRecord record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(MakeMatchBondRecord record);

	/**
	 * 查询撮合保证金
	 * @param bidId
	 */
	MakeMatchBondRecord selectByBidId(Integer bidId);
}