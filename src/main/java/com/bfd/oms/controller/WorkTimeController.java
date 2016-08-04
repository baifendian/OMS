package com.bfd.oms.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bfd.oms.model.LoginData;
import com.bfd.oms.model.MailWithBLOBs;
import com.bfd.oms.model.Result;
import com.bfd.oms.model.Users;
import com.bfd.oms.model.WorkTime;
import com.bfd.oms.service.IMailService;
import com.bfd.oms.service.IWorkTimeService;
import com.bfd.oms.util.DateUtil;
import com.bfd.oms.util.MailSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 
 * 工作中心
 *
 */
@Controller
@RequestMapping("/work")
public class WorkTimeController extends BaseController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private IWorkTimeService worktime;

	@Autowired
	private IMailService mail;

	/**
	 * 查询所有用户的加班信息（审批中心 列表）
	 * 
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 */
	@RequestMapping(value = "/queryAllUserWork", method = RequestMethod.GET)
	@ResponseBody
	public Object queryAllUserWork(HttpServletRequest request) {
		Map<String, Object> map = getParameterMap(request);
		map.put("auditName", getLoginData(request).getUsername());
		if (map.get("worktimeBegin") != null) {
			String begin = map.get("worktimeBegin").toString().replace("/", "-");
			map.put("worktimeBegin", DateUtil.getStringToDate(begin));
		}
		if (map.get("worktimeEnd") != null) {
			String end = map.get("worktimeEnd").toString().replace("/", "-");
			map.put("worktimeEnd", DateUtil.getStringToDate(end));
		}
		PageList<WorkTime> works = worktime.PageQuery(map);
		return new Result(createPageInfo(works, request));

	}

	/**
	 * 通过id查询用户的加班信息（审批中心 审核）
	 * 
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 */
	@RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request) {
		WorkTime works = worktime.selectByPrimaryKey(Integer.parseInt(request.getParameter("worktimeId")));
		return new Result(works);

	}

	/**
	 * 首页
	 * 
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Object
	 */
	@RequestMapping(value = "/firstPage", method = RequestMethod.GET)
	@ResponseBody
	public Object firstPage(HttpServletRequest request) {
		JSONArray json = new JSONArray();
		// 总加班小时 Json
		JSONObject totalJson = new JSONObject();
		// 可调休小时 Json
		JSONObject mayUsedJson = new JSONObject();
		// 已调休小时总和 Json
		JSONObject beUsedJson = new JSONObject();
		// 即将过期的小时总和
		JSONObject willLostJson = new JSONObject();
		// 正在调休的小时总和
		JSONObject inUseJson = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		LoginData loginData = getLoginData(request);
		map.put("userName", loginData.getUsername());

		// 总加班小时
		Map<String, Object> totalDay = worktime.totalDay(map);
		if (totalDay == null) {
			totalJson.put("key", "totalDay");
			totalJson.put("name", "");
			totalJson.put("value", 0);
		} else {
			int toDay = Tools(totalDay.get("totalDay").toString());
			totalJson.put("key", "totalDay");
			totalJson.put("name", "总加班小时");
			totalJson.put("value", toDay);
		}

		// 可调休小时
		Map<String, Object> restDay = worktime.restDay(map);
		Map<String, Object> surplusDay = worktime.surplusDay(map);
		int reDay = 0;
		int suDay = 0;
		if (restDay == null) {

		} else {
			reDay = Tools(restDay.get("restDay").toString());
		}
		if (surplusDay == null) {

		} else {
			suDay = Tools(surplusDay.get("surplusDay").toString());
		}
		mayUsedJson.put("key", "restsDay");
		mayUsedJson.put("name", "可调休小时");
		mayUsedJson.put("value", reDay + suDay);

		// 已调休小时总和
		Map<String, Object> useHoliday = worktime.useHoliday(map);
		// 即将过期的小时总和
		Map<String, Object> WillExpire = worktime.WillExpire(map);
		// 正在调休的小时总和
		Map<String, Object> holidaing = worktime.holidaing(map);
		if (null == useHoliday) {
			beUsedJson.put("key", "useHoliday");
			beUsedJson.put("name", "已调休小时总和");
			beUsedJson.put("value", 0);
		} else {
			beUsedJson.put("key", "useHoliday");
			beUsedJson.put("name", "已调休小时总和");
			beUsedJson.put("value", isNull(useHoliday.get("useHoliday")));
		}
		if (null == WillExpire) {
			willLostJson.put("key", "WillExpire");
			willLostJson.put("name", "即将过期的小时总和");
			willLostJson.put("value", 0);
		} else {
			willLostJson.put("key", "WillExpire");
			willLostJson.put("name", "即将过期的小时总和");
			willLostJson.put("value", isNull(WillExpire.get("WillExpire")));
		}
		if (null == holidaing) {
			inUseJson.put("key", "holidaing");
			inUseJson.put("name", "正在调休的小时总和");
			inUseJson.put("value", 0);
		} else {
			inUseJson.put("key", "holidaing");
			inUseJson.put("name", "正在调休的小时总和");
			inUseJson.put("value", isNull(holidaing.get("holidaing")));
		}

		json.add(totalJson);
		json.add(mayUsedJson);
		json.add(beUsedJson);
		json.add(willLostJson);
		json.add(inUseJson);

		return new Result(json);

	}

	/**
	 * firstPages
	 * 
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Object
	 */
	@RequestMapping(value = "/firstPages", method = RequestMethod.GET)
	@ResponseBody
	public Object firstPages(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		LoginData loginData = getLoginData(request);
		map.put("userName", loginData.getUsername());
		List<Map<String, Object>> work = worktime.PageEmployeeCenter(map);
		return new Result(work.get(0));
	}

	/**
	 * 审批人同意
	 * 
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Object
	 */
	@RequestMapping(value = "/agree", method = RequestMethod.POST)
	@ResponseBody
	public Object agree(HttpServletRequest request) {
		Map<String, Object> map = getParameterMap(request);
		int worktimeId = Integer.parseInt(map.get("worktimeId").toString());
		String bobsStr = map.get("mailwithblob").toString();
		ObjectMapper ob = new ObjectMapper();
		Map<String, Object> bloBs = null;
		try {
			// {"type":2,"typename":"审批","content":"我要加班加班加班","approveContent":"fadfdafda","receiveUsers":"wu.wang@baifendian.com;test@baifendian.com","copyUser":"wu.wang@baifendian.com;test@baifendian.com"}
			bloBs = ob.readValue(bobsStr, Map.class);
		} catch (Exception e) {
			logger.error(e);
		}
		Integer type = Integer.parseInt(bloBs.get("type").toString());
		String content = bloBs.get("content").toString();
		String receiveUsers = bloBs.get("receiveUsers").toString();
		String copyUser = bloBs.get("copyUser").toString();
		String approveContent = bloBs.get("approveContent").toString();
		String typename = bloBs.get("typename").toString();
		MailWithBLOBs bloB = new MailWithBLOBs(content, receiveUsers, copyUser, approveContent);
		bloB.setType(type);
		bloB.setTypename(typename);

		WorkTime work = worktime.selectByPrimaryKey(worktimeId);
		work.setTypename(typename);
		work.setAuditStatus(map.get("auditStatus").toString());
		LoginData loginData = getLoginData(request);
		work.setUpdateUser(loginData.getUsername());
		work.setAuditName(loginData.getUsername());
		work.setUpdateTime(new Date());
		work.setAuditName(loginData.getUsername());
		work.setMailwithblobs(bloB);
		work.getMailwithblobs().setCreateUser(loginData.getUsername());
		work.getMailwithblobs().setCreateTime(new Date());

		boolean flag = mail.agree(work);

		if (flag) {
			MailSender.sendMail(work, getLoginData(request).getPassword());
		}
		return new Result(flag);
	}

	/**
	 * 工时中心
	 * 
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Object
	 */
	@RequestMapping(value = "/WorkCenter")
	@ResponseBody
	public Object WorkCenter(HttpServletRequest req) {
		Map<String, Object> map = getParameterMap(req);
		map.put("userName", getLoginData(req).getUsername());
		if (map.get("worktimeBegin") != null) {
			String begin = map.get("worktimeBegin").toString().replace("/", "-");
			map.put("worktimeBegin", DateUtil.getStringToDate(begin));
		}
		if (map.get("worktimeEnd") != null) {
			String end = map.get("worktimeEnd").toString().replace("/", "-");
			map.put("worktimeEnd", DateUtil.getStringToDate(end));
		}
		PageList<WorkTime> wo = worktime.PageQuery(map);
		return new Result(createPageInfo(wo, req));
	}

	/**
	 * 工时中心查看
	 * 
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Object
	 */
	@RequestMapping(value = "/findWork")
	@ResponseBody
	public Object findWork(HttpServletRequest req) {
		WorkTime wo = worktime.selectByPrimaryKey(Integer.parseInt(req.getParameter("worktimeId")));
		return new Result(wo);
	}

	/**
	 * 加班或调休申请
	 * 
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Object
	 */
	@RequestMapping(value = "/OverTimeOrFalls", method = RequestMethod.POST)
	@ResponseBody
	public Object OverTimeOrFalls(HttpServletRequest req) {
		Map<String, Object> map = getParameterMap(req);
		WorkTime work = new WorkTime();

		work.setType(Integer.parseInt(map.get("type").toString()));
		work.setUserName(map.get("userName").toString());
		work.setAuditName(map.get("auditName").toString());
		work.setTypename(map.get("typename").toString());
		ObjectMapper ob = new ObjectMapper();
		Map<String, Object> bloBs = null;
		try {
			// {"type":2,"typename":"审批","content":"我要加班加班加班","approveContent":"fadfdafda","receiveUsers":"wu.wang@baifendian.com;test@baifendian.com","copyUser":"wu.wang@baifendian.com;test@baifendian.com"}
			bloBs = ob.readValue(map.get("mailwithblobs").toString(), Map.class);
		} catch (Exception e) {
			logger.error(e);
		}

		Integer type = Integer.parseInt(bloBs.get("type").toString());
		String content = bloBs.get("content").toString();
		String receiveUsers = bloBs.get("receiveUsers").toString();
		String copyUser = bloBs.get("copyUser").toString();
		String typename = bloBs.get("typename").toString();

		MailWithBLOBs bloB = new MailWithBLOBs(content, receiveUsers, copyUser, null);
		bloB.setType(type);
		bloB.setTypename(typename);
		work.setMailwithblobs(bloB);

		work.setWorktimeBegin(new Date(Long.parseLong(map.get("worktimeBegin").toString())));
		work.setWorktimeEnd(new Date(Long.parseLong(map.get("worktimeEnd").toString())));
		work.setTotal(Integer.parseInt(map.get("total").toString()));
		work.getMailwithblobs().setReceiveUsers(map.get("receiveUsers").toString());
		work.getMailwithblobs().setCopyUser(map.get("copyUser").toString());
		work.getMailwithblobs().setContent(map.get("content").toString());

		LoginData loginData = getLoginData(req);
		work.setCreateUser(loginData.getUsername());
		work.setUserName(loginData.getUsername());
		work.setCreateTime(new Date());
		//这个为测试数据 正式环境请将342行和343行代码注释
		work.getMailwithblobs().setReceiveUsers("mingyi.yu@baifendian.com");
		work.getMailwithblobs().setCopyUser("xinyi.zhu@baifendian.com");
		work.getMailwithblobs().setCreateUser(loginData.getUsername());
		work.getMailwithblobs().setCreateTime(new Date());

		if (work.getType().equals(2)) {
			Integer i = 0;
			Integer j = 0;
			Map<String, Object> restDay = worktime.restDay(map);
			i = ((BigDecimal) restDay.get("restDay")).intValue();
			Map<String, Object> surplusDay = worktime.surplusDay(map);
			j = ((BigDecimal) surplusDay.get("surplusDay")).intValue();

			Integer k = i + j;
			if (work.getTotal() > k) {
				return new Result(500, "您当前只能调休" + k + "小时");
			}

		}

		boolean b = worktime.OverTimeOrFalls(work);

		if (b) {
			MailSender.sendMail(work, getLoginData(request).getPassword());
		}
		return new Result(b);

	}

	/**
	 * 员工中心
	 * 
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Object
	 */
	@PreAuthorize(value = "hasRole('ROLE_VIEW_EMP')")
	@RequestMapping(value = "/PageEmployeeCenter")
	@ResponseBody
	public Object PageEmployeeCenter(HttpServletRequest req, Users user) {
		Map<String, Object> map = getParameterMap(req);
		map.put("userName", user.getUserName());
		PageList<?> list = (PageList<?>) worktime.PageEmployeeCenter(map);
		return new Result(createPageInfo(list, req));
	}

	public int Tools(String ss) {
		int dou = 0;
		if (null == ss || ss.equals("")) {

		} else {
			dou = Integer.parseInt(ss);
		}

		return dou;
	}

	public int isNull(Object ss) {
		int i = 0;
		if (null == ss || ss.equals("")) {
			return i;
		} else {
			return Integer.parseInt(ss.toString());
		}

	}

}
