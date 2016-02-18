package Common;

import Client.ChatClient;
import Client.MessageType;
import Client.Message;
import Server.ChatServer;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lukemcnemee
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception 
    {
        
       
        
        Object[] options = {"Start new", "Join"};
        int n = JOptionPane.showOptionDialog(null,
                "New server or join?","Question",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);

        if (n == JOptionPane.NO_OPTION) {
            System.out.println("Join");
            ChatClient client = new ChatClient();
            String addr = JOptionPane.showInputDialog(null, "What's server address?", "localhost");
            client.start(addr);
        } else if (n == JOptionPane.YES_OPTION) {
            System.out.println("Start new");
            ChatServer server = new ChatServer();
            ChatClient client = new ChatClient();
            new Thread(server).start();
            client.start("localhost");
                    
        } else if (n == JOptionPane.CLOSED_OPTION) {
            System.out.println("closed");

        }

    }

}
