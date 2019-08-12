package com.god.dao.zeus;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.god.model.zeus.entity.GodRoleResource;
import com.god.model.zeus.query.GodRoleResourceExample;


/**
 * 用户角色表 DAO层
 * 
 * @author God
 * @date 2019-08-11 09:50:00
 */
public interface GodRoleResourceDao {
	
	/**
	 * 统计记录-根据示例条件
	 */
    long countByExample(GodRoleResourceExample example);

    /**
     * 删除记录-根据示例条件
     */
    int deleteByExample(GodRoleResourceExample example);

    /**
     * 删除记录-根据主键
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入记录-完全插入
     */
    int insert(GodRoleResource record);

    /**
     * 插入记录-选择性插入
     */
    int insertSelective(GodRoleResource record);

    /**
     * 查询记录-根据示例条件
     */
    List<GodRoleResource> selectByExample(GodRoleResourceExample example);

    /**
     * 查询记录-根据主键
     */
    GodRoleResource selectByPrimaryKey(Long id);

    /**
     * 更新记录-根据示例条件选择性更新
     */
    int updateByExampleSelective(@Param("record") GodRoleResource record, @Param("example") GodRoleResourceExample example);

    /**
     * 更新记录-根据示例条件更新
     */
    int updateByExample(@Param("record") GodRoleResource record, @Param("example") GodRoleResourceExample example);

    /**
     * 更新记录-根据主键选择性更新
     * @return
     */
    int updateByPrimaryKeySelective(GodRoleResource record);

    /**
     * 更新记录-根据主键更新
     * @return
     */
    int updateByPrimaryKey(GodRoleResource record);
    
}
