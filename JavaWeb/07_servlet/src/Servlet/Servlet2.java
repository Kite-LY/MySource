package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        System.out.println("在Servlet2中查看参数：" + username);

        //查看是否存在Servlet的印记
        Object key = req.getAttribute("key");
        System.out.println("Servlet1的印记：" +key);

        //处理自己的业务
        System.out.println("Servlet自己的业务！");

    }
}
