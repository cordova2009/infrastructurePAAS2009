package com.hummingbird.paas.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.ObjectProject;
import com.hummingbird.paas.entity.Objects;
import com.hummingbird.paas.vo.MyBuildingObjectProject;
import com.hummingbird.paas.vo.MyEndedObjectProject;
import com.hummingbird.paas.vo.MyLoseObjectProject;
import com.hummingbird.paas.vo.QueryMyBidObjectListResultVO;

public interface ObjectProjectMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(String objectId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(ObjectProject record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(ObjectProject record);

    /**
     * 根据主键查询记录
     */
    ObjectProject selectByPrimaryKey(String objectId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(ObjectProject record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(ObjectProject record);
    
    @Deprecated()
    List<ObjectProject> getPages(@Param("begin") int begin ,@Param("limit") int limit);
    int getPagesCount();
    
    List<ObjectProject> getMyObjectProjectPages(@Param("userId")Integer userId,@Param("begin") int begin ,@Param("limit") int limit);
    int getMyObjectProjectCount(@Param("userId")Integer userId);
    
    List<MyBuildingObjectProject> getMyBuildingObjectProjectPages(@Param("userId")Integer userId,@Param("begin") int begin ,@Param("limit") int limit);
    int getMyBuildingObjectProjectCount(@Param("userId")Integer userId);
    
    List<MyEndedObjectProject> getMyEndedObjectProjectPages(@Param("userId")Integer userId,@Param("begin") int begin ,@Param("limit") int limit);
    int getMyEndedObjectProjectCount(@Param("userId")Integer userId);
    
    List<MyLoseObjectProject> getMyLoseObjectProjectPages(@Param("userId")Integer userId,@Param("begin") int begin ,@Param("limit") int limit);
    int getMyLoseObjectProjectCount(@Param("userId")Integer userId);

	/**
	 * 统计总记录数
	 * @param param
	 * @return
	 */
	int queryObjectCount(@Param("param")Map param);

	/**
	 * 分页查询招标记录
	 * @param pagingnation
	 * @param param
	 * @return
	 */
	List<ObjectProject> queryObjectByPage(@Param("page") Pagingnation pagingnation,@Param("param") Map param);
    
	/**
	 * 分页查询正在投标记录
	 * @param pagingnation
	 * @param param
	 * @return
	 */
	List<QueryMyBidObjectListResultVO> queryBidByAccountId(@Param("page") Pagingnation pagingnation,@Param("user_id") Integer userId);
    
    }