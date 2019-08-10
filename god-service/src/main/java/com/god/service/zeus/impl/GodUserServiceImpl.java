package com.god.service.zeus.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
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
import com.god.dao.zeus.GodRoleDao;
import com.god.dao.zeus.GodUserDao;
import com.god.dao.zeus.GodUserRoleDao;
import com.god.model.zeus.bo.GodUserBo;
import com.god.model.zeus.entity.GodRole;
import com.god.model.zeus.entity.GodUser;
import com.god.model.zeus.entity.GodUserRole;
import com.god.model.zeus.query.GodUserExample;
import com.god.model.zeus.query.GodUserExample.Criteria;
import com.god.model.zeus.query.GodUserRoleExample;
import com.god.model.zeus.vo.GodUserVo;
import com.god.service.zeus.GodUserService;
import com.god.service.zeus.constant.ZeusConstants;


@Service
public class GodUserServiceImpl implements GodUserService{

	@Autowired
	private GodUserDao userDao;
	
	@Autowired
	private GodUserRoleDao userRoleDao;
	
	@Autowired
	private GodRoleDao roleDao;
	
	@Override
	public List<GodUser> searchUserList() {
		return userDao.selectByExample(null);
	}
	
	
	@Override
	public PageResult<GodUserVo> pageList(GodUserBo godUserBo) {
		
		String beginDate = godUserBo.getBeginDate();
		String endDate = godUserBo.getEndDate();
		String name = godUserBo.getName();
		Integer status = godUserBo.getStatus();
		
		Date begin = DateUtils.stringToDate(beginDate, DateUtils.DATE_FORMAT);
		Date end = DateUtils.stringToDate(endDate, DateUtils.DATE_FORMAT);
		
		GodUserExample userExample = new GodUserExample();
		Criteria criteria = userExample.createCriteria();
		if(begin != null && end != null) {
			criteria.andCreateTimeBetween(begin, end);
		}
		if(!StringUtils.isEmpty(name)) {
			criteria.andNameLike("%" + name + "%");
		}
		if(status != null) {
			criteria.andStatusEqualTo(status);
		}
		
		//获取第1页，10条内容，默认查询总数count
		Page<Object> page = PageHelper.startPage(godUserBo.getPageNum(), godUserBo.getPageSize());
		List<GodUser> userList = userDao.selectByExample(userExample);
		List<GodUserVo> userVoList = new ArrayList<GodUserVo>();
		if(userList.size() > 0) {
			for (GodUser user : userList) {
				userVoList.add(convertToGodUserVo(user));
			}
		}
		PageResult<GodUserVo> pageResult = new PageResult<GodUserVo>(userVoList, page.getTotal(), page.getPageNum(), page.getPageSize());
		
		return pageResult;
	}
	
	private GodUserVo convertToGodUserVo(GodUser godUser) {
		if(godUser == null) return null;
		GodUserVo userVo = new GodUserVo();
		BeanUtils.copyProperties(godUser, userVo);
		
		Long userId = godUser.getId();
		GodRole role = roleDao.selectByUserId(userId);
		if(role != null) {
			userVo.setRoleId(role.getId());
			userVo.setRoleName(role.getName());
		}
		return userVo;
	}
	
	
	
	@Override
	@Transactional
	public int update(GodUserBo godUserBo) {
		String name = godUserBo.getName();
		String password = godUserBo.getPassword();
		Integer status = godUserBo.getStatus();
		Long roleId = godUserBo.getRoleId();
		Long id = godUserBo.getId();
		
		Date currentDate = new Date();
		
		GodUser user = new GodUser();
		user.setId(id);
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
		
		if(roleId != null && id != null) {
			// 更新用户角色关系
			// 删除旧关系
			GodUserRoleExample userRoleExample = new GodUserRoleExample();
			userRoleExample.createCriteria().andUserIdEqualTo(id);
			userRoleDao.deleteByExample(userRoleExample);
			
			// 新增关系
			GodUserRole userRole = new GodUserRole();
			userRole.setUserId(id);
			userRole.setRoleId(roleId);
			userRole.setCreateTime(currentDate);
			userRole.setUpdateTime(currentDate);
			userRoleDao.insert(userRole);
			
		}
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
	public GodUser getGodUserById(Long userId) {
		if(userId == null) {
			return null;
		}
		return userDao.selectByPrimaryKey(userId);
		
	}
}
