<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
</head>
<body>
<div id="orderList">
	<div class="header">订单列表</div>
	<table>
		<tr>
			<th class="row1">订单号</th>
			<th class="row2">收货人</th>
			<th class="row3">总数</th>
			<th class="row4">总价</th>
			<th class="row5">订单详情</th>
		</tr>
		<s:iterator value="orderList" id="order">
			<tr>
				<td class="row1"><s:property value="#order.id"/></td>
				<td class="row2"><s:property value="#order.cname"/></td>
				<td class="row3"><s:property value="#order.subNum"/></td>
				<td class="row4"><s:property value="#order.subPrice"/></td>
				<td class="row5"><input type="button" value="订单详情" onclick="location='orderById?id=<s:property value="#order.id"/>'"></td>
			</tr>
		</s:iterator>
	</table>
	<div class="op">
		<input type="button" value="再次订购" onclick="location='listBook'"/>
	</div>
</div>
</body>
</html>