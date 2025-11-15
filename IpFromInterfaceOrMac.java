import java.net.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IpFromInterfaceOrMac {

    // Get IP address by network interface name
    public static String getIpFromInterface(String interfaceName) throws SocketException {
        NetworkInterface networkInterface = NetworkInterface.getByName(interfaceName);
        if (networkInterface != null && networkInterface.isUp()) {
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                    return inetAddress.getHostAddress();
                }
            }
        }
        return null;
    }

    // Get IP address by MAC address by parsing ARP cache (works if MAC-IP mapping exists)
    public static String getIpFromMac(String macAddress) {
        try {
            Process p = Runtime.getRuntime().exec("arp -a");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            macAddress = macAddress.toLowerCase().replace("-", ":");
            while ((line = input.readLine()) != null) {
                String lineLower = line.toLowerCase();
                if (lineLower.contains(macAddress)) {
                    // Parse IP address from line (Windows arp -a line format)
                    String[] parts = line.split("\\s+");
                    for (String part : parts) {
                        if (part.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) {
                            input.close();
                            return part;
                        }
                    }
                }
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // List all network interfaces with their names and MAC addresses
    public static void listInterfaces() throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        System.out.println("Available Network Interfaces:");
        while (interfaces.hasMoreElements()) {
            NetworkInterface nif = interfaces.nextElement();
            byte[] mac = nif.getHardwareAddress();
            String macStr = (mac != null) ? formatMacAddress(mac) : "N/A";
            System.out.printf("Name: %s | Display Name: %s | MAC: %s%n", nif.getName(), nif.getDisplayName(), macStr);
        }
    }

    private static String formatMacAddress(byte[] mac) {
        StringBuilder sb = new StringBuilder();
        for (byte b : mac) {
            sb.append(String.format("%02X", b)).append(":");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        listInterfaces();

        System.out.println("\nEnter 1 to provide Interface Name or 2 to provide MAC Address:");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice == 1) {
            System.out.print("Enter Interface Name: ");
            String interfaceName = scanner.nextLine();
            String ip = getIpFromInterface(interfaceName);
            if (ip != null) {
                System.out.println("IP Address for interface " + interfaceName + ": " + ip);
            } else {
                System.out.println("No IP address found for interface " + interfaceName);
            }
        } else if (choice == 2) {
            System.out.print("Enter MAC Address (e.g. 00:1A:2B:3C:4D:5E): ");
            String mac = scanner.nextLine();
            String ip = getIpFromMac(mac);
            if (ip != null) {
                System.out.println("IP Address for MAC " + mac + ": " + ip);
            } else {
                System.out.println("No IP address found for MAC " + mac);
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
