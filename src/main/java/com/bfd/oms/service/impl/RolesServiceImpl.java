package com.bfd.oms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfd.oms.dao.RolesMapper;
import com.bfd.oms.dao.UserRoleMapper;
import com.bfd.oms.model.Roles;
import com.bfd.oms.model.UserRole;
import com.bfd.oms.service.IRolesService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
public class RolesServiceImpl implements IRolesService{

	@Autowired
	RolesMapper rolesMapper;
	
	@Autowired
	UserRoleMapper userroleMapper;

	@Override
	public PageList<Roles> PageRoles(Map<String, Object> map) {
		return rolesMapper.PageRoles(map);
	}

	@Override
	public Map<String, Object> selectByPrimaryKey(Integer userId) {
		return rolesMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<Roles> findlist() {
		return rolesMapper.findlist();
	}

	@Override
	public boolean setUserRole(UserRole userrole) {
		return userroleMapper.setUserRole(userrole);
	}
	

	 

}
