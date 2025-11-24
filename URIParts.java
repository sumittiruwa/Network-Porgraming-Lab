import java.net.*;

public class URIParts {

    public static void main(String[] args) {
        try {
            URI uri = new URI("https://www.instagram.com/?__pwa=1");

            System.out.println("Scheme   : " + uri.getScheme());
            System.out.println("Host     : " + uri.getHost());
            System.out.println("Port     : " + uri.getPort());
            System.out.println("Path     : " + uri.getPath());
            System.out.println("Query    : " + uri.getQuery());
            System.out.println("Fragment : " + uri.getFragment());

        } catch (Exception e) {
            System.out.println("Invalid URI!");
        }
    }
}
