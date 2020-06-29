package cn.kitey.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan(value = "cn.kitey.mybatis.mapper")
@SpringBootApplication
public class Demo06BootDataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo06BootDataMybatisApplication.class, args);
    }

}
