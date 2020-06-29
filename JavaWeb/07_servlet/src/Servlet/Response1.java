package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("经过了Response1");
        resp.setStatus(302);
        //设置响应头，说明新的地址在哪里
       //resp.setHeader("location","http://www.baidu.com");

        //推荐使用的方法(请求重新定向直接跳转方法)
        resp.sendRedirect("http://vip.com");
    }
}
