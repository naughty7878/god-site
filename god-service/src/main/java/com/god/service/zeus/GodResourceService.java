package com.god.service.zeus;

import java.util.List;

import com.god.common.bean.PageResult;
import com.god.model.zeus.bo.GodResourceBo;
import com.god.model.zeus.entity.GodResource;

public interface GodResourceService {

	/**
	 * 分页查询
	 * @param data
	 * @return
	 */
	PageResult<GodResource> pageList(GodResourceBo godResourceBo);

	/**
	 * 更新资源
	 * @param data
	 */
	int update(GodResourceBo godResourceBo);

	/**
	 * 新增资源
	 * @param data
	 */
	int add(GodResourceBo godResourceBo);

	/**
	 * 根据ID，查询资源
	 * @param ResourceId
	 * @return
	 */
	GodResource getGodResourceById(Long resourceId);

	/**
	 * 可用资源集合
	 * @return
	 */
	List<GodResource> availableList();
}
