import java.net.*;

public class TCPSocketInfo {
    public static void main(String[] args) {
        try {
            // Connect to a server (Example: google.com on port 80)
            Socket socket = new Socket("google.com", 80);

            System.out.println("Connected to server!");
            System.out.println("Remote Address: " + socket.getInetAddress());
            System.out.println("Remote Port: " + socket.getPort());
            System.out.println("Local Address: " + socket.getLocalAddress());
            System.out.println("Local Port: " + socket.getLocalPort());
            System.out.println("Keep-Alive: " + socket.getKeepAlive());
            System.out.println("TCP No Delay: " + socket.getTcpNoDelay());

            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
