package com.god.model.zeus.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户登录日志表 实体类
 * 
 * @author God
 * @date 2019-08-10 18:52:38
 */
public class GodUserLoginLog implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	/**
     * ID 
     */
	private Long id;
	/**
     * 用户id 
     */
	private Long userId;
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

