package com.bfd.oms.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.bfd.oms.model.Users;

/**
 * 用户信息
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 *
 */
@Repository
public interface UserMapper {

	/**
	 * 插入用户
	 * 
	 * @param record
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	void insertSelective(Users record);

	/**
	 * 根据用户名获取用户
	 * 
	 * @param userName
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	List<Users> querySingleUser(String userName);

	/**
	 * 更新用户
	 * 
	 * @param record
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	void updateByPrimaryKeySelective(Users record);

    boolean setUsers(Users user);
    
    /**
	 * 根据用户名获取用户
	 * 
	 * @param userName及角色
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
    public Users queryUserAndRole(String userName);
}