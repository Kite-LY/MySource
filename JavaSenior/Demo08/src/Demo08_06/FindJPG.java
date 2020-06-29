package Demo08_06;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * 输出jpg文件，如果存在就输出该文件名称
 *
 */
public class FindJPG {

    @Test
    public void test01(){
        File file = new File("D:\\我的小照片\\old");
        String[] fileName = file.list();
        for (String s : fileName) {
            if(s.endsWith(".jpg")){
                System.out.println(s);
            }
        }
    }

    /**
     * 打印指定目录中所有文件名称，包括子文件中的文件
     *
     */
    @Test
    public void test02(){
        //创建目录对象
        File file = new File("D:\\java\\javaScoreShangGuigu");
        //打印

        printFile(file);

        }
        public static void printFile(File file){
            File[] file1 = file.listFiles();
            for(File f : file1){
                if(f.isDirectory()){
                    printFile(f);
                }else {
                    System.out.println(f.getAbsoluteFile());
                }
            }

        }
}
