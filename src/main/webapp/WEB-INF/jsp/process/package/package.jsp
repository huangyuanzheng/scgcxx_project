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
</style>
</head>
<body>
	<div class="my_serach">
		<span>状态<span class="glyphicon glyphicon-hand-right"></span></span>
		<select class="btn btn-default dropdown-toggle" id="my_status" name="product_status">
			<option  value="2">全部</option>
   			<option  value="0" selected="selected">待包装</option>
   			<option value="1">已包装</option>
   		</select>
		<span>组号<span class="glyphicon glyphicon-hand-right"></span></span>
		<input id="my_product" class="form-control" type="text" name="product_id"  value="${param.product_id}"/>
		<button id="dyn_query"  class="btn btn-info" data-type="reload">
			<i class="layui-icon">&#xe615;</i>查询
		</button>
	</div>
	<table class="layui-table" id="demo"  lay-filter="test"></table>
	<script type="text/html" id="barDemo">
		{{#  if(d.product_status_name != '已包装'){ }}
		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="assign">包装</a>
		{{#  } }}
		{{#  if(d.product_status_name == '已包装'){ }}
		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="detail">查看</a>
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
		    ,where:{product_status : "0"}
		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度
		    ,page:true
		    ,limit:10
		    ,limits:[5, 10, 15, 20]
		    ,cols: [[ 
	          {field: 'product_id', title: '成品号', width: 80, align: 'center'}
	          ,{field: 'process_id', title: '组号', width: 100, align: 'center'}
	          ,{field: 'product_cus', title: '客户', width: 100, align: 'center'}
	          ,{field: 'product_std', title: '规格号', width: 130, align: 'center'}
	          ,{field: 'process_color', title: '颜色号', width: 100, align: 'center'}
	          ,{field: 'product_level', title: '成品等级', width: 130, align: 'center'}
	          ,{field: 'product_num', title:'成品量', width:100, align:'center'}
	          ,{field: 'product_pkg', title:'已打包量', width:130, align:'center'}
	          ,{field: 'product_status_name', title: '状态 ', width: 130, align: 'center'}
		      ,{fixed: 'right', title: '操作', align:'center', toolbar: '#barDemo'}
		    ]]
		  });
		  table.on('tool(test)', function(obj){	//tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			  var data = obj.data;	//获取当前行数据
			  var layEvent = obj.event;	//获取lay-event对应的值（也可以是表头的event参数对应的值）
			  var tr = obj.tr;	//获取当前行tr的dom对象
			  if(layEvent === 'assign'){
				  layer.open({
					  type:2
					  ,area:['600px', '700px']
				  	  ,title:'编号：'+data.product_id
				  	  ,maxmin:true
				  	  ,anim:1
				  	  ,content:['toPackage.do?product_id='+data.product_id]
				  	  ,btn:['确认', '取消']
				  	  ,btnAlign: 'c'
				  	  ,yes:function(index, layero){
						var	product_num = layer.getChildFrame('#product_num', index);
						var	no_pkg = layer.getChildFrame('#product_nopkg', index);
						var	nums = layer.getChildFrame('#product_pkg', index);
						if(nums.val() == ''){
							layer.alert("请设置包装量!!!",
	  						  {
	  					  		icon:5,
	  							anim:6,
	  							yes:function(index){
	  								layer.close(index);
	  							}
	  						  });
						}else if(parseFloat(nums.val()) <= 0){
							layer.alert("包装量不能小于零，请重新设置!!!",
	  						  {
	  					  		icon:5,
	  							anim:6,
	  							yes:function(index){
	  								layer.close(index);
	  							}
	  						  });
						}else if(parseFloat(nums.val()) > parseFloat(no_pkg.val())){
							layer.alert("包装量不能大于未包装量，请重新设置!!!",
			  						  {
			  					  		icon:5,
			  							anim:6,
			  							yes:function(index){
			  								layer.close(index);
			  							}
			  						  });
						}
						else{
					  		layer.confirm('是否确认'+data.product_id+'号信息', function(index){
				  				var my_form = layer.getChildFrame('form');
				  				  $.ajax({
				  					  url:"doPackage.do"
				  					  ,data:my_form.serialize()
				  					  ,success:function(result){
				  						if(result.success){
				  							layer.closeAll('iframe');
				  							table.reload('itDemo');
				  							layer.msg(result.msg, {icon:1});
				  						}else{
				  							layer.alert(result.msg, {icon:1});
				  						}
				  					  }
				  				  	})
							 });
						}

				  	  }
				  	  
				  });
			  }else if(layEvent === 'detail'){
				  layer.open({
					  type:2
					  ,area:['850px', '600px']
				  	  ,title:'编号：'+data.product_id
				  	  ,maxmin:true
				  	  ,anim:1
				  	  ,content:['getStoreById.do?product_id='+data.product_id]
				  })
			  }
		  });
		  var $ = layui.$, active = {
			reload: function(){
				var my_product = $('#my_product');
				var my_status = $('#my_status');
				
				//执行重载
				table.reload('itDemo',{
					page:{
						curr:1
					}
					,where:{
							product_id:my_product.val(),
							product_status:my_status.val()
							
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