package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.vo.TenderMyObjectBidReturnVO;
import com.hummingbird.paas.vo.TenderSurveyReturnVO;

public interface BidRecordMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidRecord record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidRecord record);

    /**
     * 根据主键查询记录
     */
    BidRecord selectByPrimaryKey(Integer id);
    /**
     * 根据object_id,bidderid查询记录
     */
    BidRecord selectByObjectIdAndBidId(@Param("object_id") String object_id,@Param("bidId") Integer bidId);
    /**
     * 根据object_id查询记录
     */
    List<BidRecord> selectByObjectId(@Param("object_id") String object_id);
    
    /**
     * 定标页面,查询标的信息的概括
     */
    TenderSurveyReturnVO selectTenderSurvey2selectByObjectId(String object_id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidRecord record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidRecord record);
    /**
     * 查询投标的数目,投标的状态应该为OK# ,编制完成
     */
    int selectCountByObjectId(String objectId);
    
    /**
     * 招标方统计投标信息
     * @param objectId
     * @return
     */
    TenderSurveyReturnVO selectTenderSurveyByObjectId(String objectId);

	/**
	 * 查询未完成的投标
	 * @param bidId
	 * @param objectId
	 * @return
	 */
	List<BidRecord> selectUnfinishedBid(@Param("bidderId") Integer bidderId,@Param("objectId") String objectId);
	/**
	 * 我的招标项目投标列表做记录条数
	 * @param bidId
	 * @param objectId
	 * @return
	 */
	int selectTotalByObjectIdInValid(@Param("biddeeId") Integer biddeeId,@Param("objectId") String objectId);
	/**
	 * 我的招标项目投标列表接口
	 * @param bidId
	 * @param objectId
	 * @return
	 */
	List<TenderMyObjectBidReturnVO> selectByObjectIdInValid(@Param("biddeeId") Integer biddeeId,@Param("objectId") String objectId,@Param("page") Pagingnation page);

	/**
	 * 更新其它投标为失败
	 * @param objectId
	 * @param winbidderId
	 */
	void update2fail(@Param("objectId")String objectId,@Param("bidId") Integer winbidId);

	/**
	 * @param bidderId
	 * @param objectId
	 * @return
	 */
	List<BidRecord> selectBids(@Param("bidderId") Integer bidderId,@Param("objectId") String objectId,@Param("status") String status);
	

	
}