package Demo09_01;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类：
 * 1.操作数据单位：字节流，字符流
 * 2.数据的流向：输入流，输出流
 * 3.流的角色：节点流，处理流
 *
 * 二、流的体系结构：
 * 抽象基类                     字节流（文件流）                处理流
 * InputStream                 FileInputStream  (byte[])      BufferedInputStream   (byte[])
 * OutputStream                FileOutputStream (byte[])      BufferedOutputStream  (byte[])
 * Reader                      FileReader     (char[])        BufferedReader        (char[])
 * Writer                      FileWriter     (char[])        BufferedWriter        (char[])
 *
 */
public class FileReaderWriterTest {
    /**将Demo09中的Hello.txt中的内容打印到控制台上
     *
     * 说明点：
     * 1.read（）理解：返回读入的一个字节符，如果达到了末尾则返回值为-1
     * 2.异常处理：为了保证流的资源能够及时的关闭，一定要使用try-catch-finally处理
     * 3.读入的文件一定要存在，否则会用FileNotFoundException.
     */
    @Test
    public void test01()  {//抛出异常，容易导致流不能进行关闭，导致资源的浪费
        //实例化File对象
        FileReader fileReader = null;
        try {
            File file = new File("Hello.txt");
            //提供具体的文件流
            fileReader = new FileReader(file);
            //文件的读入
//        int read = fileReader.read();
//        while(read != -1){
//            System.out.print((char)read);
//            read =fileReader.read();        //读完后接着读下一个
//        }

            //方式二：语法上的改变
            int date;
            while ((date = fileReader.read()) != -1){
                System.out.print((char) date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭文件流
            try {
                if(fileReader != null){
                    fileReader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //方式二
    @Test
    public void test02() {
        //1.File的实例对象
        FileReader fileReader = null;
        try {
            File file = new File("Hello.txt");
            //2.FileReader流的实例化
            fileReader = new FileReader(file);
            //3.读入操作
            char[] cbuffer = new char[5];
            int len;
            while((len = fileReader.read(cbuffer))!=-1){
                String str = new String(cbuffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从内存中写出数据到银盘的文件中
     *
     * 说明：
     * 1.输出操作：对应的File可以不存在的，并不会报异常
     * 2.
     *      File对应的硬盘中的文件如果不存在，在输出的过程中会自动创建文件
     *      File对应的硬盘中的文件如果存在：
     *          FileWriter(file,true):不会进行覆盖,而是在原来的文件上进行追加
     *          FileWriter(file,false)/FileWriter(file):会进行覆盖
     */
    @Test
    public void testFileWriter() throws IOException {
        FileWriter fileWriter = null;  //false:表示不可以追加
        try {
            //1.实例化File对象，指明写出到的文件
            File file = new File("Hello1.txt");
            //2.提供FileWriter的对象，用于数据的写出
            fileWriter = new FileWriter(file,false);
            fileWriter.write("Hello  haha\n");
            fileWriter.write("Hello  haha");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }


    }

    /**
     * 不能使用字符流进行图片的复制
     *
     */
    @Test
    public void testFileReaderFileWriter(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            //1.创建File对象，指明读入和写出文件
            File inFile = new File("Hello.txt");
            File outFile = new File("Hello1.txt");

            //2.创建输入流和输出流
            fileReader = new FileReader(inFile);
            fileWriter = new FileWriter(outFile,false);

            //3.实现数据的写入和写出操作
            char[] arr = new char[1024];
            int len;
            while((len =fileReader.read(arr)) != -1){
              //  String sbuffer = new String(arr,0,len);
                System.out.print("复制成功！");
                fileWriter.write(arr,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if(fileWriter != null)
                  fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}















