package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.FeeRate;

public interface FeeRateMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(FeeRate record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(FeeRate record);

    /**
     * 根据主键查询记录
     */
    FeeRate selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(FeeRate record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(FeeRate record);
    
    /**
     * 根据类型查询手续费
     */
    List<FeeRate> selectFeeRate(String type);

	/**
	 * 计算交纳的费用
	 * @param inputAmount
	 * @param string
	 * @return
	 */
    Long selectMoney(@Param("inputAmount") Long inputAmount,@Param("type") String type);
}