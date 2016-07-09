package com.bfd.oms.filter;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bfd.oms.dao.UserMapper;
import com.bfd.oms.dao.UserRoleMapper;
import com.bfd.oms.model.LoginData;
import com.bfd.oms.model.UserRole;
import com.bfd.oms.model.Users;
import com.bfd.oms.util.CacheHelper;
import com.bfd.oms.util.GlobalVariable;
import com.bfd.oms.util.LoginValidte;

/**
 * 用户登录验证过滤器
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 */
public class SysAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	protected final Log		logger		= LogFactory.getLog(getClass());

	/** 登录成功后跳转的地址 */
	private String			successUrl	= "/loginSuccess";
	/** 登录失败后跳转的地址 */
	private String			errorUrl	= "/login";

	@Autowired
	private UserMapper		usersDao;

	@Autowired
	private UserRoleMapper	userRoleDao;

	/** 定义登录成功和失败的跳转地址 */
	public void init() {
		// 验证成功，跳转的页面
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setDefaultTargetUrl(successUrl);
		successHandler.setAlwaysUseDefaultTargetUrl(true);
		this.setAuthenticationSuccessHandler(successHandler);

		// 验证失败，跳转的页面
		SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();
		failureHandler.setDefaultFailureUrl(errorUrl);
		this.setAuthenticationFailureHandler(failureHandler);
	}

	public void validateUser(HttpServletRequest request, String username, String password) {

		// 调用邮箱系统
		String result = LoginValidte.postData(username, password);
		// 返回值可能为空
		JSONObject jsonObj = null;
		String code = null;
		if (result != null) {
			jsonObj = JSON.parseObject(result);
			// code:1为异常0：为正常
			code = jsonObj.getString("code");
		}
 
		// 用户信息获取以及更新
		LoginData loginData = getUser(username, password);
		// 保存到session
		request.getSession().setAttribute("user_login_user", loginData);
		// 保存到cache
		CacheHelper.setValue(CacheHelper.CACHE_LOGIN_USER_NAME, username, loginData);
		/*if (code!=null&&code.equals("0")) {
 
		if (code!=null&&code.equals("0")) {
			// 用户信息获取以及更新
			LoginData loginData = getUser(username, password);
			// 保存到session
			request.getSession().setAttribute("user_login_user", loginData);
			// 保存到cache
			CacheHelper.setValue(CacheHelper.CACHE_LOGIN_USER_NAME, username, loginData);
 
		// 用户信息获取以及更新
		try {
			LoginData loginData = getUser(username, password);
			if (loginData != null) {
				// 保存到删除已有的
				CacheHelper.removePreKey(CacheHelper.CACHE_LOGIN_USER_NAME, username);
				// 保存到cache
				CacheHelper.setValue(CacheHelper.CACHE_LOGIN_USER_NAME, username, loginData.clone());
				
				// 保存到session的密码不加密
				loginData.setPassword(password);
				// 保存到session
				request.getSession().setAttribute(GlobalVariable.LOGIN_SESSION_Id, loginData);
			}
		}
		catch (Exception e) {
			logger.info(e);
			BadCredentialsException exception = new BadCredentialsException("登录异常");// 在界面输出自定义的信息！！
			throw exception;
		}
 

		if (code != null && code.equals("0")) {

		}
		else {
			BadCredentialsException exception = new BadCredentialsException("用户验证失败");// 在界面输出自定义的信息！！
			logger.error(exception);
			// throw exception;
		}*/

	}

	// 获取用户
	private LoginData getUser(String username, String password) {
		LoginData loginData;
		try {
			Users users = usersDao.queryUserAndRole(username);
			if (users == null) {
				// 新增
				users = createUser(username, password);
			}
			else {
				// 更新
				updateUser(username, password);
			}

			loginData = new LoginData(username, users.getUserPassword(), users.getRoleId(), users.getStatus());
		}
		catch (Exception e) {
			logger.error(e);
			return null;
		}
		return loginData;
	}

	// 新增用户
	@Transactional(rollbackFor = Exception.class)
	private Users createUser(String username, String password) {
		// 加密方法
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		// 密码加密
		String encodePwd = encode.encode(password);
		Users users = new Users(username, encodePwd);
		// 真名
		users.setUserRealname(username);
		// 别名
		users.setUserNickname(username);
		Date date = new Date();
		// 注册时间
		users.setRegTime(date);
		// 最近登录时间
		users.setLastLogintime(date);
		// 状态
		users.setStatus(true);
		usersDao.insertSelective(users);
		// 角色插入
		UserRole userRole = new UserRole();
		userRole.setCreateUser(GlobalVariable.OPERATION_USER_DEFAULT);
		userRole.setUpdateUser(GlobalVariable.OPERATION_USER_DEFAULT);
		userRole.setCreateTime(date);
		userRole.setUpdateTime(date);
		// 默认是职员
		userRole.setRoleId(GlobalVariable.ROLE_EMPLOYEE);
		users.setRoleId(GlobalVariable.ROLE_EMPLOYEE);
		userRole.setUserId(users.getUserId());
		userRole.setStatus(1);
		userRoleDao.insertSelective(userRole);
		return users;
	}

	// 新增用户
	private Users updateUser(String username, String password) {
		// 加密方法
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		// 密码加密
		String encodePwd = encode.encode(password);
		Users users = new Users(username, encodePwd);
		// 最近登录时间
		users.setLastLogintime(new Date());
		usersDao.updateByPrimaryKeySelective(users);
		return users;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("不支持的认证方法: " + request.getMethod());
		}

		String username = obtainUsername(request);
		String password = obtainPassword(request);
		if (username == null) {
			username = "";
		}
		if (password == null) {
			password = "";
		}
		username = username.trim();

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			BadCredentialsException exception = new BadCredentialsException("用户名或密码不能为空！");// 在界面输出自定义的信息！！
			throw exception;
		}
		// 验证用户账号与密码是否正确
		validateUser(request, username, password);
		// 验证用户账号与密码是否正确
		// Users users = this.userDao.querySingleUser(username);
		// if (users == null || !new BCryptPasswordEncoder().matches(password,
		// users.getUserPassword())) {
		// BadCredentialsException exception = new BadCredentialsException(
		// "用户名或密码不匹配！");
		// throw exception;
		// }
		// 当验证都通过后，把用户信息放在session里
		// request.getSession().setAttribute("userSession", users);
		// 实现 Authentication
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		// 允许子类设置详细属性
		setDetails(request, authRequest);

		// 运行UserDetailsService的loadUserByUsername 再次封装Authentication
		return this.getAuthenticationManager().authenticate(authRequest);
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

	public String getErrorUrl() {
		return errorUrl;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}

}
