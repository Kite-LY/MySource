package Demo11_02;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//kite/192.168.0.110

/**
 * 案例1：客服端发送消息给服务端，服务端将数据显示到控制台上面
 *
 */
public class TCPTest {
    //客户端
    @Test
    public void test01(){
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket("192.168.0.110", 2299);
            outputStream = socket.getOutputStream();
            outputStream.write("哈喽，服务端!".getBytes());  //字符串要转为字节
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    //服务端
    @Test
    public void test02(){
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;  //需要写出数据
        try {
            serverSocket = new ServerSocket(2299);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();

            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = inputStream.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());
            System.out.println("数据来源于：" + accept.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}














