<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
    <span>欢迎${sessionScope.username}</span>
    <div><a href="${pageContext.request.contextPath}/exit.do">退出</a></div>
<form action="${pageContext.request.contextPath }/findItemsByName.do" method="post">
查询条件：
<table width="100%" border=1>
<tr>

<td><input type="text" name="items.name"><input type="submit" value="查询"/>
<input type="button" value="批量删除" onclick="deleteItemsByIds()"></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
    <td>请选择</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${itemsList }" var="items">
<tr>
    <td><input type="checkbox" name="ids" value="${items.id}"/></td>
	<td>${items.name }</td>
	<td>${items.price }</td>

	<td><fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>

	<td>${items.detail }</td>
	
	<td><a href="${pageContext.request.contextPath }/findItemsById.do?id2=${items.id}">修改</a></td>

</tr>
</c:forEach>

</table>
</form>

</body>
<script type="text/javascript">
    function deleteItemsByIds() {
        document.getElementsByTagName("form")[0].action =
            "${pageContext.request.contextPath }/deleteItemsByIds.do";
        document.getElementsByTagName("form")[0].submit();
    }
</script>
</html>