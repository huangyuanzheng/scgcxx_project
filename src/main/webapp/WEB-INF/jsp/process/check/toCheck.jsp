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
<title>质检信息</title>
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
				质检信息表
			</h3>
			<form id="my_form" method="post">
			<input name="process_id" type="hidden" id="process_id" value="${check.process_id}"/>
			<table class="table" id="my_table">
				<tr>
					<th>
						组号：
					</th>
					<td>
						${check.process_id}
					</td>
				</tr>
				<tr>
					<th>
						客户名称：
					</th>
					<td>
						${check.process_cus}
					</td>
				</tr>
				<tr>
					<th>
						花色：
					</th>
					<td>
						${check.process_color}
					</td>
				</tr>
				<tr>
					<th>
						产品规格：
					</th>
					<td>
						${check.process_std}
					</td>
				</tr>
				<tr>
					<th>
						生产产量：
					</th>
					<td>
						<input value="${check.arrange_num}" name="arrange_num" id="arrange_num" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>
						尚未质检量：
					</th>
					<td>
						<input value="${product_noCheck}" name="product_noCheck" id="product_noCheck" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>
						一等品：
					</th>
					<td>
						<input name="product_first" id="product_first" type="text">
					</td>
				</tr>
				<tr>
					<th>
						二等品：
					</th>
					<td>
						<input name="product_second" id="product_second" type="text">
					</td>
				</tr>
				<tr>
					<th>
						三等品：
					</th>
					<td>
						<input name="product_third" id="product_third" type="text">
					</td>
				</tr>
				<tr>
					<th>
						等外品：
					</th>
					<td>
						<input name="product_subStandard" id="product_subStandard" type="text">
					</td>
				</tr>
			</table>
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