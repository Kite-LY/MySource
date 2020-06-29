<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/6/2
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    这个是登录页面 login.jsp<br/>
    <%--创建用户登录表单--%>
    <form action="http://localhost:8080/15_filter/loginServlet" method="get">
        用户名：<input type="text" name="username"/><br/>
        密&nbsp;&nbsp;&nbsp;码：<input type="text" name="password"/><br/>
        <input type="submit" value="登录">
    </form>

</body>
</html>
