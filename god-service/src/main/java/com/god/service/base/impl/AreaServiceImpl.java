package com.god.service.base.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.god.common.bean.BaseOutput;
import com.god.dao.base.AreaDao;
import com.god.dao.datasource.TargetDataSource;
import com.god.model.base.entity.Area;
import com.god.model.base.query.AreaExample;
import com.god.model.base.query.AreaExample.Criteria;
import com.god.service.base.AreaService;

@Service
@TargetDataSource(name = TargetDataSource.BASE)
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;
	
	@Override
	public Area selectByCode(String code) {
		if(code == null || code.length() == 0) {
			BaseOutput.ERROR(500, "区域编码不能为空");
		}
		AreaExample example = new AreaExample();
		example.createCriteria().andCodeEqualTo(code.trim());
		example.setEnd(1);
		List<Area> list = areaDao.selectByExample(example);
		if(list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Area> selectByExample(Area area) {
		AreaExample example = new AreaExample();
		if(area != null) {
			String code = area.getCode();
			String name = area.getName();
			String parentCode = area.getParentCode();
			Integer scope = area.getScope();
			Integer regionType = area.getRegionType();
			
			Criteria createCriteria = example.createCriteria();
			if(code != null && code.length() > 0) {
				createCriteria.andCodeEqualTo(code.trim());
			}
			if(name != null && name.length() > 0) {
				createCriteria.andNameEqualTo(name.trim());
			}
			if(parentCode != null && parentCode.length() > 0) {
				createCriteria.andParentCodeEqualTo(parentCode.trim());
			}
			if(scope != null) {
				createCriteria.andScopeEqualTo(scope);
			}
			if(regionType != null) {
				createCriteria.andRegionTypeEqualTo(regionType);
			}
		}
		List<Area> list = areaDao.selectByExample(example);
		return list;
	}

}
