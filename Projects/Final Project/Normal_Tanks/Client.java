package game;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * this class represents the client
 */

public class Client {
    /**
     * constructor for this class
     */
    public Client(){
        try{
            Socket socket = new Socket("127.0.0.1", 666);
            ObjectInputStream toClient = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());

            Scanner output = new Scanner(System.in);
            /*String temp;
            while(true) {
                temp = output.nextLine();
                if(temp == "over")
                    break;
                else
                    outToClient.writeChars(temp);
            }*/
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
