package com.bfd.oms.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bfd.oms.model.Vehicle;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Repository
public interface VehicleMapper {
    int deleteByPrimaryKey(Integer vehicleId);

    int insert(Vehicle record);

    int insertSelective(Vehicle record);

    Vehicle selectByPrimaryKey(Integer vehicleId);

    int updateByPrimaryKeySelective(Vehicle record);

    int updateByPrimaryKey(Vehicle record);
    
    public void batchSave(Vehicle[] record);
  
	PageList<Vehicle> PageQuery(Map<String,Object> map);
}