package com.god.service.zeus.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.god.common.bean.BaseInput;
import com.god.common.bean.BaseOutput;
import com.god.common.constant.ResponseCode;
import com.god.common.util.IPUtils;
import com.god.common.util.MD5Utils;
import com.god.common.util.VerifyCodeUtils;
import com.god.dao.zeus.GodUserDao;
import com.god.dao.zeus.GodUserLoginLogDao;
import com.god.model.zeus.entity.GodUser;
import com.god.model.zeus.entity.GodUserLoginLog;
import com.god.model.zeus.query.GodUserExample;
import com.god.model.zeus.query.GodUserExample.Criteria;
import com.god.model.zeus.query.GodUserLoginLogExample;
import com.god.model.zeus.vo.LoginUserVo;
import com.god.service.base.BaseMapBaiduService;
import com.god.service.constant.GodUserStatusEnum;
import com.god.service.zeus.LoginService;
import com.god.service.zeus.constant.ZeusConstants;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private GodUserDao godUserDao;
	
	@Autowired
	private GodUserLoginLogDao godUserLoginLogDao;
	
	@Autowired
	private BaseMapBaiduService baseMapBaiduService;

	@Override
	public void getVerifyCode(HttpServletRequest req, HttpServletResponse resp) {
		
		resp.setHeader("Pragma", "No-cache");  
        resp.setHeader("Cache-Control", "no-cache");  
        resp.setDateHeader("Expires", 0);  
        resp.setContentType("image/jpeg");  
          
        //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        //存入会话session  
        req.getSession().setAttribute("CODE", verifyCode.toLowerCase());  
        
        //生成图片  
        int width = 100;//宽
        int height = 40;//高  
        try {
			VerifyCodeUtils.outputImage(width, height, resp.getOutputStream(), verifyCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

	@Override
	public void checkVerifyCode(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean checkVerifyCode(HttpServletRequest req, String code) {
		
        String key = (String) req.getSession().getAttribute("CODE");
        if(code != null && code.equalsIgnoreCase(key)){
            req.getSession().removeAttribute("CODE");
            return true;
        }
        return false;
	}
	
	@Override
	public BaseOutput doLogin(BaseInput<LoginUserVo> input, HttpServletRequest req) {
		
		// 登录验证次数
		Integer checkNum = (Integer) req.getSession().getAttribute(ZeusConstants.SESSION_CURRENT_LOGIN_CHECK_NUM);
		if(checkNum == null) {
			checkNum = 0;
		}
		req.getSession().setAttribute(ZeusConstants.SESSION_CURRENT_LOGIN_CHECK_NUM, ++checkNum);
		
		if(input == null || input.getData() == null) {
			
			return BaseOutput.ERROR(500, "输入参数格式错误，请输入正确格式");
		}
		LoginUserVo data = input.getData();
		String code = data.getVerifyCode();
		String username = data.getUsername();
		String password = data.getPassword();
		if(checkNum==1 || checkVerifyCode(req, code)) {
			GodUserExample userExample = new GodUserExample();
			Criteria criteria = userExample.createCriteria();
			criteria.andNameEqualTo(username);
			List<GodUser> list = godUserDao.selectByExample(userExample);
			if(list != null && list.size() > 0) {
				GodUser godUser = list.get(0);
				String md5Password = MD5Utils.getMD5ofStr(MD5Utils.getMD5ofStr(ZeusConstants.SYS_NAME + password));
				if( godUser.getPassword() != null && godUser.getPassword().equals(md5Password)) {
					if(godUser.getStatus() == GodUserStatusEnum.USER_AVAILABLE.getCode()) {
						// 登录成功
						successLoginHandle(godUser, req);
						req.getSession().setAttribute(ZeusConstants.SESSION_CURRENT_LOGIN_CHECK_NUM, 0);
						return BaseOutput.OK("登录成功！");
					}else {
						return BaseOutput.ERROR(ResponseCode.AUTHORITY_USER_UNAVAILABLE.getCode(), ResponseCode.AUTHORITY_USER_UNAVAILABLE.getMsg());
					}
				}
			}else {
				return BaseOutput.ERROR(500, "用户不存在！");
			}
		}else {
			return BaseOutput.ERROR(500, "验证码错误，请重新输入");
		}
	   return BaseOutput.ERROR(ResponseCode.AUTHORITY_USER_ERROR_PWD.getCode(), ResponseCode.AUTHORITY_USER_ERROR_PWD.getMsg());
	}
	
	/**
	 * 登录成功，处理业务
	 * @param godUser
	 * @param req
	 */
	@Transactional
	private void successLoginHandle(GodUser godUser, HttpServletRequest req) {
		
		req.getSession().setAttribute(ZeusConstants.SESSION_CURRENT_LOGIN_USER, godUser);
		
		Date currentTime = new Date();
		
		int logTimes = 0;
		// 获取最新的日志
		GodUserLoginLogExample loginLogExample = new GodUserLoginLogExample();
		loginLogExample.createCriteria().andUserIdEqualTo(godUser.getId());
		loginLogExample.setOrderByClause("create_time desc");
		List<GodUserLoginLog> logList = godUserLoginLogDao.selectByExample(loginLogExample);
		if(logList.size() > 0) {
			GodUserLoginLog godUserLoginLog = logList.get(0);
			logTimes = godUserLoginLog.getTimes();
			// 最新登录日志保持到session中
			req.getSession().setAttribute(ZeusConstants.SESSION_CURRENT_LOGIN_USER_LOG, godUserLoginLog);
		}
		
		// 记录登录日志
		GodUserLoginLog loginLog = new GodUserLoginLog();
		loginLog.setUserId(godUser.getId());
		String ip = IPUtils.getIpAddr(req);
		loginLog.setLoginIp(ip);
		String city = baseMapBaiduService.getCityByIp(ip);
		loginLog.setCity(city);
		loginLog.setTimes(logTimes + 1);
		loginLog.setCreateTime(currentTime);
		loginLog.setUpdateTime(currentTime);
		godUserLoginLogDao.insert(loginLog);
	}
	
	
	@Override
	public BaseOutput doLogout(HttpServletRequest req) {
		
		req.getSession().invalidate();
		
		return BaseOutput.OK("退出成功");
	}
	
	
	
}
