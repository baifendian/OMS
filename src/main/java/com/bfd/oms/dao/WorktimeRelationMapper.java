package com.bfd.oms.dao;

import java.util.List;

import com.bfd.oms.model.WorkTime;
import com.bfd.oms.model.WorktimeRelation;

public interface WorktimeRelationMapper {
    int insert(WorktimeRelation record);

    int insertSelective(WorktimeRelation record);

	void insertBatch(List<WorktimeRelation> mayUseList);
}