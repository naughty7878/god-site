package com.god.common.util.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 地址编码工具类
 * @author H__D
 * @date 2018-09-16 10:11:23
 *
 */
public class URLCodeUtils {
	
	public static final String UTF8 = "UTF-8";
	
	/**
	 * 对url进行urlencode编码，采用utf-8的格式
	 * 
	 * @param url 请求地址
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encode(String url) throws UnsupportedEncodingException {
		return URLEncoder.encode( url, UTF8);
	}
	
	/**
	 * 对url进行urlencode编码
	 * 
	 * @param url 请求地址
	 * @param charset 编码格式
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encode(String url, String charset) throws UnsupportedEncodingException {
		return URLEncoder.encode( url, charset);
	}
	
	/**
	 * 对url进行urldecode解码， 默认解码格式utf-8
	 * 
	 * @param url 请求地址
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String url) throws UnsupportedEncodingException {
		return URLDecoder.decode(url, UTF8);
	}
	
	/**
	 * 对url进行urldecode解码
	 * 
	 * @param url 请求地址
	 * @param charset 解码格式
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String url, String charset) throws UnsupportedEncodingException {
		return URLDecoder.decode(url, charset);
	}
	
	
	public static void main(String[] args) throws IOException {
		String encode = URLCodeUtils.encode("aaa##");
		String decode = URLCodeUtils.decode(encode);
		System.out.println(decode);
		//System.out.println(URLCodeUtil.decode(null));
	}

}
