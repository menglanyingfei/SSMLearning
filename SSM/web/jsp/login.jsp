<%--
  User: menglanyingfei
  Date: 2018/1/25
  Time: 10:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login.do" method="post">
        用户名:<input type="text" name="username"><br>
        密码:<input type="text" name="password"><br>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
