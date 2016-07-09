package com.bfd.oms.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/**
 * 身份验证器 
 * @author wujun
 */
public class AuthenticatorChild extends Authenticator{
	 private String username;  
	    private String password;  
	    public AuthenticatorChild(){  
	          
	    }  
	      
	    public AuthenticatorChild(String username, String password) {  
	        this.username = username;  
	        this.password = password;  
	    }  
	  
	    @Override  
	    protected PasswordAuthentication getPasswordAuthentication() {  
	        return new PasswordAuthentication(username, password);  
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
}
