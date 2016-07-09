package com.bfd.oms.service;

import java.util.List;
import java.util.Map;

import com.bfd.oms.model.MailWithBLOBs;
import com.bfd.oms.model.WorkTime;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface IWorkTimeService {
	
	/**
	 * 查询用户的基本信息
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：List<Users>
	 */
    public PageList<WorkTime> PageQuery(Map<String, Object> map) ;

	/**
	 * 通过id查用户的加班信息
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：WorkTime
	 */
	public WorkTime selectByPrimaryKey(Integer worktimeId);

	/**
	 * 个人加班多少小时总和(要加上个人可调休多少小时总和)
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：int
	 */
	public Map<String, Object> totalDay(Map<String, Object> map);
	
	/**
	 * 个人可调休多少小时总和
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：int
	 */
	public Map<String, Object> restDay(Map<String, Object> map);
	
	/**
	 * 个人拆分过的剩余小时总和
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：int
	 */
	public Map<String, Object> surplusDay(Map<String, Object> map);
	
	/**
	 * 即将过期时间的小时数
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：int
	 */
	public Map<String, Object> WillExpire(Map<String, Object> map);
	
	/**
	 * 已调休的小时总和
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：int
	 */
	public Map<String, Object> useHoliday(Map<String, Object> map);
	
	/**
	 * 正在调休中的小时总和
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：int
	 */
	public Map<String, Object> holidaing(Map<String, Object> map);
	
	/**
	 * 员工中心
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Map<String,Object>
	 */
	public List<Map<String, Object>> PageEmployeeCenter(Map<String, Object> map);
	
	
	/**
	 * 获取需要进行邮件提醒（即将过期）的加班工时
	 * 
	 * @return
	 * 
	 * @author 余明溢
	 * @mail mingyi.yu@baifendian.com
	 */
	List<WorkTime> getMailTip();

	/**
	 * 加班调休申请
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：boolean
	 */
	public boolean OverTimeOrFalls(WorkTime work);

}
