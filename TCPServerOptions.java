
import java.net.*;

public class TCPServerOptions {
    public static void main(String[] args) throws Exception {
        // Create server socket
        ServerSocket ss = new ServerSocket();

        // Set server socket options
        ss.setReuseAddress(true);      
        ss.setSoTimeout(5000);          
        ss.setReceiveBufferSize(8192);   

        // Bind to port
        ss.bind(new InetSocketAddress(5000));
        System.out.println("Server started with options set. Waiting for client...");

        try {
            Socket s = ss.accept();
            System.out.println("Client connected!");
            s.close();
        } catch (SocketTimeoutException e) {
            System.out.println("No client connected within timeout.");
        }

        ss.close();
    }
}
