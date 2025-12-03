import java.net.*;
import java.io.*;

public class DownloadWebPage {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.mangaread.org");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Detect charset from Content-Type
            String charset = "UTF-8"; // default
            String contentType = conn.getContentType();
            if (contentType != null && contentType.contains("charset=")) {
                charset = contentType.substring(contentType.indexOf("charset=") + 8).trim();
            }

            // Read and print page
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
            String line;
            while ((line = in.readLine()) != null) System.out.println(line);
            in.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
