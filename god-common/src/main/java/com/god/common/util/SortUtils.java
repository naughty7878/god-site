package com.god.common.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 排序工具类
 * 
 * @author H__D
 * @date 2019-06-13 16:04:01
 *
 */
public class SortUtils {

	/**
	 * 根据属性名，排序
	 * 
	 * @param list     集合
	 * @param field    属性名
	 * @param sortFlag 排序标识： 0升序 1降序
	 */
	public static <T> void sortListByField(List<T> list, String field, int sortFlag) {

		String methodName = null;
		if (field != null && field.trim().length() > 0) {
			if (Character.isUpperCase(field.charAt(0)))
				methodName = "get" + field;
			else
				methodName = "get" + (new StringBuilder()).append(Character.toUpperCase(field.charAt(0)))
						.append(field.substring(1)).toString();

			sortListByMethod(list, methodName, sortFlag);
		}
	}

	/**
	 * 根据方法名返回值，排序
	 * 
	 * @param list       集合
	 * @param methodName 方法名
	 * @param sortFlag   排序标识： 0升序 1降序
	 */
	public static <T> void sortListByMethod(List<T> list, final String methodName, final int sortFlag) {

		if (methodName == null || methodName.trim().length() == 0) {
			return;
		}
		if (list != null && list.size() > 0) {
			try {
				// 根据方法名，利用反射获取方法
				final Method method = list.get(0).getClass().getMethod(methodName, new Class[0]);
				list.sort(new Comparator<T>() {
					public int compare(T o1, T o2) {
						int n = 0;
						try {
							// 调用对象的方法的到返回值
							Object v1 = method.invoke(o1, new Object[0]);
							Object v2 = method.invoke(o2, new Object[0]);

							if (v1 instanceof Integer) {
								n = ((Integer) v1).compareTo((Integer) v2);
							} else if (v1 instanceof String) {
								n = ((String) v1).compareTo((String) v2);
							} else if (v1 instanceof Double) {
								n = ((Double) v1).compareTo((Double) v2);
							} else if (v1 instanceof Float) {
								n = ((Float) v1).compareTo((Float) v2);
							} else if (v1 instanceof Long) {
								n = ((Long) v1).compareTo((Long) v2);
							} else if (v1 instanceof Boolean) {
								n = ((Boolean) v1).compareTo((Boolean) v2);
							} else if (v1 instanceof Date) {
								n = ((Date) v1).compareTo((Date) v2);
							} else if (v1 instanceof BigDecimal) {
								n = ((BigDecimal) v1).compareTo((BigDecimal) v2);
							}
							if (sortFlag != 0) {
								n = n * -1;
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return n;
					}
				});

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
