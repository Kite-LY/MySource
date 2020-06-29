<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/21
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope</title>
</head>
<body>


<%--
    页面的4个域对象：
    pageContext    当前jsp页面范围之类有用        （pageContext类）
    request        一次请求内有效                 （HttpServletRequest类）
    sessin         一个会话内有效（打开浏览器，直接关闭浏览器）   （httpSessin类）
    application    这个web工程有限（只要web不停止，数据一直在）    （ServletContext类）

    使用顺序： pageContxt --》 request -- >  ression  -->   app;ication(从小到达进行使用的)


--%>
        <h1>scope.jsp页面</h1><br/>

        <%
            //分别往4个域中中存储数据
            pageContext.setAttribute("key", "pageContext");
            request.setAttribute("key", "request");
            session.setAttribute("key", "session");
            application.setAttribute("key", "application");
        %>
        <%--显示四个域中的值--%>
        pageContext域中是否有值:<%=pageContext.getAttribute("key")%><br/>
        request域中是否有值:<%=request.getAttribute("key")%><br/>
        session域中是否有值:<%=session.getAttribute("key")%><br/>
        application域中是否有值:<%=application.getAttribute("key")%><br/>

        <%
            request.getRequestDispatcher("/scope2.jsp").forward(request,response);
        %>

        <%--
             <jsp:forward page=""></jsp:forward>:是请求转发标签，他的功能是请求转发
             page  属性是转发的路径

        --%>
        <jsp:forward page="/scope2.jsp"></jsp:forward>

</body>
</html>
