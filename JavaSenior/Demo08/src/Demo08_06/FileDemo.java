package Demo08_06;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileDemo {

    @Test
    public void test01() throws IOException {
        File file  = new File("D:\\java\\javaScoreShangGuigu\\io\\Hello.txt");
        //创建一个与file同目录下的另一个文件，文件名为：haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("文件创建成功！");
        }
    }
}
