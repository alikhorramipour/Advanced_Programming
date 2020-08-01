package game;

import game.bufferstrategy.GameState;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * this class represents the server
 * @author Ali Khorramipour
 */

public class Server {

    public Server(){
        try{
            ServerSocket serverSocket = new ServerSocket(666);
            Socket socket = serverSocket.accept();

            //ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            //Scanner inputStream = new Scanner(objectInputStream);
            //ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));


            ObjectInputStream toServer = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());


            /*while (!temp.isEmpty()){
                this.textTemp.append(temp);
            }
            this.text = this.textTemp.toString();
            */

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
