package netDemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;




/**
 * ʵ��tcp��������
 * ����1���ͻ��˷�����Ϣ������ˣ�����˽�������ʾ�ڿ���̨��
 * 
 * @author С����
 *
 */
public class TCPTset1 {
	
	//�ͻ���
	@Test
	public void client()  {
		InetAddress inet1;
		Socket socket =null;
		OutputStream os = null;
		try {
			//1.����Socket����ָ����������ip�Ͷ˿ں�
			inet1 = InetAddress.getByName("192.168.0.113");
			socket = new Socket(inet1, 8890);
			//2.��ȡһ����������������ݵĴ���
			os = socket.getOutputStream();
			//3.д�����ݲ���
			os.write("��ã����ǿͻ���".getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//4.��Դ�Ĺر� 
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		


	}
	
	
	//�����
	@Test
	public void server() {
		ServerSocket ss = null;
		Socket socket  = null;
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			//1.����һ����������ServerSocket��ָ���Լ��Ķ˿ں�
			ss = new ServerSocket(8890);
			//2.����accept����������ʶ���������ڿͻ��˵�socket
			socket = ss.accept();
			//3.��ȡ������
			is = socket.getInputStream();
			//4.��ȡ�������е�����
			baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[5];
			int len;
			while((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			System.out.println(baos.toString());
			System.out.println("�յ��������ڣ�" + socket.getInetAddress().getHostAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//�ر���Դ
				baos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				is.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	
}











