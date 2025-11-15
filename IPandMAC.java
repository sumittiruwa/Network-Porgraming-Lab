import java.net.*;

public class IPandMAC {
    public static void main(String[] args) {
        try {
            // Get IP Address
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("IP Address: " + ip.getHostAddress());

            // Get MAC Address
            NetworkInterface ni = NetworkInterface.getByInetAddress(ip);
            byte[] mac = ni.getHardwareAddress();

            System.out.print("MAC Address: ");
            if (mac != null) {
                for (int i = 0; i < mac.length; i++) {
                    System.out.format("%02X%s",
                            mac[i], (i < mac.length - 1) ? "-" : "");
                }
            } else {
                System.out.print("Address not found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
