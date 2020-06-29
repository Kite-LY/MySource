package Demo03_1;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String 类与其他结构之间的转换
 *
 */

public class StringTest1 {

    /**
     * String 与基本数据类型，包装类之间的转换
     * String 转换为 基本数据类型，包装类:调用包装类的静态方法：parseXXX(Str)
     * 基本数据类型，包装类 转换 String重载的valueOf（XXX）
     *
     */
    @Test
    public void test1(){
        String s1 = "123";
        int n1 = Integer.parseInt(s1);          //调用了parseInt()方法
        System.out.println(n1);

        String st1 = String.valueOf(n1);
        System.out.println(st1);
    }


    /**
     * String 与char[] 进行数据转换
     * String --> char[]:调用String的toCharArray()
     * char ---> String:调用String的构造器
     *
     */
    @Test
    public void test2(){

        String s1 = "ab124";
        char[] arr = s1.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        String st2 = new  String(arr);
        System.out.println(st2);

    }

    /**
     * String 与 byte[] 之间的转换
     * 编码：String --> byte[]:调用String的getbytes（）
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc124中过";
        //编码
        byte[] bytes = str1.getBytes(); //使用的默认的字符集
        System.out.println(Arrays.toString(bytes));
        byte[] gbks = str1.getBytes("gbk");
        System.out.println(gbks);
        //解码
        String str2 = new String(bytes); //注意编码集的一致性
        System.out.println(str2);
        String str3 = new String(gbks);
        System.out.println(str3);
        String str4 = new String(gbks, "gbk");
        System.out.println(str4);


    }

}
