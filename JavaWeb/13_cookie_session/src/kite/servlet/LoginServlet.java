package kite.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //判断是否正确，正确则添加到cookir
        if("kite".equals(username) && "123456".equals(password)){
            //登录 成功
            Cookie cookie = new Cookie("username", username);
            //设施cookie存活时间 两天
            cookie.setMaxAge(60 * 60 * 24 * 2);
            resp.addCookie(cookie);
            System.out.println("登录 成功!");
        }else{
            //登录 失败
            System.out.println("登录 失败!");
        }
    }
}
