<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../../css/bootstrap.min.css" rel="stylesheet">  
<link href="../../layui/css/layui.css " media="all">
   <title>信息管理云系统</title> 
	<script type="text/javascript">
   		if(self.location != top.location){
   			top.location.href="/scgcxx/safty/login/toLogin.do";
   		}
   </script> 
   <style> 
   		html{height:100%;width:100%;}
		body{
		background-image:url(../../images/login.jpg);
		background-size:100%;
		height:100%;
		width:100%;
		margin:0;
		padding:0;
		}        
       #login_form{  
            width:30%;  
            height:50%;  
            position: relative;
            left: center;
            top: 15%;
            background-color:#4682B4;  
           	margin:0 auto;  
       	}  
       .title{  
            width:100%;  
            height:55px;  
            color:#ffffff;  
            border-bottom:1px solid #ffffff;  
            font-size:20pt;  
            font-family:"微软雅黑";  
            line-height:55px;  
            text-align:center;                
       }  
       #form_widget{  
           width:100%;  
           height:345px;  
           background-color:#808080;  
       }  
       .txt{  
           display:block; /*设置为独立块（换行）*/  
           width:70%;  
           margin:0 auto;  
           height:35px;  
           font-size:15pt;  
           border-radius:5px;/*设置圆角样式*/  
           border:0;  
           padding-left:8px;  
       }  
       #vcode{  
           height:35px;  
           width:40%;  
           font-size:15pt;  
           margin-left:15%;  
           border-radius:5px;  
           border:0;  
           padding-left:8px;  
       }  
       #code{  
           color:#ffffff;/*字体颜色白色*/  
           background-color:#000000;     
           font-size:20pt;  
           font-family:"华康娃娃体W5";  
           padding:5px 35px 10px 35px;  
           margin-left:5%;       
           cursor:pointer;  
       }  
       /*层级选择器*/  
       #search_pass_link a{  
           color:#000000;  
           text-decoration:none;                 
       }  
       /*伪类*/  
       #search_pass_link a:hover{  
           color:#ff0000;  
           text-decoration:underline;  
       }  
       .btn{  
           width:70%;  
           margin-left:15%;  
           height:40px;  
           border:0;  
           font-size:14pt;  
           font-family;"微软雅黑";  
           background-color:#FC5628;  
           color:#ffffff;  
           cursor:pointer;/*设置指针鼠标的样式*/  
           border-radius:20px;/*设置圆角样式*/  
           border:0;  
       }     
       #copyright{  
           width:100%;  
           text-align:center;  
           padding-top:80px;  
           font-family:"微软雅黑";  
           color:#e0e0e0;  
       } 
       #infoerror{
       	   width:100%;  
           text-align:center;  
           padding-top:20px;  
           font-family:"微软雅黑";  
           color:red;
       } 
       
 </style>  
