package Common;

import Client.ChatClient;
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
            String addr = JOptionPane.showInputDialog(null, "What's server address?", "localhost");
            Chat chat = new Chat(addr);
            chat.setVisible(true);
            
        } else if (n == JOptionPane.YES_OPTION) {
            System.out.println("Start new");
            ChatServer server = new ChatServer();
            new Thread(server).start();

            
            Chat chat = new Chat("localhost");
            chat.setVisible(true);
                    
        } else if (n == JOptionPane.CLOSED_OPTION) {
            System.out.println("closed");

        }

    }

}
