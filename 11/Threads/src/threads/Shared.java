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
public class Shared {
    private int max = 0;

    public int getMax() {
        return max;
    }
    
    public void increment(){
        max++;
    }
}
