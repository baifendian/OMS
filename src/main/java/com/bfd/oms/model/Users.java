package com.bfd.oms.model;

import java.util.Date;

/**
 * 用户实体表
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 */
public class Users implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8818409698759659847L;

	private Integer	userId;

	private String	userName;

	private String	userPassword;

	private String	userNickname;

	private String	userRealname;

	private Date	regTime;

	private Date	lastLogintime;

 
    private Integer remindtime;

    private Date tobfdtime;
    
	private Boolean	status;
 
	private Integer roleId;
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword == null ? null : userPassword.trim();
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname == null ? null : userNickname.trim();
	}

	public String getUserRealname() {
		return userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname == null ? null : userRealname.trim();
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Date getLastLogintime() {
		return lastLogintime;
	}

	public void setLastLogintime(Date lastLogintime) {
		this.lastLogintime = lastLogintime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	 

	 

	public Date getTobfdtime() {
		return tobfdtime;
	}

	public void setTobfdtime(Date tobfdtime) {
		this.tobfdtime = tobfdtime;
	}

	public Integer getRemindtime() {
		return remindtime;
	}

	public void setRemindtime(Integer remindtime) {
		this.remindtime = remindtime;
	}

	public Users(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public Users( String userName, String userPassword,Boolean status) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.status = status;
		 
	}

	public Users() {
		super();
	}

	public Users(Integer userId, String userName, String userPassword, String userNickname, String userRealname, Date regTime, Date lastLogintime, Integer remindtime, Boolean status, Integer roleId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
		this.userRealname = userRealname;
		this.regTime = regTime;
		this.lastLogintime = lastLogintime;
		this.remindtime = remindtime;
		this.status = status;
		this.roleId = roleId;
	}

	public Users(Integer remindtime) {
		super();
		this.remindtime = remindtime;
	}
    
    
}