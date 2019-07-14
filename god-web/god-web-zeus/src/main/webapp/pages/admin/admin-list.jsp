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
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/h-ui.admin/skin/default/skin.css"
	id="skin" />
<link rel="stylesheet" type="text/css" ref="${pageContext.request.contextPath }/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/lib/layui/css/layui.css" media="all">
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>管理员列表 - God</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		管理员管理 <span class="c-gray en">&gt;</span> 管理员列表 <a
			class="btn btn-success btn-refresh btn-refresh radius r"
			style="line-height: 1.6em; margin-top: 3px"
			onclick="javascript:location.replace(location.href);"
			href="javascript:;" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container" id="user-container">
		<div class="text-c">
			日期范围： <input type="text"
				onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })"
				id="datemin" class="input-text Wdate" style="width: 120px;">
			- <input type="text"
				onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })"
				id="datemax" class="input-text Wdate" style="width: 120px;">
			<input type="text" class="input-text" style="width: 250px"
				placeholder="输入管理员名称" id="" name="username">
			<button onclick="search_admin()" type="submit" class="btn btn-success" id="search-user-btn" name="">
				<i class="Hui-iconfont">&#xe665;</i> 搜用户
			</button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l">
				<!-- <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>批量删除</a> --> 
				<a href="javascript:;" onclick="admin_add('添加管理员','${pageContext.request.contextPath }/admin/toAdd','800','500')"
				class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
					添加管理员</a></span> <span class="r">
			</span>
		</div>
		<table id="user-table" class="table table-border table-bordered table-bg" >
			<thead>
				<tr>
					<th scope="col" colspan="9">员工列表</th>
				</tr>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="40">ID</th>
					<th width="150">登录名</th>
					<th width="150">昵称</th>
					<th width="150">邮箱</th>
					<th>角色</th>
					<th width="130">加入时间</th>
					<th width="100">是否已启用</th>
					<th width="100">操作</th>
				</tr>


			</thead>
			<tbody>
				<%-- <c:forEach var="user" items="${pageResult.rows }">
					<tr class="text-c">
						<td><input type="checkbox" value="1" name=""></td>
						<td>${user.id }</td>
						<td>${user.name }</td>
						<td>${user.nickname }</td>
						<td>无</td>
						<td>无</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
								value="${user.createTime}" /></td>
						<td class="td-status"><span class="label label-success radius">已启用</span></td>
						<td class="td-manage"><a style="text-decoration: none"
							onClick="admin_stop(this,'10001')" href="javascript:;" title="停用"><i
								class="Hui-iconfont">&#xe631;</i></a> <a title="编辑"
							href="javascript:;"
							onclick="admin_edit('管理员编辑','admin-add.html','1','800','500')"
							class="ml-5" style="text-decoration: none"><i
								class="Hui-iconfont">&#xe6df;</i></a> <a title="删除"
							href="javascript:;" onclick="admin_del(this,'1')" class="ml-5"
							style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
				</c:forEach> --%>
			</tbody>
		</table>
		<!-- 存放分页的容器 -->
		<div id="layui" style="text-align:center"></div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/lib/datatables/1.10.15/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/lib/laypage/1.2/laypage.js"></script>
	<script src="${pageContext.request.contextPath }/lib/layui/layui.js"></script>
	<script type="text/javascript">
		
		/*管理员-删除*/
		function admin_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : 'POST',
					url : '',
					dataType : 'json',
					success : function(data) {
						$(obj).parents("tr").remove();
						layer.msg('已删除!', {
							icon : 1,
							time : 1000
						});
					},
					error : function(data) {
						console.log(data.msg);
					},
				});
			});
		}

		
		
	</script>
	<script type="text/javascript">
		$(function() {
			var page_js = {
				init : function() {
					this.cacheElements();
					this.bindEvents();
					this.initLoadEvent();
				},
				cacheElements : function() {
					
					this.$userContainer = $('#user-container');
					this.$userTable = $('#user-table');
				},
				bindEvents : function() {

					//this.$accountPanel.on('click','.editBankCard',this.openEditBankCard);
				},
				
				initLoadEvent : function() {
					initLayPage();
				}
			};
			//初始化
			page_js.init();
		});
		
		function initLayPage(pageConf) {
			var beginDate = $('#datemin').val();
			var endDate = $('#datemax').val();
			var name = $('input[name="username"]').val();
		    if (!pageConf) {
		        pageConf = {};
		        pageConf.pageSize = 10;
		        pageConf.pageNum = 1;
		        pageConf.beginDate = beginDate;
		        pageConf.endDate = endDate;
		        pageConf.name = name;
		    }
		    param = {};
		    param.data = pageConf;
		    $.ajax({
				type:'post',
				url:'${pageContext.request.contextPath }/admin/pageList',
				contentType:'application/json;charset=utf-8',
				data: JSON.stringify(param),
				dataType:"json",
				success:function(data){//返回json结果
					if(data.code == 0){
						//执行一个laypage实例
				        layui.use(['laypage', 'layer'], function () {
				        	var laypage = layui.laypage;
				        	laypage.render({
				                elem: 'layui',
				                count: data.data.total,
				                curr: data.data.pageNum,
				                limit: data.data.pageSize,
				                first: "首页",
				                last: "尾页",
				                layout: ['count', 'prev', 'page', 'next', 'limit', 'skip'],
				                jump: function (obj, first) {
				                    if (!first) {
				                        pageConf.pageNum = obj.curr;
				                        pageConf.pageSize = obj.limit;
				                        initLayPage(pageConf);
				                    }
				                }
				            });
				            fillTable(data.data.rows, (pageConf.pageNum - 1) * pageConf.pageSize); //页面填充
				        });
					}else {
						console.log(data);
						console.log(typeof data);
						layer.msg(data.msg, {
							icon : 2,
							time : 1000
						});
					}
		    }});
		}    

		//填充表格数据
		function fillTable(data, num) {
		    $("#user-table tbody").html('');
		    $.each(data, function (index, obj) {
		        // id 很多时候并不是连续的，如果为了显示比较连续的记录数，可以这样根据当前页和每页条数动态的计算记录序号
		        index = index + num + 1;
		        var info = '';
		        info += '<tr class="text-c">';
		        info += '<td><input type="checkbox" value="1" name=""></td>';
		        info += '<td>' + obj.id + '</td>';
		        info += '<td>' + obj.name + '</td>';
		        info += '<td>' + obj.nickname + '</td>';
		        info += '<td>无</td>';
		        info += '<td>无</td>';
		        info += '<td>' + obj.createTime + '</td>';
		        info += (obj.status == 1 ? '<td class="td-status"><span class="label label-success radius">已启用</span></td>' : '<td class="td-status"><span class="label label-default radius">已禁用</span></td>');
		        info += '<td class="td-manage">';
		        info += (obj.status == 1 ? '<a style="text-decoration: none" onClick="admin_stop(this,'+ obj.id +')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>' : '<a onclick="admin_start(this,'+ obj.id +')" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
		        info += '<a title="编辑" href="javascript:;" onclick="admin_update(\'管理员编辑\',\'${pageContext.request.contextPath }/admin/toUpdate/'+ obj.id +'\',' + obj.id + ',\'800\', \'500\')" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">&#xe6df;</i></a>';
		        // info += '<a title="删除" href="javascript:;" onclick="admin_del(this,\'1\')" class="ml-5" style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
		        info += '</td>';
		        info += '</tr>';
		        $("#user-table tbody").append(info);
		    });
		}
		/*管理员-查询*/
		function search_admin(pageConf){
			var beginDate = $('#datemin').val();
			var endDate = $('#datemax').val();
			var name = $('input[name="username"]').val();
		    if (!pageConf) {
		        pageConf = {};
		        pageConf.pageSize = 10;
		        pageConf.pageNum = 1;
		        pageConf.beginDate = beginDate;
		        pageConf.endDate = endDate;
		        pageConf.name = name;
		    }
		    
		    initLayPage(pageConf);
		}
		
		/*管理员-停用*/
		function admin_stop(obj, id) {
			layer.confirm('确认要停用吗？',function(index) {
				$.ajax({
					type:'post',
					url:'${pageContext.request.contextPath }/admin/update',
					contentType:'application/json;charset=utf-8',
					data: JSON.stringify({"data": {"id": id, "status": 0}}),
					success:function(data){//返回json结果
						if(data.code == 0) {
							//此处请求后台程序，下方是成功后的前台处理……
							$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
							$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
							$(obj).remove();
							layer.msg('已停用!', {
								icon : 5,
								time : 1000
							});
						}else {
							layer.msg(data.msg, {
								icon : 2,
								time : 1000
							});
						}
					}
				});
			});
		}

		/*管理员-启用*/
		function admin_start(obj, id) {
			layer.confirm('确认要启用吗？',function(index) {
				$.ajax({
					type:'post',
					url:'${pageContext.request.contextPath }/admin/update',
					contentType:'application/json;charset=utf-8',
					data: JSON.stringify({"data": {"id": id, "status": 1}}),
					success:function(data){//返回json结果
						if(data.code == 0) {
							//此处请求后台程序，下方是成功后的前台处理……
							$(obj).parents("tr").find(".td-manage").prepend( '<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
							$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
							$(obj).remove();
							layer.msg('已启用!', {
								icon : 6,
								time : 1000
							});
						}else {
							layer.msg(data.msg, {
								icon : 2,
								time : 1000
							});
						}
					}
				});
			});
		}
		
		/*
		 参数解释：
		 title	标题
		 url		请求的url
		 id		需要操作的数据id
		 w		弹出层宽度（缺省调默认值）
		 h		弹出层高度（缺省调默认值）
		 */
		/*管理员-增加*/
		function admin_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*管理员-编辑*/
		function admin_update(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
	</script>
</body>
</html>