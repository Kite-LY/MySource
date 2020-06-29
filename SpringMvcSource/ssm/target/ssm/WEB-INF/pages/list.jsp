<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/6/20
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>list</title>
</head>
<body>
    <h3>查询所有用户结果！</h3>

    <c:forEach items="${list}" var="account">
        用户姓名：${account.name} <br>
        用户账户：${account.money} <br>

    </c:forEach>

</body>
</html>
