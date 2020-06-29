<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/6/18
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>response</title>
    <%--引入Jquery--%>
    <script  src="js/jquery-1.7.2.js"></script>
    <script>
        // 页面加载，绑定单击事件
        $(function(){
            $("#btn").click(function(){
                alert("hello btn");
            });
        });

    </script>



</head>
<body>
     <a href="user/testSpring"> testString</a><br/>

     <a href="user/testVoid"> testVoid </a> <br/>

     <a href="user/testModelView">testModelView </a> <br/>
     <button id="btn" >发送ajax的请求</button>

</body>
</html>
