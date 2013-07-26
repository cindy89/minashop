<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
<script type="text/javascript">

</script>
</head>
<body>
<div id="register">
  <div class="header">用户注册</div>
  <form action="/minashop/register" method="post">
	<table>
		<tr>
			<td>姓名</td>
			<td><input type="text" id="name" name="name"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="text" id="pwd" name="pwd"></td>
		</tr>
		<tr>
			<td>邮编</td>
			<td><input type="text" id="zip" name="zip"></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><input type="text" id="addr" name="addr"></td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input type="text" id="phone" name="phone"></td>
		</tr>
		<tr>
			<td>电子信箱</td>
			<td><input type="text" id="email" name="email"></td>
		</tr>
	</table>
	<div class="op">
		<input type="submit" id="register" name="register" value="注册">
		<input type="reset" id="reset" name="reset" value="重置">
		<a href="login">返回</a>
	</div>
  </form>
 </div>
</body>
</html>