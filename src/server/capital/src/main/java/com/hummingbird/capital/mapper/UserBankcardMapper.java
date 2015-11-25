package com.hummingbird.capital.mapper;

import java.util.List;

import com.hummingbird.capital.entity.UserBankcard;

public interface UserBankcardMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(UserBankcard record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(UserBankcard record);
    
    /**
     * 插入招标人开户行信息  招标人开户行审核认证通过
     */
    int insertBiddeeBankInfo(Integer userId);
    /**
     * 更新招标人开户行信息  招标人开户行审核认证通过
     */
    int updateBiddeeBankInfo(Integer userId);
    
    /**
     * 插入投标人开户行信息 投标人开户行审核认证通过
     */
    int insertBidderBankInfo(Integer userId);
    
    /**
     * 更新投标人开户行信息 投标人开户行审核认证通过
     */
    int updateBidderBankInfo(Integer userId);

    /**
     * 根据主键查询记录
     */
    UserBankcard selectByPrimaryKey(Integer id);
    
    /**
     * 根据userId查询招标人开户行记录
     */
    List<UserBankcard> selectBiddeeBankInfoByUserId(Integer userId);
    /**
     * 根据userId查询投标人开户行记录
     */
    List<UserBankcard> selectBidderBankInfoByUserId(Integer userId);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(UserBankcard record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(UserBankcard record);
    
    /**
     * 根据userId查询银行卡信息
     * @param userId
     * @return
     */
    List<UserBankcard> queryBankListByUserId(Integer userId);
}