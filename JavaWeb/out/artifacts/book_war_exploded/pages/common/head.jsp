<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/25
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--写base标签，用元固定在相对路径跳转结果-->
<%--修改base标签值为动态标签值--%>
<%
    String basePath = request.getScheme()  //获取协议名称
            +"://"
            + request.getServerName()  //获取服务器名字
            + ":"
            + request.getServerPort()        //获取服务器的端口号
            + request.getContextPath()  //获取文件路径
            + "/";
//    这里将base标签中的值放入request域中
    request.setAttribute("basePath",basePath);
%>

<base href="<%=basePath%>"/>    <!-- 使用el表达式进行地址的输出-->
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
