import java.io.*;
import java.net.*;

public class DaytimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            // Read the server's date & time
            String time = in.readLine();
            System.out.println("Server Time: " + time);

            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
