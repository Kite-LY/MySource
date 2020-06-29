import com.kiteYY.dao.UserDao;
import com.kiteYY.domain.User;
import com.kiteYY.mybatis.io.Resources;
import com.kiteYY.mybatis.sqlSession.SqlSession;
import com.kiteYY.mybatis.sqlSession.SqlSessionFactory;
import com.kiteYY.mybatis.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void test01() throws Exception{
        //1.获取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        //3.使用工厂生产session类
        SqlSession session = factory.openSession();
        //4。使用代理模式执行类类的执行方法(获取了类对象)
        UserDao mapper = session.getMapper(UserDao.class);
        //5.执行类方法
        List<User> users = mapper.findAll();
        //输出获取的数据
        for (User user : users) {
            System.out.println(user);
        }

        session.close();
    }
}
