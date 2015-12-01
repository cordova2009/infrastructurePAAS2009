package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.paas.entity.BidRecord;
import com.hummingbird.paas.vo.MyObjectTenderSurveyBodyVOResult;
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
    BidRecord selectByObjectIdAndBidderId(@Param("object_id") String object_id,@Param("bidder_id") Integer bidder_id);
    
    /**
     * 根据object_id查询记录
     */
    TenderSurveyReturnVO selectByObjectId(String object_id);

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
    MyObjectTenderSurveyBodyVOResult selectTenderSurveyByObjectId(String objectId);

	/**
	 * 查询未完成的投标
	 * @param bidId
	 * @param objectId
	 * @return
	 */
	List<BidRecord> selectUnfinishedBid(@Param("bidderId") Integer bidderId,@Param("objectId") String objectId);
}