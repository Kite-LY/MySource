package kite.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决past请求中中文乱码问题
        //一定要在获取参数之后使用才会有效
        req.setCharacterEncoding("UTF-8");
        //解决响应中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");
//        String action = req.getParameter("action");
//
//        if ("login".equals(action)) {
//            login(req,resp);
//        }else if("regist".equals(action)){
//            regist(req,resp);
//        }
        //利用反射进行方法的调用
        //获取调用的方法的名字:这里获取的是 login  或  regist   两个action的value值，再通过反射执行相应的方法
        String action = req.getParameter("action");
        try {
            //通过反射获取action鉴别字符串，获取相应的业务，方法反射对象
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用目标函数，这时action对应了this， HttpServletRequest.class 对应的req, HttpServletResponse对应resp
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
