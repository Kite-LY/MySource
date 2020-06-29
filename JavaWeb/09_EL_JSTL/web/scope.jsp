<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/22
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scope</title>
</head>
<body>
    <%
        pageContext.setAttribute("key1", "pageContext");
        request.setAttribute("key1", "request");
        session.setAttribute("key1", "session");
        application.setAttribute("key1", "application");
    %>
    ${pageScope.key1}<br/>
    ${requestScope.key1}<br/>
    ${sessionScope.key1}<br/>
    ${applicationScope.key1}<br/>
</body>
</html>
