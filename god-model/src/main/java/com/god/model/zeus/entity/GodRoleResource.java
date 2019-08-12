package com.god.model.zeus.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户角色表 实体类
 * 
 * @author God
 * @date 2019-08-11 09:50:00
 */
public class GodRoleResource implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	/**
     * ID 
     */
	private Long id;
	/**
     * 角色ID 
     */
	private Long roleId;
	/**
     * 资源ID 
     */
	private Long resourceId;
	/**
     * 创建时间 
     */
	private Date createTime;
	/**
     * 更新时间 
     */
	private Date updateTime;
	
		
	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
		
	public void setRoleId(Long value) {
		this.roleId = value;
	}
	
	public Long getRoleId() {
		return this.roleId;
	}
		
	public void setResourceId(Long value) {
		this.resourceId = value;
	}
	
	public Long getResourceId() {
		return this.resourceId;
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

