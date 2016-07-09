package com.bfd.oms.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

/**
 * 分页信息包装工具类
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 *
 */
public class PageUtil {
	private static Logger		log					= Logger.getLogger(PageUtil.class);

	
	static Properties props;

	static {
		try {
			props = PropertiesLoaderUtils.loadAllProperties("conf/env.properties");
		}
		catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * 产生 分页参数
	 * 
	 * @param request
	 * @return
	 */
	public static PageBounds createPageBounds(Object object) {
		Properties props = getPro();
		// 判断是否是Map
		if (object instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) object;
			Object pageIndex = map.get(props.get("pageIndex"));
			Object pageSize = map.get(props.get("pageSize"));
			int page = Integer.parseInt(pageIndex == null ? "0" : pageIndex.toString());
			int limit = Integer.parseInt(pageSize == null ? "10" : pageSize.toString());
			return new PageBounds(page, limit);
		}
		else {
			return new PageBounds();
		}
	}

	public static Properties getPro() {
		try {
			if (props.size() == 0) {
				props = PropertiesLoaderUtils.loadAllProperties("conf/env.properties");
			}
			return props;
		}
		catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}

	}

	/**
	 * 产生分页信息
	 * 
	 * @param list
	 * @return
	 * @author 余明溢
	 */
	public Map<String, Object> createPageInfo(PageList<?> list) {
		Paginator inator = list.getPaginator();
		Properties pro = PageUtil.getPro();
		Map<String, Object> map = new HashMap<>();
		map.put(pro.getProperty("pageIndex"), inator.getPage());
		map.put(pro.getProperty("pageSize"), inator.getLimit());
		map.put(pro.getProperty("data"), list);
		map.put(pro.getProperty("total"), inator.getTotalCount());
		return map;
	}
}