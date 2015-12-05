package com.hummingbird.paas.mapper;

import java.util.List;

import com.hummingbird.paas.entity.Biddee;
import com.hummingbird.paas.vo.CompanyBaseInfo;
import com.hummingbird.paas.vo.CompanyCerticateInfo;
import com.hummingbird.paas.vo.CompanySurvey;

public interface BiddeeMapper {
    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(Biddee record);

    /**
     * 保存属性不为空的记录
     */
    int insertSelective(Biddee record);
    /**
     * 保存认证申请通过的资质表数据 
     */
    int insertSelectByBiddeeIdSuccess(Integer biddeeId);
    /**
     * 更新认证申请通过的资质表数据 
     */
    int updateByBiddeeIdSuccess(Integer biddeeId);

    /**
     * 根据主键查询记录
     */
    Biddee selectByPrimaryKey(Integer id);
    /**

     * 根据userId查询记录
     */
    Biddee selectByUserId(Integer userId);
    /**
     * 根据id查询概况信息
     */
    CompanySurvey selectCompanySurveyById(Integer id);
    /**
     * 根据id查询证书信息
     */
    List<CompanyCerticateInfo> selectCompanyCerticateInfoById(Integer id);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateByPrimaryKeySelective(Biddee record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKey(Biddee record);
    
    
}