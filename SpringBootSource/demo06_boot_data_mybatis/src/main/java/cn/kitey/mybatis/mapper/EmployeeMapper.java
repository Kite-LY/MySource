package cn.kitey.mybatis.mapper;

import cn.kitey.mybatis.bean.Employee;

//@Mapper或者@MapperSacn将接口扫面装配到容器中
public interface EmployeeMapper {

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Employee getEmpById(Integer id);

    /**
     * 插入数据
     * @param employee
     */
    public void insertEmp(Employee employee);
}
