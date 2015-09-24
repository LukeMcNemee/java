/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LukeMcNemee
 */
public class KalkulackaTest {
    
    KalkulackaInterface k = new Kalkulacka();
    
    @Test
    public void testSoucet() {
        assertEquals(40, k.soucet(20, 20),0);
    }
    
    @Test
    public void testSoucet2() {
        assertEquals(4.2, k.soucet(2.1, 2.1),0);
    }
    
    @Test
    public void testPodil() {
        assertEquals(4, k.podil(4,1),0);
        try{
            k.podil(4,0);
        } catch (Exception e){
            return;
        }
        fail();
    }
}
