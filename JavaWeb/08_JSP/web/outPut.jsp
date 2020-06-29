<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/21
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>outPut</title>
</head>
<body>
    <%
        out.write("out1 <br/>");
        out.write("out2 <br/>");


        response.getWriter().write("response输出1：<br/>");
        response.getWriter().write("response输出2：<br/>");
    %>
</body>
</html>
