//package com.bboss.common.util;
//
//import javax.xml.bind.JAXBContext;
//
//public class JaxbUtil {
//	// 多线程安全的Context.
//	private JAXBContext jaxbContext;
//
//	/**
//	 * @param types
//	 *            所有需要序列化的Root对象的类型.
//	 */
//	public JaxbUtil(Class<?>... types) {
//		try {
//			jaxbContext = JAXBContext.newInstance(types);
//		} catch (JAXBException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * Java Object->Xml.
//	 */
//	public String toXml(Object root, String encoding) {
//		try {
//			StringWriter writer = new StringWriter();
//			createMarshaller(encoding).marshal(root, writer);
//			return writer.toString();
//		} catch (JAXBException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * Java Object->Xml, 特别支持对Root Element是Collection的情形.
//	 */
//	
//	@SuppressWarnings("rawtypes")
//	public String toXml(Collection root, String rootName, String encoding) {
//		try {
//			CollectionWrapper wrapper = new CollectionWrapper();
//			wrapper.collection = root;
//
//			JAXBElement<CollectionWrapper> wrapperElement = new JAXBElement<CollectionWrapper>(new QName(rootName), CollectionWrapper.class, wrapper);
//
//			StringWriter writer = new StringWriter();
//			createMarshaller(encoding).marshal(wrapperElement, writer);
//
//			return writer.toString();
//		} catch (JAXBException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * Xml->Java Object.
//	 */
//	@SuppressWarnings("unchecked")
//	public <T> T fromXml(String xml) {
//		try {
//			StringReader reader = new StringReader(xml);
//			SAXjson2BodyListFactory sax=SAXjson2BodyListFactory.newInstance();
//			sax.setNamespaceAware(false);
//			XMLReader xmlReader=sax.newSAXjson2BodyList().getXMLReader();
//			Source source=new SAXSource(xmlReader,new InputSource(reader));
//			return (T) createUnmarshaller().unmarshal(source);
//		} catch (JAXBException e) {
//			throw new RuntimeException(e);
//		} catch (SAXException e) {
//			throw new RuntimeException(e);
//		} catch (json2BodyListConfigurationException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * Xml->Java Object, 支持大小写敏感或不敏感.
//	 */
//	@SuppressWarnings("unchecked")
//	public <T> T fromXml(String xml, boolean caseSensitive) {
//		try {
//			String fromXml = xml;
//			if (!caseSensitive)
//				fromXml = xml.toLowerCase();
//			StringReader reader = new StringReader(fromXml);
//		     SAXjson2BodyListFactory sax=SAXjson2BodyListFactory.newInstance();
//	            sax.setNamespaceAware(false);
//	            XMLReader xmlReader=sax.newSAXjson2BodyList().getXMLReader();
//	            Source source=new SAXSource(xmlReader,new InputSource(reader));
//	            return (T) createUnmarshaller().unmarshal(source);
//		} catch (JAXBException e) {
//			throw new RuntimeException(e);
//		} catch (SAXException e) {
//		    throw new RuntimeException(e);
//        } catch (json2BodyListConfigurationException e) {
//            throw new RuntimeException(e);
//        }
//	}
//
//	/**
//	 * 创建Marshaller, 设定encoding(可为Null).
//	 */
//	public Marshaller createMarshaller(String encoding) {
//		try {
//			Marshaller marshaller = jaxbContext.createMarshaller();
//			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息 
//			if (StringUtils.isNotBlank(encoding)) {
//				marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
//			}
//			 marshaller.setProperty(CharacterEscapeHandler.class.getName(),  new CharacterEscapeHandler() {
//	                @Override
//	                public void escape(char[] ac, int i, int j, boolean flag,Writer writer) throws IOException {
//	                    writer.write(ac, i, j);
//	                }
//	             });
//			return marshaller;
//		} catch (JAXBException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * 创建UnMarshaller.
//	 */
//	public Unmarshaller createUnmarshaller() {
//		try {
//			return jaxbContext.createUnmarshaller();
//		} catch (JAXBException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * 封装Root Element 是 Collection的情况.
//	 */
//	public static class CollectionWrapper {
//		
//		@SuppressWarnings("rawtypes")
//		@XmlAnyElement
//		protected Collection collection;
//	}
//}
