package com.bfd.oms.service;

import java.util.List;
import com.bfd.oms.model.Menu;

/**
 * 菜单权限
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 */
public interface IMenuService {
	/**
	 * 获取所有菜单
	 * @return list
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public List<Menu> getAllMenu();

	/**
	 * 根据用户名获取权限
	 * @param userName
	 * @return list
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public List<Menu> getUserAuthorities(String userName);

}
