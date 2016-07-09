package com.bfd.oms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfd.oms.dao.MenuMapper;
import com.bfd.oms.model.Menu;
import com.bfd.oms.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	MenuMapper menuMapper;

	
	@Override
	public List<Menu> getAllMenu() {
		return menuMapper.getAllMenu();
	}

	@Override
	public List<Menu> getUserAuthorities(String userName) {
		return menuMapper.getUserAuthorities(userName);
	}

}
