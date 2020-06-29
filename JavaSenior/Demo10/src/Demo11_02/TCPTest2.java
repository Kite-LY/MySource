package Demo11_02;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest2 {

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
        fis.close();
        outputStream.close();
        socket.close();

    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(2299);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();//要将图片读入到程序中

        FileOutputStream fos = new FileOutputStream("aiTCP.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        System.out.println("文件传输成功!");
        fos.close();
        inputStream.close();
        accept.close();
        serverSocket.close();

    }



}




















