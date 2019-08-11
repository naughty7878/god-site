package com.god.model.zeus.bo;

import java.io.Serializable;
import java.util.Date;

import com.god.common.bean.PageRequest;


/**
 * 角色表 实体类
 * 
 * @author God
 * @date 2019-08-10 18:38:38
 */
public class GodResourceBo extends PageRequest implements Serializable{
	
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
	private String description;
	/**
     * 上级ID 
     */
	private Long parentId;
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
	
	private Long roleId;

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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
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
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}

