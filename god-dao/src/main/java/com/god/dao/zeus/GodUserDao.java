package com.god.dao.zeus;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.god.model.zeus.entity.GodUser;
import com.god.model.zeus.query.GodUserExample;



/**
 * 用户表 DAO层
 * 
 * @author God
 * @date 2019-08-01 23:53:15
 */
public interface GodUserDao {
	
	/**
	 * 统计记录-根据示例条件
	 */
    long countByExample(GodUserExample example);

    /**
     * 删除记录-根据示例条件
     */
    int deleteByExample(GodUserExample example);

    /**
     * 删除记录-根据主键
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入记录-完全插入
     */
    int insert(GodUser record);

    /**
     * 插入记录-选择性插入
     */
    int insertSelective(GodUser record);

    /**
     * 查询记录-根据示例条件
     */
    List<GodUser> selectByExample(GodUserExample example);

    /**
     * 查询记录-根据主键
     */
    GodUser selectByPrimaryKey(Integer id);

    /**
     * 更新记录-根据示例条件选择性更新
     */
    int updateByExampleSelective(@Param("record") GodUser record, @Param("example") GodUserExample example);

    /**
     * 更新记录-根据示例条件更新
     */
    int updateByExample(@Param("record") GodUser record, @Param("example") GodUserExample example);

    /**
     * 更新记录-根据主键选择性更新
     * @return
     */
    int updateByPrimaryKeySelective(GodUser record);

    /**
     * 更新记录-根据主键更新
     * @return
     */
    int updateByPrimaryKey(GodUser record);
    
}
