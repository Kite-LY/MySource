package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        System.out.println("在Servlet1中查看参数：" + username);

        //留下一个印记转发到Servlet2 查看

        req.setAttribute("key","Servlet1的印记");
        //Servlet2如何前往
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");
        requestDispatcher.forward(req,resp);
    }
}
