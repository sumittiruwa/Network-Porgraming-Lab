import java.net.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Scanner;

public class LabSeven {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter interface name or MAC address : ");
        String input = sc.nextLine().trim();

        boolean found = false;

        try {
            for(NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())){
                byte[] macBytes = ni.getHardwareAddress();
                String mac = formatMAC(macBytes);

                String normalizedInput = input.replace("-",":").toUpperCase();

                if(ni.getName().equalsIgnoreCase(input) || mac.equalsIgnoreCase(normalizedInput)){
                    found = true;
                    System.out.println("\n----------Network Interface Information----------");
                    System.out.println("Interface Name : " + ni.getName());
                    System.out.println("Display Name   : " + ni.getDisplayName());
                    System.out.println("MAC Address    : " + (mac.isEmpty() ? "N/A" : mac));

                    Enumeration<InetAddress> addresses = ni.getInetAddresses();
                    while(addresses.hasMoreElements()){
                        InetAddress adder = addresses.nextElement();
                        if (adder instanceof Inet4Address){
                            System.out.println("IPv4 Address : " + adder.getHostAddress());
                        } else if (adder instanceof Inet6Address){
                            System.out.println("IPv6 Address : " + adder.getHostAddress());
                        }
                    }
                    break;
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        if(!found){
            System.out.println("No matching interface found.");
        }
        sc.close();
    }

    static String formatMAC(byte[] mac) {
        if (mac == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X", mac[i]));
            if (i < mac.length - 1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }
}
