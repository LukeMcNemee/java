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
public class CrossRoad {
    private Semaphore semaphoreUp;
    private Semaphore semaphoreDown;
    private Semaphore semaphoreLeft;
    private Semaphore semaphoreRight;

    public CrossRoad() {
        semaphoreUp = new Semaphore();
        semaphoreDown = new Semaphore();
        semaphoreLeft = new Semaphore();
        semaphoreRight = new Semaphore();
        semaphoreUp.nextState();
        semaphoreDown.nextState();
    }
    
    public void switchSignals(){
        semaphoreUp.nextState();
        semaphoreDown.nextState();
        semaphoreLeft.nextState();
        semaphoreRight.nextState();
    }
    
    public void printState(){
        System.out.println("   |"+ semaphoreUp.getState()+ "|" );
        System.out.println("---   ---");
        System.out.println(" " + semaphoreLeft.getState() + "     " + semaphoreRight.getState() + " ");
        System.out.println("---   ---");
        System.out.println("   |"+ semaphoreDown.getState()+ "|");
        System.out.println("################");
    }
    
    
}
