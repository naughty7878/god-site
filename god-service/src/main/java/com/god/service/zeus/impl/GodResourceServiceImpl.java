package com.god.service.zeus.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.god.common.bean.PageResult;
import com.god.common.bean.TreeEntity;
import com.god.common.util.DateUtils;
import com.god.dao.zeus.GodResourceDao;
import com.god.model.zeus.bo.GodResourceBo;
import com.god.model.zeus.entity.GodResource;
import com.god.model.zeus.entity.GodRole;
import com.god.model.zeus.query.GodResourceExample;
import com.god.model.zeus.query.GodRoleExample;
import com.god.service.constant.GodResourceStatusEnum;
import com.god.service.constant.GodRoleStatusEnum;
import com.god.service.zeus.GodResourceService;
import com.god.model.zeus.query.GodResourceExample.Criteria;

@Service
public class GodResourceServiceImpl implements GodResourceService {

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
		if (begin != null && end != null) {
			criteria.andCreateTimeBetween(begin, end);
		}
		if (!StringUtils.isEmpty(name)) {
			criteria.andNameLike("%" + name + "%");
		}
		if (status != null) {
			criteria.andStatusEqualTo(status);
		}

		// 获取第1页，10条内容，默认查询总数count
		Page<Object> page = PageHelper.startPage(godResourceBo.getPageNum(), godResourceBo.getPageSize());
		List<GodResource> roleList = resourceDao.selectByExample(resourceExample);

		PageResult<GodResource> pageResult = new PageResult<GodResource>(roleList, page.getTotal(), page.getPageNum(),
				page.getPageSize());

		return pageResult;
	}

	@Override
	@Transactional
	public int update(GodResourceBo godResourceBo) {
		Long id = godResourceBo.getId();
		String name = godResourceBo.getName();
		String description = godResourceBo.getDescription();
		Integer status = godResourceBo.getStatus();
		String icon = godResourceBo.getIcon();
		Integer level = godResourceBo.getLevel();
		Long parentId = godResourceBo.getParentId();
		String url = godResourceBo.getUrl();
		Integer sort = godResourceBo.getSort();

		GodResource resource = new GodResource();
		resource.setId(id);
		if (!StringUtils.isEmpty(name)) {
			resource.setName(name);
		}
		if (!StringUtils.isEmpty(description)) {
			resource.setDescription(description);
		}
		if (status != null) {
			resource.setStatus(status);
		}
		if (icon != null) {
			resource.setIcon(icon);
		}
		if (level != null) {
			resource.setLevel(level);
		}
		if (url != null) {
			resource.setUrl(url);
		}
		if (sort != null) {
			resource.setSort(sort);
		}
		if (parentId != null) {
			resource.setParentId(parentId);
		}
		resource.setUpdateTime(new Date());

		return resourceDao.updateByPrimaryKeySelective(resource);
	}

	@Override
	@Transactional
	public int add(GodResourceBo godResourceBo) {
		String name = godResourceBo.getName();
		String description = godResourceBo.getDescription();
		Integer status = godResourceBo.getStatus();
		String icon = godResourceBo.getIcon();
		Integer level = godResourceBo.getLevel();
		Long parentId = godResourceBo.getParentId();
		String url = godResourceBo.getUrl();
		Integer sort = godResourceBo.getSort();

		// 验证
		if (StringUtils.isEmpty(name)) {
			return 0;
		}
		GodResourceExample resourceExample = new GodResourceExample();
		resourceExample.createCriteria().andNameEqualTo(name);
		resourceExample.setEnd(1);
		List<GodResource> roleList = resourceDao.selectByExample(resourceExample);
		if (roleList.size() > 0) {
			return 0;
		}

		// 新增
		GodResource resource = new GodResource();
		resource.setName(name);
		resource.setDescription(description);
		resource.setCode(name.hashCode() + "");
		resource.setParentId(parentId);
		resource.setLevel(level);
		resource.setSort(sort);
		resource.setUrl(url);
		resource.setIcon(icon);

		if (status != null) {
			resource.setStatus(status);
		} else {
			resource.setStatus(GodResourceStatusEnum.ROLE_UNAVAILABLE.getCode());
		}
		Date currentTime = new Date();
		resource.setCreateTime(currentTime);
		resource.setUpdateTime(currentTime);
		int insertStatus = resourceDao.insertSelective(resource);
		return insertStatus;
	}

	@Override
	public GodResource getGodResourceById(Long resourceId) {
		return resourceDao.selectByPrimaryKey(resourceId);
	}

	@Override
	public List<TreeEntity> getAvailableTreeList() {

		List<TreeEntity> treeList = new ArrayList<TreeEntity>();
		GodResourceExample resourceExample = new GodResourceExample();
		Criteria criteria = resourceExample.createCriteria();
		criteria.andStatusEqualTo(GodResourceStatusEnum.ROLE_AVAILABLE.getCode());
		List<GodResource> list = resourceDao.selectByExample(resourceExample);
		// 排序
		sortResources(list);
		if (list.size() > 0) {
			// 封装成树
			for (GodResource godResource : list) {
				TreeEntity treeEntity = new TreeEntity();
				treeEntity.setId(godResource.getId());
				treeEntity.setName(godResource.getName());
				treeEntity.setParentId(godResource.getParentId());
				treeEntity.setLevel(godResource.getLevel());
				treeList.add(treeEntity);
			}
		}
		return treeList;
	}

	private void sortResources(List<GodResource> list) {
		if (list != null && list.size() > 0) {
			// 排序
			list.sort(new Comparator<GodResource>() {

				@Override
				public int compare(GodResource o1, GodResource o2) {
					return getScore(o1) - getScore(o2);
				}

				int getScore(GodResource resource) {
					int score = 0;
					if (resource == null) {
						return score;
					}
					switch (resource.getLevel()) {
					case 1:
						score += 10000 * resource.getSort();
						break;
					case 2:
						score += 100 * resource.getSort();
						break;
					case 3:
						score += 1 * resource.getSort();
						break;
					default:
						break;
					}
					if (resource.getParentId() != null && resource.getParentId() != 0) {
						GodResource parentResource = resourceDao.selectByPrimaryKey(resource.getParentId());
						score += getScore(parentResource);
					}
					return score;
				}
			});
		}
	}

	@Override
	public List<GodResource> selectByRoleId(Long roleId) {

		List<GodResource> list = resourceDao.selectByRoleId(roleId);
		// 排序
		sortResources(list);
		return list;
	}

}
