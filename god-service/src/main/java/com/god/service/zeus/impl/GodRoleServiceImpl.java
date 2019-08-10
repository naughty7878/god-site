package com.god.service.zeus.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.god.common.bean.PageResult;
import com.god.common.util.DateUtils;
import com.god.dao.zeus.GodRoleDao;
import com.god.model.base.bo.GodRoleBo;
import com.god.model.zeus.entity.GodRole;
import com.god.model.zeus.query.GodRoleExample;
import com.god.model.zeus.query.GodRoleExample.Criteria;
import com.god.service.zeus.GodRoleService;

@Service
public class GodRoleServiceImpl implements GodRoleService {
	
	@Autowired
	private GodRoleDao godRoleDao;

	
	@Override
	public GodRole getGodRoleById(Long roleId) {
		return godRoleDao.selectByPrimaryKey(roleId);
	}
	

	@Override
	@Transactional
	public int add(GodRoleBo godRoleBo) {
		
		String name = godRoleBo.getName();
		String description = godRoleBo.getDescription();
		Integer status = godRoleBo.getStatus();
		
		// 验证
		if(StringUtils.isEmpty(name) ) {
			return 0;
		}
		GodRoleExample userExample = new GodRoleExample();
		userExample.createCriteria().andNameEqualTo(name);
		userExample.setEnd(1);
		List<GodRole> roleList = godRoleDao.selectByExample(userExample);
		if(roleList.size() > 0) {
			return 0;
		}
		
		// 新增
		GodRole role = new GodRole();
		role.setName(name);
		role.setDescription(description);
		
		if(status != null) {
			role.setStatus(status);
		}else {
			role.setStatus(0);
		}
		Date currentTime = new Date();
		role.setCreateTime(currentTime);
		role.setUpdateTime(currentTime);
		int insertStatus = godRoleDao.insertSelective(role);
		return insertStatus;
		
	}

	
	@Override
	public PageResult<GodRole> pageList(GodRoleBo godRoleBo) {
		
		String name = godRoleBo.getName();
		Integer status = godRoleBo.getStatus();
		
		String beginDate = godRoleBo.getBeginDate();
		String endDate = godRoleBo.getEndDate();
		
		Date begin = DateUtils.stringToDate(beginDate, DateUtils.DATE_FORMAT);
		Date end = DateUtils.stringToDate(endDate, DateUtils.DATE_FORMAT);
		
		GodRoleExample userExample = new GodRoleExample();
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
		Page<Object> page = PageHelper.startPage(godRoleBo.getPageNum(), godRoleBo.getPageSize());
		List<GodRole> userList = godRoleDao.selectByExample(userExample);
		
		PageResult<GodRole> pageResult = new PageResult<GodRole>(userList, page.getTotal(), page.getPageNum(), page.getPageSize());
		
		return pageResult;
	}
	
	@Override
	@Transactional
	public int update(GodRoleBo godRoleBo) {
		String description = godRoleBo.getDescription();
		Integer status = godRoleBo.getStatus();
		
		GodRole role = new GodRole();
		role.setId(godRoleBo.getId());
		if(!StringUtils.isEmpty(description)) {
			role.setDescription(description);
		}
		if(status != null) {
			role.setStatus(status);
		}
		role.setUpdateTime(new Date());
		
		return godRoleDao.updateByPrimaryKeySelective(role);
	}
}
