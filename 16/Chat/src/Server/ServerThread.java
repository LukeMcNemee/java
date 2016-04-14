/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author lukemcnemee
 */
public class ServerThread implements Runnable {

    private final DataOutputStream outToClient;
    private final BufferedReader inFromClient;
    private final ChatServer parent;

    public ServerThread(DataOutputStream outToClient, BufferedReader inFromClient, ChatServer parent) {
        this.outToClient = outToClient;
        this.inFromClient = inFromClient;
        this.parent = parent;
    }

    @Override
    public void run() {
        System.out.println("Thread started");
        String clientSentence;
        while (true) {
            try {

                clientSentence = inFromClient.readLine();
                if (clientSentence == null) {
                    continue;
                }
                System.out.println("received from client: " + clientSentence);
                parent.receiveMsg(clientSentence);

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public void sendMsg(String msg) {
        try {
            outToClient.writeBytes(msg);
            outToClient.flush();
            System.out.println("Send to client: " + msg);
        } catch (IOException ex) {
            System.err.println("Exception " + ex.getMessage());
        }
    }

}
