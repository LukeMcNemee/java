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
public class Kalkulacka2 implements KalkulackaInterface {

    @Override
    public double soucet(double x, double y) {
        for (int i = 1; i < y; i++) {
            x++;
        }
        return x;
    }

    @Override
    public double rozdil(double x, double y) {
        while(x >= y){
            x = x - 1;
        }
        return x;
    }

    @Override
    public double soucin(double x, double y) {
        for (int i = 1; i < y; i++) {
            x *= x;
        }
        return x;
    }

    @Override
    public double podil(double x, double y) {
        if(y == 0) throw new IllegalArgumentException("division by zero");
        return (int) x/y;
    }
}
