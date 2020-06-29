<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/6/18
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>params</title>
</head>
<body>
<h3>请求参数的绑定</h3>
    <%--请求参数的绑定--%>
    <%--<a href="param/testParam?username=kite&password=1234">请求参数的绑定</a>--%>

    <%--创建一表单，进行bean 的封装--%>
    <form action="params/saveAccount" method="post">
        姓名：<input type="text" name="username"/><br/>
        密码：<input type="text" name="password"/><br/>
        金额：<input type="text" name="money"/><br/>
        用户的id：<input type="text" name="user.id"><br/>
        用户的年龄：<input type="text" name="user.age"><br/>
        <input type="submit" value="提交">
    </form>

    <%--其中封装了集合--%>
<form action="params/saveIter" method="post">
    <%--封装到list集合中--%>
    用户的id：<input type="text" name="list[0].id"><br/>
    用户的年龄：<input type="text" name="list[0].age"><br/>
    <%--封装到map对象中--%>
    用户的id：<input type="text" name="map['one'].id"><br/>
    用户的年龄：<input type="text" name="map['one'].age"><br/>
    <input type="submit" value="提交">
</form>



<form action="params/saverUser" method="post">
    用户账号：<input type="text" name="id"/><br/>
    用户年龄：<input type="text" name="age"/><br/>
    用户生日：<input type="text" name="date"/><br/ >
    <input type="submit" value="提交">
</form>

</body>
</html>
