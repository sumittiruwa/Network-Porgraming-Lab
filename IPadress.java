import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPadress {
    public static void main(String[] args) {
        try {
            // Get the local host (your system)
            InetAddress localHost = InetAddress.getLocalHost();
            
            // Get the host IP address
            String ipAddress = localHost.getHostAddress();
            
            // Display the IP address
            System.out.println("Your system's IP address is: " + ipAddress);
        } catch (UnknownHostException e) {
            System.out.println("Unable to find IP address.");
            e.printStackTrace();
        }
    }
}
