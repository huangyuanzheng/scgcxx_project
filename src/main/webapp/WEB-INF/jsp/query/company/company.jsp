<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成品包装</title>
<link href="../../layui/css/layui.css" rel="stylesheet" media="all">
<link href="../../css/bootstrap.min.css" rel="stylesheet" media="all">
<script src="../../js/jquery-3.2.1.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../layui/layui.js" charset="utf-8"></script>
<style type="text/css">	
	.my_serach{
		padding-top:2px;
		padding-left:20px;
		width:100%;
		height:40px;
		border: 1px solid #A0A0A0;
		background:#D0D0D0;
		font-size: 15px;
		
	}
	.form-control{
		width:120px;
		height: 28px;
		display: inline-block;
	}
	.my_options{
		padding-left:20px;
		margin-bottom:0;
		width:100%;
		height:45px;
		border: 1px solid #A0A0A0;
		background:#D0D0D0;
		font-size: 15px;
	}
	.my_options button{
		margin-top: 5px;
	}
	.btn btn-default dropdown-toggle btn-lg{
		height: 22px;
		display: inline-block;
	}
</style>
</head>
<body>
<form action="toList.do" method="get">
<div class="my_serach">
     <span>请输入日期<span class="glyphicon glyphicon-hand-right"></span></span>
      <input name="check_date" value="${check_date}" id="date" lay-verify="date" class="form-control" placeholder="yyyy-MM-dd" type="text">
    <button id="dyn_query"  class="btn btn-info">
			<i class="layui-icon">&#xe615;</i>搜索
	</button>
</div> 
</form> 
<div class="my_options">
	<button type="button" class="btn btn-success" aria-hidden="true" id="sss">
		<span class="glyphicon glyphicon-print"></span>&nbsp;&nbsp;导出	
	</button>
</div>

	<p>报表部门：计划科 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;报表人：${check_person}
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	报表时间：${check_date}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;生产日期：${check_date}
	<table class="layui-table">
		 <colgroup>
    	<col width="150">
    	<col width="200">
    	<col>
  		</colgroup>
  	<thead>
    	<tr>
      	<th>序号</th><th>订单号</th><th>规格</th><th>投胚量</th><th>成品量</th><th>一等品</th>
      	<th>二等品</th><th>三等品</th><th>等外品</th><th>合格率</th>
      	</tr> 
  </thead>
  		 <c:forEach items="${companys}" var="company" varStatus="vs">
  			<tr>
  			<td align="center">${vs.count }</td>
  			<td align="center">${company.plan_id}</td>
  			<td align="center">${company.standard_name}</td>
  			<td align="center">${company.num_group}</td>
  			<td align="center">${company.num_check}</td>
  			<td align="center">${company.yd_product}</td>
  			<td align="center">${company.ed_product}</td>
  			<td align="center">${company.sd_product}</td>
  			<td align="center">${company.dw_product}</td>
  			<td align="center">${company.qulifed_rate}</td>
  			</tr>
  		</c:forEach> 
  		<tr>
  			<td colspan="3" align="center">合计</td>
  			<td align="center">${companyLast.num_group}</td>
  			<td align="center">${companyLast.num_check}</td>
  			<td align="center">${companyLast.yd_product}</td>
  			<td align="center">${companyLast.ed_product}</td>
  			<td align="center">${companyLast.sd_product}</td>
  			<td align="center">${companyLast.dw_product}</td>
  			<td align="center">${companyLast.qulifed_rate}</td>
  		</tr>
	</table>
<script src="../../layui/layui.js" charset="utf-8"></script>
<script src="../../js/jquery-3.2.1.min.js"></script>
<script >
var check_date = $('#date').val();
$('#sss').click(function(){
	location.href='toListXls.do?check_date='+check_date;
})
</script>
<script>
	$(".trd").each(function(i) {
		this.innerHTML = i + 1
	})
	var j = 0;
	$(".trd1").each(function() {
		j = Number($(this).html()) + j;
	})
	$(".td1").html(j)

	var k = 0;
	$(".trd2").each(function() {
		k = Number($(this).html()) + k;
	})
	$(".td2").html(k)
	
	var m = 0;
	$(".trd3").each(function() {
		m = Number($(this).html()) + m;
	})
	$(".td3").html(m)
	
	var n = 0;
	$(".trd4").each(function() {
		n = Number($(this).html()) + n;
	})
	$(".td4").html(n)
	
	var s = 0;
	$(".trd5").each(function() {
		s = Number($(this).html()) + s;
	})
	$(".td5").html(s)
	
	var p = 0;
	$(".trd6").each(function() {
		p = Number($(this).html()) + p;
	})
	$(".td6").html(p)
	$(".td7").html(String(m/j).substring(0,5))

	/* $("#b1").on("click",function(){
	alert.(1);
	return false;
	}) */
	
</script>
<script>
layui.use(['laydate'], function(){
	var laydate = layui.laydate;
	 laydate.render({
		    elem: '#date'
		  })
})

</script>
<script type="text/javascript">
/* function f1(){
	
}  */
/* $("#b1").click(function(){
	alert.(33);
	return false;
}) */
</script>
</body>
</html>