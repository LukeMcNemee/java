/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lukemcnemee
 */
public class Performer {
    private List<HelloListener> listeners = new ArrayList<>();

    public void addListener(HelloListener toAdd) {
        listeners.add(toAdd);
    }

    public void sayHello() {
        String message = "Hello";
        System.out.println(message);

        // Notify everybody that may be interested.
        for (HelloListener hl : listeners)
            hl.someoneSaidHello(message);
    }
}



