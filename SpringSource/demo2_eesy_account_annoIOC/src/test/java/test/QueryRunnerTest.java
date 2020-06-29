package test;

import cn.kitey.config.SpringConfiguration;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QueryRunnerTest {
    @Test
    public void queryRunnerTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //注意注入的为 QueryRunner中，所以参数为 QueryRunner.class；
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner);
        System.out.println(runner1);
        System.out.println(runner == runner1);
    }
}
