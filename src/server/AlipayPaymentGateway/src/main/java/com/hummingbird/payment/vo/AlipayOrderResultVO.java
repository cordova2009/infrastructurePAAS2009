//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2015.12.08 时间 02:29:19 PM CST 
//


package com.hummingbird.payment.vo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="is_success" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="request">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="response">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="trade">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="buyer_email" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="buyer_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="flag_trade_locked" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="gmt_create" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="gmt_last_modified_time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="gmt_payment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="is_total_fee_adjust" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="operator_role" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="out_trade_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="payment_type" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="seller_email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="seller_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="time_out" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="time_out_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="to_buyer_fee" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="to_seller_fee" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="total_fee" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="trade_no" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                             &lt;element name="trade_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="use_coupon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="sign" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sign_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isSuccess",
    "request",
    "response",
    "sign",
    "signType",
    "error"
})
@XmlRootElement(name = "alipay")
public class AlipayOrderResultVO {

    @XmlElement(name = "is_success", required = true)
    protected String isSuccess;
    @XmlElement(required = true)
    protected AlipayOrderResultVO.Request request;
    @XmlElement(required = true)
    protected AlipayOrderResultVO.Response response;
    @XmlElement(required = true)
    protected String sign;
    @XmlElement(name = "sign_type", required = true)
    protected String signType;
    /**
     * 错误
     */
    @XmlElement(name = "error", required = true)
    protected String error;

    /**
     * 获取isSuccess属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsSuccess() {
        return isSuccess;
    }

    /**
     * 设置isSuccess属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsSuccess(String value) {
        this.isSuccess = value;
    }

    /**
     * 获取request属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Alipay.Request }
     *     
     */
    public AlipayOrderResultVO.Request getRequest() {
        return request;
    }

    /**
     * 设置request属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Alipay.Request }
     *     
     */
    public void setRequest(AlipayOrderResultVO.Request value) {
        this.request = value;
    }

    /**
     * 获取response属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AlipayOrderResultVO.Response }
     *     
     */
    public AlipayOrderResultVO.Response getResponse() {
        return response;
    }

    /**
     * 设置response属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AlipayOrderResultVO.Response }
     *     
     */
    public void setResponse(AlipayOrderResultVO.Response value) {
        this.response = value;
    }

    /**
     * 获取sign属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置sign属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSign(String value) {
        this.sign = value;
    }

    /**
     * 获取signType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignType() {
        return signType;
    }

    /**
     * 设置signType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignType(String value) {
        this.signType = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="param" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "param"
    })
    public static class Request {

        protected List<AlipayOrderResultVO.Request.Param> param;

        /**
         * Gets the value of the param property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the param property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getParam().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AlipayOrderResultVO.Request.Param }
         * 
         * 
         */
        public List<AlipayOrderResultVO.Request.Param> getParam() {
            if (param == null) {
                param = new ArrayList<AlipayOrderResultVO.Request.Param>();
            }
            return this.param;
        }


        /**
         * <p>anonymous complex type的 Java 类。
         * 
         * <p>以下模式片段指定包含在此类中的预期内容。
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Param {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "name")
            protected String name;

            /**
             * 获取value属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * 设置value属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * 获取name属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * 设置name属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

			/* (non-Javadoc)
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return "Param [value=" + value + ", name=" + name + "]";
			}

        }


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Request [param=" + param + "]";
		}

    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="trade">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="buyer_email" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="buyer_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="flag_trade_locked" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="gmt_create" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="gmt_last_modified_time" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="gmt_payment" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="is_total_fee_adjust" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="operator_role" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="out_trade_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="payment_type" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="seller_email" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="seller_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="time_out" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="time_out_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="to_buyer_fee" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="to_seller_fee" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="total_fee" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="trade_no" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *                   &lt;element name="trade_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="use_coupon" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "trade"
    })
    public static class Response {

        @XmlElement(required = true)
        protected AlipayOrderResultVO.Response.Trade trade;

        /**
         * 获取trade属性的值。
         * 
         * @return
         *     possible object is
         *     {@link AlipayOrderResultVO.Response.Trade }
         *     
         */
        public AlipayOrderResultVO.Response.Trade getTrade() {
            return trade;
        }

        /**
         * 设置trade属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link AlipayOrderResultVO.Response.Trade }
         *     
         */
        public void setTrade(AlipayOrderResultVO.Response.Trade value) {
            this.trade = value;
        }


