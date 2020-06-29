package Demo11_02;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络通信
 *
 */
public class InterAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress byName = InetAddress.getByName("192.168.10.14");
            System.out.println(byName);
            InetAddress byName1 = InetAddress.getByName("www.baidu.com");
            System.out.println(byName1);

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);  //kite/192.168.0.110

            InetAddress byName2 = InetAddress.getByName("127.0.0.1");
            System.out.println(byName2);

            System.out.println();
            System.out.println(localHost.getHostName());
            System.out.println(localHost.getHostAddress());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
