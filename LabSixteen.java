import java.io.IOException;
import java.net.*;
import java.util.*;

public class LabSixteen extends ProxySelector {

    private final Map<String, Proxy> remembered = new HashMap<>();

    private final ProxySelector systemSelector;

    public LabSixteen() {
        systemSelector = ProxySelector.getDefault();
    }

    @Override
    public List<Proxy> select(URI uri) {
        
        if (remembered.containsKey(uri.getHost())) {
            return Collections.singletonList(remembered.get(uri.getHost()));
        }
      
        return systemSelector != null ? systemSelector.select(uri)
                                      : Collections.singletonList(Proxy.NO_PROXY);
    }

    @Override
    public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        System.out.println("Connection failed to " + uri + " via " + sa + ": " + ioe.getMessage());
      
        remembered.put(uri.getHost(), Proxy.NO_PROXY);
    }

    public static void main(String[] args) {
       
        ProxySelector.setDefault(new LabSixteen());

        try {
            URL url = new URL("http://google.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.connect();
            System.out.println("Connected to " + url + " successfully!");
        } catch (IOException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
