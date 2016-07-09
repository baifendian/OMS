package com.bfd.oms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfd.oms.dao.MailMapper;
import com.bfd.oms.dao.WorkTimeMapper;
import com.bfd.oms.model.MailWithBLOBs;
import com.bfd.oms.model.WorkTime;
import com.bfd.oms.service.IWorkTimeService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
public class WorkTimeServiceImpl implements IWorkTimeService{

	@Autowired
	WorkTimeMapper worktimeMapper;
	
	@Autowired
	MailMapper mailMapper;
	
	@Override
	public PageList<WorkTime> PageQuery(Map<String, Object> map) {
		return worktimeMapper.PageQuery(map);
	}


	@Override
	public WorkTime selectByPrimaryKey(Integer worktimeId) {
		return worktimeMapper.selectByPrimaryKey(worktimeId);
	}


	@Override
	public Map<String, Object> totalDay(Map<String, Object> map) {
		return worktimeMapper.totalDay(map);
	}


	@Override
	public Map<String, Object> restDay(Map<String, Object> map) {
		return worktimeMapper.restDay(map);
	}


	@Override
	public Map<String, Object> surplusDay(Map<String, Object> map) {
		return worktimeMapper.surplusDay(map);
	}


	@Override
	public Map<String, Object> WillExpire(Map<String, Object> map) {
		return worktimeMapper.WillExpire(map);
	}


	@Override
	public Map<String, Object> useHoliday(Map<String, Object> map) {
		return worktimeMapper.useHoliday(map);
	}


	@Override
	public Map<String, Object> holidaing(Map<String, Object> map) {
		return worktimeMapper.holidaing(map);
	}


	@Override
	public List<Map<String, Object>> PageEmployeeCenter(Map<String, Object> map) {
		return worktimeMapper.PageEmployeeCenter(map);
	}


	@Override
	public List<WorkTime> getMailTip() {
		return worktimeMapper.getMailTip();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean OverTimeOrFalls(WorkTime work) {
		mailMapper.insertSelective(work.getMailwithblobs());
		work.setMailId(work.getMailwithblobs().getMailId());
		work.getMailwithblobs().setContents(work.getMailwithblobs().getContent());
		work.setIsusedcompletely(0);
		boolean b = worktimeMapper.insertSelective(work);
		return b;
	}


	 

	 

}
