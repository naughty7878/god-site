package com.god.web.zeus.controller;

import java.net.UnknownHostException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.god.service.base.BaseSysService;

/**
 * Controller层： 
 * 		public List<UserVO> getUsers(UserDTO userDto); 
 * Service层：
 * 		List<UserDTO> getUsers(UserDTO userDto); 
 * DAO层： 
 * 		List<UserDTO> getUsers(UserDO userDo);
 * 
 * @author H__D
 * @date 2019-07-04 00:21:09
 *
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@Autowired
	private BaseSysService baseSysService;

	/**
	 * 界面-首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	/**
	 * 界面-欢迎界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/welcome")
	public ModelAndView welcome() {		
		ModelAndView view = new ModelAndView("welcome");
		try {
			Map<String, Object> sysProperty = baseSysService.getSysProperty();
			view.addAllObjects(sysProperty);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return view;	
	}
}
