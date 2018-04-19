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
<title>添加计划信息</title>
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
				新增计划信息表
			</h3>
			<form id="my_form" method="post">
			<table class="table" id="my_table">
				<tr>
					<th>
						计划编号：
					</th>
					<td>
						<input name="plan_id" type="text" id="plan_id" value="${plan_id}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>
						客户名称：
					</th>
					<td>
						<select name="cus_id" id="cus_id">
							<option value="">--请选择--</option>
							<c:if test="${allCustomer != null}">
								<c:forEach items="${allCustomer}" var="customer">
								<option value="${customer.cus_id}">${customer.cus_name}</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						颜色：
					</th>
					<td>
						<select name="co_id" id="co_id">
							<option value="">--请选择--</option>
							<c:if test="${allColor != null}">
								<c:forEach items="${allColor}" var="color">
									<option value="${color.co_id}">${color.co_name}</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						产品规格：
					</th>
					<td>
						<select name="standard_id" id="standard_id">
							<option value="">--请选择--</option>
							<c:if test="${allStandard != null}">
								<c:forEach items="${allStandard}" var="standard">
								<option value="${standard.standard_id}">${standard.standard_name}</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						生产序列号：
					</th>
					<td>
						<input name="plan_xh" type="text" id="plan_xh" value="${plan_xh}" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th>
						计划月份：
					</th>
					<td>
						<input name="plan_month" id="plan_month">
					</td>
				</tr>
				<tr>
					<th>
						计划产量：
					</th>
					<td>
						<input name="plan_num" id="plan_num">
					</td>
				</tr>
				<tr>
					<th>
						产品类型：
					</th>
					<td>
						<select name="plan_type" id="plan_type">
							<option value="">--请选择--</option>
							<option value="1">白布产品</option>
							<option value="2">染色产品</option>
							<option value="3">无底色印花产品</option>
							<option value="4">有底色印花产品</option>
						</select>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
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
	});
</script>

</body>
</html>