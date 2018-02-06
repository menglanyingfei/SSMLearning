<%--
  User: menglanyingfei
  Date: 2018/1/29
  Time: 16:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>json</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.js"></script>
</head>
<body>


</body>
<script type="text/javascript">

    <%--$(function () {--%>
        <%--$.ajax({--%>
            <%--url: "${pageContext.request.contextPath}/findItems2.do",--%>
            <%--type: "post",--%>
<%--//            data: {name: "手机", price: 500.0, detail: "好手机"},--%>
            <%--data: "name=手机&price=500&detail=好手机",--%>
            <%--dataType: "json",--%>

            <%--success: function (msg) {--%>
                <%--alert(msg);--%>
            <%--}--%>
        <%--})--%>
    <%--});--%>

    /*
     如果请求参数是json串  ，那么在ajax方法中得要加一个参数
     contentType:"application/json;charset=utf-8";
     */
    $(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/findItems3.do",
            type: "post",
            contentType: "application/json;charset=utf-8",
            data: '{"name": "手机", "price": 500.0, "detail": "好手机"}',
            dataType: "json",

            success: function (msg) {
//                alert(msg);
                // 将json对象转换成json串
                alert(JSON.stringify(msg));
                alert(msg.name + "--" + msg.price + "--" + msg.detail);
            }
        })
    });

</script>
</html>



















