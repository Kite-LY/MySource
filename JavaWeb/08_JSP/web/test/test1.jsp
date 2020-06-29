<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/21
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test1</title>
    <style type="text/css" >
        table{
            width: 650px;
            border: 1px;
            align-content: center;
            cellspacing: 0px;
        }
    </style>
</head>
<body>
    <%-- test1： 在jsp中输出九九乘法表--%>
    <h1 align="center" >九九乘法表</h1>
    <table align="center"  cellspacing="0" border="1">
        <%for (int i = 1; i <= 9; i++) { %>
             <tr>
                <%for (int j = 1; j <= i; j++) {%>
                 <td>
                     <%=j + "*" + i + "=" + (i*j)%>
                 </td>

                <%}%>
            </tr>
        <%} %>

    </table>

</body>
</html>
