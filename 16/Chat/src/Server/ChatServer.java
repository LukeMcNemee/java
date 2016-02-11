/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lukemcnemee
 */
public class ChatServer {

    private List<ServerThread> threads;
    private List<String> conversation;
    private int capacity;

    public ChatServer() {
        threads = new ArrayList<>();
        conversation = new ArrayList<>();
        capacity = 100;
    }

    public void start() throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(
                    connectionSocket.getOutputStream());
            ServerThread t = new ServerThread(outToClient, inFromClient, this);
            threads.add(t);
            new Thread(t).start();
            System.out.println("New client connected");
        }
    }

    public void receiveMsg(String msg) {
        System.out.println("Received: " + msg);
        for (ServerThread thread : threads) {
            thread.sendMsg(msg);
        }
        conversation.add(msg);
        if (conversation.size() >= capacity) {
            conversation.remove(0);
        }
        System.out.println(msg);
    }
}
