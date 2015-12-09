package com.hummingbird.paas.vo;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.hummingbird.common.util.convertor.JacksonDateSerializer;
import com.hummingbird.common.util.convertor.JacksonDateTimeSerializer;

/**
 * 带证书信息的 招标投标列表
 * @author YJY  
 * @since 2015年11月11日22:12:08
 * */
public class TenderMyObjectBidReturnWithCertificationVO extends TenderMyObjectBidReturnVO{
//    "list":[{
//        "bidId":"4535264477",
//        "bidderCompanyName":"蜂鸟娱乐",
//        "bidderId":"4536789",
//        "bidTime":"2015-06-25 11:35:23",
//        "bidAmount":5000000,
//        "projectExpectStartDate":"2015-06-12",
//        "projectExpectPeriod":300
//        "fileUrl":"URL",
//        "certificationList":[{
//            "certificationId":1,
//            "certificationName":"一级建造师"
//        }]
//    }]
	
	List<TenderCertificationReturnVO> certificationList;

	/**
	 * @return the certificationList
	 */
	public List<TenderCertificationReturnVO> getCertificationList() {
		return certificationList;
	}

	/**
	 * @param certificationList the certificationList to set
	 */
	public void setCertificationList(List<TenderCertificationReturnVO> certificationList) {
		this.certificationList = certificationList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenderMyObjectBidReturnWithCertificationVO [certificationList=" + certificationList + "]";
	}
	


}
