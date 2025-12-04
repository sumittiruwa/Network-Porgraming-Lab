import java.net.*;

public class UDPSocketInfo {
    public static void main(String[] args) {
        try {
            // Create a UDP socket (binds to any available port)
            DatagramSocket socket = new DatagramSocket();

            // Display UDP socket information
            System.out.println("UDP Socket Information:");
            System.out.println("------------------------");
            System.out.println("Local Address : " + socket.getLocalAddress());
            System.out.println("Local Port    : " + socket.getLocalPort());
            System.out.println("Is Bound      : " + socket.isBound());
            System.out.println("Is Closed     : " + socket.isClosed());
            System.out.println("Is Connected  : " + socket.isConnected());

            // Optional: Connect to a remote address
            InetAddress remote = InetAddress.getByName("localhost");
            socket.connect(remote, 9999);
            System.out.println("After connecting to " + remote + ":9999");
            System.out.println("Is Connected  : " + socket.isConnected());
            System.out.println("Remote Address: " + socket.getRemoteSocketAddress());

            // Close the socket
            socket.close();
            System.out.println("After closing:");
            System.out.println("Is Closed     : " + socket.isClosed());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
