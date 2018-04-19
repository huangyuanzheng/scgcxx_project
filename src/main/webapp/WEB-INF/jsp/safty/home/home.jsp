<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>生产过程云信息系统</title>
<link href="../../css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
html {
	height: 100%;
}

body {
	height: 100%;
	margin: 0;
}

.my-container {
	width: 100%;
	height: 100%;
	background-color: gray;
	position: relative;
	/* relative:相对于通常位置的定位 */
}

.my-title {
	/* absolute:相对于【距离其最近的】【设置了position的】父元素的定位 ，如果没有这样的父元素则相对于html定位
		*/
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 50px;
	line-height: 50px;
	background-color: #005566;
	color: #FFFFFF;
	font-size: 28px;
}

.my-copyright {
	position: absolute;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 30px;
	background-color: #005566;
	color: #FFFFFF;
	font-size: 14px;
	text-align: center;
	line-height: 30px;
}

.my-nav {
	position: absolute;
	left: 0;
	top: 50px;
	bottom: 30px;
	width: 149px;
	background-color: #EEEEEE;
	border-right: 1px #DFDFDF solid;
}

.my-content {
	position: absolute;
	left: 150px;
	top: 50px;
	bottom: 30px;
	right: 0;
	background-color: #FFFFFF;
}

.my-content iframe{
	width:100%;
	height:100%;
	border:none;

}

.my-title>div {
	padding-left: 5px;
}

.my-menu-item {
	display: block;
	padding: 8px 0;
}

.my-a, .my-a:link, .my-a:visited, .my-a:hover {
	text-decoration: none;
}

.my-account{
	position: absolute;
	right:10px;
	top:25px;
	
	line-height:20px;
	font-size:14px;
	
}

.my-account a{
	color:white;	
}

</style>
</head>
<body>

	<div class="my-container">
		<div class="my-title">
			<div>生产过程云信息系统</div>
			<div class="my-account">
			当前账号：${userName}
			<a href="/scgcxx/safty/logout/doLogout.do">退出</a>
			</div>
		</div>
		<div class="my-nav">

			<div class="panel-group" id="my-menu" style="padding: 0 2px;">
				<c:forEach items="${pam}" var="pm">
				<div class="panel panel-default">
					<div class="panel-heading">

						<a class="my-a" data-toggle="collapse" data-parent="#my-menu"
							href="#my-menu-safty${pm.m_name}" aria-expanded="true"
							aria-controls="collapseOne"> <span
							class="glyphicon glyphicon-th-large"></span> ${pm.m_name}
						</a>

					</div>
					<div id="my-menu-safty${pm.m_name}" class="panel-collapse collapse">
						<div class="panel-body">
							<c:forEach items="${chm}" var="cm">
							<c:choose>
								<c:when test="${pm.m_id == cm.p_id}">
								<a href="/scgcxx${cm.m_url}" target="contentFrame" class="my-menu-item my-a"><span
								class="glyphicon glyphicon-th-list"></span>${cm.m_name}</a> 
								</c:when>
							</c:choose>
							</c:forEach>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
				
		<div class="my-content"><iframe name="contentFrame" ></iframe></div>
		<div class="my-copyright">版权所有：&copy;聚合软件开发有限公司</div>
	</div>


	<script src="../../js/jquery-3.2.1.min.js"></script>
	<script src="../../js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$.ajax({
				url:"/scgcxx/safty/login/singleLogin.do",
				success:function(result){
					location.href="/scgcxx/safty/login/toLogin.do";
				}
			});
		})
	</script>
</body>
</html>