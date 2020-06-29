package cn.kitey.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 自定义拦截器类
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 预处理，controller方法执行之前
     * return true :表示放行，执行下一个拦截器，执行controller中的方法
     * return false 不放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor拦截器执行了。。。。。预处理！");

        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);

        //这里设置不进行放行,或者放行
        return true;

    }

    /**
     * 后处理方法，经过controller后返回时，执行的方法，在success.jsp方法前执行
     * @param request
     * @param response
     * @param handler
     * @param
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor拦截器执行了。。。。。后处理！");
        //这里也可以通过请求转发跳转页面（但是后面的success.jsp页面也会进行执行）
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);

    }

    /**
     * 最后处理，在success.jsp执行后，在执行该方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor拦截器执行了。。。。。最后处理！");
        //该方法不能进行页面的请求转发！！


    }

}
