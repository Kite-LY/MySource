package cn.kitey.mybatis.controller;

import cn.kitey.mybatis.bean.Department;
import cn.kitey.mybatis.bean.Employee;
import cn.kitey.mybatis.mapper.DepartmentMapper;
import cn.kitey.mybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;



    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return  departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return  department;
    }

}
