<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/22
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--
    EL表达式中11个隐含的对象可以直接进行使用

    变量                    类型                    作用
    pageContext            pageContextImpl         它可以获取jsp中的就九大内置对象
    pageScope              Map<String, Object>     他可以获取pageContext域中的数据
    requestScope           Map<String, Object>     他可以或Requset域中的数据
    sessionScope           Map<String, Object>     获取Session域中的数据
    applicationScope       Map<String, Object>     可以获取ServletContext狱中的数据

    param                  Map<String, Object>     获取请求参数值
    paramValues            Map<String, Object>     获取请求参数值，可获取多个值进行使用

    header                 Map<String, Object>     获取请求头数据
    headerValues           Map<String, Object>     获取请求头数据，可以获取多个值进行使用

    cookie                 Map<String, Object>     获取当前请求的cookie信息

    initParam              Map<String, Object>     获取web.xml中配置的<context-param>上下文参数
--%>


<html>
<head>
    <title>a</title>
</head>
<body>
    <%
        request.setAttribute("key","value");
    %>

    表达式脚本输出key的值：<%=request.getAttribute("key")==null?"":request.getAttribute("key")%><br/>
    EL表达式输出key的值：${key}<br/>
</body>
</html>
