package Demo09_01;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 *  1.转换流：属于字符流
 *   InoutStreamReader:将一个字节的输入流转换为字符的输入流
 *   OutputStreamWriter:将一个字符的输出流转换为一个字节的输出流
 *
 *  2.作用：提供字节和字符之间的转换
 *
 *  3.解码：字节，字节数组 --> 字符数组，字符串
 *    编码：字符数组，字符串  --> 字节，字节数组
 *
 *  4.字符集
 *
 */
public class InputStreamReaderTest {

    /**
     * InputStreamReader实现字节流转换为字符流
     *
     */
    @Test
    public void test01(){
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("Hello.txt");
            //使用转换流：
            //参数2：指明具体使用什么字符集，主要取决于文件使用什么字符集进行存储的
            isr = new InputStreamReader(fis,"UTF-8");

            char[] buffer = new char[10];
            int len;
            while((len = isr.read(buffer)) != -1){
                String arr = new String(buffer,0,len);
                System.out.print(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 综合使用InputStreamReader和OutputStreamWriter0
     *
     */
    @Test
    public void test02(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            FileInputStream fis = new FileInputStream("Hello.txt");
            FileOutputStream fos = new FileOutputStream("Hello_gbk.txt");

            //使用在转换流
            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");

            //文件的读出和写入
            char[] buffer = new char[12];
            int len;
            while((len = isr.read(buffer)) != -1){
                String arr = new String(buffer,0,len);
                osw.write(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            try {
                if(osw != null)
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(isr != null)
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}































