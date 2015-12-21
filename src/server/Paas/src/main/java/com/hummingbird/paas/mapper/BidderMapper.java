package com.hummingbird.paas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.common.face.Pagingnation;
import com.hummingbird.paas.entity.Bidder;
import com.hummingbird.paas.vo.CompanyCerticateInfo;
import com.hummingbird.paas.vo.CompanySurvey;
import com.hummingbird.paas.vo.MyLoseObjectProject;
import com.hummingbird.paas.vo.QueryBidderListHomepageResultVO;
import com.hummingbird.paas.vo.QueryCertificateListBodyVO;

public interface BidderMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Bidder record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Bidder record);
    
    /**
     * 保存认证申请通过的资质表数据 
     */
    int insertSelectByBidderIdSuccess(Integer bidderId);
    
    /**
     * 更新认证申请通过的资质表数据 
     */
    int updateByBidderIdSuccess(Integer bidderId);

    /**
     * 根据主键查询记录
     */
    Bidder selectByPrimaryKey(Integer id);
    /**
     * 根据工程邀请投标人
     */
    List<Bidder> selectInviteBidders(String  objectId);
    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Bidder record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Bidder record);
    
    /**
     * 根据userId查询记录
     */
    Bidder selectByUserId(Integer userId);
    /**
     * 查询首页投标人推荐列表接口
     */
    List<Bidder> getIndexBidListPages(@Param("begin") int begin ,@Param("limit") int limit);
    
    /**
     * 查询一级承包商数量
     */
    int countStairBiderNum();
    /**
     * 查询二级承包商数量
     */
    int countSecondBiderNum();
    
    /**
     * 根据id查询概况信息
     */
    CompanySurvey selectCompanySurveyById(Integer id);
    
    /**
     * 根据id查询证书信息
     */
    List<CompanyCerticateInfo> selectCompanyCerticateInfoById(Integer id);

	/**
	 * 查询投标人列表 
	 * @param queryCertificateListBodyVO
	 * @param pagingnation
	 * @return
	 */
	List<Bidder> selectBidder(@Param("queryCertificateListBodyVO")QueryCertificateListBodyVO queryCertificateListBodyVO,@Param("page") Pagingnation pagingnation);

	/**
	 * 查询投标人总记录数
	 * @param queryCertificateListBodyVO
	 * @return
	 */
	int selectBidderCount(QueryCertificateListBodyVO queryCertificateListBodyVO);


	/**
	 * 查询首页的投标人信息
	 * @param keywords
	 * @param bidderName
	 * @param pagingnation
	 * @return
	 */
	List<QueryBidderListHomepageResultVO> selectBidder4homepage(@Param("keyword")List<String> keywords,@Param("bidderName") String bidderName,
			@Param("page") Pagingnation pagingnation);
    
}