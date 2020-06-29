package kite.Servlet;

import com.google.gson.Gson;
import kite.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {


    protected void JavaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("ajax请求过来了！");
        //解决响应乱码问题

        Person person = new Person(1, "赵云");
        Gson gson = new Gson();
        String jsonPerson = gson.toJson(person);
        resp.getWriter().write(jsonPerson);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQueryAjax请求过来了！");
        //解决响应乱码问题

        Person person = new Person(1, "赵云");
        Gson gson = new Gson();
        String jsonPerson = gson.toJson(person);
        resp.getWriter().write(jsonPerson);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQueryGet请求过来了！");
        //解决响应乱码问题

        Person person = new Person(1, "赵云");
        Gson gson = new Gson();
        String jsonPerson = gson.toJson(person);
        resp.getWriter().write(jsonPerson);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQueryPost请求过来了！");
        //解决响应乱码问题

        Person person = new Person(1, "赵云");
        Gson gson = new Gson();
        String jsonPerson = gson.toJson(person);
        resp.getWriter().write(jsonPerson);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("jQuerySerialize请求过来了！");
        //解决响应乱码问题
        System.out.println("username:" + req.getParameter("username"));
        System.out.println("password:" +req.getParameter("password"));
        System.out.println("multiple:" +req.getParameter("multiple"));
        System.out.println("check:" +req.getParameter("check"));
        Person person = new Person(1, "赵云");
        Gson gson = new Gson();
        String jsonPerson = gson.toJson(person);
        resp.getWriter().write(jsonPerson);
    }


}
