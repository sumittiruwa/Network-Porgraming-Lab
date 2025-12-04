import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NIOClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try {
            SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress(host, port));
            Scanner scanner = new Scanner(System.in);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            System.out.println("Connected to server. Type messages:");

            while (true) {
                String message = scanner.nextLine();
                if (message.equalsIgnoreCase("exit")) break;

                buffer.put(message.getBytes());
                buffer.flip();
                clientChannel.write(buffer);
                buffer.clear();
            }

            clientChannel.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
