package com.god.common.util;

/**
 * 字符串工具类
 * 
 * @author H__D
 * @date 2018-09-07 00:14:54
 *
 */
public class StringUtils {

	/**
	 * 判断字符串是否是空白的 以下情况为真 1、null 2、”“ 3、” “
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * 判断字符串是否为空 null || “”
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}

	/**
	 * 删除字符串最后一个字符
	 * 
	 * @param str
	 * @return
	 */
	public static String subEndChar(String str) {
		if (str == null || str.length() == 0)
			return str;
		return str.substring(0, str.length() - 1);
	}

	/**
	 * 删除字符串第一个字符
	 * @param str
	 * @return
	 */
	public static String subBeginChar(String str) {
		if(str == null || str.length() == 0) 
			return str;
		return str.substring(1);
	}

}
