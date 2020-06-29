<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/21
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>

<%--
    jsp的page指令可以修改jsp页面中的一些重要的属性，或者是行为

    language属性：     表示jsp翻译后是什么语言文件，暂时只支持java
    contentType属性：  表示jsp返回数据类型是什么。也是源码中response.setContentType()参数值
    pageEncoding属性： 表示当前jsp页面文件本身的字符集
    import属性         用于导包，类使用

    关于out输出流使用
    autoFlush属性： 当out输出流缓冲区满了以后会进行自动的刷新初六，默认值为true
    buffer属性：    设置out缓冲区的大小，默认值为8kb
    （注意：俩个数据都建议不要进行修改）
--%>

<%--
    jsp的九大内置对象
    request :               请求对象
    reponse:                响应对象
    pageContext:            jsp上线文本对象
    session:                会话对象
    application:            ServiceContext对象
    config:                 ServiceConfig对象
    out:                    jsp输出流对象
    page:                   指向当前的jsp对象
    exception:              异常对象


--%>


<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="utf-8"
         autoFlush="true"
         buffer="8kb"
         errorPage="/errorPage.jsp"
         language="java" %>


<html>
<head>
    <title>a</title>
</head>
<body>
    这是一个a.jsp文件
    <%--<%--%>
        <%--int i = 12 /0;--%>
    <%--%>--%>
    <%--声明脚本语句：声明属性，声明static代码块，声明类方法，声明内部类--%>
    <%!
         private String name;
         private Integer id;
         private static Map<String, Object> map;
    %>
    <%!
        //s声明代码块
        static {
            map = new HashMap<>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
        }
    %>
    <%!
        public int a(){
            return 12;
        }
    %>
    <%!
        //声明内部类
        public static class A{
            private String name;
            private Integer id;
    }
    %>


    <%--表达式脚本
        1.输出整型
        2.输出浮点型
        3.输出字符型
        4.输出对象
    --%>
    <%=12%><br/>
    <%=12.2%><br/>
    <%="hello Word"%><br/>
    <%=map%><br/>

    <%--代码脚本--%>
    <%
        int i = 13;
        if(i ==13){
            System.out.println("hello word!");
        }else{
            System.out.println("kite1");
        }
    %>

    <%--代码脚本的组合使用--%>
    <table border="1" cellspacing="0">
        <%
            for (int j = 0; j < 10; j++) {
        %>
        <tr>

                <td>第<%=j + 1 %>行</td>

        </tr>
        <%
            }
        %>
    </table>
</body>
</html>


















