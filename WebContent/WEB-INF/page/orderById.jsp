<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
</head>
<body>
<div id="orderById">
	<h3>订单详情</h3>
	<div class="header">用户信息</div>
	<table class="userInfo">
		<tr>
			<td>收件人姓名</td>
			<td>${requestScope.order.cname}</td>
		</tr>
		<tr>
			<td>邮编</td>
			<td>${requestScope.order.zip}</td>
		</tr>
		<tr>
			<td>收件人地址</td>
			<td>${requestScope.order.addr}</td>
		</tr>
		<tr>
			<td>收件人电话</td>
			<td>${requestScope.order.phone}</td>
		</tr>
		<tr>
			<td>电子邮箱</td>
			<td>${requestScope.order.email}</td>
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
		<s:iterator value="bookList1" id="book">
			<tr>
			<td class="row1"><s:property value="#book.no"/></td>
			<td class="row2"><s:property value="#book.name"/></td>
			<td class="row3"><s:property value="#book.price"/></td>
			<td class="row4"><s:property value="#book.bnum"/></td>
			</tr>
		</s:iterator>
		<tr>
			<td colspan="3" style="text-align:right;">总计</td>
			<td>${requestScope.order.subPrice}</td>
		</tr>
	</table>
	<div class="op"><input type="button" value="再次订购" onclick="location='listBook'"/></div>
</div>
</body>
</html>