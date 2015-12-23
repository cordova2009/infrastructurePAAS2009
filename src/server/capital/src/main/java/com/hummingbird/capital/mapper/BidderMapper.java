package com.hummingbird.capital.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hummingbird.capital.entity.Bidder;

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
}