package com.god.web.zeus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.god.common.bean.BaseInput;
import com.god.common.bean.BaseOutput;
import com.god.common.bean.PageResult;
import com.god.model.zeus.bo.GodRoleBo;
import com.god.model.zeus.entity.GodRole;
import com.god.model.zeus.entity.GodUser;
import com.god.service.zeus.GodRoleService;
import com.god.service.zeus.GodUserService;

@Controller
@RequestMapping(value = "/role", method=RequestMethod.POST)
public class GodRoleController {
	
	@Autowired
	private GodRoleService rodRoleService;
	
	@RequestMapping(value="/toList", method=RequestMethod.GET)
	public ModelAndView toList(){
		
		ModelAndView modelAndView = new ModelAndView("role/role-list");
		return modelAndView;
	}
	
	@RequestMapping(value="/toAdd", method=RequestMethod.GET)
	public ModelAndView toAdd(){
		
		ModelAndView modelAndView = new ModelAndView("role/role-add");
		return modelAndView;
	}
	
	@RequestMapping(value="/toUpdate/{roleId}", method=RequestMethod.GET)
	public ModelAndView toUpdate(@PathVariable("roleId") Long roleId){
		
		ModelAndView modelAndView = new ModelAndView("role/role-update");
		modelAndView.addObject("godRole", rodRoleService.getGodRoleById(roleId));
		return modelAndView;
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput add(@RequestBody BaseInput<GodRoleBo> input){
		
		int addStatus = rodRoleService.add(input.getData());
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
	public BaseOutput<PageResult<GodRole>> pageList(@RequestBody BaseInput<GodRoleBo> input){
		
		PageResult<GodRole> pageResult = rodRoleService.pageList(input.getData());
		
		return BaseOutput.OK(pageResult);
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput update(@RequestBody BaseInput<GodRoleBo> input){
		
		int n = rodRoleService.update(input.getData());
		if(n == 1) {
			return BaseOutput.OK("更新成功");
		}
		return BaseOutput.ERROR(500,"更新失败");
	}
	
	/**
	 * 查询可用的角色
	 * @param input
	 * @return
	 */
	@RequestMapping(value="/availableList", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput<List<GodRole>> availableList(){
		
		List<GodRole> list = rodRoleService.availableList();
		
		return BaseOutput.OK(list);
	}
}
