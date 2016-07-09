package com.bfd.oms.controller;

 
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bfd.oms.model.LoginData;
import com.bfd.oms.model.Result;
import com.bfd.oms.model.Roles;
import com.bfd.oms.model.UserRole;
import com.bfd.oms.service.IRolesService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping(value="/role")
public class RolesController extends BaseController{

	protected final Log				logger	= LogFactory.getLog(getClass());
	
	@Autowired
	private IRolesService roles; 
	
 
	/**
	 * 查询用户角色信息分页
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Object
	 */
	@RequestMapping(value="/PageRoles")
	@ResponseBody
	public Object PageRoles(HttpServletRequest req){
		Map<String, Object> map = getParameterMap(req);
		PageList<Roles> list = roles.PageRoles(map);
		return new Result(createPageInfo(list, req));
	}
	
	/**
	 * 根据id查询角色信息
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Object
	 */
	@RequestMapping(value="/selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest req){
		Map<String, Object> role = roles.selectByPrimaryKey(Integer.parseInt(req.getParameter("userId")));
		return new Result(role);
	}
	
	/**
	 * 查询角色表
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Object
	 */
	@RequestMapping(value="/findlist")
	@ResponseBody
	public Object findlist(HttpServletRequest req){
		List<Roles> role = roles.findlist();
		return new Result(role);
	}
	
	/**
	 * 设置用户的角色
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Object
	 */
	@RequestMapping(value="/setUserRole")
	@ResponseBody
	public Object setUserRole(HttpServletRequest req,
			@RequestParam(value="userId")Integer userId ,
			@RequestParam(value="roleId")Integer roleId){
		LoginData loginData =getLoginData(req);
		UserRole userrole=new UserRole();
		userrole.setUserId(userId);
		userrole.setRoleId(roleId);
		userrole.setUpdateUser(loginData.getUsername());
		userrole.setUpdateTime(new Date());
		boolean flag = roles.setUserRole(userrole);
		logger.info("设置用户的角色:"+flag);
		return new Result(flag);
	}
	
}
