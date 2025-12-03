import java.net.*;
import java.io.*;

public class RetrieveHeaders {
    public static void main(String[] args) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL("https://www.netflix.com/np/").openConnection();
            conn.connect();

            // Retrieve specific headers
            System.out.println("Content-Type: " + conn.getHeaderField("Content-Type"));
            System.out.println("Server: " + conn.getHeaderField("Server"));
            System.out.println("Date: " + conn.getHeaderField("Date"));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
