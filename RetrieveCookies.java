import java.net.*;
import java.util.*;

public class RetrieveCookies {
    public static void main(String[] args) {
        try {
            
            CookieManager manager = new CookieManager();
            CookieHandler.setDefault(manager);

            
            URL url = new URL("http://example.com");
            url.openConnection().connect();

            for (HttpCookie cookie : manager.getCookieStore().getCookies()) {
                System.out.println(cookie);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
