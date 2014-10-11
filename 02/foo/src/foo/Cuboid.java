/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foo;

/**
 *
 * @author LukeMcNemee
 */
public class Cuboid {
    private double a;
    private double b;
    private double c;

    public Cuboid(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    
    
    

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getArea(){
        return 2*a*b+2*a*c+2*b*c;
    }
    
    public double getVolume(){
        return a*b*c;
    }

    @Override
    public String toString() {
        return "Cuboid{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
    
    public void printInfo(){
        System.out.println(toString());
    }
            
}
