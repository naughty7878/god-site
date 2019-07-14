package com.god.web.zeus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.god.common.bean.BaseInput;
import com.god.common.bean.BaseOutput;
import com.god.model.zeus.vo.LoginUserVo;
import com.god.service.zeus.LoginService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 界面-登录界面
	 * @return
	 */
	@RequestMapping(value="/toLogin")
	public String toLogin(){
		 return "login";
	}
	
	/**
	 * 获取验证码
	 * @param req
	 * @param resp
	 */
	@RequestMapping(value="/getVerifyCode")
	public void getVerifyCode(HttpServletRequest req, HttpServletResponse resp){
	
		 loginService.getVerifyCode(req, resp);
	}
	

	/**
	 * 登录
	 * @param input
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput doLogin(@RequestBody BaseInput<LoginUserVo> input, HttpServletRequest req){
	
		 return loginService.doLogin(input, req);
	}
	
	
	/**
	 * 退出登录
	 * @param input
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/doLogout", method=RequestMethod.POST)
	@ResponseBody
	public BaseOutput doLogout(HttpServletRequest req){
	
		 return loginService.doLogout(req);
	}
}
