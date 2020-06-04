package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThreadLecture extends Thread {
    private Socket client;
    public ClientThreadLecture(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        // thread de lecture
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            while (true){
                String msg = in.readLine();
                if(msg == null){
                    break;
                }
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
