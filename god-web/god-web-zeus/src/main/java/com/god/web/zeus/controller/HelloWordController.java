package com.god.web.zeus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.god.common.constant.ResponseCode;
import com.god.web.zeus.exception.CustomException;

/**
 * 
 * @author H__D
 * @date 2018-12-07 00:46:57
 *
 */
@Controller
@RequestMapping("/helloWorld")
public class HelloWordController {

	@RequestMapping(value = "/get")
	@ResponseBody
	public String get(HttpServletRequest request) {

		return "你好：get";
	}

	@RequestMapping(value = "/post")
	@ResponseBody
	public String post(HttpServletRequest request) {
		System.out.println(1 / 0);
		return "你好：post";
	}

	@RequestMapping(value = "/exception")
	@ResponseBody
	public String exception(HttpServletRequest request) {

		try {
			if (request != null) {
				throw new CustomException("测试自定义异常");
			}
			System.out.println(1 / 0);
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return "你好：post";
	}

}
