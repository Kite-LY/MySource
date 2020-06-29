package cn.kitey.test;

import cn.kitey.dao.impl.AccountDaoImpl;
import cn.kitey.domain.Account;
import cn.kitey.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class Demo1Test {

    @Autowired
    private AccountService as;

    /**
     * 测试dao层查询数据所用
     */
    @Test
    public void testFindAll(){
        as.transfer(2,1,100);


    }
}
