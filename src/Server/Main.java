package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        
        try {
            serverSocket = new ServerSocket(888);
            System.out.println("Server started");
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        
        while(true) {
            try {
                socket = serverSocket.accept();
                System.out.println("Client Connected");
                Object obj = new clientHandler(socket);
                Thread thread = new Thread((Runnable) obj);
                thread.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
    }
}
