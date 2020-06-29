package Demo09_01;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *  1.缓冲流作用：
 *      提高流的读取，写入的速度
 *
 *  2.处理流，就是套接在已有流的基础上
 */
public class BufferedTest {

    /**
     * 实现非文本文件的复制
     *
     */
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File file = new File("ai.jpeg");
            File file1 = new File("aiCopy.jpeg");

            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);
            //造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //文件复制
            long l = System.currentTimeMillis();

            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            long l1 = System.currentTimeMillis();

            System.out.println("图片文件使用缓冲流复制成功！花费的时间为：" + (l1-l) + "毫秒");//图片文件使用缓冲流复制成功！花费的时间为：17毫秒

        } catch (IOException e) {
            e.printStackTrace();
        } finally {


            //当外层的缓冲流关闭后，内层的字节流也会对应的进行关闭
            try {
                if(bos != null)
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis != null)
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 使用BufferReader和BufferWriter实现文本文件的复制
     *
     */
    @Test
    public void testBufferedReaderBufferWriter(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("Hello.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("Hello1.txt")));

            char[] buffer = new char[1024];
            int len;
            while((len = bufferedReader.read(buffer)) != -1){
                bufferedWriter.write(buffer,0,len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedWriter != null)
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bufferedReader != null)
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }
}



















