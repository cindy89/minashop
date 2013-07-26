<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
<script type="text/javascript">

</script>
</head>
<body>
<div id="login">
<div class="header">用户登录</div>
<form action="/minashop/login" method="post">
	<table>
		<tr>
			<td>用户名</td>
			<td><input type="text" id="name" name="name"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" id="pwd" name="pwd"/></td>
		</tr>
	</table>
	<div class="op">
		<input type="submit" id="submit" name="submit" value="提交">
			<input type="reset" id="reset" name="reset" value="重置">
			<a href="register">注册新用户</a>
	</div>
</form>
</div>
</body>
</html>