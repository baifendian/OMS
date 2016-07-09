package com.bfd.oms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfd.oms.dao.VehicleMapper;
import com.bfd.oms.model.Vehicle;
import com.bfd.oms.service.IVehicleService;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
public class VehicleServiceImpl implements IVehicleService {

	@Autowired
	VehicleMapper vehicleMapper;
	@Override
	public int deleteByPrimaryKey(Integer vehicleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Vehicle record) {
		vehicleMapper.insert(record);
		return 0;
	}

	@Override
	public int insertSelective(Vehicle record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vehicle selectByPrimaryKey(Integer vehicleId) {
		return vehicleMapper.selectByPrimaryKey(vehicleId);
	}

	@Override
	public int updateByPrimaryKeySelective(Vehicle record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Vehicle record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageList<Vehicle> PageQuery(Map<String,Object> map) {
		return vehicleMapper.PageQuery(map);
	}

	@Override
	public void batchSave(Vehicle[] record) {
		vehicleMapper.batchSave(record);
	}

}
