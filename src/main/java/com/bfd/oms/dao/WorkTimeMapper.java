package com.bfd.oms.dao;

import java.util.List;
import java.util.Map;
import com.bfd.oms.model.WorkTime;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface WorkTimeMapper {
	int deleteByPrimaryKey(Long worktimeId);

	int insert(WorkTime record);


	/**
	 * 通过id查询用户的加班信息（审批中心  审核）
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：WorkTime
	 */
	WorkTime selectByPrimaryKey(Integer worktimeId);

	/**
	 * 审批同意 更新状态
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：boolean
	 */
	boolean updateByPrimaryKeySelective(WorkTime worktimeId);


	boolean updateByPrimaryKey(WorkTime worktimeId);

	/**
	 * 查询所有用户的加班信息（审批中心 列表）
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：PageList<WorkTime>
	 */
	PageList<WorkTime> PageQuery(Map<String, Object> map);

	/**
	 * 总加班小时
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Map<String,Object>
	 */
	Map<String, Object> totalDay(Map<String, Object> map);

	/**
	 * 可调休小时数
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Map<String,Object>
	 */
	Map<String, Object> restDay(Map<String, Object> map);

	/**
	 * 被拆分过的可调休小时数
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Map<String,Object>
	 */
	Map<String, Object> surplusDay(Map<String, Object> map);

	/**
	 * 即将过期的小时数
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Map<String,Object>
	 */
	Map<String, Object> WillExpire(Map<String, Object> map);

	/**
	 * 已调休使用过的小时数
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Map<String,Object>
	 */
	Map<String, Object> useHoliday(Map<String, Object> map);

	/**
	 * 正在调休的小时数
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：Map<String,Object>
	 */
	Map<String, Object> holidaing(Map<String, Object> map);

	/**
	 * 员工中心 列表
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：List<Map<String,Object>>
	 */
	List<Map<String, Object>> PageEmployeeCenter(Map<String, Object> map);

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
	boolean insertSelective(WorkTime work);
	
	/**
	 * 获取可以调休的工时
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：List<WorkTime>
	 */
	List<WorkTime> getMayUsedTime(WorkTime work);

	/**
	 * 批量更新worktimeRelationid
	 * @author：wujun
	 * @email: jun.wu@baifendian.com
	 * @return_type：void
	 */
	void updataList(List<WorkTime> updateList);
}