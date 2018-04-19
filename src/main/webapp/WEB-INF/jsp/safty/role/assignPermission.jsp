<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../../css/bootstrap.min.css" rel="stylesheet" media="all">
<link href="../../layui/css/layui.css" rel="stylesheet" media="all">
<script src="../../js/jquery-3.2.1.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../layui/layui.js" charset="utf-8"></script>
<title>角色详情表</title>
<style type="text/css">
	html{height:100%;width:100%;}
	body{
		height:100%;
		width:100%;
		position:relative;
		background-color:#E8E8E8;
	}
	.my_taskDetail{
		display:inline-block;
		height:100%;
		width:300px;
		position:absolute;
		top:0;
		left:0;
		bottom:0;
		border-right: 2px solid #ffffff;
	} 
	#my_table{
		position:absolute;
		width:80%;
		height:30%;
		left:10%;
		top:80px;
	}
	.my_check{
		position:relative;
		top:450px;
		left:250px;
	}
	.my_taskAssign{
		display:inline-block;
		height:100%;
		width:450px;
		position:absolute;
		top:0;
		left: 305px;
		buttom:0;
	}
	table{
		position:absolute;
		left:20px;
		top:40px;
	}
</style>
</head>
<body>
 	<div class="my_taskDetail">
		<div class="col-md-12 column">
			<h3 class="text-center">
				角色详情
			</h3>
			<table class="table" id="my_table">
				<tr>
					<th>
						角色编号：
					</th>
					<td>
						${Role.ro_id}
					</td>
				</tr>
				<tr>
					<th>
						角色名称：
					</th>
					<td>
						${Role.ro_name}
					</td>
				</tr>
				<tr>
					<th>
						角色备注：
					</th>
					<td>
						<textarea name="t_content" rows="3"  class="form-control" readonly="readonly">${Role.ro_remark}</textarea>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="my_taskAssign">
		<h3 class="text-center">
			分配权限
		</h3>
		<form method="post" action="">
		<table  class="table table-hover">
			<tr>
				<th>权限名称</th><th>操作</th>
			</tr>
			<c:forEach items="${AllPermission}" var="ap">
			<tr>
				<td>${ap.m_name}</td>
				<td>
				<input  type="checkbox"  name="m_id" value="${ap.m_id}" id="${ap.m_id}" 
			  		onclick="toAssign('${ap.m_id}', '${Role.ro_id}')" 
					<c:if test="${ap.has}">checked</c:if>
				/>
			</tr>
			</c:forEach>	
		</table>>
		</form>
	</div>
<script type="text/javascript">
	function toAssign(m_id, ro_id){
		console.log(m_id);
		if(document.getElementById(m_id).checked){//$('#'+m_id)
			$.ajax({
				url:"doAssign.do",
				data:"m_id="+m_id+"&ro_id="+ro_id,
				method:"get",
				dataType: "json"
			}).done(function(result){
				if(result.success){
					cache:false;
					layui.use("layer", function(){
						var layer = layui.layer;
						layer.msg(result.msg, {icon:1});
					});
				}
			})
		}else{
			$.ajax({
				url:"doUnAssign.do",
				data:"m_id="+m_id+"&ro_id="+ro_id,
				method:"get",
				dataType: "json"
			}).done(function(result){
				if(result.success){
					cache:false;
					layui.use("layer", function(){
						var layer = layui.layer;
						layer.msg(result.msg, {icon:1});
					});
				}
			})
		}
	}
	</script>
</body>
</html>