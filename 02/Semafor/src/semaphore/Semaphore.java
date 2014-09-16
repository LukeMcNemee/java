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
public class Semaphore {

    private int state;    

    public Semaphore() {
        
        state = 0;        
    }

    public void nextState() {
        if(state == 0){
            state = 1;
        } else {
            state = 0;        }
    }

    public int getState() {
        return state;
    }

    public String toString(){
        return "Semaphore has state " + state;
    }
    
    
    public void printInfo(){
        System.out.println(toString());
    }
}
