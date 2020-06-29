<%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/6/19
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>


    <h3>文件上传</h3>
    <%--enctype="multipart/form-data" :将表单分为价格部分，进行上传--%>
    传统的文件上传方式<br/>
    <form action="user/fileUpLoad1" method="post" enctype="multipart/form-data">

        选择文件<input type="file" value="浏览" name="upload"/><br/>
        <input type="submit" value="文件上传"/>
    </form>

    基于SpringMVC 的文件上方式 <br/>
    <form action="user/fileUpLoad2" method="post" enctype="multipart/form-data">
        <%--这里的name必须为upload--%>
        选择文件<input type="file" value="浏览" name="upload"/><br/>
        <input type="submit" value="文件上传"/>
    </form>
    <br/>

    跨服务器文件上传<br/>
    <form action="user/fileUpLoad3" method="post" enctype="multipart/form-data">
        <%--这里的name必须为upload--%>
        选择文件<input type="file" value="浏览" name="upload"/><br/>
        <input type="submit" value="文件上传"/>
    </form>
</body>
</html>
