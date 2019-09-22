package com.god.service.base;


import java.util.List;

import com.god.common.bean.BaseOutput;
import com.god.model.base.entity.Area;

/**
 * 行政区域 服务类
 * 
 * @author h__d
 *
 */
public interface AreaService {

	/**
	 * 根据行政区域编码，获取行政区域
	 * @param id
	 * @return
	 */
	public Area selectByCode(String code);

	/**
	 * 根据行政区域条件，获取行政区域
	 * @param data
	 * @return
	 */
	public List<Area> selectByExample(Area area); 
	
	
	
}
