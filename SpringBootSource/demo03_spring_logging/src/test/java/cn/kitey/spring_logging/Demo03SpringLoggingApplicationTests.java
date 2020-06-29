package cn.kitey.spring_logging;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo03SpringLoggingApplicationTests {

    //获取日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads() {

        //日志级别：由低到高：trace < debug < info < warn > error
        //优点：可以调整输出的日志级别；日志只有在这个级别之上的才可以生效
        logger.trace("这时trace日志。。。");
        logger.debug("这时debug日志。。。");
        //springBoot默认输出的时info之后（包括info）
        logger.info("这时info日志。。。"); //自己定义的信息
        logger.warn("这时warn日志。。。");
        logger.error("这时error日志。。。");
    }

}
