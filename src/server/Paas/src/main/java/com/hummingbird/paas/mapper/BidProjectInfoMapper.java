package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.BidProjectInfo;

public interface BidProjectInfoMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String objectId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidProjectInfo record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidProjectInfo record);

    /**
     * 根据主键查询记录
     */
    BidProjectInfo selectByPrimaryKey(String objectId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidProjectInfo record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidProjectInfo record);

	/**
	 * 查询标的项目相关信息
	 * @param biddeeId
	 * @param objectId
	 * @param statusCreate
	 * @return
	 */
	List<BidProjectInfo> selectProjects(@Param("biddeeId")Integer biddeeId, @Param("objectId")String objectId,@Param("status") String bidobjectstatus);
}