package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BiddeeCertificateAduit;

public interface BiddeeCertificateAduitMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BiddeeCertificateAduit record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BiddeeCertificateAduit record);

    /**
     * 根据主键查询记录
     */
    BiddeeCertificateAduit selectByPrimaryKey(Integer id);
    
    /**
     * 根据发包方资质认证表id查询记录
     */
    BiddeeCertificateAduit selectByBcid(Integer bcid);
    
    /**
     * 根据发包方资质认证表id查询个人认证状态 
     */
    BiddeeCertificateAduit selectPersonalInfo(Integer bcid);
    
    /**
     * 根据发包方资质认证表id查询基本信息认证状态 
     */
    BiddeeCertificateAduit selectBaseInfo(Integer bcid);
    
    /**
     * 根据发包方资质认证表id查询法人认证状态 
     */
    BiddeeCertificateAduit selectLegalPersonInfo(Integer bcid);
    
    /**
     * 根据发包方资质认证表id查询公司注册认证状态 
     */
    BiddeeCertificateAduit selectCompanyRegisteredInfo(Integer bcid);
    

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BiddeeCertificateAduit record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BiddeeCertificateAduit record);
}