import java.net.*;
import java.io.*;
import java.util.*;

public class PrintHTTPHeader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://letterboxd.com/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            // Print all HTTP headers
            Map<String, List<String>> headers = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> h : headers.entrySet()) {
                System.out.println(h.getKey() + " : " + h.getValue());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
