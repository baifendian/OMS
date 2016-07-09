package com.bfd.oms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bfd.oms.dao.MailMapper;
import com.bfd.oms.dao.WorkTimeMapper;
import com.bfd.oms.dao.WorktimeRelationMapper;
import com.bfd.oms.model.WorkTime;
import com.bfd.oms.model.WorktimeRelation;
import com.bfd.oms.service.IMailService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
public class MailServiceImpl implements IMailService{

	@Autowired
	MailMapper mailMapper;
	
	@Autowired
	WorkTimeMapper worktimeMapper;
	
	@Autowired
	WorktimeRelationMapper worktimeRelationMapper;

	@Override
	public PageList<WorkTime> PageQuery(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean agree(WorkTime workTime) {
		workTime.getMailwithblobs().setContents(workTime.getMailwithblobs().getContent());
		workTime.getMailwithblobs().setContent(workTime.getMailwithblobs().getApproveContent());
		mailMapper.insertSelective(workTime.getMailwithblobs());
		workTime.setApproveMailId(workTime.getMailwithblobs().getMailId());
	 	boolean flag=false;
	 	
	 	//当为调休申请&&审批通过时
	 	// audit_status  0:申请中，1：审批通过，2：审批拒绝
	 	// type 工时类型0：加班；1：年假；2：调休；3：销假;
	 	
	 	if("1".equals(workTime.getAuditStatus())&&workTime.getType().equals(2)){
		 	//可以调休的工时
		 	List<WorkTime> workList = worktimeMapper.getMayUsedTime(workTime);
		 	
	 		int checkTotal=0;
	 		//要调休的时间
	 		int mustUse=workTime.getTotal();
	 		//登录人获取
	 		String loginName=workTime.getAuditName();
	 		List<WorkTime> mayUseList=new ArrayList<>();
	 		List<WorktimeRelation> relations=new ArrayList<>();
	 		String uuidRleation=UUID.randomUUID().toString().replaceAll("-", "");
	 		Date date=new Date();
	 		for (int i = 0; i <workList.size(); i++) {
	 			WorkTime work=workList.get(i);
	 			int total=work.getTotal();
	 			
	 			if(checkTotal<mustUse){
	 				checkTotal+=total;
	 				mayUseList.add(work);
	 				WorktimeRelation worktimeRelation=new WorktimeRelation();
	 				worktimeRelation.setCreateTime(date);
	 				worktimeRelation.setStatus(1);
	 				worktimeRelation.setCreateUser(loginName);
	 				worktimeRelation.setRelationId(uuidRleation);
	 				worktimeRelation.setType(0);
	 				worktimeRelation.setWorktimeId(work.getWorktimeId());
	 				relations.add(worktimeRelation);
	 			}else{
	 				break;
	 			}
			}
	 		//向workRelation表添加数据
			worktimeRelationMapper.insertBatch(relations);
			
			
	 		int mayLen=mayUseList.size();
	 		List<WorkTime> updateList=new ArrayList<>();
	 		
	 		for (int i = 0; i < mayLen; i++) {
	 			WorkTime mayUsedWork=mayUseList.get(i);
	 			
	 			
	 			//最后一条 是可能会截取的数据
				if(i<mayLen-1){
					//添加到待更新的list
					bindUpdateWork(updateList, mayUsedWork,loginName);
				}else{
					//待调休的加班数据的 大于 调休时间
					if(checkTotal>mustUse){
						//待截取的时间
						int subNum=checkTotal-mustUse;
						WorkTime  updateWork=new WorkTime();
						updateWork.setWorktimeId(mayUsedWork.getWorktimeId());
						updateWork.setIsusedcompletely(1);
						updateWork.setSurplusTotal(subNum);
						Date dateEnd=mayUsedWork.getWorktimeEnd();
						updateWork.setSurplusTimeEnd(dateEnd);
						long timeLong=dateEnd.getTime()-subNum*60*60*1000L;
						updateWork.setSurplusTimeBegin(new Date(timeLong));
						updateWork.setUpdateTime(new Date());
						//
						updateWork.setUpdateUser(workTime.getUserName());
						//添加到待更新的list
						updateList.add(updateWork);
					}else{
						//添加到待更新的list
						bindUpdateWork(updateList, mayUsedWork,loginName);
					}
				}
	 			
			}
	 		//更新被调休的加班数据
	 		worktimeMapper.updataList(updateList);
	 		//更新审核状态和 relationid
	 		workTime.setWorktimeRelationId(uuidRleation);
	 		flag=worktimeMapper.updateByPrimaryKeySelective(workTime);
	 		
	    //当审批通过并且是加班的数据
	 	}else if("1".equals(workTime.getAuditStatus())&&workTime.getType().equals(0)){
	 		flag=worktimeMapper.updateByPrimaryKeySelective(workTime);
	 	}
	 	else if("2".equals(workTime.getAuditStatus())){
	 		//更新审核状态
	 		flag=worktimeMapper.updateByPrimaryKeySelective(workTime);
	 	}
 	 
		return flag;
	}

	private void bindUpdateWork(List<WorkTime> updateList, WorkTime mayUsedWork,String name) {
		//isUsedCompletely 》2
		WorkTime  updateWork=new WorkTime();
		updateWork.setWorktimeId(mayUsedWork.getWorktimeId());
		updateWork.setIsusedcompletely(2);
		updateWork.setUpdateTime(new Date());
		//
		updateWork.setUpdateUser(name);
		updateList.add(updateWork);
	}
	
	 
	 

}
