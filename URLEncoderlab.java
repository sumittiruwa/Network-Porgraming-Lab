import java.net.URLEncoder;

public class URLEncoderlab {
    public static void main(String[] args) {
        try {
            String text = "hello naruto uzumaki 123 !@#";

            
            String encodedText = URLEncoder.encode(text, "UTF-8");

            System.out.println("Original Text: " + text);
            System.out.println("Encoded Text: " + encodedText);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
