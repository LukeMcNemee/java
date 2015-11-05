/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LukeMcNemee
 */
public class MyThread implements Runnable {

    private int number;

    public MyThread(int number) {
        this.number = number;
    }
    
    
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            for (double j = 0; j < 1000; j++) {
                double tmp = Math.pow(j, j);
            }
            System.out.println(number +" : " + i);
        }

    }

}
