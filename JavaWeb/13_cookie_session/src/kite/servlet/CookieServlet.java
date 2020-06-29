package kite.servlet;

import kite.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    //设置工程路径
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        //获取工程路径
        cookie.setPath(req.getContextPath() + "/abc");   //设置为： 工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的cookie");
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        //创建一个存活3600时间的cookie对象
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个存活3600时间的cookie对象");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if(cookie != null){
            //设置setmaxAge(0)：表示立即删除cookie
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            resp.getWriter().write("cookie"+cookie.getName() +"已经被删除！");
        }


    }




    protected void defaultLift(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("default","defaultCookie");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
        resp.getWriter().write("设置cookie的生命周期！");

    }




    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //方案一
//        //1.先创建一个同名修改的cookie对象
//        Cookie cookie = new Cookie("key1","updateCookie");
//        //2.在构造器中赋值新的cookie值(覆盖的方式进行修改cookie的值)
//        resp.addCookie(cookie);
//        //3.调用response.addCookie
//        resp.getWriter().write("cookie值已经被修改");

        //方案二
        //1.先查找到要修改的cookie的key对象
        Cookie key1 = CookieUtils.findCookie("key1", req.getCookies());
        //进行判断，cooke不是null时，进行赋值
        if(key1 != null) {
            //2.调用setValue()方法给key赋上新的key值
            key1.setValue("2updateCookie");
            //3.调用resp.addCookie()通知客户端保存cookie值
            resp.addCookie(key1);
        }

        resp.getWriter().write("cookie值已经被修改");

    }



    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1创建cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        Cookie cookie1 = new Cookie("key2", "value2");
        Cookie cookie2 = new Cookie("key3", "value3");
        //2.通知客户端保存cookie对象
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.getWriter().write("Cookie创建成功！");



    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //cook.getName:是获取Cookie的key的名称
            //cook.getValue：是获取Cook的value的值
            resp.getWriter().write("cook["+ cookie.getName() +"="+ cookie.getValue()+"]<br/>");
        }
        Cookie key1 = CookieUtils.findCookie("key1", cookies);
        System.out.println(key1);

    }
}
