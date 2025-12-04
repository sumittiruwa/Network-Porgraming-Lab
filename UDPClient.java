import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter message: ");
            String message = sc.nextLine();

            byte[] sendData = message.getBytes();
            byte[] receiveData = new byte[1024];

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String echo = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Echo from server: " + echo);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
