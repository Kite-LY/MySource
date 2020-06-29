package com.kiteYY.dao;


import com.kiteYY.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 根据id查询信息
     * @param userID
     * @return
     */
    User findById(Integer userID);

    /**
     * 查询所有操作
     * @return
     */
    public List<User> findAll();



}
