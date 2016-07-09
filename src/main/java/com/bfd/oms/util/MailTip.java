package com.bfd.oms.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bfd.oms.model.WorkTime;
import com.bfd.oms.service.IWorkTimeService;

/**
 * 邮件提醒工具类
 * 
 * @author 余明溢
 * @mail mingyi.yu@baifendian.com
 *
 */
@Service
public class MailTip {
	@Autowired
	private IWorkTimeService	workTimeService;

	private Dom4JUtil			dom4jUtil	= null;
	private String				mailTipHost="";
	private String				mailTipPort=null;
	private String				mailUserName="";
	private String				mailUserPwd="";
	private String              mailTipSubject="";

	public MailTip() {
		// 初始化dom4j工具类
		dom4jUtil = new Dom4JUtil();
		//邮箱服务器
		mailTipHost=PageUtil.props.getProperty("mail_tip_host");
		//端口
		mailTipPort=PageUtil.props.getProperty("mail_tip_port");
		//发邮件用户
		mailUserName=PageUtil.props.getProperty("mail_user_name");
		//发邮件用户密码
		mailUserPwd=PageUtil.props.getProperty("mail_user_pwd");
		//发邮件主体
		mailTipSubject=PageUtil.props.getProperty("mail_tip_subject");
	}

	public void run() {
		
		// 获取数据
		List<WorkTime> list = workTimeService.getMailTip();
		// 根据用户名包装数据
		Map<String, List<WorkTime>> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			WorkTime workTime = list.get(i);
			String name = workTime.getUserName();
			if (!map.containsKey(name)) {
				map.put(name, new ArrayList<WorkTime>(Arrays.asList(workTime)));
			}
			else {
				map.get(name).add(workTime);
			}
		}
		// 根据用户名 发送提醒邮件
		for (String name : map.keySet()) {
			List<WorkTime> li = map.get(name);
			List<Element> listEl = new ArrayList<>();
			// 循环此用户的提示数据
			for (int i = 0; i < li.size(); i++) {
				List<String> workArr = new ArrayList<>();
				WorkTime workTime = li.get(i);
				// 绑定数据
				bingData(workTime, workArr);
				// 存储绑定的数据 tr
				listEl.add(getTempSuffix(workArr.toArray()));
			}
			// 获取邮件发送内容
			String content = getSendContent(listEl, name);
			// 发送邮件
			sendMail(content, name);
		}

	}

	/**
	 * 清除 以前的tr
	 * 
	 * @param el
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	@SuppressWarnings("unchecked")
	public void clearMain(Element el) {
		for (Iterator<Element> i = el.elementIterator(); i.hasNext();) {
			Element elc = (Element) i.next();
			String idStr = elc.attributeValue("id");
			if (!"th".equals(idStr)) {
				el.remove(elc);
			}

		}
	}

	/**
	 * 发送邮件
	 * 
	 * @param content
	 *            内容
	 * @param user
	 *            收件人
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	public void sendMail(String content, String user) {
		// 发送邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost(mailTipHost);
		mailInfo.setMailServerPort(mailTipPort);
		mailInfo.setValidate(true);
		mailInfo.setUserName(mailUserName);
		mailInfo.setPassword(mailUserPwd);// 您的邮箱密码
		mailInfo.setFromAddress(mailUserName);
		String[] to = { user };
		mailInfo.setToAddress(to);
		mailInfo.setSubject(mailTipSubject); // 邮件标题
		mailInfo.setContent(content); // 邮件主体
		MailSender.sendHtmlMail(mailInfo);

	}

	/**
	 * 获取邮件发送内容
	 * 
	 * @param listEl
	 * @param name
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	private String getSendContent(List<Element> listEl, String name) {
		// 获取前缀 main
		Element elMain = getTempPrefix(name);
		// 获取mailTemp.xml 的tab
		Element el = dom4jUtil.getEleById(elMain, "tab");
		// 清除 以前的tr
		clearMain(el);
		// 添加tr
		dom4jUtil.addElement(el, listEl);
		// 获取 邮件发送内容
		String content = elMain.asXML();
		return content;
	}

	// 数据绑定
	private void bingData(WorkTime workTime, List<String> workArr) {
		// 获取前缀内
		if (workTime.getIsusedcompletely() == 0) {
			Date timeBegin=workTime.getWorktimeBegin();
			workArr.add(DateUtil.getFormatDate(timeBegin));
			Date timeEnd=workTime.getWorktimeEnd();
			workArr.add(DateUtil.getFormatDate(timeEnd));
			workArr.add("未调休过");
			workArr.add(workTime.getTotal().toString());

		}
		else if (workTime.getIsusedcompletely() == 1) {
			Date surplusTimeBegin=workTime.getSurplusTimeBegin();
			workArr.add(DateUtil.getFormatDate(surplusTimeBegin));
			Date surplusTimeEnd=workTime.getSurplusTimeEnd();
			workArr.add(DateUtil.getFormatDate(surplusTimeEnd));
			workArr.add("部分被调休过");
			workArr.add(workTime.getSurplusTotal().toString());
		}
		workArr.add(workTime.getAuditName());
	}

	/**
	 * 获取 mailTemp.xml 的tr_info 并克隆赋值
	 * 
	 * @param name
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	private Element getTempSuffix(Object[] str) {
		// 克隆tr_info
		Element trEle = (Element) dom4jUtil.getEleById(Dom4JUtil.root, "tr_info").clone();
		// 删除id
		trEle.remove(trEle.attribute("id"));
		// 赋值
		Dom4JUtil.setText(trEle, Arrays.asList(str));
		return trEle;
	}

	/**
	 * 获取 mailTemp.xml 的main 节点
	 * 
	 * @param name
	 * @return
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	private Element getTempPrefix(String name) {
		// 获取标题
		Element h1Ele = dom4jUtil.getEleById(Dom4JUtil.root, "title");
		// 获取标题内容
		String h1 = GlobalVariable.MAIL_TIP_TITLE;
		// 格式化标题内容
		Object real_h1 = String.format(h1, name);
		// 赋值
		Dom4JUtil.setText(h1Ele, Arrays.asList(real_h1));
		// 获取main
		return dom4jUtil.getEleById(Dom4JUtil.root, "main");
	}

}
