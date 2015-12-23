package com.hummingbird.payment.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.lang.ClassUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import com.hummingbird.common.exception.BusinessException;

/**
 * 使用jabx进行xml与bean转换
 *
 * @author john
 */
public class XmlBeanConvertUtil {

	protected String packagename = "";
	static Object lock = new Object();
	static JAXBContext context = null;
	static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory
			.getLog(XmlBeanConvertUtil.class);

	static {
		try {
			init();
		} catch (Exception e) {
			log.error("初始化失败",e);
		}
	}

	/**
	 * 转换xml为bean
	 *
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public static <T> T xml2bean(String xmlStr,T detail) throws BusinessException {
		init();
		try {
			Unmarshaller unmarshaller = context.createUnmarshaller();
			StringReader sr = new StringReader(xmlStr);
			Source source = new StreamSource(sr);
			JAXBElement<T> rootElement = (JAXBElement<T>) unmarshaller
					.unmarshal(source, detail.getClass());
			// JAXBElement rootElement =
			// (JAXBElement)unmarshaller.unmarshal(source,TXLifeType.class);
			T message = (T) rootElement.getValue();// Xml2Java
			if(log.isTraceEnabled()){
				log.trace(String.format("xml[%s]转换bean为%s",xmlStr,message));
			}
			return message;
		} catch (Exception ex) {
			log.error(String.format("转换xml到bean出错"),ex);
//			throw ValidateException.ERROR_MESSAGE_FORMATING;
			throw new ConversionException("转换xml到bean出错", ex);
		}

	}


	/**
	 * 转换非根xml 的bean到xml
	 *
	 * @param lifetype
	 * @return
	 * @throws BusinessException 
	 * @throws Exception
	 */
	public static String bean2xml(Object bean,Class c,String rootname) throws  BusinessException {
		init();
		try {
			Marshaller marshaller = context.createMarshaller();
			StringWriter sw = new StringWriter();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息（<?xml
			// version="1.0"
			// encoding="gb2312"
			// 设置TxLife为根结点
			marshaller.marshal(new JAXBElement(new QName(rootname),c, bean), sw);
			if(log.isTraceEnabled()){
				log.trace(String.format("bean[%s]输出xml为%s",bean,sw.toString()));
			}
			return sw.toString();
		} catch (JAXBException ex) {
			log.error("转换xml到bean出错",ex);
			throw new ConversionException("转换xml到bean出错", ex);
		}
	}

	private static void init() throws BusinessException {
		if (context == null) {
			synchronized (lock) {
				if (context == null) {
					try {
						List<Class> exclasses = getExtraClassFromPackage();
						context = JAXBContext.newInstance(exclasses.toArray(new Class[]{}));
					} catch (Exception ex) {
						log.error("初始化JAXB出错", ex);
						throw new BusinessException("初始化JAXB出错", ex);
					}
				}
			}
		}
	}

	/**
	 * 通过扫描指定目录，加载对应的类
	 * @return
	 * @throws Exception 
	 */
	private static List<Class> getExtraClassFromPackage() throws Exception {
		String RESOURCE_PATH = "classpath*:com/hummingbird/payment/vo/*.class";
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		List<Class> clist =  new ArrayList<Class>();
		try {
			Resource[] resources = resourcePatternResolver
					.getResources(RESOURCE_PATH);
			MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(
					resourcePatternResolver);
			for (Resource e : resources) {
				MetadataReader metadataReader = metadataReaderFactory
						.getMetadataReader(e);
				String clazzName = ClassUtils.getClass(
						metadataReader.getClassMetadata().getClassName())
						.getSimpleName();
				clist.add(ClassUtils.getClass(
						metadataReader.getClassMetadata().getClassName()));
			}

		} catch (Exception e) {
			throw e;
		}
		if (log.isDebugEnabled()) {
			log.debug(String.format("获取xml转换对象为%s",clist));
		}
		return clist;
	}


}
