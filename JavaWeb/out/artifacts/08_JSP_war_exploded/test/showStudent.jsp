<%@ page import="java.util.List" %>
<%@ page import="kite.pojo.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/21
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>test2</title>
</head>
    <style type="text/css">
        table{
            border: 1px black solid;
            width: 600px;
            border-collapse: collapse;
        }

        td,th{
            border: 1px black solid;
        }

    </style>
<body>
    <%--test2: jsp输出一个表格，里面10个学生信息--%>

    <%-- 创建数组--%>
    <%
      List<Student> list = (List<Student>) request.getAttribute("stuList");
    %>
    <%--数据的打印--%>
    <table>
        <tr>
           <td>编号</td>
           <td>姓名</td>
           <td>年龄</td>
           <td>号码</td>
        </tr>
        <% for (Student student : list) { %>
            <tr>
                <td><%=student.getId()%></td>
                <td><%=student.getName()%></td>
                <td><%=student.getAge()%></td>
                <td><%=student.getPhone()%></td>
            </tr>

        <%}%>

    </table>
</body>
</html>
