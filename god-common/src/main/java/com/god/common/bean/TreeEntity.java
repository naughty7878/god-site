package com.god.common.bean;

import java.io.Serializable;

/**
 * 树 示例对象
 * @author h__d
 *
 */
public class TreeEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;  //节点的id值
    private String name; //节点的名称
    private Boolean isLeaf; //是否是叶子节点
    private Long parentId; //当前节点对应父节点的id值
    private Integer level; // 级别
    
    public TreeEntity() {
	}

    public TreeEntity(Long id, String name, Boolean isLeaf, Long parentId){
      this.id = id;
      this.name = name;
      this.isLeaf = isLeaf;
      this.parentId = parentId;
    }

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

	public Boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
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
    
}
