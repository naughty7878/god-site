package com.god.model.base.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 行政区域表 实体类
 * 
 * @author God
 * @date 2019-08-10 16:13:42
 */
public class Area implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	/**
     * ID 
     */
	private Integer id;
	/**
     * 编码 
     */
	private String code;
	/**
     * 上级编码 
     */
	private String parentCode;
	/**
     * 名称 
     */
	private String name;
	/**
     * 别名 
     */
	private String alias;
	/**
     * 范围：1国家 2省 3市 4区 
     */
	private Integer scope;
	/**
     * 区域类型：0普通 1直辖市 
     */
	private Integer regionType;
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
		
	public void setCode(String value) {
		this.code = value;
	}
	
	public String getCode() {
		return this.code;
	}
		
	public void setParentCode(String value) {
		this.parentCode = value;
	}
	
	public String getParentCode() {
		return this.parentCode;
	}
		
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
		
	public void setAlias(String value) {
		this.alias = value;
	}
	
	public String getAlias() {
		return this.alias;
	}
		
	public void setScope(Integer value) {
		this.scope = value;
	}
	
	public Integer getScope() {
		return this.scope;
	}
		
	public void setRegionType(Integer value) {
		this.regionType = value;
	}
	
	public Integer getRegionType() {
		return this.regionType;
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

