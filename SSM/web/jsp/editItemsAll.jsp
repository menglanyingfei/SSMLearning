<%--
  User: menglanyingfei
  Date: 2018/1/24
  Time: 15:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>批量修改</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/findItemsByName.do" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>

            <td><input type="text" name="items.name">
                <input type="button" value="批量删除" onclick="editItemsAll()"></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
        </tr>
        <c:forEach items="${itemsList }" var="items" varStatus="s">
            <tr>
                <td><input type="text" name="itemsList[${s.index}].name" value="${items.name}"/></td>
                <td><input type="text" name="itemsList[${s.index}].price" value="${items.price}"/></td>
                <td><input type="text" name ="itemsList[${s.index}].createtime" value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
                <td><input type="text" name="itemsList[${s.index}].detail" value="${items.detail}"/></td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
<script type="text/javascript">
    function editItemsAll() {
        document.getElementsByTagName("form")[0].action =
            "${pageContext.request.contextPath }/editItemsAllSubmit.do";
        document.getElementsByTagName("form")[0].submit();
    }
</script>
</html>
