package client;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception
    {
        Socket client = null;

        try {
            // je suis joignable sur le port 5001
            client = new Socket("localhost",5001);

            new ClientThreadLecture(client).start();
            new ClientThreadEcriture(client).start();


        }catch (Exception e){
            if(client != null && !client.isClosed()){
                client.close();
            }
        }
    }
}
