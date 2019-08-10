package com.god.service.zeus;


import java.util.List;

import com.god.common.bean.PageResult;
import com.god.model.zeus.bo.GodRoleBo;
import com.god.model.zeus.entity.GodRole;

public interface GodRoleService {

	/**
	 * 分页查询
	 * @param data
	 * @return
	 */
	PageResult<GodRole> pageList(GodRoleBo godRoleBo);

	/**
	 * 更新角色
	 * @param data
	 */
	int update(GodRoleBo godRoleBo);

	/**
	 * 新增角色
	 * @param data
	 */
	int add(GodRoleBo godRoleBo);

	/**
	 * 根据ID，查询角色
	 * @param roleId
	 * @return
	 */
	GodRole getGodRoleById(Long roleId);

	/**
	 * 可用角色集合
	 * @return
	 */
	List<GodRole> availableList();
	
}
