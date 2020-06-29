package kite.servlet;

import kite.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //请求获取元素
        //法sql语句查询学生信息
        //使用for循环查询数据
        List<Student> list = new ArrayList<>();
        for (int i = 1; i <= 10 ; i++) {
            list.add(new Student(i, "nane" + 1, 18 + i, "phone" + 1));
        }
        //保存到查询的数据结果
        req.setAttribute("stuList", list);
        //请求转发showStudent.jsp页面
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req, resp);
    }
}
