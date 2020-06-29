package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 1、执行 Servlet 构造器方法 2、执行 init 初始化方法
 * 第一、二步，是在第一次访问，的时候创建 Servlet 程序会调用。
 * 3、执行 service 方法 第三步，每次访问都会调用。
 * 4、执行 destroy 销毁方法 第四步，在 web 工程停止的时候调用。
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1.构造器方法！");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init初始化方法!");

        //1.获取Servlet程序的别名servlet-name的值
        System.out.println("Servlet程序的别名servlet-name的值:" + servletConfig.getServletName());
        //2.获取初始化参数init-param
        System.out.println("获取初始化参数username的值：" + servletConfig.getInitParameter("username"));
        System.out.println("获取初始化参数url的值：" + servletConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println("获取ServletContext对象:" +servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        //类型转换（因为HttpServletRequest有getMethod()方法）
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求的方式
        String method = httpServletRequest.getMethod();
        //System.out.println(method);

        //请求的分发处理
       if("POST".equals(method)){
            doPost();
        }else if("GET".equals(method)){
            doGet();
        }
        //System.out.println("3.Servlet 被访问了！");
    }

    /**
     * 做get请求操作
     */
    public void doGet(){
        System.out.println("get请求！");
        System.out.println("get请求！");
        System.out.println("get请求！");
    }

    /**
     * 做Post请求操作
     */
    public void doPost(){
        System.out.println("Post请求！");
        System.out.println("Post请求！");
        System.out.println("Post请求！");
    }








    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.destroy销毁方法！");
    }
}
