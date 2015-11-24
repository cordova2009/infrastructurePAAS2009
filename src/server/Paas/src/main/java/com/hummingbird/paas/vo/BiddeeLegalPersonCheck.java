package com.hummingbird.paas.vo;

import java.util.Date;

/**
 * 招标人认证审核接口 
 * @author YJY  
 * @since 2015年11月7日11:06:3
 * @see 用于规范json
 * */

//"baseInfoCheck":{
//"biddeeId":999,
//"companyName":{"result":"FLS","msg":"公司名称与工商注册名称不一致"},
//"shortName":{"result":"OK#","msg":""},
//"description":{"result":"OK#","msg":""},
//"registeredCapital":{"result":"OK#","msg":""},
//"telephone":{"result":"OK#","msg":""},
//"email":{"result":"OK#","msg":""},
//"logoUrl":{"result":"OK#","msg":""}
//}
public class BiddeeLegalPersonCheck {
	
	private AuditInfo  legal_person;
	private AuditInfo  legal_person_idcard;
	private AuditInfo  legal_person_idcard_front_url;
	private AuditInfo  legal_person_idcard_back_url;
	private AuditInfo  legal_person_authority_book;
	/**
	 * @return the legal_person
	 */
	public AuditInfo getLegal_person() {
		return legal_person;
	}
	/**
	 * @return the legal_person_idcard
	 */
	public AuditInfo getLegal_person_idcard() {
		return legal_person_idcard;
	}
	/**
	 * @return the legal_person_idcard_front_url
	 */
	public AuditInfo getLegal_person_idcard_front_url() {
		return legal_person_idcard_front_url;
	}
	/**
	 * @return the legal_person_idcard_back_url
	 */
	public AuditInfo getLegal_person_idcard_back_url() {
		return legal_person_idcard_back_url;
	}
	/**
	 * @return the legal_person_authority_book
	 */
	public AuditInfo getLegal_person_authority_book() {
		return legal_person_authority_book;
	}
	/**
	 * @param legal_person the legal_person to set
	 */
	public void setLegal_person(AuditInfo legal_person) {
		this.legal_person = legal_person;
	}
	/**
	 * @param legal_person_idcard the legal_person_idcard to set
	 */
	public void setLegal_person_idcard(AuditInfo legal_person_idcard) {
		this.legal_person_idcard = legal_person_idcard;
	}
	/**
	 * @param legal_person_idcard_front_url the legal_person_idcard_front_url to set
	 */
	public void setLegal_person_idcard_front_url(AuditInfo legal_person_idcard_front_url) {
		this.legal_person_idcard_front_url = legal_person_idcard_front_url;
	}
	/**
	 * @param legal_person_idcard_back_url the legal_person_idcard_back_url to set
	 */
	public void setLegal_person_idcard_back_url(AuditInfo legal_person_idcard_back_url) {
		this.legal_person_idcard_back_url = legal_person_idcard_back_url;
	}
	/**
	 * @param legal_person_authority_book the legal_person_authority_book to set
	 */
	public void setLegal_person_authority_book(AuditInfo legal_person_authority_book) {
		this.legal_person_authority_book = legal_person_authority_book;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BiddeeBaseInfoCheck [legal_person=" + legal_person + ", legal_person_idcard=" + legal_person_idcard
				+ ", legal_person_idcard_front_url=" + legal_person_idcard_front_url + ", legal_person_idcard_back_url="
				+ legal_person_idcard_back_url + ", legal_person_authority_book=" + legal_person_authority_book + "]";
	}
	
	
}
