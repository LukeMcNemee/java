package Common;

import Client.MessageType;
import Client.Message;
import Client.ChatClient;
import Server.ChatServer;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringEscapeUtils;

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
     */
    public static void main(String[] args) throws Exception 
    {
        Message m = new Message(MessageType.TEXT, "hug,o");
        System.out.println(m.getMessage());
        System.out.println(m.getAuthor());
       
        /*
        Object[] options = {"Start new", "Join"};
        int n = JOptionPane.showOptionDialog(null,
                "New server or join?","Question",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[1]);

        if (n == JOptionPane.NO_OPTION) {
            System.out.println("Join");
            ChatClient client = new ChatClient();
            client.start();
        } else if (n == JOptionPane.YES_OPTION) {
            System.out.println("Start new");
            ChatServer server = new ChatServer();
            server.start();
                    
        } else if (n == JOptionPane.CLOSED_OPTION) {
            System.out.println("closed");

        }
*/
    }

}
