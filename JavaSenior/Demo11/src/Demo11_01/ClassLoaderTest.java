package Demo11_01;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 *
 */
public class ClassLoaderTest {
    @Test
    public void test01(){
        //对于自定义的类，使用系统加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用getParent（）:获取扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        //再次调用，无法获得引导加载器
        //引导加载器主要负责加载Java的核心类库，无法加载自定义类库
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }

    @Test
    public void test02() throws Exception {
//        //方式一：获取配置文件
//        Properties pro = new Properties();
//        FileInputStream fis = new FileInputStream("jdbc1.properties");
//        pro.load(fis);
//
//        String name = pro.getProperty("name");
//        String password = pro.getProperty("password");
//        System.out.println("name:" + name);
//        System.out.println("password:" + password);

        //方式二：获取配置文件
        Properties pro1 = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc1.properties");
        pro1.load(resourceAsStream);
        String name1 = pro1.getProperty("name");
        String password1 = pro1.getProperty("password");
        System.out.println("name:" + name1);
        System.out.println("password:" + password1);

    }
}
















