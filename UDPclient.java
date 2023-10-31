import java.io.*;
import java.net.*;

public class UDPclient {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket();
            String message = "Hello Server";
            byte[] sendData = message.getBytes();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);

            System.out.println("Message sent to server: " + message);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
