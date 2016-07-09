package com.bfd.oms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.bfd.oms.model.Result;
import com.bfd.oms.util.CacheHelper;
import com.bfd.oms.util.GlobalVariable;

@Controller
public class HomeController extends BaseController {

	private final Log logger = LogFactory.getLog(getClass());

	/**
	 * 网页没有找到
	 * 
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 * @return
	 */
	@RequestMapping(value = "404")
	@ResponseBody
	public Object validateUrl() {
		logger.info("网页没有找到");
		return new Result(404, "网页没有找到");
	}

	/**
	 * 拒绝访问 （没有访问权限）
	 * 
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 * @return
	 */
	@RequestMapping(value = "405")
	@ResponseBody
	public Object validatePermissions(HttpServletRequest req, HttpServletResponse resp) {
		logger.info("没有访问权限或者会话过期");
		return new Result(405, "没有访问权限或者会话过期");

	}

	/**
	 * 系统内部出错
	 * 
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 * @return
	 */
	@RequestMapping(value = "500")
	@ResponseBody
	public Object validateInnerError() {
		logger.info("系统内部错误");
		return new Result(500,"系统内部错误");
	}

	/**
	 * 登录成功
	 * 
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 * @return
	 */
	@RequestMapping(value = "/loginSuccess")
	@ResponseBody
	public Object toHome(HttpServletRequest req, HttpServletResponse resp) {
		logger.info(JSON.toJSON(new Result(200, contextMap(req).get("user"), "成功")));
		return new Result(200, contextMap(req).get("user"), "成功");
	}

	/**
	 * 登录异常
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@RequestMapping(value = "loginerror")
	@ResponseBody
	public Object loginError(HttpServletRequest req) {
		req.removeAttribute("contextMap");
		if (req.getSession() != null) {
			req.getSession().removeAttribute(GlobalVariable.LOGIN_SESSION_Id);
		}
		String msg = "";
		HttpSession session = req.getSession(false);
		if (session != null) {
			AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			msg = ex != null ? ex.getMessage() : "程序君响应过长,请重试！！！";
		}
		logger.info(msg);
		return new Result(500, msg);
	}

	/**
	 * 会话重置
	 * 
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@RequestMapping(value = "loginexpired")
	@ResponseBody
	public Object loginExpired(HttpServletRequest req, HttpServletResponse resp) {
		req.removeAttribute("contextMap");
		if (req.getSession() != null) {
			req.getSession().removeAttribute(GlobalVariable.LOGIN_SESSION_Id);
		}

		logger.info("服务器与你的会话已失效，请重新登陆！");
		String referer = req.getHeader("Referer");
		// 如果是登录转发过来的 返回JSON
		/*if (referer != null && referer.length() > 0) {
			if (referer.endsWith(GlobalVariable.SYS_LOGIN_URL)) {
				OutWithJson(resp, new Result(302, "服务器与你的会话已失效，请刷新页面后重新登陆！"));
				return null;
			}
			else {
				return "index";
			}
		}
		else {
			return "index";
		}*/
		return  new Result(302, "服务器与你的会话已失效，请刷新页面后重新登陆！");

	}

	/**
	 * 登出
	 * 
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@RequestMapping(value = "logoutSuccess")
	public String logout(HttpServletRequest req) {
		req.removeAttribute("user");
		if (req.getSession() != null) {
			req.getSession().removeAttribute(GlobalVariable.LOGIN_SESSION_Id);
		}
		return "index";
	}

	/**
	 * 登录
	 * 
	 * @param req
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest req) {
		return "index";
	}

	/**
	 * 获取全公司邮箱的
	 * 
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@RequestMapping(value = "getMail")
	@ResponseBody
	public Object getMail() {
		// 获取全公司邮箱的
		Object obj_mail = CacheHelper.getValue(CacheHelper.CACHE_MAIL, GlobalVariable.MAIL_DETAIL_CACHE);
		return new Result(obj_mail);
	}
	
	/**
	 * 返回index
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@RequestMapping("/*")
	public Object index(){
		return "index";
	}
}
