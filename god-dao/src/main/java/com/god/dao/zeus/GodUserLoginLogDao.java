package com.god.dao.zeus;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.god.model.zeus.entity.GodUserLoginLog;
import com.god.model.zeus.query.GodUserLoginLogExample;



public interface GodUserLoginLogDao {
    long countByExample(GodUserLoginLogExample example);

    int deleteByExample(GodUserLoginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GodUserLoginLog record);

    int insertSelective(GodUserLoginLog record);

    List<GodUserLoginLog> selectByExample(GodUserLoginLogExample example);

    GodUserLoginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GodUserLoginLog record, @Param("example") GodUserLoginLogExample example);

    int updateByExample(@Param("record") GodUserLoginLog record, @Param("example") GodUserLoginLogExample example);

    int updateByPrimaryKeySelective(GodUserLoginLog record);

    int updateByPrimaryKey(GodUserLoginLog record);
}