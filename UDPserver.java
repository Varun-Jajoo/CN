import java.io.*;
import java.net.*;

public class UDPserver {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];

            System.out.println("Server is waiting for a client...");

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket); // data ka wait krta hai (UDP)

            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Message received from client: " + message);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }
}