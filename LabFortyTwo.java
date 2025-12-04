import java.net.*;

public class LabFortyTwo {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(5000);                
        ds.setReceiveBufferSize(8192);        
        ds.setSendBufferSize(8192);           

        System.out.println("Timeout: " + ds.getSoTimeout());
        System.out.println("Receive Buffer: " + ds.getReceiveBufferSize());
        System.out.println("Send Buffer: " + ds.getSendBufferSize());

        ds.close();
    }
}
