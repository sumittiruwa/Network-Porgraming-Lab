// MultiThreadServer.java
import java.net.*;
import java.io.*;

class Worker extends Thread {
    Socket s;
    Worker(Socket s) { this.s = s; }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            int n = Integer.parseInt(in.readLine());
            out.println(isPrime(n) ? "Prime Number" : "Not Prime");

            s.close();
        } catch (Exception e) {}
    }

    boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= n/2; i++)
            if (n % i == 0) return false;
        return true;
    }
}

public class MultiThreadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");
        while (true) new Worker(ss.accept()).start();
    }
}
