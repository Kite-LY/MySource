<%@ page import="kite.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 小风筝
  Date: 2020/5/22
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>c</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("Kite");
        person.setPhones(new String[]{"1111","2222","3333","44444"});

        List<String> list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        person.setCities(list);

        HashMap<String, Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        person.setMap(map);


        pageContext.setAttribute("person", person);
    %>

    <%--
        在进行属性输出数据的时候读取的是对象的get() 方法，而不是读取属性的声明
    --%>
    输出Person：${person}<br/>
    输出Person中name属性的值：${person.name}<br/>
    输出Person中Phone属性中的一个字符值：${person.phones[2]}<br/>
    输出Person中list值：${person.cities}<br/>
    输出Person中List属性中的一个值：${person.cities[2]}<br/>
    输出Person中Map属性值：${person.map}<br/>
    输出Person中mao属性中Key1对应的数据值：${person.map.key1}<br/>


</body>
</html>
