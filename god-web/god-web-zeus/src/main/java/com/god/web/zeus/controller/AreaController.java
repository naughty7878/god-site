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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "行政区域接口") 
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
	@ApiOperation("根据行政区域编码，获取行政区域接口")
	@RequestMapping(value = "/getAreaByCode", method = RequestMethod.POST)
	public BaseOutput<Area> getAreaByCode(@RequestBody BaseInput<Area> input){
		Area area = areaService.selectByCode(input.getData().getCode());
		return BaseOutput.OK(area);
	}
	
	/**
	 * 根据行政区域条件，获取行政区域
	 * @param input
	 * @return
	 */
	@ApiOperation("根据行政区域条件，获取行政区域接口")
	@RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
	public BaseOutput<List<Area>> selectByExample(@RequestBody BaseInput<Area> input){
		List<Area> list = areaService.selectByExample(input.getData());
		return BaseOutput.OK(list);
	}

}
