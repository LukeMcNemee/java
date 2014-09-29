/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaphore;

/**
 * Simple class to represent function of binary semaphore
 * @author LukeMcNemee
 */
public class Semaphore {
    
    private int state;    

    /**
     * constructor, initializes semaphore state to 0
     */
    public Semaphore() {
        
        state = 0;        
    }

    /**
     * switches state of semaphore
     */
    public void nextState() {
        if(state == 0){
            state = 1;
        } else {
            state = 0;        }
    }

    /**
     * 
     * @return state of semaphore
     */
    public int getState() {
        return state;
    }

    /**
     * returns string containing info about state of semaphore
     * @return string with info about state
     */
    @Override
    public String toString(){
        return "Semaphore has state " + state;
    }
    
    /**
     * prints info about state of semaphore to System.out
     */
    public void printInfo(){
        System.out.println(toString());
    }
}
