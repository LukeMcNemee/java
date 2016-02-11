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

    Socket clientSocket = null;
    DataOutputStream outToServer;
    BufferedReader inFromServer;
    String name;
    
    
    public void start() throws IOException {
        //TODO get user name
        name =  JOptionPane.showInputDialog(null, "What's your name?");
        
        System.out.println(name);
        String sentence;
        String modifiedSentence;
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        clientSocket = new Socket("localhost", 6789);
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
        inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("Connected");
        //outToServer.writeBytes("hello \n");
        //TODO hello message send
        
        outToServer.flush();
         System.out.println("msg send");
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        loop();
        System.out.println("Close");
        close();
    }
    
    public void close() throws IOException{
        clientSocket.close();
    }
    
    BufferedReader inFromUser; 

    public ChatClient() {
        inFromUser = new BufferedReader( new InputStreamReader(System.in));
    }
    
    private void loop(){
        while(true){
            try {
                if(inFromServer.ready()){
                    String sentence = inFromServer.readLine();
                    Message m = new Message(sentence);
                    if(m.getType() == MessageType.HELLO){
                        System.out.println("New user: " + m.getAuthor());
                    } else if (m.getType() == MessageType.HELLO){
                        //...
                    }
                    
                    //System.out.println(sentence);                    
                }                
                if(inFromUser.ready()){
                    String sentence = inFromUser.readLine();
                    //TODO send message format
                    outToServer.writeBytes(sentence);
                    outToServer.flush();
                }
            } catch (IOException ex) {
                System.err.println("IO error");
            }
        }
    }
}
