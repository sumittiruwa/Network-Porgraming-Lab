import java.net.*;
import java.io.*;

public class FactorialClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a number: ");
        String num = userInput.readLine();

        out.println(num);  // send number to server
        System.out.println(in.readLine());  // receive factorial

        s.close();
    }
}
