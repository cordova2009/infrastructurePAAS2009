/**
 * 
 * AbstractBidFileTypeInfo.java
 * 版本所有 深圳市蜂鸟娱乐有限公司 2013-2014
 */
package com.hummingbird.paas.vo;

/**
 * @author john huang
 * 2015年12月23日 下午5:57:06
 * 本类主要做为 招标中的招投标文件要求
 */
public class AbstractBidFileTypeInfo {

	/**
	 * 投标方是否需要上传商务标书，YES，是。NO#，否。
	 */
	protected String needBusinessStandard;
	/**
	* 投标方是否需要上传技术标书，YES，是。NO#，否。
	*/
	protected String needTechnicalStandard;
	/**
	* 投标方是否需要上传资格审查文件，YES，是。NO#，否。
	*/
	protected String needCertificationCheckupFile;

	/**
	 * 构造函数
	 */
	public AbstractBidFileTypeInfo() {
		super();
	}

	/**
	 * 投标方是否需要上传商务标书，YES，是。NO#，否。
	 */
	public String getNeedBusinessStandard() {
	    return needBusinessStandard;
	}

	/**
	 * 投标方是否需要上传商务标书，YES，是。NO#，否。
	 */
	public void setNeedBusinessStandard(String needBusinessStandard) {
	    this.needBusinessStandard = needBusinessStandard;
	}

	/**
	* @return 投标方是否需要上传技术标书，YES，是。NO#，否。
	*/
	public String getNeedTechnicalStandard() {
	    return needTechnicalStandard;
	}

	/**
	 * @param 投标方是否需要上传技术标书，YES，是。NO#，否。
	 */
	public void setNeedTechnicalStandard(String needTechnicalStandard) {
	    this.needTechnicalStandard = needTechnicalStandard;
	}

	/**
	* @return 投标方是否需要上传资格审查文件，YES，是。NO#，否。
	*/
	public String getNeedCertificationCheckupFile() {
	    return needCertificationCheckupFile;
	}

	/**
	 * @param 投标方是否需要上传资格审查文件，YES，是。NO#，否。
	 */
	public void setNeedCertificationCheckupFile(String needCertificationCheckupFile) {
	    this.needCertificationCheckupFile = needCertificationCheckupFile;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractBidFileTypeInfo [needBusinessStandard=" + needBusinessStandard + ", needTechnicalStandard="
				+ needTechnicalStandard + ", needCertificationCheckupFile=" + needCertificationCheckupFile + "]";
	}

}