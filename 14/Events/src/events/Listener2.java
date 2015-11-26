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
public class Listener2 implements HelloListener{

    @Override
    public void someoneSaidHello(String s) {
        System.err.println(s);
    }
    
}
