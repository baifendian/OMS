package com.bfd.oms.service;

import java.util.List;
import java.util.Map;

import com.bfd.oms.model.Roles;
import com.bfd.oms.model.UserRole;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface IRolesService {
	
	/**
	 * 查询用户角色信息分页
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：List<Roles>
	 */
    public PageList<Roles> PageRoles(Map<String, Object> map) ;

    /**
     * 根据id查询角色信息
     * @author：wujun
     * @email: jun.wu@baifendian.com
     * @return_type：Roles
     */
	public Map<String, Object> selectByPrimaryKey(Integer userId);

	/**
	 * 查询角色表
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：List<Roles>
	 */
	public List<Roles> findlist();

	/**
	 * 设置用户的角色
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：boolean
	 */
	public boolean setUserRole(UserRole userrole);

	 

}
