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
<title>计划信息表</title>
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
		padding-bottom:0;
		margin-bottom:0;
		width:100%;
		height:45px;
		border: 1px solid #A0A0A0;
		background:#D0D0D0;
		font-size: 15px;
		line-height: 45px;
	}
	.layui-table-cell .layui-form-checkbox[lay-skin="primary"]{
     top: 50%;
     transform: translateY(-50%);
	}
</style>
</head>
<body>
	<div class="my_serach">
		<input id="my_status" type="hidden" name="plan_status" value="1"/>
		<span>计划编号<span class="glyphicon glyphicon-hand-right"></span></span>
		<input id="my_id" class="form-control" type="text" name="plan_id"  maxlength="8"  value="${param.plan_id}"/>
		<span>计划月份<span class="glyphicon glyphicon-hand-right"></span></span>
		<input id="my_month" class="form-control" type="text" name="plan_month"  value="${param.plan_month}"/>
		<span>产品类型<span class="glyphicon glyphicon-hand-right"></span></span>
		<select id="my_standard" name="plan_type" class="btn btn-default dropdown-toggle">
			<option value="">全部</option>
			<option value="1">白布</option>
			<option value="2">色布</option>
			<option value="3">有底花布</option>
			<option value="4">无底印花</option>
		</select>
		<button id="dyn_query"  class="btn btn-info" data-type="reload">
			<i class="layui-icon">&#xe615;</i>查询
		</button>
	</div>
	<table class="layui-table" id="demo"  lay-filter="test"></table>
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="assign">开始投坯</a>
	</script>
	<script>
 	$(document).ready(function(){
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
	});
	layui.use('table', function(){
		 var table = layui.table;
		 var tableIns = table.render({
			id:'itDemo'
		    ,elem: '#demo'
		    ,url:'doGetAllPlan.do'
		    ,where:{plan_status: '1'}
		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度
		    ,page:true
		    ,limit:10
		    ,limits:[5, 10, 15, 20]
		    ,cols: [[ 
		      {field: 'plan_id', title: '计划编号', width:100, align: 'center'}
	          ,{field: 'cus_name', title: '客户名', width:100, align: 'center'}
	          ,{field: 'co_name', title: '花色', width:100, align: 'center'}
	          ,{field: 'standard_name', title: '产品规格', width:120, align: 'center'}
	          ,{field: 'plan_xh', title: '生产顺序号', width:100, align: 'center'}
	          ,{field: 'plan_month', title: '计划月份', width:120, align: 'center'}
	          ,{field: 'plan_type_name', title: '产品类型', width:140, align: 'center'}
	          ,{field: 'plan_dateStr', title: '计划下达日期', width:160, align: 'center'}
	          ,{field: 'plan_person', title: '计划下达人', width:100, align: 'center'}
	          ,{field: 'plan_num', title: '计划产量', width:100, align: 'center'}
	          ,{field: 'plan_nums', title: '未分组量', width:100, align: 'center'}
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
						,area:['600px', '750px']
						,title: "  "
						,maxmin:true
						,anim:1
						,content:'toGroup.do?plan_id='+data.plan_id
						,btn:['确认分组', '取消分组']
						,btnAlign: 'c'
						,yes:function(index, layero){
							var group_num = layer.getChildFrame('input[id=group_num]', index);
							var nums = layer.getChildFrame('input[id=plan_nums]', index);
							console.log(nums.val()+"-----------");
							console.log(group_num.val()+"-------");
							if(group_num.val() == '' ||  parseFloat(group_num.val()) < 200){
								layer.alert("坯布分组量不少于200米!!!",
		  						  {
		  					  		icon:5,
		  							anim:6,
		  							yes:function(index){
		  								layer.close(index);
		  							}
		  						  });
							}else if(parseFloat(group_num.val()) > parseFloat(nums.val())){
								layer.alert("分组产量大于坯布剩余量，请重新设置!!!",
				  						  {
				  					  		icon:5,
				  							anim:6,
				  							yes:function(index){
				  								layer.close(index);
				  							}
				  						  });
							}else{
								layer.confirm('是否确认新增', function(index){
		/* 						var name = layer.getChildFrame('input[id=s_name]', idx);
								if(name.val()==""||name.val()==null){
									layer.alert('请填写姓名', {icon:5, anim:6});
								} */
									var f = layer.getChildFrame('form');
									$.ajax({
										url:"doGroup.do"
										,data:f.serialize()
										,dataType: "json"
										,success:function(result){
											console.log(result.success+"========");
											if(result.success){
												layer.closeAll('iframe');
												table.reload('itDemo');
												layer.msg(result.msg,{icon:1});
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
				var my_id = $('#my_id');
				var my_month = $('#my_month');
				var my_standard = $('#my_standard');
				var my_status = $('#my_status');
				
				//执行重载
				table.reload('itDemo',{
					page:{
						curr:1
					}
					,where:{
							plan_id:my_id.val(),
							plan_month:my_month.val(),
							plan_type:my_standard.val(),
							plan_status:my_status.val()
							
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