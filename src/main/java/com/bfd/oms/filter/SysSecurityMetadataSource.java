package com.bfd.oms.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import com.bfd.oms.dao.MenuMapper;
import com.bfd.oms.model.Menu;

/**
 * 加载资源与权限的对应关系
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 */
@Service
public class SysSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	@Autowired
	private MenuMapper										menuDao;
	private static Map<String, Collection<ConfigAttribute>>	resourceMap	= null;

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
		for (Map.Entry<String, Collection<ConfigAttribute>> entry : resourceMap.entrySet()) {
			allAttributes.addAll(entry.getValue());
		}
		return allAttributes;
	}

	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	/**
	 * @PostConstruct是Java EE 5引入的注解， Spring允许开发者在受管Bean中使用它。当DI容器实例化当前受管Bean时，
	 * @PostConstruct注解的方法会被自动触发，从而完成一些初始化工作，
	 * 
	 * 										加载所有资源与权限的关系
	 */
	@PostConstruct
	private void loadResourceDefine() {
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			List<Menu> menus = this.menuDao.getAllMenu();
			Collection<ConfigAttribute> configAttributes;
			ConfigAttribute configAttribute;
			for (Menu menu : menus) {
				configAttributes = new ArrayList<ConfigAttribute>();
				// TODO: 通过资源名称来表示具体的权限 注意：必须"ROLE_"开头
				configAttribute = new SecurityConfig("ROLE_" + menu.getResKey());
				//System.out.println("ROLE_" + menu.getResKey());
				configAttributes.add(configAttribute);
				resourceMap.put(menu.getResUrl(), configAttributes);
			}
		}
	}

	// 返回所请求资源所需要的权限
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		if (resourceMap == null) {
			loadResourceDefine();
		}
		// System.err.println("resourceMap.get(requestUrl);
		// "+resourceMap.get(requestUrl));
		if (requestUrl.indexOf("?") > -1) {
			requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
		}
		Collection<ConfigAttribute> configAttributes = resourceMap.get(requestUrl);
		return configAttributes;
	}

}