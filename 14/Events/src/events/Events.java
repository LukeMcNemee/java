/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author lukemcnemee
 */
public class Events {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Performer p = new Performer();
        Listener l = new Listener();
        Listener2 l2 = new Listener2();
        
        p.addListener(l);
        p.addListener(l2);
        
        p.sayHello();
    }
    
}
