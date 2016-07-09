package com.bfd.oms.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4JUtil {
	protected static final Log	logger	= LogFactory.getLog(Dom4JUtil.class);
	public static String		xmlpath	= "";
	public static Element		root;

	public Dom4JUtil() {
		xmlpath = getClass().getClassLoader().getResource("").getPath() + GlobalVariable.MAIL_TIP_TEMP_PATH;
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(new File(xmlpath));
			root = document.getRootElement();
		}
		catch (DocumentException e) {
			logger.error(e);
		}
	}

	/**
	 * 用dom4j 根据 父元素和id 获取对呀节点
	 * 
	 * @param el
	 *            父元素
	 * @param id
	 *            子元素 id
	 * @return 子元素
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@SuppressWarnings("unchecked")
	public Element getEleById(Element el, String id) {
		try {
			if (el == null) {
				el = root;
			}
			Element elRe = null;
			for (Iterator<Element> i = el.elementIterator(); i.hasNext();) {
				Element elc = (Element) i.next();
				String idStr = elc.attributeValue("id");
				if (idStr != null && idStr.equals(id)) {
					elRe = elc;
					break;
				}
				else {
					if (elRe == null)
						elRe = getEleById(elc, id);
				}
			}
			return elRe;
		}
		catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	/**
	 * 对父元素的子元素赋值
	 * 
	 * @param el
	 *            父元素
	 * @param list
	 * @return 父元素内容
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@SuppressWarnings("unchecked")
	public static String setText(Element el, List<Object> list) {
		try {
			Iterator<Object> str = list.iterator();
			for (Iterator<Element> j = el.elementIterator(); j.hasNext();) {
				Element elc = (Element) j.next();
				if (str.hasNext())
					elc.setText(str.next().toString());
			}
			if (!el.elementIterator().hasNext()) {
				el.setText(str.next().toString());
			}
			return el.asXML();
		}
		catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	/**
	 * 根据 元素id 获取 内容
	 * 
	 * @param id
	 *            元素id
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public String getText(String id) {
		Element el = getEleById(Dom4JUtil.root, id);
		return el.asXML();
	}

	/**
	 * 根据 父Element 元素id 获取 内容
	 * 
	 * @param el
	 *            父Element
	 * @param id
	 *            元素id
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public String getText(Element el, String id) {
		if (el == null) {
			el = getEleById(Dom4JUtil.root, id);
		}
		return el.asXML();
	}

	/**
	 * 根据 父Element 元素 添加子元素
	 * 
	 * @param el
	 *            父Element
	 * @param list
	 *            子元素
	 * @return 父Element 内容
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public String addElement(Element el, List<Element> list) {
		for (int i = 0; i < list.size(); i++) {
			el.add(list.get(i));
		}
		return el.asXML();
	}

	/**
	 * 根据 添加元素
	 * 
	 * @param list
	 *            子元素
	 * @return root 内容
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public String addElement(List<Element> list) {
		return addElement(root, list);
	}

}
