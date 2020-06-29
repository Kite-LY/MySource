package Demo11_03;


import Demo11_02.Person;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 调用运行时类中指定的结构：属性，方法，构造器
 *
 */
public class ReflectionTest {

    @Test
    public void test01() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //获取指定的属性
        Field age = clazz.getField("age");  //age的权限不能获取
        /*
        设置当前的属性：
        set(参数一 ,参数二 )： 参数一：指明设置那个对象的属性，参数二：将该属性设置的为多少
         */
        age.set(p,12);

        /*
        获取当前属性的值
        get(参数一): 参数一：获取的是哪个对象当前的属性值

         */
        Object o = age.get(p);

        System.out.println((int)o);
    }

    /**
     * 如何操作运行时类中的属性f
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //获取指定的属性getDeclaredField()
        Field name = clazz.getDeclaredField("name");

        //保证当前的属性是可以进行访问的
        name.setAccessible(true);

        //获取，设置指定对象的此属性值
        name.set(p, "He");
        System.out.println(name.get(p));


    }
}























