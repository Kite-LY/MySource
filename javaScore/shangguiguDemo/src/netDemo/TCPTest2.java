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
 * ʵ��TCP������
 * ����2���ͻ��˷����ļ���������������˽��ļ������ڱ���
 * 
 * @author С����
 *
 */
public class TCPTest2 {
	 
	//out д         in ��
	
	/*
	 * �漰���쳣Ӧ��ʹ��try-catch-finally����
	 * */
	@Test
	public void client() throws IOException {
		Socket socket = new Socket(InetAddress.getByName("192.168.0.113"), 9090);
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("KyxX5.jpeg"));		//��ȡ�ļ���������
		byte[] buffer = new byte[1024];
		while((fis.read(buffer)) != -1) {
			os.write(buffer);
		}
		//�ر���Դ
		fis.close();
		os.close();
		socket.close();
	}
	
	
	@Test
	public void server() throws IOException {
		ServerSocket ss = new ServerSocket(9090);
		Socket socket = ss.accept();
		InputStream is = socket.getInputStream();			//д����
		FileOutputStream fos = new FileOutputStream(new File("gaosan.jpeg"));		//�����ֽ�������
		byte[] buffer = new byte[1024];
		while((is.read(buffer)) != -1) {
			fos.write(buffer);
		}
		System.out.println("�����ļ��ɹ���");
		fos.close();
		is.close();
		socket.close();
		ss.close();
	}
}






























