package com.hummingbird.paas.mapper;

import com.hummingbird.paas.entity.BidderCertificateAduit;

public interface BidderCertificateAduitMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(BidderCertificateAduit record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(BidderCertificateAduit record);

    /**
     * 根据主键查询记录
     */
    BidderCertificateAduit selectByPrimaryKey(Integer id);
    
    /**
     * 根据发包方资质认证表id查询记录
     */
    BidderCertificateAduit selectByBcid(Integer bcid);
    
    /**
     * 根据发包方资质认证表id查询个人认证状态 
     */
    BidderCertificateAduit selectPersonalInfo(Integer bcid);
    
    /**
     * 根据发包方资质认证表id查询基本信息认证状态 
     */
    BidderCertificateAduit selectBaseInfo(Integer bcid);
    
    /**
     * 根据发包方资质认证表id查询法人认证状态 
     */
    BidderCertificateAduit selectLegalPersonInfo(Integer bcid);
    
    /**
     * 根据发包方资质认证表id查询公司注册认证状态 
     */
    BidderCertificateAduit selectCompanyRegisteredInfo(Integer bcid);
    

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(BidderCertificateAduit record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(BidderCertificateAduit record);
}