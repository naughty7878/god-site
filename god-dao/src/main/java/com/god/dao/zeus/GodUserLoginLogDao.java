package com.god.dao.zeus;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.god.model.zeus.entity.GodUserLoginLog;
import com.god.model.zeus.query.GodUserLoginLogExample;


/**
 * 用户登录日志表 DAO层
 * 
 * @author God
 * @date 2019-08-02 01:07:43
 */
public interface GodUserLoginLogDao {
	
	/**
	 * 统计记录-根据示例条件
	 */
    long countByExample(GodUserLoginLogExample example);

    /**
     * 删除记录-根据示例条件
     */
    int deleteByExample(GodUserLoginLogExample example);

    /**
     * 删除记录-根据主键
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入记录-完全插入
     */
    int insert(GodUserLoginLog record);

    /**
     * 插入记录-选择性插入
     */
    int insertSelective(GodUserLoginLog record);

    /**
     * 查询记录-根据示例条件
     */
    List<GodUserLoginLog> selectByExample(GodUserLoginLogExample example);

    /**
     * 查询记录-根据主键
     */
    GodUserLoginLog selectByPrimaryKey(Integer id);

    /**
     * 更新记录-根据示例条件选择性更新
     */
    int updateByExampleSelective(@Param("record") GodUserLoginLog record, @Param("example") GodUserLoginLogExample example);

    /**
     * 更新记录-根据示例条件更新
     */
    int updateByExample(@Param("record") GodUserLoginLog record, @Param("example") GodUserLoginLogExample example);

    /**
     * 更新记录-根据主键选择性更新
     * @return
     */
    int updateByPrimaryKeySelective(GodUserLoginLog record);

    /**
     * 更新记录-根据主键更新
     * @return
     */
    int updateByPrimaryKey(GodUserLoginLog record);
    
}
