import java.net.*;

public class CheckIP {
    public static void main(String[] args) {

        String[] testIPs = {
            "192.168.1.1",
            "2405:204:6109:8c3f::1",
            "abcd::1234",
            "256.10.20.30",
            "hello.world"
        };

        for (String ip : testIPs) {
            System.out.println(ip + " --> " + checkIPAddress(ip));
        }
    }

    public static String checkIPAddress(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);

            if (address instanceof Inet4Address) {
                return "Valid IPv4 Address";
            } else if (address instanceof Inet6Address) {
                return "Valid IPv6 Address";
            } else {
                return "Unknown IP Format";
            }

        } catch (Exception e) {
            return "Invalid IP Address";
        }
    }
}
