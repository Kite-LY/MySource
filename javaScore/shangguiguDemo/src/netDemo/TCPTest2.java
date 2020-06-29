package netDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

/**
 * 实现TCP网络编程
 * 例题2：客户端发送文件给服务器，服务端将文件保存在本地
 * 
 * @author 小风筝
 *
 */
public class TCPTest2 {
	 
	//out 写         in 读
	
	/*
	 * 涉及的异常应该使用try-catch-finally处理
	 * */
	@Test
	public void client() throws IOException {
		Socket socket = new Socket(InetAddress.getByName("192.168.0.113"), 9090);
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("KyxX5.jpeg"));		//获取文件的输入流
		byte[] buffer = new byte[1024];
		while((fis.read(buffer)) != -1) {
			os.write(buffer);
		}
		//关闭资源
		fis.close();
		os.close();
		socket.close();
	}
	
	
	@Test
	public void server() throws IOException {
		ServerSocket ss = new ServerSocket(9090);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();			//写入流
		FileOutputStream fos = new FileOutputStream(new File("gaosan.jpeg"));		//基于字节流方法
		byte[] buffer = new byte[1024];
		while((is.read(buffer)) != -1) {
			fos.write(buffer);
		}
		System.out.println("接受文件成功！");
		fos.close();
		is.close();
		socket.close();
		ss.close();
	}
}






























