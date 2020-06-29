package Demo11_02;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 案例3：从客户端附送文件给服务端，服务端保存到本地，并返回：发送成功  给客户端
 */
public class TCPTest3 {

    @Test
    public void client() throws IOException {
        Socket socket = new Socket("192.168.0.110", 2299);
        OutputStream outputStream = socket.getOutputStream();

        FileInputStream fis = new FileInputStream("ai.jpeg");

        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            outputStream.write(buffer,0,len);
        }
        socket.shutdownOutput();  //停止向服务端写数据,关闭数据的输出

        InputStream in = socket.getInputStream();
        byte[] buffer1 = new byte[1024];
        int len1;
        while((len1 = in.read(buffer1)) != -1){
            String arr = new String(buffer1);
            System.out.print(arr);
        }



        fis.close();
        outputStream.close();
        socket.close();

    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(2299);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();//要将图片读入到程序中

        FileOutputStream fos = new FileOutputStream("aiTCPResent.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        System.out.println("文件传输成功!");

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("收到了你发送的图片".getBytes());

        fos.close();
        inputStream.close();
        accept.close();
        serverSocket.close();

    }

}
