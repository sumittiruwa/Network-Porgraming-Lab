import java.net.*;
import java.io.*;

public class DownloadWebPageURLC {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://github.com/");
            URLConnection conn = url.openConnection();

            BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
            );

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            in.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
