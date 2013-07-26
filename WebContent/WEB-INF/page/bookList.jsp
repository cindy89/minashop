<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
</head>
<body>
<div id="bookList">
<div class="header">图书列表</div>
<form name="form1" action="" method="post">
<table>
	<tr>
		<th class="row1">序号</th>
		<th class="row2">书名</th>
		<th class="row3">价格</th>
		<th class="row4">数量</th>
		<th class="row5">操作</th>
	</tr>
	<s:iterator value="bookList" id="book">
		<tr>
			<td class="row1"><s:property value="#book.no"/></td>
			<td class="row2"><s:property value="#book.name"/></td>
			<td class="row3"><s:property value="#book.price"/></td>
			<td class="row4"><s:property value="#book.num"/></td>
			<td class="row5"><input type="button" value="购买" onclick="bugBook(<s:property value="#book.no"/>);"></td>
		</tr>
	</s:iterator>
</table>
<div class="op">
	<input type="button" id="seeCat" name="seeCat" value="查看购物车" onclick="location='listCart'"/>
	<input type="button" id="seeOrder" name="seeOrder" value="查看订单" onclick="location='listOrder'"/>
	<input type="button" id="subOrder" name="subOrder" value="提交订单" onclick="location='confirmOrder'">
</div>
</form>
</div>
<script type="text/javascript">
	function bugBook(no){
		document.form1.action="addCart?no="+no;
		document.form1.submit();
	}
</script>
</body>
</html>