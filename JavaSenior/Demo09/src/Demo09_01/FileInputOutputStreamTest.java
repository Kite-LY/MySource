package Demo09_01;

import org.junit.Test;

import java.io.*;

/**
 * 字符流的使用：
 *      测试FileInputStream和FileOutputStream的使用
 *
 * 结论：文本文件：使用字符流进行处理
 *      非文本文件使用字节流进行处理
 */

public class FileInputOutputStreamTest {

    @Test
    public void testFileInputStram(){
        FileInputStream fileInputStream = null;
        try {
            //1.文件对象
            File file = new File("Hello.txt");
            //2.字节流
            fileInputStream = new FileInputStream(file);
            //3.读数据
            byte[] buffer = new byte[1024];        //字节流，先用字节数组进行存储
            int len;
            while((len = fileInputStream.read(buffer)) != -1){
                String arr1 = new String(buffer,0,len);
                System.out.print(arr1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4关闭字节流

                try {
                    if(fileInputStream != null)
                        fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }

    }

    /**
     * 对图片文件进行复制操作
     *
     */

    @Test
    public void testFileInOutStream() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File("ai.jpeg");
            File file1 = new File("aiCopy.jpeg");

            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);

            long l = System.currentTimeMillis();

            //复制的过程
            byte[] buffer = new byte[10];
            int len;
            while((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
               // System.out.println(buffer);
            }

            long l1 = System.currentTimeMillis();

            System.out.println("图片文件复制成功！花费的时间为：" + (l1-l) + "毫秒");//图片文件复制成功！花费的时间为：67毫秒

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileOutputStream != null)
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fileInputStream != null)
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}

















