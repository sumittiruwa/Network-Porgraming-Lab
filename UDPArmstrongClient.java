import java.net.*;
import java.util.Scanner;

public class UDPArmstrongClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String num = sc.nextLine();

        byte[] send = num.getBytes();
        byte[] recv = new byte[1024];

        ds.send(new DatagramPacket(send, send.length, ip, 7777));

        DatagramPacket rp = new DatagramPacket(recv, recv.length);
        ds.receive(rp);

        String result = new String(rp.getData(), 0, rp.getLength());
        System.out.println("Server: " + result);

        ds.close();
    }
}
