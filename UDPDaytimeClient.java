import java.net.*;

public class UDPDaytimeClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");

        byte[] send = new byte[1];
        byte[] recv = new byte[1024];

        ds.send(new DatagramPacket(send, send.length, ip, 9999));

        DatagramPacket rp = new DatagramPacket(recv, recv.length);
        ds.receive(rp);

        System.out.println("Server Time: " +
            new String(rp.getData(), 0, rp.getLength()));

        ds.close();
    }
}
