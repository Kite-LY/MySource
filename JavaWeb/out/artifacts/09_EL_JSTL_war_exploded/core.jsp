<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/22
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>core</title>
</head>
<body>

    <%--
        1.<c:ser />
        作用：set标签可以往域中保存数据

        域对象.setAttribyate(key, value)
            scope 属性是设置保存到那个域
            page表示pageContext域
            request表示Request域
            session表示session域
            application表示ServletContext域
            key是多少   ---> var
            value是多少  ---> value
    --%>

    保存之前：${requestScope.abc}<br/>
    <c:set scope="request" var="key1" value="value1"></c:set>
    保存之后：${requestScope}<br/>

    <hr>
    <%--
        if标签用来做if判断的
        test属性表示判断条件（使用EL表达式进行输出）
        如果test符合条件则进行数据的输出
    --%>
    <c:if test="${12 == 12}">
        <h1>12 === 12</h1>
    </c:if>
    <hr>
    <%--
        <c:chosos> <c:when> <c:otherwise>标签
        作用：多路判断。跟switch..case.. .default非常接近

        choose标签开始判断
        when标签表示每一种判断情况
            test属性标识当前这种判断情况的值


        otherwise标签表示剩下的情况
        <c:choose> <c:when> <c:otherwise>标签使用时需要注意的点：
            1.标签里不能使用html注释，要使用jsp注释
            2.when标签的父标签一定要是choose
    --%>


    <%
        //首先向域中保存数据
        request.setAttribute("height", 178);
    %>

    <c:choose>
        <c:when test="${requestScope.height > 199}">
            <h2>小巨人</h2>
        </c:when>
        <c:when test="${requestScope.height > 180}">
            <h2>很高人</h2>
        </c:when>
        <c:when test="${requestScope.height > 177}">
            <h2>很高了</h2>
        </c:when>
        <c:otherwise>
            <h2>剩下小到170的情况</h2>
        </c:otherwise>
    </c:choose>


</body>
</html>






























