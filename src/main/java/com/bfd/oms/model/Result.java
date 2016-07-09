package com.bfd.oms.model;

/**
 * 返回前端结果集
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 */
public class Result implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1276969589030661817L;
	public int					code				= 200;
	public Object				data;
	public String				message;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}



	public Result(int code) {
		super();
		this.code = code;
	}

	public Result() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Result(int code, Object data, String message) {
		super();
		this.code = code;
		this.data = data;
		this.message = message;
	}

	public Result(Object data) {
		super();
		this.data = data;
	}

	public Result(Object data, String message) {
		super();
		this.data = data;
		this.message = message;
	}

	public Result(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	

}
