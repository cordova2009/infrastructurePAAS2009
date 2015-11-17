package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

/**
 * 保存投标人资质认证信息
 * @author YJY  
 * @since 2015年11月10日16:22:29
 * */
public class BidderCerticateSaveInfoVO extends AppBaseVO implements Decidable{
	private BidderCerticateSaveInfoBodyVO body;

	/**
	 * @return the body
	 */
	public BidderCerticateSaveInfoBodyVO getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(BidderCerticateSaveInfoBodyVO body) {
		this.body = body;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BidderCerticateSaveInfoVO [body=" + body + "]";
	}

	

	
	

}
