import java.net.*;

public class UDPArmstrongServer {
    public static void main(String[] args) throws Exception {
        try (DatagramSocket ds = new DatagramSocket(7777)) {
            byte[] recv = new byte[1024];

            System.out.println("UDP Armstrong Server Running...");

            while (true) {
            DatagramPacket rp = new DatagramPacket(recv, recv.length);
            ds.receive(rp);

            String numStr = new String(rp.getData(), 0, rp.getLength());
            int num = Integer.parseInt(numStr);

            int temp = num, sum = 0, digit;
            while (temp > 0) {
                digit = temp % 10;
                sum += digit * digit * digit;
                temp /= 10;
            }

            String result = (sum == num)
                    ? num + " is an Armstrong number"
                    : num + " is not an Armstrong number";

            byte[] send = result.getBytes();
            DatagramPacket sp = new DatagramPacket(send, send.length, rp.getAddress(), rp.getPort());
                ds.send(sp);
            }
        }
    }
}
