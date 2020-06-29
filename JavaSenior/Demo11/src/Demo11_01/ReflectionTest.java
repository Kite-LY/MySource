package Demo11_01;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void test01() {
        Person p1 = new Person();
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类的外部，不可以通过Person类的对象调用器内部私有结构
        //比如：name, showNation() 以及一些私有的构造器
    }

    //反射之后，对于Person的操作
    @Test
    public void test02() throws Exception {
        //1.通过反射，创建Persom类的对象
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object tom = constructor.newInstance("Tom", 12);
        Person p1 = (Person) tom;
        System.out.println(p1.toString());

        //通过反射机制，调用对象的属性，或者方法
        Field field = clazz.getField("age");        //调用属性
        field.set(p1, 10);
        System.out.println(p1.toString());

        //调用方法
        Method show = clazz.getMethod("show");
        show.invoke(p1);

        System.out.println("-----------------------------");
        //通过反射是可以调用Person类的私有结构的。蔽日：斯用的构造器，方法，属性


        //私有构造器
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Object jerry = declaredConstructor.newInstance("Jerry");
        Person p2 = (Person)jerry;
        System.out.println(p2.toString());
        //私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"Tom2");
        System.out.println(p2.toString());

        //私有方法
        Method declaredMethod = clazz.getDeclaredMethod("showNation", String.class);
        declaredMethod.setAccessible(true);
        String nation = (String)declaredMethod.invoke(p2,"China");
        System.out.println(nation);

    }

    /**
     * 关于java.lang.Class类的理解
     * 1.类加载的过程：
     *  程序经过javac.exe命令以后，会生成一个或者多个字节码文件（.class结尾）
     *  接着我们使用java.exe。命令对么个字节码文件进行解码运行，相当于将某个字
     *  节码文件加载到内存当中。此过程就称为类的加载，加载到内存中的类，我们就成为运行时类
     *  此运行时类，就最为Class的一个实例
     *
     * 2.换句话说，Class的实例就对应着一个运行时类
     * 3.加载到内存中的运行时类，会缓存一定的时间，在此时间之内，我们可以通过不痛的方式来获取运行类
     */
    @Test
    public void test03() throws ClassNotFoundException {
        //1.方式一： 调用运行时类的属性L.class
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        //2.方式二：通过运行时类对象，调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //3.调用Class的静态方法：forName(String classPath)  (常用的获取Class的方法)
        Class class3 = Class.forName("Demo11_01.Person");
        System.out.println(class3);
    }


























}




