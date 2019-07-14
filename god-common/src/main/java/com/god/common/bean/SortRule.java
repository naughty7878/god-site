package com.god.common.bean;

import java.io.Serializable;

public class SortRule implements Serializable{
	
	/* 排序字段 */
	private String field;
	/* 排序模式：0升序 1降序 */
	private int sortByMode;
	/* 正则 */
	public static final String REGEX = "[\\w|-|_|.]*";
	public String getField() {
		return field;
	}
	public void setField(String field) {
		if(field != null && !field.matches(REGEX)) {
			throw new RuntimeException("非法操作");
		}
		this.field = field;
		
	}
	public int getSortByMode() {
		return sortByMode;
	}
	public void setSortByMode(int sortByMode) {
		this.sortByMode = sortByMode;
	}
	
}
