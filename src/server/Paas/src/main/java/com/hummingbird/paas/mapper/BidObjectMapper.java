package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.BidObject;

public interface BidObjectMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String objectId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidObject record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidObject record);

    /**
     * 根据主键查询记录
     */
    BidObject selectByPrimaryKey(String objectId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidObject record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidObject record);

	/**
	 * 根据招标人查询没有完成的招标信息
	 * @param id
	 * @return
	 */
	List<BidObject> selectUnfinishObject(@Param("biddeeId")Integer biddeeId,@Param("objectId")String objectId);
}