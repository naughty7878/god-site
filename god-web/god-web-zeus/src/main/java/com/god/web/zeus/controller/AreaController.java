package com.god.web.zeus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.god.common.bean.BaseInput;
import com.god.common.bean.BaseOutput;
import com.god.model.base.entity.Area;
import com.god.service.base.AreaService;

@RestController
@RequestMapping(value = "/area")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	/**
	 * 根据行政区域编码，获取行政区域
	 * @param input
	 * @return
	 */
	@RequestMapping(value = "/getAreaByCode", method = RequestMethod.POST)
	public BaseOutput<Area> getAreaByCode(@RequestBody BaseInput<Area> input){
		
		return areaService.selectByCode(input.getData().getCode());
	}
	
	/**
	 * 根据行政区域条件，获取行政区域
	 * @param input
	 * @return
	 */
	@RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
	public BaseOutput<List<Area>> selectByExample(@RequestBody BaseInput<Area> input){
		
		return areaService.selectByExample(input.getData());
	}

}
