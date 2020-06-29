package kite.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.interfaces.RSAKey;

public class SessionServlet extends BaseServlet {

    /**
     * 往session域中存储数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("进行数据的存储！");
    }

    /**
     * session的默认时长
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的默认时长是：" +maxInactiveInterval + "秒");
    }

    /**
     * 设置单个session 的超时时长
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        //设置当前session超时时长为3秒
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("设置当前的session的超时时长为3秒！");
    }

    /**
     * session立即销毁
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        //设置当前session超时时长为3秒
        session.invalidate();
        resp.getWriter().write("设置当前的session立即销毁！");
    }


    /**
     * 获取session域中的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("在session中获取的值：" + attribute);
    }

    protected void CreateGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象（第一次会创建一个新的）
        HttpSession session = req.getSession();
        //判断session是否为新的session对象
        boolean aNew = session.isNew();
        //获取session唯一的id值
        String id = session.getId();
        //返回给服务端显示
        resp.getWriter().write("得到的Session的id是：" + id +"<br>");
        resp.getWriter().write("得到的Session是不是新创建的：" + aNew);
    }
}
