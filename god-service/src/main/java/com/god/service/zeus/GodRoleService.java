package com.god.service.zeus;


import com.god.common.bean.PageResult;
import com.god.model.base.bo.GodRoleBo;
import com.god.model.zeus.entity.GodRole;

public interface GodRoleService {

	/**
	 * 分页查询
	 * @param data
	 * @return
	 */
	PageResult<GodRole> pageList(GodRoleBo godRoleBo);

	/**
	 * 更新用户
	 * @param data
	 */
	int update(GodRoleBo godRoleBo);

	/**
	 * 新增角色
	 * @param data
	 */
	int add(GodRoleBo godRoleBo);

	GodRole getGodRoleById(Long roleId);
	
}
