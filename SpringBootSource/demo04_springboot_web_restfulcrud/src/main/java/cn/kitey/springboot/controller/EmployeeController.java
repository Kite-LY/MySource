package cn.kitey.springboot.controller;

import cn.kitey.springboot.dao.DepartmentDao;
import cn.kitey.springboot.dao.EmployeeDao;
import cn.kitey.springboot.entities.Department;
import cn.kitey.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 来处理跟员工相关的请求的控制类
 */
@Controller
public class EmployeeController {

    //获取Dao的操作对象
    @Autowired
    EmployeeDao employeeDao;

    //获取部门的操作对象
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        //将数据放入请求域 中
        model.addAttribute("emps",all);
        return "emp/list";
    }

    /**
     * 员工添加的控制类
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //将查询到的部门信息显示到页面
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //跳转到添加页面
        return "emp/add";
    }

    /**
     * 员工添加请求
     * SpringMVC自动将请求参数和入参对象的属性进行一一绑定：要求了请求参数的名字和javabean的入参对象里面的属性名一样
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表
        //redirect：表示重定向到一个地址   / 表示当前的项目路径
        //forward：表示转发到一个地址
        //System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 修改员工的数据，查出要修改的员工，回显给添加页面
     * @param id
     * @return
     */
    @GetMapping("emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        //员工对象
        model.addAttribute("emp",employee);

        //页面还要获取所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面（add是一个修改和添加二合一的页面）
        return "emp/add";
    }

    /**
     * 员工的修改：需要提交员工的id
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改员工的值："+ employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        //根据id进行数据的删除
        employeeDao.delete(id);

        return "redirect:/emps";
    }








}
