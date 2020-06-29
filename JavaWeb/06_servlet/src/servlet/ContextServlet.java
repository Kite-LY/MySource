package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        System.out.println("context-param参数的值username的值：" + context.getInitParameter("username"));
        System.out.println("context-param参数的值password的值：" + context.getInitParameter("password"));
        //2.获取当前的工程路径，格式：/工程路径
        System.out.println("当前工程路径：" + context.getContextPath());
        //3.获取工程部署后再服务器硬盘上的绝对路径
        /**
         *  / 斜杠被服务器解析地址：http://ip:port/工程名/
         *
         */
        System.out.println("工程部署的路径：" + context.getRealPath("/"));
    }
}
