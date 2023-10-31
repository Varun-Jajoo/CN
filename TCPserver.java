import java.io.*;
import java.net.*;

public class TCPserver {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server is waiting for a client...");
            Socket s = ss.accept(); // connection less hota hai TCP

            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = dis.readUTF();
            System.out.println("Message received from client: " + str);

            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
