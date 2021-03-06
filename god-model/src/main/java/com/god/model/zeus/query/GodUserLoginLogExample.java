package com.god.model.zeus.query;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户登录日志表 示例类
 * 
 * @author God
 * @date 2019-08-10 18:52:39
 */
public class GodUserLoginLogExample implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	protected String orderByClause;
	
	protected boolean distinct;
	
	protected Integer start = Integer.valueOf(0);
	
	protected Integer end = Integer.valueOf(10000);
	
	protected List<Criteria> oredCriteria;
	
	public GodUserLoginLogExample() {
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
		public Criteria andIdEqualTo(Long value) {
		    addCriterion("id =", value, "id");
		    return (Criteria) this;
		}
		public Criteria andIdNotEqualTo(Long value) {
		    addCriterion("id <>", value, "id");
		    return (Criteria) this;
		}
		public Criteria andIdGreaterThan(Long value) {
		    addCriterion("id >", value, "id");
		    return (Criteria) this;
		}
		public Criteria andIdGreaterThanOrEqualTo(Long value) {
		    addCriterion("id >=", value, "id");
		    return (Criteria) this;
		}
		public Criteria andIdLessThan(Long value) {
		    addCriterion("id <", value, "id");
		    return (Criteria) this;
		}
		
		public Criteria andIdLessThanOrEqualTo(Long value) {
		    addCriterion("id <=", value, "id");
		    return (Criteria) this;
		}
		
		public Criteria andIdIn(List<Long> values) {
		    addCriterion("id in", values, "id");
		    return (Criteria) this;
		}
		
		public Criteria andIdNotIn(List<Long> values) {
		    addCriterion("id not in", values, "id");
		    return (Criteria) this;
		}
		
		public Criteria andIdBetween(Long value1, Long value2) {
		    addCriterion("id between", value1, value2, "id");
		    return (Criteria) this;
		}
		
		public Criteria andIdNotBetween(Long value1, Long value2) {
		    addCriterion("id not between", value1, value2, "id");
		    return (Criteria) this;
		}
		public Criteria andUserIdIsNull() {
		    addCriterion("user_id is null");
		    return (Criteria) this;
		}
		public Criteria andUserIdIsNotNull() {
		    addCriterion("user_id is not null");
		    return (Criteria) this;
		}
		public Criteria andUserIdEqualTo(Long value) {
		    addCriterion("user_id =", value, "userId");
		    return (Criteria) this;
		}
		public Criteria andUserIdNotEqualTo(Long value) {
		    addCriterion("user_id <>", value, "userId");
		    return (Criteria) this;
		}
		public Criteria andUserIdGreaterThan(Long value) {
		    addCriterion("user_id >", value, "userId");
		    return (Criteria) this;
		}
		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
		    addCriterion("user_id >=", value, "userId");
		    return (Criteria) this;
		}
		public Criteria andUserIdLessThan(Long value) {
		    addCriterion("user_id <", value, "userId");
		    return (Criteria) this;
		}
		
		public Criteria andUserIdLessThanOrEqualTo(Long value) {
		    addCriterion("user_id <=", value, "userId");
		    return (Criteria) this;
		}
		
		public Criteria andUserIdIn(List<Long> values) {
		    addCriterion("user_id in", values, "userId");
		    return (Criteria) this;
		}
		
		public Criteria andUserIdNotIn(List<Long> values) {
		    addCriterion("user_id not in", values, "userId");
		    return (Criteria) this;
		}
		
		public Criteria andUserIdBetween(Long value1, Long value2) {
		    addCriterion("user_id between", value1, value2, "userId");
		    return (Criteria) this;
		}
		
		public Criteria andUserIdNotBetween(Long value1, Long value2) {
		    addCriterion("user_id not between", value1, value2, "userId");
		    return (Criteria) this;
		}
		public Criteria andLoginIpIsNull() {
		    addCriterion("login_ip is null");
		    return (Criteria) this;
		}
		public Criteria andLoginIpIsNotNull() {
		    addCriterion("login_ip is not null");
		    return (Criteria) this;
		}
		public Criteria andLoginIpEqualTo(String value) {
		    addCriterion("login_ip =", value, "loginIp");
		    return (Criteria) this;
		}
		public Criteria andLoginIpNotEqualTo(String value) {
		    addCriterion("login_ip <>", value, "loginIp");
		    return (Criteria) this;
		}
		public Criteria andLoginIpGreaterThan(String value) {
		    addCriterion("login_ip >", value, "loginIp");
		    return (Criteria) this;
		}
		public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
		    addCriterion("login_ip >=", value, "loginIp");
		    return (Criteria) this;
		}
		public Criteria andLoginIpLessThan(String value) {
		    addCriterion("login_ip <", value, "loginIp");
		    return (Criteria) this;
		}
		
		public Criteria andLoginIpLessThanOrEqualTo(String value) {
		    addCriterion("login_ip <=", value, "loginIp");
		    return (Criteria) this;
		}
		
		public Criteria andLoginIpLike(String value) {
		    addCriterion("login_ip like", value, "loginIp");
		    return (Criteria) this;
		}
		
		public Criteria andLoginIpNotLike(String value) {
		    addCriterion("login_ip not like", value, "loginIp");
		    return (Criteria) this;
		}
		
		public Criteria andLoginIpIn(List<String> values) {
		    addCriterion("login_ip in", values, "loginIp");
		    return (Criteria) this;
		}
		
		public Criteria andLoginIpNotIn(List<String> values) {
		    addCriterion("login_ip not in", values, "loginIp");
		    return (Criteria) this;
		}
		
		public Criteria andLoginIpBetween(String value1, String value2) {
		    addCriterion("login_ip between", value1, value2, "loginIp");
		    return (Criteria) this;
		}
		
		public Criteria andLoginIpNotBetween(String value1, String value2) {
		    addCriterion("login_ip not between", value1, value2, "loginIp");
		    return (Criteria) this;
		}
		public Criteria andTimesIsNull() {
		    addCriterion("times is null");
		    return (Criteria) this;
		}
		public Criteria andTimesIsNotNull() {
		    addCriterion("times is not null");
		    return (Criteria) this;
		}
		public Criteria andTimesEqualTo(Integer value) {
		    addCriterion("times =", value, "times");
		    return (Criteria) this;
		}
		public Criteria andTimesNotEqualTo(Integer value) {
		    addCriterion("times <>", value, "times");
		    return (Criteria) this;
		}
		public Criteria andTimesGreaterThan(Integer value) {
		    addCriterion("times >", value, "times");
		    return (Criteria) this;
		}
		public Criteria andTimesGreaterThanOrEqualTo(Integer value) {
		    addCriterion("times >=", value, "times");
		    return (Criteria) this;
		}
		public Criteria andTimesLessThan(Integer value) {
		    addCriterion("times <", value, "times");
		    return (Criteria) this;
		}
		
		public Criteria andTimesLessThanOrEqualTo(Integer value) {
		    addCriterion("times <=", value, "times");
		    return (Criteria) this;
		}
		
		public Criteria andTimesIn(List<Integer> values) {
		    addCriterion("times in", values, "times");
		    return (Criteria) this;
		}
		
		public Criteria andTimesNotIn(List<Integer> values) {
		    addCriterion("times not in", values, "times");
		    return (Criteria) this;
		}
		
		public Criteria andTimesBetween(Integer value1, Integer value2) {
		    addCriterion("times between", value1, value2, "times");
		    return (Criteria) this;
		}
		
		public Criteria andTimesNotBetween(Integer value1, Integer value2) {
		    addCriterion("times not between", value1, value2, "times");
		    return (Criteria) this;
		}
		public Criteria andCityIsNull() {
		    addCriterion("city is null");
		    return (Criteria) this;
		}
		public Criteria andCityIsNotNull() {
		    addCriterion("city is not null");
		    return (Criteria) this;
		}
		public Criteria andCityEqualTo(String value) {
		    addCriterion("city =", value, "city");
		    return (Criteria) this;
		}
		public Criteria andCityNotEqualTo(String value) {
		    addCriterion("city <>", value, "city");
		    return (Criteria) this;
		}
		public Criteria andCityGreaterThan(String value) {
		    addCriterion("city >", value, "city");
		    return (Criteria) this;
		}
		public Criteria andCityGreaterThanOrEqualTo(String value) {
		    addCriterion("city >=", value, "city");
		    return (Criteria) this;
		}
		public Criteria andCityLessThan(String value) {
		    addCriterion("city <", value, "city");
		    return (Criteria) this;
		}
		
		public Criteria andCityLessThanOrEqualTo(String value) {
		    addCriterion("city <=", value, "city");
		    return (Criteria) this;
		}
		
		public Criteria andCityLike(String value) {
		    addCriterion("city like", value, "city");
		    return (Criteria) this;
		}
		
		public Criteria andCityNotLike(String value) {
		    addCriterion("city not like", value, "city");
		    return (Criteria) this;
		}
		
		public Criteria andCityIn(List<String> values) {
		    addCriterion("city in", values, "city");
		    return (Criteria) this;
		}
		
		public Criteria andCityNotIn(List<String> values) {
		    addCriterion("city not in", values, "city");
		    return (Criteria) this;
		}
		
		public Criteria andCityBetween(String value1, String value2) {
		    addCriterion("city between", value1, value2, "city");
		    return (Criteria) this;
		}
		
		public Criteria andCityNotBetween(String value1, String value2) {
		    addCriterion("city not between", value1, value2, "city");
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



