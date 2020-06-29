package cn.kitey.dao;

import cn.kitey.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户接口 （这里我们使用mybatis实现，不需要书写该接口的实现类）
 * 使用注解的方式进行
 */
@Repository   //交给IOC容器
public interface AccountDao {

    /**
     * 查询所有用户的方法
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    @Insert("insert into account (name, money) values(#{name}, #{money})")
    public void saveAccount(Account account);
}
