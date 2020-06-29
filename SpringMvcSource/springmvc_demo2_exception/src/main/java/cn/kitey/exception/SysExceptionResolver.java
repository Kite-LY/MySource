package cn.kitey.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        //获取异常对象
        SysException e;
        if(ex instanceof SysException){
            //进行强转
            e = (SysException) ex;
        }else {
            e = new SysException("系统正在维护！");
        }
        //创建ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", e.getMessage());
        //跳转页面
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
