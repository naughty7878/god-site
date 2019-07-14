package com.god.service.zeus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.god.common.bean.BaseInput;
import com.god.common.bean.BaseOutput;
import com.god.model.zeus.vo.LoginUserVo;

public interface LoginService {

	/**
	 * 获取-验证码
	 * @param resp 
	 * @param req 
	 */
	void getVerifyCode(HttpServletRequest req, HttpServletResponse resp);
	
	/**
	 * 验证-验证码是否正确
	 * @param req
	 * @param resp
	 */
	void checkVerifyCode(HttpServletRequest req, HttpServletResponse resp);

	/**
	 * 进行登录
	 * @param input
	 * @return
	 */
	BaseOutput doLogin(BaseInput<LoginUserVo> input, HttpServletRequest req);

	/**
	 * 退出登录
	 * @param req
	 * @return
	 */
	BaseOutput doLogout(HttpServletRequest req);

}
