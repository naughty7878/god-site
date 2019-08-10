package com.god.model.zeus.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 角色表 实体类
 * 
 * @author God
 * @date 2019-08-10 18:38:38
 */
public class GodRole implements Serializable{
	
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
	/**
     * 创建时间 
     */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date createTime;
	/**
     * 更新时间 
     */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date updateTime;
	
		
	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
		
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
		
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}
		
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return this.status;
	}
		
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
		
	public void setUpdateTime(Date value) {
		this.updateTime = value;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

}

