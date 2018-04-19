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
<title>Insert title here</title>
<style>
	body{
		height:90%;
		width:90%;
		background-color:#E8E8E8;
	} 
	#my_table{
		position:absolute;
		width:80%;
		height:30%;
		left:15%;
		top:30%;
	}
</style>
</head>
<body>
		<form action="">
			<h2 class="text-center" align="center">
				密码修改
			</h2>
			<table class="table" id="my_table">
				<tr>
					<th>
						原密码：
					</th>
					<td>
						<input type="password" name="old_pass" id="original_password"/>
					</td>
				</tr>
				<tr>
					<th>
						新密码：
					</th>
					<td>
						<input type="password" name="new_pass" id="new_password"/>
					</td>
				</tr>
				<tr>
					<th>
						确认密码：
					</th>
					<td>
						<input type="password" name="aff_pass" id="identify_password"/>
					</td>
				</tr>
			</table>
		</form>
</body>
</html>