package kite.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决响应乱码
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if("kite".equals(username) & "123456".equals(password)){
            req.getSession().setAttribute("username",username);
            resp.getWriter().write("登录成功！");
        }else{
            //登录失败(重定向)
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
