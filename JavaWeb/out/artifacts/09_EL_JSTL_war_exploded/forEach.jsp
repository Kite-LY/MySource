<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="kite.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/22
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forEach</title>
</head>
<body>
    <%--
        遍历List集合 ---list集合中存放Student类，有属性，编号，用户名，密码，年龄，电话信息
    --%>
    <%
        List<Student> stu = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            stu.add(new Student(i,"name" + i, "pass" + i, 18 + i, "phone" + i));
        }
        request.setAttribute("stuList", stu);
    %>
    <c:forEach items="${requestScope.stuList}" var = "stu">
        ${ stu }<br/>
    </c:forEach>
    <hr>




    <%--
        遍历1 到10 输出
        begin 属性设置开始的索引
        end   属性设置结束的索引
        var   属性表示循环变量
        for(int i = 0; i < 10; i ++)
    --%>
    <c:forEach begin="1" end="10" var="i">
        ${i}
    </c:forEach>


    <hr>
    <%--
        遍历输出对象
        items： 表示遍历的数据源（遍历的集合）
        var  表示当前遍历到的数据
    --%>
    <%
        request.setAttribute("arr", new String[]{"刘备", "关羽", "张飞", "赵云"});
    %>
    <c:forEach items="${requestScope.arr}" var="item">
        ${ item }
    </c:forEach>

    <%--
        使用for：each遍历图
    --%>
    <hr>

    <%
        Map<String, Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");

        //将数据存入域中
        request.setAttribute("map", map);
    %>
    <c:forEach items="${requestScope.map}" var="enty">
        <h2>${enty}</h2>
    </c:forEach>
</body>
</html>
