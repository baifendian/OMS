package com.bfd.oms.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.bfd.oms.model.Menu;

/**
 * 菜单权限
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 */
@Repository
public interface MenuMapper {

	/**
	 * 获取所有菜单
	 * 
	 * @return list
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public List<Menu> getAllMenu();

	/**
	 * 根据用户名获取权限
	 * 
	 * @param userName
	 * @return list
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public List<Menu> getUserAuthorities(String userName);
}