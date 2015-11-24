package com.hummingbird.paas.vo;

import java.util.Date;

import com.hummingbird.commonbiz.vo.AppBaseVO;
import com.hummingbird.commonbiz.vo.Decidable;

/**
 * 保存招标人资质认证信息
 * @author YJY  
 * @since 2015年11月7日12:06:30
 * */
public class BiddeeCerticateSaveBaseInfoVO extends AppBaseVO implements Decidable{
	private BiddeeCerticateSaveBaseInfoBodyVO body;

	/**
	 * @return the body
	 */
	public BiddeeCerticateSaveBaseInfoBodyVO getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(BiddeeCerticateSaveBaseInfoBodyVO body) {
		this.body = body;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeCerticateSaveBaseInfoVO [body=" + body + "]";
	}

	
	

}
