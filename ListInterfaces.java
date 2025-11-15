import java.net.*;
import java.util.*;

public class ListInterfaces {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces =
                    NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                System.out.println("Interface Name: " + ni.getName());
                System.out.println("Display Name : " + ni.getDisplayName());
                System.out.println("------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
