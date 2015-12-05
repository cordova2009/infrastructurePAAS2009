package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.BidObject;
import com.hummingbird.paas.vo.MyTenderObjectListVO;
import com.hummingbird.paas.vo.QueryBidIndexListResult;
import com.hummingbird.paas.vo.QueryBidIndexSurveyResult;
import com.hummingbird.paas.vo.QueryIndexObjectListResult;
import com.hummingbird.paas.vo.QueryObjectIndexSurveyResult;
import com.hummingbird.paas.vo.TenderMyBuildingObjectVO;
import com.hummingbird.paas.vo.TenderMyEndedObjectVO;
import com.hummingbird.paas.vo.TenderObjectListReturnVO;

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
     * 根据biddeeId查询记录
     */
    double countAmountByBid(Integer user_id);
    /**
     * 根据user_id查询招标项目招标中的数量
     */
    int countTenderBidingNum(Integer user_id);
    /**
     * 根据user_id查询招标项目实施中的数量
     */
    int countTenderDoingNum(Integer user_id);
    /**
     * 根据user_id查询招标项目已完成的数量
     */
    int countTenderDoneNum(Integer user_id);
    
    /**
     * 查询投标项目招标中的数量
     */
    int countBidingNum(Integer user_id);
    /**
     * 查询投标项目实施中的数量
     */
    int countDoingNum(Integer user_id);
    /**
     * 查询投标项目已完成的数量
     */
    int countDoneNum(Integer user_id);
    
    /**
     * 计算我的招标数量
     */
    int selectTotalCountTenderObject(Integer user_id);
    /**
     * 计算我的实施中的招标数量
     */
    int selectTotalTenderBuildingObject(Integer user_id);
    /**
     * 计算我的已结束的招标数量
     */
    int selectTotalTenderEndedObject(Integer user_id);
    
    /**
	 * 我的招标信息
	 * @param id
	 * @return
	 */
	List<MyTenderObjectListVO> selectTenderObject(@Param("user_id")Integer user_id,@Param("page")Pagingnation page);
	/**
	 * 我的施工项目列表
	 * @param id
	 * @return
	 */
	List<TenderMyBuildingObjectVO> selectTenderBuildingObject(@Param("user_id")Integer user_id,@Param("page")Pagingnation page);
	
	/**
	 * 我的已结束项目列表接口
	 * @param id
	 * @return
	 */
	List<TenderMyEndedObjectVO> selectTenderEndedObject(@Param("user_id")Integer user_id,@Param("page")Pagingnation page);
	
	/**
	 * 计算列表总数
	 * @param id
	 * @return
	 */
	int selectTotalTenderObjectList(@Param("keywords")String[] keywords);
	
	/**
	 * 项目列表接口
	 * @param id
	 * @return
	 */
	List<TenderObjectListReturnVO> selectTenderObjectList(@Param("keywords")String[] keywords,@Param("page")Pagingnation page);
	/**
	 * 计算首页招标项目列表总数
	 * @param id
	 * @return
	 */
	int selectTotalIndexObjectList();
	
	/**
	 * 查询首页招标项目列表接口
	 * @param id
	 * @return
	 */
	List<QueryIndexObjectListResult> selectIndexObjectList(@Param("page")Pagingnation page);
	
	/**
	 * 查询首页中标结果概况接口
	 * @param id
	 * @return
	 */
	QueryBidIndexSurveyResult selectBidIndexSurvey();
	/**
	 * 查询首页招标项目概况接口
	 * @param id
	 * @return
	 */
	QueryObjectIndexSurveyResult selectObjectIndexSurvey();
	
	/**
	 * 查询首页中标项目列表接口
	 * @param publishTime 
	 * @param projectName 
	 * @return
	 */
	int selectTotalBidIndexList(@Param("projectName")String projectName,@Param("publishTime") Integer publishTime);
	
	/**
	 * 查询首页中标项目列表接口
	 * @return
	 */
	List<QueryBidIndexListResult> selectBidIndexList(@Param("projectName")String projectName,@Param("publishTime") Integer publishTime,@Param("page")Pagingnation page);
	

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
	/**
	 * 查询招标人发布的招标信息
	 * @param id
	 * @return
	 */
	List<BidObject> selectbyBiddeeId(@Param("biddeeId")Integer biddeeId,@Param("status")String status);
	/**
	 * 根据biddeeId查询招标数量
	 * @param id
	 * @return
	 */
	int selectTenderNumbyBiddeeId(Integer biddeeId);
	/**
	 * 根据biddeeId查询投标数量
	 * @param id
	 * @return
	 */
	int selectBidNumbyBiddeeId(Integer biddeeId);
	/**
	 * 根据biddeeId查询流标数量
	 * @param id
	 * @return
	 */
	int selectFlowNumbyBiddeeId(Integer biddeeId);
	/**
	 * 根据biddeeId查询中标数量
	 * @param id
	 * @return
	 */
	int selectWinNumbyBiddeeId(Integer biddeeId);
	/**
	 * 根据bidderId查询招标数量
	 * @param id
	 * @return
	 */
	int selectTenderNumbyBidderId(Integer bidderId);
	/**
	 * 根据bidderId查询投标数量
	 * @param id
	 * @return
	 */
	int selectBidNumbyBidderId(Integer bidderId);
	/**
	 * 根据bidderId查询流标数量
	 * @param id
	 * @return
	 */
	int selectFlowNumbyBidderId(Integer bidderId);
	/**
	 * 根据bidderId查询中标数量
	 * @param id
	 * @return
	 */
	int selectWinNumbyBidderId(Integer bidderId);
	
}