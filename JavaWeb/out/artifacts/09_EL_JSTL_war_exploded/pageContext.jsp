<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/22
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageContext</title>
</head>
<body>

    <%--

    <%=request.getScheme() %>               协议
    <%=request.getServerName() %>           服务器ip
    <%=request.getServerPort() %>           服务器端口
    <%=request.getContextPath() %>          获取工程路径
    <%=request.getMethod() %>               获取请求方法
    <%=request.getRemoteHost() %>           获取客户端ip地址
    <%=session.getId()%>                    获取会话id编号

    --%>
    <%--<%=request.getScheme() %><be/>--%>
    <%--<%=request.getServerName() %><be/>--%>
    <%--<%=request.getServerPort() %><be/>--%>
    <%--<%=request.getContextPath() %><be/>--%>
    <%--<%=request.getMethod() %><be/>--%>
    <%--<%=request.getRemoteHost() %><be/>--%>
    <%--<%=session.getId()%><be/>--%>


    1.协议:${pageContext.request.scheme}<be/>
    2.服务器ip:${pageContext.request.serverName}<br/>
    3.服务器端口：${pageContext.request.serverPort}<br/>
    4.获取工程路径：${pageContext.request.contextPath}<br/>
    5.获取请求方法：${pageContext.request.method}<br/>
    6.获取客户端ip地址：${pageContext.request.remoteHost}<br/>
    7.获取会话id编号：${pageContext.session.id}<br/>


</body>
</html>
