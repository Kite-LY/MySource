package com.kite.service;

import com.kite.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录用户
     * @param user
     * @return
     */
    public User login(User user);


    /**
     * 检测用户名是否存在
     * @param username
     * @return 返回true表示用户名已经存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
