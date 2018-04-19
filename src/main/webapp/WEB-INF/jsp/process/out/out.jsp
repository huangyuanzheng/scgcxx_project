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
<title>入库信息表</title>
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
	.btn btn-default dropdown-toggle btn-lg{
		height: 22px;
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
	.layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
     top: 50%;
     transform: translateY(-50%);
	}
</style>
</head>
<body>
	<div class="my_serach">
		<span>状态<span class="glyphicon glyphicon-hand-right"></span></span>
		<select class="btn btn-default dropdown-toggle" id="my_status">
			<option  value="2">全部</option>
   			<option  value="0" selected="selected">未提货</option>
   			<option value="1">已提货</option>
   		</select>
		<span>组号<span class="glyphicon glyphicon-hand-right"></span></span>
		<input id="my_process" class="form-control" type="text"  value="${param.store_id}"/>
		<button id="dyn_query"  class="btn btn-info" data-type="reload">
			<i class="layui-icon">&#xe615;</i>查询
		</button>
	</div>
	<table class="layui-table" id="demo"  lay-filter="test"></table>
	<script type="text/html" id="barDemo">
		{{#  if(d.store_status_name == '已入库'){ }}
		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="assign">提货</a>
		{{#  } }}
	</script>
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
		 var tableIns = table.render({
			id:'itDemo'
		    ,elem: '#demo'
		    ,url:'doList.do'
		    ,where:{store_status : "0"}
		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度
		    ,page:true
		    ,limit:10
		    ,limits:[5, 10, 15, 20]
		    ,cols: [[ 
		          {field: 'store_id', title: '包装号', width: 100, align: 'center'}
		          ,{field: 'product_id', title: '成品号', width: 100, align: 'center'}
		          ,{field: 'store_cus', title: '客户', width: 180, align: 'center'}
		          ,{field: 'store_std', title: '规格号', width: 180, align: 'center'}
		          ,{field: 'store_color', title: '颜色号', width: 180, align: 'center'}
		          ,{field: 'store_num', title:'包装量', width:150, align:'center'}
		          ,{field: 'out_date', title:'提货日期', width:150, align:'center'}
		          ,{field: 'out_person', title:'提货登记人', width:130, align:'center'}
		          ,{field: 'store_status_name', title: '状态 ', width: 150, align: 'center'}
		          ,{fixed: 'right', title: '操作', align:'center', toolbar: '#barDemo'}
		    ]]
		  });
		  table.on('tool(test)', function(obj){	//tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			  var data = obj.data;	//获取当前行数据
			  var layEvent = obj.event;	//获取lay-event对应的值（也可以是表头的event参数对应的值）
			  var tr = obj.tr;	//获取当前行tr的dom对象
			  if(layEvent === 'assign'){
			  		layer.confirm('确认提交吗,提交后不能修改数据',
			  				{icon:3, title:'温馨提示'},
			  				function(index){
			  					$.ajax({
			  						url:'doOut.do?product_id='+data.product_id+"&store_id="+data.store_id,
			  						cache: false
			  					}).done(function(result){
									if(result.success){
			  							layer.closeAll('iframe');
			  							table.reload('itDemo');
			  							layer.msg(result.msg, {icon:1});
									}else{
										layer.alert(result.msg, {icon:1});
									}
								})
			  					layer.close(index);
			  				})	
			  	}
		  });
		  var $ = layui.$, active = {
			reload: function(){
				var my_store = $('#my_process');
				var my_status = $('#my_status');
				
				//执行重载
				table.reload('itDemo',{
					page:{
						curr:1
					}
					,where:{
							store_id:my_store.val(),
							store_status:my_status.val()
					}
				});
			}
		  };
		  $('#dyn_query').on('click', function(){
			 var type = $(this).data('type');
			 active[type] ? active[type].call(this) : '';
		  });
	});
	</script>
</body>
</html>