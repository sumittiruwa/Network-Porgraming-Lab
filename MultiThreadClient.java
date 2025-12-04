// MultiThreadClient.java
import java.net.*;
import java.io.*;

public class MultiThreadClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        System.out.print("Enter a number: ");
        out.println(kb.readLine());

        System.out.println("Server says: " + in.readLine());

        s.close();
    }
}
