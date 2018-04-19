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
<title>密码维护</title>
</head>
<body>
<script type="text/javascript">
	window.onload=function(){
		layui.use('layer', function(){
			var layer = layui.layer;
			
			layer.open({
				type:2
				,area:['450px', '500px']
				,title: "  "
				,maxmin:true
				,anim:1
				,content:['toAlterPassword.do']
				,btn:['确认', '取消']
				,btnAlign: 'c'
				,scrollbar: false
				,yes:function(index, layero){
					var original = layer.getChildFrame('input[id=original_password]', index);
					var the_new = layer.getChildFrame('input[id=new_password]', index);
					var identify = layer.getChildFrame('input[id=identify_password]', index);
					if(original.val() == "" || original.val() === null){
						layer.alert("请填写原密码!!!",
  						  {
  					  		icon:5,
  							anim:6,
  							yes:function(index){
  								layer.close(index);
  							}
  						  });
					}else if(the_new.val() == "" || the_new.val() === null){
						layer.alert("请填写新密码!!!",
  						  {
  					  		icon:5,
  							anim:6,
  							yes:function(index){
  								layer.close(index);
  							}
  						  });
					}else if(identify.val() !== the_new.val()){
						layer.alert("两次输入密码不一致!!!",
		  						  {
		  					  		icon:5,
		  							anim:6,
		  							yes:function(index){
		  								layer.close(index);
		  							}
		  						  });
					}else{
						layer.confirm('是否确认修改', function(index){
							var f = layer.getChildFrame('form');
							$.ajax({
								url:"doAlterPassword.do"
								,data:"original="+original.val()+"&identify="+identify.val()
								,method: "post"
								,dataType: "json"
								,success:function(result){
									console.log(result.success+"========");
									if(result.success){
										layer.msg(result.msg,{icon:1,  time:2000}, function(){
											window.location.href="../logout/doLogout.do";
										});
									}else{
										layer.alert(result.msg,{icon:1});
									}
								}
							})
					 });
					}
			}
		});
		});
	}
</script>
</body>
</html>