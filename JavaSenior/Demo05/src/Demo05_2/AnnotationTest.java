package Demo05_2;

/**
 * 注解的使用
 *
 * 1.Annotation的使用实例：
 *    示例一：生成相关的文档注释
 *    示例二：在编译的时候进行格式的检查（JDK内置的三种基本注解）
 *     @Override：用于限定重写的父类方法，该注解只能应用于方法
 *     @Deprecated:用于表示所修饰的元素（类，方法）已经过时，通常是因为所修饰的结构危险或存在更好的选择
 *     @SuppressWarnings:抑制编译器的警告！
 *
 * 2.如何自定义注解：参照@SuppressWarnings
 *      1.注解的自定义声明为：@interface
 *      2.自定义内部的成员，通常使用value表示
 *      3.可以指定成员的默认值，可以是哪个default定义
 *      4.如果自定义的注解没用成员，表名的是一个表示作用
 *
 *      如果注解有成员，在使用注解时，需要指定成员的值
 *      自定义注解在使用（反射机制）
 */
public class AnnotationTest {


    public static void main(String[] args) {
        Person p = new Student();
        p.walk();
    }


}

@MyAnnotation(value = "Hi")
class Person{
    String name;
    int age;

    public Person() {
    }

    public void walk(){
        System.out.println("人走路");
    }
    public void speak(){
        System.out.println("人说话！");
    }
}

interface info{
    public void show();
}

class Student extends Person implements info{

    @Override
    public void walk() {
        System.out.println("学生走路！");
    }

    @Override
    public void show() {
        System.out.println("一个学生！");
    }
}












