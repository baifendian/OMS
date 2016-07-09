package com.bfd.oms.service;

import java.util.Map;

import com.bfd.oms.model.Vehicle;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface IVehicleService {
    int deleteByPrimaryKey(Integer vehicleId);

    int insert(Vehicle record);

    int insertSelective(Vehicle record);

    Vehicle selectByPrimaryKey(Integer vehicleId);

    int updateByPrimaryKeySelective(Vehicle record);

    int updateByPrimaryKey(Vehicle record);
    
    PageList<Vehicle> PageQuery(Map<String,Object> map);
    
    public void batchSave(Vehicle[] record);
}