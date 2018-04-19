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
<title>分组计划信息</title>
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
				分组计划信息表
			</h3>
			<form id="my_form" method="post">
			<table class="table" id="my_table">
				<tr>
					<th>
						组号：
					</th>
					<td>
						<input name="process_id" type="text" id="process_id" value="${process_id}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>
						计划编号：
					</th>
					<td id="plan_id">
						<input name="plan_id" type="text" id="plan_id" value="${plan.plan_id}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>
						客户名称：
					</th>
					<td>
						<input name="process_cus" type="text" id="process_cus" value="${plan.cus_name}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>
						花色：
					</th>
					<td>
						<input name="process_color" type="text" id="process_color" value="${plan.co_name}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>
						产品规格：
					</th>
					<td>
						<input name="process_std" type="text" id="process_std" value="${plan.standard_name}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>
						产品类型：
					</th>
					<td>
						${plan.plan_type_name}
					</td>
				</tr>
				<tr>
					<th>
						计划产量：
					</th>
					<td>
						${plan.plan_num}
					</td>
				</tr>
				<tr>
					<th>
						未投坯产量：
					</th>
					<td>
						${plan.plan_nums}
					</td>
				</tr>
				<tr>
					<th>
						分组计划量：
					</th>
					<td>
						<input name="group_num" id="group_num"/>
					</td>
				</tr>
			</table>
		<input name="plan_nums" type="hidden" id="plan_nums" value="${plan.plan_nums}"/>
		</form>
		</div>
	</div>
<script type="text/javascript">
/* 	$(document).ready(function(){
		layui.use('laydate', function(){
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem:"#plan_month"
				,type:"month"
				,min:(function(){
					var nowdate = new Date();
					var years = nowdate.getFullYear();
					var months = nowdate.getMonth() + 2;
					return years+"-"+months+"-1";
				})(),
			});
		});
	}); */
</script>

</body>
</html>