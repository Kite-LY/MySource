package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        resp.setCharacterEncoding("UTF-8");
//        //通过响应头，设置浏览器的页数UTF-8字符集
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");
//

        //此方法会同时设置服务器和客户端都是用UTF-8字符集，还同时设置了响应头
        //注意：此方法一定要在获取流对象之前进行调用才可以生效
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write("response's content!");
    }
}
