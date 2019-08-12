package com.god.web.zeus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.god.common.annotation.AuthValidate;
import com.god.common.bean.BaseInput;
import com.god.common.bean.BaseOutput;
import com.god.common.bean.PageResult;
import com.god.common.bean.TreeEntity;
import com.god.model.zeus.bo.GodResourceBo;
import com.god.model.zeus.entity.GodResource;
import com.god.service.zeus.GodResourceService;

@Controller
@RequestMapping(value = "/resource", method=RequestMethod.POST)
public class GodResourceController {
	
	@Autowired
	private GodResourceService rodResourceService;
	
	@AuthValidate(value="/resource/toList")
	@RequestMapping(value="/toList", method=RequestMethod.GET)
	public ModelAndView toList(){
		
		ModelAndView modelAndView = new ModelAndView("resource/resource-list");
		return modelAndView;
	}
	
	@RequestMapping(value="/toAdd", method=RequestMethod.GET)
	public ModelAndView toAdd(){
		
		ModelAndView modelAndView = new ModelAndView("resource/resource-add");
		return modelAndView;
	}
	
	@RequestMapping(value="/toUpdate/{resourceId}", method=RequestMethod.GET)
	public ModelAndView toUpdate(@PathVariable("resourceId") Long resourceId){
		
		ModelAndView modelAndView = new ModelAndView("resource/resource-update");
		modelAndView.addObject("godResource", rodResourceService.getGodResourceById(resourceId));
		return modelAndView;
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput add(@RequestBody BaseInput<GodResourceBo> input){
		
		int addStatus = rodResourceService.add(input.getData());
		if(addStatus == 1) {
			return BaseOutput.OK("新增成功");
		}
		return BaseOutput.ERROR(500,"新增失败");
	}
	
	/**
	 * 分页搜索
	 * @param input
	 * @return
	 */
	@RequestMapping(value="/pageList", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput<PageResult<GodResource>> pageList(@RequestBody BaseInput<GodResourceBo> input){
		
		PageResult<GodResource> pageResult = rodResourceService.pageList(input.getData());
		
		return BaseOutput.OK(pageResult);
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput update(@RequestBody BaseInput<GodResourceBo> input){
		
		int n = rodResourceService.update(input.getData());
		if(n == 1) {
			return BaseOutput.OK("更新成功");
		}
		return BaseOutput.ERROR(500,"更新失败");
	}
	
	/**
	 * 查询可用的资源Tree
	 * @param input
	 * @return
	 */
	@RequestMapping(value="/getAvailableTreeList", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput<List<TreeEntity>> getAvailableTreeList(){
		
		List<TreeEntity> list = rodResourceService.getAvailableTreeList();
		
		return BaseOutput.OK(list);
	}
	
	/**
	 * 查询可用的资源Tree
	 * @param input
	 * @return
	 */
	@RequestMapping(value="/selectByRoleId", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput<List<GodResource>> selectByRoleId(@RequestBody BaseInput<GodResourceBo> input){
		
		List<GodResource> list = rodResourceService.selectByRoleId(input.getData().getRoleId());
		
		return BaseOutput.OK(list);
	}
}
