import java.net.*;
import java.util.*;

public class Sevenlab {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Interface Display Name (e.g., Wi-Fi, Ethernet): ");
            String inputName = sc.nextLine();

            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            boolean found = false;

            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                String displayName = ni.getDisplayName();

                if (displayName.equalsIgnoreCase(inputName)) {
                    found = true;
                    Enumeration<InetAddress> addresses = ni.getInetAddresses();
                    System.out.println("IP addresses for interface: " + displayName);
                    while (addresses.hasMoreElements()) {
                        InetAddress ip = addresses.nextElement();
                        System.out.println(" - " + ip.getHostAddress());
                    }
                }
            }

            if (!found) {
                System.out.println("Interface not found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
