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
public class MyThread3 implements Runnable {

    private int number;

    private Shared shared;

    public MyThread3(int number, Shared shared) {
        this.number = number;
        this.shared = shared;
    }

    @Override
    public void run() {
        while (shared.getMax() < 50) {
            synchronized (shared) {
                shared.increment();
                if(shared.getMax() <= 50){
                    System.out.println(number + " : " + shared.getMax());
                }
            }
        }
    }
}
