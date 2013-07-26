<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认订单</title>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
</head>
<body>
<div id="confirmOrder">
	<h3>确认订单</h3>
	<div class="header">用户信息</div>
	<form action="addOrder?totPrice=${requestScope.totPrice}" method="post">
	<table class="userInfo">
		<tr>
			<td>收件人姓名</td>
			<td><input type="text" name="order.cname"></td>
		</tr>
		<tr>
			<td>邮编</td>
			<td><input type="text" name="order.zip"></td>
		</tr>
		<tr>
			<td>收件人地址</td>
			<td><input type="text" name="order.addr"></td>
		</tr>
		<tr>
			<td>收件人电话</td>
			<td><input type="text" name="order.phone"></td>
		</tr>
		<tr>
			<td>电子邮箱</td>
			<td><input type="text" name="order.email"></td>
		</tr>
	</table>
	<div class="header">购物清单</div>
	<table class="orderInfo">
		<tr>
			<th>编号</th>
			<th>书名</th>
			<th>价格</th>
			<th>数量</th>
		</tr>
		<s:iterator value="cartList" id="cart">
			<tr>
				<td width="50px;"><s:property value="#cart.book.no" /></td>
				<td width="200px;"><s:property value="#cart.book.name"/></td>
				<td width="50px;"><s:property value="#cart.book.price"/></td>
				<td width="50px;"><s:property value="#cart.num"/></td>
			</tr>
		</s:iterator>
		<tr>
			<td colspan="3" style="text-align:right;">总计：</td>
			<td>${requestScope.totPrice}</td>
		</tr>
	</table>
	<div class="op">
		<input type="submit" value="确认订单"/>
		<input type="button" value="重置订单" onclick="location='listCart'"/>
		<input type="button" value="继续购物" onclick="location='listBook'"/>
	</div>
</form>
</div>
</body>
</html>