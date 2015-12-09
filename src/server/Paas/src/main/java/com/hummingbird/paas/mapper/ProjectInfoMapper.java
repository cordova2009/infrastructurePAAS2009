package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.ProjectInfo;

public interface ProjectInfoMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String projectId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ProjectInfo record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ProjectInfo record);

    /**
     * 根据主键查询记录
     */
    ProjectInfo selectByPrimaryKey(String projectId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ProjectInfo record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ProjectInfo record);
    
    /**
     * 
     * @param objectId
     * @return
     */
    List<ProjectInfo> selectByObjectId(String objectId);
    /**
     * 查询发布的标的
     * @param biddeeId
     * @param pagingnation 
     * @return
     */
    List<ProjectInfo> queryBeeProject(@Param("biddeeId")Integer biddeeId,@Param("page") Pagingnation pagingnation);
    
    /**
     * 查询中标的标的
     */
    List<ProjectInfo> queryBerProject(@Param("bidderId")Integer bidderId,@Param("page")Pagingnation pagingnation);

	/**
	 * 查询中标的标的记录条数
	 * @param bidderId
	 * @return
	 */
	int selectBerProjectCount(Integer bidderId);

	/**
	 * 查询记录条件
	 * @param biddeeId
	 * @return
	 */
	int queryBeeProjectCount(Integer biddeeId);
}