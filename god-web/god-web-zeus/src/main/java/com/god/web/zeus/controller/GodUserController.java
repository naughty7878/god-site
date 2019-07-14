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
import com.god.model.base.bo.GodUserBo;
import com.god.model.zeus.entity.GodUser;
import com.god.service.zeus.GodUserService;

@Controller
@RequestMapping(value = {
        "/user",
        "/admin"}, method=RequestMethod.POST)
public class GodUserController {
	
	@Autowired
	private GodUserService userService;
	
	@RequestMapping(value="/toAdd", method=RequestMethod.GET)
	public ModelAndView toAdd(){
		
		ModelAndView modelAndView = new ModelAndView("admin/admin-add");
		return modelAndView;
	}
	
	@RequestMapping(value="/toUpdate/{userId}", method=RequestMethod.GET)
	public ModelAndView toUpdate(@PathVariable("userId") Integer userId){
		
		ModelAndView modelAndView = new ModelAndView("admin/admin-update");
		modelAndView.addObject("godUser", userService.getGodUserById(userId));
		return modelAndView;
	}
	
	@RequestMapping(value="/toList", method=RequestMethod.GET)
	public ModelAndView toList(){
		
		ModelAndView modelAndView = new ModelAndView("admin/admin-list");
		return modelAndView;
	}
	
	@RequestMapping(value="/pageList", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput<PageResult<GodUser>> pageList(@RequestBody BaseInput<GodUserBo> input){
		
		PageResult<GodUser> pageResult = userService.pageList(input.getData());
		
		return BaseOutput.OK(pageResult);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput update(@RequestBody BaseInput<GodUserBo> input){
		
		userService.update(input.getData());
		return BaseOutput.OK("更新成功");
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput add(@RequestBody BaseInput<GodUserBo> input){
		
		int addStatus = userService.add(input.getData());
		if(addStatus == 1) {
			return BaseOutput.OK("新增成功");
		}
		return BaseOutput.ERROR(500,"新增失败");
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	@ResponseBody
	public List<GodUser> searchUserList(){
		return userService.searchUserList();
	}

}
