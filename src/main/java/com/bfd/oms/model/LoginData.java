package com.bfd.oms.model;

import com.bfd.oms.util.PageUtil;

/**
 * 邮箱系统调用所需的数据
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 */
public class LoginData implements java.io.Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5509887886145555823L;
	private String username;
	private String password;
	private Integer role;
	private String app_name=PageUtil.getPro().getProperty("mail_app_name");
	private Boolean	status;

	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public LoginData(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public LoginData(String username, String password, Integer role, Boolean status) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.status = status;
	}
	public Object clone() {   
        try {   
            return super.clone();   
        } catch (CloneNotSupportedException e) {   
            return null;   
        }   
    }  
}
