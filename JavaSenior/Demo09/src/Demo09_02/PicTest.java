package Demo09_02;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicTest {
    /**
     * 图片的加密
     */
    @Test
    public void test01(){
        FileInputStream fs = null;
        FileOutputStream fo = null;
        try {
            fs = new FileInputStream("ai.jpeg");
            fo = new FileOutputStream("aiSecret.jpeg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fs.read(buffer)) != -1){
                for(int i = 0; i < len; i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);  //将buffer的值进行加密重新赋值到buffer上
                }
                fo.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fo != null)
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fs != null)
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 图片的解密密
     */
    @Test
    public void test02(){
        FileInputStream fs = null;
        FileOutputStream fo = null;
        try {
            fs = new FileInputStream("aiSecret.jpeg");
            fo = new FileOutputStream("aiSecretCopy.jpeg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fs.read(buffer)) != -1){
                for(int i = 0; i < len; i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);  //将buffer的值进行加密重新赋值到buffer上
                }
                fo.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fo != null)
                    fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fs != null)
                    fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
























