<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>角色编辑 - God</title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container" style="margin-right:300px;">
	<form class="form form-horizontal" id="form-role-add">
	<input type="hidden" name="id" value="${godRole.id }">
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>角色：</label>
		<div class="formControls col-xs-8 col-sm-9">   
			<input type="text" class="input-text" value="${godRole.name }" placeholder="" id="roleName" name="name" readonly="readonly">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">描述：</label>
		<div class="formControls col-xs-8 col-sm-9">
			<textarea name="description" cols="" rows="" class="textarea"  placeholder="说点什么...100个字符以内" dragonfly="true" onKeyUp="$.Huitextarealength(this,100)" >${godRole.description }</textarea>
			<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
		</div>
	</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
	
</article>
<div class="pos-a" style="width:300px;right:0;top:0; bottom:0; height:100%; border-right:1px solid #e5e5e5; background-color:#f5f5f5; overflow:auto;">
	<nav class="breadcrumb">
		资源分配
	</nav>
	<ul id="treeDemo" class="ztree"></ul>
</div>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
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
	
	$("#form-role-add").validate({
		rules:{
			roleName:{
				required:true,
				minlength:4,
				maxlength:16
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var id = $('input[name="id"]').val();
			var name = $('input[name="name"]').val();
			var description = $('textarea[name="description"]').val();
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"); //获取zTree对象
			var checkedNodes = zTree.getCheckedNodes();
			var resourceIds = [];
			$.each(checkedNodes, function (index, obj) {
				//console.log(obj);
				resourceIds.push(obj.id);
			});
			
			var data = {};
			data.id = id;
			data.name = name;
			data.description = description;
			data.resourceIds = resourceIds;
		    param = {};
		    param.data = data;
		    $.ajax({
				type:'post',
				url: '${pageContext.request.contextPath }/role/update' ,
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

var setting = {
	view: {
		dblClickExpand: false, //双击节点时，是否自动展开父节点的标识
		showLine: true,//是否显示节点之间的连线
		selectedMulti: true //设置是否允许同时选中多个节点
	},
	check:{
		//chkboxType: { "Y": "ps", "N": "ps" },
		chkStyle: "checkbox",//复选框类型
		enable: true //每个节点上是否显示 CheckBox 
	},
	data: {
		simpleData: {
            enable: true,//是否采用简单数据模式
            idKey: "id",//树节点ID名称
            pIdKey: "parentId",//父节点ID名称
            rootPId: 0,//根节点ID
        }
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				//demoIframe.attr("src",treeNode.file + ".html");
				return true;
			}
		}
	}
};

/* var zNodes =[
	{ id:1, pId:0, name:"一级分类", open:true},
	{ id:11, pId:1, name:"二级分类"},
	{ id:111, pId:11, name:"三级分类"},
	{ id:112, pId:11, name:"三级分类"},
	{ id:113, pId:11, name:"三级分类"},
	{ id:114, pId:11, name:"三级分类"},
	{ id:115, pId:11, name:"三级分类"},
	{ id:12, pId:1, name:"二级分类 1-2"},
	{ id:121, pId:12, name:"三级分类 1-2-1"},
	{ id:122, pId:12, name:"三级分类 1-2-2"},
]; */
		
		
$(document).ready(function(){
	$.ajax({
		type:'post',
		url: '${pageContext.request.contextPath }/resource/getAvailableTreeList' ,
		contentType:'application/json;charset=utf-8',
		dataType:"json",
		success: function(data){
			if(data.code == 0){
				initZTree(data.data);
				checkNode();
			}else {
				layer.msg(data.msg, { icon : 2, time : 1000 });
			}
		},
        error: function(XmlHttpRequest, textStatus, errorThrown){
			layer.msg('error!',{icon:2,time:1000});
		}
	});
});
function initZTree(zNodes){
	var t = $("#treeDemo");
	t = $.fn.zTree.init(t, setting, zNodes);
	//demoIframe = $("#testIframe");
	//demoIframe.on("load", loadReady);
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"); //获取zTree对象
	//zTree.selectNode(zTree.getNodeByParam("id",'11'));
}

function checkNode(){
	var roleId = $('input[name="id"]').val();
	var data = {};
	data.roleId = roleId;
	var param = {};
	param.data = data;
	$.ajax({
		type:'post',
		url: '${pageContext.request.contextPath }/resource/selectByRoleId' ,
		contentType:'application/json;charset=utf-8',
		data: JSON.stringify(param),
		dataType:"json",
		success: function(data){
			if(data.code == 0){
				// console.log(data.data);
				var zTree = $.fn.zTree.getZTreeObj("treeDemo"); //获取zTree对象
				//zTree.selectNode(zTree.getNodeByParam("id",'11'));
				$.each(data.data, function (index, obj) {
					// console.log(zTree.getNodeByParam("id",obj.id));
					zTree.checkNode(zTree.getNodeByParam("id",obj.id),true,false);
				});
			}else {
				layer.msg(data.msg, { icon : 2, time : 1000 });
			}
		},
        error: function(XmlHttpRequest, textStatus, errorThrown){
			layer.msg('error!',{icon:2,time:1000});
		}
	});
}


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>