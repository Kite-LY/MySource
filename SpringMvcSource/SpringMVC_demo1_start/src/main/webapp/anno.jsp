<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/6/18
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>anno</title>
</head>
<body>
    <a href="anno/testRequestParam?name=Kite"> RequestParam</a>

    <br/>

    <form action="anno/testRequestBody" method="post">
        用户账号：<input type="text" name="id"/><br/>
        用户年龄：<input type="text" name="age"/><br/>
        用户生日：<input type="text" name="date"/><br/>
    <input type="submit" value="提交！"/>

    </form>

    <br/>

    <a href="anno/testPathVariable/10">PathVariable</a>

    <br/>

    <a href="anno/testSessionAttributes">SessionAttributes</a>
    <br/>
    <a href="anno/testGetSessionAttributes">GetSessionAttributes</a>

    <br/>
    <a href="anno/testDeleteSessionAttributes">testDeleteSessionAttributes</a>

</body>
</html>
