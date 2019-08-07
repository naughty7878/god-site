package com.god.model.zeus.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户登录日志表 实体类
 * 
 * @author God
 * @date 2019-08-02 01:07:43
 */
public class GodUserLoginLog implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	/**
     * ID 
     */
	private Integer id;
	/**
     * 用户id 
     */
	private Integer userId;
	/**
     * 登录IP 
     */
	private String loginIp;
	/**
     * 次数 
     */
	private Integer times;
	/**
     * 城市 
     */
	private String city;
	/**
     * 创建时间 
     */
	private Date createTime;
	/**
     * 更新时间 
     */
	private Date updateTime;
	
		
	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
		
	public void setUserId(Integer value) {
		this.userId = value;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
		
	public void setLoginIp(String value) {
		this.loginIp = value;
	}
	
	public String getLoginIp() {
		return this.loginIp;
	}
		
	public void setTimes(Integer value) {
		this.times = value;
	}
	
	public Integer getTimes() {
		return this.times;
	}
		
	public void setCity(String value) {
		this.city = value;
	}
	
	public String getCity() {
		return this.city;
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

