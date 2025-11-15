import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Scanner;

public class MACAddressRetriever {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter IP Address: ");
            String ipAddress = sc.nextLine();

            // Get InetAddress object from IP
            InetAddress inet = InetAddress.getByName(ipAddress);

            // Get the network interface corresponding to this IP
            NetworkInterface network = NetworkInterface.getByInetAddress(inet);

            if (network == null) {
                System.out.println("No network interface found for IP: " + ipAddress);
                return;
            }

            // Get MAC address in byte array
            byte[] mac = network.getHardwareAddress();

            if (mac == null) {
                System.out.println("MAC address not found for IP: " + ipAddress);
                return;
            }

            // Convert byte array to readable MAC format
            StringBuilder macAddress = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }

            System.out.println("MAC Address: " + macAddress.toString());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
