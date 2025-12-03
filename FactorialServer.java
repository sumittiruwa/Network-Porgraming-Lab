import java.net.*;
import java.io.*;

public class FactorialServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket s = server.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        int n = Integer.parseInt(in.readLine());
        long fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;

        out.println("Factorial of " + n + " is " + fact);
        s.close(); server.close();
    }
}
