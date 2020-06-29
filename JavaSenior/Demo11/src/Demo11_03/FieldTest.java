package Demo11_03;

import Demo11_02.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {

    @Test
    public void test01(){

        Class clazz = Person.class;

        //获得属性结构
        //getFields():获取当前运行时类及父类中声为public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }

        System.out.println("-------------------------");
        //getDeclareFields():获取当前运行时类中声明的所用属性（不包含在父类中声明的属性）
        Field[] declaredField = clazz.getDeclaredFields();
        for(Field f : declaredField){
            System.out.println(f);
        }

    }

    @Test
    public void test02(){
        Class clazz = Person.class;

        Field[] declaredField = clazz.getDeclaredFields();
        for(Field f : declaredField){
            int modifiers = f.getModifiers();
            Class<?> type = f.getType();
            String name = f.getName();
            System.out.println(Modifier.toString(modifiers) + "\t" + type + " \t " + name);
        }

    }

}















