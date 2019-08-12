package com.god.dao.base;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.god.model.base.entity.Area;
import com.god.model.base.query.AreaExample;


/**
 * 行政区域表 DAO层
 * 
 * @author God
 * @date 2019-08-10 16:13:42
 */
public interface AreaDao {
	
	/**
	 * 统计记录-根据示例条件
	 */
    long countByExample(AreaExample example);

    /**
     * 删除记录-根据示例条件
     */
    int deleteByExample(AreaExample example);

    /**
     * 删除记录-根据主键
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入记录-完全插入
     */
    int insert(Area record);

    /**
     * 插入记录-选择性插入
     */
    int insertSelective(Area record);

    /**
     * 查询记录-根据示例条件
     */
    List<Area> selectByExample(AreaExample example);

    /**
     * 查询记录-根据主键
     */
    Area selectByPrimaryKey(Integer id);

    /**
     * 更新记录-根据示例条件选择性更新
     */
    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    /**
     * 更新记录-根据示例条件更新
     */
    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    /**
     * 更新记录-根据主键选择性更新
     * @return
     */
    int updateByPrimaryKeySelective(Area record);

    /**
     * 更新记录-根据主键更新
     * @return
     */
    int updateByPrimaryKey(Area record);
    
}
