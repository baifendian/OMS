package com.bfd.oms.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bfd.oms.model.Result;
import com.bfd.oms.model.Vehicle;
import com.bfd.oms.service.IVehicleService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Controller
@RequestMapping("Vehicle")
public class VehicleController extends BaseController {

	@Autowired
	IVehicleService vehicleService;

	@RequestMapping("/show")
	public Vehicle show(@RequestParam(value = "id", required = true) Integer id) {
		return vehicleService.selectByPrimaryKey(id);
	}

	@RequestMapping("/all")
	@ResponseBody
	public Object all(HttpServletRequest request) {
		Map<String, Object> map = getParameterMap(request);
		PageList<?> pageList = vehicleService.PageQuery(map);
		return createPageInfo(pageList, request);
	}

	@SuppressWarnings("unused")
	@RequestMapping("/save")
	public Result save(HttpServletRequest request) {
		Map<String, Object> map = getParameterMap(request);
		ObjectMapper ob = new ObjectMapper();
		Vehicle[] ls;
		try {
			if (map.get("data") != null)
				ls = ob.readValue(map.get("data").toString(), Vehicle[].class);
			Vehicle record = new Vehicle();
			record.setVehicleId(55);
			record.setVehicleNumber("赣a12");
			vehicleService.insert(record);
			return new Result(100);
		}
		catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(101, e.getMessage());
		}
		catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(101, e.getMessage());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(101, e.getMessage());
		}

	}
}
