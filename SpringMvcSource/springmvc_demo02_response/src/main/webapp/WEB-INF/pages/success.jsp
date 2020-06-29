<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/6/18
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%--isELIgnored 表示是否忽略El表达式--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
    使用视图解析器跳转页面成功！

    <br>
    从request域中获取数据<br/>
    ${user.username}
    ${user.password}
    ${user.age}

</body>
</html>

