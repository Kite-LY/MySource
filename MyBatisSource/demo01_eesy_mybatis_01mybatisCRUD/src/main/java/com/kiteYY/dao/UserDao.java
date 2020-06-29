package com.kiteYY.dao;

import com.kiteYY.domain.QueryVo;
import com.kiteYY.domain.User;

import java.util.List;

public interface UserDao {

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

    /**
     * 存储数据操作
     * @param user
     */
    public void saveUser(User user);

    /**
     * 更新数据操作
     * @param user
     */
    public void upDateUser(User user);

    /**
     * 数据的删除功能
     * @param userId
     */
    public void deleteUser(Integer userId);
}
