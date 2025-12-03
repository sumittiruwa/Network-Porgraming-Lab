import java.net.*;

public class GovCookie {
    public static void main(String[] args) {
        // Set custom cookie policy
        CookieHandler.setDefault(new CookieManager(null, new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                // Block cookies from .gov domains
                return !uri.getHost().endsWith(".gov");
            }
        }));

        System.out.println("Custom CookiePolicy set: .gov cookies blocked, others allowed.");
    }
}
