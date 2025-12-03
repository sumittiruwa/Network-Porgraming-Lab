// TCPTextServer.java
import java.net.*;
import java.io.*;

public class TCPTextServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started... Waiting for client.");

        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        pw.println("Hello Client! Message received.");

        String msg = br.readLine();
        System.out.println("Client says: " + msg);

        s.close();
        ss.close();
    }
}
