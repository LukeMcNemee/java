/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

/**
 *
 * @author LukeMcNemee
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore();

        s1.printInfo();
        s1.nextState();
        s1.printInfo();
        s1.nextState();
        s1.printInfo();
    }

}
