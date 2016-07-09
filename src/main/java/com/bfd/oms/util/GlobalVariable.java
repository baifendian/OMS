package com.bfd.oms.util;

// 系统变量汇总
public class GlobalVariable {
	/**
	 * 负责授权 admin 角色
	 */
	public final static int		ROLE_ADMIN				= 1;
	/**
	 * 浏览职工加班情况 HR角色
	 */
	public final static int		ROLE_HR					= 2;
	/**
	 * 员工加班、调休、销假的申请和审核 职员角色
	 */
	public final static int		ROLE_EMPLOYEE			= 3;
	/**
	 * createUser或updateUser 变量
	 */
	public final static String	OPERATION_USER_DEFAULT	= "sys";
	/**
	 * 登录人session标识符获取
	 */
	public final static String	LOGIN_SESSION_Id		= "user_login_user";
	/**
	 * 分页起始页
	 */
	public final static String	PAGE_INDEX				= "pageIndex";
	/**
	 * 分页共多少页
	 */
	public final static String	PAGE_SIZE				= "pageSize";
	/**
	 * 分页结果集
	 */
	public final static String	PAGE_DATA				= "data";
	/**
	 * 分页总条数
	 */
	public final static String	PAGE_TOTAL				= "total";
	/**
	 * 邮件提醒的模板
	 */
	public final static String	MAIL_TIP_TEMP_PATH		= "conf/mailTemp.xml";
	/**
	 * 获取全公司邮箱的CACHE
	 */
	public final static String	MAIL_DETAIL_CACHE		= "mail";
	/**
	 * 邮件提醒的标题
	 */
	public final static String	MAIL_TIP_TITLE			= "%s以下你的加班工时调休即将过期，请注意及时调休!!!";
	/**
	 * 系统登录的URL
	 */
	public final static String	SYS_LOGIN_URL			= "login";
	/**
	 * 系统会话超时的URL
	 */
	public final static String	SYS_LOGIN_EXPIRED		= "loginexpired";

}
