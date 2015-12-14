//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2015.12.08 时间 02:29:19 PM CST 
//


package com.hummingbird.payment.vo;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hummingbird.payment.vo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hummingbird.payment.vo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AlipayOrderResultVO }
     * 
     */
    public AlipayOrderResultVO createAlipay() {
        return new AlipayOrderResultVO();
    }

    /**
     * Create an instance of {@link AlipayOrderResultVO.Response }
     * 
     */
    public AlipayOrderResultVO.Response createAlipayResponse() {
        return new AlipayOrderResultVO.Response();
    }

    /**
     * Create an instance of {@link AlipayOrderResultVO.Request }
     * 
     */
    public AlipayOrderResultVO.Request createAlipayRequest() {
        return new AlipayOrderResultVO.Request();
    }

    /**
     * Create an instance of {@link AlipayOrderResultVO.Response.Trade }
     * 
     */
    public AlipayOrderResultVO.Response.Trade createAlipayResponseTrade() {
        return new AlipayOrderResultVO.Response.Trade();
    }

    /**
     * Create an instance of {@link AlipayOrderResultVO.Request.Param }
     * 
     */
    public AlipayOrderResultVO.Request.Param createAlipayRequestParam() {
        return new AlipayOrderResultVO.Request.Param();
    }

}
