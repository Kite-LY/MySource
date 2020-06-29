package netDemo;


import java.net.InetAddress;
import java.net.UnknownHostException;

//��Java��ʹ��InetAddress�����IP
/**
 * 1.���ʵ����InetAddress������������
 * 							1��getByName(String host)  2.getLocalHaost()
 * 						  �������õķ�����getHostName / fetHostAddress();
 * 
 * 
 * 2.�˿ںţ���ʶ�������������еĳ���	
 * 	 Ҫ�󣺲����ý������Ų�ͬ�Ķ˿ں�
 * 3.�˿ں���IP��ַ����ϵó�һ����·�׽��֣�Socket
 * @author С����
 *
 */

public class InetAddressTest {

	public static void main(String[] args) {
		try {
			InetAddress inet1 = InetAddress.getByName("192.168.10.14");
			System.out.println(inet1);
			
			InetAddress inet2 = InetAddress.getByName("www.baidu.com");
			System.out.println(inet2);
			
			//��ȡ������ip��ַ
			InetAddress inet3 = InetAddress.getLocalHost();
			System.out.println(inet3);
			
			System.out.println(inet3.getHostName());
			System.out.println(inet3.getHostAddress());
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}











