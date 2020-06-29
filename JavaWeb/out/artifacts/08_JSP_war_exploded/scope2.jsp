<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/21
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope2</title>
</head>
<body>
<%--显示四个域中的值--%>
pageContext域中是否有值:<%=pageContext.getAttribute("key")%><br/>
request域中是否有值:<%=request.getAttribute("key")%><br/>
session域中是否有值:<%=session.getAttribute("key")%><br/>
application域中是否有值:<%=application.getAttribute("key")%><br/>

</body>
</html>
