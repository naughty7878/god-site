package com.god.common.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页请求
 * 
 * @author H__D
 * @date 2018-11-15 00:40:43
 *
 */
public class PageRequest implements Serializable{

	private static final Integer DEFAULT_PAGE_CURRENT = 1;
	private static final Integer DEFAULT_PAGE_SIZE = 20;

	/**
	 * 当前页号
	 */
	private int pageNum = DEFAULT_PAGE_CURRENT;
	/**
	 * 页尺寸(大小)
	 */
	private int pageSize = DEFAULT_PAGE_SIZE;

	/**
	 * 排序规则
	 */
	private List<SortRule> sortRules;

	public PageRequest() {
	}

	public PageRequest(int pageNumber, int pageSize) {
		this.pageNum = pageNumber;
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum <= 0 ? DEFAULT_PAGE_CURRENT : pageNum;
	}

	public void setPageNum(int pageNumber) {
		this.pageNum = pageNumber;
	}

	public int getPageSize() {
		return pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<SortRule> getSortRules() {
		return sortRules;
	}

	public void setSortRules(List<SortRule> sortRules) {
		this.sortRules = sortRules;
	}

	
}
