package netDemo;


import java.net.InetAddress;
import java.net.UnknownHostException;

//在Java中使用InetAddress类代表IP
/**
 * 1.如何实例化InetAddress：两个方法：
 * 							1。getByName(String host)  2.getLocalHaost()
 * 						  两个常用的方法：getHostName / fetHostAddress();
 * 
 * 
 * 2.端口号：标识正在主机上运行的程序	
 * 	 要求：不懂得进程有着不同的端口号
 * 3.端口号与IP地址的组合得出一个网路套接字：Socket
 * @author 小风筝
 *
 */

public class InetAddressTest {

	public static void main(String[] args) {
		try {
			InetAddress inet1 = InetAddress.getByName("192.168.10.14");
			System.out.println(inet1);
			
			InetAddress inet2 = InetAddress.getByName("www.baidu.com");
			System.out.println(inet2);
			
			//获取本机的ip地址
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











