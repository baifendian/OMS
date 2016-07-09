package com.bfd.oms.dao;

import java.util.List;
import java.util.Map;

import com.bfd.oms.model.Roles;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface RolesMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Roles record);

    int insertSelective(Roles record);

    /**
     * 根据id查询角色信息
     * @author：wujun
     * @email: jun.wu@baifendian.com
     * @return_type：Roles
     */
    Map<String, Object> selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);

    /**
     * 查询用户角色信息分页
     * @author：wujun
     * @email: jun.wu@baifendian.com
     * @return_type：PageList<Roles>
     */
	PageList<Roles> PageRoles(Map<String, Object> map);

	/**
	 * 查询角色表
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：List<Roles>
	 */
	List<Roles> findlist();

}