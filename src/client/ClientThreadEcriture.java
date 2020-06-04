package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientThreadEcriture extends Thread {
    private Socket client;
    public ClientThreadEcriture(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        // thread de lecture
        try {
            PrintStream out = new PrintStream(client.getOutputStream(),true);
            Scanner sc = new Scanner(System.in);
            while (true){
                String msg = sc.nextLine();
                if(msg.equalsIgnoreCase("fin"))
                    break;
                out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
