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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        example3();
    }
    
    public static void example1(){
        MyThread t1 = new MyThread(10);
        MyThread t2 = new MyThread(20);
        
        new Thread(t2).start();
        new Thread(t1).start();
    }
    
    
    
    
    public static void example2(){
        Shared s1 = new Shared();
        
        MyThread2 t1 = new MyThread2(1, s1);
        MyThread2 t2 = new MyThread2(2, s1);
        MyThread2 t3 = new MyThread2(3, s1);
        
        new Thread(t3).start();
        new Thread(t2).start();
        new Thread(t1).start();
    }
    
    public static void example3(){
        Shared s1 = new Shared();
        
        MyThread3 t1 = new MyThread3(1, s1);
        MyThread3 t2 = new MyThread3(2, s1);
        MyThread3 t3 = new MyThread3(3, s1);
        
        new Thread(t3).start();
        new Thread(t2).start();
        new Thread(t1).start();
    }
    
}
