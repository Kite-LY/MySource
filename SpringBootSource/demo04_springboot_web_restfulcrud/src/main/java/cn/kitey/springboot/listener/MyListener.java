package cn.kitey.springboot.listener;

import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 配置listener监听器
 */
public class MyListener  implements ServletContextListener{
    /**
     * wb应用启动
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized。。。。当前web应用启动！");
    }

    /**
     * web应用销毁
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed。。。。当前web应用销毁！");

    }
}
