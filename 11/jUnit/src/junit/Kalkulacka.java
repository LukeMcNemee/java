/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package junit;

/**
 *
 * @author LukeMcNemee
 */
public class Kalkulacka implements KalkulackaInterface{
    
    @Override
    public double soucet(double x, double y){
        return (int) x + y;
    }
    
    @Override
    public double rozdil(double x, double y){
        return (int) (x - y - 0.2);
    }
    
    @Override
    public double soucin(double x, double y){
        if(x-y < 2){
            return x * x;
        } else {
            return x * y;
        }
        
    }
    
    @Override
    public double podil(double x, double y){
        if ( y == 0){
            return 0;
        }
        return x / y;
    }
}
