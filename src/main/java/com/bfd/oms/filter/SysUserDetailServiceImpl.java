package com.bfd.oms.filter;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.bfd.oms.dao.MenuMapper;
import com.bfd.oms.dao.UserMapper;
import com.bfd.oms.model.LoginData;
import com.bfd.oms.model.Menu;
import com.bfd.oms.model.Users;
import com.bfd.oms.util.CacheHelper;

/**
 * 用户登录时信息校验
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 */
@Service
public class SysUserDetailServiceImpl implements UserDetailsService {

	/** Logger available to subclasses */
	protected final Log	logger	= LogFactory.getLog(getClass());

	@Autowired
	private UserMapper	usersDao;
	@Autowired
	private MenuMapper	menuDao;
	
	/** 根据用户名获取用户信息 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//从缓存获取信息
		Object loginObj=CacheHelper.getValue(CacheHelper.CACHE_LOGIN_USER_NAME, username);
		Users users = null;
		if(loginObj==null){
			users = usersDao.queryUserAndRole(username); 
		}else{
			LoginData login = (LoginData)loginObj;
			users=new Users(login.getUsername(), login.getPassword(),login.getStatus());
		}
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(users);
		// 封装成spring security的user
		User userdetail = new User(users.getUserName(), users.getUserPassword(), users.getStatus(), // 账号是否可用
				true, // 账号是否过期
				true, // 密码是否过期
				true, // 账号是否被锁定
				grantedAuths // 用户的权限
		);
		return userdetail;
	}

	/** 取得用户的权限 */
	private Set<GrantedAuthority> obtionGrantedAuthorities(Users user) {
		String userName = user.getUserName();
		List<Menu> resKeys = menuDao.getUserAuthorities(userName);
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		for (Menu menu : resKeys) {
			String keys = menu.getResKey();
			// TODO: 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
			logger.info("用户‘" + userName + "’取得权限:ROLE_" + keys);
			authSet.add(new SimpleGrantedAuthority("ROLE_" + keys));
		}
		return authSet;
	}
	
	
	
}