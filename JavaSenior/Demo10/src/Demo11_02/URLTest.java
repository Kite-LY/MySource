package Demo11_02;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * UR:网络编程
 *
 */
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.bilibili.com/");
        System.out.println(url.getProtocol());  //获取协议名
        System.out.println(url.getHost());      //获取主机名
        System.out.println(url.getPort());      //获取端口号
        System.out.println(url.getPath());      //获取文件路径
        System.out.println(url.getFile());      //获取文件名

    }


    @Test
    public void test01(){
        HttpURLConnection uc = null;
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080//examples/Hello.txt");

            uc = (HttpURLConnection) url.openConnection();
            uc.connect();
            inputStream = uc.getInputStream();
            fos = new FileOutputStream("UPR.txt");

            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            System.out.println("文件下载完成！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            uc.disconnect();

        }


    }
}
