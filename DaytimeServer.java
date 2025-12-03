import java.io.*;
import java.net.*;
import java.util.Date;

public class DaytimeServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Daytime Server started...");

            while (true) {
                Socket socket = server.accept();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send current date and time
                out.println(new Date().toString());

                socket.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
