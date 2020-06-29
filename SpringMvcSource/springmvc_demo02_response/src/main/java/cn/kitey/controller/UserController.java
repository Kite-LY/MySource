package cn.kitey.controller;


import cn.kitey.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    /**
     * 返回一个ModelAndView对象
     * @return
     */
    @RequestMapping(path = "testModelView")
    public ModelAndView testModelView(){
        //创建一个ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("testModelView方法执行了" );
        User user = new User("Kitey","12333",34);
        //将user对象存入modelAndView中
        modelAndView.addObject("user",user);
        //设置跳转到那个页面(会调用视图解析器)
        modelAndView.setViewName("success");

        return modelAndView;
    }















    @RequestMapping("/testSpring")
    public String testSpring(Model model){
        System.out.println("restSpring方法执行了！");
        //模拟从数据库查询User对象
        User user = new User("Kite云","2500",12);
        //Model添加数据到request域中
        model.addAttribute("user",user);


        return "success";
    }

    /**
     * 返回值为void则会默认跳转到testVoid.jsp页面
     * 这里我们使用请求转发进行跳转，请求转发一次请求，则不用写项目名
     */
    @RequestMapping(value = "/testVoid")
     public void testVoid(HttpServletRequest request, HttpServletResponse response){
         System.out.println("testVoid方法执行了！");

        try {
            //请求转发：只发送一次请亲，资源可以共享
            //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);


            //重定向：发送两次请求，数据不能共享
           // response.sendRedirect(request.getContextPath() + "/index.jsp");

            response.setContentType("text/html;charset=utf-8");

            //直接返回请求数据
            response.getWriter().write("Kite,你好呀");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return;



    }
}
