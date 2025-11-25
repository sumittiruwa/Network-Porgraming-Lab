import java.net.URLDecoder;

public class URLDecoderLab {
    public static void main(String[] args) {
        try {
            String encoded = "Hello+Java+Programming+%40+2025%21";
            String decoded = URLDecoder.decode(encoded, "UTF-8");

            System.out.println("Encoded: " + encoded);
            System.out.println("Decoded: " + decoded);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
