package com.bfd.oms.service;

import java.util.List;

import com.bfd.oms.model.Users;

public interface IUsersService {
	
	/**
	 * 查询用户的基本信息
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：List<Users>
	 */
    public List<Users> querySingleUser(String userName) ;

    /**
     * 设置用户的基本信息
     * @author：wujun
     * @email: jun.wu@baifendian.com
     * @return_type：boolean
     */
	public boolean setUsers(Users user);

}
