<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/6/20
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <a href="account/findAll"> 测试查询</a> <br/>
    测试数据保存
    <br/>

    <form action="account/save" method="post">
        姓名：<input type="text" name="name" /><br>
        金额：<input type="text" name="money" /><br>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
