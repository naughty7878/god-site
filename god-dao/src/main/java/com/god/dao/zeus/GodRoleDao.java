package com.god.dao.zeus;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.god.model.zeus.entity.GodRole;
import com.god.model.zeus.query.GodRoleExample;


/**
 * 角色表 DAO层
 * 
 * @author God
 * @date 2019-08-10 18:38:37
 */
public interface GodRoleDao {
	
	/**
	 * 统计记录-根据示例条件
	 */
    long countByExample(GodRoleExample example);

    /**
     * 删除记录-根据示例条件
     */
    int deleteByExample(GodRoleExample example);

    /**
     * 删除记录-根据主键
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入记录-完全插入
     */
    int insert(GodRole record);

    /**
     * 插入记录-选择性插入
     */
    int insertSelective(GodRole record);

    /**
     * 查询记录-根据示例条件
     */
    List<GodRole> selectByExample(GodRoleExample example);

    /**
     * 查询记录-根据主键
     */
    GodRole selectByPrimaryKey(Long id);

    /**
     * 更新记录-根据示例条件选择性更新
     */
    int updateByExampleSelective(@Param("record") GodRole record, @Param("example") GodRoleExample example);

    /**
     * 更新记录-根据示例条件更新
     */
    int updateByExample(@Param("record") GodRole record, @Param("example") GodRoleExample example);

    /**
     * 更新记录-根据主键选择性更新
     * @return
     */
    int updateByPrimaryKeySelective(GodRole record);

    /**
     * 更新记录-根据主键更新
     * @return
     */
    int updateByPrimaryKey(GodRole record);
    
    /**
     * 根据用户ID，获取角色信息
     * @return
     */
    GodRole selectByUserId(Long userId);
}
