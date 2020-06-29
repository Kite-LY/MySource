<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/24
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upLoad</title>
</head>
<body>
    <form action="http://localhost:8080/09_EL_JSTL/upLoadServlet" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username" value="kite"/><br>
        头像：<input type="file" name="photo"/><br>
        <input type="submit" value="上传图像"/><br>
    </form>
</body>
</html>
