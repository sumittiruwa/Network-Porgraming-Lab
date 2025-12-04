import java.net.*;
import java.util.Date;

public class UDPDaytimeServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(9999);
        byte[] buf = new byte[1];

        while (true) {
            DatagramPacket rp = new DatagramPacket(buf, buf.length);
            ds.receive(rp);

            String time = new Date().toString();
            byte[] data = time.getBytes();

            DatagramPacket sp = new DatagramPacket(
                data, data.length, rp.getAddress(), rp.getPort());
            ds.send(sp);
        }
    }
}
