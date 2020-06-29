package Demo11_03;


import Demo11_02.Person;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 获取运行时类的方法结构
 *
 */
public class MethodTest {


    //getMethods():获取当前运行时类及其所用父类中声明为public权限的方法
    @Test
    public void test01(){
        Class clazz = Person.class;
        Method[] method = clazz.getMethods();
        for (Method method1 : method) {
            System.out.println(method1);
        }
        System.out.println("-----------------");

        //获取当前运行时类的所有的声明方法（不包含父类中的声明方法！）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

    }

    /**
     * 权限修饰符  返回值类型  方法名（参数列表）   注解
     *
     */
    @Test
    public void test03(){
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

    }
}















