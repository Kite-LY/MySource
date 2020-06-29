package com.kiteYY.dao;

import com.kiteYY.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的持久层接口
 */

public interface UserDao {


    /**
     * 查询所有内容的操作
     * @return
     */
    @Select("select * from `user`")
    public List<User> findAll();

}
