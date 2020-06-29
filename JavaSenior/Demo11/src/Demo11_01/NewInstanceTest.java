package Demo11_01;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建运行时类的对象
 *
 */
public class NewInstanceTest {
    @Test
    public void test01() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;

        /*
        * 想要此方法正确创建运行时类的对象，要求：
        *   1.运行时类必须提供空参的构造器
        *   2.空参的构造器的访问权限 通常设为public
        *
        * 在javabean中要提供一个public的空参构造器。原因：
        *   1.便于通过反射，创建运行时类的对象
        *   2.便于子类继承运行时类时，默认的super()，保证父类有此构造器的
        * */
        Object obj = personClass.newInstance();
        System.out.println(obj);
    }

    /**
     *
     * 反射的动态性
     */
    @Test
    public void test02(){
        for(int i = 0; i <= 20 ; i++){
            int num = new Random().nextInt(3);  //生成0 1 2三个数

            String classPath = "";
            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath  ="Demo11_01.Person";
                    break;

            }
            try {
                Object instance = getInstance(classPath);
                System.out.println(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    //创建一个全类名ClassPath
    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
