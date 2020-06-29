package Demo11_02;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议的网路编程
 *
 */
public class UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String arr = "UDP发送的文件!";
        byte[] buffer = arr.getBytes();

        DatagramPacket datagramPacket = new DatagramPacket(buffer,0,buffer.length, InetAddress.getLocalHost(), 8989);

        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
    //接收端
    @Test
    public void revere() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8989);
        byte[] buffer = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buffer, 0, buffer.length);
        datagramSocket.receive(dp);

        System.out.println(new String(dp.getData(),0,dp.getLength()));
        datagramSocket.close();
    }
}
