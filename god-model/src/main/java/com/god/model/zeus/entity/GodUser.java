package com.god.model.zeus.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户表 实体类
 * 
 * @author God
 * @date 2019-08-02 01:21:15
 */
public class GodUser implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	/**
     * ID 
     */
	private Integer id;
	/**
     * 名称 
     */
	private String name;
	/**
     * 密码 
     */
	private String password;
	/**
     * 昵称 
     */
	private String nickname;
	/**
     * 状态 0禁用 1启用 
     */
	private Integer status;
	/**
     * 创建时间 
     */
	private Date createTime;
	/**
     * 修改时间 
     */
	private Date updateTime;
	
		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
		
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return this.password;
	}
		
	public void setNickname(String value) {
		this.nickname = value;
	}
	
	public String getNickname() {
		return this.nickname;
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

