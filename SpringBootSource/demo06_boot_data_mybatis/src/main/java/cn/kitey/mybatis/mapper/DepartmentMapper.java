package cn.kitey.mybatis.mapper;

import cn.kitey.mybatis.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * 指定这是一个操作的据库的mapper
 */
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Select("delete from department where id#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id={id }")
    public int updateDept(Department department);
}
