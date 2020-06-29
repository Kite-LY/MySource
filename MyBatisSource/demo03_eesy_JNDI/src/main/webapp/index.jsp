<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.kiteYY.dao.UserDao" %>
<%@ page import="com.kiteYY.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<html>
<body>


<h2>Hello World!</h2>
<%
    //读取配置文件
    InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
    //构建SqlSessionFactory
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(resourceAsStream);
    SqlSession session1 = factory.openSession();
    UserDao mapper = session1.getMapper(UserDao.class);
    List<User> all = mapper.findAll();
    for (User user : all) {
        System.out.println(user);
    }

%>
</body>
</html>
