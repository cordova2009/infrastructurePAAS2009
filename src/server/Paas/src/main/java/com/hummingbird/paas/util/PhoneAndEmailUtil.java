package com.hummingbird.paas.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
public class PhoneAndEmailUtil {
	
	static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(PhoneAndEmailUtil.class);

	

    /**
     * 功能：手机固话验证
     * 
     * @param phoneNumber
     *            手机号或者固话
     * @return 
     * @throws ParseException
     */
	public Boolean isPhoneNumber(String phoneNumber)
	{
//		Pattern p=Pattern.compile("1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}");     
		
//		String regExp ="^[1][3,4,5,8][0-9]{9}||([0]{1}[0-9]{2,3})?-?([0-9]{7,8})||^[1-9]{1}[0-9]{5,8}$"; // 验证手机号
		String regExp ="^[1][3,4,5,8]\\d{9}||(([0]{1}\\d{2,3})?-?)?(\\d{7,8})$"; // 验证电话号
//		String regExp ="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}|[0]{1}[0-9]{2,3}-[0-9]{7,8}$";
//		Pattern p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的  
//		Pattern p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的 
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(phoneNumber);
		
		return m.matches();
	}
	 /**
     * 功能：邮箱验证
     * 
     * @param email
     *            邮箱
     * @return 
     * @throws ParseException
     */
	public Boolean isEmail(String email)
	{
		
		String regExp ="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"; // 验证邮箱
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(email);
		
		return m.matches();
	}

    /**
     * @param args
     * @throws ParseException
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) throws ParseException {
        // String IDCardNum="210102820826411";
        // String IDCardNum="210102198208264114";
//    	String phoneNumber = "13523212311";
        String phoneNumber = "027-12122200";
        String email = "www@qq.com";
        PhoneAndEmailUtil pn = new PhoneAndEmailUtil();
        System.out.println(pn.isPhoneNumber(phoneNumber)+"<<<<<"+pn.isEmail(email));
    }
    /*********************************** 电话验证结束 ****************************************/

}
