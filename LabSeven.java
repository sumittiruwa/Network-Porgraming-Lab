//Write a program to find MAC Address of the system

import java.net.InetAddress;
import java.net.NetworkInterface;

public class LabSeven {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            System.out.print("MAC Address: ");
            for (int i = 0; i < mac.length; i++) {
                System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
