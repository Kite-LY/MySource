package Demo03_1;

import org.junit.Test;

/**
 * 字符串的使用
 */
public class StringTest {





    /**
     * String：字符串，使用一对“”引起来表示
     * 1.String声明为final的，不可被继承
     * 2.String实现了Serializable接口；表示字符串是支持序列化的
     *         实现了Comparable接口，表示String可以比较大小
     * 3.String内部定义了final char[] value用于存储字符串数据
     * 4.String：代表不可变的字符序列。简称：不可变性
     *          体现：1.当对字符进行重新赋值时，需要重写内存区域赋值，不能使用原有的value进行赋值
     *               2.当对现有的字符串进行连接操作的时候，此时也需要重写内存区域中的值，不可使用value进行赋值
     * 5.通过字面值的方式（区别与new）给一个字符串赋值，此时的字符串值声明在字符串常量池中
     * 6.字符串常量池中的是不会存储相同内容的字符串的
     */


    @Test
    public void test1(){
        String s1 = "abc";//字面定义方法
        String s2 = "abc";
        System.out.println(s1 == s2);//比较的是s1和s2的地址值

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);
        System.out.println(s2);

        String s5 = s1.replace("a","m");
        System.out.println(s5);
    }


    /**
     * String的实例化方式
     * 方式一：通过字面量定义方式
     * 方式二：通过new + 构造器方式
     *
     * 面试题：String s = new String("abc")；方式在创建对象的时候，在内存中创建了几个对象？
     *      两个：一个是在堆空间中new一个结构，另一个是char[]对应的常量池中的数据：“abc”
     */

    @Test
    public void test2(){
        //通过字面量定义的方式：此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中
        String s1 = "JavaEE";
        String s2 = "JavaEE";
        //通过new + 构造器的方式，是数据在对空间中开辟空间后对应的地址值
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");

        System.out.println(s2 == s3);
        System.out.println(s3 == s4);

        System.out.println("----------------------------");
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name == p2.name);
        System.out.println(p1.name.equals(p2.name));
    }


    /**
     * 结论：
     * 1.常量与常量中中拼接结果在常量池中。且常量池中不会存在相同内容的常量
     * 2.只用其中有一个是变量，结果就在堆中。
     * 3如果使用拼接的结果调用intern（）方法，返回值就在常量池中
     *
     */

    @Test
    public void test3(){
        String s1 = "a";
        String s2 = "b";

        String s3 = "ab";
        String s4 = "a"+"b";
        String s5 = s1 + "b";
        String s6 = "a" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s4 == s7);//false
        System.out.println(s4 == s6);//false

        String s8 = s5.intern(); //返回值得到的s8使用的常量值已经存在
        System.out.println(s8 ==s3);//true
    }
}




















