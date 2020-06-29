<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/25
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <%--action 表示调用 BookServlet中的list方法   前面表示请求地址--%>
    <a href="bookServlet?action=page">图书管理</a>
    <a href="pages/manager/order_manager.jsp">订单管理</a>
    <a href="index.jsp">返回商城</a>
</div>