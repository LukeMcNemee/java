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
public class Cuboid2 {
    private double a;
    private double b;
    private double c;

    public Cuboid2(double a, double b, double c) {
        this.a = Math.abs(a);
        if(a == 0){
            System.err.println("value A cannot be 0, 1 set as default");
            this.a = 1;
        }
        this.b = Math.abs(b);
        if(b == 0){
            System.err.println("value B cannot be 0, 1 set as default");
            this.b = 1;
        }
        this.c = Math.abs(c);
        if(c == 0){
            System.err.println("value C cannot be 0, 1 set as default");
            this.c = 1;
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if(a != 0){
            this.a = Math.abs(a);
        } else {
            System.err.println("value A cannot be 0");
        }  
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
       if(b != 0){
            this.b = Math.abs(b);
        } else {
            System.err.println("value B cannot be 0");
        }  
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        if(c != 0){
            this.c = Math.abs(c);
        } else {
            System.err.println("value C cannot be 0");
        }        
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
