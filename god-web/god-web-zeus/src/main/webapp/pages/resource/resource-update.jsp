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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>资源编辑 - God</title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-resource-add">
	<input type="hidden" name="id" value="${godResource.id }">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>资源：</label>
		<div class="formControls col-xs-8 col-sm-9">   
			<input type="text" class="input-text" value="${godResource.name }" placeholder="" id="resourceName" name="resourceName" readonly="readonly">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">描述：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<textarea name="description" cols="" rows="" class="textarea"  placeholder="说点什么...100个字符以内" dragonfly="true" onKeyUp="$.Huitextarealength(this,100)" >${godResource.description }</textarea>
			<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
		<div class="formControls col-xs-8 col-sm-9 skin-minimal">
			<div class="radio-box">
				<input name="status" type="radio" id="status-1"  value="1" <c:if test="${godResource.status == 1}">checked</c:if> > 
				<label for="status-1">启用</label>
			</div>
			<div class="radio-box">
				<input type="radio" id="status-2" name="status" value="0" <c:if test="${godResource.status == 0}">checked</c:if>>
				<label for="status-2">禁用</label>
			</div>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>父级ID：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${godResource.parentId }" placeholder="" id="parentId" name="parentId" >
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">级别：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
			<select class="select" name="level" size="1">
				<option value="1" <c:if test="${godResource.level == 1}">selected="selected"</c:if> >1</option>
				<option value="2" <c:if test="${godResource.level == 2}">selected="selected"</c:if> >2</option>
				<option value="3" <c:if test="${godResource.level == 3}">selected="selected"</c:if> >3</option>
			</select>
			</span> </div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>url地址：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${godResource.url }" placeholder="" id="url" name="url">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>图标：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${godResource.icon }" placeholder="" id="icon" name="icon">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>排序：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<input type="text" class="input-text" value="${godResource.sort }" placeholder="" id="sort" name="sort">
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-resource-add").validate({
		rules:{
			resourceName:{
				required:true,
				minlength:4,
				maxlength:16
			},
			status:{
				required:true,
			},
			sort:{
				required:true
			},
			level:{
				required:true,
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var id = $('input[name="id"]').val();
			var name = $('input[name="resourceName"]').val();
			var description = $('textarea[name="description"]').val();
			var status = $('input[name="status"]:checked').val();
			var parentId = $('input[name="parentId"]').val();
			var level = $('select[name="level"]').val();
			var url = $('input[name="url"]').val();
			var icon = $('input[name="icon"]').val();
			var sort = $('input[name="sort"]').val();
			
			data = {};
			data.id = id;
			data.name = name;
			data.description = description;
			data.status = status;
			data.parentId = parentId;
			data.level = level;
			data.url = url;
			data.icon = icon;
			data.sort = sort;
		    param = {};
		    param.data = data;
		    $.ajax({
				type:'post',
				url: '${pageContext.request.contextPath }/resource/update' ,
				contentType:'application/json;charset=utf-8',
				data: JSON.stringify(param),
				dataType:"json",
				success: function(data){
					if(data.code == 0){
						layer.msg('更新成功!',{icon:1,time:1000});
						console.log(parent);
						var index = parent.layer.getFrameIndex(window.name);
						console.log(parent.$('.btn-refresh'));
						parent.$('.btn-refresh').click();
						parent.layer.close(index);
					}else {
						layer.msg(data.msg, { icon : 2, time : 1000 });
					}
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('error!',{icon:2,time:1000});
				}
			});
		}
	});
});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>