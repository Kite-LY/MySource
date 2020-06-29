package Demo08_06;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用：
 *
 * 1.File类的一个对象，代表一个文件或一个问价目录（文件夹）
 * 2.File类声明在java.id包下
 * 3.File类中涉及到关于文件或文件目录的创建，删除，重命名，修改时间，文件大小等方法
 *   并涉及到写入或者读取文件内容的操作。如果需要则要使用IO流进行完成
 * 4.后续File类的对象常会作为参数床底到流的构造器中，指明读取写入的“终点”
 *
 */
public class FileTest {

    /**
     * 1.如何创建File类的实例
     *  file(String path)
     *  file(String parentPath, String childPath)
     *  file(File parentFile, String childPath)
     *
     * 2.相对路径：相较于某个路径下指明的路径
     *
     * 3.路径分隔符：
     *  windows：\\
     *
     *
     */
    @Test
    public void test01(){
        //构造器1：
        File file1 = new File("Hello.txt");//相对路径
        File file2 = new File("D:\\java\\javaScoreShangGuigu\\JavaSenior\\Demo08\\src\\Demo08_06");//绝对路径

        System.out.println(file1);
        System.out.println(file2);
    }

    /**
     * File类的获取功能：
     *  1.public String getAbsolutePath():获取绝对路径
     *  2.public String getPath():获取路径
     *  3.public String getName():获取名称
     *  4.public String getParent()：获取上层文件目录路径。如果没用返回null
     *  5.public long length(): 获取文件长度（字节数）。不能获取目录的长度
     *  6.public long lastModified():获取最红一次修改时间，毫秒值
     *
     * 获取文件目录的路径：
     *  7.public String[] list():获取指定目录下的所用文件或者文件目录的名称数组
     *  8.public File[] listFiles():获取指定目录下的所有文件或者文件目录的File数组
     *
     */
    @Test
    public void test02(){
        File file1 = new File("Hello.txt");
        File file2 = new File("D:\\java\\javaScoreShangGuigu\\io");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));


        System.out.println();

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));

    }

    @Test
    public void test03(){
        File file1 = new File("D:\\java\\javaScoreShangGuigu");
        String[] list = file1.list();
        for(String s : list){
            System.out.println(s);
        }

        System.out.println();

        File[] file = file1.listFiles();
        for(File f : file){
            System.out.println(f);
        }

    }

    /**
     * public boolean renameTo(File dest):把文件重命名为指定的文件路径
     * 注意：保证文件1存在， 文件2不存在才能进行此操作
     */
    @Test
    public void test04(){
        File file1 = new File("Hello.txt");
        File file2 = new File("D:\\java\\javaScoreShangGuigu\\io\\Hi.txt");

        System.out.println(file2.renameTo(file1));
    }

    /**
     * File类的判断功能：
     * public boolean isDirectory():判断是否是文件目录
     * public boolean isFile():判断是否是文件
     * public boolean exists():判断文件是否存在
     * public boolean canRead():是否可读
     * public boolean canWrite():判断是否可写
     * public boolean isHidden():判断是否隐藏
     *
     */

    @Test
    public void test05(){
        File file1 = new File("Hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

    }

    /**创建硬盘中对应的文件或者文件目录
     * public boolean createNewFile():创建文件。若文件存在，则不城建，返回false
     * public boolean mkdir():创建问价目录。如果此文件的目录存在，就不创建了
     * public boolean mkdirs() : 创建文件目录。如果上层文件目录不存在，一并创建
     *
     * 删除硬盘中的文件或文件目录
     * public boolean delete():删除文件或者文件夹
     *      删除注意事项：
     *      Java中的删除不走回收站
     *
     */

    @Test
    public void test06(){
        //关于文件的创建
        File file = new File("Hi.txt");
        if(!file.exists()){//文件不存在，创建
            try {
                file.createNewFile();
                System.out.println("文件创建成功！");
            } catch (IOException e) {

            }
        }else{//文件存在
            file.delete();
            System.out.println("文件删除成功！");
        }

    }
}






















