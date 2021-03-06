<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.johe.scgcxx.model.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../../css/bootstrap.min.css" rel="stylesheet" media="all">
<link href="../../layui/css/layui.css" rel="stylesheet" media="all">
<script src="../../js/jquery-3.2.1.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../layui/layui.js" charset="utf-8"></script>
<title>添加用户信息</title>
<style type="text/css">
	html{height:100%;width:100%;}
	body{
		height:100%;
		width:100%;
		background-color:#E8E8E8;
	}
	.my_container{
		height:100%;
		width:100%;
		position:relative;
		top:0;
		left:0;
		bottom:0;
		border:3px solid #ffffff;
	} 
	#my_table{
		position:absolute;
		width:80%;
		height:30%;
		left:15%;
		buttom:2%;
		top:80px;
	}
	.text-center{
		postion:absolute;
		padding-top: 30px;
	}
</style>
</head>
<body>
	<div class="my_container">
		<div class="col-md-12 column">
			<h3 class="text-center">
				新增用户信息表
			</h3>
			<form id="my_form" method="post">
			<table class="table" id="my_table">
				<tr>
					<th>
						编号：
					</th>
					<td>
						<input name="u_id" type="text" maxlength="8" id="user_id">
					</td>
				</tr>
				<tr>
					<th>
						名称：
					</th>
					<td>
						<input name="u_name" type="text" maxlength="10" id="user_name">
					</td>
				</tr>
				<tr>
					<th>
						密码：
					</th>
					<td>
						<input name="u_pwd" type="password" value="123456" maxlength="10" id="user_pwd" readonly="readonly">
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
<script type="text/javascript">
	/* function myfunction() {
		var emp_id = document.getElementById('user_id').value;
		var emp_name = document.getElementById('user_name').value;
		if (emp_id == null || emp_id === "") {
			layui.use('layer', function() {
				var layer = layui.layer;
				layer.alert('角色编号不能为空', {
					title : 'Alert',
					icon : 1,
					anim: 6,
					yes : function(index, layero) {
						//do something
						layer.close(index); //如果设定了yes回调，需进行手工关闭
					}
				});
			});
			return false;
		}
		if (emp_name == null || emp_name === "") {
			layui.use('layer', function() {
				var layer = layui.layer;
				layer.alert('角色名称不能为空', {
					title : 'Alert',
					icon : 1,
					anim: 6,
					yes : function(index, layero) {
						//do something
						layer.close(index); //如果设定了yes回调，需进行手工关闭
					}
				});
			});
			return false;
		}
		layui.use('layer', function() {
			var layer = layui.layer;
			layer.confirm("确认新增角色吗？", {
				title : "温馨提示：",
				icon : 1,
				anim : 5,
			}, function(index) {
				//提交表单
				var my_form = document.getElementById("my_form");
				my_form.action = "doAdd.do";
				my_form.submit();
				layer.close(index);
			});
		});
	} */
</script>

</body>
</html>