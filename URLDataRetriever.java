import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class URLDataRetriever {
    public static void main(String[] args) {
        try {
            // Specify the URL to retrieve data from
            URL url = new URL("https://expressjs.com/");
            
            // Open a connection to the URL
            URLConnection urlConnection = url.openConnection();
            
            // Create a BufferedReader to read from the URL's input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            
            String inputLine;
            
            // Read and print each line from the URL content
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            
            // Close the BufferedReader
            in.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
