package classLecture;

import java.net.*;
import java.util.*;
import java.net.NetworkInterface;

public class lab9 {
    public static void main(String[] args) {
        try {
            NetworkInterface netIf = NetworkInterface.getByName("ethernet_");

            if (netIf != null) {
                System.out.println("Name: " + netIf.getName());
                System.out.println("Display Name: " + netIf.getDisplayName());
                System.out.println("Is Up: " + netIf.isUp());
                System.out.println("Is Loopback: " + netIf.isLoopback());
                System.out.println("Supports Multicast: " + netIf.supportsMulticast());
            } else {
                System.out.println("Network Interface not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
