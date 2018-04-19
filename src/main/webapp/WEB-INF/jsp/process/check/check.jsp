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
<title>ranse信息表</title>
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
		<select class="btn btn-default dropdown-toggle" id="my_status" name="process_status">
			<option  value="2">全部</option>
   			<option  value="0" selected="selected">待质检</option>
   			<option value="1">已质检</option>
   		</select>
		<span>组号<span class="glyphicon glyphicon-hand-right"></span></span>
		<input id="my_process" class="form-control" type="text" name="process_id"  value="${param.process_id}"/>
		<button id="dyn_query"  class="btn btn-info" data-type="reload">
			<i class="layui-icon">&#xe615;</i>查询
		</button>
	</div>
	<!-- <table class="layui-table" id="demo"  lay-filter="test"></table> -->
	<table class="layui-table" lay-data="{url:'doList.do', page: true, limit: 10, limits:[5, 10, 15, 20]}" id="itDemo" lay-filter="test">
	 	 <thead>
	    <tr>
	      <th lay-data="{field:'process_id', width:80, align: 'center'}" rowspan="2">组号</th>
	      <th lay-data="{field:'plan_id', width:100, align: 'center'}" rowspan="2">订单号</th>
	      <th lay-data="{field:'process_cus', width:120, align: 'center'}" rowspan="2">客户</th>
	      <th lay-data="{field:'process_std', width:120, align: 'center'}" rowspan="2">规格</th>
	      <th lay-data="{field:'process_color', width:120, align: 'center'}" rowspan="2">颜色</th>
	      <th lay-data="{field:'arrange_num', width:120}" rowspan="2">生产量</th>
	      <th lay-data="{align:'center'}" colspan="5">质检产量</th>
	      <th lay-data="{field:'process_status_name', width:120, align: 'center'}" rowspan="2">状态</th>
	      <th lay-data="{fixed: 'right', width: 160, align: 'center', toolbar: '#barDemo'}" rowspan="2">操作</th>
	    </tr>
	    <tr>
	      <th lay-data="{field:'product_sum', width:120, align: 'center'}">合计</th>
	      <th lay-data="{field:'product_first', width:120, align: 'center'}">一等品</th>
	      <th lay-data="{field:'product_second', width:120, align: 'center'}">二等品</th>
	      <th lay-data="{field:'product_third', width:200, align: 'center'}">三等品</th>
	      <th lay-data="{field:'product_subStandard', width:200, align: 'center'}">等外品</th>
	    </tr>
	  </thead>
	</table>
	<script type="text/html" id="barDemo">
		{{#  if(d.process_status_name ==='已整理' || d.process_status_name ==='质检中'){ }}
		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="assign">质检</a>
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
/* 		 var tableIns = table.render({
			id:'itDemo'
		    ,elem: '#demo'
		    ,url:'doList.do'
		    ,where:{process_status : "0"}
		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度
		    ,page:true
		    ,limit:10
		    ,limits:[5, 10, 15, 20]
		    ,cols: [[ 
	          {field: 'process_id', title: '组号', rowspan: 2,width: 130, align: 'center'}
	          ,{field: 'plan_id', title: '订单号', rowspan: 2,width: 130, align: 'center'}
	          ,{field: 'process_cus', title: '客户', rowspan: 2,width: 130, align: 'center'}
	          ,{field: 'process_std', title: '规格', rowspan: 2,width: 130, align: 'center'}
	          ,{field: 'process_color', title: '颜色号', rowspan: 2,width: 130, align: 'center'}
	          ,{field: 'arrange_num', title:'生产量', rowspan: 2,width:100, align:'center'}
		      ,{field: 'process_status_name', title: '生产状态 ', rowspan: 2,width: 130, align: 'center'}
		      ,{fixed: 'right', title: '操作', align:'center', rowspan: 2, width: 130,toolbar: '#barDemo'}]
	          ,[{field: 'product_sum', title: '合计 ', width: 130, align: 'center'}
	          ,{field: 'product_first', title: '一等品 ', width: 130, align: 'center'}
	          ,{field: 'product_second', title: '二等品 ', width: 130, align: 'center'}
	          ,{field: 'product_third', title: '三等品 ', width: 130, align: 'center'}
	          ,{field: 'product_subStandard', title: '等外品', width: 130, align: 'center'}]
		    ]
		  }); */
		  table.on('tool(test)', function(obj){	//tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			  var data = obj.data;	//获取当前行数据
			  var layEvent = obj.event;	//获取lay-event对应的值（也可以是表头的event参数对应的值）
			  var tr = obj.tr;	//获取当前行tr的dom对象
			  if(layEvent === 'assign'){
				  var product_arrange = data.arrange_num;
				  var product_sum = data.product_sum;
				  if(product_sum == null){
					  product_sum = 0;
				  }
				  var product_noCheck = product_arrange - product_sum;
				  layer.open({
					  type:2
					  ,area:['600px', '700px']
				  	  ,title:'编号：'+data.process_id
				  	  ,maxmin:true
				  	  ,anim:1
				  	  ,content:['toCheck.do?process_id='+data.process_id+'&product_noCheck='+product_noCheck]
				  	  ,btn:['确认', '取消']
				  	  ,btnAlign: 'c'
				  	  ,yes:function(index, layero){
						var	product_noCheck = layer.getChildFrame('#product_noCheck', index);
						var	product_second = layer.getChildFrame('#product_second', index);
						var	product_first = layer.getChildFrame('#product_first', index);
						var	product_third = layer.getChildFrame('#product_third', index);
						var	product_subStandard = layer.getChildFrame('#product_subStandard', index);
						console.log(product_first+'--------------->>');
						console.log(product_first.val()+'---------------');
						if(product_first.val() == '' || parseFloat(product_first.val()) < 0){
							layer.alert("一等品设置最小为零!!!",
	  						  {
	  					  		icon:5,
	  							anim:6,
	  							yes:function(index){
	  								layer.close(index);
	  							}
	  						  });
						}else if(product_second.val() == '' || parseFloat(product_first.val()) < 0){
							layer.alert("二等品设置最小为零!!!",
		  						  {
		  					  		icon:5,
		  							anim:6,
		  							yes:function(index){
		  								layer.close(index);
		  							}
			  				 });
						}else if(product_third.val() == '' || parseFloat(product_third.val()) < 0){
							layer.alert("三等品设置最小为零!!!",
			  						  {
			  					  		icon:5,
			  							anim:6,
			  							yes:function(index){
			  								layer.close(index);
			  							}
				  			 });
						}else if(product_subStandard.val() == '' || parseFloat(product_subStandard.val()) < 0){
							layer.alert("等外品设置最小为零!!!",
			  						  {
			  					  		icon:5,
			  							anim:6,
			  							yes:function(index){
			  								layer.close(index);
			  							}
				  			 });
						}else if(parseFloat(product_first.val())+parseFloat(product_second.val())+parseFloat(product_third.val())+parseFloat(product_subStandard.val())>parseFloat(product_noCheck.val())){
							layer.alert("将要质检的产品量不能大于未质检量,请重新设置!!!",
	  						  {
	  					  		icon:5,
	  							anim:6,
	  							yes:function(index){
	  								layer.close(index);
	  							}
	  						  });
						}else{
					  		layer.confirm('是否确认'+data.process_id+'号信息', function(index){
				  				var my_form = layer.getChildFrame('form');
				  				  $.ajax({
				  					  url:"doCheck.do"
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
			  }
		  });
		  var $ = layui.$, active = {
			reload: function(){
				var my_process = $('#my_process');
				var my_status = $('#my_status');
				
				//执行重载
				table.reload('itDemo',{
					page:{
						curr:1
					}
					,where:{
							process_id:my_process.val(),
							process_status:my_status.val()
							
					}
				});
			}
		  };
		  $('#dyn_query').on('click', function(){
			 var type = $(this).data('type');
			 console.log(type);
			 active[type] ? active[type].call(this):'doList.do';
		  });
	});
	</script>
</body>
</html>