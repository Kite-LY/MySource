package Demo10_01;


import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream和 ObjectOutputStream
 *
 * 2.作用：用于存储和读取基本的数据类型或者对象处理流，可以将java中的对象写入到数据源中
 *        也可以把对象从数据源中还原出来
 *
 * 3.对象进行序列化要求：
 *      3.1：需要实现接口Serializable
 *      3.2：需要提供一个全局常量
 *
 */
public class ObjectInputOutputStreamTest {

    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或者通过网路传输出去
     * 使用ObjectOutputStream实现
     *
     */
    @Test
    public void testObjectOutputStream(){

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("使用对象流进行序列化过程！"));

            oos.flush();

            oos.writeObject(new Person("刘备",49));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 反序列化过程
     *
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object o = ois.readObject();
            String arr = (String)o;
            System.out.println(arr);

            Person p = (Person)ois.readObject();
            System.out.println(p);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}









































