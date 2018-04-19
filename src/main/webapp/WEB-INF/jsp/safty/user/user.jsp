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
<title>用户信息表</title>
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
		编号：<input id="my_id" class="form-control" type="text" name="u_id"  maxlength="8"  value="${param.u_id}"/>
		名称：<input id="my_name" class="form-control" type="text" name="u_name"  value="${param.u_name}"/>
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
		<a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="assign">角色分配</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script>
	layui.use('table', function(){
		 var table = layui.table;
		 var tableIns = table.render({
			id:'itDemo'
		    ,elem: '#demo'
		    ,url:'doList.do'
		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度
		    ,page:true
		    ,limit:10
		    ,limits:[5, 10, 15, 20]
		    ,cols: [[ 
		      {type:'checkbox',align: 'center', width:100}
		      ,{field:'u_id', title: '编号', sort: true, align: 'center'}
		      ,{field:'u_name', title: '名称',align: 'center'}
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
					  ,area:['800px', '800px']
				  	  ,title:'编号：'+data.u_id
				  	  ,maxmin:true
				  	  ,anim:1
				  	  ,content:['toAssign.do?u_id='+data.u_id]
				  });
			  }else if(layEvent === 'del'){
				  layer.confirm('真的删除吗', function(index){
					 //obj.del();	//删除对应行（tr）的DOM结构，并更新缓存
					 layer.close(index);
					 $.ajax({
						url:'toDelete.do?u_id='+data.u_id
						,datatype:'json'
						,success:function(result){
							table.reload('itDemo');
							if(result.success){
								layer.msg(
										data.u_id+result.msg,
										{
											icon:1
										})
							}
							else{
								layer.alert(
										"编号"+data.u_id+result.msg,
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
					  ,area:['500px', '600px']
				  	  ,title:'编号：'+data.u_id
				  	  ,maxmin:true
				  	  ,anim:1
				  	  ,content:['toAlter.do?u_id='+data.u_id]
				  	  ,btn:['提交修改', '放弃修改']
				  	  ,btnAlign: 'c'
				  	  ,yes:function(index, layero){
						var name = layer.getChildFrame('input[id=user_name]', index);
						if(name.val() == "" || name.val() === null){
							layer.alert("请填写名称!!!",
	  						  {
	  					  		icon:5,
	  							anim:6,
	  							yes:function(index){
	  								layer.close(index);
	  							}
	  						  });
						}else{
					  		layer.confirm('是否确认修改'+data.u_id+"号信息", function(index){
				  				var my_form = layer.getChildFrame('form');
				  				  $.ajax({
				  					  url:"doAlter.do"
				  					  ,data:my_form.serialize()
				  					  ,success:function(result){
				  						if(result.success){
				  							layer.closeAll('iframe');
				  							table.reload('itDemo');
				  							layer.msg(result.msg, {icon:1});
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
				var my_name = $('#my_name');
				
				//执行重载
				table.reload('itDemo',{
					page:{
						curr:1
					}
					,where:{
							u_id:my_id.val(),
							u_name:my_name.val()
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
				,area:['500px', '600px']
				,title: "  "
				,maxmin:true
				,anim:1
				,content:['toAdd.do']
				,btn:['确认新增', '取消新增']
				,btnAlign: 'c'
				,yes:function(index, layero){
					var name = layer.getChildFrame('input[id=user_name]', index);
					var id = layer.getChildFrame('input[id=user_id]', index);
					var pwd = layer.getChildFrame('input[id=user_pwd]', index);
					if(id.val() == "" || id.val() === null){
						layer.alert("请填写编号!!!",
  						  {
  					  		icon:5,
  							anim:6,
  							yes:function(index){
  								layer.close(index);
  							}
  						  });
					}else if(name.val() == "" || name.val() === null){
						layer.alert("请填写名称!!!",
  						  {
  					  		icon:5,
  							anim:6,
  							yes:function(index){
  								layer.close(index);
  							}
  						  });
					}else if(pwd.val() == "" || pwd.val() === null){
						layer.alert("请添加初始密码!!!",
		  						  {
		  					  		icon:5,
		  							anim:6,
		  							yes:function(index){
		  								layer.close(index);
		  							}
		  						  });
					}
					else{
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