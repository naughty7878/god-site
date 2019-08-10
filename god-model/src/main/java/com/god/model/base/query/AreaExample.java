package com.god.model.base.query;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * 行政区域表 示例类
 * 
 * @author God
 * @date 2019-08-10 16:13:42
 */
public class AreaExample implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	protected String orderByClause;
	
	protected boolean distinct;
	
	protected Integer start = Integer.valueOf(0);
	
	protected Integer end = Integer.valueOf(10000);
	
	protected List<Criteria> oredCriteria;
	
	public AreaExample() {
	    oredCriteria = new ArrayList<Criteria>();
	}
	
	public void setOrderByClause(String orderByClause) {
	    this.orderByClause = orderByClause;
	}
	
	public String getOrderByClause() {
	    return orderByClause;
	}
	
	public void setDistinct(boolean distinct) {
	    this.distinct = distinct;
	}
	
	public boolean isDistinct() {
	    return distinct;
	}
	
	public void setStart(Integer start) {
	    this.start = start;
	}
	
	public Integer getStart() {
	    return start;
	}
	
	public void setEnd(Integer end) {
	    this.end = end;
	}
	
	public Integer getEnd() {
	    return end;
	}
	
	public List<Criteria> getOredCriteria() {
	    return oredCriteria;
	}
	
	public void or(Criteria criteria) {
	    oredCriteria.add(criteria);
	}
	
	public Criteria or() {
	    Criteria criteria = createCriteriaInternal();
	    oredCriteria.add(criteria);
	    return criteria;
	}
	
	public Criteria createCriteria() {
	    Criteria criteria = createCriteriaInternal();
	    if (oredCriteria.size() == 0) {
	        oredCriteria.add(criteria);
	    }
	    return criteria;
	}
	
	protected Criteria createCriteriaInternal() {
	    Criteria criteria = new Criteria();
	    return criteria;
	}
	
	public void clear() {
	    oredCriteria.clear();
	    orderByClause = null;
	    distinct = false;
	}
	
	protected abstract static class GeneratedCriteria {
	    protected List<Criterion> criteria;
	
	    protected GeneratedCriteria() {
	        super();
	        criteria = new ArrayList<Criterion>();
	    }
	
	    public boolean isValid() {
	        return criteria.size() > 0;
	    }
	
	    public List<Criterion> getAllCriteria() {
	        return criteria;
	    }
	
	    public List<Criterion> getCriteria() {
	        return criteria;
	    }
	
	    protected void addCriterion(String condition) {
		    if (condition == null) {
		    	throw new RuntimeException("Value for condition cannot be null");
		    }
		    criteria.add(new Criterion(condition));
		}
	
		protected void addCriterion(String condition, Object value, String property) {
		    if (value == null) {
		        throw new RuntimeException("Value for " + property + " cannot be null");
		    }
		    criteria.add(new Criterion(condition, value));
		}
	
		protected void addCriterion(String condition, Object value1, Object value2, String property) {
		    if (value1 == null || value2 == null) {
		        throw new RuntimeException("Between values for " + property + " cannot be null");
		    }
		    criteria.add(new Criterion(condition, value1, value2));
		}
		
		public Criteria andIdIsNull() {
		    addCriterion("id is null");
		    return (Criteria) this;
		}
		public Criteria andIdIsNotNull() {
		    addCriterion("id is not null");
		    return (Criteria) this;
		}
		public Criteria andIdEqualTo(Integer value) {
		    addCriterion("id =", value, "id");
		    return (Criteria) this;
		}
		public Criteria andIdNotEqualTo(Integer value) {
		    addCriterion("id <>", value, "id");
		    return (Criteria) this;
		}
		public Criteria andIdGreaterThan(Integer value) {
		    addCriterion("id >", value, "id");
		    return (Criteria) this;
		}
		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
		    addCriterion("id >=", value, "id");
		    return (Criteria) this;
		}
		public Criteria andIdLessThan(Integer value) {
		    addCriterion("id <", value, "id");
		    return (Criteria) this;
		}
		
		public Criteria andIdLessThanOrEqualTo(Integer value) {
		    addCriterion("id <=", value, "id");
		    return (Criteria) this;
		}
		
		public Criteria andIdIn(List<Integer> values) {
		    addCriterion("id in", values, "id");
		    return (Criteria) this;
		}
		
		public Criteria andIdNotIn(List<Integer> values) {
		    addCriterion("id not in", values, "id");
		    return (Criteria) this;
		}
		
		public Criteria andIdBetween(Integer value1, Integer value2) {
		    addCriterion("id between", value1, value2, "id");
		    return (Criteria) this;
		}
		
		public Criteria andIdNotBetween(Integer value1, Integer value2) {
		    addCriterion("id not between", value1, value2, "id");
		    return (Criteria) this;
		}
		public Criteria andCodeIsNull() {
		    addCriterion("code is null");
		    return (Criteria) this;
		}
		public Criteria andCodeIsNotNull() {
		    addCriterion("code is not null");
		    return (Criteria) this;
		}
		public Criteria andCodeEqualTo(String value) {
		    addCriterion("code =", value, "code");
		    return (Criteria) this;
		}
		public Criteria andCodeNotEqualTo(String value) {
		    addCriterion("code <>", value, "code");
		    return (Criteria) this;
		}
		public Criteria andCodeGreaterThan(String value) {
		    addCriterion("code >", value, "code");
		    return (Criteria) this;
		}
		public Criteria andCodeGreaterThanOrEqualTo(String value) {
		    addCriterion("code >=", value, "code");
		    return (Criteria) this;
		}
		public Criteria andCodeLessThan(String value) {
		    addCriterion("code <", value, "code");
		    return (Criteria) this;
		}
		
		public Criteria andCodeLessThanOrEqualTo(String value) {
		    addCriterion("code <=", value, "code");
		    return (Criteria) this;
		}
		
		public Criteria andCodeLike(String value) {
		    addCriterion("code like", value, "code");
		    return (Criteria) this;
		}
		
		public Criteria andCodeNotLike(String value) {
		    addCriterion("code not like", value, "code");
		    return (Criteria) this;
		}
		
		public Criteria andCodeIn(List<String> values) {
		    addCriterion("code in", values, "code");
		    return (Criteria) this;
		}
		
		public Criteria andCodeNotIn(List<String> values) {
		    addCriterion("code not in", values, "code");
		    return (Criteria) this;
		}
		
		public Criteria andCodeBetween(String value1, String value2) {
		    addCriterion("code between", value1, value2, "code");
		    return (Criteria) this;
		}
		
		public Criteria andCodeNotBetween(String value1, String value2) {
		    addCriterion("code not between", value1, value2, "code");
		    return (Criteria) this;
		}
		public Criteria andParentCodeIsNull() {
		    addCriterion("parent_code is null");
		    return (Criteria) this;
		}
		public Criteria andParentCodeIsNotNull() {
		    addCriterion("parent_code is not null");
		    return (Criteria) this;
		}
		public Criteria andParentCodeEqualTo(String value) {
		    addCriterion("parent_code =", value, "parentCode");
		    return (Criteria) this;
		}
		public Criteria andParentCodeNotEqualTo(String value) {
		    addCriterion("parent_code <>", value, "parentCode");
		    return (Criteria) this;
		}
		public Criteria andParentCodeGreaterThan(String value) {
		    addCriterion("parent_code >", value, "parentCode");
		    return (Criteria) this;
		}
		public Criteria andParentCodeGreaterThanOrEqualTo(String value) {
		    addCriterion("parent_code >=", value, "parentCode");
		    return (Criteria) this;
		}
		public Criteria andParentCodeLessThan(String value) {
		    addCriterion("parent_code <", value, "parentCode");
		    return (Criteria) this;
		}
		
		public Criteria andParentCodeLessThanOrEqualTo(String value) {
		    addCriterion("parent_code <=", value, "parentCode");
		    return (Criteria) this;
		}
		
		public Criteria andParentCodeLike(String value) {
		    addCriterion("parent_code like", value, "parentCode");
		    return (Criteria) this;
		}
		
		public Criteria andParentCodeNotLike(String value) {
		    addCriterion("parent_code not like", value, "parentCode");
		    return (Criteria) this;
		}
		
		public Criteria andParentCodeIn(List<String> values) {
		    addCriterion("parent_code in", values, "parentCode");
		    return (Criteria) this;
		}
		
		public Criteria andParentCodeNotIn(List<String> values) {
		    addCriterion("parent_code not in", values, "parentCode");
		    return (Criteria) this;
		}
		
		public Criteria andParentCodeBetween(String value1, String value2) {
		    addCriterion("parent_code between", value1, value2, "parentCode");
		    return (Criteria) this;
		}
		
		public Criteria andParentCodeNotBetween(String value1, String value2) {
		    addCriterion("parent_code not between", value1, value2, "parentCode");
		    return (Criteria) this;
		}
		public Criteria andNameIsNull() {
		    addCriterion("name is null");
		    return (Criteria) this;
		}
		public Criteria andNameIsNotNull() {
		    addCriterion("name is not null");
		    return (Criteria) this;
		}
		public Criteria andNameEqualTo(String value) {
		    addCriterion("name =", value, "name");
		    return (Criteria) this;
		}
		public Criteria andNameNotEqualTo(String value) {
		    addCriterion("name <>", value, "name");
		    return (Criteria) this;
		}
		public Criteria andNameGreaterThan(String value) {
		    addCriterion("name >", value, "name");
		    return (Criteria) this;
		}
		public Criteria andNameGreaterThanOrEqualTo(String value) {
		    addCriterion("name >=", value, "name");
		    return (Criteria) this;
		}
		public Criteria andNameLessThan(String value) {
		    addCriterion("name <", value, "name");
		    return (Criteria) this;
		}
		
		public Criteria andNameLessThanOrEqualTo(String value) {
		    addCriterion("name <=", value, "name");
		    return (Criteria) this;
		}
		
		public Criteria andNameLike(String value) {
		    addCriterion("name like", value, "name");
		    return (Criteria) this;
		}
		
		public Criteria andNameNotLike(String value) {
		    addCriterion("name not like", value, "name");
		    return (Criteria) this;
		}
		
		public Criteria andNameIn(List<String> values) {
		    addCriterion("name in", values, "name");
		    return (Criteria) this;
		}
		
		public Criteria andNameNotIn(List<String> values) {
		    addCriterion("name not in", values, "name");
		    return (Criteria) this;
		}
		
		public Criteria andNameBetween(String value1, String value2) {
		    addCriterion("name between", value1, value2, "name");
		    return (Criteria) this;
		}
		
		public Criteria andNameNotBetween(String value1, String value2) {
		    addCriterion("name not between", value1, value2, "name");
		    return (Criteria) this;
		}
		public Criteria andAliasIsNull() {
		    addCriterion("alias is null");
		    return (Criteria) this;
		}
		public Criteria andAliasIsNotNull() {
		    addCriterion("alias is not null");
		    return (Criteria) this;
		}
		public Criteria andAliasEqualTo(String value) {
		    addCriterion("alias =", value, "alias");
		    return (Criteria) this;
		}
		public Criteria andAliasNotEqualTo(String value) {
		    addCriterion("alias <>", value, "alias");
		    return (Criteria) this;
		}
		public Criteria andAliasGreaterThan(String value) {
		    addCriterion("alias >", value, "alias");
		    return (Criteria) this;
		}
		public Criteria andAliasGreaterThanOrEqualTo(String value) {
		    addCriterion("alias >=", value, "alias");
		    return (Criteria) this;
		}
		public Criteria andAliasLessThan(String value) {
		    addCriterion("alias <", value, "alias");
		    return (Criteria) this;
		}
		
		public Criteria andAliasLessThanOrEqualTo(String value) {
		    addCriterion("alias <=", value, "alias");
		    return (Criteria) this;
		}
		
		public Criteria andAliasLike(String value) {
		    addCriterion("alias like", value, "alias");
		    return (Criteria) this;
		}
		
		public Criteria andAliasNotLike(String value) {
		    addCriterion("alias not like", value, "alias");
		    return (Criteria) this;
		}
		
		public Criteria andAliasIn(List<String> values) {
		    addCriterion("alias in", values, "alias");
		    return (Criteria) this;
		}
		
		public Criteria andAliasNotIn(List<String> values) {
		    addCriterion("alias not in", values, "alias");
		    return (Criteria) this;
		}
		
		public Criteria andAliasBetween(String value1, String value2) {
		    addCriterion("alias between", value1, value2, "alias");
		    return (Criteria) this;
		}
		
		public Criteria andAliasNotBetween(String value1, String value2) {
		    addCriterion("alias not between", value1, value2, "alias");
		    return (Criteria) this;
		}
		public Criteria andScopeIsNull() {
		    addCriterion("scope is null");
		    return (Criteria) this;
		}
		public Criteria andScopeIsNotNull() {
		    addCriterion("scope is not null");
		    return (Criteria) this;
		}
		public Criteria andScopeEqualTo(Integer value) {
		    addCriterion("scope =", value, "scope");
		    return (Criteria) this;
		}
		public Criteria andScopeNotEqualTo(Integer value) {
		    addCriterion("scope <>", value, "scope");
		    return (Criteria) this;
		}
		public Criteria andScopeGreaterThan(Integer value) {
		    addCriterion("scope >", value, "scope");
		    return (Criteria) this;
		}
		public Criteria andScopeGreaterThanOrEqualTo(Integer value) {
		    addCriterion("scope >=", value, "scope");
		    return (Criteria) this;
		}
		public Criteria andScopeLessThan(Integer value) {
		    addCriterion("scope <", value, "scope");
		    return (Criteria) this;
		}
		
		public Criteria andScopeLessThanOrEqualTo(Integer value) {
		    addCriterion("scope <=", value, "scope");
		    return (Criteria) this;
		}
		
		public Criteria andScopeIn(List<Integer> values) {
		    addCriterion("scope in", values, "scope");
		    return (Criteria) this;
		}
		
		public Criteria andScopeNotIn(List<Integer> values) {
		    addCriterion("scope not in", values, "scope");
		    return (Criteria) this;
		}
		
		public Criteria andScopeBetween(Integer value1, Integer value2) {
		    addCriterion("scope between", value1, value2, "scope");
		    return (Criteria) this;
		}
		
		public Criteria andScopeNotBetween(Integer value1, Integer value2) {
		    addCriterion("scope not between", value1, value2, "scope");
		    return (Criteria) this;
		}
		public Criteria andRegionTypeIsNull() {
		    addCriterion("region_type is null");
		    return (Criteria) this;
		}
		public Criteria andRegionTypeIsNotNull() {
		    addCriterion("region_type is not null");
		    return (Criteria) this;
		}
		public Criteria andRegionTypeEqualTo(Integer value) {
		    addCriterion("region_type =", value, "regionType");
		    return (Criteria) this;
		}
		public Criteria andRegionTypeNotEqualTo(Integer value) {
		    addCriterion("region_type <>", value, "regionType");
		    return (Criteria) this;
		}
		public Criteria andRegionTypeGreaterThan(Integer value) {
		    addCriterion("region_type >", value, "regionType");
		    return (Criteria) this;
		}
		public Criteria andRegionTypeGreaterThanOrEqualTo(Integer value) {
		    addCriterion("region_type >=", value, "regionType");
		    return (Criteria) this;
		}
		public Criteria andRegionTypeLessThan(Integer value) {
		    addCriterion("region_type <", value, "regionType");
		    return (Criteria) this;
		}
		
		public Criteria andRegionTypeLessThanOrEqualTo(Integer value) {
		    addCriterion("region_type <=", value, "regionType");
		    return (Criteria) this;
		}
		
		public Criteria andRegionTypeIn(List<Integer> values) {
		    addCriterion("region_type in", values, "regionType");
		    return (Criteria) this;
		}
		
		public Criteria andRegionTypeNotIn(List<Integer> values) {
		    addCriterion("region_type not in", values, "regionType");
		    return (Criteria) this;
		}
		
		public Criteria andRegionTypeBetween(Integer value1, Integer value2) {
		    addCriterion("region_type between", value1, value2, "regionType");
		    return (Criteria) this;
		}
		
		public Criteria andRegionTypeNotBetween(Integer value1, Integer value2) {
		    addCriterion("region_type not between", value1, value2, "regionType");
		    return (Criteria) this;
		}
		public Criteria andCreateTimeIsNull() {
		    addCriterion("create_time is null");
		    return (Criteria) this;
		}
		public Criteria andCreateTimeIsNotNull() {
		    addCriterion("create_time is not null");
		    return (Criteria) this;
		}
		public Criteria andCreateTimeEqualTo(Date value) {
		    addCriterion("create_time =", value, "createTime");
		    return (Criteria) this;
		}
		public Criteria andCreateTimeNotEqualTo(Date value) {
		    addCriterion("create_time <>", value, "createTime");
		    return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThan(Date value) {
		    addCriterion("create_time >", value, "createTime");
		    return (Criteria) this;
		}
		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
		    addCriterion("create_time >=", value, "createTime");
		    return (Criteria) this;
		}
		public Criteria andCreateTimeLessThan(Date value) {
		    addCriterion("create_time <", value, "createTime");
		    return (Criteria) this;
		}
		
		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
		    addCriterion("create_time <=", value, "createTime");
		    return (Criteria) this;
		}
		
		public Criteria andCreateTimeIn(List<Date> values) {
		    addCriterion("create_time in", values, "createTime");
		    return (Criteria) this;
		}
		
		public Criteria andCreateTimeNotIn(List<Date> values) {
		    addCriterion("create_time not in", values, "createTime");
		    return (Criteria) this;
		}
		
		public Criteria andCreateTimeBetween(Date value1, Date value2) {
		    addCriterion("create_time between", value1, value2, "createTime");
		    return (Criteria) this;
		}
		
		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
		    addCriterion("create_time not between", value1, value2, "createTime");
		    return (Criteria) this;
		}
		public Criteria andUpdateTimeIsNull() {
		    addCriterion("update_time is null");
		    return (Criteria) this;
		}
		public Criteria andUpdateTimeIsNotNull() {
		    addCriterion("update_time is not null");
		    return (Criteria) this;
		}
		public Criteria andUpdateTimeEqualTo(Date value) {
		    addCriterion("update_time =", value, "updateTime");
		    return (Criteria) this;
		}
		public Criteria andUpdateTimeNotEqualTo(Date value) {
		    addCriterion("update_time <>", value, "updateTime");
		    return (Criteria) this;
		}
		public Criteria andUpdateTimeGreaterThan(Date value) {
		    addCriterion("update_time >", value, "updateTime");
		    return (Criteria) this;
		}
		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
		    addCriterion("update_time >=", value, "updateTime");
		    return (Criteria) this;
		}
		public Criteria andUpdateTimeLessThan(Date value) {
		    addCriterion("update_time <", value, "updateTime");
		    return (Criteria) this;
		}
		
		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
		    addCriterion("update_time <=", value, "updateTime");
		    return (Criteria) this;
		}
		
		public Criteria andUpdateTimeIn(List<Date> values) {
		    addCriterion("update_time in", values, "updateTime");
		    return (Criteria) this;
		}
		
		public Criteria andUpdateTimeNotIn(List<Date> values) {
		    addCriterion("update_time not in", values, "updateTime");
		    return (Criteria) this;
		}
		
		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
		    addCriterion("update_time between", value1, value2, "updateTime");
		    return (Criteria) this;
		}
		
		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
		    addCriterion("update_time not between", value1, value2, "updateTime");
		    return (Criteria) this;
		}
	}
	
	public static class Criteria extends GeneratedCriteria {
	
	    protected Criteria() {
	        super();
	    }
	}
	
	public static class Criterion {
	    private String condition;
	
	    private Object value;
	
	    private Object secondValue;
	
	    private boolean noValue;
	
	    private boolean singleValue;
	
	    private boolean betweenValue;
	
	    private boolean listValue;
	
	    private String typeHandler;
	
	    public String getCondition() {
	        return condition;
	    }
	
	    public Object getValue() {
	        return value;
	    }
	
	    public Object getSecondValue() {
	        return secondValue;
	    }
	
	    public boolean isNoValue() {
	        return noValue;
	    }
	
	    public boolean isSingleValue() {
	        return singleValue;
	    }
	
	    public boolean isBetweenValue() {
	        return betweenValue;
	    }
	
	    public boolean isListValue() {
	        return listValue;
	    }
	
	    public String getTypeHandler() {
	        return typeHandler;
	    }
	
	    protected Criterion(String condition) {
	        super();
	        this.condition = condition;
	        this.typeHandler = null;
	        this.noValue = true;
	    }
	
	    protected Criterion(String condition, Object value, String typeHandler) {
	        super();
	        this.condition = condition;
	        this.value = value;
	        this.typeHandler = typeHandler;
	        if (value instanceof List<?>) {
	            this.listValue = true;
	        } else {
	            this.singleValue = true;
	        }
	    }
	
	    protected Criterion(String condition, Object value) {
	        this(condition, value, null);
	    }
	
	    protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
	        super();
	        this.condition = condition;
	        this.value = value;
	        this.secondValue = secondValue;
	        this.typeHandler = typeHandler;
	        this.betweenValue = true;
	    }
	
	    protected Criterion(String condition, Object value, Object secondValue) {
	        this(condition, value, secondValue, null);
	    }
	}
}



