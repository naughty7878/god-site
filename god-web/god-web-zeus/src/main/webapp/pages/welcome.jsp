<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>我的桌面</title>
</head>
<body>
	<div class="page-container">
		<p class="f-20 text-success">
			欢迎使用 God 后台管理系统 <span class="f-14"></span>
		</p>
		<p>登录次数：${empty currentLoginUserLog ? 1 : currentLoginUserLog.times + 1}</p>
		<p>上次登录IP：${empty currentLoginUserLog ? '无' : currentLoginUserLog.loginIp } 上次登录时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
            value="${currentLoginUserLog.createTime}" /></p>
		<table class="table table-border table-bordered table-bg mt-20">
			<thead>
				<tr>
					<th colspan="2" scope="col">服务器信息</th>
				</tr>
			</thead>
			<tbody>
				
				<tr>
					<td width="30%">用户的账户名称</td>
					<td>${user_name }</td>
				</tr>
				<tr>
					<td>用户的主目录</td>
					<td>${user_home }</td>
				</tr>
				<tr>
					<td>用户的当前工作目录</td>
					<td>${user_dir }</td>
				</tr>
				<tr>
					<td>本地ip地址</td>
					<td>${ip }</td>
				</tr>
				<tr>
					<td>本地主机名</td>
					<td>${hostName }</td>
				</tr>
				<tr>
					<td>JVM可以使用的总内存</td>
					<td>${totalMemory }</td>
				</tr>
				<tr>
					<td>JVM可以使用的剩余内存</td>
					<td>${freeMemory }</td>
				</tr>
				<tr>
					<td>JVM可以使用的处理器个数名</td>
					<td>${availableProcessors }</td>
				</tr>
				<tr>
					<td>Java的运行环境版本</td>
					<td>${java_version }</td>
				</tr>
				<tr>
					<td>Java的运行环境供应商</td>
					<td>${java_vendor }</td>
				</tr>
				<tr>
					<td>Java的安装路径</td>
					<td>${java_home }</td>
				</tr>
				<tr>
					<td>Java运行时环境规范版本</td>
					<td>${java_specification_version }</td>
				</tr>
				<tr>
					<td>Java运行时环境规范名称</td>
					<td>${java_specification_name }</td>
				</tr>
				
				<tr>
					<td>操作系统的名称</td>
					<td>${os_name }</td>
				</tr>
				<tr>
					<td>操作系统的构架</td>
					<td>${os_arch }</td>
				</tr>
				<tr>
					<td>操作系统的版本称</td>
					<td>${os_version }</td>
				</tr>
				<tr>
					<td>文件分隔符</td>
					<td>${file_separator }</td>
				</tr>
				<tr>
					<td>路径分隔符</td>
					<td>${path_separator }</td>
				</tr>
				<tr>
					<td>行分隔符</td>
					<td>${line_separator }</td>
				</tr>
				<tr>
					<td >当前SessionID</td>
					<td>${pageContext.session.id }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<footer class="footer mt-20">
		<div class="container">
			<p>
				Copyright &copy;2015-2017 H-ui.admin v3.1 All Rights Reserved.<br>
				本后台系统由<a href="http://www.h-ui.net/" target="_blank"
					title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持
			</p>
		</div>
	</footer>
	<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui/js/H-ui.min.js"></script>
</body>
</html>