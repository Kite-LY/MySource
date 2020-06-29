<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/21
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
    头部信息 <br/>
    主体信息 <br/>

    <%--
        <%@include file = ""%> 就是静态包含
        file 属性指定你要包含的jsp页面的路径
        地址中的  /   表示为 http://ip:port/工程名/   映射东到代码的web目录

        静态包含的特点：
        1.静态包含不会翻译被包含的jsp页面
        2.静态包含其实是把包含的jsp页面的代码拷贝到包含的位置执行输出

    --%>
    <%--<%@ include file="/include/footer.jsp"%>--%>


    <%--
        动态包含:   <jsp:include page=""></jsp:include>
        1.动态包含把包含的jsp页面也翻译成java代码
        2.动态包含底层代码使用如下代码调用被包含的jsp页面执行输出
            JspRuntimeLibrary.include(request, reponse, "/include/footer.js", out, false);
    --%>
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="kite"/>
        <jsp:param name="password" value="123456"></jsp:param>
    </jsp:include>



</body>
</html>