        /**
         * <p>anonymous complex type的 Java 类。
         * 
         * <p>以下模式片段指定包含在此类中的预期内容。
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="buyer_email" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="buyer_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="flag_trade_locked" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="gmt_create" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="gmt_last_modified_time" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="gmt_payment" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="is_total_fee_adjust" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="operator_role" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="out_trade_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="payment_type" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="seller_email" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="seller_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="time_out" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="time_out_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="to_buyer_fee" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="to_seller_fee" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="total_fee" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="trade_no" type="{http://www.w3.org/2001/XMLSchema}integer"/>
         *         &lt;element name="trade_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="use_coupon" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "buyerEmail",
            "buyerId",
            "discount",
            "flagTradeLocked",
            "gmtCreate",
            "gmtLastModifiedTime",
            "gmtPayment",
            "isTotalFeeAdjust",
            "operatorRole",
            "outTradeNo",
            "paymentType",
            "price",
            "quantity",
            "sellerEmail",
            "sellerId",
            "subject",
            "timeOut",
            "timeOutType",
            "toBuyerFee",
            "toSellerFee",
            "totalFee",
            "tradeNo",
            "tradeStatus",
            "useCoupon"
        })
        public static class Trade {

            @XmlElement(name = "buyer_email")
            protected long buyerEmail;
            @XmlElement(name = "buyer_id")
            protected long buyerId;
            protected float discount;
            @XmlElement(name = "flag_trade_locked")
            protected byte flagTradeLocked;
            @XmlElement(name = "gmt_create", required = true)
            protected String gmtCreate;
            @XmlElement(name = "gmt_last_modified_time", required = true)
            protected String gmtLastModifiedTime;
            @XmlElement(name = "gmt_payment", required = true)
            protected String gmtPayment;
            @XmlElement(name = "is_total_fee_adjust", required = true)
            protected String isTotalFeeAdjust;
            @XmlElement(name = "operator_role", required = true)
            protected String operatorRole;
            @XmlElement(name = "out_trade_no", required = true)
            protected String outTradeNo;
            @XmlElement(name = "payment_type")
            protected byte paymentType;
            protected float price;
            protected byte quantity;
            @XmlElement(name = "seller_email", required = true)
            protected String sellerEmail;
            @XmlElement(name = "seller_id")
            protected long sellerId;
            @XmlElement(required = true)
            protected String subject;
            @XmlElement(name = "time_out", required = true)
            protected String timeOut;
            @XmlElement(name = "time_out_type", required = true)
            protected String timeOutType;
            @XmlElement(name = "to_buyer_fee")
            protected float toBuyerFee;
            @XmlElement(name = "to_seller_fee")
            protected float toSellerFee;
            @XmlElement(name = "total_fee")
            protected float totalFee;
            @XmlElement(name = "trade_no", required = true)
            protected String tradeNo;
            @XmlElement(name = "trade_status", required = true)
            protected String tradeStatus;
            @XmlElement(name = "use_coupon", required = true)
            protected String useCoupon;

            /**
             * 获取buyerEmail属性的值。
             * 
             */
            public long getBuyerEmail() {
                return buyerEmail;
            }

            /**
             * 设置buyerEmail属性的值。
             * 
             */
            public void setBuyerEmail(long value) {
                this.buyerEmail = value;
            }

            /**
             * 获取buyerId属性的值。
             * 
             */
            public long getBuyerId() {
                return buyerId;
            }

            /**
             * 设置buyerId属性的值。
             * 
             */
            public void setBuyerId(long value) {
                this.buyerId = value;
            }

            /**
             * 获取discount属性的值。
             * 
             */
            public float getDiscount() {
                return discount;
            }

            /**
             * 设置discount属性的值。
             * 
             */
            public void setDiscount(float value) {
                this.discount = value;
            }

            /**
             * 获取flagTradeLocked属性的值。
             * 
             */
            public byte getFlagTradeLocked() {
                return flagTradeLocked;
            }

            /**
             * 设置flagTradeLocked属性的值。
             * 
             */
            public void setFlagTradeLocked(byte value) {
                this.flagTradeLocked = value;
            }

            /**
             * 获取gmtCreate属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGmtCreate() {
                return gmtCreate;
            }

            /**
             * 设置gmtCreate属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGmtCreate(String value) {
                this.gmtCreate = value;
            }

            /**
             * 获取gmtLastModifiedTime属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGmtLastModifiedTime() {
                return gmtLastModifiedTime;
            }

            /**
             * 设置gmtLastModifiedTime属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGmtLastModifiedTime(String value) {
                this.gmtLastModifiedTime = value;
            }

            /**
             * 获取gmtPayment属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGmtPayment() {
                return gmtPayment;
            }

            /**
             * 设置gmtPayment属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGmtPayment(String value) {
                this.gmtPayment = value;
            }

            /**
             * 获取isTotalFeeAdjust属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsTotalFeeAdjust() {
                return isTotalFeeAdjust;
            }

            /**
             * 设置isTotalFeeAdjust属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsTotalFeeAdjust(String value) {
                this.isTotalFeeAdjust = value;
            }

            /**
             * 获取operatorRole属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOperatorRole() {
                return operatorRole;
            }

            /**
             * 设置operatorRole属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOperatorRole(String value) {
                this.operatorRole = value;
            }

            /**
             * 获取outTradeNo属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOutTradeNo() {
                return outTradeNo;
            }

            /**
             * 设置outTradeNo属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOutTradeNo(String value) {
                this.outTradeNo = value;
            }

            /**
             * 获取paymentType属性的值。
             * 
             */
            public byte getPaymentType() {
                return paymentType;
            }

