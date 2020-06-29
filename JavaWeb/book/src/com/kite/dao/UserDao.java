package com.kite.dao;

import com.kite.pojo.User;

public interface UserDao {




    /**
     * 根据用户信息查询用户消息
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 返回null，说明用户名用户密码错误
     */
    public User queryUserByUsernameAndPassWord(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

}
