
package Server;

import Client.LoginSwingUI;
import java.net.Socket;


public class clientHandler implements Runnable {
    Socket socket;
    
    clientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Now calling the LoginSwingUI");
        System.out.println(socket.getInetAddress().getHostAddress());
        LoginSwingUI ui = new LoginSwingUI();
        ui.hide();
        ui.setVisible(true);
        System.out.println("Calling of LoginSwingUI ended");
    }
}
