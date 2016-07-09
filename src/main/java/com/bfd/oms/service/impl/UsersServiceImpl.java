package com.bfd.oms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bfd.oms.dao.UserMapper;
import com.bfd.oms.model.Users;
import com.bfd.oms.service.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<Users> querySingleUser(String userName) {
		
		return userMapper.querySingleUser(userName);
	}

	@Override
	public boolean setUsers(Users user) {
		return userMapper.setUsers(user);		
	}

}
