import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOServer {
    public static void main(String[] args) {
        int port = 5000;
        try {
            // Open server socket channel
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(port));
            System.out.println("Server started on port " + port);

            while (true) {
                SocketChannel clientChannel = serverChannel.accept(); // Accept client
                System.out.println("Client connected: " + clientChannel.getRemoteAddress());

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int bytesRead = clientChannel.read(buffer);
                while (bytesRead > 0) {
                    buffer.flip();
                    String message = new String(buffer.array(), 0, buffer.limit());
                    System.out.println("Client says: " + message);
                    buffer.clear();
                    bytesRead = clientChannel.read(buffer);
                }

                clientChannel.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
