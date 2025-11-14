import java.net.*;
import java.io.*;

public class InetAdress {
    

       public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();

            System.out.println("Host Name: " + localHost.getHostName());
            System.out.println("IP Address: " + localHost.getHostAddress());

            if(localHost.isReachable(5000)) {
                System.out.println("The host is reachable.");
            } else {
                System.out.println("The host is not reachable.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Unable to find host.");
        } catch (IOException e) {
            System.out.println("Error checking reachability.");
        }
    }
}
