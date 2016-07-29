package com.bfd.oms.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bfd.oms.model.LoginData;
import com.bfd.oms.model.Result;
import com.bfd.oms.model.Users;
import com.bfd.oms.service.IUsersService;

/**
 * 个人中心
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 */
@Controller
@RequestMapping("/user")
public class PersonalCenterController extends BaseController {

	@Autowired
	private IUsersService user;

	/**
	 * 个人中心 跳转页面
	 * 
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@RequestMapping("/personalCenter")
	public String personalCenter() {
		return "index";
	}

	/**
	 * 查询用户的基本信息
	 * 
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：String
	 */
	@RequestMapping(value = "/querySingleUser", method = RequestMethod.GET)
	@ResponseBody
	public Object querySingleUser(HttpServletRequest request) {
		List<Users> users = new ArrayList<>();
		LoginData loginData = (LoginData) request.getSession().getAttribute("user_login_user");
		if (null != loginData) {
			users = user.querySingleUser(loginData.getUsername());
		}
		if (users.size() > 0) {
			Users use=users.get(0);
			use.setUserPassword(null);
			return new Result();
		}
		else {
			return new Result(500, "用户不存在！");
		}

	}

	/**
	 * 设置用户的基本信息
	 * 
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：boolean
	 */
	@RequestMapping(value = "/setUsers")
	@ResponseBody
	public Object setUsers(HttpServletRequest req,@RequestParam(value="remindtime")Integer remindtime ) {
		Users user=new Users(remindtime);
		user.setUserName(getLoginData(req).getUsername());
		return new Result(this.user.setUsers(user));
	}
}
