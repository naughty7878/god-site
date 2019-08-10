package com.god.model.zeus.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 资源表 实体类
 * 
 * @author God
 * @date 2019-08-11 00:15:26
 */
public class GodResource implements Serializable{
	
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
     * 编码 
     */
	private String code;
	/**
     * 描述 
     */
	private String describe;
	/**
     * 上级ID 
     */
	private Integer parentId;
	/**
     * 级别 
     */
	private Integer level;
	/**
     * 排序 
     */
	private Integer sort;
	/**
     * 连接地址 
     */
	private String url;
	/**
     * 图标 
     */
	private String icon;
	/**
     * 状态：0禁用 1启用 
     */
	private Integer status;
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
		
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
		
	public void setCode(String value) {
		this.code = value;
	}
	
	public String getCode() {
		return this.code;
	}
		
	public void setDescribe(String value) {
		this.describe = value;
	}
	
	public String getDescribe() {
		return this.describe;
	}
		
	public void setParentId(Integer value) {
		this.parentId = value;
	}
	
	public Integer getParentId() {
		return this.parentId;
	}
		
	public void setLevel(Integer value) {
		this.level = value;
	}
	
	public Integer getLevel() {
		return this.level;
	}
		
	public void setSort(Integer value) {
		this.sort = value;
	}
	
	public Integer getSort() {
		return this.sort;
	}
		
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return this.url;
	}
		
	public void setIcon(String value) {
		this.icon = value;
	}
	
	public String getIcon() {
		return this.icon;
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

