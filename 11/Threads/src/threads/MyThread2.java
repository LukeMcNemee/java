/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author LukeMcNemee
 */
public class MyThread2 implements Runnable {

    private int number;

    private Shared shared;

    public MyThread2(int number, Shared shared) {
        this.number = number;
        this.shared = shared;
    }

    @Override
    public void run() {
        while (shared.getMax() < 50) {
            shared.increment();
            System.out.println(number + " : " 
                    + shared.getMax());
        }
    }
}
