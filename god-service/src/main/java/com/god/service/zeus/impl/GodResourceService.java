package com.god.service.zeus.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.god.common.bean.PageResult;
import com.god.common.util.DateUtils;
import com.god.dao.zeus.GodResourceDao;
import com.god.model.zeus.bo.GodResourceBo;
import com.god.model.zeus.entity.GodResource;
import com.god.model.zeus.entity.GodRole;
import com.god.model.zeus.query.GodResourceExample;
import com.god.model.zeus.query.GodResourceExample.Criteria;

@Service
public class GodResourceService implements com.god.service.zeus.GodResourceService {
	
	@Autowired
	private GodResourceDao resourceDao;

	@Override
	public PageResult<GodResource> pageList(GodResourceBo godResourceBo) {
		String name = godResourceBo.getName();
		Integer status = godResourceBo.getStatus();
		
		String beginDate = godResourceBo.getBeginDate();
		String endDate = godResourceBo.getEndDate();
		
		Date begin = DateUtils.stringToDate(beginDate, DateUtils.DATE_FORMAT);
		Date end = DateUtils.stringToDate(endDate, DateUtils.DATE_FORMAT);
		
		GodResourceExample resourceExample = new GodResourceExample();
		Criteria criteria = resourceExample.createCriteria();
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
		Page<Object> page = PageHelper.startPage(godResourceBo.getPageNum(), godResourceBo.getPageSize());
		List<GodResource> roleList = resourceDao.selectByExample(resourceExample);
		
		PageResult<GodResource> pageResult = new PageResult<GodResource>(roleList, page.getTotal(), page.getPageNum(), page.getPageSize());
		
		return pageResult;
	}

	@Override
	public int update(GodResourceBo godResourceBo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(GodResourceBo godResourceBo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GodResource getGodResourceById(Long ResourceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GodResource> availableList() {
		// TODO Auto-generated method stub
		return null;
	}

}
