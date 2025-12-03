import java.net.*;
import java.io.*;
import java.util.*;

public class ArbitraryHeaders {
    public static void main(String[] args) {
        try {
            // Connect to a website
            HttpURLConnection conn = (HttpURLConnection) new URL("http://google.com").openConnection();
            conn.connect();

            // Get all headers as a map
            Map<String, List<String>> headers = conn.getHeaderFields();

            // Print all headers
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
