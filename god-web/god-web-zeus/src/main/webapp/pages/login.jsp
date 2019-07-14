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
<link
	href="${pageContext.request.contextPath }/static/h-ui/css/H-ui.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/static/h-ui.admin/css/H-ui.login.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/static/h-ui.admin/css/style.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/lib/Hui-iconfont/1.0.8/iconfont.css"
	rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>后台登录 - God</title>
<meta name="keywords"
	content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description"
	content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="header"></div>
	<div class="loginWraper">
		<div id="loginform" 
			<c:if test="${empty currentLoginCheckNum || currentLoginCheckNum == 0}">class="loginBox2"</c:if>
			<c:if test="${currentLoginCheckNum > 0}">class="loginBox"</c:if>
		 >
			<form class="form form-horizontal" action="index.html" method="post">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input id="username" name="username" type="text" placeholder="账户"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input id="password" name="password" type="password"
							placeholder="密码" onkeydown="clientClickButton(event)" class="input-text size-L">
					</div>
				</div>
				
				<div id="verifyCodeDiv" class="row cls" <c:if test="${empty currentLoginCheckNum || currentLoginCheckNum == 0}">style="display:none;"</c:if> > 
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input id="verifyCode" name="verifyCode" class="input-text size-L"
							type="text" placeholder="验证码"
							onblur="if(this.value==''){this.value='验证码:'}"
							onkeydown="clientClickButton(event)"
							onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:"
							style="width: 150px;"> 
							<img id="imgVerifyCode" onclick="changeVerifyCode()"
							src="${pageContext.request.contextPath }/login/getVerifyCode">
						<a id="kanbuq" href="javascript:;" onclick="changeVerifyCode()">看不清，换一张</a>
					</div>
				</div>
				<!-- 
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<label for="online"> <input type="checkbox" name="online"
							id="online" value=""> 使我保持登录状态
						</label>
					</div>
				</div>
				 -->
				<div class="row cl">
					<div class="formControls col-xs-8 col-xs-offset-3">
						<button onclick="doLogin()" type="button"
							class="btn btn-success radius size-L">&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;</button>
						<button type="reset" class="btn btn-default radius size-L">&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright GOD by H-ui.admin v3.1</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript">
		//改变验证码事件
		function changeVerifyCode() {
			var img = document.getElementById('imgVerifyCode');
			img.src = "${pageContext.request.contextPath }/login/getVerifyCode?x="
					+ Math.floor(Math.random() * 100)
		}

		//提交验证并验证验证码
		function checkVerifyCode() {

			var input = document.getElementsByTagName('input')[0];

			//ajax提交
			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					alert(xhr.responseText);
				}
			}
			xhr.open('get',
					'${pageContext.request.contextPath }/checkVerifyCode?code='
							+ input.value);
			xhr.send(null);

		}

		//登录
		function doLogin() {

			var username = document.getElementById('username').value;
			var password = document.getElementById('password').value;
			var verifyCode = document.getElementById('verifyCode').value;
			var param = {};
			var data = {};
			data.username = username;
			data.password = password;
			data.verifyCode = verifyCode;
			param.data = data;

			// ajax提交
			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var resp = JSON.parse(xhr.responseText);
					if (resp.code != 0) {
						layer.msg(resp.msg, {
							icon : 2,
							time : 1000
						});
						showVerifyCode();
						changeVerifyCode();
						
						document.getElementById('verifyCode').value = '验证码:';
						// document.getElementById('password').value = "";
					} else {
						location.href = "${pageContext.request.contextPath }/home/index";
					}
				}
			}
			xhr.open('POST',
					'${pageContext.request.contextPath }/login/doLogin');
			// 设置 HTTP 头，数据指定为 JSON 格式
			xhr.setRequestHeader("Content-Type",
					"application/json;charset=UTF-8");
			xhr.send(JSON.stringify(param));
		}
		
		function showVerifyCode(){
			document.getElementById("loginform").classList.add("loginBox");
			document.getElementById("loginform").classList.remove("loginBox2");
			document.getElementById("verifyCodeDiv").style.display="block";
		}
		
		// 回车登录
		function clientClickButton(event) {
	        if (event.keyCode == 13) {
	        	doLogin();
	            event.returnValue = false;
	        }
		}
	</script>
</body>
</html>
