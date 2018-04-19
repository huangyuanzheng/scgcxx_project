<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>打包信息表</title>
<style type="text/css">	
	.form-control{
		width:120px;
		height: 28px;
		display: inline-block;
	}
	.btn btn-default dropdown-toggle btn-lg{
		height: 22px;
		display: inline-block;
	}
</style>
</head>
<body>
	<input id="product_id" class="form-control" type="hidden" name="product_id"  value="${product_id}"/>
	<table class="layui-table" id="demo"  lay-filter="test"></table>
	<script>
/* 	$(document).ready(function(){
 		layui.use('laydate', function(){
			var laydate = layui.laydate;
			//执行一个laydate实例
			laydate.render({
				elem:"#my_month"
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
	layui.use('table', function(){
		 var table = layui.table;
		 var id = $("#product_id").val();
		 var tableIns = table.render({
			id:'itDemo'
		    ,elem: '#demo'
		    ,url:'StoreList.do'
		    ,where:{product_id : id}
		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度
		    ,page:true
		    ,limit:10
		    ,limits:[5, 10, 15, 20]
		    ,cols: [[ 
	          {field: 'store_id', title: '包装号', width: 80, align: 'center'}
	          ,{field: 'product_id', title: '成品号', width: 80, align: 'center'}
	          ,{field: 'store_cus', title: '客户', width: 100, align: 'center'}
	          ,{field: 'store_std', title: '规格号', width: 100, align: 'center'}
	          ,{field: 'store_color', title: '颜色号', width: 100, align: 'center'}
	          ,{field: 'store_num', title:'包装量', width:80, align:'center'}
	          ,{field: 'store_status_name', title: '状态 ', width: 80, align: 'center'}
		    ]]
		  });
	});
	</script>
</body>
</html>