package com.kite.web;

import com.google.gson.Gson;
import com.kite.pojo.User;
import com.kite.service.impl.UserServiceImpl;
import com.kite.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet{

    private UserServiceImpl userService = new UserServiceImpl();
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数username
        String username = req.getParameter("username");
        //判断用户名是否存在
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装为map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existUserName",existsUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        //将数据回传给客户端输出
        resp.getWriter().write(json);

    }



    /**
     * 用户的注销功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.销毁Session域中的用户的登录信息（销毁session)
        req.getSession().invalidate();
        //2.重定向到首页(首页直接获取getContextPath())
        resp.sendRedirect(req.getContextPath());
    }
    /**
     * 登录操作执行方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用UserService方法
       
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //使用userService调用login()方法
        User login = userService.login(new User(null, username, password, null));
        //根据login()方法的返回值判断是否存在
        if(login == null){
            //返回为空，则没有 在数据库查找到相应的用户信息，则跳回到登录页面
            //编写返回的提示信息
            req.setAttribute("msg","你输入的用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            //跳转成功页面login_success
            System.out.println("登录成功！");
            //session  经常用于保存用户的登录信息
            req.getSession().setAttribute("user",login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 注册执行方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        //获取session中的验证码
        String attribute = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中的验证码信息，以免 重复登录
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1.检查请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");


        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //2.检查验证码是否正确
        if(attribute!= null &&attribute.equals(code)){
            //检查 用户名是否可用
            if (userService.existsUsername(username)) {

                //把回显信息，存放到request域中
                req.setAttribute("msg","您注册的用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                System.out.println("用户名[" + username + "]已存在!");
//        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //      可用
//                调用Sservice保存到数据库
                userService.registUser(new User(null, username, password, email));
//
//        跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        }else{
            //把回显信息，存放到request域中
            req.setAttribute("msg","验证码输入错误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);


            //验证码错误，跳回初始页面
            System.out.println("您输入的验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }
}
