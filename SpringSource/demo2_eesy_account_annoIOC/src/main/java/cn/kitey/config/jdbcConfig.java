package cn.kitey.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class jdbcConfig {

    /**
     * 创建QueryRunner对象
     * @param dataSource
     * @return
     */

    @Bean(name = "runner")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }



    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource ds;
        try {
            ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/eesy?serverTimezone=GMT%2B8");
            ds.setUser("root");
            ds.setPassword("25002500");
        } catch (PropertyVetoException e) {
            throw  new RuntimeException(e);
        }
        return ds;
    }
}
