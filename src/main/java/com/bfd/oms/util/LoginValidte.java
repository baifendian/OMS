package com.bfd.oms.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;
import com.bfd.oms.model.MailAddress;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 邮件系统调用
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 *
 */
@Service
public class LoginValidte {

	// 登录接口验证URL
	private static String				MAIL_VAILDATE_URL;

	private static String				MAIL_ADDRESS_GET_URL;
	// 登录接口app_name
	private static String				APP_NAME;
	private static CloseableHttpClient	client;
	/** Logger available to subclasses */
	protected final static Log			logger	= LogFactory.getLog(LoginValidte.class);
	private static Scanner				sc;
	static {
		MAIL_VAILDATE_URL = PageUtil.getPro().getProperty("mailSys_validate_ip");
		MAIL_ADDRESS_GET_URL = PageUtil.getPro().getProperty("mailSys_getMail_ip");
		APP_NAME = PageUtil.getPro().getProperty("mail_app_name");
		client = HttpClients.createDefault();
	}

	/**
	 * 验证用户登录
	 * 
	 * @param username
	 *            邮箱
	 * @param password
	 *            密码
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public static String postData(String username, String password) {
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(MAIL_VAILDATE_URL);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("username", username));
			nvps.add(new BasicNameValuePair("password", password));
			nvps.add(new BasicNameValuePair("app_name", APP_NAME));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			response = client.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) { // 成功\
				HttpEntity entity = response.getEntity();
				sc = new Scanner(entity.getContent());
				StringBuffer buffer = new StringBuffer();
				while (sc.hasNext()) {
					buffer.append(sc.nextLine());
				}
				return buffer.toString();
			}
			return null;

		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
		finally {
			if (response != null) {
				try {
					response.close();
				}
				catch (IOException e) {
					logger.error(e.getMessage());
					return null;
				}
			}
		}
	}

	/**
	 * 获取公司所有人的邮箱
	 * 
	 * @return
	 * 
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public static Object getMail() {
		CloseableHttpResponse response = null;
		try {
			HttpPost httpPost = new HttpPost(MAIL_ADDRESS_GET_URL);
			response = client.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) { // 成功\
				HttpEntity entity = response.getEntity();
				sc = new Scanner(entity.getContent());
				StringBuffer buffer = new StringBuffer();
				while (sc.hasNext()) {
					buffer.append(sc.nextLine());
				}
				String Json=buffer.toString();
				return convertToJson(Json);
			}
			return null;

		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
		finally {
			if (response != null) {
				try {
					response.close();
				}
				catch (IOException e) {
					logger.error(e.getMessage());
					return null;
				}
			}
		}
	}
	
	/**
	 *  转换数据
	 * @param json
	 * @return
	 * 
	 * 
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public static Object convertToJson(String json){
		ObjectMapper ob = new ObjectMapper();
		
		List<?> mailList=new ArrayList<>();
		List<MailAddress> list=new ArrayList<>();
		try {
			mailList=ob.readValue(json,mailList.getClass());
			for (int i = 0; i < mailList.size(); i++) {
				String mail=(String) mailList.get(i);
				String name=mail.substring(0, mail.indexOf("@"));
				list.add(new MailAddress(name,mail));
			}
			return list;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}
}
