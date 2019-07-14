package com.god.service.zeus.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.god.common.bean.BaseInput;
import com.god.common.bean.PageResult;
import com.god.common.util.DateUtils;
import com.god.common.util.MD5Utils;
import com.god.dao.zeus.GodUserDao;
import com.god.model.base.bo.GodUserBo;
import com.god.model.zeus.entity.GodUser;
import com.god.model.zeus.query.GodUserExample;
import com.god.service.zeus.GodUserService;
import com.god.service.zeus.constant.ZeusConstants;


@Service
public class GodUserServiceImpl implements GodUserService{

	@Autowired
	private GodUserDao userDao;
	
	@Override
	public List<GodUser> searchUserList() {
		return userDao.selectByExample(null);
	}
	
	
	@Override
	public PageResult<GodUser> pageList(GodUserBo godUserBo) {
		
		String beginDate = godUserBo.getBeginDate();
		String endDate = godUserBo.getEndDate();
		String name = godUserBo.getName();
		Integer status = godUserBo.getStatus();
		
		Date begin = DateUtils.stringToDate(beginDate, DateUtils.DATE_FORMAT);
		Date end = DateUtils.stringToDate(endDate, DateUtils.DATE_FORMAT);
		
		GodUserExample userExample = new GodUserExample();
		if(begin != null && end != null) {
			userExample.createCriteria().andCreateTimeBetween(begin, end);
		}
		if(!StringUtils.isEmpty(name)) {
			userExample.createCriteria().andNameLike("%" + name + "%");
		}
		if(status != null) {
			userExample.createCriteria().andStatusEqualTo(status);
		}
		
		//获取第1页，10条内容，默认查询总数count
		Page<Object> page = PageHelper.startPage(godUserBo.getPageNum(), godUserBo.getPageSize());
		List<GodUser> userList = userDao.selectByExample(userExample);
		
		PageResult<GodUser> pageResult = new PageResult<GodUser>(userList, page.getTotal(), page.getPageNum(), page.getPageSize());
		
		return pageResult;
	}
	
	@Override
	public int update(GodUserBo godUserBo) {
		String name = godUserBo.getName();
		String password = godUserBo.getPassword();
		Integer status = godUserBo.getStatus();
		
		GodUser user = new GodUser();
		user.setId(godUserBo.getId());
		if(!StringUtils.isEmpty(name)) {
			user.setName(name);
		}
		if(status != null) {
			user.setStatus(status);
		}
		if(!StringUtils.isEmpty(password)) {
			String md5Password = MD5Utils.getMD5ofStr(MD5Utils.getMD5ofStr(ZeusConstants.SYS_NAME + password));
			user.setPassword(md5Password);
		}
		user.setUpdateTime(new Date());
		
		return userDao.updateByPrimaryKeySelective(user);
	}


	@Override
	@Transactional
	public int add(GodUserBo godUserBo) {
		
		String name = godUserBo.getName();
		String password = godUserBo.getPassword();
		Integer status = godUserBo.getStatus();
		
		// 验证
		if(StringUtils.isEmpty(name) || godUserBo.getPassword() == null) {
			return 0;
		}
		GodUserExample userExample = new GodUserExample();
		userExample.createCriteria().andNameEqualTo(name);
		List<GodUser> userList = userDao.selectByExample(userExample);
		if(userList.size() > 0) {
			return 0;
		}
		
		// 新增
		GodUser user = new GodUser();
		if(!StringUtils.isEmpty(name)) {
			user.setName(name);
			user.setNickname(name);
		}
		if(!StringUtils.isEmpty(password)) {
			String md5Password = MD5Utils.getMD5ofStr(MD5Utils.getMD5ofStr(ZeusConstants.SYS_NAME + password));
			user.setPassword(md5Password);
		}else {
			String md5Password = MD5Utils.getMD5ofStr(MD5Utils.getMD5ofStr(ZeusConstants.SYS_NAME + ZeusConstants.SYS_INIT_PASSWORD));
			user.setPassword(md5Password);
		}
		if(status != null) {
			user.setStatus(status);
		}else {
			user.setStatus(0);
		}
		Date currentTime = new Date();
		user.setCreateTime(currentTime);
		user.setUpdateTime(currentTime);
		int updateByPrimaryKeySelective = userDao.insertSelective(user);
		// System.out.println(updateByPrimaryKeySelective);
		
		return 1;
	}


	/**
	 * 根据userId获取用户
	 * @param userId
	 */
	public GodUser getGodUserById(Integer userId) {
		if(userId == null) {
			return null;
		}
		return userDao.selectByPrimaryKey(userId);
		
	}
}