            /**
             * 设置paymentType属性的值。
             * 
             */
            public void setPaymentType(byte value) {
                this.paymentType = value;
            }

            /**
             * 获取price属性的值。
             * 
             */
            public float getPrice() {
                return price;
            }

            /**
             * 设置price属性的值。
             * 
             */
            public void setPrice(float value) {
                this.price = value;
            }

            /**
             * 获取quantity属性的值。
             * 
             */
            public byte getQuantity() {
                return quantity;
            }

            /**
             * 设置quantity属性的值。
             * 
             */
            public void setQuantity(byte value) {
                this.quantity = value;
            }

            /**
             * 获取sellerEmail属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSellerEmail() {
                return sellerEmail;
            }

            /**
             * 设置sellerEmail属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSellerEmail(String value) {
                this.sellerEmail = value;
            }

            /**
             * 获取sellerId属性的值。
             * 
             */
            public long getSellerId() {
                return sellerId;
            }

            /**
             * 设置sellerId属性的值。
             * 
             */
            public void setSellerId(long value) {
                this.sellerId = value;
            }

            /**
             * 获取subject属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSubject() {
                return subject;
            }

            /**
             * 设置subject属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSubject(String value) {
                this.subject = value;
            }

            /**
             * 获取timeOut属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTimeOut() {
                return timeOut;
            }

            /**
             * 设置timeOut属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTimeOut(String value) {
                this.timeOut = value;
            }

            /**
             * 获取timeOutType属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTimeOutType() {
                return timeOutType;
            }

            /**
             * 设置timeOutType属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTimeOutType(String value) {
                this.timeOutType = value;
            }

            /**
             * 获取toBuyerFee属性的值。
             * 
             */
            public float getToBuyerFee() {
                return toBuyerFee;
            }

            /**
             * 设置toBuyerFee属性的值。
             * 
             */
            public void setToBuyerFee(float value) {
                this.toBuyerFee = value;
            }

            /**
             * 获取toSellerFee属性的值。
             * 
             */
            public float getToSellerFee() {
                return toSellerFee;
            }

            /**
             * 设置toSellerFee属性的值。
             * 
             */
            public void setToSellerFee(float value) {
                this.toSellerFee = value;
            }

            /**
             * 获取totalFee属性的值。
             * 
             */
            public float getTotalFee() {
                return totalFee;
            }

            /**
             * 设置totalFee属性的值。
             * 
             */
            public void setTotalFee(float value) {
                this.totalFee = value;
            }

            /**
             * 获取tradeNo属性的值。
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public String getTradeNo() {
                return tradeNo;
            }

            /**
             * 设置tradeNo属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setTradeNo(String value) {
                this.tradeNo = value;
            }

            /**
             * 获取tradeStatus属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTradeStatus() {
                return tradeStatus;
            }

            /**
             * 设置tradeStatus属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTradeStatus(String value) {
                this.tradeStatus = value;
            }

            /**
             * 获取useCoupon属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUseCoupon() {
                return useCoupon;
            }

            /**
             * 设置useCoupon属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUseCoupon(String value) {
                this.useCoupon = value;
            }

			/* (non-Javadoc)
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return "Trade [buyerEmail=" + buyerEmail + ", buyerId=" + buyerId + ", discount=" + discount
						+ ", flagTradeLocked=" + flagTradeLocked + ", gmtCreate=" + gmtCreate + ", gmtLastModifiedTime="
						+ gmtLastModifiedTime + ", gmtPayment=" + gmtPayment + ", isTotalFeeAdjust=" + isTotalFeeAdjust
						+ ", operatorRole=" + operatorRole + ", outTradeNo=" + outTradeNo + ", paymentType="
						+ paymentType + ", price=" + price + ", quantity=" + quantity + ", sellerEmail=" + sellerEmail
						+ ", sellerId=" + sellerId + ", subject=" + subject + ", timeOut=" + timeOut + ", timeOutType="
						+ timeOutType + ", toBuyerFee=" + toBuyerFee + ", toSellerFee=" + toSellerFee + ", totalFee="
						+ totalFee + ", tradeNo=" + tradeNo + ", tradeStatus=" + tradeStatus + ", useCoupon="
						+ useCoupon + "]";
			}

        }


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Response [trade=" + trade + "]";
		}

    }


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlipayOrderResultVO [isSuccess=" + isSuccess + ", request=" + request + ", response=" + response
				+ ", sign=" + sign + ", signType=" + signType + "]";
	}

	/**
	 * 错误 
	 */
	public String getError() {
		return error;
	}

	/**
	 * 错误 
	 */
	public void setError(String error) {
		this.error = error;
	}

}
