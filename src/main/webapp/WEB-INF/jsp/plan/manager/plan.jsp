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
		<span>计划状态<span class="glyphicon glyphicon-hand-right"></span></span>
		<select class="btn btn-default dropdown-toggle" id="my_status" name="plan_status">
			<option  value="2">全部</option>
   			<option  value="0" selected="selected">未下达</option>
   			<option value="1">已下达</option>
   		</select>
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
	<div class="my_options">
			<button type="button" class="btn btn-success" aria-hidden="true" onclick="add()">
				<span class="glyphicon glyphicon-plus"></span>新增	
			</button>
		<button id="muilt_del" class="btn btn-danger" data-type="getCheckData" type="submit" onclick="this.form.action='toMutilDel.do'">
			<span class="glyphicon glyphicon-trash"></span>删除
		</button>
	</div>
	<table class="layui-table" id="demo"  lay-filter="test"></table>
	<script type="text/html" id="barDemo">
		{{#  if(d.plan_status_name ==='未下达'){ }}
		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="assign">下达计划</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		{{#  } }}
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
		    ,url:'doList.do'
		    ,where:{plan_status: '0'}
		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度
		    ,page:true
		    ,limit:10
		    ,limits:[5, 10, 15, 20]
		    ,cols: [[ 
		       {type:'checkbox',align: 'center', width:60}
		      ,{field: 'plan_id', title: '计划编号', width:100, align: 'center'}
	          ,{field: 'cus_name', title: '客户名', width:100, align: 'center'}
	          ,{field: 'co_name', title: '花色', width:100, align: 'center'}
	          ,{field: 'standard_name', title: '产品规格', width:120, align: 'center'}
	          ,{field: 'plan_xh', title: '生产顺序号', width:100, align: 'center'}
	          ,{field: 'plan_month', title: '计划月份', width:120, align: 'center'}
	          ,{field: 'plan_num', title: '计划产量', width:100, align: 'center'}
	          ,{field: 'plan_type_name', title: '产品类型', width:140, align: 'center'}
	          ,{field: 'plan_dateStr', title: '计划下达日期', width:160, align: 'center'}
	          ,{field: 'plan_person', title: '计划下达人', width:100, align: 'center'}
	          ,{field: 'plan_status_name', title: '计划状态' , width:100, align: 'center'}
		      ,{fixed: 'right', title: '操作', align:'center', toolbar: '#barDemo'}
		    ]]
		  });
		  table.on('tool(test)', function(obj){	//tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			  var data = obj.data;	//获取当前行数据
			  var layEvent = obj.event;	//获取lay-event对应的值（也可以是表头的event参数对应的值）
			  var tr = obj.tr;	//获取当前行tr的dom对象
			  if(layEvent === 'assign'){
				  layer.confirm('确认下达吗', function(index){
					 //obj.del();	//删除对应行（tr）的DOM结构，并更新缓存
					 layer.close(index);
					 $.ajax({
						url:'toAssign.do?plan_id='+data.plan_id
						,datatype:'json'
						,success:function(result){
							table.reload('itDemo');
							if(result.success){
								layer.msg(
										"编号"+data.plan_id+result.msg,
										{
											icon:1
										})
							}
							else{
								layer.alert(
										"编号"+data.plan_id+result.msg,
										{
											icon:5,
											anim:6
										})
							}
						}
					 })
				  });
			  }else if(layEvent === 'del'){
				  layer.confirm('真的删除吗', function(index){
					 //obj.del();	//删除对应行（tr）的DOM结构，并更新缓存
					 layer.close(index);
					 $.ajax({
						url:'toDelete.do?plan_id='+data.plan_id
						,datatype:'json'
						,success:function(result){
							table.reload('itDemo');
							if(result.success){
								layer.msg(
										data.plan_id+result.msg,
										{
											icon:1
										})
							}
							else{
								layer.alert(
										"编号"+data.plan_id+result.msg,
										{
											icon:5,
											anim:6
										})
							}
						}
					 })
				  });
			  }else if(layEvent === 'edit'){
				  layer.open({
					  type:2
					  ,area:['600px', '750px']
				  	  ,title:'编号：'+data.ro_id
				  	  ,maxmin:true
				  	  ,anim:1
				  	  ,content:['toAlter.do?plan_id='+data.plan_id]
				  	  ,btn:['提交修改', '放弃修改']
				  	  ,btnAlign: 'c'
				  	  ,yes:function(index, layero){
						var plan_xh = layer.getChildFrame('input[id=plan_xh]', index);
						var plan_month = layer.getChildFrame('input[id=plan_month]', index);
						var plan_num = layer.getChildFrame('input[id=plan_num]', index);
						if(plan_xh.val() == "" || plan_xh.val() === null){
							layer.alert("请填写生产序列号!!!",
			  						  {
			  					  		icon:5,
			  							anim:6,
			  							yes:function(index){
			  								layer.close(index);
			  							}
			  						  });
					   }else if(plan_month.val() == "" || plan_month.val() === null){
							layer.alert("请填写计划月份!!!",
			  						  {
			  					  		icon:5,
			  							anim:6,
			  							yes:function(index){
			  								layer.close(index);
			  							}
			  						  });
						}else if(plan_num.val() <= 0){
							layer.alert("计划产量必须大于零!!!",
			  						  {
			  					  		icon:5,
			  							anim:6,
			  							yes:function(index){
			  								layer.close(index);
			  							}
			  						  });
						}else{
					  		layer.confirm('是否确认修改'+data.plan_id+'号信息', function(index){
				  				var my_form = layer.getChildFrame('form');
				  				  $.ajax({
				  					  url:"doAlter.do"
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
/* 		  var $ = layui.$, active ={
			getCheckData: function(){//多选删除
				var checkStatus = table.checkStatus('demo')
				,s_id = checkStatus.data.s_id;
				if(s_id.length){
					layer.alert("请选择删除学生信息！！！",{icon:5, anim:6});
				}else{
					$.ajxa({
						url:"doMultiDel.do"
						,data:s_id.serialize()
						,success:function(result){
							if(result.success){
								layer.closeAll();
								table.msg(result.msg,
										{
											icon:1
										});
							}
						}
					}) 
				}	
			});
			}*/
		});	
		function add(){
			var table = layui.table;
			layer.open({
				type:2
				,area:['600px', '750px']
				,title: "  "
				,maxmin:true
				,anim:1
				,content:['toAdd.do']
				,btn:['确认新增', '取消新增']
				,btnAlign: 'c'
				,yes:function(index, layero){
					var plan_id = layer.getChildFrame('input[id=plan_id]', index);
					var plan_xh = layer.getChildFrame('input[id=plan_xh]', index);
					var plan_month = layer.getChildFrame('input[id=plan_month]', index);
					var cus_id = layer.getChildFrame('#cus_id', index);
					var co_id = layer.getChildFrame('#co_id', index);
					var standard_id = layer.getChildFrame('#standard_id', index);
					var plan_num = layer.getChildFrame('input[id=plan_num]', index);
					var plan_type = layer.getChildFrame('#plan_type', index);
					if(plan_id.val() == "" || plan_id.val() === null){
						layer.alert("请填写计划编号!!!",
  						  {
  					  		icon:5,
  							anim:6,
  							yes:function(index){
  								layer.close(index);
  							}
  						  });
					}else if(cus_id.val() == ""){
						layer.alert("请填写客户名称!!!",
  						  {
  					  		icon:5,
  							anim:6,
  							yes:function(index){
  								layer.close(index);
  							}
  						  });
					}else if(co_id.val() == "" || co_id.val() === null){
						layer.alert("请填写布匹颜色!!!",
		  						  {
		  					  		icon:5,
		  							anim:6,
		  							yes:function(index){
		  								layer.close(index);
		  							}
		  						  });
					}else if(standard_id.val() == "" || standard_id.val() === null){
						layer.alert("请填写产品规格!!!",
		  						  {
		  					  		icon:5,
		  							anim:6,
		  							yes:function(index){
		  								layer.close(index);
		  							}
		  						  });
				   }else if(plan_xh.val() == "" || plan_xh.val() === null){
						layer.alert("请填写生产序列号!!!",
		  						  {
		  					  		icon:5,
		  							anim:6,
		  							yes:function(index){
		  								layer.close(index);
		  							}
		  						  });
				   }else if(plan_month.val() == "" || plan_month.val() === null){
						layer.alert("请填写计划月份!!!",
		  						  {
		  					  		icon:5,
		  							anim:6,
		  							yes:function(index){
		  								layer.close(index);
		  							}
		  						  });
					}else if(plan_num.val() <= 0){
						layer.alert("计划产量必须大于零!!!",
		  						  {
		  					  		icon:5,
		  							anim:6,
		  							yes:function(index){
		  								layer.close(index);
		  							}
		  						  });
					}else if(plan_type.val() == "" || plan_type.val() === null){
						layer.alert("请填写产品类型!!!",
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
								url:"doAdd.do"
								,data:f.serialize()
								,dataType: "json"
								,success:function(result){
									console.log(result.success+"========");
									if(result.success){
										layer.closeAll('iframe');
										table.reload('itDemo');
										layer.msg(result.msg,{icon:1});
									}
									else{
										layer.alert(result.msg,{icon:1});
									}
								}
							})
					 });
				   }
				}
			});
		}
	</script>

</body>
</html>