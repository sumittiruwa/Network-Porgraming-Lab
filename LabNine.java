import java.net.*;
import java.util.Enumeration;

public class LabNine { // keep class name LabNine
    public static void main(String[] args) {
        try {
            // --- Factory Methods ---
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();

                // --- Getter Methods ---
                System.out.println("Name: " + ni.getName());
                System.out.println("Display Name: " + ni.getDisplayName());

                // MAC address
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    System.out.println("MAC Address: " + sb.toString());
                } else {
                    System.out.println("MAC Address: Not Available");
                }

                // Check interface status
                System.out.println("Is Up: " + ni.isUp());
                System.out.println("Is Loopback: " + ni.isLoopback());
                System.out.println("Supports Multicast: " + ni.supportsMulticast());

                // List IP addresses
                Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress addr = inetAddresses.nextElement();
                    System.out.println("IP Address: " + addr.getHostAddress());
                }

                System.out.println("----------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
