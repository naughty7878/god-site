package com.god.model.base.bo;

import java.io.Serializable;
import java.util.Date;

import com.god.common.bean.PageRequest;


/**
 * 角色表 实体类
 * 
 * @author God
 * @date 2019-08-10 18:38:38
 */
public class GodRoleBo extends PageRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	/**
     * ID 
     */
	private Long id;
	/**
     * 名称 
     */
	private String name;
	/**
     * 描述 
     */
	private String description;
	/**
     * 状态：0禁用 1启用 
     */
	private Integer status;

	private String beginDate;
	private String endDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}

