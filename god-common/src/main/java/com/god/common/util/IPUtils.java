package com.god.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

/**
 * IP工具类
 * 
 * @author HD
 * @time Oct 16, 2015
 * 
 * 
 */
public class IPUtils {


	/**
	 * 
	 * 获取IP地址 可获得多级代理的ip地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {

		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if(ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")){  
                //根据网卡取本机配置的IP  
                InetAddress inet=null;  
                try {  
                    inet = InetAddress.getLocalHost();  
                } catch (UnknownHostException e) {  
                    e.printStackTrace();  
                }  
                ip= inet.getHostAddress();  
            }
		}
		// 如果是多级代理，那么取第一个ip为客户ip
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(0, ip.indexOf(",")).trim();
		}
		return ip;

	}

	/**
	 * 根据IP地址,访问http://www.ip.cn.并返回该IP地址的归属地.
	 * 
	 * @param str
	 *            IP地址.
	 * @return 返回IP地址的归属地.可能会包含网络商名.
	 */
	public synchronized static String getCityFromIP(String str) {
		if (str == null || str.trim().length() == 0) {
			return null;
		}
		String urlStr = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=" + str;
		String content = getHttpContent(urlStr);
		if (content != null && content.trim().length() > 0 && content.contains("{")) {

			System.out.println(content);
//			JSONObject jsonObject = JSONObject.fromObject(content);
//			if (jsonObject.containsKey("city")) {
//				return jsonObject.get("city").toString();
//			}
		}
		return null;
	}

	/**
	 * @param urlStr
	 *            请求的地址
	 * @param content
	 *            请求的参数 格式为：name=xxx&pwd=xxx
	 * @param encoding
	 *            服务器端请求编码。如GBK,UTF-8等
	 * @return
	 */
	public static String getHttpContent(String urlStr) {
		URL url = null;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();// 新建连接实例
			connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
			connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫秒
			connection.setDoOutput(true);// 是否打开输出流 true|false
			connection.setDoInput(true);// 是否打开输入流true|false
			connection.setRequestMethod("POST");// 提交方法POST|GET
			connection.setRequestProperty("Content-Type", "text/html;charset=UTF-8");
			connection.setUseCaches(false);// 是否缓存true|false
			connection.connect();// 打开连接端口
			// DataOutputStream out = new DataOutputStream(connection
			// .getOutputStream());// 打开输出流往对端服务器写数据
			// out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
			// out.flush();// 刷新
			// out.close();// 关闭输出流
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));// 往对端写完数据对端服务器返回数据
			// ,以BufferedReader流来读取
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append("\n");
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();// 关闭连接
			}
		}
		return null;
	}

	/**
	 * unicode 转换成 中文
	 * 
	 * @param theString
	 * @return
	 */
	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException("Malformed      encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}

	/**
	 * 判断是否为IP地址
	 * 
	 * @param addr
	 * @return
	 */
	public static boolean isIPAddr(String addr) {
		if (addr == null || addr.trim().length() == 0)
			return false;
		String[] ips = addr.split(".");
		if (ips.length != 4)
			return false;
		try {
			int ipa = Integer.parseInt(ips[0]);
			int ipb = Integer.parseInt(ips[1]);
			int ipc = Integer.parseInt(ips[2]);
			int ipd = Integer.parseInt(ips[3]);
			return ipa >= 0 && ipa <= 255 && ipb >= 0 && ipb <= 255 && ipc >= 0 && ipc <= 255 && ipd >= 0 && ipd <= 255;
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * 利用谷歌测试网络是否连通 ping
	 * ，一般情况下Windows系统返回的TTL值在100-130之间，而UNIX/Linux系统返回的TTL值在240-255之间。
	 * 
	 * @return
	 */
	public static boolean checkInternet() {
		String address = "www.google.cn";
		StringBuffer sb = new StringBuffer();
		try {
			Runtime runtime = Runtime.getRuntime();// 返回与当前 Java 应用程序相关的运行时对象。
			// 判断主机类型
			String strAddress = null;
			if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1)// window系统
			{
				strAddress = "ping -n 5 www.google.cn";
			} else { // Linux系统
				strAddress = "ping -c 5 www.google.cn";
			}
			Process process = runtime.exec(strAddress); // 得到进程
			InputStream is = process.getInputStream();// 得到输入流
			InputStreamReader isr = new InputStreamReader(is);// 得到字符输入流
			BufferedReader br = new BufferedReader(isr);// 得到字符缓存输入流
			String connectionStr = br.readLine();
			while (connectionStr != null) {
				sb.append(connectionStr);
				connectionStr = br.readLine();
			}
			br.close();
			isr.close();
			is.close();
		} catch (IOException e) {
			// System.out.println("连接错误");
			e.printStackTrace();
		} finally {
			// 判断是否连通
			if (sb.toString().toLowerCase().indexOf("ttl") >= 0)
				return true;
			else
				return false;
		}

	}

	/**
	 * InetAddress :此类表示互联网协议 (IP) 地址。
	 * 
	 * @return 本机的
	 */
	public static InetAddress getLocalInetAddress() {
		try {
			return InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// System.out.println("unknown host");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 返回 IP 地址字符串（以文本表现形式）。
	 * 
	 * @param inetAddress
	 * @return
	 */
	public static String getHostIP(InetAddress inetAddress) {
		if (inetAddress == null)
			return null;
		String ip = inetAddress.getHostAddress(); // 得到ip地址
		return ip;
	}

	/**
	 * 获取此 IP 地址的主机名。
	 * 
	 * @param inetAddress
	 * @return
	 */
	public static String getHostName(InetAddress inetAddress) {
		if (inetAddress == null)
			return null;
		String name = inetAddress.getHostName(); // 得到主机名称
		return name;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InetAddress localInetAddress = IPUtils.getLocalInetAddress();
		String hostIP = IPUtils.getHostIP(localInetAddress);
		System.out.println(getCityFromIP(hostIP));
	}

}
