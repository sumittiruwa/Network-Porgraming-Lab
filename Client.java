
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.print("Enter message: ");
            String msg = keyboard.readLine();

            out.println(msg);
            System.out.println("Echo from server: " + in.readLine());

            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
