package com.god.service.base.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.god.service.base.BaseSysService;

@Service
public class BaseSysServiceImpl implements BaseSysService {

	@Override
	public Map<String, Object> getSysProperty() throws UnknownHostException {
		Runtime r = Runtime.getRuntime();
		Properties props = System.getProperties();
		InetAddress addr;
		addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress();
		Map<String, String> envMap = System.getenv();
		String userName = envMap.get("USERNAME");// 获取用户名
		String computerName = envMap.get("COMPUTERNAME");// 获取计算机名
		String userDomain = envMap.get("USERDOMAIN");// 获取计算机域名
		
		Map<String, Object> map = new HashMap<>();
//		map.put("userName", userName);
//		map.put("computerName", computerName);
//		map.put("userDomain", userDomain);
		map.put("ip", ip);
		map.put("hostName", addr.getHostName());
		map.put("totalMemory", r.totalMemory());
		map.put("freeMemory", r.freeMemory());
		map.put("availableProcessors", r.availableProcessors());
		map.put("java_version", props.getProperty("java.version"));
		map.put("java_vendor", props.getProperty("java.vendor"));
		map.put("java_vendor_url", props.getProperty("java_vendor.url"));
		map.put("java_home", props.getProperty("java.home"));
		map.put("java_vm_specification.version", props.getProperty("java.vm.specification.version"));
		map.put("java_vm_specification.vendor", props.getProperty("java.vm.specification.vendor"));
		map.put("java_vm_specification.name", props.getProperty("java.vm.specification.name"));
		map.put("java_vm_version", props.getProperty("java.vm.version"));
		map.put("java_vm_vendor", props.getProperty("java.vm.vendor"));
		map.put("java_vm_name", props.getProperty("java.vm.name"));
		map.put("java_specification_version", props.getProperty("java.specification.version"));
		map.put("java_specification_vender", props.getProperty("java.specification.vender"));
		map.put("java_specification_name", props.getProperty("java.specification.name"));
		map.put("java_class_version", props.getProperty("java.class.version"));
		map.put("java_class_path", props.getProperty("java.class.path"));
		map.put("java_library_path", props.getProperty("java.library.path"));
		map.put("java_io_tmpdir", props.getProperty("java.io.tmpdir"));
		map.put("java_ext_dirs", props.getProperty("java.ext.dirs"));
		map.put("os_name", props.getProperty("os.name"));
		map.put("os_arch", props.getProperty("os.arch"));
		map.put("os_version", props.getProperty("os.version"));
		map.put("file_separator", props.getProperty("file.separator"));
		map.put("path_separator", props.getProperty("path.separator"));
		map.put("line_separator", props.getProperty("line.separator"));
		map.put("user_name", props.getProperty("user.name"));
		map.put("user_home", props.getProperty("user.home"));
		map.put("user_dir", props.getProperty("user.dir"));
		
//		System.out.println("用户名:    " + userName);
//		System.out.println("计算机名:    " + computerName);
//		System.out.println("计算机域名:    " + userDomain);
//		System.out.println("本地ip地址:    " + ip);
//		System.out.println("本地主机名:    " + addr.getHostName());
//		System.out.println("JVM可以使用的总内存:    " + r.totalMemory());
//		System.out.println("JVM可以使用的剩余内存:    " + r.freeMemory());
//		System.out.println("JVM可以使用的处理器个数:    " + r.availableProcessors());
//		System.out.println("Java的运行环境版本：    " + props.getProperty("java.version"));
//		System.out.println("Java的运行环境供应商：    " + props.getProperty("java.vendor"));
//		System.out.println("Java供应商的URL：    " + props.getProperty("java.vendor.url"));
//		System.out.println("Java的安装路径：    " + props.getProperty("java.home"));
//		System.out.println("Java的虚拟机规范版本：    " + props.getProperty("java.vm.specification.version"));
//		System.out.println("Java的虚拟机规范供应商：    " + props.getProperty("java.vm.specification.vendor"));
//		System.out.println("Java的虚拟机规范名称：    " + props.getProperty("java.vm.specification.name"));
//		System.out.println("Java的虚拟机实现版本：    " + props.getProperty("java.vm.version"));
//		System.out.println("Java的虚拟机实现供应商：    " + props.getProperty("java.vm.vendor"));
//		System.out.println("Java的虚拟机实现名称：    " + props.getProperty("java.vm.name"));
//		System.out.println("Java运行时环境规范版本：    " + props.getProperty("java.specification.version"));
//		System.out.println("Java运行时环境规范供应商：    " + props.getProperty("java.specification.vender"));
//		System.out.println("Java运行时环境规范名称：    " + props.getProperty("java.specification.name"));
//		System.out.println("Java的类格式版本号：    " + props.getProperty("java.class.version"));
//		System.out.println("Java的类路径：    " + props.getProperty("java.class.path"));
//		System.out.println("加载库时搜索的路径列表：    " + props.getProperty("java.library.path"));
//		System.out.println("默认的临时文件路径：    " + props.getProperty("java.io.tmpdir"));
//		System.out.println("一个或多个扩展目录的路径：    " + props.getProperty("java.ext.dirs"));
//		System.out.println("操作系统的名称：    " + props.getProperty("os.name"));
//		System.out.println("操作系统的构架：    " + props.getProperty("os.arch"));
//		System.out.println("操作系统的版本：    " + props.getProperty("os.version"));
//		System.out.println("文件分隔符：    " + props.getProperty("file.separator"));
//		System.out.println("路径分隔符：    " + props.getProperty("path.separator"));
//		System.out.println("行分隔符：    " + props.getProperty("line.separator"));
//		System.out.println("用户的账户名称：    " + props.getProperty("user.name"));
//		System.out.println("用户的主目录：    " + props.getProperty("user.home"));
//		System.out.println("用户的当前工作目录：    " + props.getProperty("user.dir"));
		
		return map;
	}

}
