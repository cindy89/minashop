<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
</head>
<body>
<div id="cart">
	<div class="header">购物车列表</div>
	<table>
		<tr>
			<th class="row1">编号</th>
			<th class="row2">书名</th>
			<th class="row3">价格</th>
			<th class="row4">数量</th>
			<th class="row5">操作</th>
		</tr>
		<s:iterator value="cartList" id="cart">
			<tr>
				<td class="row1"><s:property value="#cart.book.no" /></td>
				<td class="row2"><s:property value="#cart.book.name"/></td>
				<td class="row3"><s:property value="#cart.book.price"/></td>
				<td class="row4"><input type="text" id="num_<s:property value="#cart.book.no" />" value="<s:property value="#cart.num"/>"></td>
				<td class="row5">
					<input type="button" value="修改" onclick="location='updateCart?no=<s:property value="#cart.book.no" />&num='+document.getElementById('num_<s:property value="#cart.book.no" />').value"/>
					<input type="button" value="删除" onclick="location='deleteCart?no=<s:property value="#cart.book.no" />'"/>
				</td>
			</tr>
		</s:iterator>
		<tr>
			<td colspan="3" style="text-align:right;">总计:</td>
			<td colspan="2">${requestScope.totPrice}</td>
		</tr>
	</table>
	<div class="op">
		<input type="button" value="清空购物车" onclick="location='clear'"/>
		<input type="button" value="继续购物" onclick="location='listBook'"/>
		<input type="button" value="提交订单" onclick="location='confirmOrder?totPrice=${requestScope.totPrice}'">
	</div>
</div>
</body>
</html>