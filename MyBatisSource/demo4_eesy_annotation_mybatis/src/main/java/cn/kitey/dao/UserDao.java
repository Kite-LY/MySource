package cn.kitey.dao;

import cn.kitey.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    /**
     * 使用注解实现数据的查找
     * @return
     */
    @Select("select * from user")
    //配置结果集(可以用于实体类中的名称于数据库名称不对应的场景)
    //id 为再次使用结果集时不需要重新配置results
    @Results(id = "resultMap", value = {
            @Result(id = true, column = "id", property ="userId" ),
            @Result(column ="username" ,property ="username" ),
            @Result(column ="sex" ,property ="sex" ),
            @Result(column ="address" ,property ="address" ),
            @Result(column ="birthday" ,property ="birthday" )
    })
    public List<User> findAll();


    /**
     * 使用注解实现书数据的插入
     * @param user
     */
    @Insert("insert into user(username, sex, address, birthday)" +
            " values(#{username}, #{sex}, #{address}, #{birthday})")
    public void insertUser(User user);


    @Select("select * from user where id = #{id}")
    @ResultMap(value = {"resultMap"})
    public User findById(Integer id);

}
