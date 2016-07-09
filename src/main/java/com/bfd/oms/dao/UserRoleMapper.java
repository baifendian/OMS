package com.bfd.oms.dao;

import java.util.Map;

import com.bfd.oms.model.UserRole;
import com.bfd.oms.model.UserRoleKey;

/**
 * 用户角色关联
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 */
public interface UserRoleMapper {
	/**
	 * 删除
	 * @param key
	 * @return
	 */
	int deleteByPrimaryKey(UserRoleKey key);

	/**
	 * 插入
	 * @param record
	 * @return
	 */
	int insertSelective(UserRole record);

	/**
	 * 查询
	 * @param key
	 * @return
	 */
	UserRole selectByPrimaryKey(UserRoleKey key);

	/**
	 * 更新
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(UserRole record);
	
	/**
	 * 设置用户信息
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：boolean
	 */
	boolean setUserRole(UserRole userrole);

}