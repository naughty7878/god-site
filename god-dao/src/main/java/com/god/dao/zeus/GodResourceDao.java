package com.god.dao.zeus;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.god.model.zeus.entity.GodResource;
import com.god.model.zeus.query.GodResourceExample;


/**
 * 资源表 DAO层
 * 
 * @author God
 * @date 2019-08-11 01:24:17
 */
public interface GodResourceDao {
	
	/**
	 * 统计记录-根据示例条件
	 */
    long countByExample(GodResourceExample example);

    /**
     * 删除记录-根据示例条件
     */
    int deleteByExample(GodResourceExample example);

    /**
     * 删除记录-根据主键
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入记录-完全插入
     */
    int insert(GodResource record);

    /**
     * 插入记录-选择性插入
     */
    int insertSelective(GodResource record);

    /**
     * 查询记录-根据示例条件
     */
    List<GodResource> selectByExample(GodResourceExample example);

    /**
     * 查询记录-根据主键
     */
    GodResource selectByPrimaryKey(Long id);

    /**
     * 更新记录-根据示例条件选择性更新
     */
    int updateByExampleSelective(@Param("record") GodResource record, @Param("example") GodResourceExample example);

    /**
     * 更新记录-根据示例条件更新
     */
    int updateByExample(@Param("record") GodResource record, @Param("example") GodResourceExample example);

    /**
     * 更新记录-根据主键选择性更新
     * @return
     */
    int updateByPrimaryKeySelective(GodResource record);

    /**
     * 更新记录-根据主键更新
     * @return
     */
    int updateByPrimaryKey(GodResource record);
    
}
