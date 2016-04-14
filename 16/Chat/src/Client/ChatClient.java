/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lukemcnemee
 */
public class ChatClient {

    private Socket clientSocket = null;
    private DataOutputStream outToServer;
    private BufferedReader inFromServer;
    private String name;

    public void start(String address) throws IOException {
        name = JOptionPane.showInputDialog(null, "What's your name?");
        System.out.println("username:" + name);

        String textFromServer;

        clientSocket = new Socket(address, 6789);
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
        inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("Connected");

        outToServer.writeBytes(new Message(MessageType.HELLO, name).getMessage());

        outToServer.flush();
        loop();
        close();
    }

    public void close() throws IOException {
        clientSocket.close();
    }

    BufferedReader inFromUser;

    public ChatClient() {
        inFromUser = new BufferedReader(new InputStreamReader(System.in));
    }

    private void loop() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                {
                    String sentence = inFromServer.readLine();
                    if (sentence == null) {
                        continue;
                    }
                    Message m = new Message(sentence);
                    System.out.println("msg received " + m.getMessage());
                    switch (m.getType()) {
                        case HELLO:
                            System.out.println(m.getAuthor() + " connected");
                            break;
                        case LEAVE:
                            System.out.println(m.getAuthor() + " left");

                            break;
                        case TEXT:
                            System.out.println(m.getAuthor() + ": " + m.getText());
                            break;
                        case WRITING:
                            System.out.println(m.getAuthor() + " is writing ...");

                        default:
                            System.out.println("Message not readable");
                    }

                    //System.out.println(sentence);                    
                }
                if (inFromUser.ready()) {
                    String sentence = inFromUser.readLine();
                    if (sentence.equals(":quit")) {
                        outToServer.writeBytes(new Message(MessageType.LEAVE, name).getMessage());
                        return;
                    }
                    Message m = new Message(MessageType.TEXT, name, sentence);
                    outToServer.writeBytes(m.getMessage());
                    outToServer.flush();

                    outToServer.notify();
                    System.out.println("msg send " + m.getMessage());
                }
            } catch (IOException ex) {
                System.err.println("IO error");
            }
        }
    }
}
