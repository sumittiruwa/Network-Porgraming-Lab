import java.net.*;

public class IPCharacteristics {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();

            System.out.println("IP Address: " + ip.getHostAddress());
            System.out.println("Loopback Address: " + ip.isLoopbackAddress());
            System.out.println("Link Local Address: " + ip.isLinkLocalAddress());
            System.out.println("Site Local Address: " + ip.isSiteLocalAddress());
            System.out.println("Multicast Address: " + ip.isMulticastAddress());
            System.out.println("Any Local Address: " + ip.isAnyLocalAddress());

        } catch (UnknownHostException e) {
            System.out.println("Unable to find IP address.");
        }
    }
}
