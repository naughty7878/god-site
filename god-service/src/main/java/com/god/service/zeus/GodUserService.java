package com.god.service.zeus;

import java.util.List;

import com.god.common.bean.PageResult;
import com.god.model.zeus.bo.GodUserBo;
import com.god.model.zeus.entity.GodUser;
import com.god.model.zeus.vo.GodUserVo;



/**
 * 用户服务类
 * @author H__D
 * @date 2019-07-06 00:47:36
 *
 */
public interface GodUserService {

	List<GodUser> searchUserList();

	/**
	 * 分页查询
	 * @param data
	 * @return
	 */
	PageResult<GodUserVo> pageList(GodUserBo godUserBo);

	/**
	 * 更新用户
	 * @param data
	 */
	int update(GodUserBo godUserBo);

	/**
	 * 新增用户
	 * @param data
	 */
	int add(GodUserBo godUserBo);
	
	/**
	 * 根据用户ID，获取用户
	 * @param userId
	 * @return
	 */
	GodUser getGodUserById(Long userId);

	/**
	 * 转化成用户值对象
	 * @param godUser
	 * @return
	 */
	GodUserVo convertToGodUserVo(GodUser godUser);

}
