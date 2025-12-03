// TCPTextClient.java
import java.net.*;
import java.io.*;

public class TCPTextClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        System.out.println("Server says: " + br.readLine());

        pw.println("Hello Server! This is Client.");

        s.close();
    }
}
