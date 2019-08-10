package com.god.model.zeus.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户角色表 实体类
 * 
 * @author God
 * @date 2019-08-10 23:26:32
 */
public class GodUserRole implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	/**
     * ID 
     */
	private Long id;
	/**
     * 用户ID 
     */
	private Long userId;
	/**
     * 角色ID 
     */
	private Long roleId;
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
		
	public void setUserId(Long value) {
		this.userId = value;
	}
	
	public Long getUserId() {
		return this.userId;
	}
		
	public void setRoleId(Long value) {
		this.roleId = value;
	}
	
	public Long getRoleId() {
		return this.roleId;
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

