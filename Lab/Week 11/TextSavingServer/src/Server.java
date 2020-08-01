import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * this class represents the server
 * @author Ali Khorramipour
 */

public class Server {
    private String text; // final text
    private StringBuilder textTemp; // temporary string for holding the information coming from the client

    public Server(){
        this.textTemp = new StringBuilder();
        try{
            ServerSocket serverSocket = new ServerSocket(666);
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            Scanner inputStream = new Scanner(dataInputStream);

             String temp = inputStream.nextLine();
            while (!temp.isEmpty()){
                this.textTemp.append(temp);
            }
            this.text = this.textTemp.toString();

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
