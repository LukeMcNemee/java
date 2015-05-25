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
public class Kalkulacka3 implements KalkulackaInterface{

    @Override
    public double soucet(double x, double y) {
        double result = 0;
        result = x + 5;
        for (int i = 0; i <= y; i++){
            if(i>5){
                result++;
            }
        }
        return result;        
    }

    @Override
    public double rozdil(double x, double y) {
        return 2*x - y - x ;
    }

    @Override
    public double soucin(double x, double y) {
        double result = 0;
        for (int i = 0; i < y; i++){
            result += x;
        }
        return result;
    }

    @Override
    public double podil(double x, double y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
