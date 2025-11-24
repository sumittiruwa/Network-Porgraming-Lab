import java.net.*;

public class ProtocolCheck {

    public static void main(String[] args) {

        String protocols[] = {"http", "https", "ftp", "file", "jar"};

        for (String p : protocols) {
            try {
                URL url = new URL(p + "://google.com");
                System.out.println(p + " protocol is supported.");
            } catch (Exception e) {
                System.out.println(p + " protocol is NOT supported.");
            }
        }
    }
}
