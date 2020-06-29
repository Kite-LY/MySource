<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/6/2
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>a.jsp</title>
</head>
<body>
    <%
        System.out.println("访问login.jsp  1111");
        Object attribute = request.getSession().getAttribute("user");
        //r如果attribute为空，则跳转到登录页面
        if(attribute == null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
    %>
    我是a.jsp网页
</body>
</html>
