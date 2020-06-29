package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("URI:" + req.getRequestURI());
        //获取绝对路径
        System.out.println("URL:" + req.getRequestURL());
        //获取客户的ip地址
        System.out.println("客户的ip地址:" + req.getRemoteHost());
        //获取请求头
        System.out.println("获取请求头:" + req.getHeader("User-Agent"));
        //获取请求的方式Get()或者Post()
        System.out.println("获取请求方式:" + req.getMethod());

    }
}
