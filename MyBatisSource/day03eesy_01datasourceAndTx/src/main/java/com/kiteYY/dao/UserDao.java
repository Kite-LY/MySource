package com.kiteYY.dao;

import com.kiteYY.domain.QueryVo;
import com.kiteYY.domain.User;

import java.util.List;

public interface UserDao {


    /**
     * 查询在ids中的user数据
     * @return
     */
    List<User> findInIds(QueryVo vo);

    /**
     * 根据出入德参数条件
     * @param user 查询调价：有可能有用户名，也可能有性别，也有可能有地址，也有可能什么都没有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据Query中的条件查询用户
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 查询总记录数
     * @return
     */
    Integer findTotal();

    /**
     * 模糊查询
     * @return
     */
   List<User> findByName(String userName);

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