</head>  
<body leftmargin="0" onload="changeImg()">

                <div id="login_form" >  
                    <div class="title"	>  
                        	生产过程信息云系统          
                    </div>     
                    <div id="form_widget"> 
                    	<form id="my_form" method="post"> 
                        <br>  
                        <input type="text" placeholder="请输入账号" id="box_name" class="txt" name="u_id"/>  
                        <br> 
                        <input type="password" placeholder="请输入密码" id="box_pass" class="txt" name="u_pwd"/>  
                        <br>  
                        <input type="text" id="vcode" placeholder="验证码" value="验证码" onfocus="this.value=''" onblur="if(this.value=='')this.value='验证码'"/>
                        <span id="code" >看不清，换一张</span> 
					    </form> 
					    <br> 
					    <br>             
 						<input  type="submit" value="登录" onclick="check()" class="btn" onmouseover="this.style.backgroundColor='#FF8D00'" onmouseout="this.style.backgroundColor='#FC5628'">  
                        <br>
                        <div id="infoerror"> 
                        ${adminerror}
                        </div>
                        <div id="copyright">  
                            Power By HYL &copy;CopyRight 2018/1/25  
                        </div>
                    </div>  
                </div>        
       <script src="../../layui/layui.js"></script>
       <script src="../../js/jquery-3.2.1.min.js"></script>
       <script type="text/javascript">  
            var code;//声明一个变量用于存储生成的验证码  
            document.getElementById("code").onclick=changeImg;  
            function changeImg(){  
                //alert("换图片");  
                var arrays=new Array(  
                    '1','2','3','4','5','6','7','8','9','0',  
                    'a','b','c','d','e','f','g','h','i','j',  
                    'k','l','m','n','o','p','q','r','s','t',  
                    'u','v','w','x','y','z',  
                    'A','B','C','D','E','F','G','H','I','J',  
                    'K','L','M','N','O','P','Q','R','S','T',  
                    'U','V','W','X','Y','Z'               
                );  
                code='';//重新初始化验证码  
                //alert(arrays.length);  
                //随机从数组中获取四个元素组成验证码  
                for(var i=0;i<4;i++){  
                //随机获取一个数组的下标  
                    var r=parseInt(Math.random()*arrays.length);  
                    code+=arrays[r];  
                    //alert(arrays[r]);  
                }  
                //alert(code);  
                document.getElementById('code').innerHTML=code;//将验证码写入指定区域  
            }         
              
            //效验验证码(表单被提交时触发)  
            function check(){  
                //获取用户输入的验证码  
                var input_code=document.getElementById('vcode').value;  
                //获取用户输入名和密码
                var input_admin=document.getElementById('box_name').value;
                var input_password=document.getElementById('box_pass').value;
                if(input_admin == null || input_admin === ""){
                    layui.use('layer', function(){
                  	  var layer = layui.layer;
                	  layer.alert(
                   		 '请输入用户名!',
   	                	  {
   	                		  title:'Alert',
   	                		  icon: 5,
   	                		  anim:6,
   	                		  yes: function(index, layero){
   	                		    //do something
   	                		    layer.close(index); //如果设定了yes回调，需进行手工关闭
   	                		  }
   	                	  }
                   	  );
                  	});
                    return false;
                }
                else if(input_password == null || input_password === ""){
                    layui.use('layer', function(){
                  	  var layer = layui.layer;
                	  layer.alert(
                   		 '请输入密码!',
   	                	  {
   	                		  title:'Alert',
   	                		  icon: 5,
   	                		  anim:6,
   	                		  yes: function(index, layero){
   	                		    //do something
   	                		    layer.close(index); //如果设定了yes回调，需进行手工关闭
   	                		  }
   	                	  }
                   	  );
                  });
                  return false;
                }  
                //alert(input_code+"----"+code);  
                if(input_code.toLowerCase()==code.toLowerCase())  
                {  
                	/* var my_form = document.getElementById("my_form"); */
                	$.ajax({
							url:"doLogin.do"
							,data:$('#my_form').serialize()
							,dataType: "json"
							,success:function(result){
								if(result.success){
									layui.use('layer', function(){
										console.log(result.success+"-------");
					                  	var layer = layui.layer;
										layer.msg(result.msg,
													{
														icon:1
														,time:2000
													},function(){
														window.location.href="../home/toHome.do";
													});
									});
									//window.location.href="toMainMenu.do"
								}else{
									layui.use('layer', function(){
					                var layer = layui.layer;
									layer.alert(result.msg, 
											{
												title:'Alert'
												,icon:5
												,anim:6
												,yes: function(index, layero){
						   	                		    //do something
						   	                		    layer.close(index); //如果设定了yes回调，需进行手工关闭
						   	                		  }
											}
									)
								}); 
							}
						}
                	})
                    //验证码正确(表单提交)  
                    /* return true;  */  
                }  
                else
                {  
                    //验证码不正确  
                	layui.use('layer', function(){
                	  var layer = layui.layer;
                	  layer.alert(
                		 '请输入正确的验证码!',
	                	  {
	                		  title:'Alert',
	                		  icon: 5,
	                		  anim: 6,
	                		  yes: function(index, layero){
	                		    //do something
	                		    layer.close(index); //如果设定了yes回调，需进行手工关闭
	                		  }
	                	  }
                	  );
                });
               	//验证码不正确,表单不允许提交  
    			return false;  
            	} 
            }
        </script> 
    </body>  
</html> 