package com.god.dao.zeus;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.god.model.zeus.entity.GodUserRole;
import com.god.model.zeus.query.GodUserRoleExample;


/**
 * 用户角色表 DAO层
 * 
 * @author God
 * @date 2019-08-10 22:53:40
 */
public interface GodUserRoleDao {
	
	/**
	 * 统计记录-根据示例条件
	 */
    long countByExample(GodUserRoleExample example);

    /**
     * 删除记录-根据示例条件
     */
    int deleteByExample(GodUserRoleExample example);

    /**
     * 删除记录-根据主键
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入记录-完全插入
     */
    int insert(GodUserRole record);

    /**
     * 插入记录-选择性插入
     */
    int insertSelective(GodUserRole record);

    /**
     * 查询记录-根据示例条件
     */
    List<GodUserRole> selectByExample(GodUserRoleExample example);

    /**
     * 查询记录-根据主键
     */
    GodUserRole selectByPrimaryKey(Long id);

    /**
     * 更新记录-根据示例条件选择性更新
     */
    int updateByExampleSelective(@Param("record") GodUserRole record, @Param("example") GodUserRoleExample example);

    /**
     * 更新记录-根据示例条件更新
     */
    int updateByExample(@Param("record") GodUserRole record, @Param("example") GodUserRoleExample example);

    /**
     * 更新记录-根据主键选择性更新
     * @return
     */
    int updateByPrimaryKeySelective(GodUserRole record);

    /**
     * 更新记录-根据主键更新
     * @return
     */
    int updateByPrimaryKey(GodUserRole record);
    
}
