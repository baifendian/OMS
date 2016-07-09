package com.bfd.oms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.alibaba.fastjson.JSON;
import com.bfd.oms.model.LoginData;
import com.bfd.oms.model.Result;
import com.bfd.oms.util.CacheHelper;
import com.bfd.oms.util.GlobalVariable;
import com.bfd.oms.util.LoginValidte;
import com.bfd.oms.util.PageUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

public class BaseController {

	protected final Log				logger	= LogFactory.getLog(getClass());
	protected HttpServletRequest	request;

	/**
	 * 从request中获得参数Map，并返回可读的Map
	 * 
	 * @param request
	 * @return map
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> getParameterMap(HttpServletRequest request) {
		// 参数Map
		Map<String, Object> properties = request.getParameterMap();
		// 返回值Map
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Iterator entries = properties.entrySet().iterator();
		Map.Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			}
			else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			}
			else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}

	/**
	 * 产生分页信息
	 * 
	 * @param list
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public Object createPageInfo(PageList<?> list, HttpServletRequest request) {
		Paginator inator = list.getPaginator();
		Properties pro = PageUtil.getPro();
		Map<String, Object> map = new HashMap<>();
		map.put(pro.getProperty(GlobalVariable.PAGE_INDEX), inator.getPage());
		map.put(pro.getProperty(GlobalVariable.PAGE_SIZE), inator.getLimit());
		map.put(pro.getProperty(GlobalVariable.PAGE_DATA), list);
		map.put(pro.getProperty(GlobalVariable.PAGE_TOTAL), inator.getTotalCount());
		return map;
	}

	/**
	 * 注入request
	 * 
	 * @param request
	 */
	@Resource
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 登录的信息获取
	 * 
	 * @param request
	 * @return LoginData
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@ModelAttribute(value = "contextMap")
	public Map<String, Object> contextMap(HttpServletRequest request) {
		// 获取全公司邮箱的
		Object obj_mail = CacheHelper.getValue(CacheHelper.CACHE_MAIL, GlobalVariable.MAIL_DETAIL_CACHE);
		if (null == obj_mail) {
			obj_mail=LoginValidte.getMail();
			// 重新存储
			CacheHelper.setValue(CacheHelper.CACHE_MAIL, GlobalVariable.MAIL_DETAIL_CACHE,obj_mail );
		}
		Map<String, Object> contextMap = new HashMap<String, Object>();
		try {
			
			
			contextMap.put("now", new Date().getTime());
			
			// 项目路径
			contextMap.put("projectPath", request.getContextPath());
			HttpSession session = request.getSession();
			if (session != null) {
				Object obj = session.getAttribute(GlobalVariable.LOGIN_SESSION_Id);
				if (obj != null) {
					LoginData loginData = (LoginData) obj;
					loginData.setPassword(null);
					contextMap.put("user", JSON.toJSON(loginData));
				}
				else {
					return null;
				}
			}
			else {
				return null;
			}
		}
		catch (Exception e) {
			logger.error(e);
			return null;
		}
		return contextMap;
	}

	/**
	 * 
	 * @param response
	 * @param obj
	 *            要加工成JSON的对象
	 * @param result
	 *            返回的结果
	 * 
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	protected void OutWithJson(HttpServletResponse response, Result result) {
		// 将实体对象转换为JSON Object转换
		String jsonStr = JSON.toJSONString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(jsonStr);
			logger.debug(jsonStr);
		}
		catch (IOException e) {
			logger.error(e);
		}
		finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 获取登录信息
	 * 
	 * @param request
	 * @return
	 * 
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public LoginData getLoginData(HttpServletRequest request) {
		HttpSession httpSession = request.getSession(false);
		Object obj = httpSession.getAttribute(GlobalVariable.LOGIN_SESSION_Id);
		return (LoginData) obj;
	}
}
